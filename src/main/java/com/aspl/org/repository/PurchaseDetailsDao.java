package com.aspl.org.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aspl.org.entity.PurchaseDetails;

public interface PurchaseDetailsDao extends JpaRepository<PurchaseDetails, Integer> {

	List<PurchaseDetails> findByPoid(Integer poId);
	List<PurchaseDetails> findByItemCode(String itemCode);
	
	List<PurchaseDetails> findByItemId(Integer itemId);
	
//	List<PurchaseDetails> findByItemIdAndCreatedDateBetween(Date startDate, Date endDate);
	
	List<PurchaseDetails> findByPoidAndPoDetailsStaus(Integer poId, Integer poDetailsStaus);
	
	List<PurchaseDetails> findByPoidAndPoDetailsStausOrPoDetailsStausOrPoDetailsStaus(Integer poId, 
			Integer pendingPoDetailsStaus, Integer partlyAcceptedPoDetailsStaus, Integer partlyRejectedPoDetailsStaus);
	
}
