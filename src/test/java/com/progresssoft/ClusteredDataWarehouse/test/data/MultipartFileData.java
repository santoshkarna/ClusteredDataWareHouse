package com.progresssoft.ClusteredDataWarehouse.test.data;

import org.springframework.web.multipart.MultipartFile;

import com.progresssoft.ClusteredDataWarehouse.validation.FileFormat;

public class MultipartFileData {

	@FileFormat
	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
