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

@Entity
@Table(name = "Serviceorder_details")

public class ServiceorderDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
    private Integer soid;
	@Column(name = "service_description")
	private String serviceDescription;
	
	private Double qty;
	private Double price;
	private Double amount;
	private Double disc;
	private Double assesValue;
	private String unit;
	private Date createdDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="soid",insertable=false,updatable=false)
	Serviceorder serviceorder;

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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Serviceorder getServiceorder() {
		return serviceorder;
	}

	public void setServiceorder(Serviceorder serviceorder) {
		this.serviceorder = serviceorder;
	}


	
}
