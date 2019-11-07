package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.DepartmentForGRNDTO;
import com.aspl.org.dto.IndentDTO;
import com.aspl.org.dto.IndentDetailsDTO;
import com.aspl.org.dto.ItemMasterDTO;
import com.aspl.org.dto.StoreDetailsDTO;
import com.aspl.org.entity.DepartmentMaster;
import com.aspl.org.entity.Indent;
import com.aspl.org.entity.IndentDetails;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.repository.DepartmentMasterRepo;
import com.aspl.org.repository.IndentDao;
import com.aspl.org.repository.IndentDetailsDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.UomMasterRepo;
import com.aspl.org.service.IndentService;
import com.aspl.org.service.ItemMasterService;
import com.aspl.org.utils.GlobalDefine;

/*
 * Service for Indent 
 */
@Service
@Transactional
public class IndentServiceImpl implements IndentService {

	@Autowired
	IndentDao indentDao;
	

	@Autowired
	IndentDetailsDao indentDetailsDao;
	
	@Autowired
	StoreDetailsServiceImpl storeDetailsServiceImpl;
	
	@Autowired
	DepartmentMasterRepo departmentDao;
	
	@Autowired
	UomMasterRepo uomRepo;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	ItemMasterService itemService;

	
	/*
	 * @Param indentDTO
	 * 
	 * This method is used to save indent. From UI side this method takes all the indent details as IndentDTO object and then it checks if the item is present in the 
	 * stock or not. If it's not present in the store details table then it inserts into Indent and Indent Details table. If the item is present in the table then 
	 * it checks whether the indent quantity is less than the minimum quantity of store table or not. If it's true then it inserts into Indent and Indent Details table.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails indentSave(IndentDTO indentDTO) throws Exception {
		
//		("indent: "+indentDTO.toString());
		
		
		
		try {
			Double min = 0.0;
			Double quantity = 0.0;
			Indent indent = new Indent();
			List<StoreDetailsDTO> storeDetailsStock = new ArrayList<StoreDetailsDTO>();
			
			List<IndentDetailsDTO> indentDetailsDTOs = new ArrayList<>();
			for(IndentDetailsDTO dto : indentDTO.getIndentDetails()) {
				indentDetailsDTOs.add(dto);
			}
			
			for (IndentDetailsDTO indentDetails:  indentDTO.getIndentDetails()) {
				IndentDetails toGetItemCode = prepareIndentDetailsEntity(indentDetails);
				
				storeDetailsStock = storeDetailsServiceImpl.findStoreDetailsByItemCode(toGetItemCode.getItemCode());
				
				//getting minimum value for that item and the stock of that item
				for(StoreDetailsDTO storeDTO : storeDetailsStock) {
					quantity = quantity + storeDTO.getQuantity();
					min = storeDTO.getMinimum();
				}
				
			}
			Indent indentEntity = prepareIndentEntity(indentDTO);

			//checking for if the item's stock is less than minimum value
			if(quantity < min || storeDetailsStock.isEmpty()) {
				
				//Generating indentCode start
				/*String indentCode = "";
				Long indentCount = indentDao.count(); //getting total number of indents currently present in the indent table
				
				DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
				String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//				(formattedDate);
				Integer currYear = Integer.valueOf(formattedDate);
				Integer nextYear = currYear+1;
				indentCode = "PID/"+(indentCount+1)+"/"+currYear+"-"+nextYear;
				//Generating indentCode end
				
				indentEntity.setIndentCode(indentCode);*/
				
				if(indentDTO.getId()==null) {
					indentEntity.setIndentCode(indentDTO.getIndentCode());
					indentEntity.setStatus(GlobalDefine.indentPending);
				}
				
