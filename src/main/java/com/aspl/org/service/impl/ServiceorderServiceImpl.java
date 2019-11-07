package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.DeliveryTermsMasterforVendorDTO;
import com.aspl.org.dto.JurisdictionMasterForVendorDTO;
import com.aspl.org.dto.PaymentMethodMasterforVendorDTO;
import com.aspl.org.dto.PaymentTermsMasterforVendorDTO;
import com.aspl.org.dto.ReminderTermsMasterForVendorDTO;
import com.aspl.org.dto.ServiceorderDTO;
import com.aspl.org.dto.ShippingMethodMasterforVendorDTO;
import com.aspl.org.dto.SoDetailsDTO;
import com.aspl.org.dto.VendorMasterDTO;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.ReminderTermsMasterForVendor;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.Serviceorder;
import com.aspl.org.entity.ServiceorderDetails;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.entity.VendorMaster;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.repository.ServiceorderDao;
import com.aspl.org.repository.ServiceorderDetailsDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.ServiceorderService;
import com.aspl.org.service.UomMasterService;
import com.aspl.org.service.VendormasterService;

@Service
@Transactional
public class ServiceorderServiceImpl implements ServiceorderService{
	
	@Autowired
	ServiceorderDao serviceorderDao;
	
	@Autowired
	ServiceorderDetailsDao serviceorderDetailsDao;
	
	@Autowired
	VendorMasterDao vendorDao;
	
	@Autowired
	DeliveryTermsMasterDao deliveryMasterDao;
	
	@Autowired
	JurisdictionMasterDao juridictionDao;
	
	@Autowired
	PaymentMethodMasterDao paymentMethodDao;
	
	@Autowired
	PaymentTermsMasterDao paymentTermsDao;
	
	@Autowired
	ReminderTermsMasterDao reminderMasterDao;
	
	@Autowired
	ShippingMethodMasterDao shippingDao;
	
	@Autowired
	VendormasterService vendorService;
	
	@Autowired
	UomMasterService uomService;
	

	
	/* 
	 * 
	 * @Param serviceorderDTO
	 * 
	 * serviceorderSave method to save Service Order
	 * 
	 * Parameter will be the DTO object of service order
	 * 
	 * @Return type will be in ResponseDetails, to show the Response status of the service method
	 * 
	 */
	
	@Override
	public ResponseDetails serviceorderSave(ServiceorderDTO serviceorderDTO) throws Exception {
    
		Serviceorder serviceorder = new Serviceorder();
					
		if (String.valueOf(serviceorderDTO.getVendor().getStateCode()).equals("19")) {
			serviceorderDTO.setSgst(serviceorderDTO.getSgst());
			serviceorderDTO.setCgst(serviceorderDTO.getCgst());
						
			Serviceorder serviceOrder = prepareServiceorderEntity(serviceorderDTO);
//			serviceOrder.setServiceCode(serviceOrderCode);
			serviceOrder.setServiceCode(serviceorderDTO.getServiceCode());
						
			serviceorder = serviceorderDao.save(serviceOrder);
					
						
		} else {
			serviceorderDTO.setIgst(serviceorderDTO.getIgst());
						
			Serviceorder serviceOrder = prepareServiceorderEntity(serviceorderDTO);
//			serviceOrder.setServiceCode(serviceOrderCode);
			serviceOrder.setServiceCode(serviceorderDTO.getServiceCode());
						
			serviceorder = serviceorderDao.save(serviceOrder);
			//("purchase: "+purchase.getId());
						
		}
					
		//Saving service order header end
		for (SoDetailsDTO soDetailsDTO : serviceorderDTO.getServiceorderDetails()) {
			ServiceorderDetails toGetItemCode = prepareSoDetailsEntity( soDetailsDTO);
			
			if (String.valueOf(serviceorderDTO.getVendor().getStateCode()).equals("19")) {
				//("purchase: "+purchase.getId());
				toGetItemCode.setSoid(serviceorder.getId());
									
				serviceorderDetailsDao.save(toGetItemCode);
			} else {
								//("purchase: "+purchase.getId());
				toGetItemCode.setSoid(serviceorder.getId());
									
				serviceorderDetailsDao.save(toGetItemCode);
			}
						   
							
		}
		return new ResponseDetails(new Date(), "We have created your service order successfully", null, 1);
	}
	
