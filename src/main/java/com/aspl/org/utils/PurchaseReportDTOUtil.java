package com.aspl.org.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aspl.org.dao.CompanyMasterDao;
import com.aspl.org.dto.GoodsReceiptNoteReportDTO;
import com.aspl.org.dto.GoodsReceiptNoteReportItemsDTO;
import com.aspl.org.dto.PendingPurchaseIndentReportIndentWiseDTO;
import com.aspl.org.dto.PendingPurchaseIndentReportIndentWiseItemDetailsDTO;
import com.aspl.org.dto.PurchaseOrderReportDTO;
import com.aspl.org.dto.PurchaseOrderReportItemDTO;
import com.aspl.org.dto.VendorMasterDTO;
import com.aspl.org.entity.CompanyMaster;
import com.aspl.org.entity.ContactsDetails;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.DepartmentMaster;
import com.aspl.org.entity.GoodReceiptNoteItemDetails;
import com.aspl.org.entity.GoodsRecieptNoteHeader;
import com.aspl.org.entity.Indent;
import com.aspl.org.entity.IndentDetails;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.Purchase;
import com.aspl.org.entity.PurchaseDetails;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.entity.VendorMaster;
import com.aspl.org.repository.ContactsDetailsDao;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.DepartmentMasterRepo;
import com.aspl.org.repository.GoodReceiptNoteItemDetailsRepository;
import com.aspl.org.repository.GoodsReceiptNoteRepository;
import com.aspl.org.repository.IndentDao;
import com.aspl.org.repository.IndentDetailsDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.PurchaseDao;
import com.aspl.org.repository.PurchaseDetailsDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.repository.StoreDetailsDao;
import com.aspl.org.repository.UomMasterRepo;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.impl.VendorMasterServiceImpl;

/*
 * Util class for generating DTOs of purchase reports
 */
@Component
public class PurchaseReportDTOUtil {
	
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
	JurisdictionMasterDao juridictionDao;

	/*
	 * @Param goodReceiptNoteItemDetails
	 * 
	 * This method takes GoodReceiptNoteItemDetails object as param and returns GoodsReceiptNoteReportItemsDTO for GRN report's GRN items.
	 * It fetches data from GoodReceiptNoteItemDetails and UomMaster table.
	 * 
	 * @Return GoodsReceiptNoteReportItemsDTO
	 */
	public GoodsReceiptNoteReportItemsDTO prepareGoodsReceiptNoteReportItemDetailsDTO(
			GoodReceiptNoteItemDetails goodReceiptNoteItemDetails) {
		
		GoodsReceiptNoteReportItemsDTO dto = new GoodsReceiptNoteReportItemsDTO();
		
		ItemMaster item = new ItemMaster();
		if(goodReceiptNoteItemDetails.getItemId()!=null) {
			item = itemDao.findById(goodReceiptNoteItemDetails.getItemId()).get();
		}
		
		dto.setAcceptedQnt(goodReceiptNoteItemDetails.getAcceptedQnt());
		dto.setChallanQnt(goodReceiptNoteItemDetails.getInvoiceQnt());
		dto.setItemCode(item.getItemCode());
		dto.setItemName(item.getItemName());
		dto.setItemDescription(item.getRemarks());
		dto.setRateType(goodReceiptNoteItemDetails.getRateType());
		dto.setReceivedQnt(goodReceiptNoteItemDetails.getReceivedQnt());
		dto.setRejectedQnt(goodReceiptNoteItemDetails.getRejectedQnt());
		
		UomMaster uom = new UomMaster();
		if(goodReceiptNoteItemDetails.getUomId()!=null) {
			Optional<UomMaster> uomO = uomRepo.findById(Integer.valueOf(goodReceiptNoteItemDetails.getUomId()));
			if(uomO.isPresent()) {
				uom = uomO.get();
			}
		}
		
		dto.setUnit(uom.getUomDescription());
		dto.setWtPerUnit(String.valueOf(goodReceiptNoteItemDetails.getWtPerUnit()));
		if(goodReceiptNoteItemDetails.getReceivedQnt()!=null && !goodReceiptNoteItemDetails.getReceivedQnt().equals("null")
				&& goodReceiptNoteItemDetails.getWtPerUnit()!=null && !goodReceiptNoteItemDetails.getWtPerUnit().equals("null")) {
			dto.setReceivedWt((goodReceiptNoteItemDetails.getReceivedQnt()*goodReceiptNoteItemDetails.getWtPerUnit()));
		}
		
		
		return dto;
	}
	
