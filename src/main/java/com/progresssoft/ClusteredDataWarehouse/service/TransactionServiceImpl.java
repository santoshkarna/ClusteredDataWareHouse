package com.progresssoft.ClusteredDataWarehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresssoft.ClusteredDataWarehouse.model.AccumulativeCurrencyDealCount;
import com.progresssoft.ClusteredDataWarehouse.model.InvalidDeal;
import com.progresssoft.ClusteredDataWarehouse.model.UploadSummaryReport;
import com.progresssoft.ClusteredDataWarehouse.model.ValidDeal;
import com.progresssoft.ClusteredDataWarehouse.repository.AccumulativeCurrencyDealCountRepository;
import com.progresssoft.ClusteredDataWarehouse.repository.InvalidDealRepositoryBatchInsert;
import com.progresssoft.ClusteredDataWarehouse.repository.UploadSummaryReportRepository;
import com.progresssoft.ClusteredDataWarehouse.repository.ValidDealRepositoryBatchInsert;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	ValidDealRepositoryBatchInsert validDealRepositoryBatchInsert;

	@Autowired
	InvalidDealRepositoryBatchInsert invalidDealRepositoryBatchInsert;

	@Autowired
	AccumulativeCurrencyDealCountRepository accumulativeCurrencyDealCountRepository;

	@Autowired
	UploadSummaryReportRepository uploadSummaryReportRepository;

	@Override
	public void saveAllValidDeals(List<ValidDeal> validDeals) {
		validDealRepositoryBatchInsert.batchInsert(validDeals);
	}

	@Override
	public void saveAllInvalidDeals(List<InvalidDeal> invalidDeals) {
		invalidDealRepositoryBatchInsert.batchInsert(invalidDeals);

	}

	@Override
	public void saveAllAccumulativeCurrencyCodeCount(List<AccumulativeCurrencyDealCount> accumulativeCurrencyDealList) {
		accumulativeCurrencyDealCountRepository.save(accumulativeCurrencyDealList);

	}

	@Override
	public void saveAllUploadSummaryReport(UploadSummaryReport summaryReportModel) {
		uploadSummaryReportRepository.save(summaryReportModel);
	}

}