package com.aspl.org.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.VendorMaster;


@Repository
public interface VendorMasterDao extends JpaRepository<VendorMaster, Integer> {

	VendorMaster findByVendorName(String vendorName);
	
	VendorMaster findByVendorCode(String vendorCode);
	List<VendorMaster> findByStatus(Integer status);
	//Optional<ItemMaster> findByItemCode(String itemCode);

	//VendorMaster save(Optional<VendorMaster> vendorMaster1);

	//Optional<ItemMaster> load(Class<ItemMaster> class1, int item_code);

	//Optional<ItemMaster> findById(String itemCode);
	//ItemMaster findById(int item_code);

	int deleteById(int vendorCode);
}
