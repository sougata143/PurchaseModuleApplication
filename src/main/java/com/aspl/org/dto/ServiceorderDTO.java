package com.aspl.org.dto;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ServiceorderDTO {
	
	private Integer id;
	private String serviceCode;
	
	private VendorMasterDTO vendor;
	
	private Integer accepted;
	//private Double gst;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date orderDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validityDate;
	private Integer purchaseStatus;
	private Double pkg;
	
	private String notes;
	
	/*
	 * For editing purpose UI needs these fields
	 */
	private Double pkgPer;
	private Double freightPer;
	private Double royaltyPer;
	private Double igstPer;
	private Double cgstPer;
	private Double sgstPer;
	
    private PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO;
	
	private DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO;
	
	private ReminderTermsMasterForVendorDTO ReminderTermsMasterForVendorDTO;
	
	private PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO;
	
	private ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO;
	
	private JurisdictionMasterForVendorDTO jurisdictionMasterForVendor;
	
	private Integer isActive;
	
	private List<SoDetailsDTO> serviceorderDetails;

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

	public VendorMasterDTO getVendor() {
		return vendor;
	}

	public void setVendor(VendorMasterDTO vendor) {
		this.vendor = vendor;
	}

	public Integer getAccepted() {
		return accepted;
	}

	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
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

	public Integer getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(Integer purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
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

	public PaymentTermsMasterforVendorDTO getPaymentTermsMasterforVendorDTO() {
		return paymentTermsMasterforVendorDTO;
	}

	public void setPaymentTermsMasterforVendorDTO(PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO) {
		this.paymentTermsMasterforVendorDTO = paymentTermsMasterforVendorDTO;
	}

	public DeliveryTermsMasterforVendorDTO getDeliveryTermsMasterforVendorDTO() {
		return deliveryTermsMasterforVendorDTO;
	}

	public void setDeliveryTermsMasterforVendorDTO(DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO) {
		this.deliveryTermsMasterforVendorDTO = deliveryTermsMasterforVendorDTO;
	}

	public ReminderTermsMasterForVendorDTO getReminderTermsMasterForVendorDTO() {
		return ReminderTermsMasterForVendorDTO;
	}

	public void setReminderTermsMasterForVendorDTO(ReminderTermsMasterForVendorDTO reminderTermsMasterForVendorDTO) {
		ReminderTermsMasterForVendorDTO = reminderTermsMasterForVendorDTO;
	}

	public PaymentMethodMasterforVendorDTO getPaymentMethodMasterforVendorDTO() {
		return paymentMethodMasterforVendorDTO;
	}

	public void setPaymentMethodMasterforVendorDTO(PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO) {
		this.paymentMethodMasterforVendorDTO = paymentMethodMasterforVendorDTO;
	}

	public ShippingMethodMasterforVendorDTO getShippingMethodMasterforVendorDTO() {
		return shippingMethodMasterforVendorDTO;
	}

	public void setShippingMethodMasterforVendorDTO(ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO) {
		this.shippingMethodMasterforVendorDTO = shippingMethodMasterforVendorDTO;
	}

	public JurisdictionMasterForVendorDTO getJurisdictionMasterForVendor() {
		return jurisdictionMasterForVendor;
	}

	public void setJurisdictionMasterForVendor(JurisdictionMasterForVendorDTO jurisdictionMasterForVendor) {
		this.jurisdictionMasterForVendor = jurisdictionMasterForVendor;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public List<SoDetailsDTO> getServiceorderDetails() {
		return serviceorderDetails;
	}

	public void setServiceorderDetails(List<SoDetailsDTO> serviceorderDetails) {
		this.serviceorderDetails = serviceorderDetails;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	


}
