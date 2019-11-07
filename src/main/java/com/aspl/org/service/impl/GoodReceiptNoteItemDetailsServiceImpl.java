package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.DepartmentForGRNDTO;
import com.aspl.org.dto.GoodReceiptNoteItemDetailsDTO;
import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.PoDetailsDTO;
import com.aspl.org.dto.SubCategoryForMappingDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.DepartmentMaster;
import com.aspl.org.entity.GoodReceiptNoteItemDetails;
import com.aspl.org.entity.GoodsRecieptNoteHeader;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.PurchaseDetails;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.DepartmentMasterRepo;
import com.aspl.org.repository.GoodReceiptNoteItemDetailsRepository;
import com.aspl.org.repository.GoodsReceiptNoteRepository;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.PurchaseDetailsDao;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.repository.UomMasterRepo;
import com.aspl.org.service.GoodReceiptNoteItemDetailsService;
import com.aspl.org.utils.GlobalDefine;

/*
 * Service for back end logic of GoodsReceiptNoteItemDetails
 */
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class GoodReceiptNoteItemDetailsServiceImpl implements GoodReceiptNoteItemDetailsService {
	
	@Autowired
	GoodReceiptNoteItemDetailsRepository grnDetailsRepo;
	
	@Autowired
	GoodsReceiptNoteRepository grnHeaderRepo;
	
	@Autowired
	PurchaseDetailsDao purchaseDetailsDao;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	DepartmentMasterRepo departmentRepo;
	
	@Autowired
	UomMasterRepo uomRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	SubCategoryRepo subCategoryRepo;	

	/*
	 * Method for getting all the GRN items
	 * 
	 * @Return List<GoodReceiptNoteItemDetailsDTO>
	 */
	@Override
	public List<GoodReceiptNoteItemDetailsDTO> getAllGoodReceiptNoteItemDetails() {
		List<GoodReceiptNoteItemDetailsDTO> grnDetailsDTOs = new ArrayList<>();
		try {
			List<GoodReceiptNoteItemDetails> grnDetails = grnDetailsRepo.findAll();
			for(GoodReceiptNoteItemDetails grn : grnDetails) {
				GoodReceiptNoteItemDetailsDTO grnDetailsDTO = prepareGoodReceiptNoteItemDetailsDTO(grn);
				grnDetailsDTOs.add(grnDetailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDetailsDTOs;
	}

	/*
	 * @Param detailsId
	 * 
	 * Method getting GRN details by details id
	 * 
	 * @Return GoodReceiptNoteItemDetailsDTO
	 */
	@Override
	public GoodReceiptNoteItemDetailsDTO getGoodReceiptNoteItemDetailsByDetailsId(Integer detaislId) {
		
		GoodReceiptNoteItemDetailsDTO grnDetailsDTO = new GoodReceiptNoteItemDetailsDTO();
		try {
			GoodReceiptNoteItemDetails grnDetails = grnDetailsRepo.findById(detaislId).get();
			grnDetailsDTO = prepareGoodReceiptNoteItemDetailsDTO(grnDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDetailsDTO;
	}

	/*
	 * @Param grnHeaderId
	 * 
	 * Method fetching GRN items by GRN header
	 * 
	 * @Return List<GoodReceiptNoteItemDetailsDTO>
	 */
	@Override
	public List<GoodReceiptNoteItemDetailsDTO> getGoodReceiptNoteItemDetailsByGrnHeaderId(Integer grnHeaderId) {
	
		List<GoodReceiptNoteItemDetailsDTO> grnDetailsDTOs = new ArrayList<>();
		try {
			List<GoodReceiptNoteItemDetails> grnDetails = grnDetailsRepo.findByGrnHeaderId(grnHeaderId);
			for(GoodReceiptNoteItemDetails grn : grnDetails) {
				GoodReceiptNoteItemDetailsDTO grnDetailsDTO = prepareGoodReceiptNoteItemDetailsDTO(grn);
				grnDetailsDTOs.add(grnDetailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDetailsDTOs;
	}
	
	/*
	 * @Param grnHeaderId
	 * 
	 * Method fetching GRN items by GRN header
	 * 
	 * @Return List<GoodReceiptNoteItemDetailsDTO>
	 */
	@Override
	public List<GoodReceiptNoteItemDetailsDTO> getGoodReceiptNoteItemDetailsByGrnHeaderIdAndQcStatus(Integer grnHeaderId, Integer qcAccept) {
		
		List<GoodReceiptNoteItemDetailsDTO> grnDetailsDTOs = new ArrayList<>();
		try {
			List<GoodReceiptNoteItemDetails> grnDetails = grnDetailsRepo.findByGrnHeaderIdAndDetailsQcStatus(grnHeaderId, 0);
			for(GoodReceiptNoteItemDetails grn : grnDetails) {
				GoodReceiptNoteItemDetailsDTO grnDetailsDTO = prepareGoodReceiptNoteItemDetailsDTO(grn);
				grnDetailsDTOs.add(grnDetailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDetailsDTOs;
	}
	
	/*
	 * @Param grnHeaderId
	 * 
	 * Method fetching GRN items by GRN header
	 * 
	 * @Return List<GoodReceiptNoteItemDetailsDTO>
	 */
	@Override
	public List<GoodReceiptNoteItemDetailsDTO> getGoodReceiptNoteItemDetailsByGrnHeaderIdAndQcStatusAccepted(Integer grnHeaderId, Integer qcAccept) {
		
		List<GoodReceiptNoteItemDetailsDTO> grnDetailsDTOs = new ArrayList<>();
		try {
			List<GoodReceiptNoteItemDetails> grnDetails = grnDetailsRepo.findByGrnHeaderIdAndDetailsQcStatus(grnHeaderId, 2);
			for(GoodReceiptNoteItemDetails grn : grnDetails) {
				GoodReceiptNoteItemDetailsDTO grnDetailsDTO = prepareGoodReceiptNoteItemDetailsDTO(grn);
				grnDetailsDTOs.add(grnDetailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDetailsDTOs;
	}
	
	/*
	 * @Param grnHeaderId
	 * 
	 * Method fetching GRN items by GRN header
	 * 
	 * @Return List<GoodReceiptNoteItemDetailsDTO>
	 */
	@Override
	public List<GoodReceiptNoteItemDetailsDTO> getAuthorizedGoodReceiptNoteItemDetailsByGrnHeaderId(Integer grnHeaderId) {
		
		List<GoodReceiptNoteItemDetailsDTO> grnDetailsDTOs = new ArrayList<>();
		try {
			List<GoodReceiptNoteItemDetails> grnDetails = grnDetailsRepo.findByGrnHeaderIdAndDetailsStatus(grnHeaderId, GlobalDefine.grnAccept);
			for(GoodReceiptNoteItemDetails grn : grnDetails) {
				GoodReceiptNoteItemDetailsDTO grnDetailsDTO = prepareGoodReceiptNoteItemDetailsDTO(grn);
				grnDetailsDTOs.add(grnDetailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDetailsDTOs;
	}
	
	/*
	 * @Param grnHeaderId
	 * 
	 * Method fetching GRN items by GRN header
	 * 
	 * @Return List<GoodReceiptNoteItemDetailsDTO>
	 */
	@Override
	public List<GoodReceiptNoteItemDetailsDTO> getUnAuthorizedGoodReceiptNoteItemDetailsByGrnHeaderId(Integer grnHeaderId) {
	
		List<GoodReceiptNoteItemDetailsDTO> grnDetailsDTOs = new ArrayList<>();
		try {
			List<GoodReceiptNoteItemDetails> grnDetails = grnDetailsRepo.findByGrnHeaderIdAndDetailsStatus(grnHeaderId, GlobalDefine.grnPending);
			for(GoodReceiptNoteItemDetails grn : grnDetails) {
				GoodReceiptNoteItemDetailsDTO grnDetailsDTO = prepareGoodReceiptNoteItemDetailsDTO(grn);
				grnDetailsDTOs.add(grnDetailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDetailsDTOs;
	}

	/*
	 * @Param goodReceiptNoteItemDetailsDTO
	 * 
	 * Method for saving GRN items
	 * 
	 * @Return GoodReceiptNoteItemDetailsDTO
	 * 
	 */
	@Override
	public GoodReceiptNoteItemDetails saveGoodReceiptNoteItemDetailsDTO(
			GoodReceiptNoteItemDetailsDTO goodReceiptNoteItemDetailsDTO) {
		
		GoodReceiptNoteItemDetails grnDetailsEntity = new GoodReceiptNoteItemDetails();
		try {
			GoodReceiptNoteItemDetails grnDetails = prepareGoodReceiptNoteItemDetails(goodReceiptNoteItemDetailsDTO);
			
			grnDetailsEntity = grnDetailsRepo.save(grnDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDetailsEntity;
	}

	/*
	 * @Param goodReceiptNoteItemDetailsDTO
	 * 
	 * This method is for updating the GRN item details
	 * 
	 * @Return GoodReceiptNoteItemDetailsDTO
	 */
	@Override
	public GoodReceiptNoteItemDetails updateGoodReceiptNoteItemDetailsDTO(
			GoodReceiptNoteItemDetailsDTO goodReceiptNoteItemDetailsDTO) {
		
		GoodReceiptNoteItemDetails grnDetailsEntity = new GoodReceiptNoteItemDetails();
		try {
			GoodReceiptNoteItemDetails grnDetails = prepareGoodReceiptNoteItemDetails(goodReceiptNoteItemDetailsDTO);
			
			grnDetailsEntity = grnDetailsRepo.save(grnDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDetailsEntity;
	}

	/*
	 * @Param detailsId
	 * 
	 * This method is for delete GRN item details
	 */
	@Override
	public void deleteGoodReceiptNoteItemDetails(Integer detailsId) {
		
		try {
			grnDetailsRepo.deleteById(detailsId);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Param goodReceiptNoteItemDetails
	 * 
	 * This method is for preparing DTO from Entity
	 * 
	 * @Return GoodReceiptNoteItemDetailsDTO
	 */
	@Override
	public GoodReceiptNoteItemDetailsDTO prepareGoodReceiptNoteItemDetailsDTO(
			GoodReceiptNoteItemDetails goodReceiptNoteItemDetails) {
		
		GoodReceiptNoteItemDetailsDTO goodReceiptNoteItemDetailsDTO = new GoodReceiptNoteItemDetailsDTO();
		
		goodReceiptNoteItemDetailsDTO.setAcceptedQnt(goodReceiptNoteItemDetails.getAcceptedQnt());
		
		if(goodReceiptNoteItemDetails.getAvailableQnt()!=null)
			goodReceiptNoteItemDetailsDTO.setAvailableQnt(goodReceiptNoteItemDetails.getAvailableQnt());
		else
			goodReceiptNoteItemDetailsDTO.setAvailableQnt(0.0);
		
		goodReceiptNoteItemDetailsDTO.setBatchNo(goodReceiptNoteItemDetails.getBatchNo());
		goodReceiptNoteItemDetailsDTO.setBatchQnt(goodReceiptNoteItemDetails.getBatchQnt());
		goodReceiptNoteItemDetailsDTO.setExpiryDate(goodReceiptNoteItemDetails.getExpiryDate());
		goodReceiptNoteItemDetailsDTO.setGrnDetailsId(goodReceiptNoteItemDetails.getGrnDetailsId());
		goodReceiptNoteItemDetailsDTO.setInvoiceQnt(goodReceiptNoteItemDetails.getInvoiceQnt());
		
		if(goodReceiptNoteItemDetails.getPendingOrderedQnt()!=null)
			goodReceiptNoteItemDetailsDTO.setPendingOrderedQnt(goodReceiptNoteItemDetails.getPendingOrderedQnt());
		else
			goodReceiptNoteItemDetailsDTO.setPendingOrderedQnt(0.0);
		
		if(goodReceiptNoteItemDetails.getPrice()!=null)
			goodReceiptNoteItemDetailsDTO.setPrice(goodReceiptNoteItemDetails.getPrice());
		else
			goodReceiptNoteItemDetailsDTO.setPrice(0.0);
		
		goodReceiptNoteItemDetailsDTO.setProcess(goodReceiptNoteItemDetails.getProcess());
		goodReceiptNoteItemDetailsDTO.setRateType(goodReceiptNoteItemDetails.getRateType());
		goodReceiptNoteItemDetailsDTO.setReason(goodReceiptNoteItemDetails.getReason());
		
		if(goodReceiptNoteItemDetails.getRejectedQnt()!=null)
			goodReceiptNoteItemDetailsDTO.setRejectedQnt(goodReceiptNoteItemDetails.getRejectedQnt());
		else
			goodReceiptNoteItemDetailsDTO.setRejectedQnt(0.0);
		
		if(goodReceiptNoteItemDetails.getReceivedQnt()!=null)
			goodReceiptNoteItemDetailsDTO.setReceivedQnt(goodReceiptNoteItemDetails.getReceivedQnt());
		else
			goodReceiptNoteItemDetailsDTO.setReceivedQnt(0.0);
		
		if(goodReceiptNoteItemDetails.getWeight()!=null)
			goodReceiptNoteItemDetailsDTO.setWeight(goodReceiptNoteItemDetails.getWeight());
		else
			goodReceiptNoteItemDetailsDTO.setWeight(0.0);
		
		goodReceiptNoteItemDetailsDTO.setGrnHeaderId(String.valueOf(goodReceiptNoteItemDetails.getGrnHeaderId()));
		
		goodReceiptNoteItemDetailsDTO.setDetailsStatus(goodReceiptNoteItemDetails.getDetailsStatus());
		goodReceiptNoteItemDetailsDTO.setDetailsQcStatus(goodReceiptNoteItemDetails.getDetailsQcStatus());
		
		goodReceiptNoteItemDetailsDTO.setMfgDate(goodReceiptNoteItemDetails.getMfgDate());
		
		//Fetching UOM
		UomMaster uomDTO = new UomMaster();
		if(goodReceiptNoteItemDetails.getUomId()!=null && goodReceiptNoteItemDetails.getUomId()!="null") {
			Optional<UomMaster> uomO = uomRepo.findById(Integer.valueOf(goodReceiptNoteItemDetails.getUomId())); 
			UomMaster uom = uomO.get();
			
			uomDTO.setDecimalPlace(uom.getDecimalPlace());
			uomDTO.setIsActive(uom.getIsActive());
			uomDTO.setUomCode(uom.getUomCode());
			uomDTO.setUomDescription(uom.getUomDescription());
			uomDTO.setUomId(uom.getUomId());
			
			goodReceiptNoteItemDetailsDTO.setUomDTO(uomDTO);
		}
		
		
		DepartmentForGRNDTO deptDTO = new DepartmentForGRNDTO();
		//For getting department 
		if(goodReceiptNoteItemDetails.getDepartmentId()!=null) {
			Optional<DepartmentMaster> deptO = departmentRepo.findById(Integer.valueOf(goodReceiptNoteItemDetails.getDepartmentId()));
			
			if(deptO.isPresent()) {
				DepartmentMaster dept = deptO.get();
				
				deptDTO.setDepartmentdetails(dept.getDepartmentdetails());
				deptDTO.setDepartmentId(dept.getDepartmentId());
				deptDTO.setDepartmentname(dept.getDepartmentname());
				
				goodReceiptNoteItemDetailsDTO.setDepartment(deptDTO);
			}
			
		}
		
		ItemMaster item = new ItemMaster();
		//for getting items
		if(goodReceiptNoteItemDetails.getItemCode()!=null) {
			Optional<ItemMaster> itemO = itemDao.findById(goodReceiptNoteItemDetails.getItemId());
			item = itemO.get();
		}
		ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
		
		CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
		SubCategoryForMappingDTO subCategoryDTO = new SubCategoryForMappingDTO();
		
		Category category = new Category();
		SubCategory subCategory = new SubCategory();
		//for getting category
		if(item.getCategoryId2()!=null) {
			Optional<Category> categoryO = categoryRepo.findById(item.getCategoryId2());
			if(categoryO.isPresent()) {
				category = categoryO.get();
				
				categoryDTO.setCategoryId(category.getCategoryId());
				categoryDTO.setCategoryName(category.getCategoryName());
			}
		}
		//for getting sub category
		if(item.getSubCategoryId2()!=null) {
			Optional<SubCategory> subCategoryO = subCategoryRepo.findById(item.getSubCategoryId2());
			if(subCategoryO.isPresent()) {
				subCategory = subCategoryO.get();
				
				subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
				subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
			}
		}
		
		itemDTO.setCategory(categoryDTO);
		itemDTO.setItemCode(item.getItemCode());
		itemDTO.setItemId(item.getId());
		itemDTO.setItemName(item.getItemName());
		itemDTO.setSubCategory(subCategoryDTO);
		itemDTO.setVendorId(item.getVendorCode());
		goodReceiptNoteItemDetailsDTO.setItem(itemDTO);
		
		goodReceiptNoteItemDetailsDTO.setWtPerUnit(goodReceiptNoteItemDetails.getWtPerUnit());
		
//		List<PurchaseDetails> poDetails = purchaseDetailsDao.findByPoid(Integer.valueOf(grnHeader.getPoId()));
		
		PurchaseDetails po = new PurchaseDetails();
		if(goodReceiptNoteItemDetails.getPoDetailsId()!=null) {
			if(goodReceiptNoteItemDetails.getPoDetailsId()!=0 && goodReceiptNoteItemDetails.getPoDetailsId()!=null && !goodReceiptNoteItemDetails.getPoDetailsId().equals("null")) {
				Optional<PurchaseDetails> poDetailsO = purchaseDetailsDao.findById(goodReceiptNoteItemDetails.getPoDetailsId());
				if(poDetailsO.isPresent()) {
					po = poDetailsO.get();
				}
			}
		}
		
//		List<PoDetailsDTO> poDetailsDTOs = new ArrayList<>();
		
		/*for(PurchaseDetails po : poDetails) {
			PoDetailsDTO poDetailsDTO = new PoDetailsDTO();
			
			poDetailsDTO.setAccountsHead(po.getAccountsHead());
			poDetailsDTO.setAssesValue(po.getAssesValue());
			poDetailsDTO.setBaseUom(po.getBaseUom());
			poDetailsDTO.setConvQty(po.getConvQty());
			poDetailsDTO.setDescription(po.getDescription());
			poDetailsDTO.setDisc(po.getDisc());
			poDetailsDTO.setId(po.getId());
			poDetailsDTO.setIndentReqQty(po.getIndentReqQty());
			poDetailsDTO.setItemCode(po.getItemCode());
			poDetailsDTO.setMake(po.getMake());
			poDetailsDTO.setMaxQty(po.getMaxQty());
			poDetailsDTO.setMinQty(po.getMinQty());
			poDetailsDTO.setPendingIndentQty(po.getPendingIndentQty());
			poDetailsDTO.setPendingPurQty(po.getPendingPurQty());
			poDetailsDTO.setPendingSale(po.getPendingSale());
			poDetailsDTO.setPoid(po.getPoid());
			poDetailsDTO.setPurPrice(po.getPurPrice());
			poDetailsDTO.setPurQty(po.getPurQty());
			poDetailsDTO.setPurUom(po.getPurUom());
			poDetailsDTO.setQcSpec(po.getQcSpec());
			poDetailsDTO.setRemarks(po.getRemarks());
			poDetailsDTO.setReorderLevel(po.getReorderLevel());
			poDetailsDTO.setTariff(po.getTariff());
			poDetailsDTO.setTotal(po.getTotal());
			poDetailsDTO.setWeight(po.getWeight());
			
			poDetailsDTOs.add(poDetailsDTO);
		}*/
		
		PoDetailsDTO poDetailsDTO = new PoDetailsDTO();
		
		if(po.getId()!=null) {
			poDetailsDTO.setAccountsHead(po.getAccountsHead());
			
			if(po.getAssesValue()!=null)
				poDetailsDTO.setAssesValue(po.getAssesValue());
			else
				poDetailsDTO.setAssesValue(0.0);
			
			poDetailsDTO.setBaseUom(po.getBaseUom());
			
			if(po.getConvQty()!=null)
				poDetailsDTO.setConvQty(po.getConvQty());
			else
				poDetailsDTO.setConvQty(0.0);
			
			poDetailsDTO.setDescription(po.getDescription());
			
			if(po.getDisc()!=null)
				poDetailsDTO.setDisc(po.getDisc());
			else
				poDetailsDTO.setDisc(0.0);
			
			poDetailsDTO.setId(po.getId());
			
			if(po.getIndentReqQty()!=null)
				poDetailsDTO.setIndentReqQty(po.getIndentReqQty());
			
			poDetailsDTO.setItemCode(po.getItemCode());
			poDetailsDTO.setMake(po.getMake());
			
			if(po.getMaxQty()!=null)
				poDetailsDTO.setMaxQty(po.getMaxQty());
			else
				poDetailsDTO.setMaxQty(0.0);
			
			if(po.getMinQty()!=null)
				poDetailsDTO.setMinQty(po.getMinQty());
			else
				poDetailsDTO.setMinQty(0.0);
			
			if(po.getPendingIndentQty()!=null)
				poDetailsDTO.setPendingIndentQty(po.getPendingIndentQty());
			else
				poDetailsDTO.setPendingIndentQty(0.0);
			
			if(po.getPendingPurQty()!=null)
				poDetailsDTO.setPendingPurQty(po.getPendingPurQty());
			else
				poDetailsDTO.setPendingPurQty(0.0);
			
			if(po.getPendingSale()!=null)
				poDetailsDTO.setPendingSale(po.getPendingSale());
			else
				poDetailsDTO.setPendingSale(0.0);
			
			poDetailsDTO.setPoid(po.getPoid());
			
			if(po.getPurPrice()!=null)
				poDetailsDTO.setPurPrice(po.getPurPrice());
			else
				poDetailsDTO.setPurPrice(0.0);
			
			if(po.getPurQty()!=null && !po.getPurQty().equals("null"))
				poDetailsDTO.setPurQty(po.getPurQty());
			
			poDetailsDTO.setPurUom(po.getPurUom());
			poDetailsDTO.setQcSpec(po.getQcSpec());
			poDetailsDTO.setRemarks(po.getRemarks());
			
			if(po.getReorderLevel()!=null)
				poDetailsDTO.setReorderLevel(po.getReorderLevel());
			else
				poDetailsDTO.setReorderLevel(0.0);
			
			poDetailsDTO.setTariff(po.getTariff());
			
			if(po.getTotal()!=null)
				poDetailsDTO.setTotal(po.getTotal());
			else
				poDetailsDTO.setTotal(0.0);
			
			if(po.getWeight()!=null && !po.getWeight().equals("null"))
				poDetailsDTO.setWeight(po.getWeight());
			
			if(poDetailsDTO!=null)
				goodReceiptNoteItemDetailsDTO.setPoDetails(poDetailsDTO);
			
			goodReceiptNoteItemDetailsDTO.setPoDetailsId(po.getId());
		}
		
		
		return goodReceiptNoteItemDetailsDTO;
	}

	/*
	 * @Param goodReceiptNoteItemDetailsDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return GoodReceiptNoteItemDetails
	 */
	@Override
	public GoodReceiptNoteItemDetails prepareGoodReceiptNoteItemDetails(
									GoodReceiptNoteItemDetailsDTO goodReceiptNoteItemDetailsDTO) {
		
		GoodReceiptNoteItemDetails goodReceiptNoteItemDetails = new GoodReceiptNoteItemDetails();
		
		if(goodReceiptNoteItemDetailsDTO.getGrnDetailsId()!=null) {
			
			Optional<GoodReceiptNoteItemDetails> grnDetailsO = grnDetailsRepo.findById(goodReceiptNoteItemDetailsDTO.getGrnDetailsId());
			
			if(grnDetailsO.isPresent()) {
				goodReceiptNoteItemDetails = grnDetailsO.get();
			}
			
		}
		
		if(goodReceiptNoteItemDetailsDTO.getAvailableQnt()!=null)
			goodReceiptNoteItemDetails.setAvailableQnt(goodReceiptNoteItemDetailsDTO.getAvailableQnt());
		else
			goodReceiptNoteItemDetails.setAvailableQnt(0.0);
		
		goodReceiptNoteItemDetails.setBatchNo(goodReceiptNoteItemDetailsDTO.getBatchNo());
		
		if(goodReceiptNoteItemDetailsDTO.getBatchQnt()!=null)
			goodReceiptNoteItemDetails.setBatchQnt(goodReceiptNoteItemDetailsDTO.getBatchQnt());
		else
			goodReceiptNoteItemDetails.setBatchQnt(goodReceiptNoteItemDetailsDTO.getBatchQnt());
		
		goodReceiptNoteItemDetails.setDepartmentId(goodReceiptNoteItemDetailsDTO.getDepartmentId());
		goodReceiptNoteItemDetails.setExpiryDate(goodReceiptNoteItemDetailsDTO.getExpiryDate());
		goodReceiptNoteItemDetails.setGrnHeaderId(Integer.valueOf(goodReceiptNoteItemDetailsDTO.getGrnHeaderId()));
		
		if(goodReceiptNoteItemDetailsDTO.getInvoiceQnt()!=null)
			goodReceiptNoteItemDetails.setInvoiceQnt(goodReceiptNoteItemDetailsDTO.getInvoiceQnt());
		else
			goodReceiptNoteItemDetails.setInvoiceQnt(0.0);
		
		goodReceiptNoteItemDetails.setItemCode(goodReceiptNoteItemDetailsDTO.getItem().getItemCode());
		goodReceiptNoteItemDetails.setItemName(goodReceiptNoteItemDetailsDTO.getItem().getItemName());
		
		if(goodReceiptNoteItemDetailsDTO.getPendingOrderedQnt()!=null)
			goodReceiptNoteItemDetails.setPendingOrderedQnt(goodReceiptNoteItemDetailsDTO.getPendingOrderedQnt());
		else
			goodReceiptNoteItemDetails.setPendingOrderedQnt(0.0);
		
		if(goodReceiptNoteItemDetailsDTO.getPrice()!=null)
			goodReceiptNoteItemDetails.setPrice(goodReceiptNoteItemDetailsDTO.getPrice());
		else
			goodReceiptNoteItemDetails.setPrice(goodReceiptNoteItemDetailsDTO.getPrice());
		
		goodReceiptNoteItemDetails.setProcess(goodReceiptNoteItemDetailsDTO.getProcess());
		goodReceiptNoteItemDetails.setRateType(goodReceiptNoteItemDetailsDTO.getRateType());
		goodReceiptNoteItemDetails.setReason(goodReceiptNoteItemDetailsDTO.getReason());
		
		if(goodReceiptNoteItemDetailsDTO.getWtPerUnit()!=null)
			goodReceiptNoteItemDetails.setWtPerUnit(goodReceiptNoteItemDetailsDTO.getWtPerUnit());
		else
			goodReceiptNoteItemDetails.setWtPerUnit(0.0);
		
		goodReceiptNoteItemDetails.setDetailsQcStatus(GlobalDefine.grnPending);
		goodReceiptNoteItemDetails.setDetailsStatus(GlobalDefine.grnPending);
		goodReceiptNoteItemDetails.setUomId(String.valueOf(goodReceiptNoteItemDetailsDTO.getUomDTO().getUomId()));
		
		if(goodReceiptNoteItemDetailsDTO.getRejectedQnt()!=null)
			goodReceiptNoteItemDetails.setRejectedQnt(goodReceiptNoteItemDetailsDTO.getRejectedQnt());
		else
			goodReceiptNoteItemDetails.setRejectedQnt(0.0);
		
		goodReceiptNoteItemDetails.setUomId(String.valueOf(goodReceiptNoteItemDetailsDTO.getUomDTO().getUomId()));
		
		if(goodReceiptNoteItemDetailsDTO.getWeight()!=null)
			goodReceiptNoteItemDetails.setWeight(goodReceiptNoteItemDetailsDTO.getWeight());
		else
			goodReceiptNoteItemDetails.setWeight(0.0);
		
		goodReceiptNoteItemDetails.setItemId(goodReceiptNoteItemDetailsDTO.getItem().getItemId());
		
		goodReceiptNoteItemDetails.setMfgDate(goodReceiptNoteItemDetailsDTO.getMfgDate());
		
		goodReceiptNoteItemDetails.setPoDetailsId(goodReceiptNoteItemDetailsDTO.getPoDetailsId());
		
		Double wtPerUnit = 0.0;
		Double receivedQnt = 0.0;
		Double acceptedQnt = 0.0;
		String acceptedQntS = "0.0";
		String acceptedQntSA = "0.0" ;
		if(goodReceiptNoteItemDetailsDTO.getWtPerUnit()!=null) {
			wtPerUnit = goodReceiptNoteItemDetailsDTO.getWtPerUnit();
			receivedQnt = goodReceiptNoteItemDetailsDTO.getReceivedQnt();
			
			acceptedQnt = receivedQnt / wtPerUnit;
			acceptedQntS = String.valueOf(acceptedQnt);
			acceptedQntSA = acceptedQntS.split("\\.")[0];
		}
		
		goodReceiptNoteItemDetails.setReceivedQnt(goodReceiptNoteItemDetailsDTO.getReceivedQnt());
		
//		if(acceptedQntSA!=null || acceptedQntSA != " ")
//			goodReceiptNoteItemDetails.setAcceptedQnt(Double.valueOf(goodReceiptNoteItemDetailsDTO.getAcceptedQnt()));
		
		if(goodReceiptNoteItemDetailsDTO.getAcceptedQnt()!=null)
			goodReceiptNoteItemDetails.setAcceptedQnt(Double.valueOf(goodReceiptNoteItemDetailsDTO.getAcceptedQnt()));
		else
			goodReceiptNoteItemDetails.setAcceptedQnt(0.0);
		
		if(goodReceiptNoteItemDetailsDTO.getRejectedQnt()!=null)
			goodReceiptNoteItemDetails.setRejectedQnt(Double.valueOf(goodReceiptNoteItemDetailsDTO.getRejectedQnt()));
		else
			goodReceiptNoteItemDetails.setRejectedQnt(0.0);
		
		return goodReceiptNoteItemDetails;
	}

	@Override
	public List<GoodReceiptNoteItemDetailsDTO> getGoodsReceiptNumberByItemId(Integer itemId) {
		
		List<GoodReceiptNoteItemDetailsDTO> detailsDTO = new ArrayList<>();
		try {
			List<GoodReceiptNoteItemDetails> grnEntity = grnDetailsRepo.findByItemId(itemId);
			for(GoodReceiptNoteItemDetails grn : grnEntity) {
				detailsDTO.add(prepareGoodReceiptNoteItemDetailsDTO(grn));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return detailsDTO;
	}
	

}
