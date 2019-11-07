package com.aspl.org.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.GoodsRecieptNoteHeader;

@Repository
public interface GoodsReceiptNoteRepository extends JpaRepository<GoodsRecieptNoteHeader, Integer> {

	GoodsRecieptNoteHeader findByGrnNo(String grnNo);
	List<GoodsRecieptNoteHeader> findByPoId(String poId);
	List<GoodsRecieptNoteHeader> findByIsActive(Integer isActive);
	List<GoodsRecieptNoteHeader> findByIsAccepted(Integer isAccepted);
	List<GoodsRecieptNoteHeader> findByQcRequired(Integer qcRequired);
	
	List<GoodsRecieptNoteHeader> findByQcRequiredAndGrnStatusOrGrnStatusOrGrnStatus(
			Integer qcRequired, Integer grnStatus, Integer partlyAcceptGrnStatus, Integer partlyRejectGrnStatus);
	
	List<GoodsRecieptNoteHeader> findByQcAccept(Integer qcAccept);
	List<GoodsRecieptNoteHeader> findByQcAcceptOrQcAccept(Integer qcAccept, Integer qcPartiallyAccept);
	List<GoodsRecieptNoteHeader> findByQcAcceptOrQcAcceptAndQcRequired(Integer qcAccept, Integer qcPartiallyAccept, Integer qcRequired);
	List<GoodsRecieptNoteHeader> findByQcAcceptOrQcAcceptOrQcAccept(Integer qcAccept, Integer qcPartiallyAccept, Integer partiallyAuthorised);
	
	List<GoodsRecieptNoteHeader> findByGrnStatus(Integer grnStatus);
	List<GoodsRecieptNoteHeader> findByGrnStatusOrGrnStatusOrGrnStatus(Integer grnStatus, Integer partlyAcceptGrnStatus, Integer partlyRejectGrnStatus);
	
	List<GoodsRecieptNoteHeader> findByCreatedDateBetweenOrderByCreatedDateDesc(Date startDate, Date endDate);
	List<GoodsRecieptNoteHeader> findByIsAuthorisedAndCreatedDateBetweenOrderByCreatedDateDesc(Integer isAuthorised, Date startDate, Date endDate);
	
}
