package com.aspl.org.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aspl.org.dto.GoodReceiptNoteItemDetailsDTO;
import com.aspl.org.dto.GoodsReceiptNoteHeaderDTO;
import com.aspl.org.dto.POforGRNDTO;
import com.aspl.org.entity.GoodsRecieptNoteHeader;
import com.aspl.org.entity.Purchase;
import com.aspl.org.entity.VendorMaster;
import com.aspl.org.repository.GoodReceiptNoteItemDetailsRepository;
import com.aspl.org.repository.GoodsReceiptNoteRepository;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.PurchaseDao;
import com.aspl.org.repository.StoreDetailsDao;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.GoodReceiptNoteItemDetailsService;
import com.aspl.org.service.StoreDetailsService;
import com.aspl.org.service.impl.FinishedGoodsTransactionServiceImpl;
import com.aspl.org.service.impl.RawMaterialTransactionServiceImpl;

@Component
public class GRNEntityDTOConversionUtil {

	@Autowired
	GoodsReceiptNoteRepository grnRepo;
	
	@Autowired
	PurchaseDao poDao;
	
	@Autowired
	GoodReceiptNoteItemDetailsService grnDetailsService;
	
	@Autowired
	StoreDetailsService storeDetailsService;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	GoodReceiptNoteItemDetailsRepository grnDetalsRepo;
	
	@Autowired
	StoreDetailsDao storeDao;
	
	@Autowired
	VendorMasterDao vendorDao;
	
	@Autowired
	FinishedGoodsTransactionServiceImpl finishedGoodsTransService;
	
