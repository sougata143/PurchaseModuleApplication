package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.StateCodeDTO;
import com.aspl.org.entity.StateCodeMaster;
import com.aspl.org.repository.StateCodeRepository;
import com.aspl.org.service.StateCodeService;

/*
 * Service for State code master CRUD operations
 */
@Service
@Transactional
public class StateCodeServiceImpl implements StateCodeService {
	
	@Autowired
	StateCodeRepository stateRepo;

	/*
	 * Method for fetching all state codes
	 * 
	 *  @Return List<StateCodeDTO>
	 */
	@Override
	public List<StateCodeDTO> getAllStateCode() {
		// TODO Auto-generated method stub
		List<StateCodeDTO> stateCodeDTOs = new ArrayList<>();
		try {
			List<StateCodeMaster> stateMaster = stateRepo.findAll();
			for(StateCodeMaster sc : stateMaster) {
				StateCodeDTO stateCodeDTO = new StateCodeDTO();
				stateCodeDTO.setStateCode(sc.getStateCode());
				stateCodeDTO.setStateId(sc.getStateId());
				stateCodeDTO.setStateName(sc.getStateName());
				stateCodeDTOs.add(stateCodeDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stateCodeDTOs;
	}

	/*
	 * @Param stateId
	 * 
	 * Method for getting state code by id
	 * 
	 * @Return StateCodeDTO
	 */
	@Override
	public StateCodeDTO getStateCodeById(Integer stateId) {
		// TODO Auto-generated method stub
		StateCodeDTO stateCodeDTO = new StateCodeDTO();
		try {
			StateCodeMaster stateCodeMaster = stateRepo.findById(stateId).get();
			stateCodeDTO.setStateCode(stateCodeMaster.getStateCode());
			stateCodeDTO.setStateId(stateId);
			stateCodeDTO.setStateName(stateCodeMaster.getStateName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stateCodeDTO;
	}

	/*
	 * @Param code
	 * 
	 * Method for getting state code by code
	 * 
	 * @Return StateCodeDTO
	 */
	@Override
	public StateCodeDTO getStateCodeByCode(String code) {
		// TODO Auto-generated method stub
		StateCodeDTO stateCodeDTO = new StateCodeDTO();
		try {
			StateCodeMaster stateCodeMaster = stateRepo.findByStateCode(code);
			stateCodeDTO.setStateCode(stateCodeMaster.getStateCode());
			stateCodeDTO.setStateId(stateCodeMaster.getStateId());
			stateCodeDTO.setStateName(stateCodeMaster.getStateName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stateCodeDTO;
	}

	/*
	 * @Param stateCodeDTO
	 * 
	 * Method for saving state code
	 * 
	 * @Return StateCodeDTO
	 */
	@Override
	public StateCodeDTO saveStateCode(StateCodeDTO stateCodeDTO) {
		// TODO Auto-generated method stub
		StateCodeMaster stateCode = new StateCodeMaster();
		stateCode.setStateCode(stateCodeDTO.getStateCode());
		stateCode.setStateName(stateCodeDTO.getStateName());
		try {
			stateRepo.save(stateCode);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stateCodeDTO;
	}

	/*
	 * @Param stateCodeDTO
	 * 
	 * Method for updating state code
	 * 
	 * @Return StateCodeDTO
	 */
	@Override
	public StateCodeDTO updateStateCode(StateCodeDTO stateCodeDTO) {
		// TODO Auto-generated method stub
		try {
			StateCodeMaster stateCode = stateRepo.findById(stateCodeDTO.getStateId()).get();
			stateCode.setStateCode(stateCodeDTO.getStateCode());
			stateCode.setStateName(stateCodeDTO.getStateName());
			stateRepo.save(stateCode);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stateCodeDTO;
	}

	@Override
	public void deleteStateCode(Integer stateId) {
		// TODO Auto-generated method stub

	}

}
