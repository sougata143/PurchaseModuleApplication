package com.aspl.org.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.entity.Purchase;


@Repository
public interface PurchaseDao extends JpaRepository<Purchase, Integer> {
	//public interface ItemMasterDao extends CrudRepository<ItemMaster, String> {
		//Indent findByItemName(String itemName);
		
	Purchase findByIndentCode(String indentCode);
	List<Purchase> findByIndentId(String indentId);
		//Optional<ItemMaster> findByItemCode(String itemCode);

		@Transactional
		@Modifying
		@Query("update Purchase ai set ai.accepted=1 where ai.id=?1")
		void purchaseAuthorised(int iId);

		
		@Transactional
		@Modifying
		@Query("update Purchase ai set ai.accepted=0 where ai.id=?1")
		void purchaseUnauthorised(int iId);

		@Query("Select ai from Purchase ai where ai.accepted=0 and ai.purchaseCode=?1")//indentCode
		Purchase findByPurchaseCodeAndAccepted(String purchaseCode, Integer accepted);
		Purchase findByVendorName(String vendorName);
		
		List<Purchase> findByAccepted(Integer accepted);
		List<Purchase> findByIsActive(Integer isActive);
		List<Purchase> findByCreatedDateBetween(Date startDate, Date endDate);
		
		List<Purchase> findByPurchaseStatusOrPurchaseStatusOrPurchaseStatus(Integer pendingStatus, Integer partiallyAcceptedStatus, Integer partiallyRejectedStatus);
		List<Purchase> findByPurchaseStatus(Integer purchaseStatus);
		
		List<Purchase> findByVendorIdAndCreatedDateBetween(Integer vendorId, Date startDate, Date endDate);

	}

