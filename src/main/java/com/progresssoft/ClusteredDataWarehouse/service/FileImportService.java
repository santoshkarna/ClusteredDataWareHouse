package com.progresssoft.ClusteredDataWarehouse.service;

import org.springframework.web.multipart.MultipartFile;

import com.progresssoft.ClusteredDataWarehouse.model.UploadSummaryReport;

public interface FileImportService {
	void fileUpload(MultipartFile multipartFile, UploadSummaryReport summaryReportModel);

	boolean isFileAlreadyImported(String originalFilename);
}
