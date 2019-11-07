package com.aspl.org.entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Landed_price")
public class LandedPrice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer landedPriceId;
	private Integer itemId;
	private Double minStock;
	private String unit;
	private Double mrp;
	private Date createdDate;
	private Integer isActive;
	private Integer categoryId;
	private Integer subCategoryId;
	private Integer vendorId;
	private Integer grnId;
	private Double orderQnt;
	private Double discount;
	private Integer grnDetailsId;
	
	public Integer getLandedPriceId() {
		return landedPriceId;
	}
	public void setLandedPriceId(Integer landedPriceId) {
		this.landedPriceId = landedPriceId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Double getMinStock() {
		return minStock;
	}
	public void setMinStock(Double minStock) {
		this.minStock = minStock;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
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
