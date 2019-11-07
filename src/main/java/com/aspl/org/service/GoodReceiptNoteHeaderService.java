package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.GoodReceiptNoteItemDetailsDTO;
import com.aspl.org.dto.GoodsReceiptNoteHeaderDTO;
import com.aspl.org.entity.GoodReceiptNoteItemDetails;

public interface GoodReceiptNoteHeaderService {

	List<GoodsReceiptNoteHeaderDTO> getAllGoodsReceiptNote();
	GoodsReceiptNoteHeaderDTO getGoodsReceiptNoteByGrnNo(String grn);
	GoodsReceiptNoteHeaderDTO getGoodsReceiptNoteById(Integer grnId);
	List<GoodsReceiptNoteHeaderDTO> getGoodsReceiptNoteByIsActive(Integer isActive);
	List<GoodsReceiptNoteHeaderDTO> getGoodReceiptNumberByIsAccepted(Integer isAccepted);
	List<GoodsReceiptNoteHeaderDTO> getGoodsReceiptNumberByQcRequired(Integer qcRequired);
	List<GoodsReceiptNoteHeaderDTO> getAuthorisedGoodsReceiptNumber();
	List<GoodsReceiptNoteHeaderDTO> getUnAuthorisedGoodsReceiptNumber();
	List<GoodsReceiptNoteHeaderDTO> getGoodsReceiptNumberByQcAccepted();
	List<GoodsReceiptNoteHeaderDTO> getGoodsReceiptNumberByQcRejected();
	
	GoodsReceiptNoteHeaderDTO saveGoodsReceiptNoteHeader(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO);
	GoodsReceiptNoteHeaderDTO updateGoodsReceiptNoteHeader(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO);
	
	void deleteGoodsReceiptNoteHeaderDTO(Integer grnId);
	GoodsReceiptNoteHeaderDTO softDeleteGoodsReceiptNoteHeader(Integer grnId);
	GoodsReceiptNoteHeaderDTO permDeleteGoodsReceiptNoteHeaderDTO(Integer grnId);
	
//	GoodsReceiptNoteHeaderDTO prepareGoodsReceiptNoteHeaderDTO(GoodsRecieptNoteHeader goodsRecieptNoteHeader, String grnAccess);
//	GoodsRecieptNoteHeader prepareGoodsReceiptNoteEntity(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO);
	
	GoodsReceiptNoteHeaderDTO authoriseGoodsReceiptNoteHeader(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO);
	GoodsReceiptNoteHeaderDTO qcAcceptOrRejectGoodsReceiptNoteHeader(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO);
	public GoodReceiptNoteItemDetails saveGoodReceiptNote(GoodReceiptNoteItemDetailsDTO detailsDTO);
//	GoodsReceiptNoteHeaderDTO acceptGoodsReceiptNoteHeader(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO);
//	GoodsReceiptNoteHeaderDTO prepareAuthorizedGoodsReceiptNoteHeaderDTO(GoodsRecieptNoteHeader goodsRecieptNoteHeader);
//	GoodsReceiptNoteHeaderDTO prepareUnAuthorizedGoodsReceiptNoteHeaderDTO(
//			GoodsRecieptNoteHeader goodsRecieptNoteHeader);
//	GoodsReceiptNoteHeaderDTO prepareGoodsReceiptNoteHeaderRequiredQcDTO(GoodsRecieptNoteHeader goodsRecieptNoteHeader);
//	GoodsReceiptNoteHeaderDTO prepareAuthorizedGoodsReceiptNoteHeaderQcAcceptDTO(
//			GoodsRecieptNoteHeader goodsRecieptNoteHeader);
	GoodsReceiptNoteHeaderDTO getGoodsReceiptNoteByGrnId(Integer grnId);
	List<GoodsReceiptNoteHeaderDTO> getAllNonQcGoodsReceiptNote();
	
	
}
