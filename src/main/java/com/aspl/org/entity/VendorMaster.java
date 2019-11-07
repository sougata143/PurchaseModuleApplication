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
@Table(name = "Vendor_Master")
// @JsonIgnoreProperties(value= {"password"})
public class VendorMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Vendor_Code", nullable = false)
	private String vendorCode;
	@Column(name = "Vendor_Name", length = 45, nullable = false)
	private String vendorName;
	private String branch_office;
	private String hoCode;
	private String hoName;
	private String address1;
	private String address2;

	/*
	 * private String chepter; private String heading; private String subHeading;
	 */
	private String city;
	private String state;
	private Integer stateCode;
	private String country;
	private String ledgerName;// same as vendor name
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validationDate;
	
	private Integer pin;
	private String branchName;
	private String ifscCode;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorMaster")
//	private List<ContactsDetails> contactsDetails;

	private String gstNo;
	private String panNo;
	private String staxRegnNo;
	private String cexciseRegnNo;
	private String eccNo;
	private String rnge;
	private String division;
	private String commissionerate;
	private String impExpCode;
	private String binNo;
	private String ecgcNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date ecgcDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date ecgcValidityDate;

	private String regnCumCode;  

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date regnCumCodeDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date regnCumValidityDate;
	private String regnCumCouncilName;

	private Integer paymentTermsId;
	private String paymentTermsCode;

	private Integer deliveryTermsId;
	private String deliveryTermsCode;

	private Integer reminderTermsId;
	private String reminderTermsCode;

	private Integer paymentMethodId;
	private String paymentMethodCode;

	private Integer shippingMethodCodeId;
	private String ShippingMethodCode;

	private Integer jurisdictionId;
	private String jurisdictionCode;

	private String bankName;
	private String accountNo;
	private String insuranceType;
	private String amount;
	private Integer status;

	@Column(name = "is_isoSupplier", columnDefinition = "smallint(11) default 1")
	private Integer isisoSupplier;
	@Column(name = "is_blocked", columnDefinition = "smallint(11) default 0")
	private Integer isbLocked;

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getVendorCode() {
		return vendorCode;
	}


	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public String getBranch_office() {
		return branch_office;
	}


	public void setBranch_office(String branch_office) {
		this.branch_office = branch_office;
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


	public Integer getStateCode() {
		return stateCode;
	}


	public void setStateCode(Integer stateCode) {
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


	public Date getValidationDate() {
		return validationDate;
	}


	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}


	public Integer getPin() {
		return pin;
	}


	public void setPin(Integer pin) {
		this.pin = pin;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getIfscCode() {
		return ifscCode;
	}


	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


//	public List<ContactsDetails> getContactsDetails() {
//		return contactsDetails;
//	}
//
//
//	public void setContactsDetails(List<ContactsDetails> contactsDetails) {
//		this.contactsDetails = contactsDetails;
//	}


	public String getGstNo() {
		return gstNo;
	}


	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}


	public String getPanNo() {
		return panNo;
	}


	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}


	public String getStaxRegnNo() {
		return staxRegnNo;
	}


	public void setStaxRegnNo(String staxRegnNo) {
		this.staxRegnNo = staxRegnNo;
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


	public Date getEcgcDate() {
		return ecgcDate;
	}


	public void setEcgcDate(Date ecgcDate) {
		this.ecgcDate = ecgcDate;
	}


	public Date getEcgcValidityDate() {
		return ecgcValidityDate;
	}


	public void setEcgcValidityDate(Date ecgcValidityDate) {
		this.ecgcValidityDate = ecgcValidityDate;
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


	public Integer getPaymentTermsId() {
		return paymentTermsId;
	}


	public void setPaymentTermsId(Integer paymentTermsId) {
		this.paymentTermsId = paymentTermsId;
	}


	public String getPaymentTermsCode() {
		return paymentTermsCode;
	}


	public void setPaymentTermsCode(String paymentTermsCode) {
		this.paymentTermsCode = paymentTermsCode;
	}


	public Integer getDeliveryTermsId() {
		return deliveryTermsId;
	}


	public void setDeliveryTermsId1(Integer deliveryTermsId) {
		this.deliveryTermsId = deliveryTermsId;
	}


	public String getDeliveryTermsCode() {
		return deliveryTermsCode;
	}


	public void setDeliveryTermsCode(String deliveryTermsCode) {
		this.deliveryTermsCode = deliveryTermsCode;
	}


	public Integer getReminderTermsId() {
		return reminderTermsId;
	}


	public void setReminderTermsId(Integer reminderTermsId) {
		this.reminderTermsId = reminderTermsId;
	}


	public String getReminderTermsCode() {
		return reminderTermsCode;
	}


	public void setReminderTermsCode(String reminderTermsCode) {
		this.reminderTermsCode = reminderTermsCode;
	}


	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}


	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}


	public String getPaymentMethodCode() {
		return paymentMethodCode;
	}


	public void setPaymentMethodCode(String paymentMethodCode) {
		this.paymentMethodCode = paymentMethodCode;
	}


	public Integer getShippingMethodCodeId() {
		return shippingMethodCodeId;
	}


	public void setShippingMethodCodeId(Integer shippingMethodCodeId) {
		this.shippingMethodCodeId = shippingMethodCodeId;
	}


	public String getShippingMethodCode() {
		return ShippingMethodCode;
	}


	public void setShippingMethodCode(String shippingMethodCode) {
		ShippingMethodCode = shippingMethodCode;
	}


	public Integer getJurisdictionId() {
		return jurisdictionId;
	}


	public void setJurisdictionId(Integer jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}


	public String getJurisdictionCode() {
		return jurisdictionCode;
	}


	public void setJurisdictionCode(String jurisdictionCode) {
		this.jurisdictionCode = jurisdictionCode;
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


	public String getInsuranceType() {
		return insuranceType;
	}


	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getIsisoSupplier() {
		return isisoSupplier;
	}


	public void setIsisoSupplier(Integer isisoSupplier) {
		this.isisoSupplier = isisoSupplier;
	}


	public Integer getIsbLocked() {
		return isbLocked;
	}


	public void setIsbLocked(Integer isbLocked) {
		this.isbLocked = isbLocked;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
