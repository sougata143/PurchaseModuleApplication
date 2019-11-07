package com.aspl.org.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.DeliveryTermsMasterforVendorDTO;
import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.JurisdictionMasterForVendorDTO;
import com.aspl.org.dto.PaymentMethodMasterforVendorDTO;
import com.aspl.org.dto.PaymentTermsMasterforVendorDTO;
import com.aspl.org.dto.PurchaseDTO;
import com.aspl.org.dto.PurchaseDetailsDTO;
import com.aspl.org.dto.ReminderTermsMasterForVendorDTO;
import com.aspl.org.dto.ShippingMethodMasterforVendorDTO;
import com.aspl.org.dto.StoreDetailsDTO;
import com.aspl.org.dto.SubCategoryForMappingDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.Indent;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.Purchase;
import com.aspl.org.entity.PurchaseDetails;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.entity.VendorMaster;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.IndentDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.PurchaseDao;
import com.aspl.org.repository.PurchaseDetailsDao;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.repository.UomMasterRepo;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.DeliveryTermsMasterService;
import com.aspl.org.service.JurisdictionMasterService;
import com.aspl.org.service.PaymentMethodMasterService;
import com.aspl.org.service.PaymentTermsMasterService;
import com.aspl.org.service.ReminderTermsMasterService;
import com.aspl.org.service.ShippingMethodMasterService;
import com.aspl.org.service.UomMasterService;
import com.aspl.org.service.impl.IndentServiceImpl;
import com.aspl.org.service.impl.StoreDetailsServiceImpl;

@Component
public class PurchaseOrderDTOEntityConversionUtil {
	
	@Autowired
	PurchaseDao purchaseDao;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	UomMasterRepo uomRepo;
	
	@Autowired
	VendorMasterDao vendorDao;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	SubCategoryRepo subCategoryRepo;
	
	@Autowired
	DeliveryTermsMasterService deliveryMasterService;
	
	@Autowired
	JurisdictionMasterService juridictionService;
	
	@Autowired
	PaymentMethodMasterService paymentMethodService;
	
	@Autowired
	PaymentTermsMasterService paymentTermsService;
	
	@Autowired
	ReminderTermsMasterService reminderMasterService;
	
	@Autowired
	ShippingMethodMasterService shippingService;
	
	@Autowired
	PurchaseDetailsDao purchaseDetailsDao;
	
	@Autowired
	StoreDetailsServiceImpl storeDetailsServiceImpl;

	@Autowired
	IndentServiceImpl indentServiceImpl;
	
	@Autowired
	IndentDao indentDao;
	
	@Autowired
	UomMasterService uomService;
	
	

