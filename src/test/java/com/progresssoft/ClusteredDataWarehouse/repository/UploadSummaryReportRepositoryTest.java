package com.progresssoft.ClusteredDataWarehouse.repository;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.progresssoft.ClusteredDataWarehouse.model.UploadSummaryReport;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class UploadSummaryReportRepositoryTest {
	
	@Autowired
	UploadSummaryReportRepository uploadSummaryReportRepository;
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@Test
	public void testFindSourceFileName(){
		
//		UploadSummaryReport uploadSummaryReport = new UploadSummaryReport();
//		
//		uploadSummaryReport.setSourceFileName("test-data.csv");
//		uploadSummaryReport.setImportDate(new Date());
//		uploadSummaryReport.setInvalidDealsImportedCount(1);
//		uploadSummaryReport.setValidDealsImportedCount(1);
//		uploadSummaryReport.setProcessDuration(2.0);
//		
//		testEntityManager.persistAndFlush(uploadSummaryReport);
//		
//		UploadSummaryReport uploadSummaryReportTest = uploadSummaryReportRepository.findBySourceFileName("test-data.csv");
//		assertThat(uploadSummaryReportTest, notNullValue());
	}
	

}
