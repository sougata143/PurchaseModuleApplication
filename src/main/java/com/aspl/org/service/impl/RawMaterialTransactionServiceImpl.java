package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.RawMaterialTransactionDTO;
import com.aspl.org.entity.RawMaterialTransaction;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.repository.RawMaterialTransactionRepository;
import com.aspl.org.service.RawMaterialTransactionService;



@Service 
@Transactional
public class RawMaterialTransactionServiceImpl implements RawMaterialTransactionService {

	@Autowired
	RawMaterialTransactionRepository transRepo;
	
	@Override
	public List<RawMaterialTransactionDTO> getAllRawMaterialTransaction() {
		
		List<RawMaterialTransactionDTO> transDTOs = new ArrayList<>();
		try {
			List<RawMaterialTransaction> trans = transRepo.findAll();
			for(RawMaterialTransaction tr : trans) {
				RawMaterialTransactionDTO trDTO = prepareRawMaterialTransactionDTO(tr);
				transDTOs.add(trDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return transDTOs;
	}

	@Override
	public ResponseDetails saveRawMaterialTransaction(RawMaterialTransactionDTO rawMaterialTransaction) {
		
		try {
			RawMaterialTransaction trans = prepareRawMaterialTransaction(rawMaterialTransaction);
			transRepo.save(trans);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "saved successfully ", "200");
	}

	@Override
	public RawMaterialTransactionDTO getRawMaterialTransactionByTransId(Integer transId) {
		
		RawMaterialTransactionDTO trDTO = new RawMaterialTransactionDTO();
		try {
			RawMaterialTransaction trans = transRepo.findById(transId).get();
			trDTO = prepareRawMaterialTransactionDTO(trans);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return trDTO;
	}

	@Override
	public ResponseDetails updateRawMaterialTransaction(RawMaterialTransactionDTO rawMaterialTransactionDTO) {
		
		try {
			RawMaterialTransaction trans = prepareRawMaterialTransaction(rawMaterialTransactionDTO);
			transRepo.save(trans);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "updated successfully ", "200");
	}

	@Override
	public RawMaterialTransactionDTO prepareRawMaterialTransactionDTO(RawMaterialTransaction rawMaterialTransaction) {
	
		RawMaterialTransactionDTO rawMaterialTransactionDTO = new RawMaterialTransactionDTO();
		
		rawMaterialTransactionDTO.setCategory(rawMaterialTransaction.getCategory());
		rawMaterialTransactionDTO.setClosingStock(rawMaterialTransaction.getClosingStock());
		rawMaterialTransactionDTO.setCreatedDate(rawMaterialTransaction.getCreatedDate());
		rawMaterialTransactionDTO.setCredit(rawMaterialTransaction.getCredit());
		rawMaterialTransactionDTO.setDebit(rawMaterialTransaction.getDebit());
		rawMaterialTransactionDTO.setItemId(rawMaterialTransaction.getItemId());
		rawMaterialTransactionDTO.setOpeningStock(rawMaterialTransaction.getOpeningStock());
		rawMaterialTransactionDTO.setRawMaterialTransId(rawMaterialTransaction.getRawMaterialTransId());
		rawMaterialTransactionDTO.setStoreId(rawMaterialTransaction.getStoreId());
		
		rawMaterialTransactionDTO.setPoId(rawMaterialTransaction.getPoId());
		rawMaterialTransactionDTO.setGrnId(rawMaterialTransaction.getGrnId());
		
		return rawMaterialTransactionDTO;
	}

	@Override
	public RawMaterialTransaction prepareRawMaterialTransaction(RawMaterialTransactionDTO rawMaterialTransactionDTO) {
		
		RawMaterialTransaction rawMaterialTransaction = new RawMaterialTransaction();
		
		rawMaterialTransaction.setCategory(rawMaterialTransactionDTO.getCategory());
		rawMaterialTransaction.setClosingStock(rawMaterialTransactionDTO.getClosingStock());
		rawMaterialTransaction.setCreatedDate(rawMaterialTransactionDTO.getCreatedDate());
		rawMaterialTransaction.setCredit(rawMaterialTransactionDTO.getCredit());
		rawMaterialTransaction.setDebit(rawMaterialTransactionDTO.getDebit());
		rawMaterialTransaction.setItemId(rawMaterialTransactionDTO.getItemId());
		rawMaterialTransaction.setOpeningStock(rawMaterialTransactionDTO.getOpeningStock());
		rawMaterialTransaction.setStoreId(rawMaterialTransactionDTO.getStoreId());
		
		rawMaterialTransaction.setPoId(rawMaterialTransactionDTO.getPoId());
		rawMaterialTransaction.setGrnId(rawMaterialTransactionDTO.getGrnId());
		
		return rawMaterialTransaction;
	}

	@Override
	public List<RawMaterialTransactionDTO> getAllRawMaterialTransactionByItemId(Integer itemId) {
		
		List<RawMaterialTransactionDTO> rawMaterialDTOs = new ArrayList<>();
		try {
			List<RawMaterialTransaction> rmts = transRepo.findByItemId(itemId);
			for(RawMaterialTransaction rmt : rmts) {
				RawMaterialTransactionDTO dto = prepareRawMaterialTransactionDTO(rmt);
				rawMaterialDTOs.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rawMaterialDTOs;
	}

}
