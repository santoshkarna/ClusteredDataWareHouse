package com.progresssoft.ClusteredDataWarehouse.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import com.progresssoft.ClusteredDataWarehouse.validation.NotEmptyFile;

public class NotEmptyFileVaidator implements ConstraintValidator<NotEmptyFile, MultipartFile> {

	@Override
	public void initialize(NotEmptyFile notEmptyFile) {

	}

	@Override
	public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext validatorContext) {

		return !multipartFile.isEmpty();
	}

}