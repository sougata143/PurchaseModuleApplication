package com.aspl.org.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.aspl.org.dto.PriceHistoryDTO;
import com.aspl.org.dto.PurchaseDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.PurchaseService;



@RestController
@RequestMapping(path = "/purchase")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseController {
	public static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	PurchaseService purchaseService;
	

	@PostMapping("/purchaseOrdersSave")	
	public ResponseDetails purchaseSave(@RequestBody PurchaseDTO purchaseDTO) throws Exception{
		logger.info("ordersSave: " +purchaseDTO.toString());
		ResponseDetails responseDetails=purchaseService.purchaseSave(purchaseDTO);
			
		return responseDetails;
		
	}
	
	@PutMapping("/purchaseOrderAuthorise")
	public ResponseDetails indentAuthorised(@RequestBody PurchaseDTO purchaseDTO) throws Exception{
		
		return purchaseService.purchaseAuthorised(purchaseDTO);
		//return new ResponseDetails(new Date(), "'"+iId+"' authorised.", null);
	}
	@PutMapping("/purchaseOrderUnauthorise")
	public ResponseDetails indentUnauthorised(@RequestBody PurchaseDTO purchaseDTO) throws Exception{
		
		return purchaseService.purchaseUnauthorised(purchaseDTO);
		//return new ResponseDetails(new Date(), "'"+iId+"' authorised.", null);
	}
	
	
	@GetMapping(path="/getAllPurchaseForAuthorisation", produces = "application/json")
	public List<PurchaseDTO>  getAllPurchaseForAuthorisation() throws Exception{
		
		List<PurchaseDTO> purchaseList = purchaseService.getAllPurchaseForAuthorisation();
			
		return purchaseList;
	}
	
	@GetMapping(path="/getPurchaseForAuthorisation", produces = "application/json")
	public PurchaseDTO  getPurchaseForAuthorisation(@RequestParam("purchaseCode") String purchaseCode) throws Exception{
		
		PurchaseDTO purchaseOrder = purchaseService.findByPurchaseCode(purchaseCode);
			
		return purchaseOrder;
		
	}
	
	@GetMapping("getAllActivePurchaseOrder")
	public List<PurchaseDTO> getAllActivePurchaseOrders(){
		return purchaseService.getAllActivePurchaseOrder();
	}
	
	@GetMapping("getAllAuthorisedPurchaseOrder")
	public List<PurchaseDTO> getAllAuthorisedPurchaseOrders(){
		return purchaseService.getAllAuthorisedPurchaseOrder();
	}
	
	@GetMapping("getPurchaseOrderById/{id}") public PurchaseDTO getPurchaseOrderById(@PathVariable("id") Integer id){ 
		  
		return purchaseService.findByPurchaseId(id); 
	}
	
	@PutMapping("updatePurchaseOrder")
	public ResponseDetails updatePurchaseOrder(@RequestBody PurchaseDTO purchaseDTO) throws Exception {
		return purchaseService.purchaseUpdate(purchaseDTO);
	}
	
	@PutMapping("softDeletePurchase/{id}")
	public PurchaseDTO softDeletePurchase(@PathVariable("id") Integer Id) {
		return purchaseService.softDeleteItem(Id);
	}
	
	@GetMapping("getPurchasePriceForItem/{itemId}")
	public List<PriceHistoryDTO> getPurchasePriceForItem(@PathVariable("itemId") Integer itemId) {
		return purchaseService.getPurchasePriceForItem(itemId);
	}
	 
}

