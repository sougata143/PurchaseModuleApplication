package com.aspl.org.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Indent_details")

public class IndentDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="indent_id")
	private Integer indentId;
	private String itemCode;
	private String description;
	private String purUom;
	private Double reqQty;
//	private Double itemValue;
//	private String costCentre;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date reqDate;
	private String reason;
	private String drawingInfo;
	private String baseUom;
	private Double convQty;
	private Double availableQty;
	private Double reorderLevel;
	private Double maxQty;
	private Double minQty;
	private Double pendingIndentQty;
	private Double pendingPurQty;
	private Double pendingSale;
	private Integer itemId;

	private Integer indentItemStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="indent_id",insertable=false,updatable=false)
	Indent indent;
	
	
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


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPurUom() {
		return purUom;
	}


	public void setPurUom(String purUom) {
		this.purUom = purUom;
	}


	public Double getReqQty() {
		return reqQty;
	}


	public void setReqQty(Double reqQty) {
		this.reqQty = reqQty;
	}


//	public Double getItemValue() {
//		return itemValue;
//	}


//	public void setItemValue(Double itemValue) {
//		this.itemValue = itemValue;
//	}


//	public String getCostCentre() {
//		return costCentre;
//	}


//	public void setCostCentre(String costCentre) {
//		this.costCentre = costCentre;
//	}


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


	public String getBaseUom() {
		return baseUom;
	}


	public void setBaseUom(String baseUom) {
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


	public Indent getIndent() {
		return indent;
	}


	public void setIndent(Indent indent) {
		this.indent = indent;
	}


	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	
	public Integer getIndentItemStatus() {
		return indentItemStatus;
	}


	public void setIndentItemStatus(Integer indentItemStatus) {
		this.indentItemStatus = indentItemStatus;
	}


     
}
