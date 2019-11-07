package com.aspl.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.StoreTransactionReportDTO;
import com.aspl.org.service.StoreReportService;

@RestController
@RequestMapping(path = "/storeReport")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StoreReportController {

	@Autowired
	StoreReportService storeReportService;
	
	
	@GetMapping("getStoreTransactionReport/{itemId}")
	public StoreTransactionReportDTO getStoreTransactionReport(@PathVariable("itemId") Integer itemId) {
		return storeReportService.getStoreTransactionReportDTO(itemId);
	}
	
}
