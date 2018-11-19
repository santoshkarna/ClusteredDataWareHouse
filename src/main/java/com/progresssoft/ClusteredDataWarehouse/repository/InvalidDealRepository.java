package com.progresssoft.ClusteredDataWarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progresssoft.ClusteredDataWarehouse.model.InvalidDeal;

@Repository
public interface InvalidDealRepository extends JpaRepository<InvalidDeal, String> {

}
