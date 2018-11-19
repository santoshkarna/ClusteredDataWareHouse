package com.progresssoft.ClusteredDataWarehouse.model;

import org.springframework.web.multipart.MultipartFile;

import com.progresssoft.ClusteredDataWarehouse.validation.FileFormat;
import com.progresssoft.ClusteredDataWarehouse.validation.NotEmptyFile;

public class UploadFileModel {
	@FileFormat
	@NotEmptyFile
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
