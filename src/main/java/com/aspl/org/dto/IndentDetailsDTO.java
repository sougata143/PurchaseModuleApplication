package com.aspl.org.dto;

import java.util.Date;

import com.aspl.org.entity.UomMaster;
import com.fasterxml.jackson.annotation.JsonFormat;

public class IndentDetailsDTO {

	private Integer id;
	private Integer indentId;
	private ItemMasterDTO item;
	private String description;
	private UomMaster purUom;
	private Double reqQty;
	private Double itemValue;
	private String costCentre;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date reqDate;
	private String reason;
	private String drawingInfo;
	private UomMaster baseUom;
	private Double convQty;
	private Double availableQty;
	private Double reorderLevel;
	private Double maxQty;
	private Double minQty;
	private Double pendingIndentQty;
	private Double pendingPurQty;
	private Double pendingSale;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIndentId() {
		return indentId;
	}
	public void setIndentId(Integer indentId) {
		this.indentId = indentId;
	}
	public ItemMasterDTO getItem() {
		return item;
	}
	public void setItem(ItemMasterDTO item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UomMaster getPurUom() {
		return purUom;
	}
	public void setPurUom(UomMaster purUom) {
		this.purUom = purUom;
	}
	public Double getReqQty() {
		return reqQty;
	}
	public void setReqQty(Double reqQty) {
		this.reqQty = reqQty;
	}
	public Double getItemValue() {
		return itemValue;
	}
	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}
	public String getCostCentre() {
		return costCentre;
	}
	public void setCostCentre(String costCentre) {
		this.costCentre = costCentre;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDrawingInfo() {
		return drawingInfo;
	}
	public void setDrawingInfo(String drawingInfo) {
		this.drawingInfo = drawingInfo;
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
	public Double getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(Double availableQty) {
		this.availableQty = availableQty;
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
	public Double getPendingSale() {
		return pendingSale;
	}
	public void setPendingSale(Double pendingSale) {
		this.pendingSale = pendingSale;
	}
	
	
}
