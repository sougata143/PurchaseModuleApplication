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

import com.aspl.org.entity.JobberMaster;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.JobbermasterService;


@RestController
@RequestMapping(path = "/jobbermaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobberController {
	
	public static final Logger logger = LoggerFactory.getLogger(JobberController.class);
	
@Autowired JobbermasterService jobberMasterService;

	@PostMapping("/jobbermstsave")
	public ResponseDetails jobbermaster(@RequestBody JobberMaster jobberMaster){
		
		
		if(jobberMasterService.findByJobberName(jobberMaster.getJobberName())!=null) {
			return new ResponseDetails(new Date(), "Sorry '"+jobberMaster.getJobberName()+"' already exist.", null);
		}else if(jobberMasterService.findByJobberCode(jobberMaster.getJobberCode())!=null) {
				return new ResponseDetails(new Date(), "Sorry '"+jobberMaster.getJobberCode()+"' already exist.", null);
			}
			jobberMasterService.jobberMasterSave(jobberMaster);
			return new ResponseDetails(new Date(), "'"+jobberMaster.getJobberName()+"' added.", null);
	}
	
	
	  @GetMapping("/getByCode/{jobberCode}")
	  public JobberMaster getByCode(@PathVariable String jobberCode) {
		  
		  
		  return jobberMasterService.findByJobberCode(jobberCode);
		  
	  }
	 
	  @GetMapping("/getByName/{jobberName}")
	  public JobberMaster getByName(@PathVariable String jobberName) {
		  
		  
		  return jobberMasterService.findByJobberName(jobberName);
		  
	  }
	  
	  
	@GetMapping(path="/getalljobberlist", produces = "application/json")
	public List<JobberMaster> getalljobberlist() {
		
		return  jobberMasterService.getalljobberlist();
	}
	
	/*
	 * @PostMapping("/updateitemmaster/{itemCode}") public ItemMaster
	 * updateitemmaster(@PathVariable(value="itemCode") String
	 * itemCode, @RequestBody ItemMaster itemMaster) { ItemMaster itemMaster1 =
	 * itemMasterService.findByItemCode(itemCode);
	 * 
	 * return itemMasterService.itemmasterupdate(itemMaster1); }
	 */
	// ------------------- Update a User ------------------------------------------------
	
	@PutMapping("/jobberMasterUpdateByCode/{jobberCode}")
	public JobberMaster updateJobberById(@PathVariable("jobberCode") String jobberCode, @RequestBody JobberMaster jobberMaster) {
		logger.info("Updating User with jobberCode {}", jobberCode);

		JobberMaster currentJobber = jobberMasterService.findByJobberCode(jobberCode);

		if (currentJobber == null) {
			logger.error("Unable to update. User with jobberCode {} not found.", jobberCode);
			//return "Unable to upate. User with itemCode " + itemCode + " not found."),HttpStatus.NOT_FOUND);
			return jobberMaster;
		}

		currentJobber.setJobberName(jobberMaster.getJobberName());
		//currentJobber.setCateg(jobberMaster.getCategory());
		//currentJobber.setRemarks(jobberMaster.getRemarks());
		//currentItem.setRate(itemMaster.getRate());

		jobberMasterService.jobberMasterUpdate(currentJobber);
		return currentJobber;
	}
	
	
	// ------------------- Delete a User-----------------------------------------
	/*
	 * @DeleteMapping("/deleteItemById/{itemCode}") public String
	 * deleteUser(@PathVariable("itemCode") String itemCode) {
	 * logger.info("Fetching & Deleting User with id {}", itemCode);
	 * ("deleteItemById...."); Optional<ItemMaster> itemMaster =
	 * itemMasterService.findByItemCode(itemCode);
	 * ("itemMaster delete: "+itemMaster.get().getItemCode()); if
	 * (itemMaster == null) {
	 * logger.error("Unable to delete. User with id {} not found.", itemCode);
	 * return "Unable to delete. User with id " + itemCode + " not found."; }
	 * itemMasterService.deleteItemMasterById(itemMaster.get().getId());
	 * ("itemMaster: "+itemMaster.toString()); return
	 * "delete. User with id " + itemCode; }
	 */

	@DeleteMapping("/deleteJobberById/{jobberCode}")
	public String deleteUser(@PathVariable("jobberCode") String jobberCode) {
			logger.info("Fetching & Deleting User with id {}", jobberCode);
			
			JobberMaster jobberMaster = jobberMasterService.findByJobberCode(jobberCode);
			if (jobberMaster == null) {
				logger.error("Unable to delete. User with id {} not found.", jobberCode);
				return "Unable to delete. User with id " + jobberCode + " not found.";
			}
			jobberMasterService.deleteJobberMasterById(jobberMaster.getId());
			
			return "delete. User with jobberCode " + jobberCode;
		}
}
