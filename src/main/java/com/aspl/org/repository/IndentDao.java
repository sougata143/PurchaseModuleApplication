package com.aspl.org.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.Indent;



@Repository
public interface IndentDao extends JpaRepository<Indent, Integer> {
	
	List<Indent> findByIndentCode(String indentCode);

	@Query("Select ai from Indent ai where ai.accepted=0 and ai.indentCode=?1")//indentCode
	Indent getIndentForAuthorisation(String indentCode);

	@Query("Select ai from Indent ai where ai.accepted=0")//indentCode
	List<Indent> getAllUnauthorisedIndent();
	
	List<Indent> findByPurchaseStatusAndCreatedDateBetweenOrderByCreatedDateDesc(Integer purchaseStatus, Date startDate, Date endDate);
	
	@Query("Select ai from Indent ai where ai.accepted=1")//indentCode
	List<Indent> getAllAuthorisedIndent();
	
	@Query("Select ai from Indent ai where ai.accepted=1 and ai.indentCode=?1")//indentCode
	Indent getAuthorisedIndenByIndentCode(String indentCode);
	
	List<Indent> findByStatus(Integer status);
	Indent findByIndentCodeAndStatus(String indentCode, Integer status);
	List<Indent> findByAccepted(Integer accepted);
	List<Indent> findByCreatedDateBetweenOrderByCreatedDateDesc(Date startDate, Date endDate);
	List<Indent> findByStatusAndCreatedDateBetweenOrderByCreatedDateDesc(Integer status, Date startDate, Date endDate);
	
	List<Indent> findByStatusOrStatusOrStatusAndCreatedDateBetweenOrderByCreatedDateDesc(Integer status, 
			Integer partailAcceptStatus, Integer partailRejectStatus, Date startDate, Date endDate);
	
	List<Indent> findByStatusOrStatusOrStatus(Integer pendingStatus, Integer partiallyPendingStatus, Integer partiallyRejectedStatus);
	List<Indent> findByIsActive(Integer isActive);
	

}
