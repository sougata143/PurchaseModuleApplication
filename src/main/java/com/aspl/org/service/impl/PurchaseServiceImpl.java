package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.GoodReceiptNoteItemDetailsDTO;
import com.aspl.org.dto.GoodsReceiptNoteHeaderDTO;
import com.aspl.org.dto.IndentDTO;
import com.aspl.org.dto.ItemMasterDTO;
import com.aspl.org.dto.LandedPriceDTO;
import com.aspl.org.dto.PriceHistoryDTO;
import com.aspl.org.dto.PurchaseDTO;
import com.aspl.org.dto.PurchaseDetailsDTO;
import com.aspl.org.dto.VendorForItemDTO;
import com.aspl.org.dto.VendorMasterDTO;
import com.aspl.org.entity.Indent;
import com.aspl.org.entity.Purchase;
import com.aspl.org.entity.PurchaseDetails;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.repository.IndentDao;
import com.aspl.org.repository.PurchaseDao;
import com.aspl.org.repository.PurchaseDetailsDao;
import com.aspl.org.service.GoodReceiptNoteHeaderService;
import com.aspl.org.service.GoodReceiptNoteItemDetailsService;
import com.aspl.org.service.IndentService;
import com.aspl.org.service.ItemMasterService;
import com.aspl.org.service.LandedPriceService;
import com.aspl.org.service.PurchaseService;
import com.aspl.org.service.StoreDetailsService;
import com.aspl.org.service.VendormasterService;
import com.aspl.org.utils.GlobalDefine;
import com.aspl.org.utils.PurchaseOrderDTOEntityConversionUtil;

/*
 * Service for purchase back end logics
 */
