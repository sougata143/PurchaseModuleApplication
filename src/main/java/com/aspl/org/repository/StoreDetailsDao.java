package com.aspl.org.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.StoreDetails;


@Repository
public interface StoreDetailsDao extends JpaRepository<StoreDetails, Integer> {
//public interface ItemMasterDao extends CrudRepository<ItemMaster, String> {
	StoreDetails findStoreDetailsByItemName(String itemName);
	
	List<StoreDetails> findByItemCode(String itemCode);
	//Optional<ItemMaster> findByItemCode(String itemCode);

	StoreDetails save(Optional<StoreDetails> storeDetails);

	//Optional<ItemMaster> load(Class<ItemMaster> class1, int item_code);

	//Optional<ItemMaster> findById(String itemCode);
	//ItemMaster findById(int item_code);

	int deleteById(int itemCode);
	
	List<StoreDetails> findByItemId(Integer itemId);
	List<StoreDetails> findByExpiryDate(Date expiryDate);
	
}
