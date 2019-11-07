package com.aspl.org.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dao.CompanyMasterDao;
import com.aspl.org.dto.GoodsReceiptNoteReportDTO;
import com.aspl.org.dto.PendingPurchaseIndentReportIndentWiseDTO;
import com.aspl.org.dto.PurchaseIndentReportDTO;
import com.aspl.org.dto.PurchaseIndentReportItemsDTO;
import com.aspl.org.dto.PurchaseOrderReportDTO;
import com.aspl.org.entity.DepartmentMaster;
import com.aspl.org.entity.GoodsRecieptNoteHeader;
import com.aspl.org.entity.Indent;
import com.aspl.org.entity.IndentDetails;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.Purchase;
import com.aspl.org.entity.PurchaseDetails;
import com.aspl.org.entity.StoreDetails;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.repository.ContactsDetailsDao;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.DepartmentMasterRepo;
import com.aspl.org.repository.GoodReceiptNoteItemDetailsRepository;
import com.aspl.org.repository.GoodsReceiptNoteRepository;
import com.aspl.org.repository.IndentDao;
import com.aspl.org.repository.IndentDetailsDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.PurchaseDao;
import com.aspl.org.repository.PurchaseDetailsDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.repository.StoreDetailsDao;
import com.aspl.org.repository.UomMasterRepo;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.PurchaseReportService;
import com.aspl.org.utils.PurchaseReportDTOUtil;
import com.aspl.org.utils.PurchaseUtil;

/*
 * Service class for fetching data from different table for generating purchase reports.
 */
@Service
@Transactional
public class PurchaseReportServiceImpl implements PurchaseReportService {
	
	@Autowired
	CompanyMasterDao companyDao;
	
	@Autowired
	DepartmentMasterRepo deptDao;
	
	@Autowired
	IndentDao indentDao;
	
	@Autowired
	IndentDetailsDao indentDetailsDao;
	
	@Autowired
	PurchaseDetailsDao purchaseDetailsDao;
	
	@Autowired
	PurchaseDao purchaseDao;
	
	@Autowired
	GoodsReceiptNoteRepository grnRepo;
	
	@Autowired
	VendorMasterDao vendorDao;
	
	@Autowired
	VendorMasterServiceImpl vendorService;
	
	@Autowired
	GoodReceiptNoteItemDetailsRepository grnDetailsRepo;
	
	@Autowired
	UomMasterRepo uomRepo;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	PurchaseDetailsDao poDetailsDao;
	
	@Autowired
	StoreDetailsDao storeDao;
	
	@Autowired
	ContactsDetailsDao contactDao;
	
	@Autowired
	DeliveryTermsMasterDao deliverTermsMasterDao;
	
	@Autowired
	PaymentMethodMasterDao paymentMethodDao;
	
	@Autowired
	ShippingMethodMasterDao shippingMethodDao;
	
	@Autowired
	PaymentTermsMasterDao paymentTermsDao;
	
	@Autowired
	PurchaseUtil purUtil;
	
	@Autowired
	PurchaseReportDTOUtil purchaseReportDTOUtil;

