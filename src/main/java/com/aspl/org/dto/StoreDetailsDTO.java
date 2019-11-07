package com.aspl.org.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StoreDetailsDTO {

	private Integer id;
	private ItemForCategoryMapDTO item;
	private Double quantity;
	private DepartmentForGRNDTO department;
	private CategoryMappingDTO category;
	private String sapCode;
	private String hsCode;
	private String barCode;
	private Double reorder;
	private Double minimum;
	private String unit;
	private Double wtPerUnit;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expiryDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ItemForCategoryMapDTO getItem() {
		return item;
	}
	public void setItem(ItemForCategoryMapDTO item) {
		this.item = item;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public DepartmentForGRNDTO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentForGRNDTO department) {
		this.department = department;
	}
	public CategoryMappingDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryMappingDTO category) {
		this.category = category;
	}
	public String getSapCode() {
		return sapCode;
	}
	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}
	public String getHsCode() {
		return hsCode;
	}
	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Double getReorder() {
		return reorder;
	}
	public void setReorder(Double reorder) {
		this.reorder = reorder;
	}
	public Double getMinimum() {
		return minimum;
	}
	public void setMinimum(Double minimum) {
		this.minimum = minimum;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Double getWtPerUnit() {
		return wtPerUnit;
	}
	public void setWtPerUnit(Double wtPerUnit) {
		this.wtPerUnit = wtPerUnit;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
