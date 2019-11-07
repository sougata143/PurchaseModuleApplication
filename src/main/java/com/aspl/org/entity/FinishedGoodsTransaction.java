package com.aspl.org.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="finished_goods_transaction")
public class FinishedGoodsTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer finishedGoodsTransId;
	
	private Integer itemId;
	private Double openingStock;
	private Double closingStock;
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
