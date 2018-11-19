package com.progresssoft.ClusteredDataWarehouse.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.progresssoft.ClusteredDataWarehouse.dto.SummaryReportDTO;
import com.progresssoft.ClusteredDataWarehouse.service.SummaryReportService;

@Controller
public class UploadSummaryReportController {
	
	@Autowired
	SummaryReportService summaryReportService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadSummaryReportController.class);
	
	
	@RequestMapping(method=RequestMethod.GET, value="/search/summary")
	public ResponseEntity<Object> getSummaryReport(@RequestParam("filename") String fileName ) {

		if( StringUtils.isBlank(fileName) ){
			return ResponseEntity.badRequest().body("Please provide File name");
		}
		
		LOGGER.info("Searching for uploaded file: {}", fileName);
		
		SummaryReportDTO summaryReportDTO 	=	summaryReportService.findBySourceFileName(fileName);
		
		if( null == summaryReportDTO ){
			return ResponseEntity.badRequest().body("File never imported");
		}
		
		return ResponseEntity.ok(summaryReportDTO);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/search")
    public String getPage() {
        return "upload-summary";
    }

}