	/*
	 * @Param purchase
	 * 
	 * This method is for converting purchase entity to purchase DTO
	 * 
	 * @Return PurchaseDTO
	 */
	public PurchaseDTO preparePurchaseDTO(Purchase purchase, String authorization) {
		
		PurchaseDTO purchaseDTO = new PurchaseDTO();
		
		purchaseDTO.setAccepted(purchase.getAccepted());
		purchaseDTO.setAdvance(purchase.getAccepted());
		purchaseDTO.setAuthorise(purchase.getAuthorise());
		purchaseDTO.setAuthorisedBy(purchase.getAuthorisedBy());
		purchaseDTO.setCgst(purchase.getCgst());
		purchaseDTO.setDeliveryDate(purchase.getDeliveryDate());
		purchaseDTO.setFreight(purchase.getFreight());
		purchaseDTO.setGrandTotal(purchase.getGrandTotal());
//		purchaseDTO.setGst(purchase.getGst());
		purchaseDTO.setId(purchase.getId());
		purchaseDTO.setIgst(purchase.getIgst());
		purchaseDTO.setBillingAddr(purchase.getBillingAddr());
		//purchaseDTO.setVendor(purchase.getVendorId());
		
		purchaseDTO.setInsurance(purchase.getInsurance());
		purchaseDTO.setIsActive(purchase.getIsActive());
		purchaseDTO.setOrderDate(purchase.getOrderDate());
		purchaseDTO.setOtherCharges(purchase.getOtherCharges());
		purchaseDTO.setPoType(purchase.getPoType());
		purchaseDTO.setPreparedBy(purchase.getPreparedBy());
		purchaseDTO.setPurchaseCode(purchase.getPurchaseCode());
		
		purchaseDTO.setRegdOfficeAddr(purchase.getRegdOfficeAddr());
		purchaseDTO.setRevalidate(purchase.getRevalidate());
		purchaseDTO.setRoyalty(purchase.getRoyalty());
		purchaseDTO.setSgst(purchase.getSgst());
		purchaseDTO.setTotal_with_gst(purchase.getTotal_with_gst());
		purchaseDTO.setType(purchase.getType());
		purchaseDTO.setValidityDate(purchase.getValidityDate());
		purchaseDTO.setPkg(purchase.getPkg());
		
		DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO = new DeliveryTermsMasterforVendorDTO();
		if(purchase.getDeliveryTermsId()!=null) {
			deliveryTermsMasterforVendorDTO = deliveryMasterService.getDeliveryTermsMasterById(purchase.getDeliveryTermsId());
			
			purchaseDTO.setDeliveryTermsMasterforVendorDTO(deliveryTermsMasterforVendorDTO);
					
		}
		
		JurisdictionMasterForVendorDTO jurisdictionMasterForVendor = new JurisdictionMasterForVendorDTO();
		if(purchase.getJurisdictionId()!=null) {
			jurisdictionMasterForVendor = juridictionService.getJurisdictionMasterById(purchase.getJurisdictionId());
			purchaseDTO.setJurisdictionMasterForVendor(jurisdictionMasterForVendor);
		}
		
		PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO = new PaymentMethodMasterforVendorDTO();
		if(purchase.getPaymentMethodId()!=null) {
			paymentMethodMasterforVendorDTO = paymentMethodService.getPaymentMethodMasterById(purchase.getPaymentMethodId());
			purchaseDTO.setPaymentMethodMasterforVendorDTO(paymentMethodMasterforVendorDTO);
		}
		
		
		PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO = new PaymentTermsMasterforVendorDTO();
		if(purchase.getPaymentTermsId()!=null) {
			paymentTermsMasterforVendorDTO = paymentTermsService.getPaymentTermsMasterById(purchase.getPaymentTermsId());
			purchaseDTO.setPaymentTermsMasterforVendorDTO(paymentTermsMasterforVendorDTO);
		}
		
		
		ReminderTermsMasterForVendorDTO reminderTermsMasterForVendorDTO = new ReminderTermsMasterForVendorDTO();
		if(purchase.getReminderTermsId()!=null) {
			reminderTermsMasterForVendorDTO = reminderMasterService.getReminderTermsMasterById(purchase.getReminderTermsId());
			purchaseDTO.setReminderTermsMasterForVendorDTO(reminderTermsMasterForVendorDTO);
		}
		
		
		ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO = new ShippingMethodMasterforVendorDTO();
		if(purchase.getShippingMethodCodeId()!=null) {
			shippingMethodMasterforVendorDTO = shippingService.getShippingMethodMasterById(purchase.getShippingMethodCodeId());
			purchaseDTO.setShippingMethodMasterforVendorDTO(shippingMethodMasterforVendorDTO);
		}
		
		VendorMaster vendor = new VendorMaster();
		if(purchase.getVendorId()!=null) {
			Optional<VendorMaster> vendorO = vendorDao.findById(Integer.valueOf(purchase.getVendorId()));
			if(vendorO.isPresent()) {
				vendor = vendorO.get();
				
				purchaseDTO.setVendor(vendor);
			}
		}
		
		purchaseDTO.setPurchaseStatus(purchase.getPurchaseStatus());
		
		if(purchase.getIndentId()!=null)
			purchaseDTO.setIndent(indentServiceImpl.getIndentByIndentId(Integer.valueOf(purchase.getIndentId())));
		
		List<PurchaseDetailsDTO> purchaseDetailsDTO = new ArrayList<>();
		
		List<PurchaseDetails> purchaseDetails = new ArrayList<>();
		if(authorization.equalsIgnoreCase("none")) {
			purchaseDetails = purchaseDetailsDao.findByPoid(purchase.getId());
		}
		
		if(authorization.equalsIgnoreCase("authorized")) {
			purchaseDetails = 
					purchaseDetailsDao.findByPoidAndPoDetailsStaus(purchase.getId(), 2);
		}
		
		if(authorization.equalsIgnoreCase("unauthorized")) {
			purchaseDetails = 
					purchaseDetailsDao.findByPoidAndPoDetailsStausOrPoDetailsStausOrPoDetailsStaus(purchase.getId(), 0, 1, 4);
		}
		
//		List<PurchaseDetails> purchaseDetails = purchaseDetailsDao.findByPoid(purchase.getId());
		for(PurchaseDetails poDetails : purchaseDetails) {
			PurchaseDetailsDTO poDetailsDTO = preparePurchaseDetailsDTO(poDetails);
			purchaseDetailsDTO.add(poDetailsDTO);
		}
		purchaseDTO.setPurchaseDetails(purchaseDetailsDTO);
		
		purchaseDTO.setNotes(purchase.getNotes());
		
		purchaseDTO.setIgstPer(purchase.getIgstPer());
		purchaseDTO.setCgstPer(purchase.getCgstPer());
		purchaseDTO.setSgstPer(purchase.getSgstPer());
		purchaseDTO.setFreightPer(purchase.getFreightPer());
		purchaseDTO.setRoyaltyPer(purchase.getRoyaltyPer());
		purchaseDTO.setPkgPer(purchase.getPkgPer());
		purchaseDTO.setNotes(purchase.getNotes());
		
		
		return purchaseDTO;
	}
	

