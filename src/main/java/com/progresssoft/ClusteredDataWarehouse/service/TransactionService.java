package com.progresssoft.ClusteredDataWarehouse.service;

import java.util.List;

import com.progresssoft.ClusteredDataWarehouse.model.AccumulativeCurrencyDealCount;
import com.progresssoft.ClusteredDataWarehouse.model.InvalidDeal;
import com.progresssoft.ClusteredDataWarehouse.model.UploadSummaryReport;
import com.progresssoft.ClusteredDataWarehouse.model.ValidDeal;

public interface TransactionService {

	public void saveAllValidDeals(List<ValidDeal> validDeals);

	public void saveAllInvalidDeals(List<InvalidDeal> invalidDeals);

	public void saveAllAccumulativeCurrencyCodeCount(List<AccumulativeCurrencyDealCount> accumulativeCurrencyCodeCount);

	public void saveAllUploadSummaryReport(UploadSummaryReport summaryReportModel);
}