	@Autowired
	RawMaterialTransactionServiceImpl rawMaterialTransService;
	
	
	/*
	 * @Param goodsReceiptNoteHeader
	 * 
	 * In this method the entity is converted to DTO. This is helpful for it's reusability. In this method Purchase and VendorMaster entities are used.
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 */
	public GoodsReceiptNoteHeaderDTO prepareGoodsReceiptNoteHeaderDTO(GoodsRecieptNoteHeader goodsRecieptNoteHeader, String grnAccess) {
		GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO = new GoodsReceiptNoteHeaderDTO();
		
		goodsReceiptNoteHeaderDTO.setDcDate(goodsRecieptNoteHeader.getDcDate());
		goodsReceiptNoteHeaderDTO.setDcNo(goodsRecieptNoteHeader.getDcNo());
		goodsReceiptNoteHeaderDTO.setGrnId(goodsRecieptNoteHeader.getGrnId());
		goodsReceiptNoteHeaderDTO.setGrnNo(goodsRecieptNoteHeader.getGrnNo());
		goodsReceiptNoteHeaderDTO.setGrnType(goodsRecieptNoteHeader.getGrnType());
		goodsReceiptNoteHeaderDTO.setGrossWeight(goodsRecieptNoteHeader.getGrossWeight());
		goodsReceiptNoteHeaderDTO.setInvoiceDate(goodsRecieptNoteHeader.getInvoiceDate());
		goodsReceiptNoteHeaderDTO.setInvoiceNo(goodsRecieptNoteHeader.getInvoiceNo());
		goodsReceiptNoteHeaderDTO.setInwardDate(goodsRecieptNoteHeader.getInwardDate());
		goodsReceiptNoteHeaderDTO.setInwardType(goodsRecieptNoteHeader.getInwardType());
		goodsReceiptNoteHeaderDTO.setLrDate(goodsRecieptNoteHeader.getLrDate());
		goodsReceiptNoteHeaderDTO.setLrNo(goodsRecieptNoteHeader.getLrNo());
		goodsReceiptNoteHeaderDTO.setNetWeight(goodsRecieptNoteHeader.getNetWeight());
		goodsReceiptNoteHeaderDTO.setIsAuthorised(goodsRecieptNoteHeader.getIsAuthorised());
		goodsReceiptNoteHeaderDTO.setAuthorisedBy(goodsRecieptNoteHeader.getAuthorisedBy());
		goodsReceiptNoteHeaderDTO.setCreateDate(goodsRecieptNoteHeader.getCreatedDate());
		
		goodsReceiptNoteHeaderDTO.setGrnStatus(goodsRecieptNoteHeader.getGrnStatus());
		goodsReceiptNoteHeaderDTO.setQcAccept(String.valueOf(goodsRecieptNoteHeader.getQcAccept()));
		
		goodsReceiptNoteHeaderDTO.setNotes(goodsRecieptNoteHeader.getNotes());
		
		POforGRNDTO po = new POforGRNDTO();
		
		//For getting Purchase Order 
		if(goodsRecieptNoteHeader.getGrnType().equalsIgnoreCase("With PO")) {
			if(goodsRecieptNoteHeader.getPoId()!=null && !goodsRecieptNoteHeader.getPoId().equals("null")) {
				Optional<Purchase> purchaseO = poDao.findById(Integer.valueOf(goodsRecieptNoteHeader.getPoId()));
				if(purchaseO.isPresent()) {
					Purchase poEntity  = purchaseO.get();
					
					po.setId(poEntity.getId());
					po.setPoType(poEntity.getPoType());
					po.setPurchaseCode(poEntity.getPurchaseCode());
					po.setVendorId(poEntity.getVendorId());
					po.setVendorName(poEntity.getVendorName());
				}
			}
		}
		
		
		if(goodsRecieptNoteHeader.getGrnType().equalsIgnoreCase("Cash Purchase")) {
			if(goodsRecieptNoteHeader.getPoId()!=null && goodsRecieptNoteHeader.getPoId().equalsIgnoreCase("null")) {
//				Optional<ItemMaster> itemO = itemDao.findById(Integer.valueOf(goodsRecieptNoteHeader.getPoId()));
//				if(itemO.isPresent()) {
//					ItemMaster item  = itemO.get();
//					
//					po.setId(item.getId());
//					po.setPoType("");
//					po.setPurchaseCode("");
					
					VendorMaster vendor = new VendorMaster();
					//If vendor id is present in the goodsRecieptNoteHeader only then fetch the VendorMaster by vendor Id
					if(goodsRecieptNoteHeader.getVendorId()!=null && !goodsRecieptNoteHeader.getVendorId().equals("null")) {
						Optional<VendorMaster> vendorO = vendorDao.findById(Integer.valueOf(goodsRecieptNoteHeader.getVendorId()));
						if(vendorO.isPresent()) {
							vendor = vendorO.get();
						}
//					}
					po.setVendorId(vendor.getId());
					po.setVendorName(vendor.getVendorName());
				}
			}
		}
		
		VendorMaster vendor = new VendorMaster();
		//If vendor id is present in the goodsRecieptNoteHeader only then fetch the VendorMaster by vendor Id
		if(goodsRecieptNoteHeader.getVendorId()!=null && !goodsRecieptNoteHeader.getVendorId().equalsIgnoreCase("null") ) {
			Optional<VendorMaster> vendorO = vendorDao.findById(Integer.valueOf(goodsRecieptNoteHeader.getVendorId()));
			if(vendorO.isPresent()) {
				vendor = vendorO.get();
			}

			goodsReceiptNoteHeaderDTO.setVendorId(String.valueOf(vendor.getId()));
			goodsReceiptNoteHeaderDTO.setVendorName(vendor.getVendorName());
		}
		
		
		goodsReceiptNoteHeaderDTO.setPurchaseOrder(po);
		
		goodsReceiptNoteHeaderDTO.setQcRequired(goodsRecieptNoteHeader.getQcRequired());
		goodsReceiptNoteHeaderDTO.setReceivedOn(goodsRecieptNoteHeader.getReceivedOn());
		goodsReceiptNoteHeaderDTO.setSupplierTc(goodsRecieptNoteHeader.getSupplierTc());
		goodsReceiptNoteHeaderDTO.setTareWeight(goodsRecieptNoteHeader.getTareWeight());
		
		goodsReceiptNoteHeaderDTO.setTransporterName(goodsRecieptNoteHeader.getTransporterName());
		goodsReceiptNoteHeaderDTO.setRgWt(goodsRecieptNoteHeader.getRgWt());
		
		goodsReceiptNoteHeaderDTO.setVehicleNo(goodsRecieptNoteHeader.getVehicleNo());
		
//		List<GoodReceiptNoteItemDetailsDTO> grnDetails = grnDetailsService.getGoodReceiptNoteItemDetailsByGrnHeaderId(goodsRecieptNoteHeader.getGrnId());
		
		// fetching all the grns which is accepted
		List<GoodReceiptNoteItemDetailsDTO> grnDetails = new ArrayList<>();
		
		if(grnAccess.equalsIgnoreCase("none")) {
			grnDetails = grnDetailsService.getGoodReceiptNoteItemDetailsByGrnHeaderIdAndQcStatus(goodsRecieptNoteHeader.getGrnId(), 2);
		}else if(grnAccess.equalsIgnoreCase("qcAccept")) {
			grnDetails = 
					grnDetailsService.getGoodReceiptNoteItemDetailsByGrnHeaderIdAndQcStatusAccepted(goodsRecieptNoteHeader.getGrnId(), 2);
		}
		else {
			grnDetails = grnDetailsService.getGoodReceiptNoteItemDetailsByGrnHeaderIdAndQcStatus(goodsRecieptNoteHeader.getGrnId(), 0);
		}
		
		goodsReceiptNoteHeaderDTO.setGoodReceiptNoteItemDetails(grnDetails);
		
		goodsReceiptNoteHeaderDTO.setQcAccept(String.valueOf(goodsRecieptNoteHeader.getQcAccept()));
		
		return goodsReceiptNoteHeaderDTO;
	}
	

	

