package com.progresssoft.ClusteredDataWarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progresssoft.ClusteredDataWarehouse.model.UploadSummaryReport;

@Repository
public interface UploadSummaryReportRepository extends JpaRepository<UploadSummaryReport, String> {
	
	UploadSummaryReport findBySourceFileName( String sourceFileName );

}
