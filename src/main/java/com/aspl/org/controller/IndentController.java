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

import com.aspl.org.dto.IndentDTO;
import com.aspl.org.entity.Indent;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.IndentService;


@RestController
@RequestMapping(path = "/indent")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndentController {
	public static final Logger logger = LoggerFactory.getLogger(IndentController.class);

	@Autowired
	IndentService indentService;
	

	@PostMapping("/indententry")
	public ResponseDetails indentGenerate(@RequestBody IndentDTO indent) throws Exception{

		ResponseDetails responseDetails=indentService.indentSave(indent);
		return responseDetails;
		
	}
		
	@PutMapping("/indentUpdate")
	public ResponseDetails indentUpdate(@RequestBody IndentDTO indent) throws Exception{
		ResponseDetails responseDetails=indentService.indentSave(indent);
			return responseDetails;
	}
	
	

	@PutMapping("/indentAuthorised")
	public ResponseDetails indentAuthorised(@RequestBody IndentDTO indentDTO) throws Exception{
		
		return indentService.indentAuthorised(indentDTO);
		
	}

	@PutMapping("/indentUnauthorised")
	public ResponseDetails indentUnauthorised(@RequestBody IndentDTO indentDTO) throws Exception{
		return indentService.indentUnauthorised(indentDTO);
	}
	
	
	
	 @GetMapping(path="/getAllAuthorisedIndent", produces = "application/json")
	 public List<IndentDTO> getAllAuthorisedIndent() throws Exception{
	  
		 List<IndentDTO> indentList = indentService.getAllAuthorisedIndent();
	  
		 return indentList;
	  }
	
	  @GetMapping(path="/getAllUnauthorisedIndent", produces = "application/json")
	  public List<IndentDTO> getAllUnauthorisedIndent() throws Exception{
	  
		  List<IndentDTO> indentList = indentService.getAllUnauthorisedIndent();
	  
		  return indentList; 
	  }
	 
	
	@GetMapping(path="/getAllIndent", produces = "application/json")
	public List<IndentDTO>  getAllIndent() throws Exception{
		
		List<IndentDTO> indentList = indentService.getAllIndent();
			
		return indentList;
	}
	
	@GetMapping("/getIndentByIndentId/{indentId}")
	public IndentDTO  getAuthorisedIndenByIndentId(@PathVariable("indentId") Integer indentId) throws Exception{
		
		IndentDTO indent = indentService.getIndentByIndentId(indentId);
			
		return indent;
		
	}
	
	@PutMapping("softDeleteIndent/{indentId}")
	public Indent softDeleteIndent(@PathVariable("indentId") Integer indentId) {
		return indentService.softDeleteIndent(indentId);
	}
	
}