	/* 
	 * 
	 * @Param serviceorderDTO
	 * 
	 * serviceorderUpdate method to update Service Order
	 * 
	 * Parameter will be the DTO object of service order
	 * 
	 * @Return type will be in ResponseDetails, to show the Response status of the service method
	 * 
	 */
	@Override
	public ResponseDetails serviceorderUpdate(ServiceorderDTO serviceorderDTO) throws Exception {
		Serviceorder srv = new Serviceorder();
		try {
			Optional<Serviceorder> srvO = serviceorderDao.findById(serviceorderDTO.getId());
			
			if(srvO.isPresent()) {
				srv = srvO.get();
			}
			if(serviceorderDTO.getId()!=null) {
				List<SoDetailsDTO> serviceDetailsDTOs = serviceorderDTO.getServiceorderDetails();
				List<SoDetailsDTO> serviceDetailsDTOsEmpty = new ArrayList<>();
				for(SoDetailsDTO dto : serviceDetailsDTOs) {
					serviceDetailsDTOsEmpty.add(dto);
				}
				Serviceorder serviceOrderEntity = prepareServiceorderEntity(serviceorderDTO);
				
				serviceorderDao.save(serviceOrderEntity);
				
				for(SoDetailsDTO dto : serviceDetailsDTOsEmpty) {
					ServiceorderDetails detailsEntity = prepareSoDetailsEntity(dto);
					
					serviceorderDetailsDao.save(detailsEntity); 
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Service order updated successfully", srv.toString());
	}
	
	/* 
	 * 
	 * @Param serviceCode
	 * 
	 * findByServiceorderCode method to search Service Order by service order code
	 * 
	 * Parameter will be the serviceCode object of service order
	 * 
	 * @Return type will be service order DTO
	 * 
	 */
	@Override
	public ServiceorderDTO findByServiceorderCode(String serviceCode) {
		System.err.println("Service Order Code : "+serviceCode);
		ServiceorderDTO srvDTO = new ServiceorderDTO();
		try {
			Serviceorder srv = serviceorderDao.findByServiceCode(serviceCode);
			srvDTO = prepareServiceorderDTO(srv);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return srvDTO;

	}
	
	/* 
	 * 
	 * getAllServiceOrder method to get all Service Order issued by purchase order
	 * 
	 * @Return type will be service order DTO
	 * 
	 */
	@Override
	public List<ServiceorderDTO> getAllServiceOrder() {
		List<ServiceorderDTO> serviceorderDTOs = new ArrayList<>();
		ServiceorderDTO srvDTO = new ServiceorderDTO();
		
		try {
//			List<Serviceorder> serviceorder = serviceorderDao.findAll();
			List<Serviceorder> serviceorder = serviceorderDao.findByIsActive(1);
			for(Serviceorder srv : serviceorder) {
				srvDTO = prepareServiceorderDTO(srv);
				serviceorderDTOs.add(srvDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return serviceorderDTOs;
	}
	
	/*
	 * @Param serviceorder
	 * 
	 * This method is for converting service order entity to service order DTO
	 * 
	 * @Return serviceorderDTO
	 */
	@Override
	public ServiceorderDTO prepareServiceorderDTO(Serviceorder serviceorder) {
		
       ServiceorderDTO serviceorderDTO = new ServiceorderDTO();
		
       serviceorderDTO.setAccepted(serviceorder.getAccepted());
       
       if(serviceorder.getCgst()!=null)
    	   serviceorderDTO.setCgst(serviceorder.getCgst());
       else
    	   serviceorderDTO.setCgst(0.0);
       
       serviceorderDTO.setDeliveryDate(serviceorder.getDeliveryDate());
       
       if(serviceorder.getFreight()!=null)
    	   serviceorderDTO.setFreight(serviceorder.getFreight());
       else
    	   serviceorderDTO.setFreight(0.0);
       
       if(serviceorder.getGrandTotal()!=null)
    	   serviceorderDTO.setGrandTotal(serviceorder.getGrandTotal());
       else
    	   serviceorderDTO.setGrandTotal(0.0);
       
//       serviceorderDTO.setGst(serviceorder.getGst());
       serviceorderDTO.setId(serviceorder.getId());
       
       if(serviceorder.getIgst()!=null)
    	   serviceorderDTO.setIgst(serviceorder.getIgst());
       else
    	   serviceorderDTO.setIgst(0.0);
       
       if(serviceorder.getPkg()!=null)
    	   serviceorderDTO.setPkg(serviceorder.getPkg());
       else
    	   serviceorderDTO.setPkg(0.0);
		
	
       serviceorderDTO.setIsActive(serviceorder.getIsActive());
       serviceorderDTO.setOrderDate(serviceorder.getOrderDate());
       
       if(serviceorder.getOtherCharges()!=null)
    	   serviceorderDTO.setOtherCharges(serviceorder.getOtherCharges());
       else
    	   serviceorderDTO.setOtherCharges(0.0);
      
       if(serviceorder.getNotes()!=null)
    	   serviceorderDTO.setNotes(serviceorder.getNotes());
       else
    	   serviceorderDTO.setNotes("");
       
       serviceorderDTO.setServiceCode(serviceorder.getServiceCode());
		
       if(serviceorder.getPkgPer()!=null)
    	   serviceorderDTO.setPkgPer(serviceorder.getPkgPer());
       else
    	   serviceorderDTO.setPkgPer(serviceorder.getPkgPer());
       
       if(serviceorder.getCgstPer()!=null)
    	   serviceorderDTO.setCgstPer(serviceorder.getCgstPer());
       else
    	   serviceorderDTO.setCgstPer(0.0);
       
       if(serviceorder.getSgstPer()!=null)
    	   serviceorderDTO.setSgstPer(serviceorder.getSgstPer());
       else
    	   serviceorderDTO.setSgstPer(0.0);
       
       if(serviceorder.getFreightPer()!=null)
    	   serviceorderDTO.setFreightPer(serviceorder.getFreightPer());
       else
    	   serviceorderDTO.setFreightPer(0.0);
       
       if(serviceorder.getIgstPer()!=null)
    	   serviceorderDTO.setIgstPer(serviceorder.getIgstPer());
       else
    	   serviceorderDTO.setIgstPer(0.0);
       
       if(serviceorder.getRoyaltyPer()!=null)
    	   serviceorderDTO.setRoyaltyPer(serviceorder.getRoyaltyPer());
       else
    	   serviceorderDTO.setRoyaltyPer(0.0);
		
       if(serviceorder.getRoyalty()!=null)
    	   serviceorderDTO.setRoyalty(serviceorder.getRoyalty());
       else
    	   serviceorderDTO.setRoyalty(serviceorder.getRoyalty());
       
       if(serviceorder.getSgst()!=null)
    	   serviceorderDTO.setSgst(serviceorder.getSgst());
       else
    	   serviceorderDTO.setSgst(0.0);
       
       if(serviceorder.getTotal_with_gst()!=null)
    	   serviceorderDTO.setTotal_with_gst(serviceorder.getTotal_with_gst());
       else
    	   serviceorderDTO.setTotal_with_gst(0.0);
       
       serviceorderDTO.setValidityDate(serviceorder.getValidityDate());
       
       DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO = new DeliveryTermsMasterforVendorDTO();
		if(serviceorder.getDeliveryTermsId1()!=null) {
			Optional<DeliveryTermsMasterforVendor> deliveryTermsO = deliveryMasterDao.findById(serviceorder.getDeliveryTermsId1());
			
			if(deliveryTermsO.isPresent()) {
				DeliveryTermsMasterforVendor DeliveryTermsMasterControllerforVendor = deliveryTermsO.get();
				deliveryTermsMasterforVendorDTO.setDeliveryTermsCode(DeliveryTermsMasterControllerforVendor.getDeliveryTermsCode());
				deliveryTermsMasterforVendorDTO.setDescription(DeliveryTermsMasterControllerforVendor.getDescription());
				deliveryTermsMasterforVendorDTO.setId(DeliveryTermsMasterControllerforVendor.getId());
				
				serviceorderDTO.setDeliveryTermsMasterforVendorDTO(deliveryTermsMasterforVendorDTO);
			}
					
		}
		
		JurisdictionMasterForVendorDTO jurisdictionMasterForVendor = new JurisdictionMasterForVendorDTO();
		if(serviceorder.getJurisdictionId()!=null) {
			Optional<JurisdictionMasterForVendor> juridictionO = juridictionDao.findById(serviceorder.getJurisdictionId());
			if(juridictionO.isPresent()) {
				JurisdictionMasterForVendor juridiction = juridictionO.get();
				jurisdictionMasterForVendor.setDescription(juridiction.getDescription());
				jurisdictionMasterForVendor.setId(juridiction.getId());
				jurisdictionMasterForVendor.setJurisdictionCode(juridiction.getJurisdictionCode());
				
				serviceorderDTO.setJurisdictionMasterForVendor(jurisdictionMasterForVendor);
			}
		}
		
		PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO = new PaymentMethodMasterforVendorDTO();
		if(serviceorder.getPaymentMethodId()!=null) {
			Optional<PaymentMethodMasterforVendor> paymentMethodO = paymentMethodDao.findById(serviceorder.getPaymentMethodId()) ;
			if(paymentMethodO.isPresent()) {
				PaymentMethodMasterforVendor masterforVendor = paymentMethodO.get();
				paymentMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				paymentMethodMasterforVendorDTO.setId(masterforVendor.getId());
				paymentMethodMasterforVendorDTO.setPaymentMethodCode(masterforVendor.getPaymentMethodCode());
				
				serviceorderDTO.setPaymentMethodMasterforVendorDTO(paymentMethodMasterforVendorDTO);
			}
		}
		
		
		PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO = new PaymentTermsMasterforVendorDTO();
		if(serviceorder.getPaymentTermsId()!=null) {
			Optional<PaymentTermsMasterforVendor> paymentTermsO = paymentTermsDao.findById(serviceorder.getPaymentTermsId());
			if(paymentTermsO.isPresent()) {
				PaymentTermsMasterforVendor masterforVendor = paymentTermsO.get();
				paymentTermsMasterforVendorDTO.setDays(masterforVendor.getDays());
				paymentTermsMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				paymentTermsMasterforVendorDTO.setDisc_amt(masterforVendor.getDisc_amt());
				paymentTermsMasterforVendorDTO.setId(masterforVendor.getId());
				paymentTermsMasterforVendorDTO.setPaymentTermsCode(masterforVendor.getPaymentTermsCode());
				
				serviceorderDTO.setPaymentTermsMasterforVendorDTO(paymentTermsMasterforVendorDTO);
			}
		}
		
		
		ReminderTermsMasterForVendorDTO reminderTermsMasterForVendorDTO = new ReminderTermsMasterForVendorDTO();
		if(serviceorder.getReminderTermsId()!=null) {
			Optional<ReminderTermsMasterForVendor> reminderO = reminderMasterDao.findById(serviceorder.getReminderTermsId());
			if(reminderO.isPresent()) {
				ReminderTermsMasterForVendor forVendor = reminderO.get();
				reminderTermsMasterForVendorDTO.setDescription(forVendor.getDescription());
				reminderTermsMasterForVendorDTO.setId(forVendor.getId());
				reminderTermsMasterForVendorDTO.setMaxReminder(forVendor.getMaxReminder());
				reminderTermsMasterForVendorDTO.setReminderTermsCode(forVendor.getReminderTermsCode());
				
				serviceorderDTO.setReminderTermsMasterForVendorDTO(reminderTermsMasterForVendorDTO);
			}
		}
		
		
		ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO = new ShippingMethodMasterforVendorDTO();
		if(serviceorder.getShippingMethodCodeId()!=null) {
			Optional<ShippingMethodMasterforVendor> shippingO = shippingDao.findById(serviceorder.getShippingMethodCodeId());
			if(shippingO.isPresent()) {
				ShippingMethodMasterforVendor masterforVendor = shippingO.get();
				shippingMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				shippingMethodMasterforVendorDTO.setId(masterforVendor.getId());
				shippingMethodMasterforVendorDTO.setShippingMethodCode(masterforVendor.getShippingMethodCode());
				
				serviceorderDTO.setShippingMethodMasterforVendorDTO(shippingMethodMasterforVendorDTO);
			}
		}
		
		
		VendorMaster vendor = new VendorMaster();
		if(serviceorder.getVendorId()!=null) {
			Optional<VendorMaster> vendorO = vendorDao.findById(Integer.valueOf(serviceorder.getVendorId()));
			if(vendorO.isPresent()) {
				vendor = vendorO.get();
				
				VendorMasterDTO vendorDTO = vendorService.findByVendorId(vendor.getId());
				serviceorderDTO.setVendor(vendorDTO);
			}
		}else {
			VendorMasterDTO vendorDTO = new VendorMasterDTO();
			serviceorderDTO.setVendor(vendorDTO);
		}
		
		
		
		List<SoDetailsDTO> soDetailsDTO = new ArrayList<>();
		List<ServiceorderDetails> serviceorderDetails = serviceorderDetailsDao.findBySoid(serviceorder.getId());
		for(ServiceorderDetails soDetails : serviceorderDetails) {
			SoDetailsDTO sDetailsDTO = prepareSoDetailsDTO(soDetails);
			soDetailsDTO.add(sDetailsDTO);
		}
		serviceorderDTO.setServiceorderDetails(soDetailsDTO);
		
		return serviceorderDTO;
	}

	
	/*
	 * @Param serviceorderDetails
	 * 
	 * Method for creating service order details DTO from service order details entity
	 * 
	 * @Return @soDetailsDTO
	 */

	@Override
	public SoDetailsDTO prepareSoDetailsDTO(ServiceorderDetails serviceorderDetails) {
        SoDetailsDTO soDetailsDTO = new SoDetailsDTO();
		
		
		soDetailsDTO.setAssesValue(serviceorderDetails.getAssesValue());
		soDetailsDTO.setServiceDescription(serviceorderDetails.getServiceDescription());
		soDetailsDTO.setDisc(serviceorderDetails.getDisc());
		
		soDetailsDTO.setId(serviceorderDetails.getId());

		
		
		soDetailsDTO.setSoid(serviceorderDetails.getSoid());
		
		soDetailsDTO.setPrice(serviceorderDetails.getPrice());
		soDetailsDTO.setQty(serviceorderDetails.getQty());
		soDetailsDTO.setDisc(serviceorderDetails.getDisc());
		//soDetailsDTO.setNetDisc(serviceorderDetails.getNetDisc());
		soDetailsDTO.setAmount(serviceorderDetails.getAmount());
		
		if(serviceorderDetails.getUnit()!=null) {
			UomMaster uom = uomService.getUomByUomId(Integer.valueOf(serviceorderDetails.getUnit()));
			soDetailsDTO.setUnit(uom);
		}
		
		
		return soDetailsDTO;
	}

	/*
	 * @Param serviceorderDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return serviceorder
	 */

	@Override
	public Serviceorder prepareServiceorderEntity(ServiceorderDTO serviceorderDTO) { 
		
      Serviceorder serviceorder = new Serviceorder();
		
      if(serviceorderDTO.getId()!=null) {
    	  Optional<Serviceorder> serviceorderO = serviceorderDao.findById(serviceorderDTO.getId());
			
			if(serviceorderO.isPresent()) {
				serviceorder = serviceorderO.get();
			}
      }
      if(serviceorderDTO.getId()==null) {
    	  serviceorder.setAccepted(0);
    	  serviceorder.setServiceorderStatus(0);
		}
      
//      serviceorder.setAccepted(serviceorderDTO.getAccepted());
	
      if(serviceorderDTO.getCgst()!=null)
    	  serviceorder.setCgst(serviceorderDTO.getCgst());
      else
    	  serviceorder.setCgst(0.0);
      
      serviceorder.setDeliveryDate(serviceorderDTO.getDeliveryDate());
      
      if(serviceorderDTO.getFreight()!=null)
    	  serviceorder.setFreight(serviceorderDTO.getFreight());
      else
    	  serviceorder.setFreight(0.0);
      
      if(serviceorderDTO.getGrandTotal()!=null)
    	  serviceorder.setGrandTotal(serviceorderDTO.getGrandTotal());
      else
    	  serviceorder.setGrandTotal(0.0);
      
//      serviceorder.setGst(serviceorderDTO.getGst());
      serviceorder.setId(serviceorderDTO.getId());
      
      if(serviceorderDTO.getIgst()!=null)
    	  serviceorder.setIgst(serviceorderDTO.getIgst());
      else
    	  serviceorder.setIgst(0.0);
      
      serviceorder.setIsActive(1);
      
      serviceorder.setNotes(serviceorderDTO.getNotes());
      
      if(serviceorderDTO.getPkg()!=null)
    	  serviceorder.setPkg(serviceorderDTO.getPkg());
      else
    	  serviceorder.setPkg(0.0);
		
      serviceorder.setIsActive(serviceorderDTO.getIsActive());
      serviceorder.setOrderDate(serviceorderDTO.getOrderDate());
      
      if(serviceorderDTO.getOtherCharges()!=null)
    	  serviceorder.setOtherCharges(serviceorderDTO.getOtherCharges());
      else
    	  serviceorder.setOtherCharges(0.0);
	  
      if(serviceorderDTO.getPkgPer()!=null)
    	  serviceorder.setPkgPer(serviceorderDTO.getPkgPer());
      else
    	  serviceorder.setPkgPer(0.0);
      
      if(serviceorderDTO.getCgstPer()!=null)
    	  serviceorder.setCgstPer(serviceorderDTO.getCgstPer());
      else
    	  serviceorder.setCgstPer(0.0);
      
      if(serviceorderDTO.getSgstPer()!=null)
    	  serviceorder.setSgstPer(serviceorderDTO.getSgstPer());
      else
    	  serviceorder.setSgstPer(0.0);
      
      if(serviceorderDTO.getFreightPer()!=null)
    	  serviceorder.setFreightPer(serviceorderDTO.getFreightPer());
      else
    	  serviceorder.setFreightPer(serviceorderDTO.getFreightPer());
      
      if(serviceorderDTO.getIgstPer()!=null)
    	  serviceorder.setIgstPer(serviceorderDTO.getIgstPer());
      else
    	  serviceorder.setIgstPer(0.0);
      
      if(serviceorderDTO.getRoyaltyPer()!=null)
    	  serviceorder.setRoyaltyPer(serviceorderDTO.getRoyaltyPer());
      else
    	  serviceorder.setRoyaltyPer(0.0);
      
      if(serviceorderDTO.getRoyalty()!=null)
    	  serviceorder.setRoyalty(serviceorderDTO.getRoyalty());
      else
    	  serviceorder.setRoyalty(0.0);
      
      if(serviceorderDTO.getSgst()!=null)
    	  serviceorder.setSgst(serviceorderDTO.getSgst());
      else
    	  serviceorder.setSgst(0.0);
      
//      serviceorder.setTotal_with_gst(serviceorderDTO.getTotal_with_gst());

      serviceorder.setValidityDate(serviceorderDTO.getValidityDate());
		
		List<SoDetailsDTO> soDetailsDTOs = serviceorderDTO.getServiceorderDetails();
		List<ServiceorderDetails> soDetailsEntitys = new ArrayList<>();
		for(SoDetailsDTO sDetailsDTO : soDetailsDTOs) {
			ServiceorderDetails soDetails = prepareSoDetailsEntity(sDetailsDTO);
			soDetailsEntitys.add(soDetails);
		}
		serviceorder.setServiceorderDetails(soDetailsEntitys);
		VendorMaster vendor = new VendorMaster();
		if(serviceorderDTO.getVendor()!=null) {
			Optional<VendorMaster> vendorO = vendorDao.findById(serviceorderDTO.getVendor().getId());
			if(vendorO.isPresent()) {
				vendor = vendorO.get();
			}
		}
		if(vendor!=null) {
			serviceorder.setVendorCode(vendor.getVendorCode());
			serviceorder.setVendorId(vendor.getId());
			serviceorder.setVendorName(vendor.getVendorName());
		}
		serviceorder.setVendorCode(serviceorderDTO.getVendor().getVendorCode());
		serviceorder.setVendorId(serviceorderDTO.getVendor().getId());
		serviceorder.setVendorName(serviceorderDTO.getVendor().getVendorName());
		
		if(serviceorderDTO.getDeliveryTermsMasterforVendorDTO()!=null) {
			serviceorder.setDeliveryTermsCode(serviceorderDTO.getDeliveryTermsMasterforVendorDTO().getDeliveryTermsCode());
			serviceorder.setDeliveryTermsId1(serviceorderDTO.getDeliveryTermsMasterforVendorDTO().getId());
		}
		
		if(serviceorderDTO.getJurisdictionMasterForVendor()!=null) {
			serviceorder.setJurisdictionCode(serviceorderDTO.getJurisdictionMasterForVendor().getJurisdictionCode());
			serviceorder.setJurisdictionId(serviceorderDTO.getJurisdictionMasterForVendor().getId());
		}
		
		if(serviceorderDTO.getPaymentMethodMasterforVendorDTO()!=null) {
			serviceorder.setPaymentMethodCode(serviceorderDTO.getPaymentMethodMasterforVendorDTO().getPaymentMethodCode());
			serviceorder.setPaymentMethodId(serviceorderDTO.getPaymentMethodMasterforVendorDTO().getId());
		}
		
		if(serviceorderDTO.getPaymentTermsMasterforVendorDTO()!=null) {
			serviceorder.setPaymentTermsCode(serviceorderDTO.getPaymentTermsMasterforVendorDTO().getPaymentTermsCode());
			serviceorder.setPaymentTermsId(serviceorderDTO.getPaymentTermsMasterforVendorDTO().getId());
		}
		
		if(serviceorderDTO.getReminderTermsMasterForVendorDTO()!=null) {
			serviceorder.setReminderTermsCode(serviceorderDTO.getReminderTermsMasterForVendorDTO().getReminderTermsCode());
			serviceorder.setReminderTermsId(serviceorderDTO.getReminderTermsMasterForVendorDTO().getId());
		}
		
		if(serviceorderDTO.getShippingMethodMasterforVendorDTO()!=null) {
			serviceorder.setShippingMethodCode(serviceorderDTO.getShippingMethodMasterforVendorDTO().getShippingMethodCode());
			serviceorder.setShippingMethodCodeId(serviceorderDTO.getShippingMethodMasterforVendorDTO().getId());
		}
		
		
	    serviceorder.setIsActive(1);
		
		return serviceorder;
	}
	
	/*
	 * @Param serviceorderDetailsDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return serviceorderDetails
	 */

	@Override
	public ServiceorderDetails prepareSoDetailsEntity(SoDetailsDTO serviceorderDetailsDTO) {
         ServiceorderDetails serviceorderDetails = new ServiceorderDetails();
		
		 if(serviceorderDetailsDTO.getId()!=null) {
			 serviceorderDetails = serviceorderDetailsDao.findById(serviceorderDetailsDTO.getId()).get();
		 }
         
		 if(serviceorderDetailsDTO.getAssesValue()!=null)
			 serviceorderDetails.setAssesValue(Double.valueOf(serviceorderDetailsDTO.getAssesValue()));
		 else
			 serviceorderDetails.setAssesValue(0.0);
	
         serviceorderDetails.setServiceDescription(serviceorderDetailsDTO.getServiceDescription());
         
         if(serviceorderDetailsDTO.getDisc()!=null)
        	 serviceorderDetails.setDisc(serviceorderDetailsDTO.getDisc());
         else
        	 serviceorderDetails.setDisc(0.0);
         
//         serviceorderDetails.setNetDisc(serviceorderDetailsDTO.getNetDisc());
         
		
		if(serviceorderDetailsDTO.getId()!=null)
			serviceorderDetails.setId(serviceorderDetailsDTO.getId());
		
		
		serviceorderDetails.setSoid(serviceorderDetailsDTO.getSoid());
		
		if(serviceorderDetailsDTO.getPrice()!=null)
			serviceorderDetails.setPrice(serviceorderDetailsDTO.getPrice());
		else
			serviceorderDetails.setPrice(0.0);
		
		if(serviceorderDetailsDTO.getQty()!=null)
			serviceorderDetails.setQty(serviceorderDetailsDTO.getQty());
		else
			serviceorderDetails.setQty(0.0);
		
		serviceorderDetails.setUnit(String.valueOf(serviceorderDetailsDTO.getUnit().getUomId()));
		
		if(serviceorderDetailsDTO.getAmount()!=null)
			serviceorderDetails.setAmount(serviceorderDetailsDTO.getAmount());
		else
			serviceorderDetails.setAmount(0.0);
		
		serviceorderDetails.setServiceorder(serviceorderDetails.getServiceorder());
		
		
		return serviceorderDetails;
	}
	
	/*
	 * Method for fetching active service orders
	 * 
	 * @Return List<ServiceorderDTO>
	 */

	@Override
	public List<ServiceorderDTO> getAllActiveServiceOrder() {
		List<ServiceorderDTO> serviceDTOs = new ArrayList<>();
		ServiceorderDTO srvDTO = new ServiceorderDTO();
		
		try {
			List<Serviceorder> serviceorder = serviceorderDao.findByIsActive(1);
			for(Serviceorder srv : serviceorder) {
				srvDTO = prepareServiceorderDTO(srv);
				serviceDTOs.add(srvDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return serviceDTOs;
	}

	@Override
	public ResponseDetails softDeleteServiceOrder(Integer serviceorderId) {
		Optional<Serviceorder> serviceorderO = serviceorderDao.findById(serviceorderId);
		if(serviceorderO.isPresent()) {
			Serviceorder serviceorder = serviceorderO.get();
			serviceorder.setServiceorderStatus(0);
			serviceorderDao.save(serviceorder);
		}
		return new ResponseDetails(new Date(), "Successfully Deleted", "200");
	}

	@Override
	public ServiceorderDTO findByServiceorderId(Integer serviceorderId) {
		ServiceorderDTO srvDTO = new ServiceorderDTO();
		try {
			Optional<Serviceorder> srvO = serviceorderDao.findById(serviceorderId);
			Serviceorder srv = new Serviceorder();
			if(srvO.isPresent()) {
				srv = srvO.get();
			}
			srvDTO = prepareServiceorderDTO(srv);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return srvDTO;

}
}
