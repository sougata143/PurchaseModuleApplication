package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.FinishedGoodsTransaction;

@Repository
public interface FinishedGoodsTransactionRepo extends JpaRepository<FinishedGoodsTransaction, Integer> {

	List<FinishedGoodsTransaction> findByItemId(Integer itemId);
	
}