	/*
	 * @Param purchaseDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return Purchase
	 */
	public Purchase preparePurchaseEntity(PurchaseDTO purchaseDTO) {
		
		Purchase purchase = new Purchase();
		
		if(purchaseDTO.getId()!=null) {
			
			Optional<Purchase> purchaseO = purchaseDao.findById(purchaseDTO.getId());
			
			if(purchaseO.isPresent()) {
				purchase = purchaseO.get();
//				purchase.setPurchaseCode(purchaseDTO.getPurchaseCode());
			}
			
		}
		
		if(purchaseDTO.getId()==null) {
			purchase.setAccepted(0);
			purchase.setPurchaseStatus(0);
			purchase.setAuthorise("0");
		}else {
//			purchase.setAccepted(purchaseDTO.getAccepted());
//			purchase.setPurchaseStatus(purchaseDTO.getPurchaseStatus());
		}
		
		
		purchase.setAdvance(0); // need to send from UI
		
		if(purchaseDTO.getNotes()!=null)
			purchase.setNotes(purchaseDTO.getNotes());
		else
			purchase.setNotes("");
		
		purchase.setAuthorisedBy(purchaseDTO.getAuthorisedBy());
		
		if(purchaseDTO.getCgst()!=null)
			purchase.setCgst(purchaseDTO.getCgst());
		else
			purchase.setCgst(0.0);
		
		purchase.setDeliveryDate(purchaseDTO.getDeliveryDate());
		
		if(purchaseDTO.getFreight()!=null)
			purchase.setFreight(purchaseDTO.getFreight());
		else
			purchase.setFreight(0.0);
		
		if(purchaseDTO.getGrandTotal()!=null)
			purchase.setGrandTotal(purchaseDTO.getGrandTotal());
		else
			purchase.setGrandTotal(0.0);
		
//		purchase.setGst(purchaseDTO.getGst());
		purchase.setId(purchaseDTO.getId());
		
		if(purchaseDTO.getIgst()!=null)
			purchase.setIgst(purchaseDTO.getIgst());
		else
			purchase.setIgst(0.0);
		
		purchase.setInsurance(purchaseDTO.getInsurance());
		purchase.setIsActive(1);
		purchase.setOrderDate(purchaseDTO.getOrderDate());
		
		if(purchaseDTO.getOtherCharges()!=null)
			purchase.setOtherCharges(purchaseDTO.getOtherCharges());
		else
			purchase.setOtherCharges(0.0);
		
		purchase.setPoType(purchaseDTO.getPoType());
		purchase.setPreparedBy(purchaseDTO.getPreparedBy());
//		purchase.setPurchaseCode(purchaseDTO.getPurchaseCode());
		
		purchase.setRegdOfficeAddr(purchaseDTO.getRegdOfficeAddr());
		purchase.setRevalidate(purchaseDTO.getRevalidate());
		
		if(purchaseDTO.getRoyalty()!=null)
			purchase.setRoyalty(purchaseDTO.getRoyalty());
		else
			purchase.setRoyalty(0.0);
		
		if(purchaseDTO.getSgst()!=null)
			purchase.setSgst(purchaseDTO.getSgst());
		else
			purchase.setSgst(0.0);
		
//		purchase.setTotal_with_gst(purchaseDTO.getTotal_with_gst());
		purchase.setType(purchaseDTO.getType());
		purchase.setValidityDate(purchaseDTO.getValidityDate());
		
		List<PurchaseDetailsDTO> purchaseDetailsDTOs = purchaseDTO.getPurchaseDetails();
		List<PurchaseDetails> purchaseDetailsEntitys = new ArrayList<>();
		for(PurchaseDetailsDTO poDetailsDTO : purchaseDetailsDTOs) {
			PurchaseDetails poDetails = preparePurchaseDetailsEntity(poDetailsDTO);
			purchaseDetailsEntitys.add(poDetails);
		}
		purchase.setPurchaseDetails(purchaseDetailsEntitys);
		
		Indent indent = new Indent();
		if(purchaseDTO.getIndent()!=null) {
			Optional<Indent> indentO = indentDao.findById(purchaseDTO.getIndent().getId());
			if(indentO.isPresent()) {
				indent = indentO.get();
			}
		}
		purchase.setIndentId(String.valueOf(indent.getId()));
		purchase.setIndentCode(indent.getIndentCode());
			
		VendorMaster vendor = new VendorMaster();
		if(purchaseDTO.getVendor()!=null) {
			Optional<VendorMaster> vendorO = vendorDao.findById(purchaseDTO.getVendor().getId());
			if(vendorO.isPresent()) {
				vendor = vendorO.get();
			}
		}
		if(vendor!=null) {
			purchase.setVendorCode(vendor.getVendorCode());
			purchase.setVendorId(vendor.getId());
			purchase.setVendorName(vendor.getVendorName());
		}
		
		if(purchaseDTO.getPkg()!=null)
			purchase.setPkg(purchaseDTO.getPkg());
		else
			purchase.setPkg(0.0);
		
		purchase.setCreatedDate(new Date());
		purchase.setBillingAddr(purchaseDTO.getBillingAddr());
		
		if(purchaseDTO.getIgstPer()!=null)
			purchase.setIgstPer(purchaseDTO.getIgstPer());
		else
			purchase.setIgstPer(0.0);
		
		if(purchaseDTO.getCgstPer()!=null)
			purchase.setCgstPer(purchaseDTO.getCgstPer());
		else
			purchase.setCgstPer(0.0);
		
		if(purchaseDTO.getSgstPer()!=null)
			purchase.setSgstPer(purchaseDTO.getSgstPer());
		else
			purchase.setSgstPer(0.0);
		
		if(purchaseDTO.getFreightPer()!=null)
			purchase.setFreightPer(purchaseDTO.getFreightPer());
		else
			purchase.setFreightPer(0.0);
		
		if(purchaseDTO.getRoyaltyPer()!=null)
			purchase.setRoyaltyPer(purchaseDTO.getRoyaltyPer());
		else
			purchase.setRoyaltyPer(0.0);
		
		if(purchaseDTO.getPkgPer()!=null)
			purchase.setPkgPer(purchaseDTO.getPkgPer());
		else
			purchase.setPkgPer(0.0);
		
		if(purchaseDTO.getPaymentMethodMasterforVendorDTO()!=null)
			purchase.setPaymentMethodId(purchaseDTO.getPaymentMethodMasterforVendorDTO().getId());
		if(purchaseDTO.getPaymentTermsMasterforVendorDTO()!=null)
			purchase.setPaymentTermsId(purchaseDTO.getPaymentTermsMasterforVendorDTO().getId());
		if(purchaseDTO.getJurisdictionMasterForVendor()!=null)
			purchase.setJurisdictionId(purchaseDTO.getJurisdictionMasterForVendor().getId());
		if(purchaseDTO.getReminderTermsMasterForVendorDTO()!=null)
			purchase.setReminderTermsId(purchaseDTO.getReminderTermsMasterForVendorDTO().getId());
		if(purchaseDTO.getShippingMethodMasterforVendorDTO()!=null)
			purchase.setShippingMethodCodeId(purchaseDTO.getShippingMethodMasterforVendorDTO().getId());
		if(purchaseDTO.getDeliveryTermsMasterforVendorDTO()!=null)
			purchase.setDeliveryTermsId(purchaseDTO.getDeliveryTermsMasterforVendorDTO().getId());
		
		return purchase;
	}

	
	/*
	 * @Param purchaseDetails
	 * 
	 * Method for creating pruchase details DTO from purchase Deatails entity
	 * 
	 * @Return @PurchaseDetailsDTO
	 */
	public PurchaseDetailsDTO preparePurchaseDetailsDTO(PurchaseDetails purchaseDetails) {
		
		PurchaseDetailsDTO purchaseDetailsDTO = new PurchaseDetailsDTO();
		
		purchaseDetailsDTO.setAccountsHead(purchaseDetails.getAccountsHead());
		purchaseDetailsDTO.setAssesValue(purchaseDetails.getAssesValue());
		purchaseDetailsDTO.setId(purchaseDetails.getId());
		
		UomMaster baseUomDTO = new UomMaster();
		if(purchaseDetails.getBaseUom()!=null && !purchaseDetails.getBaseUom().equals("null")) {
			baseUomDTO = prepareUomDTO(Integer.valueOf(purchaseDetails.getPurUom()));
			purchaseDetailsDTO.setBaseUom(baseUomDTO);
		}
		
		
		if(purchaseDetails.getConvQty()!=null)
			purchaseDetailsDTO.setConvQty(purchaseDetails.getConvQty());
		else
			purchaseDetailsDTO.setConvQty(0.0);
			
		purchaseDetailsDTO.setDescription(purchaseDetails.getDescription());
		
		if(purchaseDetails.getDisc()!=null)
			purchaseDetailsDTO.setDisc(purchaseDetails.getDisc());
		else
			purchaseDetailsDTO.setDisc(0.0);
		
		purchaseDetails.setId(purchaseDetails.getId());
		
		purchaseDetailsDTO.setIndentReqQty(purchaseDetails.getIndentReqQty());
		
		ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
		if(purchaseDetails.getItemId()!=null) {
			itemDTO = getItemMaster(purchaseDetails.getItemId());
			
			purchaseDetailsDTO.setItemCode(itemDTO);
			
			if(itemDTO.getItemId()!=null) {
				List<StoreDetailsDTO> store = storeDetailsServiceImpl.findStoreDetailsByItemId(purchaseDetails.getItemId());
				Double availStock = 0.0;
				for(int i = 0 ; i > store.size() ; i++ ) {
					availStock = availStock + store.get(i).getQuantity(); 
				}
				purchaseDetailsDTO.setAvailableStock(availStock);
			}
		}
		
		purchaseDetailsDTO.setMake(purchaseDetails.getMake());
		purchaseDetailsDTO.setMaxQty(purchaseDetails.getMaxQty());
		purchaseDetailsDTO.setMinQty(purchaseDetailsDTO.getMinQty());
		purchaseDetailsDTO.setPendingIndentQty(purchaseDetailsDTO.getPendingIndentQty());
		purchaseDetailsDTO.setPendingPurQty(purchaseDetailsDTO.getPendingPurQty());
		purchaseDetailsDTO.setPendingSale(String.valueOf(purchaseDetails.getPendingSale()));
		
		purchaseDetailsDTO.setPoid(purchaseDetails.getPoid());
		
		purchaseDetailsDTO.setPurPrice(purchaseDetails.getPurPrice());
		purchaseDetailsDTO.setPurQty(purchaseDetails.getPurQty());
		
		UomMaster purUomDTO = new UomMaster(); 
		if(purchaseDetails.getPurUom()!=null && !purchaseDetails.getPurUom().equals("null")) {
			purUomDTO = prepareUomDTO(Integer.valueOf(purchaseDetails.getPurUom()));
			purchaseDetailsDTO.setPurUom(purUomDTO);
		}
		
		
		purchaseDetailsDTO.setQcSpec(purchaseDetails.getQcSpec());
		purchaseDetailsDTO.setRemarks(purchaseDetails.getRemarks());
		purchaseDetailsDTO.setReorderLevel(purchaseDetails.getReorderLevel());
		purchaseDetailsDTO.setTariff(purchaseDetails.getTariff());
		
		if(purchaseDetails.getTotal()!=null)
			purchaseDetailsDTO.setTotal(purchaseDetails.getTotal());
		else
			purchaseDetailsDTO.setTotal(0.0);
		
		if(purchaseDetails.getWeight()!=null)
			purchaseDetailsDTO.setWeight(purchaseDetails.getWeight());
		else
			purchaseDetailsDTO.setWeight(0.0);
		
		purchaseDetailsDTO.setCreatedDate(purchaseDetails.getCreatedDate());
//		purchaseDetailsDTO.setPoDetailsStaus(purchaseDetails.getPoDetailsStaus());
		
		purchaseDetailsDTO.setRateType(purchaseDetails.getRateType());
		
		if(purchaseDetails.getMaxQty()!=null)
			purchaseDetailsDTO.setMaxQty(purchaseDetails.getMaxQty());
		else
			purchaseDetailsDTO.setMaxQty(0.0);
		
		if(purchaseDetails.getMinQty()!=null)
			purchaseDetailsDTO.setMinQty(purchaseDetails.getMinQty());
		else
			purchaseDetailsDTO.setMinQty(0.0);
		
		if(purchaseDetails.getPendingIndentQty()!=null)
			purchaseDetailsDTO.setPendingIndentQty(purchaseDetails.getPendingIndentQty());
		else
			purchaseDetailsDTO.setPendingIndentQty(0.0);
		
		if(purchaseDetails.getPendingPurQty()!=null)
			purchaseDetailsDTO.setPendingPurQty(purchaseDetails.getPendingPurQty());
		else
			purchaseDetailsDTO.setPendingPurQty(0.0);
		
		
		return purchaseDetailsDTO;
	}

