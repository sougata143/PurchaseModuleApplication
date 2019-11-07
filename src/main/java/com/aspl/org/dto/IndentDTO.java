package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IndentDTO {

	private Integer id;
	private String indentCode;
	private DepartmentForGRNDTO department;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date indentDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validateDate;
	private String projectCode;
	private String priority;
	private String notes;
	private int accepted;
	private String authorise;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date authoriseDate;
	private String preparedBy;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String revalidate;
	private String authorisedBy;
	private Integer status;
	private Integer purchaseStatus;
	
	List<IndentDetailsDTO> indentDetails;
	
	private Integer isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIndentCode() {
		return indentCode;
	}

	public void setIndentCode(String indentCode) {
		this.indentCode = indentCode;
	}

	public DepartmentForGRNDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentForGRNDTO department) {
		this.department = department;
	}

	public Date getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	public Date getValidateDate() {
		return validateDate;
	}

	public void setValidateDate(Date validateDate) {
		this.validateDate = validateDate;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	public String getAuthorise() {
		return authorise;
	}

	public void setAuthorise(String authorise) {
		this.authorise = authorise;
	}

	public Date getAuthoriseDate() {
		return authoriseDate;
	}

	public void setAuthoriseDate(Date authoriseDate) {
		this.authoriseDate = authoriseDate;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public String getRevalidate() {
		return revalidate;
	}

	public void setRevalidate(String revalidate) {
		this.revalidate = revalidate;
	}

	public String getAuthorisedBy() {
		return authorisedBy;
	}

	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<IndentDetailsDTO> getIndentDetails() {
		return indentDetails;
	}

	public void setIndentDetails(List<IndentDetailsDTO> indentDetails) {
		this.indentDetails = indentDetails;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(Integer purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
