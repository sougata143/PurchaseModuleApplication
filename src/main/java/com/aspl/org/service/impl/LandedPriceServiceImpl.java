package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.LandedPriceDTO;
import com.aspl.org.dto.SubCategoryForMappingDTO;
import com.aspl.org.dto.VendorMasterDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.LandedPrice;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.LandedPriceDao;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.service.LandedPriceService;
import com.aspl.org.service.VendormasterService;

/*
 * Service for Landed Price master CRUD operation and back end logic
 */
@Service
public class LandedPriceServiceImpl implements LandedPriceService {
	
	@Autowired 
	LandedPriceDao landedPriceDao;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	SubCategoryRepo subCategoryRepo;
	
	@Autowired
	VendormasterService vendorService;
	

	/*
	 * @Param landedPriceDTO
	 * 
	 * Method for saving landed price master
	 * 
	 * @Return LandedPriceDTO
	 */
	@Override
	public LandedPriceDTO landedPriceSave(LandedPriceDTO landedPriceDTO) {
		LandedPrice landedPrice = new LandedPrice();
		try {
			landedPrice.setCreatedDate(new Date());
			landedPrice.setItemId(landedPriceDTO.getItemDTO().getItemId());
			landedPrice.setMinStock(landedPriceDTO.getMinStock());
			landedPrice.setMrp(landedPriceDTO.getMrp());
			landedPrice.setUnit(landedPriceDTO.getUnit());
			landedPrice.setIsActive(1);
			ItemMaster item = itemDao.findById(landedPriceDTO.getItemDTO().getItemId()).get();
//			landedPrice.setCategoryId(landedPriceDTO.getItemDTO().getCategory().getCategoryId());
//			landedPrice.setSubCategoryId(landedPriceDTO.getItemDTO().getSubCategory().getSubCategoryId());
			landedPrice.setCategoryId(item.getCategoryId2());
			landedPrice.setSubCategoryId(item.getSubCategoryId2());
			landedPrice.setDiscount(landedPriceDTO.getDiscount());
			landedPrice.setGrnId(landedPriceDTO.getGrnId());
			landedPrice.setOrderQnt(landedPriceDTO.getOrderQnt());
			landedPrice.setVendorId(landedPriceDTO.getVendorId());
			
			landedPriceDao.save(landedPrice);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return landedPriceDTO;
	}

	/*
	 * @Param landedPriceDTO
	 * 
	 * Method for updating landed price
	 * 
	 * @Return LandedPriceDTO
	 */
	@Override
	public LandedPriceDTO landedPriceUpdate(LandedPriceDTO landedPriceDTO) {
		try {
			LandedPrice landedPrice = landedPriceDao.findById(landedPriceDTO.getId()).get();
			landedPrice.setCreatedDate(new Date());
			landedPrice.setItemId(landedPriceDTO.getItemDTO().getItemId());
			landedPrice.setMinStock(landedPriceDTO.getMinStock());
			landedPrice.setMrp(landedPriceDTO.getMrp());
			landedPrice.setUnit(landedPriceDTO.getUnit());
			landedPrice.setDiscount(landedPriceDTO.getDiscount());
			landedPrice.setGrnId(landedPriceDTO.getGrnId());
			landedPrice.setOrderQnt(landedPriceDTO.getOrderQnt());
			landedPrice.setVendorId(landedPriceDTO.getVendorId());
			
			landedPriceDao.save(landedPrice);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return landedPriceSave(landedPriceDTO);
	}

	/*
	 * Method for fetching all landed price
	 * 
	 * @Return List<LandedPriceDTO>
	 */
	@Override
	public List<LandedPriceDTO> getallitemlist() {
		List<LandedPriceDTO> landedPriceDTOs = new ArrayList<>();
		try {
			List<LandedPrice> landedPrices = landedPriceDao.findAll();
			 
			for(LandedPrice price : landedPrices) {
				LandedPriceDTO landedPriceDTO = new LandedPriceDTO();
				landedPriceDTO.setCreatedDate(price.getCreatedDate());
				landedPriceDTO.setId(price.getLandedPriceId());
				landedPriceDTO.setMinStock(price.getMinStock());
				landedPriceDTO.setMrp(price.getMrp());
				landedPriceDTO.setUnit(price.getUnit());
				
				ItemMaster item = itemDao.findById(price.getItemId()).get();
				Category category = categoryRepo.findById(item.getCategoryId2()).get();
				SubCategory subCategory = subCategoryRepo.findById(item.getSubCategoryId2()).get();
				
				ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO(); 
				itemDTO.setItemCode(item.getItemCode());
				itemDTO.setItemId(item.getId());
				itemDTO.setItemName(item.getItemName());
				
				CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
				categoryDTO.setCategoryId(category.getCategoryId());
				categoryDTO.setCategoryName(category.getCategoryName());
				itemDTO.setCategory(categoryDTO);
				
				SubCategoryForMappingDTO subCategoryDTO = new SubCategoryForMappingDTO(); 
				subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
				subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
				itemDTO.setSubCategory(subCategoryDTO);
				
				landedPriceDTO.setItemDTO(itemDTO);
				
				landedPriceDTO.setDiscount(price.getDiscount());
				landedPriceDTO.setGrnId(price.getGrnId());
				landedPriceDTO.setOrderQnt(price.getOrderQnt());
				
				if(price.getVendorId()!=null) {
					VendorMasterDTO vendor = vendorService.getVendorById(price.getVendorId());
					landedPriceDTO.setVendorId(landedPriceDTO.getVendorId());
				}
				
				landedPriceDTOs.add(landedPriceDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return landedPriceDTOs;
	}


	/*
	 * @Param landedPriceId
	 * 
	 * Method for permanently delete landed price
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails permDeleteLandedPriceById(int landednPriceId) {
		try {
			landedPriceDao.deleteById(landednPriceId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Deleted" , null);
	}
	
	/*
	 * @Param id
	 * 
	 * Method for getting landed price by id
	 * 
	 * @Return LandedPriceDTO
	 */
	@Override
	public LandedPriceDTO getLandedPriceById(Integer id) {
		// TODO Auto-generated method stub
		LandedPriceDTO landedPriceDTO = new LandedPriceDTO();
		try {
			LandedPrice price = landedPriceDao.findById(id).get();
			
			landedPriceDTO.setCreatedDate(price.getCreatedDate());
			landedPriceDTO.setId(price.getLandedPriceId());
			landedPriceDTO.setMinStock(price.getMinStock());
			landedPriceDTO.setMrp(price.getMrp());
			landedPriceDTO.setUnit(price.getUnit());
			
			ItemMaster item = itemDao.findById(price.getItemId()).get();
			ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO(); 
			itemDTO.setItemCode(item.getItemCode());
			itemDTO.setItemId(item.getId());
			itemDTO.setItemName(item.getItemName());
			
			Category category = categoryRepo.findById(item.getCategoryId2()).get();
			SubCategory subCategory = subCategoryRepo.findById(item.getSubCategoryId2()).get();
			
			itemDTO.setItemCode(item.getItemCode());
			itemDTO.setItemId(item.getId());
			itemDTO.setItemName(item.getItemName());
			
			CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
			categoryDTO.setCategoryId(category.getCategoryId());
			categoryDTO.setCategoryName(category.getCategoryName());
			itemDTO.setCategory(categoryDTO);
			
			SubCategoryForMappingDTO subCategoryDTO = new SubCategoryForMappingDTO(); 
			subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
			subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
			itemDTO.setSubCategory(subCategoryDTO);
			
			landedPriceDTO.setItemDTO(itemDTO);
			
			landedPriceDTO.setItemDTO(itemDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return landedPriceDTO;
	}

	/*
	 * @Param itemId
	 * 
	 * Method for getting landed price by item
	 * 
	 * @Return List<LandedPriceDTO>
	 */
	@Override
	public List<LandedPriceDTO> getLandedPriceForItem(Integer itemID) {
		// TODO Auto-generated method stub
		List<LandedPriceDTO> landedPriceDTOs = new ArrayList<>();
		try {
			List<LandedPrice> price = landedPriceDao.findByItemIdOrderByCreatedDateDesc(itemID);
			
			for(LandedPrice p : price) {
				LandedPriceDTO landedPriceDTO = new LandedPriceDTO();
				landedPriceDTO.setCreatedDate(p.getCreatedDate());
				landedPriceDTO.setId(p.getLandedPriceId());
				landedPriceDTO.setMinStock(p.getMinStock());
				landedPriceDTO.setMrp(p.getMrp());
				landedPriceDTO.setUnit(p.getUnit());
				
				ItemMaster item = itemDao.findById(p.getItemId()).get();
				ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO(); 
				itemDTO.setItemCode(item.getItemCode());
				itemDTO.setItemId(item.getId());
				itemDTO.setItemName(item.getItemName());
				
				Category category = categoryRepo.findById(item.getCategoryId2()).get();
				SubCategory subCategory = subCategoryRepo.findById(item.getSubCategoryId2()).get();
				
				CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
				categoryDTO.setCategoryId(category.getCategoryId());
				categoryDTO.setCategoryName(category.getCategoryName());
				itemDTO.setCategory(categoryDTO);
				
				SubCategoryForMappingDTO subCategoryDTO = new SubCategoryForMappingDTO(); 
				subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
				subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
				itemDTO.setSubCategory(subCategoryDTO);
				
				landedPriceDTO.setItemDTO(itemDTO);
				
				landedPriceDTO.setItemDTO(itemDTO);
				
				landedPriceDTOs.add(landedPriceDTO);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return landedPriceDTOs;
	}

	/*
	 * @Param id
	 * 
	 * Method for soft delete landed price
	 * 
	 * @Return String
	 */
	@Override
	public String softDeleteLandedPrice(Integer id) {
		// TODO Auto-generated method stub
		try {
			LandedPrice landedPrice = landedPriceDao.findById(id).get();
			landedPrice.setIsActive(0);
			landedPriceDao.save(landedPrice);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "successfully disabled the landed price";
	}

	/*
	 * @Param categoryId
	 * 
	 * Method for fetching landed price by category
	 * 
	 * @Return List<LandedPriceDTO>
	 */
	@Override
	public List<LandedPriceDTO> getLandedPriceByCategoryId(Integer categoryId) {
		// TODO Auto-generated method stub
		
		List<LandedPriceDTO> landedPriceDTOs = new ArrayList<>();
		try {
			List<LandedPrice> price = landedPriceDao.findByCategoryId(categoryId);
			
			for(LandedPrice p : price) {
				LandedPriceDTO landedPriceDTO = new LandedPriceDTO();
				landedPriceDTO.setCreatedDate(p.getCreatedDate());
				landedPriceDTO.setId(p.getLandedPriceId());
				landedPriceDTO.setMinStock(p.getMinStock());
				landedPriceDTO.setMrp(p.getMrp());
				landedPriceDTO.setUnit(p.getUnit());
				
				ItemMaster item = itemDao.findById(p.getItemId()).get();
				ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO(); 
				itemDTO.setItemCode(item.getItemCode());
				itemDTO.setItemId(item.getId());
				itemDTO.setItemName(item.getItemName());
				
				Category category = categoryRepo.findById(item.getCategoryId2()).get();
				SubCategory subCategory = subCategoryRepo.findById(item.getSubCategoryId2()).get();
				
				CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
				categoryDTO.setCategoryId(category.getCategoryId());
				categoryDTO.setCategoryName(category.getCategoryName());
				itemDTO.setCategory(categoryDTO);
				
				SubCategoryForMappingDTO subCategoryDTO = new SubCategoryForMappingDTO(); 
				subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
				subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
				itemDTO.setSubCategory(subCategoryDTO);
				
				landedPriceDTO.setItemDTO(itemDTO);
				
				landedPriceDTO.setItemDTO(itemDTO);
				
				landedPriceDTOs.add(landedPriceDTO);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return landedPriceDTOs;
	}

	/*
	 * @Param subCategoryId
	 * 
	 * Method for getting landed price by sub category
	 * 
	 * @Return List<LandedPriceDTO>
	 */
	@Override
	public List<LandedPriceDTO> getLandedPriceBySubCategoryId(Integer subCategoryId) {
		// TODO Auto-generated method stub
		List<LandedPriceDTO> landedPriceDTOs = new ArrayList<>();
		try {
			List<LandedPrice> price = landedPriceDao.findBySubCategoryId(subCategoryId);
			
			for(LandedPrice p : price) {
				LandedPriceDTO landedPriceDTO = new LandedPriceDTO();
				landedPriceDTO.setCreatedDate(p.getCreatedDate());
				landedPriceDTO.setId(p.getLandedPriceId());
				landedPriceDTO.setMinStock(p.getMinStock());
				landedPriceDTO.setMrp(p.getMrp());
				landedPriceDTO.setUnit(p.getUnit());
				
				ItemMaster item = itemDao.findById(p.getItemId()).get();
				ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO(); 
				itemDTO.setItemCode(item.getItemCode());
				itemDTO.setItemId(item.getId());
				itemDTO.setItemName(item.getItemName());
				landedPriceDTO.setItemDTO(itemDTO);
				
				landedPriceDTOs.add(landedPriceDTO);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return landedPriceDTOs;
	}
	

}