	/*
	 * @Param purchaseDetailsDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return PurchaseDetails
	 */
	public PurchaseDetails preparePurchaseDetailsEntity(PurchaseDetailsDTO purchaseDetailsDTO) {
		
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		
		if(purchaseDetailsDTO.getId()!=null) {
			Optional<PurchaseDetails> purchaseDetailsO = purchaseDetailsDao.findById(purchaseDetailsDTO.getId());
			if(purchaseDetailsO.isPresent()) {
				purchaseDetails = purchaseDetailsO.get();
			}
		}
		
		purchaseDetails.setAccountsHead(purchaseDetailsDTO.getAccountsHead());
		
		if(purchaseDetailsDTO.getAssesValue()!=null)
			purchaseDetails.setAssesValue(Double.valueOf(purchaseDetailsDTO.getAssesValue()));
		else
			purchaseDetails.setAssesValue(Double.valueOf(0.0));
		
//		purchaseDetails.setAssesValue(Double.valueOf(purchaseDetailsDTO.getAssesValue()));
		
		if(purchaseDetailsDTO.getBaseUom()!=null)
			purchaseDetails.setBaseUom(String.valueOf(purchaseDetailsDTO.getBaseUom().getUomId()));
		
		if(purchaseDetailsDTO.getConvQty()!=null)
			purchaseDetails.setConvQty(purchaseDetailsDTO.getConvQty());
		else
			purchaseDetails.setConvQty(0.0);
		
		purchaseDetails.setDescription(purchaseDetailsDTO.getDescription());
		
		if(purchaseDetailsDTO.getDisc()!=null)
			purchaseDetails.setDisc(purchaseDetailsDTO.getDisc());
		else
			purchaseDetails.setDisc(0.0);
		
//		purchaseDetails.setDisc(purchaseDetailsDTO.getDisc());
		
		if(purchaseDetailsDTO.getId()!=null)
			purchaseDetails.setId(purchaseDetailsDTO.getId());
		
		if(purchaseDetailsDTO.getIndentReqQty()!=null)
			purchaseDetails.setIndentReqQty(purchaseDetailsDTO.getIndentReqQty());
		else
			purchaseDetails.setIndentReqQty(0.0);
		
		purchaseDetails.setItemCode(purchaseDetailsDTO.getItemCode().getItemCode());
		purchaseDetails.setItemId(purchaseDetailsDTO.getItemCode().getItemId());
		purchaseDetails.setMake(purchaseDetailsDTO.getMake());
		
		if(purchaseDetailsDTO.getMaxQty()!=null)
			purchaseDetails.setMaxQty(purchaseDetailsDTO.getMaxQty());
		else
			purchaseDetails.setMaxQty(0.0);
		
		if(purchaseDetailsDTO.getMinQty()!=null)
			purchaseDetails.setMinQty(purchaseDetailsDTO.getMinQty());
		else
			purchaseDetails.setMinQty(0.0);
		
		if(purchaseDetailsDTO.getPendingIndentQty()!=null)
			purchaseDetails.setPendingIndentQty(purchaseDetailsDTO.getPendingIndentQty());
		else
			purchaseDetails.setPendingIndentQty(0.0);
		
		if(purchaseDetailsDTO.getPendingPurQty()!=null && !purchaseDetailsDTO.getPendingPurQty().equals("null"))
			purchaseDetails.setPendingPurQty(purchaseDetailsDTO.getPendingPurQty());

		if(purchaseDetailsDTO.getPendingSale()!=null && !purchaseDetailsDTO.getPendingSale().equals("null"))
			purchaseDetails.setPendingSale(Double.valueOf(purchaseDetailsDTO.getPendingSale()));
		
		purchaseDetails.setPoid(purchaseDetailsDTO.getPoid());
		
		if(purchaseDetailsDTO.getPurPrice()!=null)
			purchaseDetails.setPurPrice(purchaseDetailsDTO.getPurPrice());
		else
			purchaseDetails.setPurPrice(0.0);
		
		if(purchaseDetailsDTO.getPurQty()!=null)
			purchaseDetails.setPurQty(purchaseDetailsDTO.getPurQty());
		else
			purchaseDetails.setPurQty(0.0);
		
		if(purchaseDetailsDTO.getPurUom()!=null && !purchaseDetailsDTO.getPurUom().equals("null"))
			purchaseDetails.setPurUom(String.valueOf(purchaseDetailsDTO.getPurUom().getUomId()));
		
		purchaseDetails.setQcSpec(purchaseDetailsDTO.getQcSpec());
		purchaseDetails.setRemarks(purchaseDetailsDTO.getRemarks());
		
		if(purchaseDetailsDTO.getReorderLevel()!=null)
			purchaseDetails.setReorderLevel(purchaseDetailsDTO.getReorderLevel());
		else
			purchaseDetails.setReorderLevel(0.0);
		
		purchaseDetails.setTariff(purchaseDetailsDTO.getTariff());
		purchaseDetails.setTotal(purchaseDetailsDTO.getTotal());
		
		if(purchaseDetailsDTO.getWeight()!=null && !purchaseDetailsDTO.getWeight().equals("null"))
			purchaseDetails.setWeight(purchaseDetailsDTO.getWeight());
		else
			purchaseDetails.setWeight(0.0);
		
		purchaseDetails.setPoDetailsStaus(0);
		purchaseDetails.setCreatedDate(new Date());
		
		purchaseDetails.setRateType(purchaseDetailsDTO.getRateType());
		
		return purchaseDetails;
	}
	
