package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServiceOrderReportDTO {

	private String serviceOrderId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date serviceOrderDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	
	private String vendorName;
	private String vendorAddress;
	private String contactPerson;
	private String phoneNumber;
	private String vendorGst;
	private String vendorFax;
	
	private String payTerms;
	private String deliveryTerms;
	private String shippingMode;
	private String paymentMethod;
	private String packingType;
	private String juridiction;
	
	private String amountInWord;
	
	private String pan;
	private String ecc;
	private String gstNumber;
	private String division;
	private String commisisionarate;
	
	private String notes;
	
	private Double basicTotal;
	private Double cgstTotal;
	private Double sgstTotal;
	private Double igstTotal;
	private Double grandTotal;
	
	private Double soTotalQnt;
	
	private List<ServiceOrderItemsDTO> serviceOrderItemsDTO;

	public String getServiceOrderId() {
		return serviceOrderId;
	}

	public void setServiceOrderId(String serviceOrderId) {
		this.serviceOrderId = serviceOrderId;
	}

	public Date getServiceOrderDate() {
		return serviceOrderDate;
	}

	public void setServiceOrderDate(Date serviceOrderDate) {
		this.serviceOrderDate = serviceOrderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVendorGst() {
		return vendorGst;
	}

	public void setVendorGst(String vendorGst) {
		this.vendorGst = vendorGst;
	}

	public String getVendorFax() {
		return vendorFax;
	}

	public void setVendorFax(String vendorFax) {
		this.vendorFax = vendorFax;
	}

	public String getPayTerms() {
		return payTerms;
	}

	public void setPayTerms(String payTerms) {
		this.payTerms = payTerms;
	}

	public String getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public String getShippingMode() {
		return shippingMode;
	}

	public void setShippingMode(String shippingMode) {
		this.shippingMode = shippingMode;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public String getJuridiction() {
		return juridiction;
	}

	public void setJuridiction(String juridiction) {
		this.juridiction = juridiction;
	}

	public String getAmountInWord() {
		return amountInWord;
	}

	public void setAmountInWord(String amountInWord) {
		this.amountInWord = amountInWord;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getEcc() {
		return ecc;
	}

	public void setEcc(String ecc) {
		this.ecc = ecc;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getCommisisionarate() {
		return commisisionarate;
	}

	public void setCommisisionarate(String commisisionarate) {
		this.commisisionarate = commisisionarate;
	}

	public List<ServiceOrderItemsDTO> getServiceOrderItemsDTO() {
		return serviceOrderItemsDTO;
	}

	public void setServiceOrderItemsDTO(List<ServiceOrderItemsDTO> serviceOrderItemsDTO) {
		this.serviceOrderItemsDTO = serviceOrderItemsDTO;
	}
	
	public Double getSoTotalQnt() {
		return soTotalQnt;
	}

	public void setSoTotalQnt(Double soTotalQnt) {
		this.soTotalQnt = soTotalQnt;
	}

	public Double getBasicTotal() {
		return basicTotal;
	}

	public void setBasicTotal(Double basicTotal) {
		this.basicTotal = basicTotal;
	}

	public Double getCgstTotal() {
		return cgstTotal;
	}

	public void setCgstTotal(Double cgstTotal) {
		this.cgstTotal = cgstTotal;
	}

	public Double getSgstTotal() {
		return sgstTotal;
	}

	public void setSgstTotal(Double sgstTotal) {
		this.sgstTotal = sgstTotal;
	}

	public Double getIgstTotal() {
		return igstTotal;
	}

	public void setIgstTotal(Double igstTotal) {
		this.igstTotal = igstTotal;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	
}
