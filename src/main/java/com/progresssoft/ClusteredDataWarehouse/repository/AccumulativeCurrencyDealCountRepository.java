package com.progresssoft.ClusteredDataWarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progresssoft.ClusteredDataWarehouse.model.AccumulativeCurrencyDealCount;

@Repository
public interface AccumulativeCurrencyDealCountRepository extends JpaRepository<AccumulativeCurrencyDealCount, String> {

}