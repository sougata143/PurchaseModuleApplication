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
@Table(name = "Service_order")

public class Serviceorder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="service_code")
	private String serviceCode;
	private Integer vendorId;
	private String vendorCode;
	private String vendorName;
	@Column(columnDefinition="int(11) default '1'")
	private Integer accepted;
	
	private Double gst;
	private Double cgst;
	private Double sgst;
	private Double igst;
	private Double total_with_gst;
	private Double freight;
	private Double royalty;
	private Double otherCharges;
	private Double grandTotal;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	
	private String notes;
	
	private Integer paymentTermsId;
	private String paymentTermsCode;

	private Integer deliveryTermsId1;
	private String deliveryTermsCode;

	private Integer reminderTermsId;
	private String reminderTermsCode;

	private Integer paymentMethodId;
	private String paymentMethodCode;

	private Integer shippingMethodCodeId;
	private String ShippingMethodCode;

	private Integer jurisdictionId;
	private String jurisdictionCode;
	
	private Integer serviceorderStatus;
	
	private Double pkg;
	private String unit;
	

	/*
	 * For editing purpose UI needs these fields
	 */
	private Double pkgPer;
	private Double freightPer;
	private Double royaltyPer;
	private Double igstPer;
	private Double cgstPer;
	private Double sgstPer;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date orderDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validityDate;
	@Column(name="is_active",columnDefinition="smallint(11) default 1")
	private Integer isActive;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="serviceorder")
	private List<ServiceorderDetails> serviceorderDetails;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
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
	public Double getGst() {
		return gst;
	}
	public void setGst(Double gst) {
		this.gst = gst;
	}
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
	public Integer getDeliveryTermsId1() {
		return deliveryTermsId1;
	}
	public void setDeliveryTermsId1(Integer deliveryTermsId1) {
		this.deliveryTermsId1 = deliveryTermsId1;
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
	public Integer getServiceorderStatus() {
		return serviceorderStatus;
	}
	public void setServiceorderStatus(Integer serviceorderStatus) {
		this.serviceorderStatus = serviceorderStatus;
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
	public List<ServiceorderDetails> getServiceorderDetails() {
		return serviceorderDetails;
	}
	public void setServiceorderDetails(List<ServiceorderDetails> serviceorderDetails) {
		this.serviceorderDetails = serviceorderDetails;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	
	


}
