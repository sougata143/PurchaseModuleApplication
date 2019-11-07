package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.FinishedGoodsTransactionDTO;
import com.aspl.org.dto.GoodReceiptNoteItemDetailsDTO;
import com.aspl.org.dto.GoodsReceiptNoteHeaderDTO;
import com.aspl.org.dto.LandedPriceDTO;
import com.aspl.org.dto.RawMaterialTransactionDTO;
import com.aspl.org.dto.StoreDetailsDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.GoodReceiptNoteItemDetails;
import com.aspl.org.entity.GoodsRecieptNoteHeader;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.Purchase;
import com.aspl.org.entity.PurchaseDetails;
import com.aspl.org.entity.StoreDetails;
import com.aspl.org.repository.GoodReceiptNoteItemDetailsRepository;
import com.aspl.org.repository.GoodsReceiptNoteRepository;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.PurchaseDao;
import com.aspl.org.repository.PurchaseDetailsDao;
import com.aspl.org.repository.StoreDetailsDao;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.GoodReceiptNoteHeaderService;
import com.aspl.org.service.GoodReceiptNoteItemDetailsService;
import com.aspl.org.service.LandedPriceService;
import com.aspl.org.service.StoreDetailsService;
import com.aspl.org.utils.GRNEntityDTOConversionUtil;
import com.aspl.org.utils.GlobalDefine;

/*
 * Service class for back end logic implementation of Goods Receipt Note
 */
@Service
@Transactional
public class GoodsReceiptNumberHeaderServiceImpl implements GoodReceiptNoteHeaderService {

	@Autowired
	GoodsReceiptNoteRepository grnRepo;
	
	@Autowired
	PurchaseDao poDao;
	
	@Autowired
	PurchaseDetailsDao poDetailsDao;
	
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
	
	@Autowired
	GRNEntityDTOConversionUtil gRNEntityDTOConversionUtil;
	
	@Autowired
	LandedPriceService landedPriceService;
	
	
	
