package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.FinishedGoodsTransactionDTO;
import com.aspl.org.entity.FinishedGoodsTransaction;
import com.aspl.org.entity.ResponseDetails;

public interface FinishedGoodsTransactionService {

	List<FinishedGoodsTransactionDTO> getAllFinishedGoodsTransaction();
	List<FinishedGoodsTransactionDTO> getAllFinishedGoodsTransactionByItemId(Integer itemId);
	
	FinishedGoodsTransactionDTO getFinishedGoodsTransactionById(Integer transId);
	ResponseDetails saveFinishedGoodsTransaction(FinishedGoodsTransactionDTO finishedGoodsTransactionDTO);
	ResponseDetails updateFinishedGoodsTransaction(FinishedGoodsTransactionDTO finishedGoodsTransactionDTO);
	ResponseDetails softDeleteFinishedGoodsTransaction(Integer transId);
	FinishedGoodsTransactionDTO prepareFinishedGoodsTransactionDTO(FinishedGoodsTransaction finishedGoodsTransaction);
	FinishedGoodsTransaction prepareFinishedGoodsTransaction(FinishedGoodsTransactionDTO finishedGoodsTransactionDTO);
	
}
