package com.aspl.org.dto;

import com.aspl.org.entity.UomMaster;

public class SoDetailsDTO {
	
    private Integer id;
	
    private Integer soid;
    private String serviceDescription;
    private Double qty;
	private Double price;
	private Double amount;
	private Double disc;
	private Double assesValue;
	private UomMaster unit;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSoid() {
		return soid;
	}
	public void setSoid(Integer soid) {
		this.soid = soid;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
	public UomMaster getUnit() {
		return unit;
	}
	public void setUnit(UomMaster unit) {
		this.unit = unit;
	}
	
	
}
