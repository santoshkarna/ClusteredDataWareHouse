package com.progresssoft.ClusteredDataWarehouse.dto;

public class SummaryReportDTO {
	private String sourceFileName;

	private int validDealsImportedCount;

	private int invalidDealsImportedCount;

	private String processDuration;

	private String importDate;

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

	public String getProcessDuration() {
		return processDuration;
	}

	public void setProcessDuration(String processDuration) {
		this.processDuration = processDuration;
	}

	public String getImportDate() {
		return importDate;
	}

	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}

}
