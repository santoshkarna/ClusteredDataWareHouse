package com.progresssoft.ClusteredDataWarehouse.dto;

public class DealsDTO {

	private String dealUniqueId;

	private String sourceFileName;

	private String fromCurrencyCode;

	private String toCurrencyCode;

	private String dealTimestamp;

	private String dealAmount;

	public String getDealUniqueId() {
		return dealUniqueId;
	}

	public void setDealUniqueId(String dealUniqueId) {
		this.dealUniqueId = dealUniqueId;
	}

	public String getSourceFileName() {
		return sourceFileName;
	}

	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}

	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}

	public String getToCurrencyCode() {
		return toCurrencyCode;
	}

	public void setToCurrencyCode(String toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}

	public String getDealTimestamp() {
		return dealTimestamp;
	}

	public void setDealTimestamp(String dealTimestamp) {
		this.dealTimestamp = dealTimestamp;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

}
