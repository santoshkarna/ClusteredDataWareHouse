package com.progresssoft.ClusteredDataWarehouse.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.progresssoft.ClusteredDataWarehouse.dto.SummaryReportDTO;
import com.progresssoft.ClusteredDataWarehouse.model.UploadSummaryReport;
import com.progresssoft.ClusteredDataWarehouse.repository.UploadSummaryReportRepository;
import com.progresssoft.ClusteredDataWarehouse.service.SummaryReportService;
import com.progresssoft.ClusteredDataWarehouse.service.SummaryReportServiceImpl;

import static org.mockito.Matchers.eq;

import static org.mockito.Mockito.when;

import java.util.Date;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SummaryReportServiceTest {
	
	@Mock
	UploadSummaryReportRepository uploadSummaryReportRepository;
	
	
	@InjectMocks
	SummaryReportService summaryReportService = new SummaryReportServiceImpl();
	
	
	@Test
	public void testFindNullFileName(){

        String fileName = "filename.csv";

        UploadSummaryReport summaryReport = new UploadSummaryReport();
        summaryReport.setSourceFileName(fileName);
        summaryReport.setImportDate(new Date());
        summaryReport.setInvalidDealsImportedCount(1);
        summaryReport.setValidDealsImportedCount(2);
        summaryReport.setProcessDuration(2.0);
        
        when(uploadSummaryReportRepository.findBySourceFileName(eq(fileName))).thenReturn(summaryReport);

        SummaryReportDTO foundEntity = summaryReportService.findBySourceFileName(fileName);

        verify(uploadSummaryReportRepository, atLeastOnce()).findBySourceFileName(eq(fileName));
        assertEquals(foundEntity.getSourceFileName(), summaryReport.getSourceFileName());
	}
	
	@Test
	public void testFindBySourceFileName(){

        String fileName = "filename.csv";

        UploadSummaryReport summaryReport = new UploadSummaryReport();
        summaryReport.setSourceFileName(fileName);
        summaryReport.setImportDate(new Date());
        summaryReport.setInvalidDealsImportedCount(1);
        summaryReport.setValidDealsImportedCount(2);
        summaryReport.setProcessDuration(2.0);
        
        when(uploadSummaryReportRepository.save(summaryReport)).thenReturn(summaryReport);

        when(uploadSummaryReportRepository.findBySourceFileName(eq(fileName))).thenReturn(summaryReport);

        SummaryReportDTO foundEntity = summaryReportService.findBySourceFileName(fileName);

        verify(uploadSummaryReportRepository, atLeastOnce()).findBySourceFileName(eq(fileName));
        assertEquals(foundEntity.getSourceFileName(), summaryReport.getSourceFileName());
	}
}
