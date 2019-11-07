package com.aspl.org.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponseDetails {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	  private Date timestamp;
	  private String message;
	  private String details;
	  private Double status;
	  
	  public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Double getStatus() {
		return status;
	}

	public void setStatus(Double status) {
		this.status = status;
	}

	public ResponseDetails(Date timestamp, String message, String details) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	    this.details = details;
	  }

	public ResponseDetails(Date timestamp, String message, String details, ResponseDetails responseDetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.status =(double)status;
	}
	
	
	public ResponseDetails(Date timestamp, String message, String details, int status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.status = (double)status;
	}
	
	/*
	 * public ResponseDetails(Date timestamp, String message, Object object,
	 * ResponseDetails indentAuthorisationUpdate) { // TODO Auto-generated
	 * constructor stub }
	 */


	@Override
	public String toString() {
		return "ResponseDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + ", status="
				+ status + "]";
	}
	
}
