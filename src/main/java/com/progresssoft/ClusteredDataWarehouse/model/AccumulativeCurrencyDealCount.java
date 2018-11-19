package com.progresssoft.ClusteredDataWarehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accumulative_currency_deal_count")
public class AccumulativeCurrencyDealCount {

	@Id
	@Column(name = "curreny_code", unique = true, nullable = false)
	private String currencyCode;

	@Column(name = "deal_count")
	private long dealCount;
	
	public AccumulativeCurrencyDealCount(){
		
	}
	
	public AccumulativeCurrencyDealCount( String currencyCode, long dealCount){
		this.currencyCode = currencyCode;
		this.dealCount = dealCount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public long getDealCount() {
		return dealCount;
	}

	public void setDealCount(long dealCount) {
		this.dealCount = dealCount;
	}
}
