package com.progresssoft.ClusteredDataWarehouse.validations;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.progresssoft.ClusteredDataWarehouse.test.data.MultipartFileEmptyData;
import com.progresssoft.ClusteredDataWarehouse.validation.NotEmptyFile;

public class NotEmptyFileValidatorTest {

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@Test
    public void testInvalidFileFormat() {

		MockMultipartFile multipartFileData = new MockMultipartFile();
        multipartFileData.setMultipartFile(new MultipartFileEmptyData("filename.csv", 0));

        Set<ConstraintViolation<MockMultipartFile>> constraintViolations = validator.validate(multipartFileData);

//        assertThat(constraintViolations, hasSize(1));
    }
	
	
	@Test
    public void testValidFileFormat() {

		MockMultipartFile multipartFileData = new MockMultipartFile();
        multipartFileData.setMultipartFile(new MultipartFileEmptyData("filename.csv", 1));

        Set<ConstraintViolation<MockMultipartFile>> constraintViolations = validator.validate(multipartFileData);

        assertThat(constraintViolations, hasSize(0));
    }
	
	
	private class MockMultipartFile{
		
		@NotEmptyFile
		MultipartFile multipartFile;

		public MultipartFile getMultipartFile() {
			return multipartFile;
		}

		public void setMultipartFile(MultipartFile multipartFile) {
			this.multipartFile = multipartFile;
		}
		
		
	}
	
}
