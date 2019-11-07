package com.aspl.org.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

	@Entity
	@Table(name="Indent")
	public class Indent {
	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "indent")
	 */
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String indentCode;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private Date createdDate;
		private Integer department;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private Date indentDate;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private Date validateDate;
		private String projectCode;
		private String priority;
		private String notes;
		@Column(columnDefinition="int(11) default '1'")
		private Integer accepted;
		private String authorise;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private Date authoriseDate;
		private String preparedBy;
		private String revalidate;
		private String authorisedBy;
		@Column(columnDefinition="int(11) default '0'")
		private Integer status;
		private Integer purchaseStatus;
		
		@OneToMany(fetch=FetchType.LAZY,mappedBy="indent")
		List<IndentDetails> indentDetails;
		
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

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public Integer getDepartment() {
			return department;
		}


		public void setDepartment(Integer department) {
			this.department = department;
		}


		public Integer getIsActive() {
			return isActive;
		}


		public void setIsActive(Integer isActive) {
			this.isActive = isActive;
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


		public Integer getStatus() {
			return status;
		}


		public void setStatus(Integer status) {
			this.status = status;
		}


		public List<IndentDetails> getIndentDetails() {
			return indentDetails;
		}


		public void setIndentDetails(List<IndentDetails> indentDetails) {
			this.indentDetails = indentDetails;
		}


		public Integer getPurchaseStatus() {
			return purchaseStatus;
		}


		public void setPurchaseStatus(Integer purchaseStatus) {
			this.purchaseStatus = purchaseStatus;
		}


		public Integer getAccepted() {
			return accepted;
		}


		public void setAccepted(Integer accepted) {
			this.accepted = accepted;
		}



		
}
