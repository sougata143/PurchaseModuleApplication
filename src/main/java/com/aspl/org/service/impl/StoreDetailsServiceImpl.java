package com.aspl.org.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.DepartmentForGRNDTO;
import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.StoreDetailsDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.DepartmentMaster;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.StoreDetails;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.DepartmentMasterRepo;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.StoreDetailsDao;
import com.aspl.org.service.StoreDetailsService;


/*
 * Service for Store details
 */
@Service
@Transactional
public class StoreDetailsServiceImpl implements StoreDetailsService {

	
	@Autowired 
	StoreDetailsDao storeDetailsDao;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	DepartmentMasterRepo deptRepo;
	
	@Autowired
	ItemMasterDao itemDao;
	
	
	
	/*
	 * @Param StoreDetails
	 * 
	 * Method for converting Entity to DTO
	 * 
	 * @Return StoreDetailsDTO
	 */
	@Override
	public StoreDetailsDTO prepareStoreDetailsDTO(StoreDetails storeDetails) {
		
		StoreDetailsDTO storeDetailsDTO = new StoreDetailsDTO();
		storeDetailsDTO.setBarCode(storeDetails.getBarCode());
		
		CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
		Category category = new Category();
		
		if(storeDetails.getCategory()!=null && !storeDetails.getCategory().equals("null") && !storeDetails.getCategory().equals("")) {
			Optional<Category> categoryO = categoryRepo.findById(Integer.valueOf(storeDetails.getCategory()));
			if(categoryO.isPresent()) {
				category = categoryO.get();
			}
		}
		
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryName(category.getCategoryName());
		
		storeDetailsDTO.setCategory(categoryDTO);
		
		DepartmentForGRNDTO detpartmentDTO = new DepartmentForGRNDTO();
		
		DepartmentMaster dept = new DepartmentMaster();
		if(storeDetails.getDepartment()!=null && !storeDetails.getDepartment().equals("null") && !storeDetails.getDepartment().equals("")) {
			Optional<DepartmentMaster> deptO = deptRepo.findById(Integer.valueOf(storeDetails.getDepartment()));
			if(deptO.isPresent()) {
				dept = deptO.get();
			}
		}
		
		detpartmentDTO.setDepartmentdetails(dept.getDepartmentdetails());
		detpartmentDTO.setDepartmentId(dept.getDepartmentId());
		detpartmentDTO.setDepartmentname(dept.getDepartmentname());
		
		storeDetailsDTO.setDepartment(detpartmentDTO);
		
		storeDetailsDTO.setHsCode(storeDetails.getHsCode());
		storeDetailsDTO.setId(storeDetails.getId());
		storeDetailsDTO.setMinimum(storeDetails.getMinimum());
		
		ItemMaster item = new ItemMaster();
		if(storeDetails.getItemId()!=null) {
			Optional<ItemMaster> itemO = itemDao.findById(storeDetails.getItemId());
			if(itemO.isPresent()) {
				item = itemO.get();
			}
		}
		
		ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO(); 
		itemDTO.setItemCode(item.getItemCode());
		itemDTO.setItemId(item.getId());
		itemDTO.setItemName(item.getItemName());
		
		storeDetailsDTO.setItem(itemDTO);
		
		storeDetailsDTO.setQuantity(storeDetails.getQuantity());
		storeDetailsDTO.setReorder(storeDetails.getReorder());
		storeDetailsDTO.setSapCode(storeDetails.getSapCode());
		storeDetailsDTO.setExpiryDate(storeDetails.getExpiryDate());
		storeDetailsDTO.setUnit(storeDetails.getUnit());
		storeDetailsDTO.setWtPerUnit(storeDetails.getWtPerUnit());
		
		return storeDetailsDTO;
	}