	/*
	 * @Param goodsRecieptNoteHeader
	 * 
	 * This method takes GoodsRecieptNoteHeader object as param and returns GoodsReceiptNoteReportDTO for GRN report's GRN header.
	 * It fetches data from GoodsReceiptNoteHeader, PurchaseOrder, TransporterMaster and GoodReceiptNoteItemDetails table. After fetching GoodReceiptNoteItemDetails
	 * data it is sent to prepareGoodsReceiptNoteReportItemDetailsDTO() method for generating the DTO of GoodsReceiptNoteReportItemDetailsDTO and then added to 
	 * GoodsReceiptNoteReportDTO object's GoodsRecieptNoteHeader.
	 * 
	 * @Return GoodsReceiptNoteReportDTO
	 */
	public GoodsReceiptNoteReportDTO prepareGoodsReceiptNoteReportDTO(GoodsRecieptNoteHeader goodsRecieptNoteHeader) {
		
		GoodsReceiptNoteReportDTO dto = new GoodsReceiptNoteReportDTO();
		
		dto.setAuthoriseDate(goodsRecieptNoteHeader.getAuthoriseDate());
		dto.setDcDate(goodsRecieptNoteHeader.getDcDate());
		dto.setDcNo(goodsRecieptNoteHeader.getDcNo());
		
		  dto.setGrnDate(goodsRecieptNoteHeader.getCreatedDate()); 
		  dto.setGrnNo(goodsRecieptNoteHeader.getGrnNo());
		  dto.setInvoiceDate(goodsRecieptNoteHeader.getInvoiceDate());
		  dto.setInvoiceNo(goodsRecieptNoteHeader.getInvoiceNo());
		  dto.setAuthorisedBy(goodsRecieptNoteHeader.getAuthorisedBy());
		  dto.setCheckedBy(goodsRecieptNoteHeader.getAuthorisedBy());
		  dto.setPreparedBy(goodsRecieptNoteHeader.getAuthorisedBy());
		  dto.setNotes(goodsRecieptNoteHeader.getNotes());
		  
		  Purchase po = new Purchase();
		  
		  if(goodsRecieptNoteHeader.getPoId()!=null && !goodsRecieptNoteHeader.getPoId().equals("null")) {
			  Optional<Purchase> poO = purchaseDao.findById(Integer.valueOf(goodsRecieptNoteHeader.getPoId()));
			  
			  if(poO.isPresent()) {
				  po = poO.get();
			  }
		  }
		  
		  dto.setPoDate(po.getOrderDate()); 
		  dto.setPoNo(po.getPurchaseCode());
		  
		  /*Optional<Transporter> transporterO = transporterRepo.findById(goodsRecieptNoteHeader.getTransporterId());
		  Transporter transporter = new Transporter();
		  if(transporterO.isPresent()) {
			  transporter = transporterO.get();
		  }*/
		  
		  dto.setTransport(goodsRecieptNoteHeader.getTransporterName());
		  
		  VendorMaster vendor = new VendorMaster();
		  VendorMasterDTO vendorDTO = new VendorMasterDTO();
		  
		  if(goodsRecieptNoteHeader.getVendorId()!=null) {
			  Optional<VendorMaster> vendorO = vendorDao.findById(Integer.valueOf(goodsRecieptNoteHeader.getVendorId()));
			  if(vendorO.isPresent()) {
				  vendor = vendorO.get();
				  vendorDTO = vendorService.prepareVendorMasterDTO(vendor); 
			  }
		  }
		  
		  dto.setVendorMaster(vendorDTO);
		  
		  Double totalAcceptedQnt = 0.0;
		  Double totalChalanQnt = 0.0;
		  Double totalReceivedQnt = 0.0;
		  Double totalReceivedWt = 0.0;
		  Double totalRejectedQnt = 0.0;
		  
		  List<GoodsReceiptNoteReportItemsDTO> goodsReceiptNoteReportItemsDTO = new ArrayList<>();
		  
		  List<GoodReceiptNoteItemDetails> details = grnDetailsRepo.findByGrnHeaderId(goodsRecieptNoteHeader.getGrnId());
		  for(GoodReceiptNoteItemDetails grnDetails : details) {
			  
			  GoodsReceiptNoteReportItemsDTO detailsDto = new GoodsReceiptNoteReportItemsDTO();
			  detailsDto = prepareGoodsReceiptNoteReportItemDetailsDTO(grnDetails);
			  
			  if(grnDetails.getAcceptedQnt()!=null)
				  totalAcceptedQnt = totalAcceptedQnt + grnDetails.getAcceptedQnt();
			  
			  if(grnDetails.getInvoiceQnt()!=null)
				  totalChalanQnt = totalChalanQnt + grnDetails.getInvoiceQnt();
			  
			  if(grnDetails.getReceivedQnt()!=null)
				  totalReceivedQnt = totalReceivedQnt + grnDetails.getReceivedQnt();
			  
			  if(grnDetails.getWtPerUnit()!=null && grnDetails.getReceivedQnt()!=null)
				  totalReceivedWt = totalReceivedWt + (grnDetails.getWtPerUnit() * grnDetails.getReceivedQnt());
			  
			  if(grnDetails.getRejectedQnt()!=null)
				  totalRejectedQnt = totalRejectedQnt + grnDetails.getRejectedQnt();
			  
			  goodsReceiptNoteReportItemsDTO.add(detailsDto);
		  }
		  dto.setGoodsReceiptNoteReportItemsDTO(goodsReceiptNoteReportItemsDTO);
		 
		  dto.setTotalAcceptedQnt(totalAcceptedQnt);
		  dto.setTotalChalanQnt(totalChalanQnt);
		  dto.setTotalReceivedQnt(totalReceivedQnt);
		  dto.setTotalReceivedWt(totalReceivedWt);
		  dto.setTotalRejectedQnt(totalRejectedQnt);
		
		return dto;
	}
	
