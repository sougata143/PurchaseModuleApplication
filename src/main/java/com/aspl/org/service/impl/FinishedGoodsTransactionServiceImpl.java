package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.FinishedGoodsTransactionDTO;
import com.aspl.org.entity.FinishedGoodsTransaction;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.repository.FinishedGoodsTransactionRepo;
import com.aspl.org.service.FinishedGoodsTransactionService;


@Service
@Transactional
public class FinishedGoodsTransactionServiceImpl implements FinishedGoodsTransactionService {

	@Autowired
	FinishedGoodsTransactionRepo transRepo;
	
	@Override
	public List<FinishedGoodsTransactionDTO> getAllFinishedGoodsTransaction() {
		List<FinishedGoodsTransactionDTO> transDTOs = new ArrayList<>();
		try {
			List<FinishedGoodsTransaction> trans = transRepo.findAll();
			for(FinishedGoodsTransaction tran : trans) {
				FinishedGoodsTransactionDTO tr = new FinishedGoodsTransactionDTO();
				tr = prepareFinishedGoodsTransactionDTO(tran);
				transDTOs.add(tr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	 @Override public FinishedGoodsTransactionDTO getFinishedGoodsTransactionById(Integer transId) { 
		try {
	 
		}catch(Exception e) { 
			e.printStackTrace();
		} 
		return null; 
	 }
	
	
	@Override
	public ResponseDetails saveFinishedGoodsTransaction(FinishedGoodsTransactionDTO finishedGoodsTransactionDTO) {
		try {
			FinishedGoodsTransaction fgt = prepareFinishedGoodsTransaction(finishedGoodsTransactionDTO);
			transRepo.save(fgt);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Successfully saved", "200");
	}

	@Override
	public ResponseDetails updateFinishedGoodsTransaction(FinishedGoodsTransactionDTO finishedGoodsTransactionDTO) {
		try {
			FinishedGoodsTransaction fgt = prepareFinishedGoodsTransaction(finishedGoodsTransactionDTO);
			transRepo.save(fgt);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Successfully saved", "200");
	}

	@Override
	public ResponseDetails softDeleteFinishedGoodsTransaction(Integer transId) {
		
//		try {
//			FinishedGoodsTransaction fgt = transRepo.findById(transId).get();
//			
//			transRepo.save(fgt);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		return new ResponseDetails(new Date(), "Successfully saved", "200");
	}

	@Override
	public FinishedGoodsTransactionDTO prepareFinishedGoodsTransactionDTO(
			FinishedGoodsTransaction finishedGoodsTransaction) {
		FinishedGoodsTransactionDTO tr = new FinishedGoodsTransactionDTO();
		try {
			tr.setCategory(finishedGoodsTransaction.getCategory());
			tr.setClosingStock(finishedGoodsTransaction.getClosingStock());
			tr.setCreatedDate(finishedGoodsTransaction.getCreatedDate());
			tr.setFinishedGoodsTransId(finishedGoodsTransaction.getFinishedGoodsTransId());
			tr.setItemId(finishedGoodsTransaction.getItemId());
			tr.setOpeningStock(finishedGoodsTransaction.getOpeningStock());
			tr.setCredit(finishedGoodsTransaction.getCredit());
			tr.setDebit(finishedGoodsTransaction.getDebit());
			tr.setStoreId(finishedGoodsTransaction.getStoreId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tr;
	}

	@Override
	public FinishedGoodsTransaction prepareFinishedGoodsTransaction(
			FinishedGoodsTransactionDTO finishedGoodsTransactionDTO) {
		FinishedGoodsTransaction tr = new FinishedGoodsTransaction();
		try {
			tr.setCategory(finishedGoodsTransactionDTO.getCategory());
			tr.setClosingStock(finishedGoodsTransactionDTO.getClosingStock());
			tr.setCreatedDate(finishedGoodsTransactionDTO.getCreatedDate());
			tr.setFinishedGoodsTransId(finishedGoodsTransactionDTO.getFinishedGoodsTransId());
			tr.setItemId(finishedGoodsTransactionDTO.getItemId());
			tr.setOpeningStock(finishedGoodsTransactionDTO.getOpeningStock());
			tr.setCredit(finishedGoodsTransactionDTO.getCredit());
			tr.setDebit(finishedGoodsTransactionDTO.getDebit());
			tr.setStoreId(finishedGoodsTransactionDTO.getStoreId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tr;
	}

	@Override
	public List<FinishedGoodsTransactionDTO> getAllFinishedGoodsTransactionByItemId(Integer itemId) {
		List<FinishedGoodsTransactionDTO> finishedStocks = new ArrayList<>();
		try {
			List<FinishedGoodsTransaction> fgts = transRepo.findByItemId(itemId);
			for(FinishedGoodsTransaction fgt : fgts) {
				FinishedGoodsTransactionDTO dto = prepareFinishedGoodsTransactionDTO(fgt);
				finishedStocks.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return finishedStocks;
	}

}
