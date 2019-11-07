package com.aspl.org.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


import com.aspl.org.dto.VendorMasterDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.VendormasterService;


@RestController
@RequestMapping(path = "/vendormaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VendorController {
	
	public static final Logger logger = LoggerFactory.getLogger(VendorController.class);
	
	@Autowired VendormasterService vendorMasterService;
	
	@PostMapping("/vendormstsave")
	public ResponseDetails vendormaster(@RequestBody VendorMasterDTO vendorMasterDTO){
		vendorMasterService.vendorMasterSave(vendorMasterDTO);
		
		return new ResponseDetails(new Date(), "'"+vendorMasterDTO.getVendorName()+"' added.", null);
	}

	 
	@GetMapping(path="/getallvendorlist", produces = "application/json")
	public List<VendorMasterDTO> getallvendorlist() {
		return  vendorMasterService.getallvendorlist();
	}
	
	
	  @PutMapping("/updateVendorMaster")
	  public ResponseDetails updateVendorById(@RequestBody VendorMasterDTO vendorMasterDTO) { 
		  logger.info("Updating User with jobberCode {}");
	  
		  ResponseDetails currentVendor = vendorMasterService.vendormasterupdate(vendorMasterDTO);
		  
		  return currentVendor;
	  }
	 
	  @DeleteMapping("/deleteVendor/{vendorId}") 
	  public ResponseDetails deleteUser(@PathVariable("vendorId") String vendorId) {
		 
		  logger.info("Fetching & Deleting User with id {}", vendorId);
		  
		  return vendorMasterService.permDeleteVendorMasterById(Integer.valueOf(vendorId));
	  }
	  
	  @PutMapping("/softDeleteVendor/{vendorId}") 
	  public ResponseDetails softDeleteUser(@PathVariable("vendorId") String vendorId) {
		 
		  logger.info("Fetching & Deleting User with id {}", vendorId);
		  
		  return vendorMasterService.softDeleteVendorMasterById(Integer.valueOf(vendorId));
	  }
	  
	  @GetMapping("getVendorMasterById/{vendorId}")
	  public VendorMasterDTO getVendorMasterById(@PathVariable("vendorId") String vendorId) {
		  VendorMasterDTO vendorDTO = new VendorMasterDTO();
		  if(vendorId!=null) {
			  vendorDTO = vendorMasterService.findByVendorId(Integer.valueOf(vendorId));
		  }
		  return vendorDTO;
	  }
	 
}