	/*
	 * @Param goodsReceiptNoteHeaderDTO
	 * 
	 * This method is used to convert a DTO to Entity
	 * 
	 * @Return GoodsReceiptNoteHeader
	 */
	public GoodsRecieptNoteHeader prepareGoodsReceiptNoteEntity(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		GoodsRecieptNoteHeader goodsReceiptNoteEntity = new GoodsRecieptNoteHeader();
		
		if(goodsReceiptNoteHeaderDTO.getGrnId()!=null) {
			
			Optional<GoodsRecieptNoteHeader> grnO = grnRepo.findById(goodsReceiptNoteHeaderDTO.getGrnId());
			
			if(grnO.isPresent()) {
				goodsReceiptNoteEntity = grnO.get();
			}
			
		}
		
		goodsReceiptNoteEntity.setDcDate(goodsReceiptNoteHeaderDTO.getDcDate());
		goodsReceiptNoteEntity.setDcNo(goodsReceiptNoteHeaderDTO.getDcNo());
		goodsReceiptNoteEntity.setGrnId(goodsReceiptNoteHeaderDTO.getGrnId());
//		goodsReceiptNoteEntity.setGrnNo(goodsReceiptNoteHeaderDTO.getGrnNo());
		goodsReceiptNoteEntity.setGrnType(goodsReceiptNoteHeaderDTO.getGrnType());
		
		if(goodsReceiptNoteHeaderDTO.getGrossWeight()!=null)
			goodsReceiptNoteEntity.setGrossWeight(goodsReceiptNoteHeaderDTO.getGrossWeight());
		else
			goodsReceiptNoteEntity.setGrossWeight(0.0);
		
		goodsReceiptNoteEntity.setInvoiceDate(goodsReceiptNoteHeaderDTO.getInvoiceDate());
		goodsReceiptNoteEntity.setInvoiceNo(goodsReceiptNoteHeaderDTO.getInvoiceNo());
		goodsReceiptNoteEntity.setInwardDate(goodsReceiptNoteHeaderDTO.getInwardDate());
		goodsReceiptNoteEntity.setInwardType(goodsReceiptNoteHeaderDTO.getInwardType());
		goodsReceiptNoteEntity.setLrDate(goodsReceiptNoteHeaderDTO.getLrDate());
		goodsReceiptNoteEntity.setLrNo(goodsReceiptNoteHeaderDTO.getLrNo());
		
		if(goodsReceiptNoteHeaderDTO.getNetWeight()!=null)
			goodsReceiptNoteEntity.setNetWeight(goodsReceiptNoteHeaderDTO.getNetWeight());
		else
			goodsReceiptNoteEntity.setNetWeight(0.0);
		
		goodsReceiptNoteEntity.setAuthorisedBy(goodsReceiptNoteHeaderDTO.getAuthorisedBy());
		goodsReceiptNoteEntity.setIsAuthorised(0);
		goodsReceiptNoteEntity.setQcAccept(0);
		goodsReceiptNoteEntity.setIsAccepted(0);
		goodsReceiptNoteEntity.setIsActive(1);
		goodsReceiptNoteEntity.setCreatedDate(new Date());
		goodsReceiptNoteEntity.setAuthoriseDate(new Date());
		
		goodsReceiptNoteEntity.setPoId(String.valueOf(goodsReceiptNoteHeaderDTO.getPurchaseOrder().getId()));
		
		goodsReceiptNoteEntity.setNotes(goodsReceiptNoteHeaderDTO.getNotes());
		
		goodsReceiptNoteEntity.setQcRequired(goodsReceiptNoteHeaderDTO.getQcRequired());
		goodsReceiptNoteEntity.setReceivedOn(goodsReceiptNoteHeaderDTO.getReceivedOn());
		goodsReceiptNoteEntity.setSupplierTc(goodsReceiptNoteHeaderDTO.getSupplierTc());
		
		if(goodsReceiptNoteHeaderDTO.getTareWeight()!=null)
			goodsReceiptNoteEntity.setTareWeight(goodsReceiptNoteHeaderDTO.getTareWeight());
		else
			goodsReceiptNoteEntity.setTareWeight(0.0);
		
		goodsReceiptNoteEntity.setVendorId(String.valueOf(goodsReceiptNoteHeaderDTO.getVendorId()));
		goodsReceiptNoteEntity.setPoType(goodsReceiptNoteHeaderDTO.getPurchaseOrder().getPoType());
		
		
		goodsReceiptNoteEntity.setTransporterName(goodsReceiptNoteHeaderDTO.getTransporterName());
		goodsReceiptNoteEntity.setRgWt(goodsReceiptNoteHeaderDTO.getRgWt());
		
		goodsReceiptNoteEntity.setVehicleNo(goodsReceiptNoteHeaderDTO.getVehicleNo());
		return goodsReceiptNoteEntity;
	}
	
}
