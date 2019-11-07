package com.aspl.org.dto;

import java.util.List;

public class GoodsReceiptNoteDTO {

	private GoodsReceiptNoteHeaderDTO grnHeader;
	private List<GoodReceiptNoteItemDetailsDTO> grnDetails;
	
	public GoodsReceiptNoteHeaderDTO getGrnHeader() {
		return grnHeader;
	}
	public void setGrnHeader(GoodsReceiptNoteHeaderDTO grnHeader) {
		this.grnHeader = grnHeader;
	}
	public List<GoodReceiptNoteItemDetailsDTO> getGrnDetails() {
		return grnDetails;
	}
	public void setGrnDetails(List<GoodReceiptNoteItemDetailsDTO> grnDetails) {
		this.grnDetails = grnDetails;
	}
	
	
}
