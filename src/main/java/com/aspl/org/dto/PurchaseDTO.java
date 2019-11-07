package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.aspl.org.entity.VendorMaster;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseDTO {

	private Integer id;
	private String purchaseCode;
	
	private IndentDTO indent;
	
	private String type;
	private Integer advance;
	private VendorMaster vendor;
	private Integer accepted;
	
	private String regdOfficeAddr;//from CompanyMaster
	private String billingAddr;//from CompanyMaster
	private String poType;
	private Double gst;
	private Double cgst;
	private Double sgst;
	private Double igst;
	private Double total_with_gst;
	private Double freight;
	private Double royalty;
	private String insurance;
	private Double otherCharges;
	private Double grandTotal;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	private String authorise;
	private String revalidate;
	private String preparedBy;
	private String authorisedBy;
	private String notes;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date orderDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validityDate;
	
	private Integer isActive;
	private Integer purchaseStatus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date authDate;
	
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
	
	private PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO;
	
	private DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO;
	
	private ReminderTermsMasterForVendorDTO ReminderTermsMasterForVendorDTO;
	
	private PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO;
	
	private ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO;
	
	private JurisdictionMasterForVendorDTO jurisdictionMasterForVendor;
	
	List<PurchaseDetailsDTO> purchaseDetails;

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

	public IndentDTO getIndent() {
		return indent;
	}

	public void setIndent(IndentDTO indent) {
		this.indent = indent;
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

	public VendorMaster getVendor() {
		return vendor;
	}

	public void setVendor(VendorMaster vendor) {
		this.vendor = vendor;
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

	public String getAuthorisedBy() {
		return authorisedBy;
	}

	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
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

	public List<PurchaseDetailsDTO> getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(List<PurchaseDetailsDTO> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	
	
}
