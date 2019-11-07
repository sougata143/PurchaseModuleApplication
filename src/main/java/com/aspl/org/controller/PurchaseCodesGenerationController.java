package com.aspl.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.service.PurchaseCodesGenerationService;

@RestController
@RequestMapping(path = "/purchaseCodeGeneration")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseCodesGenerationController {

	@Autowired
	PurchaseCodesGenerationService purchaseCodesGenerationService;
	
	@GetMapping("generatePurchaseOrderCode")
	public String generatePurchaseOrderCode() {
		return purchaseCodesGenerationService.generatePurchaseOrderCode();
	}
	
	@GetMapping("generateIndentCode")
	public String generateIndentCode() {
		return purchaseCodesGenerationService.generateIndentCode();
	}
	
	@GetMapping("generateGrnCode")
	public String generateGrnCode() {
		return purchaseCodesGenerationService.generateGrnCode();
	}
	
	@GetMapping("generateServiceOrderCode")
	public String generateServiceOrderCode() {
		return purchaseCodesGenerationService.generateServiceOrderCode();
	}
	
	@GetMapping("generateItemCode/{categoryId}")
	public String generateItemCode(@PathVariable("categoryId") String categoryId) {
		return purchaseCodesGenerationService.generateItemCode(categoryId);
	}
	
	@GetMapping("generateVendorCode")
	public String generateVendorCode() {
		return purchaseCodesGenerationService.generateVendorCode();
	}
	
}
