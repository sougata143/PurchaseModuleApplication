package com.aspl.org.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseIndentReportItemsDTO {

	public String itemCode;
	public String itemName;
	public String itemDescription;
	public String productGrp;
	public String unit;
	public Double reqQnt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date reqDate;
	public Double inStockQnt;
	public Double pendingIndentQnt;
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getProductGrp() {
		return productGrp;
	}
	public void setProductGrp(String productGrp) {
		this.productGrp = productGrp;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getReqQnt() {
		return reqQnt;
	}
	public void setReqQnt(Double reqQnt) {
		this.reqQnt = reqQnt;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	public Double getInStockQnt() {
		return inStockQnt;
	}
	public void setInStockQnt(Double inStockQnt) {
		this.inStockQnt = inStockQnt;
	}
	public Double getPendingIndentQnt() {
		return pendingIndentQnt;
	}
	public void setPendingIndentQnt(Double pendingIndentQnt) {
		this.pendingIndentQnt = pendingIndentQnt;
	}
	
	
	
	
}
