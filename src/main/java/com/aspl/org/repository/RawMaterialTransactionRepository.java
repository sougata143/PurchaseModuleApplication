package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.RawMaterialTransaction;

@Repository
public interface RawMaterialTransactionRepository extends JpaRepository<RawMaterialTransaction, Integer> {

	List<RawMaterialTransaction> findByItemId(Integer itemId);
	
}