	/*
	 * @Param indent
	 * 
	 * This method takes Indent object as param and returns PendingPurchaseIndentReportIndentWiseDTO object. This is to generate PendingPurchaseIndentReportIndentWise
	 * report for purchase module. This method fetches data from Indent, IndentDetails, DepartmentMaster, Purchase, PurchaseDetails, GoodReceiptNote, 
	 * GoodReceiptNoteItemDetails table. After fecthing indent details data it is passed to PendingPurchaseIndentReportIndentWiseItemDetailsDTO() to convert it to 
	 * PendingPurchaseIndentReportIndentWiseItemDetailsDTO DTO oject and adds it to PendingPurchaseIndentReportIndentWiseDTO object and return the
	 * PendingPurchaseIndentReportIndentWiseDTO object. 
	 * 
	 * @Return PendingPurchaseIndentReportIndentWiseDTO
	 */
	public PendingPurchaseIndentReportIndentWiseDTO preparePendingPurchaseIndentReportIndentWiseDTO(Indent indent) {
		
		PendingPurchaseIndentReportIndentWiseDTO dto = new PendingPurchaseIndentReportIndentWiseDTO();
		
//		dto.setCompanyName(companyName);
		
		Optional<DepartmentMaster> deptO = null;
		DepartmentMaster dept = new DepartmentMaster();
		if(indent.getDepartment()!=null) {
			deptO = deptDao.findById(indent.getDepartment());
			if(deptO.isPresent()) {
				dept = deptO.get();
			}
		}
		
		if(dept!=null)
			dto.setDepartment(dept.getDepartmentname());
		else
			dto.setDepartment("NA");
		
//		dto.setFactoryAddress(factoryAddress);
		
		dto.setIndentAuthDate(indent.getAuthoriseDate());
		dto.setIndentCode(indent.getIndentCode());
		dto.setIndentDate(indent.getIndentDate());
		
		dto.setNotes(indent.getNotes());
		
		List<IndentDetails> indentDetails = new ArrayList<>();
		
		indentDetails = indent.getIndentDetails();
		
		List<PendingPurchaseIndentReportIndentWiseItemDetailsDTO> dtos = new ArrayList<>();
		for(IndentDetails id : indentDetails) {
			PendingPurchaseIndentReportIndentWiseItemDetailsDTO detailsDto = new PendingPurchaseIndentReportIndentWiseItemDetailsDTO();
			
			detailsDto.setIndentQnt(id.getReqQty());
//			ItemMaster item = itemDao.findById(id.getItemId()).get();
			detailsDto.setPendingIndentQnt(id.getPendingIndentQty());
			detailsDto.setPendingPurQnt(id.getPendingPurQty());
			
			ItemMaster item = new ItemMaster();
			Optional<ItemMaster> itemO = itemDao.findById(id.getItemId());
			if(itemO.isPresent()) {
				item = itemO.get();
			}
			
			String agency = "NA";
			String poNo = "NA";
			String poDate = "NA";
			String lastPrice = "NA";
			
			List<PurchaseDetails> purDetailsEmpList = new ArrayList<>();
			List<PurchaseDetails> purDetailsList = purchaseDetailsDao.findByItemId(item.getId());
			if(!purDetailsList.isEmpty()) {
				for(PurchaseDetails pd : purDetailsList) {
					
					Purchase po = new Purchase();
					if(pd.getPoid()!=null) {
						Optional<Purchase> poO = purchaseDao.findById(pd.getPoid());
						if(poO.isPresent()) {
							po = poO.get();
						}
					}
					
					VendorMaster vendor = new VendorMaster();
					if(po.getVendorId()!=null) {
						Optional<VendorMaster> vendorO = vendorDao.findById(po.getVendorId());
						if(vendorO.isPresent()) {
							vendor = vendorO.get();
						}
					}
					
					if(vendor.getVendorName()!=null)
						agency = vendor.getVendorName();
					
					if(po.getPurchaseCode()!=null)
						poNo = po.getPurchaseCode();
					
					if(po.getCreatedDate()!=null)
						poDate = String.valueOf(po.getCreatedDate());
					
					if(pd.getPurPrice()!=null)
						lastPrice = String.valueOf(pd.getPurPrice());
				}
			}
			
			UomMaster baseUom = new UomMaster();
			if(id.getBaseUom()!=null && !id.getBaseUom().equals("null")) {
				Optional<UomMaster> baseUomO = uomRepo.findById(Integer.valueOf(id.getBaseUom()));
				if(baseUomO.isPresent()) {
					baseUom = baseUomO.get();
				}
			}
			
			detailsDto.setItemCode(item.getItemCode());
			detailsDto.setIndentQnt(id.getReqQty());
			
			if(poDate!=null)
				poDate = poDate.split("\\s")[0];
			
			detailsDto.setLastPoDetails(agency + " " + poNo + " " + poDate.split("\\s")[0]);
			
			
			detailsDto.setReqQnt(String.valueOf(id.getReqQty()));
			detailsDto.setUnit(baseUom.getUomDescription());
			detailsDto.setItemDescription(item.getRemarks());
			detailsDto.setItemName(item.getItemName());
			
			dtos.add(detailsDto);
		}
		dto.setPendingPurchaseIndentReportIndentWiseItemDetailsDTO(dtos);
		
		Purchase po = new Purchase();
		if(indent.getId()!=null) {
			List<Purchase> pos = purchaseDao.findByIndentId(String.valueOf(indent.getId())); 
			if(!pos.isEmpty()) {
				po = pos.get(0);
			}
			if(po!=null) {
				dto.setPurchaseCode(po.getPurchaseCode());
				dto.setPurchaseDate(po.getOrderDate());
			}
		}
		
		List<PurchaseDetails> poDetails = new ArrayList<>();
		if(po!=null) {
			poDetails = poDetailsDao.findByPoid(po.getId());
		}
		
		Double purQnt = 0.0;
		if(!poDetails.isEmpty()) {
			for(PurchaseDetails pd : poDetails) {
				if(pd.getPurQty()!=null) {
					purQnt = purQnt + pd.getPurQty();
				}
			}
		}
		dto.setPurchaseQnt(purQnt);
		
		List<GoodsRecieptNoteHeader> grnHeaderList = new ArrayList<>();
		GoodsRecieptNoteHeader grnHeader = new GoodsRecieptNoteHeader();
		if(po!=null) {
			grnHeaderList = grnRepo.findByPoId(String.valueOf(po.getId()));
			if(!grnHeaderList.isEmpty()) {
				grnHeader = grnHeaderList.get(0);
			}
		}
		
		List<GoodReceiptNoteItemDetails> grnDetails = new ArrayList<>();
		if(grnHeader!=null) {
			grnDetails = grnDetailsRepo.findByGrnHeaderId(grnHeader.getGrnId());
			dto.setReceiptNo(grnHeader.getGrnNo());
		}
		
		Double receivedQnt = 0.0;
		for(GoodReceiptNoteItemDetails gd : grnDetails) {
			receivedQnt = receivedQnt + gd.getReceivedQnt();
		}

		dto.setReceivedQnt(receivedQnt);
		
//		dto.setRegisteredOffcieAddress(registeredOffcieAddress);
		dto.setValidityDate(indent.getValidateDate());
		
		return dto;
	}
	
