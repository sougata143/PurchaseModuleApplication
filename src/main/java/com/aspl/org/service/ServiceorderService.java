package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aspl.org.dto.ServiceorderDTO;
import com.aspl.org.dto.SoDetailsDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.Serviceorder;
import com.aspl.org.entity.ServiceorderDetails;

@Service
public interface ServiceorderService  {
	
	ResponseDetails serviceorderSave(ServiceorderDTO serviceorderDTO) throws Exception;
	ResponseDetails serviceorderUpdate(ServiceorderDTO serviceorderDTO) throws Exception;
	
	ServiceorderDTO findByServiceorderCode(String serviceCode);
	List<ServiceorderDTO> getAllServiceOrder();
	List<ServiceorderDTO> getAllActiveServiceOrder();
	ServiceorderDTO findByServiceorderId(Integer serviceorderId);
	
	ServiceorderDTO prepareServiceorderDTO(Serviceorder serviceorder);
	Serviceorder prepareServiceorderEntity(ServiceorderDTO serviceorderDTO);
	
	SoDetailsDTO prepareSoDetailsDTO(ServiceorderDetails serviceorderDetails);
	ServiceorderDetails prepareSoDetailsEntity(SoDetailsDTO serviceorderDetailsDTO);
	ResponseDetails softDeleteServiceOrder(Integer serviceorderId);
	
	

}
