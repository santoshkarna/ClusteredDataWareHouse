package com.progresssoft.ClusteredDataWarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progresssoft.ClusteredDataWarehouse.model.ValidDeal;

@Repository
public interface ValidDealRepository extends JpaRepository<ValidDeal, String> {

}
