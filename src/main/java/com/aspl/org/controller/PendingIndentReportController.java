package com.aspl.org.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PendingIndentReportController 
{
	
	
	
	
	
//	final static Logger logger = Logger.getLogger(PendingIndentReportController.class);
	
	
	
	@RequestMapping(value = "/show_all_Order_StockisttoCNF", method = RequestMethod.GET)
	public String ShowallOrderBucketPlace(Model model ) {

		
		
		return "stockisttoCNFordercompletelist";

	}
	
	
	@RequestMapping(value = { "/stockistOrdercompleteList-{ordBookingId}" }, method = RequestMethod.GET)
	public String stockistOrderList(@PathVariable String ordBookingId,ModelMap model) {

		
		
		
		return "stockistorderdetailslist";
	}
	
	
	
	
}