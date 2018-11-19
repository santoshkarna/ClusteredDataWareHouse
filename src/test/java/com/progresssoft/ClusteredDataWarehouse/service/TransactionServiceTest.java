package com.progresssoft.ClusteredDataWarehouse.service;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.progresssoft.ClusteredDataWarehouse.model.AccumulativeCurrencyDealCount;
import com.progresssoft.ClusteredDataWarehouse.model.InvalidDeal;
import com.progresssoft.ClusteredDataWarehouse.model.UploadSummaryReport;
import com.progresssoft.ClusteredDataWarehouse.model.ValidDeal;
import com.progresssoft.ClusteredDataWarehouse.repository.AccumulativeCurrencyDealCountRepository;
import com.progresssoft.ClusteredDataWarehouse.repository.InvalidDealRepositoryBatchInsert;
import com.progresssoft.ClusteredDataWarehouse.repository.UploadSummaryReportRepository;
import com.progresssoft.ClusteredDataWarehouse.repository.ValidDealRepositoryBatchInsert;
import com.progresssoft.ClusteredDataWarehouse.service.TransactionService;
import com.progresssoft.ClusteredDataWarehouse.service.TransactionServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {


	@Mock
	ValidDealRepositoryBatchInsert validDealRepositoryBatchInsert;

	@Mock
	InvalidDealRepositoryBatchInsert invalidDealRepositoryBatchInsert;

	@Mock
	AccumulativeCurrencyDealCountRepository accumulativeCurrencyDealCountRepository;

	@Mock
	UploadSummaryReportRepository uploadSummaryReportRepository;

	@InjectMocks
	private TransactionService transactionService = new TransactionServiceImpl();


	@Test
	public void testSaveAllValidDeals () {

		List<ValidDeal> validDeals = new ArrayList<ValidDeal>();

		transactionService.saveAllValidDeals(validDeals);

		verify(validDealRepositoryBatchInsert, atLeastOnce()).batchInsert(eq(validDeals));

	}
	
	@Test
	public void testSaveAllInvalidDeals () {

		List<InvalidDeal> invalidDeals = new ArrayList<InvalidDeal>();

		transactionService.saveAllInvalidDeals(invalidDeals);

		verify(invalidDealRepositoryBatchInsert, atLeastOnce()).batchInsert(eq(invalidDeals));

	}
	
	
	@Test
	public void testSaveAllAccumulativeCurrencyCodeCount () {

		List<AccumulativeCurrencyDealCount> accumulativeCurrencyCodeDealCountList = new ArrayList<AccumulativeCurrencyDealCount>();

		transactionService.saveAllAccumulativeCurrencyCodeCount(accumulativeCurrencyCodeDealCountList);

		verify(accumulativeCurrencyDealCountRepository, atLeastOnce()).save(eq(accumulativeCurrencyCodeDealCountList));

	}
	
	@Test
	public void testSaveAllUploadSummaryReport () {

		UploadSummaryReport uploadSummaryReport = new UploadSummaryReport();

		transactionService.saveAllUploadSummaryReport(uploadSummaryReport);

		verify(uploadSummaryReportRepository, atLeastOnce()).save(eq(uploadSummaryReport));

	}


}
