package com.progresssoft.ClusteredDataWarehouse.validations;

import org.junit.Test;

import com.progresssoft.ClusteredDataWarehouse.dto.DealsDTO;
import com.progresssoft.ClusteredDataWarehouse.validator.DataValidator;

import static org.junit.Assert.assertEquals;

public class DataValidatorTest {

	@Test
	public void testBlankFromCurrencyCode() {

		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setDealUniqueId("6464e5b9-b545-48a1-84be-46c8f7fd3d31");
		dealsDTO.setFromCurrencyCode("");
		dealsDTO.setToCurrencyCode("AED");
		dealsDTO.setDealTimestamp("2017-11-03 01:57:59");
		dealsDTO.setDealAmount("1");

		assertEquals(false, DataValidator.isvalid(dealsDTO));
	}

	@Test
	public void testBlankDealUniqueId() {

		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setDealUniqueId("");
		dealsDTO.setFromCurrencyCode("UYU");
		dealsDTO.setToCurrencyCode("AED");
		dealsDTO.setDealTimestamp("2017-11-03 01:57:59");
		dealsDTO.setDealAmount("1");

		assertEquals(false, DataValidator.isvalid(dealsDTO));
	}

	@Test
	public void testBlankToCurrencyCode() {

		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setDealUniqueId("6464e5b9-b545-48a1-84be-46c8f7fd3d31");
		dealsDTO.setFromCurrencyCode("UYU");
		dealsDTO.setToCurrencyCode("");
		dealsDTO.setDealTimestamp("2017-11-03 01:57:59");
		dealsDTO.setDealAmount("1");

		assertEquals(false, DataValidator.isvalid(dealsDTO));
	}

	@Test
	public void testBlankDealTimestamp() {

		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setDealUniqueId("6464e5b9-b545-48a1-84be-46c8f7fd3d31");
		dealsDTO.setFromCurrencyCode("UYU");
		dealsDTO.setToCurrencyCode("AED");
		dealsDTO.setDealTimestamp("");
		dealsDTO.setDealAmount("1");

		assertEquals(false, DataValidator.isvalid(dealsDTO));
	}

	@Test
	public void testBlankDealAmount() {

		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setDealUniqueId("6464e5b9-b545-48a1-84be-46c8f7fd3d31");
		dealsDTO.setFromCurrencyCode("UYU");
		dealsDTO.setToCurrencyCode("AED");
		dealsDTO.setDealTimestamp("2017-11-03 01:57:59");
		dealsDTO.setDealAmount("");

		assertEquals(false, DataValidator.isvalid(dealsDTO));
	}

	@Test
	public void testInvalidFromCurrenyCode() {

		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setDealUniqueId("6464e5b9-b545-48a1-84be-46c8f7fd3d31");
		dealsDTO.setFromCurrencyCode("INVALID");
		dealsDTO.setToCurrencyCode("AED");
		dealsDTO.setDealTimestamp("2017-11-03 01:57:59");
		dealsDTO.setDealAmount("1");

		assertEquals(false, DataValidator.isvalid(dealsDTO));
	}

	@Test
	public void testInvalidToCurrenyCode() {

		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setDealUniqueId("6464e5b9-b545-48a1-84be-46c8f7fd3d31");
		dealsDTO.setFromCurrencyCode("AED");
		dealsDTO.setToCurrencyCode("INVALID");
		dealsDTO.setDealTimestamp("2017-11-03 01:57:59");
		dealsDTO.setDealAmount("1");

		assertEquals(false, DataValidator.isvalid(dealsDTO));
	}

	@Test
	public void testInvalidDealTimestamp() {

		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setDealUniqueId("6464e5b9-b545-48a1-84be-46c8f7fd3d31");
		dealsDTO.setFromCurrencyCode("AED");
		dealsDTO.setToCurrencyCode("INVALID");
		dealsDTO.setDealTimestamp("2017-11-03 01:57 PM");
		dealsDTO.setDealAmount("1");

		assertEquals(false, DataValidator.isvalid(dealsDTO));
	}

	@Test
	public void testInvalidDealAmount() {

		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setDealUniqueId("6464e5b9-b545-48a1-84be-46c8f7fd3d31");
		dealsDTO.setFromCurrencyCode("AED");
		dealsDTO.setToCurrencyCode("INVALID");
		dealsDTO.setDealTimestamp("2017-11-03 01:57:59");
		dealsDTO.setDealAmount("INVALID");

		assertEquals(false, DataValidator.isvalid(dealsDTO));
	}

}
