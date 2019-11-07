package com.aspl.org.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.report.service.ServiceOrderReportPdfGenService;


@RestController
@RequestMapping("serviceOrderReport/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServiceOrderReportController {
	
	@Autowired
	ServiceOrderReportPdfGenService soReportService;

	
	
	@GetMapping("getServiceOrderReport/{soid}")
	Map<String, Object> getServiceOrderReportDTO(HttpServletRequest request, @PathVariable("soid") String soid) {
		
		return soReportService.getServiceOrderReport(request, soid);
	}
	
}