				indent = indentDao.save(indentEntity); // saving the indent header 
			}
			
			for (IndentDetailsDTO indentDetails:  indentDetailsDTOs) {
				IndentDetails toGetItemCode = prepareIndentDetailsEntity(indentDetails);
				
				List<StoreDetailsDTO> storeDetails = storeDetailsServiceImpl.findStoreDetailsByItemCode(toGetItemCode.getItemCode());
				
				for(StoreDetailsDTO storeDTO : storeDetails) {
					quantity = quantity + storeDTO.getQuantity();
					min = storeDTO.getMinimum();
				}
				
//				("storeDetails: "+storeDetails.getQuantity());
//				("getMinimum: "+storeDetails.getMinimum());
				
				//checking for if the item's stock is less than minimum value
				if (quantity < min|| storeDetailsStock.isEmpty()) {
					
//					("indent: "+indent.getId());
					
//					toGetItemCode.setIndentId(indentDTO.getId());
					toGetItemCode.setAvailableQty(quantity);
					toGetItemCode.setIndentId(indent.getId());
					toGetItemCode.setIndent(indent);
					
					toGetItemCode.setIndentItemStatus(GlobalDefine.indentPending);
						
					indentDetailsDao.save(toGetItemCode);
						
						
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ResponseDetails rd = new ResponseDetails(new Date(), "We have created your indent successfully", null, 200); 
		return rd;
  
       }

	
	/*
	 *@Param indentCode
	 *
	 *This method is used for finding the indent by indentCode. User gives indentCode and then it finds indent by indentCode field.
	 *
	 * @Return IndentDTO
	 */
	@Override
	public IndentDTO findByIndentCode(String indentCode) {
		
		Indent indents = new Indent();
		if(!indentDao.findByIndentCode(indentCode).isEmpty()) {
			indents = indentDao.findByIndentCode(indentCode).get(0);
		}
		IndentDTO indentDTO = prepareIndentDTO(indents);
		
		return indentDTO;
	}

	/*
	 * 
	 * This method is used for fetching all the indents.
	 * 
	 * @Return List<IndentDTO>
	 */
	@Override
	public List<IndentDTO> getAllIndent() {
		List<IndentDTO> indentDTOs = new ArrayList<>();
		try {
//			List<Indent> indents = indentDao.findAll();
			List<Indent> indents = indentDao.findByIsActive(1);
			for(Indent ind : indents) {
				IndentDTO indentDTO = prepareIndentDTO(ind);
				indentDTOs.add(indentDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return indentDTOs;
	}

	/*
	 * @Param indentDTO
	 * 
	 * This method is used for authorizing and indent. This method takes indent dto as param from where it'll use indentId for finding the indent, and authorised by
	 * for getting the authorized by value.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails indentAuthorised(IndentDTO indentDTO) {
		try {
			Indent indent = new Indent();
			Optional<Indent> indentO = indentDao.findById(indentDTO.getId());
			if(indentO.isPresent()) {
				indent = indentO.get();
				List<IndentDetails> indentDetailsList = indentDetailsDao.findByIndentIdAndIndentItemStatusOrIndentItemStatus(indent.getId(), 0, 1);
				
				Integer entitySize = indentDetailsList.size();
				Integer dtoSize = indentDTO.getIndentDetails().size();
				
				/*If the entitySize which is the indent details present in the table and the DTO size which is the items UI is sending in the DTO is equals then
				It implies that the user is authorizing all the indent items.*/
				if(entitySize==dtoSize) {
					indent.setAccepted(GlobalDefine.indentAccepted);
					indent.setAuthorise(String.valueOf(GlobalDefine.indentAccepted));
					indent.setAuthoriseDate(new Date());
					
					indent.setStatus(GlobalDefine.indentAccepted);
				}
				
				/*If the entitySize which is the indent details present in the table and the DTO size which is the items UI is sending in the DTO is equals then
				It implies that the user is not authorizing all the indent items. So which items are present in the DTO only those will be authorized.*/
				if(entitySize>dtoSize) {
					
					indent.setAccepted(GlobalDefine.indentPartlyAccepted);
					indent.setAuthorise(String.valueOf(GlobalDefine.indentPartlyAccepted));
					indent.setAuthoriseDate(new Date());
					indent.setStatus(GlobalDefine.indentPartlyAccepted);
					
				}
				
				indentDao.save(indent);
				
				for(IndentDetailsDTO id : indentDTO.getIndentDetails()) {
					
					IndentDetails indentDetails = new IndentDetails();
					if(id.getId()!=null) {
						Optional<IndentDetails> indentDetailsO = indentDetailsDao.findById(id.getId());
						if(indentDetailsO.isPresent()) {
							indentDetails = indentDetailsO.get();
						}
					}
					
					indentDetails.setIndentItemStatus(GlobalDefine.indentAccepted);
					
					indentDetailsDao.save(indentDetails);
					
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
//		indentDao.indentAuthorised(iId);
		return new ResponseDetails(new Date(), "Indent authorised.", null);
		//return indentDao.indentAuthorised(iId);
	}

	/*
	 * @Param indentDTO
	 * 
	 * This method is for unauthorizing an indent.
	 */
	@Override
	public ResponseDetails indentUnauthorised(IndentDTO indentDTO) {
		try {
			Indent indent = new Indent();
			Optional<Indent> indentO = indentDao.findById(indentDTO.getId());
			if(indentO.isPresent()) {
				indent = indentO.get();
				
				List<IndentDetails> indentDetailsList = indentDetailsDao.findByIndentId(indent.getId());
				
				Integer entitySize = indentDetailsList.size();
				Integer dtoSize = indentDTO.getIndentDetails().size();
				
				/*If the entitySize which is the indent details present in the table and the DTO size which is the items UI is sending in the DTO is equals then
				It implies that the user is unauthorizing all the indent items.*/
				if(entitySize==dtoSize) {
					indent.setAccepted(GlobalDefine.indentAccepted);
					indent.setAuthorise(String.valueOf(GlobalDefine.indentRejected));
					indent.setAuthoriseDate(new Date());
					
					indent.setStatus(GlobalDefine.indentAccepted);
				}
				
				/*If the entitySize which is the indent details present in the table and the DTO size which is the items UI is sending in the DTO is equals then
				It implies that the user is not unauthorizing all the indent items. So which items are present in the DTO only those will be unauthorized.*/
				if(entitySize>dtoSize) {
					indent.setAccepted(GlobalDefine.indentPartlyAccepted);
					indent.setAuthorise(String.valueOf(GlobalDefine.indentPartlyRejected));
					indent.setAuthoriseDate(new Date());
					
					indent.setStatus(GlobalDefine.indentPartlyAccepted);
				}
				
				indentDao.save(indent);
				
				for(IndentDetailsDTO id : indentDTO.getIndentDetails()) {
					IndentDetails indentDetails = prepareIndentDetailsEntity(id);
					
					indentDetails.setIndentItemStatus(GlobalDefine.indentRejected);
					
					indentDetailsDao.save(indentDetails);
					
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
//		indentDao.indentUnauthorised(iId);
		return new ResponseDetails(new Date(), "Indent auauthorised.", null);
		//return indentDao.indentAuthorised(iId);
	}
		
	/*
	 * This method is used for fetching the indents which is not authorized till now fully or partially. This is used for getting the list of indents for authorization.
	 * 
	 * @Return List<IndentDTO>
	 */
	@Override
	public List<IndentDTO> getAllUnauthorisedIndent() {
		
		List<IndentDTO> indentDTOs = new ArrayList<>();
		try {
			List<Indent> indent = indentDao.findByStatusOrStatusOrStatus(0, 1, 4); //fetching the indents which are pending or partially authorised or partially rejected
			for(Indent ind : indent) {
				IndentDTO indentDTO = new IndentDTO();
				indentDTO = prepareUnauthorizedIndentDTO(ind);
				indentDTOs.add(indentDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return indentDTOs;
	}

	
	/*
	 * This method is used for fetching the indents which is not authorized till now fully or partially. This is used for getting the list of indents which are authorized.
	 * 
	 * @Return List<IndentDTO>
	 */
	@Override
	public List<IndentDTO> getAllAuthorisedIndent() {
		
		List<IndentDTO> indentDTOs = new ArrayList<>();
		try {
			List<Indent> indents = indentDao.findByStatus(2);
			for(Indent ind : indents) {
				IndentDTO indentDTO = new IndentDTO();
				indentDTO = prepareIndentDTO(ind);
				indentDTOs.add(indentDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return indentDTOs;
	}

	/*
	 * @Param indent
	 * 
	 * This method is used for converting indent entity to indent dto. Advantage of this method is reusablity. We can reuse it for converting entity object to DTO multiple
	 * times. In this method all the required different classes objects are added to the DTO. For indent the required different classes objects are Indent, IndentDetails
	 * and DepartmentMaster.
	 * 
	 * @Return IndentDTO
	 */
	@Override
	public IndentDTO prepareIndentDTO(Indent indent) {
		
		IndentDTO indentDTO = new IndentDTO();
		
		indentDTO.setAccepted(indent.getAccepted());
		indentDTO.setAuthorise(indent.getAuthorise());
		indentDTO.setAuthoriseDate(indent.getAuthoriseDate());
		indentDTO.setAuthorisedBy(indent.getAuthorisedBy());
		
		DepartmentForGRNDTO deptDTO = new DepartmentForGRNDTO();

		//If the department field in indent table is present then fetch the department master table by primary key
		if(indent.getDepartment()!=0) {
			Optional<DepartmentMaster> deptO = departmentDao.findById(indent.getDepartment());
			if(deptO.isPresent()) {
				DepartmentMaster dept = deptO.get();
				deptDTO.setDepartmentdetails(dept.getDepartmentdetails());
				deptDTO.setDepartmentId(dept.getDepartmentId());
				deptDTO.setDepartmentname(dept.getDepartmentname());
			}
		}
		indentDTO.setDepartment(deptDTO);
		
		indentDTO.setId(indent.getId());
		indentDTO.setIndentCode(indent.getIndentCode());
		indentDTO.setIndentDate(indent.getIndentDate());
		indentDTO.setIsActive(indent.getIsActive());
		indentDTO.setNotes(indent.getNotes());
		indentDTO.setPreparedBy(indent.getPreparedBy());
		indentDTO.setPriority(indent.getPriority());
		indentDTO.setProjectCode(indent.getProjectCode());
		indentDTO.setRevalidate(indent.getRevalidate());
		indentDTO.setStatus(indent.getStatus());
		indentDTO.setValidateDate(indent.getValidateDate());
		
		//Find all the indent details finding by indent id
		List<IndentDetails> indentDetails = indentDetailsDao.findByIndentId(indent.getId());
		List<IndentDetailsDTO> indentDetailsDTOs = new ArrayList<>();
		for(IndentDetails id : indentDetails) {
			IndentDetailsDTO indentDetailsDTO = prepareIndentDetailsDTO(id);
			indentDetailsDTOs.add(indentDetailsDTO);
		}
		indentDTO.setIndentDetails(indentDetailsDTOs);
		
		return indentDTO;
	}
	
	/*
	 * @Param indent
	 * 
	 * This method is used for converting indent entity to indent dto. Advantage of this method is reusablity. We can reuse it for converting entity object to DTO multiple
	 * times. In this method all the required different classes objects are added to the DTO. For indent the required different classes objects are Indent, IndentDetails
	 * and DepartmentMaster.
	 * 
	 * @Return IndentDTO
	 */
	@Override
	public IndentDTO prepareUnauthorizedIndentDTO(Indent indent) {
		
		IndentDTO indentDTO = new IndentDTO();
		
		indentDTO.setAccepted(indent.getAccepted());
		indentDTO.setAuthorise(indent.getAuthorise());
		indentDTO.setAuthoriseDate(indent.getAuthoriseDate());
		indentDTO.setAuthorisedBy(indent.getAuthorisedBy());
		
		DepartmentForGRNDTO deptDTO = new DepartmentForGRNDTO();

		//If the department field in indent table is present then fetch the department master table by primary key
		if(indent.getDepartment()!=0) {
			Optional<DepartmentMaster> deptO = departmentDao.findById(indent.getDepartment());
			if(deptO.isPresent()) {
				DepartmentMaster dept = new DepartmentMaster();
				deptDTO.setDepartmentdetails(dept.getDepartmentdetails());
				deptDTO.setDepartmentId(dept.getDepartmentId());
				deptDTO.setDepartmentname(dept.getDepartmentname());
			}
		}
		indentDTO.setDepartment(deptDTO);
		
		indentDTO.setId(indent.getId());
		indentDTO.setIndentCode(indent.getIndentCode());
		indentDTO.setIndentDate(indent.getIndentDate());
		indentDTO.setIsActive(indent.getIsActive());
		indentDTO.setNotes(indent.getNotes());
		indentDTO.setPreparedBy(indent.getPreparedBy());
		indentDTO.setPriority(indent.getPriority());
		indentDTO.setProjectCode(indent.getProjectCode());
		indentDTO.setRevalidate(indent.getRevalidate());
		indentDTO.setStatus(indent.getStatus());
		indentDTO.setValidateDate(indent.getValidateDate());
		
		//Find all the indent details finding by indent id
		List<IndentDetails> indentDetails = indentDetailsDao.findByIndentIdAndIndentItemStatus(indent.getId(), 0);
		List<IndentDetailsDTO> indentDetailsDTOs = new ArrayList<>();
		for(IndentDetails id : indentDetails) {
			IndentDetailsDTO indentDetailsDTO = prepareIndentDetailsDTO(id);
			indentDetailsDTOs.add(indentDetailsDTO);
		}
		indentDTO.setIndentDetails(indentDetailsDTOs);
		
		return indentDTO;
	}

	/*
	 * @Param indentDTO
	 * 
	 * This method is used for converting indent DTO to indent Entity. Advantage of this method is reusablity. We can reuse it for converting entity object to DTO multiple
	 * times. In this method all the required different classes objects primary keys and other fields if required are added to the entity getting from the dto.
	 * For indent the required different classes objects are Indent, IndentDetails and DepartmentMaster.
	 * 
	 * @Return Indent
	 */
	@Override
	public Indent prepareIndentEntity(IndentDTO indentDTO) {
		
		Indent indent = new Indent();
		
		if(indentDTO.getId()!=null) {
			
			Optional<Indent> indentO = indentDao.findById(indentDTO.getId());
			
			if(indentO.isPresent()) {
				indent = indentO.get();
//				indent.setIndentCode(indentDTO.getIndentCode());
			}
			
		}
		
		indent.setAccepted(indentDTO.getAccepted());
		indent.setAuthorise(indentDTO.getAuthorise());
		indent.setAuthoriseDate(indentDTO.getAuthoriseDate());
		indent.setAuthorisedBy(indentDTO.getAuthorisedBy());
		
		indent.setPurchaseStatus(0);
		
		indent.setDepartment(indentDTO.getDepartment().getDepartmentId());
		
		if(indentDTO.getId()!=null)
			indent.setId(indent.getId());
		
//		indent.setIndentCode(indentDTO.getIndentCode());
		indent.setIndentDate(indentDTO.getIndentDate());
		indent.setIsActive(1);
		indent.setNotes(indentDTO.getNotes());
		indent.setPreparedBy(indentDTO.getPreparedBy());
		indent.setPriority(indentDTO.getPriority());
		indent.setProjectCode(indentDTO.getProjectCode());
		indent.setRevalidate(indentDTO.getRevalidate());
		
		if(indentDTO.getId()==null) {
			indent.setStatus(0);
			indent.setAccepted(0);
			indent.setAuthorise("0");
			indent.setIsActive(1);
			indent.setCreatedDate(new Date());
		}
		
		indent.setValidateDate(indentDTO.getValidateDate());
		
		List<IndentDetailsDTO> indentDetails = indentDTO.getIndentDetails();
		List<IndentDetails> indentDetailsDTOs = new ArrayList<>();
		for(IndentDetailsDTO id : indentDetails) {
			IndentDetails indentDetailsDTO = prepareIndentDetailsEntity(id);
			indentDetailsDTOs.add(indentDetailsDTO);
		}
		indent.setIndentDetails(indentDetailsDTOs);
		
		return indent;
	}

	/*
	 * @Param indentDetails
	 * 
	 * This method is used to convert to IndentDetailsDTO object from IndentDetails entity object. In this method different entities are used ie. UomMaster and ItemMaster.
	 * UomMaster is used to get the unit. ItemMaster is used to get the item details.
	 * 
	 * @return IndentDetailsDTO
	 */
	@Override
	public IndentDetailsDTO prepareIndentDetailsDTO(IndentDetails indentDetails) {
	
		IndentDetailsDTO indentDetailsDTO = new IndentDetailsDTO();
		indentDetailsDTO.setAvailableQty(indentDetails.getAvailableQty());
		indentDetailsDTO.setConvQty(indentDetails.getConvQty());
//		indentDetailsDTO.setCostCentre(indentDetails.getCostCentre());
		indentDetailsDTO.setDescription(indentDetails.getDescription());
		indentDetailsDTO.setDrawingInfo(indentDetails.getDrawingInfo());
		indentDetailsDTO.setId(indentDetails.getId());
		indentDetailsDTO.setIndentId(indentDetails.getIndentId());
//		indentDetailsDTO.setItemValue(indentDetails.getItemValue());
		indentDetailsDTO.setMaxQty(indentDetails.getMaxQty());
		indentDetailsDTO.setMinQty(indentDetails.getMinQty());
		indentDetailsDTO.setPendingIndentQty(indentDetails.getPendingIndentQty());
		indentDetailsDTO.setPendingPurQty(indentDetails.getPendingPurQty());
		indentDetailsDTO.setPendingSale(indentDetails.getPendingSale());
		indentDetailsDTO.setReason(indentDetails.getReason());
		indentDetailsDTO.setReorderLevel(indentDetails.getReorderLevel());
		indentDetailsDTO.setReqDate(indentDetails.getReqDate());
		indentDetailsDTO.setReqQty(indentDetails.getReqQty());
		
		UomMaster uomDTO = new UomMaster();
		if(indentDetails.getBaseUom()!=null && !indentDetails.getBaseUom().equals("null")) {
			Optional<UomMaster> uomO = uomRepo.findById(Integer.valueOf(indentDetails.getBaseUom()));
			if(uomO.isPresent()) {
				UomMaster uom = uomO.get();
				uomDTO.setDecimalPlace(uom.getDecimalPlace());
				uomDTO.setIsActive(uom.getIsActive());
				uomDTO.setUomCode(uom.getUomCode());
				uomDTO.setUomDescription(uom.getUomDescription());
				uomDTO.setUomId(uom.getUomId());
			}
		}
		indentDetailsDTO.setBaseUom(uomDTO);
		
		UomMaster uomDTOPur = new UomMaster();
		if(indentDetails.getPurUom()!=null && !indentDetails.getPurUom().equals("null")) {
			Optional<UomMaster> uomO = uomRepo.findById(Integer.valueOf(indentDetails.getPurUom()));
			if(uomO.isPresent()) {
				UomMaster uom = uomO.get();
				uomDTOPur.setDecimalPlace(uom.getDecimalPlace());
				uomDTOPur.setIsActive(uom.getIsActive());
				uomDTOPur.setUomCode(uom.getUomCode());
				uomDTOPur.setUomDescription(uom.getUomDescription());
				uomDTOPur.setUomId(uom.getUomId());
			}
		}
		indentDetailsDTO.setPurUom(uomDTOPur);
		
		ItemMasterDTO itemDTO = new ItemMasterDTO();
		if(indentDetails.getItemId()!=null) {
			Optional<ItemMaster> itemMasterO = itemDao.findById(indentDetails.getItemId());
			if(itemMasterO.isPresent()) {
				ItemMaster item = itemMasterO.get();
//				itemDTO.setItemCode(item.getItemCode());
//				itemDTO.setItemId(item.getId());
//				itemDTO.setItemName(itemDTO.getItemName());
				itemDTO = itemService.prepareItemMasterDTO(item);
			}
		}
		indentDetailsDTO.setItem(itemDTO);
		
		return indentDetailsDTO;
	}

	/*
	 * @Param indentDetails
	 * 
	 * This method is used to convert to IndentDetails object from IndentDetailsDTO DTO object. In this method different entities are used ie. UomMaster and ItemMaster.
	 * UomMaster is used to get the unit. ItemMaster is used to get the item details.
	 * 
	 * @return IndentDetailsDTO
	 */
	@Override
	public IndentDetails prepareIndentDetailsEntity(IndentDetailsDTO indentDetailsDTO) {
		
		IndentDetails indentDetails = new IndentDetails();
		
		if(indentDetailsDTO.getId()!=null) {
			
			Optional<IndentDetails> indentDetailsO = indentDetailsDao.findById(indentDetailsDTO.getId());
			
			if(indentDetailsO.isPresent()) {
				indentDetails = indentDetailsO.get();
			}
			
		}
		
		if(indentDetailsDTO.getAvailableQty()!=null)
			indentDetails.setAvailableQty(indentDetailsDTO.getAvailableQty());
		else
			indentDetails.setAvailableQty(0.0);
		
		if(indentDetailsDTO.getConvQty()!=null)
			indentDetails.setConvQty(indentDetailsDTO.getConvQty());
		else
			indentDetails.setConvQty(0.0);
		
//		indentDetails.setCostCentre(indentDetailsDTO.getCostCentre());
		indentDetails.setDescription(indentDetailsDTO.getDescription());
		indentDetails.setDrawingInfo(indentDetailsDTO.getDrawingInfo());
		
		if(indentDetailsDTO.getId()!=null)
			indentDetails.setId(indentDetailsDTO.getId());
		
		indentDetails.setIndentId(indentDetailsDTO.getIndentId());
//		indentDetails.setItemValue(indentDetailsDTO.getItemValue());
		
		if(indentDetailsDTO.getMaxQty()!=null)
			indentDetails.setMaxQty(indentDetailsDTO.getMaxQty());
		else
			indentDetails.setMaxQty(0.0);
		
		if(indentDetailsDTO.getMinQty()!=null)
			indentDetails.setMinQty(indentDetailsDTO.getMinQty());
		else
			indentDetails.setMinQty(0.0);
		
		if(indentDetailsDTO.getPendingIndentQty()!=null)
			indentDetails.setPendingIndentQty(indentDetailsDTO.getPendingIndentQty());
		else
			indentDetails.setPendingIndentQty(0.0);
		
		if(indentDetailsDTO.getPendingPurQty()!=null)
			indentDetails.setPendingPurQty(indentDetailsDTO.getPendingPurQty());
		else
			indentDetails.setPendingPurQty(0.0);
		
		if(indentDetailsDTO.getPendingSale()!=null)
			indentDetails.setPendingSale(indentDetailsDTO.getPendingSale());
		else
			indentDetails.setPendingSale(0.0);
		
		indentDetails.setReason(indentDetailsDTO.getReason());
		
		if(indentDetailsDTO.getReorderLevel()!=null)
			indentDetails.setReorderLevel(indentDetailsDTO.getReorderLevel());
		else
			indentDetails.setReorderLevel(0.0);
		
		indentDetails.setReqDate(indentDetailsDTO.getReqDate());
		
		if(indentDetailsDTO.getReqQty()!=null)
			indentDetails.setReqQty(indentDetailsDTO.getReqQty());
		else
			indentDetails.setReqQty(0.0);
		
		if(indentDetailsDTO.getBaseUom()!=null)
			indentDetails.setBaseUom(String.valueOf(indentDetailsDTO.getBaseUom().getUomId()));
		
		if(indentDetailsDTO.getPurUom()!=null)
			indentDetails.setPurUom(String.valueOf(indentDetailsDTO.getPurUom().getUomId()));
		
		
		indentDetails.setItemCode(indentDetailsDTO.getItem().getItemCode());
		indentDetails.setItemId(indentDetailsDTO.getItem().getId());
		
		return indentDetails;
	}

	/*
	 * @Param indentId
	 * 
	 * Fetching indent by indentId
	 * 
	 * @Return IndentDTO
	 */
	@Override
	public IndentDTO getIndentByIndentId(Integer indentId) {
		
		Optional<Indent> indentO = indentDao.findById(indentId);
		Indent indent = new Indent();
		if(indentO.isPresent()) {
			indent = indentO.get();
		}
		
		IndentDTO indentDTO = prepareIndentDTO(indent);
		
		return indentDTO;
	}


	@Override
	public Indent softDeleteIndent(Integer indentId) {
	
		Indent indent = new Indent();
		try {
			indent = indentDao.findById(indentId).get();
			indent.setIsActive(0);
			indentDao.save(indent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return indent;
	}
}