package com.aspl.org.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LandedPriceDTO {

	private Integer id;
	private ItemForCategoryMapDTO itemDTO;
	private String unit;
	private Double minStock;
	private Double mrp;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createdDate;
	private Integer vendorId;
	private Integer grnId;
	private Double orderQnt;
	private Double discount;
	private Integer grnDetailsId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ItemForCategoryMapDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemForCategoryMapDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getMinStock() {
		return minStock;
	}
	public void setMinStock(Double minStock) {
		this.minStock = minStock;
	}
	public Double getMrp() {
		return mrp;
	}
	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	public Integer getGrnId() {
		return grnId;
	}
	public void setGrnId(Integer grnId) {
		this.grnId = grnId;
	}
	public Double getOrderQnt() {
		return orderQnt;
	}
	public void setOrderQnt(Double orderQnt) {
		this.orderQnt = orderQnt;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getGrnDetailsId() {
		return grnDetailsId;
	}
	public void setGrnDetailsId(Integer grnDetailsId) {
		this.grnDetailsId = grnDetailsId;
	}
	
	
	
	
}
