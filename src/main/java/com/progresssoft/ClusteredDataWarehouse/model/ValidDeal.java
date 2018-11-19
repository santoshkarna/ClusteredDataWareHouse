package com.progresssoft.ClusteredDataWarehouse.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.progresssoft.ClusteredDataWarehouse.dto.DealsDTO;
import com.progresssoft.ClusteredDataWarehouse.validator.DataValidator;

@Entity
@Table(name = "valid_deal")
public class ValidDeal extends AbstractEntity {
	
	@Column(name = "deal_unique_id", nullable = true)
    private String dealUniqueId;
	
	@Column(name = "source_file_name")
    private String sourceFileName;

    @Column(name = "from_currency_code", nullable = true)
    private String fromCurrencyCode;

    @Column(name = "to_currency_code", nullable = true)
    private String toCurrencyCode;

    @Column(name = "deal_timestamp", nullable = true)
    private LocalDateTime dealTimestamp;

    @Column(name = "deal_amount", nullable = true)
    private BigDecimal dealAmount;
    
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


	public LocalDateTime getDealTimestamp() {
		return dealTimestamp;
	}


	public void setDealTimestamp(LocalDateTime dealTimestamp) {
		this.dealTimestamp = dealTimestamp;
	}


	public BigDecimal getDealAmount() {
		return dealAmount;
	}


	public void setDealAmount(BigDecimal dealAmount) {
		this.dealAmount = dealAmount;
	}

	public ValidDeal() {
		
    }
	
	
	public static ValidDeal copyProperties(DealsDTO dealsDTO) {

        ValidDeal validDeal = new ValidDeal();
        validDeal.setDealUniqueId(dealsDTO.getDealUniqueId());
        validDeal.setFromCurrencyCode(dealsDTO.getFromCurrencyCode());
        validDeal.setToCurrencyCode(dealsDTO.getToCurrencyCode());
        validDeal.setDealAmount(new BigDecimal(dealsDTO.getDealAmount()));
        validDeal.setDealTimestamp(LocalDateTime.parse(dealsDTO.getDealTimestamp(), DataValidator.TIMESTAMP_FORMATTER));

        return  validDeal;
    }
}
