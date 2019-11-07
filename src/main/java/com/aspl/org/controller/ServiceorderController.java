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
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.ServiceorderDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.ServiceorderService;

@RestController
@RequestMapping(path = "/serviceorder")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServiceorderController {
	
	public static final Logger logger = LoggerFactory.getLogger(ServiceorderController.class);
	
	@Autowired
	ServiceorderService serviceorderService;
	
	@PostMapping("/serviceOrdersSave")
	public ResponseDetails serviceorderSave(@RequestBody ServiceorderDTO serviceorderDTO) throws Exception{
		logger.info("ordersSave: " +serviceorderDTO.toString());
		ResponseDetails responseDetails=serviceorderService.serviceorderSave(serviceorderDTO);
			
		return responseDetails;
		
	}
	
	@GetMapping(path="/getAllServiceOrder", produces = "application/json")
	public List<ServiceorderDTO>  getAllServiceOrder() throws Exception{
		
		List<ServiceorderDTO> serviceorderList = serviceorderService.getAllServiceOrder();
			
		return serviceorderList;
	}
	
	@GetMapping("getAllActiveServiceOrder")
	public List<ServiceorderDTO> getAllActiveServiceOrders(){
		return serviceorderService.getAllActiveServiceOrder();
	}
	
	@GetMapping("getServiceOrderById/{id}") 
	public ServiceorderDTO getServiceOrderById(@PathVariable("id") Integer id){ 
		  
		return serviceorderService.findByServiceorderId(id); 
	}
	
	@PutMapping("softDeleteServiceorder/{serviceorderId}")
	public ResponseDetails softDeleteServiceorder(@PathVariable("serviceorderId") String serviceorderId) {
		return serviceorderService.softDeleteServiceOrder(Integer.valueOf(serviceorderId));
	}
	
	@PutMapping("updateServiceOrder")
	public ResponseDetails updateServiceOrder(@RequestBody ServiceorderDTO serviceorderDTO) throws Exception {
		return serviceorderService.serviceorderUpdate(serviceorderDTO);
	}

}
