package com.aspl.org.entity;

	import java.util.Date;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


	@Entity
	@Table(name="Jobber_Master")
	//@JsonIgnoreProperties(value= {"password"})
	public class JobberMaster {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		 @Column(name = "Jobber_Code", nullable = false)
		private String jobberCode;
		
		@Column(name = "Jobber_Name", length = 45, nullable = false)
		private String jobberName;
		@Column(name = "Branch_Office")
		private String branchOffice;
		@Column(name = "Ho_Code")
		private String hoCode;
		private String hoName;
		private String address1;
		private String address2;
	/*
	 * private String chepter; private String heading; private String subHeading;
	 */
		private String city;
		private String state;
		private String pin;
		private String stateCode;
		private String country;
		private String ledgerName;
		private String closingBalance;
		private String contactPerson;
		private String designation;
		private String department;
		private String contactNo;
		private String mobileNo;
		private String faxNo;
		private String email;
		private String jobber_type;
		private String url;
		private String lstNo;
		
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name = "Lst_No_Date")
		private Date lstNoDate;
		
		private String cstNo;
		
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name = "Cst_No_Date")
		private Date cstNoDate;
		
		private String panNo;
		private String impExpCode;
		private String binNo;
		private String ecgcNo;
		
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name = "Ecgc_No_Date")
		private Date ecgcNoDate;
		
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name = "Ecgc_Validity_Date")
		private Date ecgcValidityDate;
		
		private String cexciseRegnNo;
		private String eccNo;
		@Column(name = "rnge",length = 45, nullable = false)
		private String rnge;
		private String division;
		private String commissionerate;
		private String regnCumCode;
		
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name = "Regn_Cum_Code_Date")
		private Date regnCumCodeDate; 
		
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name = "Regn_Cum_Validity_Date")
		private Date regnCumValidityDate; 
		
		private String regnCumCouncilName;
		private String paymentTerms;
		private String paymentMethod;
		private String shipMethodCode;
		private String deliveryTerms;
		private String jurisdiction;
		private String reminderTerms;
		private String bankName;
		private String accountNo;
		@Column(name="is_active",columnDefinition="smallint(11) default 1")
		private Integer isActive;
		@Column(name="is_blocked",columnDefinition="smallint(11) default 0")
		private Integer isBlocked;
		
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getJobberCode() {
			return jobberCode;
		}

		public void setJobberCode(String jobberCode) {
			this.jobberCode = jobberCode;
		}

		public String getJobberName() {
			return jobberName;
		}

		public void setJobberName(String jobberName) {
			this.jobberName = jobberName;
		}

		public String getBranchOffice() {
			return branchOffice;
		}

		public void setBranchOffice(String branchOffice) {
			this.branchOffice = branchOffice;
		}

		public String getHoCode() {
			return hoCode;
		}

		public void setHoCode(String hoCode) {
			this.hoCode = hoCode;
		}

		public String getHoName() {
			return hoName;
		}

		public void setHoName(String hoName) {
			this.hoName = hoName;
		}

		public String getAddress1() {
			return address1;
		}

		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPin() {
			return pin;
		}

		public void setPin(String pin) {
			this.pin = pin;
		}

		public String getStateCode() {
			return stateCode;
		}

		public void setStateCode(String stateCode) {
			this.stateCode = stateCode;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getLedgerName() {
			return ledgerName;
		}

		public void setLedgerName(String ledgerName) {
			this.ledgerName = ledgerName;
		}

		public String getClosingBalance() {
			return closingBalance;
		}

		public void setClosingBalance(String closingBalance) {
			this.closingBalance = closingBalance;
		}

		public String getContactPerson() {
			return contactPerson;
		}

		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getContactNo() {
			return contactNo;
		}

		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getFaxNo() {
			return faxNo;
		}

		public void setFaxNo(String faxNo) {
			this.faxNo = faxNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getJobber_type() {
			return jobber_type;
		}

		public void setJobber_type(String jobber_type) {
			this.jobber_type = jobber_type;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getLstNo() {
			return lstNo;
		}

		public void setLstNo(String lstNo) {
			this.lstNo = lstNo;
		}

		public Date getLstNoDate() {
			return lstNoDate;
		}

		public void setLstNoDate(Date lstNoDate) {
			this.lstNoDate = lstNoDate;
		}

		public String getCstNo() {
			return cstNo;
		}

		public void setCstNo(String cstNo) {
			this.cstNo = cstNo;
		}

		public Date getCstNoDate() {
			return cstNoDate;
		}

		public void setCstNoDate(Date cstNoDate) {
			this.cstNoDate = cstNoDate;
		}

		public String getPanNo() {
			return panNo;
		}

		public void setPanNo(String panNo) {
			this.panNo = panNo;
		}

		public String getImpExpCode() {
			return impExpCode;
		}

		public void setImpExpCode(String impExpCode) {
			this.impExpCode = impExpCode;
		}

		public String getBinNo() {
			return binNo;
		}

		public void setBinNo(String binNo) {
			this.binNo = binNo;
		}

		public String getEcgcNo() {
			return ecgcNo;
		}

		public void setEcgcNo(String ecgcNo) {
			this.ecgcNo = ecgcNo;
		}

		public Date getEcgcNoDate() {
			return ecgcNoDate;
		}

		public void setEcgcNoDate(Date ecgcNoDate) {
			this.ecgcNoDate = ecgcNoDate;
		}

		public Date getEcgcValidityDate() {
			return ecgcValidityDate;
		}

		public void setEcgcValidityDate(Date ecgcValidityDate) {
			this.ecgcValidityDate = ecgcValidityDate;
		}

		public String getCexciseRegnNo() {
			return cexciseRegnNo;
		}

		public void setCexciseRegnNo(String cexciseRegnNo) {
			this.cexciseRegnNo = cexciseRegnNo;
		}

		public String getEccNo() {
			return eccNo;
		}

		public void setEccNo(String eccNo) {
			this.eccNo = eccNo;
		}

		public String getRnge() {
			return rnge;
		}

		public void setRnge(String rnge) {
			this.rnge = rnge;
		}

		public String getDivision() {
			return division;
		}

		public void setDivision(String division) {
			this.division = division;
		}

		public String getCommissionerate() {
			return commissionerate;
		}

		public void setCommissionerate(String commissionerate) {
			this.commissionerate = commissionerate;
		}

		public String getRegnCumCode() {
			return regnCumCode;
		}

		public void setRegnCumCode(String regnCumCode) {
			this.regnCumCode = regnCumCode;
		}

		public Date getRegnCumCodeDate() {
			return regnCumCodeDate;
		}

		public void setRegnCumCodeDate(Date regnCumCodeDate) {
			this.regnCumCodeDate = regnCumCodeDate;
		}

		public Date getRegnCumValidityDate() {
			return regnCumValidityDate;
		}

		public void setRegnCumValidityDate(Date regnCumValidityDate) {
			this.regnCumValidityDate = regnCumValidityDate;
		}

		public String getRegnCumCouncilName() {
			return regnCumCouncilName;
		}

		public void setRegnCumCouncilName(String regnCumCouncilName) {
			this.regnCumCouncilName = regnCumCouncilName;
		}

		public String getPaymentTerms() {
			return paymentTerms;
		}

		public void setPaymentTerms(String paymentTerms) {
			this.paymentTerms = paymentTerms;
		}

		public String getPaymentMethod() {
			return paymentMethod;
		}

		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}

		public String getShipMethodCode() {
			return shipMethodCode;
		}

		public void setShipMethodCode(String shipMethodCode) {
			this.shipMethodCode = shipMethodCode;
		}

		public String getDeliveryTerms() {
			return deliveryTerms;
		}

		public void setDeliveryTerms(String deliveryTerms) {
			this.deliveryTerms = deliveryTerms;
		}

		public String getJurisdiction() {
			return jurisdiction;
		}

		public void setJurisdiction(String jurisdiction) {
			this.jurisdiction = jurisdiction;
		}

		public String getReminderTerms() {
			return reminderTerms;
		}

		public void setReminderTerms(String reminderTerms) {
			this.reminderTerms = reminderTerms;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		public Integer getIsActive() {
			return isActive;
		}

		public void setIsActive(Integer isActive) {
			this.isActive = isActive;
		}

		public Integer getIsBlocked() {
			return isBlocked;
		}

		public void setIsBlocked(Integer isBlocked) {
			this.isBlocked = isBlocked;
		}

		
}
