package com.aspl.org.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PriceHistoryDTO {

	private VendorForItemDTO vendor;
	private Double orderQnt;
	private Double price;
	private Double disc;
	private String grnNo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date receiveDate;
	private Double suppliedQnt;
	
	
	public VendorForItemDTO getVendor() {
		return vendor;
	}
	public void setVendor(VendorForItemDTO vendor) {
		this.vendor = vendor;
	}
	public Double getOrderQnt() {
		return orderQnt;
	}
	public void setOrderQnt(Double orderQnt) {
		this.orderQnt = orderQnt;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDisc() {
		return disc;
	}
	public void setDisc(Double disc) {
		this.disc = disc;
	}
	public String getGrnNo() {
		return grnNo;
	}
	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public Double getSuppliedQnt() {
		return suppliedQnt;
	}
	public void setSuppliedQnt(Double suppliedQnt) {
		this.suppliedQnt = suppliedQnt;
	}
	
	
	
}
