package com.progresssoft.ClusteredDataWarehouse.repository;

import java.util.List;

import com.progresssoft.ClusteredDataWarehouse.model.InvalidDeal;

public interface InvalidDealRepositoryBatchInsert {

	void batchInsert(List<InvalidDeal> validDeal);
}
