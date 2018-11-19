package com.progresssoft.ClusteredDataWarehouse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "upload_summary_report")
public class UploadSummaryReport extends AbstractEntity {

	@Column(name = "source_file_name", nullable = false)
	private String sourceFileName;

	@Column(name = "valid_deals_imported_count")
	private int validDealsImportedCount;

	@Column(name = "invalid_deals_imported_count")
	private int invalidDealsImportedCount;

	@Column(name = "process_duration")
	private double processDuration;

	@Column(name = "import_timestamp")
	private Date importDate;

	public UploadSummaryReport() {

	}

	public String getSourceFileName() {
		return sourceFileName;
	}

	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

	public int getValidDealsImportedCount() {
		return validDealsImportedCount;
	}

	public void setValidDealsImportedCount(int validDealsImportedCount) {
		this.validDealsImportedCount = validDealsImportedCount;
	}

	public int getInvalidDealsImportedCount() {
		return invalidDealsImportedCount;
	}

	public void setInvalidDealsImportedCount(int invalidDealsImportedCount) {
		this.invalidDealsImportedCount = invalidDealsImportedCount;
	}

	public double getProcessDuration() {
		return processDuration;
	}

	public void setProcessDuration(double processDuration) {
		this.processDuration = processDuration;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

}
