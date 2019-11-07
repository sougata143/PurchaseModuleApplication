package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.GoodsReceiptNoteHeaderDTO;
import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.ItemMasterDTO;
import com.aspl.org.dto.PurchaseDTO;
import com.aspl.org.dto.RawMaterialTransactionDTO;
import com.aspl.org.dto.StockLedgerDTO;
import com.aspl.org.dto.StockLedgerListDTO;
import com.aspl.org.service.FinishedGoodsTransactionService;
import com.aspl.org.service.GoodReceiptNoteHeaderService;
import com.aspl.org.service.GoodReceiptNoteItemDetailsService;
import com.aspl.org.service.ItemMasterService;
import com.aspl.org.service.PurchaseService;
import com.aspl.org.service.RawMaterialTransactionService;
import com.aspl.org.service.StockLedgerReportService;


@Service
@Transactional
public class StockLedgerReportServiceImpl implements StockLedgerReportService {

	@Autowired
	RawMaterialTransactionService rawMaterailTransactionService;
	
	@Autowired
	FinishedGoodsTransactionService finishedGoodsTransactionService;
	
	@Autowired
	ItemMasterService itemService;
	
	@Autowired
	GoodReceiptNoteHeaderService grnHeaderService;
	
	@Autowired
	GoodReceiptNoteItemDetailsService grnDetailsService;
	
	@Autowired
	PurchaseService poService;
	
	@Override
	public StockLedgerDTO getStockLedgerReport(Integer itemId) {
		
		StockLedgerDTO stockLedger = new StockLedgerDTO();
		try {
			List<RawMaterialTransactionDTO> transactionDTO = rawMaterailTransactionService.getAllRawMaterialTransactionByItemId(itemId);
			ItemMasterDTO item = itemService.findByItemId(itemId);
			
			ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
			List<StockLedgerListDTO> stockLedgerItems = new ArrayList<>();
			
			itemDTO.setCategory(item.getCategoryId());
			itemDTO.setSubCategory(item.getSubCategoryId());
			itemDTO.setItemCode(item.getItemCode());
			itemDTO.setItemId(itemId);
			itemDTO.setItemName(item.getItemName());
			itemDTO.setVendorId(item.getVendorCode().getVendorName());
			
			Double finalBalance = 0.0;
			Double firstBalance = 0.0;
			Double totalCredit = 0.0;
			Double totalDebit = 0.0;
			
			for(RawMaterialTransactionDTO transaction : transactionDTO) {
				StockLedgerListDTO stockLedgerItem = new StockLedgerListDTO();
				
				stockLedgerItem.setClosingBalance(transaction.getClosingStock());
				stockLedgerItem.setCredit(transaction.getCredit());
				stockLedgerItem.setDebit(transaction.getDebit());
				
				GoodsReceiptNoteHeaderDTO grnHeader = new GoodsReceiptNoteHeaderDTO();
				if(transaction.getGrnId()!=null) {
					grnHeader = grnHeaderService.getGoodsReceiptNoteByGrnId(transaction.getGrnId());
				}
				
				PurchaseDTO poHeader = new PurchaseDTO();
				if(transaction.getPoId()!=null) {
					poHeader = poService.findByPurchaseId(transaction.getPoId());
				}
				
				stockLedgerItem.setGrnNo(grnHeader.getGrnNo());
				stockLedgerItem.setOpenningBalance(transaction.getOpeningStock());
				stockLedgerItem.setPoNo(poHeader.getPurchaseCode());
				stockLedgerItem.setReceiveDate(grnHeader.getReceivedOn());
				
				if(transaction.getCredit()!=0.0)
					stockLedgerItem.setTransactionType("credit");
				else
					stockLedgerItem.setTransactionType("debit");
				
				finalBalance = finalBalance + transaction.getClosingStock();
				totalCredit = totalCredit + transaction.getCredit();
				totalDebit = totalDebit + transaction.getDebit();
				
				stockLedgerItems.add(stockLedgerItem);
			}
			
			firstBalance = transactionDTO.get(0).getOpeningStock();
			
			stockLedger.setFinalBalance(finalBalance);
			stockLedger.setFirstBalance(firstBalance);
			stockLedger.setTotalCredit(totalCredit);
			stockLedger.setTotalDebit(totalDebit);
			
			stockLedger.setItem(itemDTO);
			
			stockLedger.setStockLedgerItems(stockLedgerItems);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stockLedger;
	}

}
