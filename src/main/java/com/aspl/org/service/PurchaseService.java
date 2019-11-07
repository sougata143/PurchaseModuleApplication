package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.aspl.org.dto.PriceHistoryDTO;
import com.aspl.org.dto.PurchaseDTO;
import com.aspl.org.entity.ResponseDetails;

@Service
public interface PurchaseService {

	
	ResponseDetails purchaseSave(PurchaseDTO purchaseDTO) throws Exception;
	ResponseDetails purchaseUpdate(PurchaseDTO purchaseDTO) throws Exception;
	
	//ResponseDetails findByIndentCode(String indentCode);
	
	ResponseDetails purchaseAuthorised(PurchaseDTO purchaseDTO);
	ResponseDetails purchaseUnauthorised(PurchaseDTO purchaseDTO);
	
	PurchaseDTO findByPurchaseCode(String purchaseCode);
	PurchaseDTO findByPurchaseId(Integer purchaseId);
	List<PurchaseDTO> getAllPurchaseForAuthorisation();
	List<PurchaseDTO> getAllUnAuthorisedPurchaseOrder();
	List<PurchaseDTO> getAllAuthorisedPurchaseOrder();
	List<PurchaseDTO> getAllActivePurchaseOrder();

//	PurchaseDTO preparePurchaseDTO(Purchase purchase, String authorization);
//	Purchase preparePurchaseEntity(PurchaseDTO purchaseDTO);
	PurchaseDTO softDeleteItem(Integer id);
	List<PriceHistoryDTO> getPurchasePriceForItem(Integer itemId);
	
//	PurchaseDetailsDTO preparePurchaseDetailsDTO(PurchaseDetails purchaseDetails);
//	PurchaseDetails preparePurchaseDetailsEntity(PurchaseDetailsDTO purchaseDetailsDTO);
//	PurchaseDTO prepareUnauthorisedPurchaseDTO(Purchase purchase);
	//PurchaseDTO findByVendorName(String vendorName);


}
