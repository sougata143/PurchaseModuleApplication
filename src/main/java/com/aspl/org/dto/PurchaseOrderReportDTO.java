package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseOrderReportDTO {

	private String poNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date poDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	private String indentNumber;
	private String buyer;
	private String currency;
	private String gstNo;
	
	private String billTo;
	private String shipTo;
	
	private String notes;
	
	private String vendorCode;
	private String vendorName;
	private String vendorPhone;
	private String vendorFax;
	private String venodrGst;
	private String vendorEmail;
	public String vendorPan;
	public String vendorAddress;
	
	private Double excise;
	private Double sgst;
	private Double total;
	
	private String amountInWords;
	private String paymentTerms;
	private String deliveryTerms;
	private String deliveryMethod;
	private String shippingMethod;
	private String paymentMethod;
	private String juridiction;
	
	private String preparedBy;
	private String checkedBy;
	private String authorisedBy;
	
	private Double totalPoQnt;
	
	private String poType;
	private String poRaisedBy;
	private String revalidateNo;
	
	private Double basicTotalQnt;
	private String validity;
	private String contactPerson;
	private Double basicCgst;
	private Double basicSgst;
	private Double basicIgst;
	private String authDate;
	
	private Double basicCgstPer;
	private Double basicSgstPer;
	private Double basicIgstPer;
 
	
	private List<PurchaseOrderReportItemDTO> PurchaseOrderReportItemDTO;


	public String getPoNumber() {
		return poNumber;
	}


	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}


	public Date getPoDate() {
		return poDate;
	}


	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public String getIndentNumber() {
		return indentNumber;
	}


	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}


	public String getBuyer() {
		return buyer;
	}


	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getGstNo() {
		return gstNo;
	}


	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}


	public String getBillTo() {
		return billTo;
	}


	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}


	public String getShipTo() {
		return shipTo;
	}


	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
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


	public String getVendorPhone() {
		return vendorPhone;
	}


	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}


	public String getVendorFax() {
		return vendorFax;
	}


	public void setVendorFax(String vendorFax) {
		this.vendorFax = vendorFax;
	}


	public String getVenodrGst() {
		return venodrGst;
	}


	public void setVenodrGst(String venodrGst) {
		this.venodrGst = venodrGst;
	}


	public String getVendorEmail() {
		return vendorEmail;
	}


	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}


	public String getVendorPan() {
		return vendorPan;
	}


	public void setVendorPan(String vendorPan) {
		this.vendorPan = vendorPan;
	}


	public String getVendorAddress() {
		return vendorAddress;
	}


	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}


	public Double getExcise() {
		return excise;
	}


	public void setExcise(Double excise) {
		this.excise = excise;
	}


	public Double getSgst() {
		return sgst;
	}


	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public String getAmountInWords() {
		return amountInWords;
	}


	public void setAmountInWords(String amountInWords) {
		this.amountInWords = amountInWords;
	}


	public String getPaymentTerms() {
		return paymentTerms;
	}


	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}


	public String getDeliveryTerms() {
		return deliveryTerms;
	}


	public void setDeliveryTerms(String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}


	public String getDeliveryMethod() {
		return deliveryMethod;
	}


	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}


	public String getShippingMethod() {
		return shippingMethod;
	}


	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getJuridiction() {
		return juridiction;
	}


	public void setJuridiction(String juridiction) {
		this.juridiction = juridiction;
	}


	public String getPreparedBy() {
		return preparedBy;
	}


	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}


	public String getCheckedBy() {
		return checkedBy;
	}


	public void setCheckedBy(String checkedBy) {
		this.checkedBy = checkedBy;
	}


	public String getAuthorisedBy() {
		return authorisedBy;
	}


	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
	}


	public Double getTotalPoQnt() {
		return totalPoQnt;
	}


	public void setTotalPoQnt(Double totalPoQnt) {
		this.totalPoQnt = totalPoQnt;
	}


	public String getPoType() {
		return poType;
	}


	public void setPoType(String poType) {
		this.poType = poType;
	}


	public String getPoRaisedBy() {
		return poRaisedBy;
	}


	public void setPoRaisedBy(String poRaisedBy) {
		this.poRaisedBy = poRaisedBy;
	}


	public String getRevalidateNo() {
		return revalidateNo;
	}


	public void setRevalidateNo(String revalidateNo) {
		this.revalidateNo = revalidateNo;
	}


	public Double getBasicTotalQnt() {
		return basicTotalQnt;
	}


	public void setBasicTotalQnt(Double basicTotalQnt) {
		this.basicTotalQnt = basicTotalQnt;
	}


	public String getValidity() {
		return validity;
	}


	public void setValidity(String validity) {
		this.validity = validity;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public Double getBasicCgst() {
		return basicCgst;
	}


	public void setBasicCgst(Double basicCgst) {
		this.basicCgst = basicCgst;
	}


	public Double getBasicSgst() {
		return basicSgst;
	}


	public void setBasicSgst(Double basicSgst) {
		this.basicSgst = basicSgst;
	}


	public Double getBasicIgst() {
		return basicIgst;
	}


	public void setBasicIgst(Double basicIgst) {
		this.basicIgst = basicIgst;
	}


	public String getAuthDate() {
		return authDate;
	}


	public void setAuthDate(String authDate) {
		this.authDate = authDate;
	}


	public Double getBasicCgstPer() {
		return basicCgstPer;
	}


	public void setBasicCgstPer(Double basicCgstPer) {
		this.basicCgstPer = basicCgstPer;
	}


	public Double getBasicSgstPer() {
		return basicSgstPer;
	}


	public void setBasicSgstPer(Double basicSgstPer) {
		this.basicSgstPer = basicSgstPer;
	}


	public Double getBasicIgstPer() {
		return basicIgstPer;
	}


	public void setBasicIgstPer(Double basicIgstPer) {
		this.basicIgstPer = basicIgstPer;
	}


	public List<PurchaseOrderReportItemDTO> getPurchaseOrderReportItemDTO() {
		return PurchaseOrderReportItemDTO;
	}


	public void setPurchaseOrderReportItemDTO(List<PurchaseOrderReportItemDTO> purchaseOrderReportItemDTO) {
		PurchaseOrderReportItemDTO = purchaseOrderReportItemDTO;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	
	
	
}
