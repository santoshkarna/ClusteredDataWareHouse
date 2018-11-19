package com.progresssoft.ClusteredDataWarehouse.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.progresssoft.ClusteredDataWarehouse.dto.DealsDTO;
import com.progresssoft.ClusteredDataWarehouse.exception.FileImportException;
import com.progresssoft.ClusteredDataWarehouse.model.AccumulativeCurrencyDealCount;
import com.progresssoft.ClusteredDataWarehouse.model.InvalidDeal;
import com.progresssoft.ClusteredDataWarehouse.model.UploadSummaryReport;
import com.progresssoft.ClusteredDataWarehouse.model.ValidDeal;
import com.progresssoft.ClusteredDataWarehouse.repository.AccumulativeCurrencyDealCountRepository;
import com.progresssoft.ClusteredDataWarehouse.repository.InvalidDealRepositoryBatchInsert;
import com.progresssoft.ClusteredDataWarehouse.repository.UploadSummaryReportRepository;
import com.progresssoft.ClusteredDataWarehouse.repository.ValidDealRepositoryBatchInsert;
import com.progresssoft.ClusteredDataWarehouse.validator.DataValidator;

@Service("fileImportService")
public class FileImportServiceImpl implements FileImportService{



	@Autowired
	ValidDealRepositoryBatchInsert validDealRepositoryBatchInsert;

	@Autowired
	InvalidDealRepositoryBatchInsert invalidDealRepositoryBatchInsert;

	@Autowired
	AccumulativeCurrencyDealCountRepository accumulativeCurrencyDealCountRepository;
	
	@Autowired
	UploadSummaryReportRepository uploadSummaryReportRepository;
	
	
	@Autowired
	TransactionService transactionService;

	private static final Logger LOGGER = LoggerFactory.getLogger(FileImportServiceImpl.class);


	@Override
	@Transactional
	public void fileUpload(MultipartFile multipartFile, UploadSummaryReport summaryReportModel) {

		LOGGER.info("Importing File Name: {}", multipartFile.getOriginalFilename());
		
		BufferedReader br 	=	null;
		try{
			String fileName		 = multipartFile.getOriginalFilename();
			
			final long startTime = System.currentTimeMillis();

			InputStream inputFS = multipartFile.getInputStream();

			br = new BufferedReader(new InputStreamReader(inputFS));
			List<AccumulativeCurrencyDealCount> accumulativeCurrencyDealList = accumulativeCurrencyDealCountRepository.findAll();

			Map<String, Long> accumulativeCurrencyDealMap = accumulativeCurrencyDealList.stream().collect(
					Collectors.toMap(AccumulativeCurrencyDealCount::getCurrencyCode, AccumulativeCurrencyDealCount::getDealCount));

			CSVParser csvParser = new CSVParser(br, CSVFormat.RFC4180.withHeader());
			List<ValidDeal> validDeals 	=	 new LinkedList<ValidDeal>();
			List<InvalidDeal> invalidDeals	=	 new LinkedList<InvalidDeal>();
			for (CSVRecord record : csvParser) 
			{ 
				DealsDTO dealsDTO =	new DealsDTO();
				dealsDTO.setDealUniqueId(record.get("DEAL_ID"));
				dealsDTO.setFromCurrencyCode(record.get("FROM_CURRENCY"));
				dealsDTO.setToCurrencyCode(record.get("TO_CURRENCY"));
				dealsDTO.setDealTimestamp(record.get("TIMESTAMP"));
				dealsDTO.setDealAmount(record.get("AMOUNT"));

				if( DataValidator.isvalid(dealsDTO) ){

					ValidDeal validDeal = ValidDeal.copyProperties(dealsDTO);
					validDeal.setSourceFileName(fileName);
					accumulativeCurrencyDealMap.merge(validDeal.getFromCurrencyCode(), 1L, Long::sum);
					validDeals.add(validDeal);
				}else{
					InvalidDeal invalidDeal = InvalidDeal.copyProperties(dealsDTO);
					invalidDeal.setSourceFileName(fileName);
					invalidDeals.add(invalidDeal);
				}

			}

			accumulateCurrencyCodeDealCount(accumulativeCurrencyDealList,accumulativeCurrencyDealMap);
			
			
			transactionService.saveAllValidDeals(validDeals);
			transactionService.saveAllInvalidDeals(invalidDeals);

			final long endTime = System.currentTimeMillis();

			long processingTime = (endTime - startTime) / 1000;

			summaryReportModel.setValidDealsImportedCount(validDeals.size());
			summaryReportModel.setInvalidDealsImportedCount(invalidDeals.size());
			summaryReportModel.setProcessDuration(processingTime);
			summaryReportModel.setImportDate(new Date(System.currentTimeMillis()));
			
			transactionService.saveAllAccumulativeCurrencyCodeCount(accumulativeCurrencyDealList);
			transactionService.saveAllUploadSummaryReport(summaryReportModel);
			
			csvParser.close();
		}catch(Exception e){
			throw new FileImportException("Error occured while Importing file.", e);
		} finally {
            try {
            	br.close();
            } catch (IOException e) {
                LOGGER.error("Error closing the Buffered Reader.");
            }
        }

	}


	private void accumulateCurrencyCodeDealCount(List<AccumulativeCurrencyDealCount> accumulativeCurrencyDealList,
			Map<String, Long> accumulativeCurrencyDealMap) {
		
		accumulativeCurrencyDealList.clear();
		for ( Entry<String,Long> entrySet : accumulativeCurrencyDealMap.entrySet() ){
			accumulativeCurrencyDealList.add(new AccumulativeCurrencyDealCount(entrySet.getKey(), entrySet.getValue()));
		}
	}


	@Override
	@Transactional
	public boolean isFileAlreadyImported(String originalFilename) {
		
		UploadSummaryReport uploadSummaryReport = uploadSummaryReportRepository.findBySourceFileName(originalFilename);
		if( uploadSummaryReport != null ){
			return true;
		}
		return false;
	}

}