	/*
	 * @Param storeDetailsDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return StoreDetails
	 */
	@Override
	public StoreDetails prepareStoreDetails(StoreDetailsDTO storeDetailsDTO) {
		
		StoreDetails storeDetails = new StoreDetails();
		storeDetails.setBarCode(storeDetailsDTO.getBarCode());
		storeDetails.setCategory(String.valueOf(storeDetailsDTO.getCategory().getCategoryId()));
		
		if(storeDetailsDTO.getDepartment()!=null)
			storeDetails.setDepartment(String.valueOf(storeDetailsDTO.getDepartment().getDepartmentId()));
		
		storeDetails.setHsCode(storeDetailsDTO.getHsCode());
		storeDetails.setMinimum(storeDetailsDTO.getMinimum());
		storeDetails.setItemCode(String.valueOf(storeDetailsDTO.getItem().getItemCode()));
		storeDetails.setItemId(storeDetailsDTO.getItem().getItemId());
		storeDetails.setItemName(storeDetailsDTO.getItem().getItemName());
		storeDetails.setQuantity(storeDetailsDTO.getQuantity());
		storeDetails.setReorder(storeDetailsDTO.getReorder());
		storeDetails.setSapCode(storeDetailsDTO.getSapCode());
		storeDetails.setUnit(storeDetailsDTO.getUnit());
		storeDetails.setWtPerUnit(storeDetailsDTO.getWtPerUnit());
		storeDetails.setExpiryDate(storeDetailsDTO.getExpiryDate());
		
		return storeDetails;
	}	
	
	
	/*
	 * Method for fetching all store details
	 * 
	 * @Return List<StoreDetailsDTO>
	 */
	@Override
	public List<StoreDetailsDTO> getAllStoreList() {
		List<StoreDetailsDTO> storeDetailsDTOs = new ArrayList<>();
		try {
			List<StoreDetails> storeDetailsList = storeDetailsDao.findAll();
			for(StoreDetails sd : storeDetailsList) {
				StoreDetailsDTO storeDTO = new StoreDetailsDTO();
				storeDTO = prepareStoreDetailsDTO(sd);
				storeDetailsDTOs.add(storeDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return storeDetailsDTOs;
	}
	
	
	/*
	 * @Param itemName
	 * 
	 * Method for fetching store by item name
	 * 
	 * @Return StoreDetailsDTO
	 */
	@Override
	public StoreDetailsDTO findStoreDetailsByItemName(String itemName) {
		
		//int item_code=Integer.parseInt(itemName);
		StoreDetailsDTO storeDTO = new StoreDetailsDTO();
		try {
			StoreDetails storeDetails = storeDetailsDao.findStoreDetailsByItemName(itemName);
			storeDTO = prepareStoreDetailsDTO(storeDetails);
		}catch(Exception e){
			e.printStackTrace();
		}
		return storeDTO;

	}
	
	/*
	 * @Param itemCode
	 * 
	 * Method for fetching store by item code
	 * 
	 * @Return StoreDetailsDTO
	 */
	  @Override
	  public List<StoreDetailsDTO> findStoreDetailsByItemCode(String itemCode) {
	  //("itemCode: "+itemCode);
		  StoreDetailsDTO storeDTO = new StoreDetailsDTO();
		  List<StoreDetailsDTO> storeDTOs = new ArrayList<>();
			try {
				List<StoreDetails> storeDetails = storeDetailsDao.findByItemCode(itemCode);
				for(StoreDetails sd : storeDetails) {
					storeDTO = prepareStoreDetailsDTO(sd);
					storeDTOs.add(storeDTO);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return storeDTOs;
	  
	  }


	  /*
	   * @Param storeDetailsDTO
	   * 
	   * Method for saving store deails
	   * 
	   * @Return StoreDetailsDTO
	   */
	@Override
	public StoreDetails saveStoreDetails(StoreDetailsDTO storeDetailsDTO) {
		
		StoreDetails storeDetailsReturnEntity = new StoreDetails();
		try {
			StoreDetails storeDetailsReturn = prepareStoreDetails(storeDetailsDTO);
			
			storeDetailsReturnEntity = storeDetailsDao.save(storeDetailsReturn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return storeDetailsReturnEntity;
	}
	
	/*
	 * @Param storeDetailsDTO
	 * 
	 * Method for updating store details
	 * 
	 * @Return StoreDetailsDTO
	 */
	@Override
	public StoreDetailsDTO updateStoreDetails(StoreDetailsDTO storeDetailsDTO) {
		
		try {
			if(storeDetailsDTO.getId()!=0) {
				StoreDetails storeDetailsReturn =  prepareStoreDetails(storeDetailsDTO);
				StoreDetails storeDetailsReturnEntity = storeDetailsDao.save(storeDetailsReturn);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return storeDetailsDTO;
	}

	@Override
	public List<StoreDetailsDTO> findStoreDetailsByItemId(Integer itemId) {
		
		StoreDetailsDTO storeDTO = new StoreDetailsDTO();
		  List<StoreDetailsDTO> storeDTOs = new ArrayList<>();
			try {
				List<StoreDetails> storeDetails = storeDetailsDao.findByItemId(itemId);
				for(StoreDetails sd : storeDetails) {
					storeDTO = prepareStoreDetailsDTO(sd);
					storeDTOs.add(storeDTO);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return storeDTOs;
	}


	/*
	 * @Param ExpiryDate
	 * 
	 * Method for finding expired items
	 * 
	 * @Return List<StoreDetailsDTO>
	 */
	@Override
	public List<StoreDetailsDTO> findExpiredStoreDetails() {
		
		StoreDetailsDTO storeDTO = new StoreDetailsDTO();
		List<StoreDetailsDTO> storeDTOs = new ArrayList<>();
		try {
			LocalDate currDateLD = LocalDate.now();
			Date currDateD = new SimpleDateFormat("yyyy-MM-dd").parse(currDateLD.toString());
			
			List<StoreDetails> storeDetails = storeDetailsDao.findAll();
			for(StoreDetails sd : storeDetails) {
				if(sd.getExpiryDate().before(currDateD)) {
					if(sd.getQuantity()!=0) {
						storeDTO = prepareStoreDetailsDTO(sd);
						storeDTOs.add(storeDTO);
					}
				}
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return storeDTOs;
	}


	@Override
	public List<StoreDetailsDTO> findCloseToExpireStoreDetails() {
		
		StoreDetailsDTO storeDTO = new StoreDetailsDTO();
		List<StoreDetailsDTO> storeDTOs = new ArrayList<>();
		try {
			LocalDate currDateLD = LocalDate.now();
			
			Date currDateD = new SimpleDateFormat("yyyy-MM-dd").parse(currDateLD.toString());
			Date toBeExpDateD = new SimpleDateFormat("yyyy-MM-dd").parse(currDateLD.plusMonths(3).toString());
			
//			System.out.println(currDateLD+ " / "+ currDateD +" / "+toBeExpDateD);
			List<StoreDetails> storeDetails = storeDetailsDao.findAll();
			for(StoreDetails sd : storeDetails) {
				if(sd.getExpiryDate().after(currDateD) && sd.getExpiryDate().before(toBeExpDateD)) {
					storeDTO = prepareStoreDetailsDTO(sd);
					storeDTOs.add(storeDTO);
				}
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return storeDTOs;
	}


	@Override
	public StoreDetails dumpExpiredStore(Integer storeId) {
		
		StoreDetailsDTO storeDTO = new StoreDetailsDTO();
		StoreDetails store = new StoreDetails();
		try {
			if(storeId!=null) {
				Optional<StoreDetails> storeO = storeDetailsDao.findById(storeId);
				if(storeO.isPresent()) {
					store = storeO.get();
//					storeDTO = prepareStoreDetailsDTO(store);
				}
			}
			 
			LocalDate currDateLD = LocalDate.now();
			
			Date currDateD = new SimpleDateFormat("yyyy-MM-dd").parse(currDateLD.toString());
			Date toBeExpDateD = new SimpleDateFormat("yyyy-MM-dd").parse(currDateLD.plusMonths(3).toString());
			
			if(store.getExpiryDate().before(currDateD)) {
				store.setQuantity(0.0);
				storeDetailsDao.save(store);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return store;
	}
}
