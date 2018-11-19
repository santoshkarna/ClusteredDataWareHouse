package com.progresssoft.ClusteredDataWarehouse.validator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;

import com.progresssoft.ClusteredDataWarehouse.dto.DealsDTO;
import com.progresssoft.ClusteredDataWarehouse.model.ISOCurrencyCode;

public class DataValidator {
	
	
	private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(TIMESTAMP_FORMAT);
	
	public static boolean isvalid(DealsDTO dealsDTO){
		
		if( StringUtils.isBlank(dealsDTO.getDealUniqueId()) 
				|| StringUtils.isBlank(dealsDTO.getFromCurrencyCode()) 
				|| StringUtils.isBlank(dealsDTO.getToCurrencyCode()) 
				|| StringUtils.isBlank(dealsDTO.getDealTimestamp())
				|| StringUtils.isBlank(dealsDTO.getDealAmount()) ){
			return false;
		}
		
		
		if( !ISOCurrencyCode.CURRENCY_CODES.contains(dealsDTO.getFromCurrencyCode()) 
				|| !ISOCurrencyCode.CURRENCY_CODES.contains(dealsDTO.getToCurrencyCode()) ){
			return false;
		}
		
		try {
            LocalDateTime.parse(dealsDTO.getDealTimestamp(), TIMESTAMP_FORMATTER);
            new BigDecimal(dealsDTO.getDealAmount());
        } catch (DateTimeParseException | NumberFormatException ex) {
            return false;
        }
		
		return true;
		
	}


}