package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aspl.org.dto.StoreDetailsDTO;
import com.aspl.org.entity.StoreDetails;

@Service
public interface StoreDetailsService {
	
	List<StoreDetailsDTO> getAllStoreList();

	List<StoreDetailsDTO> findStoreDetailsByItemCode(String itemCode);
	List<StoreDetailsDTO> findStoreDetailsByItemId(Integer itemId);
	List<StoreDetailsDTO> findExpiredStoreDetails();
	List<StoreDetailsDTO> findCloseToExpireStoreDetails();
	StoreDetailsDTO findStoreDetailsByItemName(String itemName);

	StoreDetails saveStoreDetails(StoreDetailsDTO storeDetailsDTO);
	StoreDetailsDTO updateStoreDetails(StoreDetailsDTO storeDetailsDTO);
	StoreDetails dumpExpiredStore(Integer storeId);
	
	StoreDetailsDTO prepareStoreDetailsDTO(StoreDetails storeDetails);
	StoreDetails prepareStoreDetails(StoreDetailsDTO storeDetailsDTO);
}
