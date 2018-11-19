package com.progresssoft.ClusteredDataWarehouse.service;

import com.progresssoft.ClusteredDataWarehouse.dto.SummaryReportDTO;

public interface SummaryReportService {

	SummaryReportDTO findBySourceFileName( String sourceFileName );
}
