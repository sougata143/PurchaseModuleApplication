package com.aspl.org.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.FinishedGoodsTransactionDTO;
import com.aspl.org.dto.RawMaterialTransactionDTO;
import com.aspl.org.dto.StoreDetailsDTO;
import com.aspl.org.entity.StoreDetails;
import com.aspl.org.service.FinishedGoodsTransactionService;
import com.aspl.org.service.RawMaterialTransactionService;
import com.aspl.org.service.StoreDetailsService;

@RestController
@RequestMapping(path = "/store")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StoreController {
	public static final Logger logger = LoggerFactory.getLogger(StoreController .class);

	@Autowired
	StoreDetailsService storeService;
	
	@Autowired
	RawMaterialTransactionService rawMaterialTransService;
	
	@Autowired
	FinishedGoodsTransactionService finishedGoodsTransService;


	  @GetMapping(path="/getAllStoreList", produces = "application/json")	  
	  public List<StoreDetailsDTO> getAllStoreList() {
		  
		  return storeService.getAllStoreList();
		  
	  }

	  @GetMapping("/getStoreDetailsByCode/{itemCode}")
	  public List<StoreDetailsDTO> getByCode(@PathVariable String itemCode) {
		  //("itemCode: "+itemCode);
		  
		  return storeService.findStoreDetailsByItemCode(itemCode);
		  
	  }
	 
	  @GetMapping("/getStoreDetailsByItemName/{itemName}")
	  public StoreDetailsDTO getByItemName(@PathVariable String itemName) {
		 // ("itemName: "+itemName);
		  
		  return storeService.findStoreDetailsByItemName(itemName);
		  
	  }
	  
	  @GetMapping("/getStoreDetailsByItemId/{itemId}")
	  public List<StoreDetailsDTO> getByItemId(@PathVariable Integer itemId) {
		 // ("itemName: "+itemName);
		  
		  return storeService.findStoreDetailsByItemId(itemId);
		  
	  }
	  
	  @GetMapping("/getExpiredStore")
	  public List<StoreDetailsDTO> getExpiredStore() {
		 // ("itemName: "+itemName);
		  
		  return storeService.findExpiredStoreDetails();
		  
	  }
	  
	  @GetMapping("/getCloseToExpiredStore")
	  public List<StoreDetailsDTO> getCloseToExpireStore() {
		 // ("itemName: "+itemName);
		  return storeService.findCloseToExpireStoreDetails();
		  
	  }
	  
	  @PutMapping("/dumpExpiredItems/{storeId}")
	  public StoreDetails dumpExpiredItem(@PathVariable("storeId") Integer storeId) {
		  return storeService.dumpExpiredStore(storeId);
	  }
	  
	  @GetMapping("/getFinishedGoodsTransactionByItem/{itemId}")
	  public List<FinishedGoodsTransactionDTO> getFinishedGoodsTransactionByItem(@PathVariable("itemId") Integer itemId) {
		 // ("itemName: "+itemName);
		  
		  return finishedGoodsTransService.getAllFinishedGoodsTransactionByItemId(itemId);
		  
	  }
	  
	  @GetMapping("/getRawMaterialTransactionByItem/{itemId}")
	  public List<RawMaterialTransactionDTO> getRawMaterialTransactionByItem(@PathVariable("itemId") Integer itemId) {
		 // ("itemName: "+itemName);
		  
		  return rawMaterialTransService.getAllRawMaterialTransaction();
		  
	  }
	  
}

