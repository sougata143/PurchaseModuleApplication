package com.aspl.org.dto;

import java.util.Date;

import com.aspl.org.entity.UomMaster;

public class PurchaseDetailsDTO {

	private Integer id;
	
    private Integer poid;
    
    private ItemForCategoryMapDTO itemCode;
	
    private String description;
	private String make;
	private Double indentReqQty;
	private Double weight;
	private Double purQty;
	
	private UomMaster purUom;
	
	private Double purPrice;
	private Double total;
	private Double disc;
	private Double assesValue;
	private String qcSpec;
	private String remarks;
	private String accountsHead;
	private String tariff;
	
	private UomMaster baseUom;
	
	private Double convQty;
	private Double reorderLevel;
	private Double maxQty;
	private Double minQty;
	private Double pendingIndentQty;
	private Double pendingPurQty;
	private String pendingSale;
	
	private String rateType;
	private Double availableStock;
	private Date createdDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPoid() {
		return poid;
	}
	public void setPoid(Integer poid) {
		this.poid = poid;
	}
	public ItemForCategoryMapDTO getItemCode() {
		return itemCode;
	}
	public void setItemCode(ItemForCategoryMapDTO itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public Double getIndentReqQty() {
		return indentReqQty;
	}
	public void setIndentReqQty(Double indentReqQty) {
		this.indentReqQty = indentReqQty;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getPurQty() {
		return purQty;
	}
	public void setPurQty(Double purQty) {
		this.purQty = purQty;
	}
	public UomMaster getPurUom() {
		return purUom;
	}
	public void setPurUom(UomMaster purUom) {
		this.purUom = purUom;
	}
	public Double getPurPrice() {
		return purPrice;
	}
	public void setPurPrice(Double purPrice) {
		this.purPrice = purPrice;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getDisc() {
		return disc;
	}
	public void setDisc(Double disc) {
		this.disc = disc;
	}
	public Double getAssesValue() {
		return assesValue;
	}
	public void setAssesValue(Double assesValue) {
		this.assesValue = assesValue;
	}
	public String getQcSpec() {
		return qcSpec;
	}
	public void setQcSpec(String qcSpec) {
		this.qcSpec = qcSpec;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAccountsHead() {
		return accountsHead;
	}
	public void setAccountsHead(String accountsHead) {
		this.accountsHead = accountsHead;
	}
	public String getTariff() {
		return tariff;
	}
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	public UomMaster getBaseUom() {
		return baseUom;
	}
	public void setBaseUom(UomMaster baseUom) {
		this.baseUom = baseUom;
	}
	public Double getConvQty() {
		return convQty;
	}
	public void setConvQty(Double convQty) {
		this.convQty = convQty;
	}
	public Double getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(Double reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public Double getMaxQty() {
		return maxQty;
	}
	public void setMaxQty(Double maxQty) {
		this.maxQty = maxQty;
	}
	public Double getMinQty() {
		return minQty;
	}
	public void setMinQty(Double minQty) {
		this.minQty = minQty;
	}
	public Double getPendingIndentQty() {
		return pendingIndentQty;
	}
	public void setPendingIndentQty(Double pendingIndentQty) {
		this.pendingIndentQty = pendingIndentQty;
	}
	public Double getPendingPurQty() {
		return pendingPurQty;
	}
	public void setPendingPurQty(Double pendingPurQty) {
		this.pendingPurQty = pendingPurQty;
	}
	public String getPendingSale() {
		return pendingSale;
	}
	public void setPendingSale(String pendingSale) {
		this.pendingSale = pendingSale;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public Double getAvailableStock() {
		return availableStock;
	}
	public void setAvailableStock(Double availableStock) {
		this.availableStock = availableStock;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	
		
}
