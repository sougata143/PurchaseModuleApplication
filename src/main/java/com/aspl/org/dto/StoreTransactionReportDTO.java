package com.aspl.org.dto;

import java.util.List;

public class StoreTransactionReportDTO {

	private Double totalOpeningStock;
	private Double totalClosingStock;
	private Double totalCredit;
	private Double totalDebit;
	
	private List<FinishedGoodsTransactionDTO> finishedGoodsTransactions;
	private List<RawMaterialTransactionDTO> rawMaterialTransactions;
	public Double getTotalOpeningStock() {
		return totalOpeningStock;
	}
	public void setTotalOpeningStock(Double totalOpeningStock) {
		this.totalOpeningStock = totalOpeningStock;
	}
	public Double getTotalClosingStock() {
		return totalClosingStock;
	}
	public void setTotalClosingStock(Double totalClosingStock) {
		this.totalClosingStock = totalClosingStock;
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
	public List<FinishedGoodsTransactionDTO> getFinishedGoodsTransactions() {
		return finishedGoodsTransactions;
	}
	public void setFinishedGoodsTransactions(List<FinishedGoodsTransactionDTO> finishedGoodsTransactions) {
		this.finishedGoodsTransactions = finishedGoodsTransactions;
	}
	public List<RawMaterialTransactionDTO> getRawMaterialTransactions() {
		return rawMaterialTransactions;
	}
	public void setRawMaterialTransactions(List<RawMaterialTransactionDTO> rawMaterialTransactions) {
		this.rawMaterialTransactions = rawMaterialTransactions;
	}
	
	
	
}
