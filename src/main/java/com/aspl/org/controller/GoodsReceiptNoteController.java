package com.aspl.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.GoodsReceiptNoteHeaderDTO;
import com.aspl.org.service.GoodReceiptNoteHeaderService;

@RestController
@RequestMapping("goodReceiptNote")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GoodsReceiptNoteController {

	@Autowired
	GoodReceiptNoteHeaderService grnService;
	
	@GetMapping("getAllGoodReceiptNote")
	public List<GoodsReceiptNoteHeaderDTO> getAllGoodReceiptNote(){
		return grnService.getAllGoodsReceiptNote();
	}
	
	@GetMapping("getAllAcceptedGoodReceiptNote")
	public List<GoodsReceiptNoteHeaderDTO> getAcceptedGoodsReceiptNoteHeader() {
		return grnService.getGoodReceiptNumberByIsAccepted(1);
	}
	
	@GetMapping("getAllQcNotRequiredGoodReceiptNote")
	public List<GoodsReceiptNoteHeaderDTO> getAllQcNotRequiredGoodReceiptNote() {
		return grnService.getAllNonQcGoodsReceiptNote();
	}
	
	@GetMapping("getAllQcRequiredGoodReceiptNote")
	public List<GoodsReceiptNoteHeaderDTO> getQcRequiredGoodsReceiptNoteHeader() {
		return grnService.getGoodsReceiptNumberByQcRequired(0);
	}
	
	@PostMapping("saveGoodsReceiptNote")
	public GoodsReceiptNoteHeaderDTO saveGoodsReceiptNoteHeader(@RequestBody GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		return grnService.saveGoodsReceiptNoteHeader(goodsReceiptNoteHeaderDTO);
	}
	
	@GetMapping("getAllQcAcceptedGoodsReceiptNote")
	public List<GoodsReceiptNoteHeaderDTO> getQcAcceptedGoodsReceiptNoteHeader() {
		return grnService.getGoodsReceiptNumberByQcAccepted();
	}
	
	@PutMapping("updateGoodsReceiptNote")
	public GoodsReceiptNoteHeaderDTO updateGoodsReceiptNoteHeader(@RequestBody GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		return grnService.updateGoodsReceiptNoteHeader(goodsReceiptNoteHeaderDTO);
	}
	
	@PutMapping("authoriseGoodsReceiptNote")
	public GoodsReceiptNoteHeaderDTO authoriseGoodsReceiptNoteHeader(@RequestBody GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		return grnService.authoriseGoodsReceiptNoteHeader(goodsReceiptNoteHeaderDTO);
	}
	
	@PutMapping("acceptGoodsReceiptNote")
	public GoodsReceiptNoteHeaderDTO acceptGoodsReceiptNoteHeader(@RequestBody GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		return grnService.authoriseGoodsReceiptNoteHeader(goodsReceiptNoteHeaderDTO); 
	}
	
	@PutMapping("acceptGoodsReceiptNoteQC")
	public GoodsReceiptNoteHeaderDTO qcAcceptGoodsReceiptNote(@RequestBody GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		return grnService.qcAcceptOrRejectGoodsReceiptNoteHeader(goodsReceiptNoteHeaderDTO);
	}
	
	@PutMapping("softDeleteGoodsReceiptNote/{grnHeaderId}")
	public GoodsReceiptNoteHeaderDTO softDeleteGoodsReceiptNoteHeader(@PathVariable("grnHeaderId") Integer grnHeaderId) {
		return grnService.softDeleteGoodsReceiptNoteHeader(grnHeaderId);
	}
	
	@DeleteMapping("permDeleteGoodsReceiptNote/{grnHeaderId}")
	public GoodsReceiptNoteHeaderDTO permDeleteGoodsReceiptNote(@PathVariable("grnHeaderId") Integer grnHeaderId) {
		return grnService.permDeleteGoodsReceiptNoteHeaderDTO(grnHeaderId);
	}
	
	@GetMapping("getGoodReceiptNoteByGrnId/{grnId}")
	public GoodsReceiptNoteHeaderDTO getGoodReceiptNoteByGrnNo(@PathVariable("grnId") String grnId) {
		return grnService.getGoodsReceiptNoteByGrnId(Integer.valueOf(grnId));
	}
	
}
