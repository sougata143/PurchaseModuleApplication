package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseIndentReportDTO {

	private String indentCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date indentDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validityDate;
	private String department;
	private String projectCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date authDate;
	private String workOrderNo;
	private String note;
	
	private List<PurchaseIndentReportItemsDTO> PurchaseIndentReportItemsDTO;

	public String getIndentCode() {
		return indentCode;
	}

	public void setIndentCode(String indentCode) {
		this.indentCode = indentCode;
	}

	public Date getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	public Date getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public Date getAuthDate() {
		return authDate;
	}

	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public List<PurchaseIndentReportItemsDTO> getPurchaseIndentReportItemsDTO() {
		return PurchaseIndentReportItemsDTO;
	}

	public void setPurchaseIndentReportItemsDTO(List<PurchaseIndentReportItemsDTO> purchaseIndentReportItemsDTO) {
		PurchaseIndentReportItemsDTO = purchaseIndentReportItemsDTO;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	
}
