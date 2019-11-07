package com.aspl.org.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FinishedGoodsTransactionDTO {

	private Integer finishedGoodsTransId;
	
	private Integer itemId;
	private Double openingStock;
	private Double closingStock;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createdDate;
	private String category;
	private Double credit;
	private Double debit;
	private Integer storeId;
	
	public Integer getFinishedGoodsTransId() {
		return finishedGoodsTransId;
	}
	public void setFinishedGoodsTransId(Integer finishedGoodsTransId) {
		this.finishedGoodsTransId = finishedGoodsTransId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Double getOpeningStock() {
		return openingStock;
	}
	public void setOpeningStock(Double openingStock) {
		this.openingStock = openingStock;
	}
	public Double getClosingStock() {
		return closingStock;
	}
	public void setClosingStock(Double closingStock) {
		this.closingStock = closingStock;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Double getDebit() {
		return debit;
	}
	public void setDebit(Double debit) {
		this.debit = debit;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	
	
}
