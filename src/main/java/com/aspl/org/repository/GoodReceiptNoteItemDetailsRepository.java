package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.GoodReceiptNoteItemDetails;

@Repository
public interface GoodReceiptNoteItemDetailsRepository extends JpaRepository<GoodReceiptNoteItemDetails, Integer> {

	List<GoodReceiptNoteItemDetails> findByGrnHeaderId(Integer grnHeaderId);
	
	List<GoodReceiptNoteItemDetails> findByGrnHeaderIdAndDetailsQcStatus(Integer grnHeaderId, Integer detailsQcStatus);
	
	List<GoodReceiptNoteItemDetails> findByGrnHeaderIdAndDetailsQcStatusOrDetailsQcStatus(Integer grnHeaderId, Integer detailsQcStatus, Integer detailsPartialQcStatus);
	
	List<GoodReceiptNoteItemDetails> findByGrnHeaderIdAndDetailsStatus(Integer grnHeaderId, Integer detailsStatus);
	
	List<GoodReceiptNoteItemDetails> findByItemId(Integer itemId);
	
}
