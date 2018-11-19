package com.progresssoft.ClusteredDataWarehouse.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import com.progresssoft.ClusteredDataWarehouse.validation.FileFormat;

public class FileFormatValidator implements ConstraintValidator<FileFormat, MultipartFile> {

	@Override
	public void initialize(FileFormat fileFormat) {

	}

	@Override
	public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext validatorContext) {
//		return multipartFile.getContentType().equals("text/csv");
		return multipartFile.getContentType().equals("application/vnd.ms-excel");
	}

}
