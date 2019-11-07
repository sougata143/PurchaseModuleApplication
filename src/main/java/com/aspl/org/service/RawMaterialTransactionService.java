package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.RawMaterialTransactionDTO;
import com.aspl.org.entity.RawMaterialTransaction;
import com.aspl.org.entity.ResponseDetails;

public interface RawMaterialTransactionService {

	public List<RawMaterialTransactionDTO> getAllRawMaterialTransaction();
	public List<RawMaterialTransactionDTO> getAllRawMaterialTransactionByItemId(Integer itemId);
	
	public ResponseDetails saveRawMaterialTransaction(RawMaterialTransactionDTO rawMaterialTransaction);
	public RawMaterialTransactionDTO getRawMaterialTransactionByTransId(Integer transId);
	public ResponseDetails updateRawMaterialTransaction(RawMaterialTransactionDTO rawMaterialTransactionDTO);
	RawMaterialTransactionDTO prepareRawMaterialTransactionDTO(RawMaterialTransaction rawMaterialTransaction);
	RawMaterialTransaction prepareRawMaterialTransaction(RawMaterialTransactionDTO rawMaterialTransactionDTO);
	
}
