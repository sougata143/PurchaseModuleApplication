package com.aspl.org.entity;

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
@Table(name="Gst_State_Code")
public class StateCodeDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer stateCode;
	private String stateName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="stateCode",insertable=false,updatable=false)
	Purchase purchaseOrder;
	
	
	public StateCodeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StateCodeDetails(int stateCode, String stateName) {
		super();
		this.stateCode = stateCode;
		this.stateName = stateName;
	}


	public int getStateCode() {
		return stateCode;
	}


	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}



}
