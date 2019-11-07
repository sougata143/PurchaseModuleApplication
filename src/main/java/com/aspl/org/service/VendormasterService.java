package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aspl.org.dto.ContactsDetailsDTO;
import com.aspl.org.dto.VendorMasterDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.VendorMaster;

@Service
public interface VendormasterService {

	
	ResponseDetails vendorMasterSave(VendorMasterDTO vendorMasterDTO);
	
	/* public VendorMaster vendorMasterUpdate(VendorMaster currentVendor); */
    //void itemMasterUpdate(ItemMaster currentItem);

	
//	  VendorMaster vendormasterupdate(Optional<VendorMaster> vendorMaster1);
	ResponseDetails vendormasterupdate(VendorMasterDTO vendorMaster);
	 
	
	List<VendorMasterDTO> getallvendorlist();

	
	//Optional<ItemMaster> findByItemCode(String itemCode);
	VendorMasterDTO findByVendorCode(String vendorCode);
	

	/* VendorMaster findByVendorName(String vendorName); */

	//int deleteItemById(Optional<ItemMaster> itemMaster);

	
	  ResponseDetails permDeleteVendorMasterById(int vendorId);
	  ResponseDetails softDeleteVendorMasterById(int vendorId);
	  
	 VendorMasterDTO getVendorById(Integer vendorId);
	
	VendorMasterDTO prepareVendorMasterDTO(VendorMaster vendorMaster);
	VendorMaster prepareVendorMaster(VendorMasterDTO vendorMasterDTO);

	VendorMasterDTO findByVendorId(Integer vendorId);

	//ResponseDetails vendormasterupdate(VendorMasterDTO vendorMaster, ContactsDetailsDTO contactDetails);




	
	
}
