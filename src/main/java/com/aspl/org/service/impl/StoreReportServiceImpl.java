package com.aspl.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.FinishedGoodsTransactionDTO;
import com.aspl.org.dto.RawMaterialTransactionDTO;
import com.aspl.org.dto.StoreTransactionReportDTO;
import com.aspl.org.service.FinishedGoodsTransactionService;
import com.aspl.org.service.RawMaterialTransactionService;
import com.aspl.org.service.StoreReportService;


@Service
@Transactional
public class StoreReportServiceImpl implements StoreReportService {

	@Autowired
	RawMaterialTransactionService rawMaterialTransService;
	
	@Autowired
	FinishedGoodsTransactionService finishedGoodsTransService;
	
	@Override
	public StoreTransactionReportDTO getStoreTransactionReportDTO(Integer itemId) {
	
		StoreTransactionReportDTO storeTransReportDTO = new StoreTransactionReportDTO();
		try {
			
			Double totalClosingStock = 0.0;
			Double totalCredit = 0.0;
			Double totalDebit = 0.0;
			Double totalOpeningStock = 0.0;
			
			List<RawMaterialTransactionDTO> rawMaterialTrans = 
					rawMaterialTransService.getAllRawMaterialTransactionByItemId(itemId);
			
			List<FinishedGoodsTransactionDTO> finishedGoodsTrans = 
					finishedGoodsTransService.getAllFinishedGoodsTransactionByItemId(itemId);
			
			if(rawMaterialTrans.size()>0){
				for(RawMaterialTransactionDTO rawMaterialDTO : rawMaterialTrans) {
					totalClosingStock = totalClosingStock + rawMaterialDTO.getClosingStock();
					totalCredit = totalCredit + rawMaterialDTO.getCredit();
					totalDebit = totalDebit + rawMaterialDTO.getDebit();
					totalOpeningStock = totalOpeningStock + rawMaterialDTO.getOpeningStock();
				}
			}
			
			if(finishedGoodsTrans.size()>0) {
				for(FinishedGoodsTransactionDTO finishedGoodsDTO : finishedGoodsTrans) {
					totalClosingStock = totalClosingStock + finishedGoodsDTO.getClosingStock();
					totalCredit = totalCredit + finishedGoodsDTO.getCredit();
					totalDebit = totalDebit + finishedGoodsDTO.getDebit();
					totalOpeningStock = totalOpeningStock + finishedGoodsDTO.getOpeningStock();
				}
			}
			
			storeTransReportDTO.setTotalClosingStock(totalClosingStock);
			storeTransReportDTO.setTotalCredit(totalCredit);
			storeTransReportDTO.setTotalDebit(totalDebit);
			storeTransReportDTO.setTotalOpeningStock(totalOpeningStock);
			
			storeTransReportDTO.setFinishedGoodsTransactions(finishedGoodsTrans);
			storeTransReportDTO.setRawMaterialTransactions(rawMaterialTrans);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return storeTransReportDTO;
	}

}
