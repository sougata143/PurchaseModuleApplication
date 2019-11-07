package com.aspl.org.dto;

public class StoreDTO {

	private Integer id;
	private String itemName;
	private String itemCode;
	private Integer quantity;
	private String department;
	private String category;
	private String sapCode;
	private String hsCode;
	private String barCode;
	private String reorder;
	private Integer minimum;
	
	private CategoryMappingDTO categoryDTO;
	private SubCategoryForMappingDTO subCategoryDTO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
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
	public String getReorder() {
		return reorder;
	}
	public void setReorder(String reorder) {
		this.reorder = reorder;
	}
	public Integer getMinimum() {
		return minimum;
	}
	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}
	public CategoryMappingDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryMappingDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	public SubCategoryForMappingDTO getSubCategoryDTO() {
		return subCategoryDTO;
	}
	public void setSubCategoryDTO(SubCategoryForMappingDTO subCategoryDTO) {
		this.subCategoryDTO = subCategoryDTO;
	}
	
	
}
