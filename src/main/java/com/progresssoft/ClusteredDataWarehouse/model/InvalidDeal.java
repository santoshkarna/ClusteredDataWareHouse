package com.progresssoft.ClusteredDataWarehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.progresssoft.ClusteredDataWarehouse.dto.DealsDTO;

@Entity
@Table(name = "invalid_deal")
public class InvalidDeal extends AbstractEntity {
	
	@Column(name = "deal_unique_id", nullable = true)
    private String dealUniqueId;
	
	@Column(name = "source_file_name")
    private String sourceFileName;

    @Column(name = "from_currency_code", nullable = true)
    private String fromCurrencyCode;

    @Column(name = "to_currency_code", nullable = true)
    private String toCurrencyCode;

    @Column(name = "deal_timestamp", nullable = true)
    private String dealTimestamp;

    @Column(name = "deal_amount", nullable = true)
    private String DealAmount;

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
		return DealAmount;
	}

	public void setDealAmount(String dealAmount) {
		DealAmount = dealAmount;
	}
    
    public InvalidDeal(){
    	
    }
    
    public static InvalidDeal copyProperties(DealsDTO dealsDTO) {

        InvalidDeal invalidDeal = new InvalidDeal();
        invalidDeal.setDealUniqueId(StringUtils.isBlank(dealsDTO.getDealUniqueId()) ? StringUtils.EMPTY : dealsDTO.getDealUniqueId() );
        invalidDeal.setFromCurrencyCode(StringUtils.isBlank(dealsDTO.getFromCurrencyCode()) ? StringUtils.EMPTY : dealsDTO.getFromCurrencyCode());
        invalidDeal.setToCurrencyCode(StringUtils.isBlank(dealsDTO.getToCurrencyCode()) ? StringUtils.EMPTY : dealsDTO.getToCurrencyCode() );
        invalidDeal.setDealAmount(StringUtils.isBlank(dealsDTO.getDealAmount()) ? null : dealsDTO.getDealAmount());
        invalidDeal.setDealTimestamp(StringUtils.isBlank(dealsDTO.getDealTimestamp()) ? null : dealsDTO.getDealTimestamp());

        return  invalidDeal;
    }

}
