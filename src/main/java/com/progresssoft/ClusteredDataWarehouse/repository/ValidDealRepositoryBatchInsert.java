package com.progresssoft.ClusteredDataWarehouse.repository;

import java.util.List;

import com.progresssoft.ClusteredDataWarehouse.model.ValidDeal;

public interface ValidDealRepositoryBatchInsert {

	void batchInsert(List<ValidDeal> validDeal);
}