	/*
	 *@Param uomId
	 * 
	 * fetching UOM master by uomId
	 * 
	 * @Return UomMasterDTO
	 */
	public UomMaster prepareUomDTO(Integer uomId) {
		UomMaster uomDTO = new UomMaster();
		
		uomDTO = uomService.getUomByUomId(uomId);
		
		return uomDTO;
	}
	
	/*
	 * @Param itemId
	 * 
	 * fetching item
	 * 
	 * @Return ItemForCategoryMapDTO
	 */
	public ItemForCategoryMapDTO getItemMaster(Integer itemId) {
		
		ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
		
		Optional<ItemMaster> itemO = itemDao.findById(itemId);
		
		ItemMaster item = itemO.get();
		itemDTO.setItemCode(item.getItemCode());
		itemDTO.setItemId(item.getId());
		itemDTO.setItemName(item.getItemName());
		
		CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
		
		if(item.getCategoryId2()!=null) {
			Optional<Category> categoryO = categoryRepo.findById(item.getCategoryId2());
			if(categoryO.isPresent()) {
				Category category = categoryO.get();
				categoryDTO.setCategoryId(category.getCategoryId());
				categoryDTO.setCategoryName(category.getCategoryName());
				
				itemDTO.setCategory(categoryDTO);
			}
		}
		
		SubCategoryForMappingDTO subCategoryDTO = new SubCategoryForMappingDTO();
		
		if(item.getSubCategoryId2()!=null) {
			Optional<SubCategory> subCategoryO = subCategoryRepo.findById(item.getSubCategoryId2());
			
			if(subCategoryO.isPresent()) {
				SubCategory subCategory = subCategoryO.get();
				subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
				subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
				
				itemDTO.setSubCategory(subCategoryDTO);
			}
		}
		
		return itemDTO;
	
	}
	
}