	/*
	 * Method for fetching all the GRNs
	 * 
	 * @Return List<GoodsReceiptNoteHeaderDTO>
	 */
	@Override
	public List<GoodsReceiptNoteHeaderDTO> getAllGoodsReceiptNote() {
	
		List<GoodsReceiptNoteHeaderDTO> goodsReceiptNoteHeaderDTOs = new ArrayList<>();
		try {
			List<GoodsRecieptNoteHeader> grn = grnRepo.findByIsActive(1);
			for(GoodsRecieptNoteHeader gr : grn) {
				GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
//				grDTO = prepareGoodsReceiptNoteHeaderDTO(gr);
				grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(gr, "none");
				goodsReceiptNoteHeaderDTOs.add(grDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTOs;
	}
	
	/*
	 * Method for fetching all the GRNs
	 * 
	 * @Return List<GoodsReceiptNoteHeaderDTO>
	 */
	@Override
	public List<GoodsReceiptNoteHeaderDTO> getAllNonQcGoodsReceiptNote() {
		
		List<GoodsReceiptNoteHeaderDTO> goodsReceiptNoteHeaderDTOs = new ArrayList<>();
		try {
			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcRequiredAndGrnStatusOrGrnStatusOrGrnStatus(0, 0, 1, 4);
			for(GoodsRecieptNoteHeader gr : grn) {
				GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
//				grDTO = prepareGoodsReceiptNoteHeaderDTO(gr);
				grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(gr, "none");
				goodsReceiptNoteHeaderDTOs.add(grDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTOs;
	}

	/*
	 * @Param grn
	 * 
	 * the param is actually the grnNo
	 * 
	 * This method is for getting GRN by grnNo
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 * 
	 */
	@Override
	public GoodsReceiptNoteHeaderDTO getGoodsReceiptNoteByGrnNo(String grn) {
		
		GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
		try {
			GoodsRecieptNoteHeader grnEntity = grnRepo.findByGrnNo(grn);
//			grDTO = prepareGoodsReceiptNoteHeaderDTO(grnEntity);
			grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(grnEntity, "none");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grDTO;
	}

	/*
	 * @Param grnId
	 *
	 *This method is for getting GRNs by grnId
	 *
	 * @Return GoodsReceiptNoteHeaderDTO
	 * 
	 */
	@Override
	public GoodsReceiptNoteHeaderDTO getGoodsReceiptNoteById(Integer grnId) {
		
		GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
		try {
			GoodsRecieptNoteHeader grnEntity = grnRepo.findById(grnId).get();
//			grDTO = prepareGoodsReceiptNoteHeaderDTO(grnEntity);
			grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(grnEntity, "none");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grDTO;
	}

	/*
	 * @Param isActive
	 * 
	 * This method is for getting all the active GRNs
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 */
	@Override
	public List<GoodsReceiptNoteHeaderDTO> getGoodsReceiptNoteByIsActive(Integer isActive) {
		
		List<GoodsReceiptNoteHeaderDTO> goodsReceiptNoteHeaderDTOs = new ArrayList<>();
		try {
			List<GoodsRecieptNoteHeader> grn = grnRepo.findByIsActive(isActive);
			for(GoodsRecieptNoteHeader gr : grn) {
				GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
//				grDTO = prepareGoodsReceiptNoteHeaderDTO(gr);
				grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(gr, "none");
				goodsReceiptNoteHeaderDTOs.add(grDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTOs;
	}

	/*
	 * @Param isAccepted
	 * 
	 * This method is for getting accepted GRNs
	 * 
	 * @Return List<GoodsReceiptNoteHeaderDTO>
	 */
	@Override
	public List<GoodsReceiptNoteHeaderDTO> getGoodReceiptNumberByIsAccepted(Integer isAccepted) {
		
		List<GoodsReceiptNoteHeaderDTO> goodsReceiptNoteHeaderDTOs = new ArrayList<>();
		try {
			List<GoodsRecieptNoteHeader> grn = grnRepo.findByIsAccepted(isAccepted);
			for(GoodsRecieptNoteHeader gr : grn) {
				GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
//				grDTO = prepareGoodsReceiptNoteHeaderDTO(gr);
				grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(gr, "none");
				goodsReceiptNoteHeaderDTOs.add(grDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTOs;
	}

	/*
	 * @Param qcRequired
	 * 
	 * This method is for getting all the qc required GRNs
	 * 
	 * @Return List<GoodsReceiptNoteHeaderDTO>
	 */
	@Override
	public List<GoodsReceiptNoteHeaderDTO> getGoodsReceiptNumberByQcRequired(Integer qcRequired) {
		
		List<GoodsReceiptNoteHeaderDTO> goodsReceiptNoteHeaderDTOs = new ArrayList<>();
		try {
//			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcAcceptOrQcAccept(0,1);
			
//			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcRequired(1);
			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcRequiredAndGrnStatusOrGrnStatusOrGrnStatus(1, 0, 1, 4);
			
			for(GoodsRecieptNoteHeader gr : grn) {
				GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
				
//				grDTO = prepareGoodsReceiptNoteHeaderRequiredQcDTO(gr);
				grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(gr, "qcRequired");
				
//				if(gr.getQcAccept().equals(0)) {
//					grDTO = prepareGoodsReceiptNoteHeaderRequiredQcDTO(gr);
//				}
//				
//				if(gr.getQcAccept().equals(1)) {
//					grDTO = prepareGoodsReceiptNoteHeaderRequiredQcDTO(gr);
//				}
				
				if(grDTO.getGrnId()!=null)
					goodsReceiptNoteHeaderDTOs.add(grDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return goodsReceiptNoteHeaderDTOs;
	}

	/*
	 * @Param goodsReceiptNoteHeaderDTO
	 * 
	 * Method for saving GRNs
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 */
	@Override
	public GoodsReceiptNoteHeaderDTO saveGoodsReceiptNoteHeader(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		
		try {
			
			List<GoodReceiptNoteItemDetailsDTO> grndDetailsDTO = goodsReceiptNoteHeaderDTO.getGoodReceiptNoteItemDetails();
			List<GoodReceiptNoteItemDetailsDTO> grndDetailsDTOEmp = new ArrayList<>();
			for(GoodReceiptNoteItemDetailsDTO dto : grndDetailsDTO) {
				grndDetailsDTOEmp.add(dto);
			}
			GoodsRecieptNoteHeader grnHeader = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteEntity(goodsReceiptNoteHeaderDTO);
			
			// generating GRN number start
			/*String grnNo = "";
			Long grnCount = grnRepo.count();
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); // getting the current year's last two digits

			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			grnNo = "GRP/"+(grnCount+1)+"/"+currYear+"-"+nextYear; 
			// generating GRN number end
			*/

//			grnHeader.setGrnNo(grnNo);
			grnHeader.setGrnNo(goodsReceiptNoteHeaderDTO.getGrnNo());
			
			grnHeader.setGrnStatus(GlobalDefine.grnPending);
			
			GoodsRecieptNoteHeader grnHeaderEntity = grnRepo.save(grnHeader);
			
			for(GoodReceiptNoteItemDetailsDTO grnDetails : grndDetailsDTOEmp) {
				GoodReceiptNoteItemDetailsDTO grnItem = grnDetails;
				grnItem.setGrnHeaderId(String.valueOf(grnHeaderEntity.getGrnId()));
				
				GoodReceiptNoteItemDetails grnDetailsEntity = grnDetailsService.saveGoodReceiptNoteItemDetailsDTO(grnDetails);
				
				LandedPriceDTO landedPrice = landedPriceService.getLandedPriceForItem(grnDetails.getItem().getItemId()).get(0);
				landedPrice.setGrnId(grnHeaderEntity.getGrnId());
				landedPrice.setGrnDetailsId(grnDetailsEntity.getGrnDetailsId());
				
				landedPriceService.landedPriceSave(landedPrice);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTO;
	}

	/*
	 * @Param goodsReceiptNoteHeaderDTO
	 * 
	 * This method is for updating GRNs
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 */
	@Override
	public GoodsReceiptNoteHeaderDTO updateGoodsReceiptNoteHeader(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		
		try {
			if(goodsReceiptNoteHeaderDTO.getGrnId()!=0) {
				GoodsRecieptNoteHeader grnHeader = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteEntity(goodsReceiptNoteHeaderDTO);
				grnHeader.setIsAccepted(0);
				grnHeader.setIsActive(1);
				grnHeader.setIsAuthorised(goodsReceiptNoteHeaderDTO.getIsAuthorised());
//				grnHeader.setQcAccept(Integer.valueOf(goodsReceiptNoteHeaderDTO.getQcAccept()));
				grnHeader.setQcRequired(goodsReceiptNoteHeaderDTO.getQcRequired());
				grnHeader.setVendorId(String.valueOf(goodsReceiptNoteHeaderDTO.getVendorId()));
				
				grnRepo.save(grnHeader);
				
				for(GoodReceiptNoteItemDetailsDTO grnDetails : goodsReceiptNoteHeaderDTO.getGoodReceiptNoteItemDetails()) {
					if(grnDetails.getGrnDetailsId()!=0) {
						grnDetailsService.updateGoodReceiptNoteItemDetailsDTO(grnDetails);
					}else {
						grnDetailsService.saveGoodReceiptNoteItemDetailsDTO(grnDetails);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTO;
	}

	@Override
	public void deleteGoodsReceiptNoteHeaderDTO(Integer grnId) {
		// TODO Auto-generated method stub
		
	}

	

	/*
	 * @Param grnHeadrId 
	 * @Param authorisedBy
	 * 
	 * This method is for authorising the GRN. After the authorization the received quantity will be inserted to the store details table as the quantity.
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 */
	@Override
	public GoodsReceiptNoteHeaderDTO authoriseGoodsReceiptNoteHeader(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		
		try {
			if(goodsReceiptNoteHeaderDTO.getGrnId()!=0) {
				Optional<GoodsRecieptNoteHeader> grnHeaderO = grnRepo.findById(goodsReceiptNoteHeaderDTO.getGrnId());
				if(grnHeaderO.isPresent()) {
					GoodsRecieptNoteHeader grnHeader = grnHeaderO.get();
					
					List<GoodReceiptNoteItemDetails> grnDetails = grnDetalsRepo.findByGrnHeaderIdAndDetailsQcStatus(goodsReceiptNoteHeaderDTO.getGrnId(), 0);
					
					List<GoodReceiptNoteItemDetailsDTO> grnDetailsListEntity = goodsReceiptNoteHeaderDTO.getGoodReceiptNoteItemDetails();
					List<GoodReceiptNoteItemDetailsDTO> grnDetailsList = new ArrayList<>();
					for(GoodReceiptNoteItemDetailsDTO details : grnDetailsListEntity) {
						grnDetailsList.add(details);
					}
					
					Integer entitySize = grnDetails.size();
					Integer dtoSize = grnDetailsList.size();
					
					/*
					 * If entitySize which is the count of the items present in the table is equals to the DTO size which is the count of the items present in the DTO
					 * sent from the UI then that implies that user is accepting all the grn items. So we are authorizing all the items sent in the DTO.
					 */
					if(entitySize == dtoSize) {
						grnHeader.setIsAuthorised(1); 
						grnHeader.setAuthorisedBy(goodsReceiptNoteHeaderDTO.getAuthorisedBy());
						grnHeader.setQcAccept(GlobalDefine.grnAccept);
						grnHeader.setGrnStatus(GlobalDefine.grnAccept);
						
						grnRepo.save(grnHeader);
					}
					
					/*
					 * If entitySize which is the count of the items present in the table is less than the DTO size which is the count of the items present in the DTO
					 * sent from the UI then that implies that user is not accepting all the grn items. So we are authorizing only the items sent in the DTO.
					 */
					if(entitySize > dtoSize ) {
						grnHeader.setIsAuthorised(1); 
						grnHeader.setAuthorisedBy(goodsReceiptNoteHeaderDTO.getAuthorisedBy());
						grnHeader.setQcAccept(GlobalDefine.grnPartlyAccept);
						grnHeader.setGrnStatus(GlobalDefine.grnPartlyAccept);
						
						grnRepo.save(grnHeader);
					}
					
					for(GoodReceiptNoteItemDetailsDTO detailsDTO : grnDetailsList) {
						saveGoodReceiptNote(detailsDTO);
					}
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTO;
	}

	/*
	 * @Param grnHeaderId 
	 * @Param qcAccept
	 * 
	 * This method is for accept or reject the GRN by QC
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 */
	@Override
	public GoodsReceiptNoteHeaderDTO qcAcceptOrRejectGoodsReceiptNoteHeader(GoodsReceiptNoteHeaderDTO goodsReceiptNoteHeaderDTO) {
		
		GoodsReceiptNoteHeaderDTO grnDTO = new GoodsReceiptNoteHeaderDTO(); 
		try {
			if(goodsReceiptNoteHeaderDTO.getGrnId()!=0) {
				
				Optional<GoodsRecieptNoteHeader> grnHeaderO = grnRepo.findById(goodsReceiptNoteHeaderDTO.getGrnId());
				if(grnHeaderO.isPresent()) {
					GoodsRecieptNoteHeader grnHeader = grnHeaderO.get();
					
					List<GoodReceiptNoteItemDetails> detailsList = 
							grnDetalsRepo.findByGrnHeaderIdAndDetailsStatus(goodsReceiptNoteHeaderDTO.getGrnId(), 0);
					
					Integer entitySize = detailsList.size();
					
					/*
					 * If entitySize which is the count of the items present in the table is equals to the DTO size which is the count of the items present in the DTO
					 * sent from the UI then that implies that user is accepting all the grn items. So we are authorizing all the items sent in the DTO.
					 */
					if(entitySize == 1) {
						if(goodsReceiptNoteHeaderDTO.getQcAccept().equals("1")) {
							
							grnHeader.setGrnStatus(GlobalDefine.grnAccept);
							
							for(GoodReceiptNoteItemDetailsDTO grnDetails : goodsReceiptNoteHeaderDTO.getGoodReceiptNoteItemDetails()) {
								saveGoodReceiptNote(grnDetails);
							}
							
						}
						
						if(goodsReceiptNoteHeaderDTO.getQcAccept().equals("0")) {
							
							grnHeader.setGrnStatus(GlobalDefine.grnReject);
							
							for(GoodReceiptNoteItemDetailsDTO grnDetails : goodsReceiptNoteHeaderDTO.getGoodReceiptNoteItemDetails()) {
								GoodReceiptNoteItemDetails grnDetailsEntity = new GoodReceiptNoteItemDetails();
								Optional<GoodReceiptNoteItemDetails> grnDetailsO = grnDetalsRepo.findById(grnDetails.getGrnDetailsId());
								if(grnDetailsO.isPresent()) {
									grnDetailsEntity = grnDetailsO.get();
								}
//								GoodReceiptNoteItemDetails detailsEntity = grnDetailsService.prepareGoodReceiptNoteItemDetails(grnDetailsEntity);
								
								grnDetailsEntity.setDetailsQcStatus(GlobalDefine.grnAccept);
								
								grnDetalsRepo.save(grnDetailsEntity);
							}
						}
					}
					
					/*
					 * If entitySize which is the count of the items present in the table is less than the DTO size which is the count of the items present in the DTO
					 * sent from the UI then that implies that user is not accepting all the grn items. So we are authorizing only the items sent in the DTO.
					 */
					if(entitySize > 1) {
						if(goodsReceiptNoteHeaderDTO.getQcAccept().equals("1")) {
							
							grnHeader.setGrnStatus(GlobalDefine.grnPartlyAccept);
							
							for(GoodReceiptNoteItemDetailsDTO grnDetails : goodsReceiptNoteHeaderDTO.getGoodReceiptNoteItemDetails()) {
								saveGoodReceiptNote(grnDetails);
							}
							
						}
						
						if(goodsReceiptNoteHeaderDTO.getQcAccept().equals("0")) {
							
							grnHeader.setGrnStatus(GlobalDefine.grnPartlyRejected);
							
							for(GoodReceiptNoteItemDetailsDTO grnDetails : goodsReceiptNoteHeaderDTO.getGoodReceiptNoteItemDetails()) {
								GoodReceiptNoteItemDetails grnDetailsEntity = new GoodReceiptNoteItemDetails();
								Optional<GoodReceiptNoteItemDetails> grnDetailsO = grnDetalsRepo.findById(grnDetails.getGrnDetailsId());
								if(grnDetailsO.isPresent()) {
									grnDetailsEntity = grnDetailsO.get();
								}
//								GoodReceiptNoteItemDetails detailsEntity = grnDetailsService.prepareGoodReceiptNoteItemDetails(grnDetailsEntity);
								
								grnDetailsEntity.setDetailsQcStatus(GlobalDefine.grnAccept);
								grnDetailsEntity.setReason(grnDetails.getReason());
								grnDetailsEntity.setReceivedQnt(grnDetails.getReceivedQnt());
								grnDetailsEntity.setRejectedQnt(grnDetails.getRejectedQnt());
								grnDetailsEntity.setAcceptedQnt(grnDetails.getAcceptedQnt());
								
								grnDetalsRepo.save(grnDetailsEntity);
							}
						}
					}
					
					grnRepo.save(grnHeader);
					grnDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(grnHeader, "none");
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDTO;
	}

	/*
	 * Method for getting QC accepted GRNs 
	 * 
	 * @Return List<GoodsReceiptNoteHeaderDTO>
	 */
	@Override
	public List<GoodsReceiptNoteHeaderDTO> getGoodsReceiptNumberByQcAccepted() {
		
		List<GoodsReceiptNoteHeaderDTO> goodsReceiptNoteHeaderDTOs = new ArrayList<>();
		try {
//			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcAccept(2);
//			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcAcceptOrQcAccept(1, 2);
			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcAcceptOrQcAcceptOrQcAccept(1, 2, 6);
			for(GoodsRecieptNoteHeader gr : grn) {
				GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
//				grDTO = prepareAuthorizedGoodsReceiptNoteHeaderQcAcceptDTO(gr);
				grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(gr, "acAccept");
				goodsReceiptNoteHeaderDTOs.add(grDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTOs;
	}
	
	/*
	 * Getting QC rejected GRNs
	 * 
	 * @Return List<GoodsReceiptNoteHeaderDTO>
	 */
	@Override
	public List<GoodsReceiptNoteHeaderDTO> getGoodsReceiptNumberByQcRejected() {
		
		List<GoodsReceiptNoteHeaderDTO> goodsReceiptNoteHeaderDTOs = new ArrayList<>();
		try {
			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcAccept(2);
			for(GoodsRecieptNoteHeader gr : grn) {
				GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
				grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(gr, "none");
				goodsReceiptNoteHeaderDTOs.add(grDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTOs;
	}

	/*
	 * @Param grnId
	 * 
	 * Method for soft delete GRN 
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 */
	@Override
	public GoodsReceiptNoteHeaderDTO softDeleteGoodsReceiptNoteHeader(Integer grnId) {
		
		GoodsReceiptNoteHeaderDTO grnDTO = new GoodsReceiptNoteHeaderDTO();
		try {
			Optional<GoodsRecieptNoteHeader> grnHeaderO = grnRepo.findById(grnId);
			if(grnHeaderO.isPresent()) {
				GoodsRecieptNoteHeader grnHeader = grnHeaderO.get();
				grnHeader.setIsActive(0);
				
				grnRepo.save(grnHeader);
				grnDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(grnHeader, "none");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDTO;
	}

	/*
	 * @Param grnID
	 * 
	 * Method for Permanent delete GRN
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 */
	@Override
	public GoodsReceiptNoteHeaderDTO permDeleteGoodsReceiptNoteHeaderDTO(Integer grnId) {
		
		GoodsReceiptNoteHeaderDTO grnDTO = new GoodsReceiptNoteHeaderDTO();
		try {
			Optional<GoodsRecieptNoteHeader> grnHeaderO = grnRepo.findById(grnId);
			if(grnHeaderO.isPresent()) {
				GoodsRecieptNoteHeader grnHeader = grnHeaderO.get();
				grnRepo.delete(grnHeader);
				grnDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(grnHeader, "none");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnDTO;
	}

	@Override
	public List<GoodsReceiptNoteHeaderDTO> getAuthorisedGoodsReceiptNumber() {
		
		List<GoodsReceiptNoteHeaderDTO> goodsReceiptNoteHeaderDTOs = new ArrayList<>();
		try {
			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcAccept(GlobalDefine.grnAccept);
			for(GoodsRecieptNoteHeader gr : grn) {
				GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
				grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(gr, "none");
				goodsReceiptNoteHeaderDTOs.add(grDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTOs;
	}
	
	/*
	 * @Param grn
	 * 
	 * the param is actually the grnNo
	 * 
	 * This method is for getting GRN by grnNo
	 * 
	 * @Return GoodsReceiptNoteHeaderDTO
	 * 
	 */
	@Override
	public GoodsReceiptNoteHeaderDTO getGoodsReceiptNoteByGrnId(Integer grnId) {
		
		GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
		try {
			GoodsRecieptNoteHeader grnEntity = grnRepo.findById(grnId).get();
			grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(grnEntity, "none");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grDTO;
	}

	@Override
	public List<GoodsReceiptNoteHeaderDTO> getUnAuthorisedGoodsReceiptNumber() {
		
		List<GoodsReceiptNoteHeaderDTO> goodsReceiptNoteHeaderDTOs = new ArrayList<>();
		try {
//			List<GoodsRecieptNoteHeader> grn = grnRepo.findByQcAccept(GlobalDefine.grnPending);
			List<GoodsRecieptNoteHeader> grn = grnRepo.findByGrnStatusOrGrnStatusOrGrnStatus(0, 1, 4);
			for(GoodsRecieptNoteHeader gr : grn) {
				GoodsReceiptNoteHeaderDTO grDTO = new GoodsReceiptNoteHeaderDTO();
				grDTO = gRNEntityDTOConversionUtil.prepareGoodsReceiptNoteHeaderDTO(gr, "none");
				goodsReceiptNoteHeaderDTOs.add(grDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goodsReceiptNoteHeaderDTOs;
	}
	
	
	/*
	 * @Param detailsDTO
	 * 
	 * saving grn details
	 * 
	 * @Return GoodReceiptNoteItemDetails
	 */
	@Override
	public GoodReceiptNoteItemDetails saveGoodReceiptNote(GoodReceiptNoteItemDetailsDTO detailsDTO) {

//		GoodReceiptNoteItemDetails details = grnDetailsService.prepareGoodReceiptNoteItemDetails(detailsDTO);

		GoodReceiptNoteItemDetails details = grnDetalsRepo.findById(detailsDTO.getGrnDetailsId()).get();
		
		if(details.getReceivedQnt().equals(detailsDTO.getAcceptedQnt())) {
			details.setDetailsStatus(GlobalDefine.grnAccept);
			details.setDetailsQcStatus(GlobalDefine.grnAccept);
//			details.setAcceptedQnt(acceptedQnt);
//			details.setReceivedQnt(receivedQnt);
//			details.setRejectedQnt(rejectedQnt);
		}else {
			details.setDetailsStatus(GlobalDefine.grnPartlyAccept);
			details.setDetailsQcStatus(GlobalDefine.grnPartlyAccept);
		}
		
		GoodReceiptNoteItemDetails grnDetailsEntity = grnDetalsRepo.save(details);
		
		StoreDetailsDTO storeDetailsDTO = new StoreDetailsDTO();
		
		if(detailsDTO.getItem()!=null) {
			Optional<ItemMaster> itemO = itemDao.findById(detailsDTO.getItem().getItemId());
			ItemMaster item = new ItemMaster();
			if(itemO.isPresent()) {
				item = itemO.get();
			}
			
			storeDetailsDTO.setBarCode(item.getBarCode());
			
			CategoryMappingDTO cat = new CategoryMappingDTO();
			Category cate = item.getCategoryId();
			if(cate!=null) {
				cat.setCategoryId(cat.getCategoryId());
				cat.setCategoryName(cate.getCategoryName());
			}
			
			storeDetailsDTO.setCategory(cat);
			storeDetailsDTO.setDepartment(detailsDTO.getDepartment());
			storeDetailsDTO.setHsCode(item.getHsCode());
			storeDetailsDTO.setItem(detailsDTO.getItem());
			
			if(detailsDTO.getUomDTO()!=null)
				storeDetailsDTO.setUnit(detailsDTO.getUomDTO().getUomCode());
			
			storeDetailsDTO.setWtPerUnit(detailsDTO.getWtPerUnit());
			storeDetailsDTO.setExpiryDate(detailsDTO.getExpiryDate());
			
			if(item.getMinimum()!=null)
				storeDetailsDTO.setMinimum(Double.valueOf(item.getMinimum()));
			
			storeDetailsDTO.setReorder(Double.valueOf(item.getReorder()));
//			storeDetailsDTO.setSapCode(item.getSapCode());
			
			List<StoreDetails> storeDetails = storeDao.findByItemId(item.getId());
			Double quantity = 0.0;
			if(!storeDetails.isEmpty()) {
				for(StoreDetails sd : storeDetails) {
					quantity = quantity + sd.getQuantity();
				}
			}
			
			storeDetailsDTO.setQuantity(quantity+detailsDTO.getAcceptedQnt());
			
			FinishedGoodsTransactionDTO fgtDTO = new FinishedGoodsTransactionDTO();
			RawMaterialTransactionDTO rmtDTO = new RawMaterialTransactionDTO();									
			
			Double closingStockRmt = 0.0;
			Double closingStockFgt = 0.0;
			Double openingStockRmt = 0.0;
			Double openingStockFgt = 0.0;
			
			if(storeDetails.isEmpty()) {
				closingStockRmt = closingStockRmt + quantity;
				closingStockFgt = closingStockFgt + quantity;
				openingStockRmt = quantity;
				openingStockFgt = quantity;
			}
			
			List<FinishedGoodsTransactionDTO> fgts = finishedGoodsTransService.getAllFinishedGoodsTransactionByItemId(item.getId());
			List<RawMaterialTransactionDTO> rmts = rawMaterialTransService.getAllRawMaterialTransactionByItemId(item.getId());
			
			
			Integer rmtsSize = rmts.size();
			Integer fgtSize = fgts.size();
			
			if(rmtsSize>0)
				openingStockRmt = rmts.get(rmtsSize-1).getClosingStock();
			
			if(fgtSize>0)
				openingStockFgt = fgts.get(fgtSize-1).getClosingStock();
			
			if(!storeDetails.isEmpty()) {
				openingStockRmt = openingStockRmt;
				closingStockRmt = openingStockRmt + quantity;
				
				openingStockFgt = openingStockFgt;
				closingStockFgt = openingStockFgt + quantity;
			}
			
			fgtDTO.setCategory(String.valueOf(item.getCategoryId2()));
			fgtDTO.setClosingStock(closingStockFgt);
			fgtDTO.setCreatedDate(new Date());
			fgtDTO.setCredit(quantity);
			fgtDTO.setDebit(0.0);
			fgtDTO.setItemId(item.getId());
			fgtDTO.setOpeningStock(openingStockFgt);
			
			PurchaseDetails poDetails = new PurchaseDetails();
			Purchase po = new Purchase();
			if(grnDetailsEntity.getPoDetailsId()!=null) {
				Optional<PurchaseDetails> poDetailsO = poDetailsDao.findById(grnDetailsEntity.getPoDetailsId());
				if(poDetailsO.isPresent()) {
					poDetails = poDetailsO.get();
					
					po = poDao.findById(poDetails.getPoid()).get();
				}
			}
			
			rmtDTO.setCategory(String.valueOf(item.getCategoryId2()));
			rmtDTO.setClosingStock(closingStockRmt);
			rmtDTO.setCreatedDate(new Date());
			rmtDTO.setCredit(quantity);
			rmtDTO.setDebit(0.0);
			rmtDTO.setItemId(item.getId());
			rmtDTO.setOpeningStock(openingStockRmt);
			
			
			if((quantity+detailsDTO.getAcceptedQnt()) < item.getMaximum()) {
				
				StoreDetails storeEntity = storeDetailsService.saveStoreDetails(storeDetailsDTO);
				
//				if(item.getCategory().equalsIgnoreCase("Raw Material")) {
//					rmtDTO.setStoreId(storeEntity.getId());
					rmtDTO.setGrnId(grnDetailsEntity.getGrnHeaderId());
					rmtDTO.setPoId(po.getId());	
					
					rawMaterialTransService.saveRawMaterialTransaction(rmtDTO);
//				}
				
				if(item.getCategory().equalsIgnoreCase("Finished Good")) {
					fgtDTO.setStoreId(storeEntity.getId());
					
					finishedGoodsTransService.saveFinishedGoodsTransaction(fgtDTO);
				}
				
				
			}else {
				
			}
			
		}
		
		return grnDetailsEntity;
	
	}

	


}
