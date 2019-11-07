package com.aspl.org.dto;

import java.util.List;


public class StockLedgerDTO {

	private ItemForCategoryMapDTO item;
	
	private Double totalCredit;
	private Double totalDebit;
	private Double finalBalance;
	private Double firstBalance;
	
	List<StockLedgerListDTO> stockLedgerItems;

	public ItemForCategoryMapDTO getItem() {
		return item;
	}

	public void setItem(ItemForCategoryMapDTO item) {
		this.item = item;
	}

	public Double getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(Double totalCredit) {
		this.totalCredit = totalCredit;
	}

	public Double getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(Double totalDebit) {
		this.totalDebit = totalDebit;
	}

	public Double getFinalBalance() {
		return finalBalance;
	}

	public void setFinalBalance(Double finalBalance) {
		this.finalBalance = finalBalance;
	}

	public Double getFirstBalance() {
		return firstBalance;
	}

	public void setFirstBalance(Double firstBalance) {
		this.firstBalance = firstBalance;
	}

	public List<StockLedgerListDTO> getStockLedgerItems() {
		return stockLedgerItems;
	}

	public void setStockLedgerItems(List<StockLedgerListDTO> stockLedgerItems) {
		this.stockLedgerItems = stockLedgerItems;
	}
	
	
}