	/*
	 * @Param startDate
	 * @Param endDate
	 * 
	 * It takes a date range as startDate and endDate and searches indent as created date between this date range, which has status of pending or partially accpeted or 
	 * partially rejected. Then for every Indent object is sent to preparePendingPurchaseIndentReportIndentWiseDTO() method of PurchaseReportDTOUtil class to generate
	 * the DTO.
	 * 
	 * @Return List<PendingPurchaseIndentReportIndentWiseDTO>
	 */
	@Override
	public List<PendingPurchaseIndentReportIndentWiseDTO> getPendingPurchaseIndentReportIndentWiseDTO(String startDate, String endDate) throws ParseException {
		
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		List<PendingPurchaseIndentReportIndentWiseDTO> dtos = new ArrayList<>();
		try {
			List<Indent> indents = indentDao.findByStatusOrStatusOrStatusAndCreatedDateBetweenOrderByCreatedDateDesc(0, 1, 4, start, end);
			for(Indent i : indents) {
				PendingPurchaseIndentReportIndentWiseDTO dto = new PendingPurchaseIndentReportIndentWiseDTO();
				dto = purchaseReportDTOUtil.preparePendingPurchaseIndentReportIndentWiseDTO(i);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	
	/*
	 * @Param startDate
	 * @Param endDate
	 * 
	 * It takes a date range as startDate and endDate and searches indent as created date between this date range, which has purchase status of pending.  
	 * Then for every Indent object is sent to preparePendingPurchaseIndentReportIndentWiseDTO() method of PurchaseReportDTOUtil class to generate
	 * the DTO.
	 * 
	 * @Return List<PendingPurchaseIndentReportIndentWiseDTO>
	 */
	@Override
	public List<PendingPurchaseIndentReportIndentWiseDTO> getPendingPurchaseOrderOfIndentReportIndentWiseDTO(
			String startDate, String endDate) throws ParseException {
	
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		List<PendingPurchaseIndentReportIndentWiseDTO> dtos = new ArrayList<>();
		try {
			List<Indent> indents = indentDao.findByPurchaseStatusAndCreatedDateBetweenOrderByCreatedDateDesc(0, start, end);
			for(Indent i : indents) {
				PendingPurchaseIndentReportIndentWiseDTO dto = new PendingPurchaseIndentReportIndentWiseDTO();
				dto = purchaseReportDTOUtil.preparePendingPurchaseIndentReportIndentWiseDTO(i);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	
	
	/*
	 * @Param grnId
	 * 
	 * This method takes grnId as parameter and returns GoodsReceiptNoteReportDTO. It fetches GoodsRecieptNoteHeader by it's grnId and then sent to  
	 * prepareGoodsReceiptNoteReportDTO() method for generating the DTO object. 
	 * 
	 * @Return GoodsReceiptNoteReportDTO
	 */
	@Override
	public GoodsReceiptNoteReportDTO getGoodsReceiptNoteReport(Integer grnId) {
		
		GoodsReceiptNoteReportDTO goodsReceiptNoteReportDTO = new GoodsReceiptNoteReportDTO();
		try {
			Optional<GoodsRecieptNoteHeader> grnHeaderO = grnRepo.findById(grnId);
			if(grnHeaderO.isPresent()) {
				GoodsRecieptNoteHeader grnHeader = grnHeaderO.get();
				goodsReceiptNoteReportDTO = purchaseReportDTOUtil.prepareGoodsReceiptNoteReportDTO(grnHeader);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteReportDTO;
	}

	/*
	 * @Param startDate
	 * @Param endDate
	 * 
	 * This method takes a date range and finds GRN in that date range which has status as pending or partially accepted or partially rejected. Then it sends this object to 
	 * prepareGoodsReceiptNoteReportDTO() method to generate the DTO. 
	 * 
	 * @Return List<GoodsReceiptNoteReportDTO> 
	 */
	@Override
	public List<GoodsReceiptNoteReportDTO> getPendingGoodsReturnReport(String startDate, String endDate) {
	
		List<GoodsReceiptNoteReportDTO> dtos = new ArrayList<>();
		try {
			Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			
			List<GoodsRecieptNoteHeader> grnHeaders = grnRepo.findByIsAuthorisedAndCreatedDateBetweenOrderByCreatedDateDesc(0, start, end);
			for(GoodsRecieptNoteHeader grnHeader : grnHeaders) {
				GoodsReceiptNoteReportDTO dto = new GoodsReceiptNoteReportDTO();
				dto = purchaseReportDTOUtil.prepareGoodsReceiptNoteReportDTO(grnHeader);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	
	/*
	 * @Param startDate
	 * @Param endDate
	 * 
	 * This method takes a date range and finds indents in this date range. Then it is sent to  preparePendingPurchaseIndentReportIndentWiseDTO() for every object from the 
	 * list to convert it to the DTO.
	 * 
	 * @Return List<PendingPurchaseIndentReportIndentWiseDTO>
	 */
	@Override
	public List<PendingPurchaseIndentReportIndentWiseDTO> getAllPurchaseIndentReportIndentWise(String startDate,
			String endDate) throws ParseException {
		
		Date start = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
		Date end = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
		List<PendingPurchaseIndentReportIndentWiseDTO> dtos = new ArrayList<>();
		try {
			List<Indent> indents = indentDao.findByCreatedDateBetweenOrderByCreatedDateDesc(start, end);
			for(Indent i : indents) {
				PendingPurchaseIndentReportIndentWiseDTO dto = new PendingPurchaseIndentReportIndentWiseDTO();
				dto = purchaseReportDTOUtil.preparePendingPurchaseIndentReportIndentWiseDTO(i);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	
	/*
	 * @Param indentId
	 * 
	 * This method take indentId as param and fetches Indent table by indentId. Then the fetched object is converted to DTO. This method fetches data from indent, 
	 * IndentDetails, DepartmentMaster, Purchase, ItemMaster, StoreDetails and UomMaster table.
	 * 
	 * @Return PurchaseIndentReportDTO
	 */
	@Override
	public PurchaseIndentReportDTO getPurchaseIndentReport(Integer indentId) {
		
		PurchaseIndentReportDTO indentDTO = new PurchaseIndentReportDTO();
		try {
			Indent indentEntity = new Indent();
			if(indentId!=null) {
				Optional<Indent> indentEntityListO = indentDao.findById(indentId);
				if(indentEntityListO.isPresent()) {
					indentEntity = indentEntityListO.get();
				}
			}
			
			List<IndentDetails> indentDetailsEntityList = new ArrayList<>();

			if(indentEntity!=null) {
				if(indentEntity.getId()!=null) {
					indentDetailsEntityList = indentDetailsDao.findByIndentId(indentEntity.getId());
				}
			}
			
			indentDTO.setAuthDate(indentEntity.getAuthoriseDate());

		    DepartmentMaster dept = new DepartmentMaster();
			if(indentEntity.getDepartment()!=null) {
				Optional<DepartmentMaster> deptO = deptDao.findById(indentEntity.getDepartment());

			    if(deptO.isPresent()) {
			    	dept = deptO.get();
			    }
			}
			
			indentDTO.setDepartment(dept.getDepartmentname());
			indentDTO.setIndentCode(indentEntity.getIndentCode());
			indentDTO.setIndentDate(indentEntity.getIndentDate());
			indentDTO.setProjectCode(indentEntity.getProjectCode());
			indentDTO.setValidityDate(indentEntity.getValidateDate());
			
			indentDTO.setNote(indentEntity.getNotes());
			
			List<Purchase> poList = purchaseDao.findByIndentId(String.valueOf(indentEntity.getId()));
			if(!poList.isEmpty()) {
				indentDTO.setWorkOrderNo(poList.get(0).getPurchaseCode());
			}
			
			List<PurchaseIndentReportItemsDTO> purchaseIndentReportItemsDTOList = new ArrayList<>();
			for(IndentDetails id : indentDetailsEntityList) {
				PurchaseIndentReportItemsDTO purchaseIndentReportItemsDTO = new PurchaseIndentReportItemsDTO();
				ItemMaster item = new ItemMaster();
				
				if(id.getItemId()!=null) {
					Optional<ItemMaster> itemO = itemDao.findById(id.getItemId());

					if(itemO.isPresent()) {
						item = itemO.get();
					}
				}

				List<StoreDetails> storeList = new ArrayList<>();
				if(id.getItemCode()!=null) {
					storeList = storeDao.findByItemCode(id.getItemCode());
				}
				
				Double stock = 0.0;
				if(!storeList.isEmpty()) {
					for(StoreDetails sd : storeList) {
						stock = stock + sd.getQuantity();
					}
				}
				
				UomMaster uom = new UomMaster();
				
				if(id.getPurUom()!=null) {
					Optional<UomMaster> uomO = uomRepo.findById(Integer.valueOf(id.getPurUom()));
					
					if(uomO.isPresent()) {
						uom = uomO.get();
					}
				}
				
				
				purchaseIndentReportItemsDTO.setInStockQnt(stock);
				purchaseIndentReportItemsDTO.setItemCode(item.getItemCode());
				purchaseIndentReportItemsDTO.setItemDescription(item.getRemarks());
				purchaseIndentReportItemsDTO.setItemName(item.getItemName());
				purchaseIndentReportItemsDTO.setPendingIndentQnt(id.getPendingIndentQty());
//				purchaseIndentReportItemsDTO.setProductGrp(indentEntity.getpr);
				purchaseIndentReportItemsDTO.setReqDate(id.getReqDate());
				purchaseIndentReportItemsDTO.setReqQnt(id.getReqQty());
				
				purchaseIndentReportItemsDTO.setUnit(uom.getUomDescription());
				
				purchaseIndentReportItemsDTOList.add(purchaseIndentReportItemsDTO);
			}
			indentDTO.setPurchaseIndentReportItemsDTO(purchaseIndentReportItemsDTOList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return indentDTO;
	}

	/*
	 * @Param purchaseId
	 * 
	 * This method takes purchaseId as param and returns PurchaseOrderReportDTO. First it finds the purchase by the purchaseId and then fecthes all the PurchaseDetails
	 * by purchaseId. It fetches data from Purchase, PurchaseDetails, ItemMaster, VendorMaster, DeliveryTermsMaster, PaymentTermsMaster, ContactDetails and UomMaster tables.  
	 * 
	 * @Return PurchaseOrderReportDTO
	 */
	@Override
	public PurchaseOrderReportDTO getPurchaseOrderReport(Integer purchaseId) {
	
		PurchaseOrderReportDTO orderReportDTO = new PurchaseOrderReportDTO();
		
		Purchase purchaseEntity = new Purchase();
		if(purchaseId!=null) {
			Optional<Purchase> purchase = purchaseDao.findById(purchaseId);
			if(purchase.isPresent()) {
				purchaseEntity = purchase.get();
			}
		}

		orderReportDTO = purchaseReportDTOUtil.preparePurchaseOrderReportDTO(purchaseEntity);
		
		return orderReportDTO;
	}

	/*
	 * @Param vendorId
	 * @Param startDate
	 * @Param endDate
	 * 
	 * This method takes vendorId, Startdate and endDate as param and returns List<PurchaseOrderReportDTO>. First it finds the purchase by the date range of startDate 
	 * and endDate and the vendorId then fetches all the PurchaseDetails by purchaseId. It fetches data from Purchase, PurchaseDetails, ItemMaster, VendorMaster, 
	 * DeliveryTermsMaster, PaymentTermsMaster, ContactDetails and UomMaster tables.  
	 * 
	 * @Return List<PurchaseOrderReportDTO>
	 */
	@Override
	public List<PurchaseOrderReportDTO> getPendingPurchaseOrderReportVendorWise(String startDate, String endDate, Integer vendorId) {
		
		List<PurchaseOrderReportDTO> orderReportDTOs = new ArrayList<>();
		try {
			
			Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			
			List<Purchase> purchases = purchaseDao.findByVendorIdAndCreatedDateBetween(vendorId,start, end);
			for(Purchase pur : purchases) {
				PurchaseOrderReportDTO orderReportDTO = new PurchaseOrderReportDTO();
				orderReportDTO = purchaseReportDTOUtil.preparePurchaseOrderReportDTO(pur);
				orderReportDTOs.add(orderReportDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderReportDTOs;
	}

	
	/*
	 * @Param vendorId
	 * @Param startDate
	 * @Param endDate
	 * 
	 * This method takes vendorId, Startdate and endDate as param and returns List<PurchaseOrderReportDTO>. First it finds the purchase by the date range of startDate 
	 * and endDate and then fetches all the PurchaseDetails by purchaseId, and then checks if the item is present. It fetches data from Purchase, PurchaseDetails, 
	 * ItemMaster, VendorMaster, DeliveryTermsMaster, PaymentTermsMaster, ContactDetails and UomMaster tables.  
	 * 
	 * @Return List<PurchaseOrderReportDTO>
	 */
	@Override
	public List<PurchaseOrderReportDTO> getPurchaseOrderReportItemWise(String startDate, String endDate, Integer itemId) {
		
		List<PurchaseOrderReportDTO> orderReportDTOs = new ArrayList<>();
		try {
			
			Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			
			List<Purchase> purchases = purchaseDao.findByCreatedDateBetween(start, end);
			List<PurchaseDetails> purchaseDetails = purchaseDetailsDao.findByItemId(itemId);
			/*
			 * for(Purchase pur : purchases) { PurchaseOrderReportDTO orderReportDTO = new
			 * PurchaseOrderReportDTO(); orderReportDTO =
			 * purchaseReportDTOUtil.preparePurchaseOrderReportDTO(pur);
			 * orderReportDTOs.add(orderReportDTO); }
			 */
			for(PurchaseDetails pd : purchaseDetails) {
				Purchase purchaseEntity = purchaseDao.findById(pd.getPoid()).get();
				if(purchases.contains(purchaseEntity)) {
					PurchaseOrderReportDTO orderReportDTO = new PurchaseOrderReportDTO();
					orderReportDTO = purchaseReportDTOUtil.preparePurchaseOrderReportDTO(purchaseEntity);
					orderReportDTOs.add(orderReportDTO);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderReportDTOs;
	}


}