@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseDao purchaseDao;
	
	@Autowired
	PurchaseOrderDTOEntityConversionUtil purchaseDTOEntityConversionUtil;

	@Autowired
	PurchaseDetailsDao purchaseDetailsDao;
	
	@Autowired
	StoreDetailsService storeDetailsService;

	@Autowired
	IndentService indentService;
	
	@Autowired
	IndentDao indentDao;
	
	@Autowired
	GoodReceiptNoteItemDetailsService grnDetailsService;
	
	@Autowired
	GoodReceiptNoteHeaderService grnService;
	
	@Autowired
	VendormasterService vendorService;
	
	@Autowired
	LandedPriceService landedPriceService;
	
	@Autowired
	ItemMasterService itemMasterService;
	
	
	
	
	/*
	 * @Param purchaseDTO
	 * 
	 * This method is for saving purchase oreder
	 * 
	 * @Return ReposnseDetails
	 */
	@Override
	public ResponseDetails purchaseSave(PurchaseDTO purchaseDTO) throws Exception {
		
		Indent indent = new Indent();
		if(purchaseDTO.getIndent().getId()!=null) {
			Optional<Indent> indentO = indentDao.findById(Integer.valueOf(purchaseDTO.getIndent().getId()));
			if(indentO.isPresent()) {
				indent = indentO.get();
				
			}
		}
		
		if (indent != null) {
			if (indent.getStatus().equals(2) && !indent.getPurchaseStatus().equals(GlobalDefine.purchaseDone) ) {
				
				Purchase purchase = new Purchase();
				
				Purchase vendorNames = purchaseDao.findByVendorName(purchaseDTO.getVendor().getVendorName());
				if(vendorNames!=null) {
					
					return new ResponseDetails(new Date(), "Sorry '"+purchaseDTO.getVendor().getVendorName()+"' already exist.", null);
				}
				/*if(jobberMasterService.findByJobberName(jobberMaster.getJobberName())!=null) {
					return new ResponseDetails(new Date(), "Sorry '"+jobberMaster.getJobberName()+"' already exist.", null);
				}*/
				
				else {
				
				if (purchaseDTO.getVendor().getStateCode().equals("19")) {
					purchaseDTO.setSgst(purchaseDTO.getSgst());
					purchaseDTO.setCgst(purchaseDTO.getCgst());
					
//					purchaseDTO.setPurchaseCode(purchaseOrderCode);
					
					Purchase purchaseEntity = purchaseDTOEntityConversionUtil.preparePurchaseEntity(purchaseDTO);
					
					purchaseEntity.setPurchaseStatus(GlobalDefine.orderPending);
					purchaseEntity.setAccepted(GlobalDefine.orderPending);
//					purchaseEntity.setPurchaseCode(purchaseOrderCode);
					purchaseEntity.setPurchaseCode(purchaseDTO.getPurchaseCode());
					
					purchase = purchaseDao.save(purchaseEntity);
					//("purchase: "+purchase.getId());
					
				} else {
					purchaseDTO.setIgst(purchaseDTO.getIgst());
					
//					purchaseDTO.setPurchaseCode(purchaseOrderCode);
					
					Purchase purchaseEntity = purchaseDTOEntityConversionUtil.preparePurchaseEntity(purchaseDTO);
					
					purchaseEntity.setPurchaseStatus(GlobalDefine.orderPending);
					purchaseEntity.setAccepted(GlobalDefine.orderPending);
//					purchaseEntity.setPurchaseCode(purchaseOrderCode);
					purchaseEntity.setPurchaseCode(purchaseDTO.getPurchaseCode());
					
					purchase = purchaseDao.save(purchaseEntity);
					//("purchase: "+purchase.getId());
					
				}
				
				//Saving purchase order header end
				
				
				for (PurchaseDetailsDTO poDetailsDTO : purchaseDTO.getPurchaseDetails()) {
					PurchaseDetails toGetItemCode = purchaseDTOEntityConversionUtil.preparePurchaseDetailsEntity(poDetailsDTO);
					PurchaseDetails purDetails = new PurchaseDetails();
						
					toGetItemCode.setPoid(purchase.getId());
						
					purDetails = purchaseDetailsDao.save(toGetItemCode);
					   
					//("toGetItemCode: "+toGetItemCode.getId());
					if (purchase.getId()>0 && purDetails.getId()>0) {
						IndentDTO indentDTOUpdate = indentService.prepareIndentDTO(indent);
						indentDTOUpdate.setPurchaseStatus(GlobalDefine.purchaseDone);
						
						indentService.indentSave(indentDTOUpdate);
					    
					    LandedPriceDTO landedPrice = new LandedPriceDTO();
					    
					    landedPrice.setCreatedDate(new Date());
					    landedPrice.setItemDTO(poDetailsDTO.getItemCode());
					    landedPrice.setMinStock(poDetailsDTO.getMinQty());
					    landedPrice.setMrp(poDetailsDTO.getPurPrice());
					    landedPrice.setUnit(String.valueOf(poDetailsDTO.getPurUom().getUomId()));
					    landedPrice.setDiscount(poDetailsDTO.getDisc());
					    landedPrice.setOrderQnt(poDetailsDTO.getPurQty());
					    landedPrice.setVendorId(purchase.getVendorId());
					    
					    //updating current price for the item
					    landedPriceService.landedPriceSave(landedPrice);
					    
					    ItemMasterDTO item = itemMasterService.findByItemId(purDetails.getItemId());
					    item.setUpdatedPrice(purDetails.getPurPrice());
					    itemMasterService.itemmasterupdate(item);
				    }
				}
				}
			} else {
				return new ResponseDetails(new Date(), "You have already created purchase order", null, 1);
			}
		
		} else {
			return new ResponseDetails(new Date(), "Invalid indent '"+purchaseDTO.getIndent().getIndentCode()+", created indent first to purchase", null, 0);
		}
		
		return new ResponseDetails(new Date(), "We have created your purchase successfully", null, 1);
 
       }

	
	
	/*
	 * Method for fetching all the purchase orders for authorisation. i.e all the purchase orders will accepted as 0
	 * 
	 * @Return List<PurchaseDTO>
	 * 
	 */
	@Override
	public List<PurchaseDTO> getAllPurchaseForAuthorisation() {
		List<PurchaseDTO> purchaseDTOs = new ArrayList<>();
		PurchaseDTO purDTO = new PurchaseDTO();
		
		try {
			List<Purchase> purchases = purchaseDao.findByPurchaseStatusOrPurchaseStatusOrPurchaseStatus(0, 1, 4);
			for(Purchase pur : purchases) {
//				purDTO = prepareUnauthorisedPurchaseDTO(pur);
				purDTO = purchaseDTOEntityConversionUtil.preparePurchaseDTO(pur, "unauthorized");
				purchaseDTOs.add(purDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return purchaseDTOs;
	}

	/*
	 * @Param iId
	 * 
	 * Method for authorise purchase order
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails purchaseAuthorised(PurchaseDTO purchaseDTO) {
		Purchase purchase = new Purchase();
		try {
			List<PurchaseDetails> purchaseDetailsList = 
					purchaseDetailsDao.findByPoidAndPoDetailsStausOrPoDetailsStausOrPoDetailsStaus(purchaseDTO.getId(), 0, 1, 4); 
			
			Integer dtoSize = purchaseDTO.getPurchaseDetails().size();
			Integer entitySize = purchaseDetailsList.size();
			
			if(dtoSize == entitySize) {
				purchase = purchaseDao.findById(purchaseDTO.getId()).get();
				
				purchase.setPurchaseStatus(GlobalDefine.orderAccept);
				purchase.setAuthDate(new Date());
				
				for(PurchaseDetails pd : purchaseDetailsList) {
					PurchaseDetails purDetails = purchaseDetailsDao.findById(pd.getId()).get();
					purDetails.setPoDetailsStaus(GlobalDefine.orderAccept);
					
					purchaseDetailsDao.save(purDetails);
				}
				
				purchase = purchaseDao.save(purchase);
				
			}
			
			if(dtoSize < entitySize) {
				purchase = purchaseDao.findById(purchaseDTO.getId()).get();
				
				purchase.setPurchaseStatus(GlobalDefine.orderPartlyAccept);
				purchase.setAuthDate(new Date());
				
				for(PurchaseDetailsDTO pd : purchaseDTO.getPurchaseDetails()) {
					
					PurchaseDetails purDetails = purchaseDetailsDao.findById(pd.getId()).get();
					purDetails.setPoDetailsStaus(GlobalDefine.orderAccept);
					
					purchaseDetailsDao.save(purDetails);
				}
				
				purchase = purchaseDao.save(purchase);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseDetails(new Date(), "Purchase Order authorised.", purchase.toString());
		//return indentDao.indentAuthorised(iId);
	}

	/*
	 * @Param iId
	 * 
	 * Method for unauthorising purchase order
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails purchaseUnauthorised(PurchaseDTO purchaseDTO) {
		Purchase purchase = new Purchase();
		try {
			List<PurchaseDetails> purchaseDetailsList = purchaseDetailsDao.findByPoid(purchaseDTO.getId()); 
			Integer dtoSize = purchaseDTO.getPurchaseDetails().size();
			Integer entitySize = purchaseDetailsList.size();
			
			if(dtoSize == entitySize) {
				purchase = purchaseDTOEntityConversionUtil.preparePurchaseEntity(purchaseDTO);
				purchase.setPurchaseStatus(GlobalDefine.orderReject);
				
				for(PurchaseDetails pd : purchaseDetailsList) {
					pd.setPoDetailsStaus(GlobalDefine.orderReject);
					
					purchaseDetailsDao.save(pd);
				}
				
				purchase = purchaseDao.save(purchase);
				
			}
			
			if(dtoSize < entitySize) {
				purchase = purchaseDTOEntityConversionUtil.preparePurchaseEntity(purchaseDTO);
				purchase.setPurchaseStatus(GlobalDefine.orderPartlyAccept);
				
				for(PurchaseDetails pd : purchaseDetailsList) {
					pd.setPoDetailsStaus(GlobalDefine.orderPartlyAccept);
					
					purchaseDetailsDao.save(pd);
				}
				
				purchase = purchaseDao.save(purchase);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseDetails(new Date(), "Indent authorised.", purchase.toString());
		//return indentDao.indentAuthorised(iId);
	}

	/*
	 * @Param purchaseCode
	 * 
	 * Method for getting purchase order by purchaseCode
	 * 
	 * @Return PurchaseDTO
	 */
	@Override
	public PurchaseDTO findByPurchaseCode(String purchaseCode) {
		
		
		PurchaseDTO purDTO = new PurchaseDTO();
		try {
			Purchase pur = purchaseDao.findByPurchaseCodeAndAccepted(purchaseCode, 0);
//			purDTO = preparePurchaseDTO(pur);
			purDTO = purchaseDTOEntityConversionUtil.preparePurchaseDTO(pur, "none");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return purDTO;

	}
	
	@Override
	public PurchaseDTO findByPurchaseId(Integer purchaseId) {
		
		PurchaseDTO purDTO = new PurchaseDTO();
		try {
			Optional<Purchase> purO = purchaseDao.findById(purchaseId);
			Purchase pur = new Purchase();
			if(purO.isPresent()) {
				pur = purO.get();
			}
//			purDTO = preparePurchaseDTO(pur);
			purDTO = purchaseDTOEntityConversionUtil.preparePurchaseDTO(pur, "none");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return purDTO;
	}

	/*
	 *@Param purchaseDTO
	 *
	 * Method for updating purchase order
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails purchaseUpdate(PurchaseDTO purchaseDTO) throws Exception {
		
		Purchase pur = new Purchase();
		try {
			Optional<Purchase> purO = purchaseDao.findById(purchaseDTO.getId());
			
			if(purO.isPresent()) {
				pur = purO.get();
			}
			if(purchaseDTO.getId()!=null) {
				List<PurchaseDetailsDTO> details = purchaseDTO.getPurchaseDetails();
				Purchase purchase = purchaseDTOEntityConversionUtil.preparePurchaseEntity(purchaseDTO);
				
				purchaseDao.save(purchase);
				for(PurchaseDetailsDTO dto : details) {
					PurchaseDetails purchaseDetails = purchaseDTOEntityConversionUtil.preparePurchaseDetailsEntity(dto);
					
					purchaseDetailsDao.save(purchaseDetails);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Purchase updated successfully", pur.toString());
	}
	

	/*
	 * Method for getting all unauthorised purchase order
	 * 
	 * @Return List<PurchaseDTO>
	 */
	@Override
	public List<PurchaseDTO> getAllUnAuthorisedPurchaseOrder() {
		
		List<PurchaseDTO> purchaseDTOs = new ArrayList<>();
		PurchaseDTO purDTO = new PurchaseDTO();
		
		try {
			List<Purchase> purchases = purchaseDao.findByPurchaseStatusOrPurchaseStatusOrPurchaseStatus(0, 1, 4);
			for(Purchase pur : purchases) {
//				purDTO = prepareUnauthorisedPurchaseDTO(pur);
				purDTO = purchaseDTOEntityConversionUtil.preparePurchaseDTO(pur, "unauthorized");
				purchaseDTOs.add(purDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return purchaseDTOs;
	}

	/*
	 * Method for getting all authorised purchase order
	 * 
	 * @Return List<PurchaseDTO>
	 */
	@Override
	public List<PurchaseDTO> getAllAuthorisedPurchaseOrder() {

		List<PurchaseDTO> purchaseDTOs = new ArrayList<>();
		PurchaseDTO purDTO = new PurchaseDTO();
		
		try {
			List<Purchase> purchases = purchaseDao.findByPurchaseStatus(2);
			for(Purchase pur : purchases) {
//				purDTO = preparePurchaseDTO(pur);
				purDTO = purchaseDTOEntityConversionUtil.preparePurchaseDTO(pur, "authorized");
				purchaseDTOs.add(purDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return purchaseDTOs;
	}
	
	/*
	 * Method for fetching active purchase orders
	 * 
	 * @Return List<PurchaseDTO>
	 */
	@Override
	public List<PurchaseDTO> getAllActivePurchaseOrder() {
		
		List<PurchaseDTO> purchaseDTOs = new ArrayList<>();
		PurchaseDTO purDTO = new PurchaseDTO();
		
		try {
			List<Purchase> purchases = purchaseDao.findByIsActive(1);
			for(Purchase pur : purchases) {
//				purDTO = preparePurchaseDTO(pur);
				purDTO = purchaseDTOEntityConversionUtil.preparePurchaseDTO(pur, "none");
				purchaseDTOs.add(purDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return purchaseDTOs;
	}

	@Override
	public PurchaseDTO softDeleteItem(Integer id) {
		
		PurchaseDTO purchaseDTO = new PurchaseDTO();
		try {
			Purchase purchase = purchaseDao.findById(id).get();
			purchase.setIsActive(0);
			purchaseDao.save(purchase);
			purchaseDTOEntityConversionUtil.preparePurchaseDTO(purchase, "none");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return purchaseDTO;
	}



	@Override
	public List<PriceHistoryDTO> getPurchasePriceForItem(Integer itemId) {
	
		List<PriceHistoryDTO> priceHistorys = new ArrayList<>();
		
		try {
			List<LandedPriceDTO> landedPrices = landedPriceService.getLandedPriceForItem(itemId);
			for(LandedPriceDTO price : landedPrices) {
				PriceHistoryDTO priceHistoryDTO = new PriceHistoryDTO();
				
				VendorForItemDTO vendorForItem = new VendorForItemDTO();
				VendorMasterDTO vendor = new VendorMasterDTO();
				if(price.getVendorId()!=null) {
					vendor  = vendorService.findByVendorId(price.getVendorId());
					vendorForItem.setVendorCode(vendor.getVendorCode());
					vendorForItem.setVendorId(vendor.getId());
					vendorForItem.setVendorName(vendor.getVendorName());
				}
				
				GoodsReceiptNoteHeaderDTO grnHeader = grnService.getGoodsReceiptNoteByGrnId(price.getGrnId());
				GoodReceiptNoteItemDetailsDTO grnDetails = 
						grnDetailsService.getGoodReceiptNoteItemDetailsByDetailsId(price.getGrnDetailsId());
				
				priceHistoryDTO.setDisc(price.getDiscount());
				priceHistoryDTO.setOrderQnt(priceHistoryDTO.getOrderQnt());
				priceHistoryDTO.setPrice(priceHistoryDTO.getPrice());
				priceHistoryDTO.setGrnNo(grnHeader.getGrnNo());
				priceHistoryDTO.setReceiveDate(grnHeader.getReceivedOn());
				
				if(grnDetails!=null)
					priceHistoryDTO.setSuppliedQnt(grnDetails.getAcceptedQnt());
				
				priceHistoryDTO.setVendor(vendorForItem);
				
				priceHistorys.add(priceHistoryDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return priceHistorys;
	}

	

}