	/*
	 * @Param purchaseEntity
	 * 
	 * This method is used to convert Purchase object to PurchaseOrderReportDTO. This will fetch data from Purchase, PurchaseDetails, ItemMaster, VendorMaster,
	 * DeliveryTermsMaster, PaymentTermsMaster, ContactDetails and UomMaster. 
	 * 
	 * @Return PurchaseOrderReportDTO
	 */
	public PurchaseOrderReportDTO preparePurchaseOrderReportDTO(Purchase purchaseEntity) {
		PurchaseOrderReportDTO orderReportDTO = new PurchaseOrderReportDTO();
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		//fetching companies for billing address and shipping address
		CompanyMaster billingCompany = new CompanyMaster();
		CompanyMaster shippingCompany = new CompanyMaster();
		if(purchaseEntity.getBillingAddr()!=null) {
			Optional<CompanyMaster> company = companyDao.findById(Integer.valueOf(purchaseEntity.getBillingAddr()));
			if(company.isPresent()) {
				billingCompany = company.get();
			}
		}
		if(purchaseEntity.getRegdOfficeAddr()!=null) {
			Optional<CompanyMaster> company = companyDao.findById(Integer.valueOf(purchaseEntity.getRegdOfficeAddr()));
			if(company.isPresent()) {
				shippingCompany = company.get();
			}
		}
		
		List<PurchaseDetails> purchaseDetails = new ArrayList<>();
		if(purchaseEntity!=null) {
			purchaseDetails = purchaseDetailsDao.findByPoid(purchaseEntity.getId());
		}
		
		VendorMaster vendor = new VendorMaster();
		if(purchaseEntity.getVendorId()!=null) {
			Optional<VendorMaster> vendorO = vendorDao.findById(purchaseEntity.getVendorId());
			if(vendorO.isPresent()) {
				vendor = vendorO.get();
			}
		}
		
		orderReportDTO.setAuthorisedBy(purchaseEntity.getAuthorisedBy());
		orderReportDTO.setBuyer("");
		orderReportDTO.setCheckedBy(purchaseEntity.getAuthorisedBy());
		orderReportDTO.setCurrency(purchaseEntity.getCurrency());
		orderReportDTO.setDeliveryDate(purchaseEntity.getDeliveryDate());
		orderReportDTO.setPoRaisedBy(purchaseEntity.getPreparedBy());
		orderReportDTO.setRevalidateNo(purchaseEntity.getRevalidate());
		
		//setting billing address of billing company and shipping of shipping company registered office addresses
		orderReportDTO.setBillTo(billingCompany.getRegdOfficeAddr());
		orderReportDTO.setShipTo(shippingCompany.getRegdOfficeAddr());
		
		orderReportDTO.setNotes(purchaseEntity.getNotes());
		
		DeliveryTermsMasterforVendor deliveryTerm = new DeliveryTermsMasterforVendor();
		if(vendor.getDeliveryTermsId()!=null) {
			Optional<DeliveryTermsMasterforVendor> deliveryO = deliverTermsMasterDao.findById(vendor.getDeliveryTermsId());
			if(deliveryO.isPresent()) {
				deliveryTerm = deliveryO.get();
			}
		}
		
		PaymentTermsMasterforVendor paymentTerms = new PaymentTermsMasterforVendor();
		if(vendor.getPaymentTermsId()!=null) {
			Optional<PaymentTermsMasterforVendor> paymentTermsO = paymentTermsDao.findById(vendor.getPaymentTermsId());
			if(paymentTermsO.isPresent()) {
				paymentTerms = paymentTermsO.get();
			}
		}
		
		if(vendor.getShippingMethodCodeId()!=null) {
			Optional<ShippingMethodMasterforVendor> shippingMethodO = shippingMethodDao.findById(vendor.getShippingMethodCodeId());
			if(shippingMethodO.isPresent()) {
				ShippingMethodMasterforVendor masterforVendor = new ShippingMethodMasterforVendor();
				masterforVendor = shippingMethodO.get(); 
				orderReportDTO.setShippingMethod(masterforVendor.getDescription());
			}
		}
		
		PaymentMethodMasterforVendor paymentMethodMasterforVendor = new PaymentMethodMasterforVendor();
		if(vendor.getPaymentMethodId()!=null) {
			Optional<PaymentMethodMasterforVendor> paymentMethodMasterforVendorO = paymentMethodDao.findById(vendor.getPaymentMethodId());
			if(paymentMethodMasterforVendorO.isPresent()) {
				paymentMethodMasterforVendor = paymentMethodMasterforVendorO.get();
				orderReportDTO.setPaymentMethod(paymentMethodMasterforVendor.getDescription());
			}
		}
		
		if(vendor.getJurisdictionId()!=null) {
			Optional<JurisdictionMasterForVendor> juridictionO = juridictionDao.findById(vendor.getJurisdictionId());
			if(juridictionO.isPresent()) {
				JurisdictionMasterForVendor juri = new JurisdictionMasterForVendor();
				juri = juridictionO.get();
				orderReportDTO.setJuridiction(juri.getDescription());
			}
		}
		
		orderReportDTO.setDeliveryMethod(deliveryTerm.getDescription());
		orderReportDTO.setDeliveryTerms(deliveryTerm.getDescription());
//		orderReportDTO.setExcise(purchaseEntity.getGst());
//		orderReportDTO.setGstNo(gstNo);
		orderReportDTO.setIndentNumber(purchaseEntity.getIndentCode());

		orderReportDTO.setPaymentTerms(paymentTerms.getDescription());
		orderReportDTO.setPoDate(purchaseEntity.getOrderDate());
		orderReportDTO.setPoNumber(purchaseEntity.getPurchaseCode());
		orderReportDTO.setPreparedBy(purchaseEntity.getPreparedBy());
		
		if(purchaseEntity.getSgst()!=null)
			orderReportDTO.setSgst(Double.valueOf(df.format(purchaseEntity.getSgst())));
		else
			orderReportDTO.setSgst(0.0);
		
		if(purchaseEntity.getGrandTotal()!=null)
			orderReportDTO.setTotal(Double.valueOf(df.format(purchaseEntity.getGrandTotal())));
		else
			orderReportDTO.setTotal(0.0);
		
		//Fetching data from ContactDetails table by vendorId
		ContactsDetails contacts = new ContactsDetails();
		if(vendor.getId()!=null) {
			List<ContactsDetails> contactList = contactDao.findByVendorId(vendor.getId());
			if(!contactList.isEmpty()) {
				contacts = contactList.get(0);
			}
		}
		
		orderReportDTO.setVendorCode(vendor.getVendorCode());
		orderReportDTO.setVendorFax(contacts.getFaxNo());
		orderReportDTO.setVendorName(vendor.getVendorName());
		orderReportDTO.setVendorPhone(contacts.getContactNo());
		orderReportDTO.setVenodrGst(vendor.getGstNo());
		orderReportDTO.setVendorPan(vendor.getPanNo());
		orderReportDTO.setVendorEmail(contacts.getEmail());
		orderReportDTO.setVendorAddress(vendor.getAddress1()+" "+vendor.getAddress2());
		orderReportDTO.setContactPerson(contacts.getContactPerson());
		orderReportDTO.setPoType(purchaseEntity.getPoType());
		orderReportDTO.setValidity(String.valueOf(purchaseEntity.getValidityDate()));
		orderReportDTO.setAuthDate(String.valueOf(purchaseEntity.getAuthDate()));
		
		Double totalPoQnt = 0.0;
		Double basicTotalPoQnt = 0.0;
		Double rate = 0.0;
		Double qnt = 0.0;
		Double grandTotal = 0.0;
		Double totalWoDisc = 0.0;
		Double grandTot = 0.0;
		
		List<PurchaseOrderReportItemDTO> purchaseOrderReportItemDTO = new ArrayList<>();
		for(PurchaseDetails pd : purchaseDetails) {
			PurchaseOrderReportItemDTO dto = new PurchaseOrderReportItemDTO();
			
			ItemMaster item = new ItemMaster();
			if(pd.getItemId()!=null) {
				Optional<ItemMaster> itemO = itemDao.findById(pd.getItemId());
				if(itemO.isPresent()) {
					item = itemO.get();
				}
			}
			
			dto.setItemCode(item.getItemCode());
			dto.setItemDescription(item.getRemarks());
			dto.setItemDescription2(item.getItemName());
			
			dto.setDiscount(pd.getDisc());

			if(item.getUpdatedPrice()!=null) {
				rate = Double.valueOf(df.format(item.getUpdatedPrice()));
				dto.setRate(rate);
			}
			
			UomMaster uom = new UomMaster();
			if(pd.getPurUom()!=null && !pd.getPurUom().equals("null")) {
				Optional<UomMaster> uomO = uomRepo.findById(Integer.valueOf(pd.getPurUom()));
				if(uomO.isPresent()) {
					uom = uomO.get();
				}
			}
			dto.setUnit(uom.getUomDescription());
			
//			basicTotalPoQnt = totalPoQnt + pd.getTotal();
			
//			Double discQnt = pd.getIndentReqQty() - ((pd.getIndentReqQty()/100)*pd.getDisc());
			Double discQnt = 0.0;
			
			
			
//			orderReportDTO.setTotal(purchaseEntity.getGrandTotal());
			
//			dto.setQuantity(pd.getIndentReqQty());
			totalWoDisc = rate *(pd.getPurQty());
			discQnt =(rate *((pd.getPurQty()/100)*pd.getDisc()));
//			basicTotalPoQnt = (rate * discQnt);
			grandTotal = totalWoDisc - discQnt;
			
			grandTot = grandTot + grandTotal;
			Double grandTotD = Double.valueOf(df.format(grandTotal));
			dto.setQuantity(pd.getIndentReqQty());
			
			dto.setTotal(grandTotD);
			purchaseOrderReportItemDTO.add(dto);
		}
		
		Double grandTotD = Double.valueOf(df.format(totalPoQnt));
		orderReportDTO.setBasicTotalQnt(grandTotD);
		
		Double basicCgst = 0.0;
		Double basicSgst = 0.0;
		Double basicIgst = 0.0;
		
		//Calculating the CGST, SGST amount
		if(purchaseEntity.getPoType()!=null) {
			if(purchaseEntity.getPoType().equals("CGST,SGST")) {
				Double cgst = purchaseEntity.getCgst();
				Double sgst = purchaseEntity.getSgst();
				
//				basicCgst = (basicTotalPoQnt/100)*cgst;
//				basicSgst = (basicTotalPoQnt/100)*sgst;
				
				basicCgst = cgst;
				basicSgst = sgst;
				
//				totalPoQnt = basicTotalPoQnt + basicSgst + basicCgst;
				totalPoQnt = grandTot + basicSgst + basicCgst;
				
				orderReportDTO.setTotalPoQnt(Double.valueOf(df.format(totalPoQnt)));
				
				orderReportDTO.setBasicCgstPer(purchaseEntity.getCgstPer());
				orderReportDTO.setBasicSgstPer(purchaseEntity.getSgstPer());
				
				orderReportDTO.setTotal(totalPoQnt);
			}
		}
		//Calculating the IGSTamount
		if(purchaseEntity.getPoType()!=null) {
			if(purchaseEntity.getPoType().equals("IGST")) {
				Double igst = purchaseEntity.getIgst();
//				basicIgst = (basicTotalPoQnt/100)*igst;
				basicIgst = igst;
				
//				totalPoQnt = basicTotalPoQnt + basicIgst;
				totalPoQnt = grandTot + igst;
				
				orderReportDTO.setTotalPoQnt(Double.valueOf(df.format(totalPoQnt)));
				
				orderReportDTO.setBasicIgstPer(purchaseEntity.getIgstPer());
				
				orderReportDTO.setTotal(Double.valueOf(df.format(totalPoQnt)));
			}
		}
		
		String poTotalQntPS = null;
		String amountPaisaInWord = null;
		
		orderReportDTO.setBasicCgst(Double.valueOf(df.format(basicCgst)));
		orderReportDTO.setBasicSgst(Double.valueOf(df.format(basicSgst)));
		orderReportDTO.setBasicIgst(Double.valueOf(df.format(basicIgst)));
		
		String[] totalPoQntSA = df.format(totalPoQnt).split("\\.");
		String poTotalQntRS = String.valueOf(totalPoQntSA[0]);	//getting the rupee
		
		if(totalPoQntSA.length>1) {
			poTotalQntPS = String.valueOf(totalPoQntSA[1]); 	//getting the paisa
			amountPaisaInWord = purUtil.convertToWords(Long.parseLong(poTotalQntPS));	//converting paisa part to word
		}
		
		String amountRupeeInWord = purUtil.convertToWords(Long.parseLong(poTotalQntRS));	//converting rupees part to word
		
		if(totalPoQntSA.length>1)
			orderReportDTO.setAmountInWords(amountRupeeInWord+" Rupees and "+ amountPaisaInWord + " Paisa Only");
		else
			orderReportDTO.setAmountInWords(amountRupeeInWord+"Rupees Only");
		
		orderReportDTO.setPurchaseOrderReportItemDTO(purchaseOrderReportItemDTO);
		
		orderReportDTO.setTotalPoQnt(Double.valueOf(df.format(totalPoQnt)));
		
		return orderReportDTO;
	}
	
}
