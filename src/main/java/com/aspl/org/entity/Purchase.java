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
@Table(name = "Purchase_order")

public class Purchase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="purchase_code")
	private String purchaseCode;
	@Column(name = "indent_Id")
	private String indentId;
	@Column(name="indent_code")
	private String indentCode;
	private Date createdDate;
	private String type;
	private Integer advance;
	private Integer vendorId;
	private String vendorCode;
	private String vendorName;
	@Column(columnDefinition="int(11) default '1'")
	private Integer accepted;
	/*
	 * private String shipTo; private String billTo;
	 */
	private String regdOfficeAddr;//from CompanyMaster
	private String billingAddr;//from CompanyMaster
	private String poType;
//	private Double gst;
	private Double cgst;
	private Double sgst;
	private Double igst;
	private Double total_with_gst;
	private Double freight;
	private Double royalty;
	private String insurance;
	private Double otherCharges;
	private Double grandTotal;
	private Date deliveryDate;
	private String authorise;
	private String revalidate;
	private String preparedBy;
	private String currency;
	private String authorisedBy;
	
	private Integer purchaseStatus;
	private Date authDate;
	
	private Integer paymentTermsId;
	private Integer deliveryTermsId;
	private Integer reminderTermsId;
	private Integer paymentMethodId;
	private Integer shippingMethodCodeId;
	private Integer jurisdictionId;
	
	private Double pkg;
	
	/*
	 * For editing purpose UI needs these fields
	 */
	private Double pkgPer;
	private Double freightPer;
	private Double royaltyPer;
	private Double igstPer;
	private Double cgstPer;
	private Double sgstPer;
	private String notes;
	
	private Date orderDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validityDate;
	@Column(name="is_active",columnDefinition="smallint(11) default 1")
	private Integer isActive;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="purchase")
	List<PurchaseDetails> purchaseDetails;
	//@OneToMany(fetch=FetchType.LAZY,mappedBy="purchase")
	//List<StateCodeDetails> stateCodeDetails;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPurchaseCode() {
		return purchaseCode;
	}
	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
	public String getIndentId() {
		return indentId;
	}
	public void setIndentId(String indentId) {
		this.indentId = indentId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getAdvance() {
		return advance;
	}
	public void setAdvance(Integer advance) {
		this.advance = advance;
	}
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
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
	public Integer getAccepted() {
		return accepted;
	}
	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}
	public String getRegdOfficeAddr() {
		return regdOfficeAddr;
	}
	public void setRegdOfficeAddr(String regdOfficeAddr) {
		this.regdOfficeAddr = regdOfficeAddr;
	}
	public String getBillingAddr() {
		return billingAddr;
	}
	public void setBillingAddr(String billingAddr) {
		this.billingAddr = billingAddr;
	}
	public String getPoType() {
		return poType;
	}
	public void setPoType(String poType) {
		this.poType = poType;
	}
//	public Double getGst() {
//		return gst;
//	}
//	public void setGst(Double gst) {
//		this.gst = gst;
//	}
	public Double getCgst() {
		return cgst;
	}
	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}
	public Double getSgst() {
		return sgst;
	}
	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}
	public Double getIgst() {
		return igst;
	}
	public void setIgst(Double igst) {
		this.igst = igst;
	}
	public Double getTotal_with_gst() {
		return total_with_gst;
	}
	public void setTotal_with_gst(Double total_with_gst) {
		this.total_with_gst = total_with_gst;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Double getRoyalty() {
		return royalty;
	}
	public void setRoyalty(Double royalty) {
		this.royalty = royalty;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public Double getOtherCharges() {
		return otherCharges;
	}
	public void setOtherCharges(Double otherCharges) {
		this.otherCharges = otherCharges;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getAuthorise() {
		return authorise;
	}
	public void setAuthorise(String authorise) {
		this.authorise = authorise;
	}
	public String getRevalidate() {
		return revalidate;
	}
	public void setRevalidate(String revalidate) {
		this.revalidate = revalidate;
	}
	public String getPreparedBy() {
		return preparedBy;
	}
	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAuthorisedBy() {
		return authorisedBy;
	}
	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
	}
	public Integer getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(Integer purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	public Date getAuthDate() {
		return authDate;
	}
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}
	public Double getPkg() {
		return pkg;
	}
	public void setPkg(Double pkg) {
		this.pkg = pkg;
	}
	public Double getPkgPer() {
		return pkgPer;
	}
	public void setPkgPer(Double pkgPer) {
		this.pkgPer = pkgPer;
	}
	public Double getFreightPer() {
		return freightPer;
	}
	public void setFreightPer(Double freightPer) {
		this.freightPer = freightPer;
	}
	public Double getRoyaltyPer() {
		return royaltyPer;
	}
	public void setRoyaltyPer(Double royaltyPer) {
		this.royaltyPer = royaltyPer;
	}
	public Double getIgstPer() {
		return igstPer;
	}
	public void setIgstPer(Double igstPer) {
		this.igstPer = igstPer;
	}
	public Double getCgstPer() {
		return cgstPer;
	}
	public void setCgstPer(Double cgstPer) {
		this.cgstPer = cgstPer;
	}
	public Double getSgstPer() {
		return sgstPer;
	}
	public void setSgstPer(Double sgstPer) {
		this.sgstPer = sgstPer;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getValidityDate() {
		return validityDate;
	}
	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public List<PurchaseDetails> getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(List<PurchaseDetails> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getPaymentTermsId() {
		return paymentTermsId;
	}
	public void setPaymentTermsId(Integer paymentTermsId) {
		this.paymentTermsId = paymentTermsId;
	}
	public Integer getDeliveryTermsId() {
		return deliveryTermsId;
	}
	public void setDeliveryTermsId(Integer deliveryTermsId) {
		this.deliveryTermsId = deliveryTermsId;
	}
	public Integer getReminderTermsId() {
		return reminderTermsId;
	}
	public void setReminderTermsId(Integer reminderTermsId) {
		this.reminderTermsId = reminderTermsId;
	}
	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public Integer getShippingMethodCodeId() {
		return shippingMethodCodeId;
	}
	public void setShippingMethodCodeId(Integer shippingMethodCodeId) {
		this.shippingMethodCodeId = shippingMethodCodeId;
	}
	public Integer getJurisdictionId() {
		return jurisdictionId;
	}
	public void setJurisdictionId(Integer jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}
	
	

	
}
