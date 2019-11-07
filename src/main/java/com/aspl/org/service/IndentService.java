package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aspl.org.dto.IndentDTO;
import com.aspl.org.dto.IndentDetailsDTO;
import com.aspl.org.entity.Indent;
import com.aspl.org.entity.IndentDetails;
import com.aspl.org.entity.ResponseDetails;


@Service
public interface IndentService {

	IndentDTO findByIndentCode(String indentCode);
	IndentDTO getIndentByIndentId(Integer indentId);
	
	List<IndentDTO> getAllIndent();
	List<IndentDTO> getAllUnauthorisedIndent();
	
	ResponseDetails indentSave(IndentDTO indentDTO) throws Exception;
	Indent softDeleteIndent(Integer indentId);
	
	ResponseDetails indentAuthorised(IndentDTO indentDTO);
	ResponseDetails indentUnauthorised(IndentDTO indentDTO);
	
    List<IndentDTO> getAllAuthorisedIndent();
    
    IndentDTO prepareIndentDTO(Indent indent);
    Indent prepareIndentEntity(IndentDTO indentDTO);
    
    IndentDetailsDTO prepareIndentDetailsDTO(IndentDetails indentDetails);
    IndentDetails prepareIndentDetailsEntity(IndentDetailsDTO indentDetailsDTO);
	IndentDTO prepareUnauthorizedIndentDTO(Indent indent);

	
	
}
