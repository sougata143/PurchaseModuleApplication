package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.IndentDetails;

@Repository
public interface IndentDetailsDao extends JpaRepository<IndentDetails, Integer> {


		//@Query("select od from IndentDetails od where od.id=?1")
		//public IndentDetails findIndentDetailsById(int id);
	
		List<IndentDetails> findByIndentId(Integer indentId);
		List<IndentDetails> findByIndentIdAndIndentItemStatus(Integer indentId, Integer indentItemStatus);
		List<IndentDetails> findByIndentIdAndIndentItemStatusOrIndentItemStatus(Integer indentId, Integer indentItemStatus, Integer indentItemStatus2);
		
	}
