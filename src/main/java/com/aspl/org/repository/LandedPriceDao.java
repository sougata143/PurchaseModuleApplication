package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.LandedPrice;

@Repository
public interface LandedPriceDao extends JpaRepository<LandedPrice, Integer> {
	
	List<LandedPrice> findByItemId(Integer itemId);
	List<LandedPrice> findByCategoryId(Integer categoryId);
	List<LandedPrice> findBySubCategoryId(Integer subCategoryId);
	List<LandedPrice> findByItemIdOrderByCreatedDateDesc(Integer itemId);
	
}
