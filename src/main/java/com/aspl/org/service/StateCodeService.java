package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.StateCodeDTO;

public interface StateCodeService {

	List<StateCodeDTO> getAllStateCode();
	StateCodeDTO getStateCodeById(Integer stateId);
	StateCodeDTO getStateCodeByCode(String code);
	StateCodeDTO saveStateCode(StateCodeDTO stateCodeDTO);
	StateCodeDTO updateStateCode(StateCodeDTO stateCodeDTO);
	void deleteStateCode(Integer stateId);
	
}
