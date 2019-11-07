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
import com.aspl.org.dto.ShippingMethodMasterforVendorDTO;
import com.aspl.org.dto.VendorMasterDTO;
import com.aspl.org.entity.ContactsDetails;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.ReminderTermsMasterForVendor;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
import com.aspl.org.entity.VendorMaster;
import com.aspl.org.repository.ContactsDetailsDao;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.VendormasterService;

@Service
@Transactional
public class VendorMasterServiceImpl implements VendormasterService {

	
	@Autowired 
	VendorMasterDao vendorMasterDao;
	
	
	@Autowired 
	ContactsDetailsDao contactsDetailsDao;
	
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
	DeliveryTermsMasterDao deliveryMasterDao;
	/*
	 * DeliveryTermsMasterServiceImpl deliveryTermsMasterServiceImpl;
	 * 
	 * JurisdictionMasterServiceImpl jurisdictionMasterServiceImpl;
	 * 
	 * PaymentMethodMasterServiceImpl paymentMethodMasterServiceImpl;
	 * 
	 * PaymentTermsMasterServiceImpl paymentTermsMasterServiceImpl;
	 */
	
	@Override
	public VendorMasterDTO prepareVendorMasterDTO(VendorMaster vendorMaster) {
		// TODO Auto-generated method stub
		VendorMasterDTO vendorMasterDTO = new VendorMasterDTO();
		
		vendorMasterDTO.setAccountNo(vendorMaster.getAccountNo());
		vendorMasterDTO.setAddress1(vendorMaster.getAddress1());
		vendorMasterDTO.setAddress2(vendorMaster.getAddress2());
		vendorMasterDTO.setAmount(vendorMaster.getAmount());
		vendorMasterDTO.setBankName(vendorMaster.getBankName());
		vendorMasterDTO.setBinNo(vendorMaster.getBinNo());
		vendorMasterDTO.setBranch_office(vendorMaster.getBranch_office());
		vendorMasterDTO.setCexciseRegnNo(vendorMaster.getCexciseRegnNo());
		vendorMasterDTO.setCity(vendorMaster.getCity());
		vendorMasterDTO.setCommissionerate(vendorMaster.getCommissionerate());
		
		List<ContactsDetails> contacts = contactsDetailsDao.findByVendorId(vendorMaster.getId());
		vendorMasterDTO.setContactsDetails(contacts);
		
		vendorMasterDTO.setCountry(vendorMaster.getCountry());
		
		vendorMasterDTO.setDivision(vendorMaster.getDivision());
		vendorMasterDTO.setEccNo(vendorMaster.getEccNo());
		vendorMasterDTO.setEcgcDate(vendorMaster.getEcgcDate());
		vendorMasterDTO.setEcgcNo(vendorMaster.getEcgcNo());
		vendorMasterDTO.setEcgcValidityDate(vendorMaster.getEcgcValidityDate());
		vendorMasterDTO.setGstNo(vendorMaster.getGstNo());
		vendorMasterDTO.setHoCode(vendorMaster.getHoCode());
		vendorMasterDTO.setHoName(vendorMaster.getHoName());
		vendorMasterDTO.setId(vendorMaster.getId());
		vendorMasterDTO.setImpExpCode(vendorMaster.getImpExpCode());
		vendorMasterDTO.setInsuranceType(vendorMaster.getInsuranceType());
		vendorMasterDTO.setIsbLocked(vendorMaster.getIsbLocked());
		vendorMasterDTO.setIsisoSupplier(vendorMaster.getIsisoSupplier());
		
		vendorMasterDTO.setLedgerName(vendorMaster.getLedgerName());
		vendorMasterDTO.setPanNo(vendorMaster.getPanNo());
		vendorMasterDTO.setPin(vendorMaster.getPin());
		vendorMasterDTO.setBranchName(vendorMaster.getBranchName());
		vendorMasterDTO.setIfscCode(vendorMaster.getIfscCode());
		
		vendorMasterDTO.setRegnCumCode(vendorMaster.getRegnCumCode());
		vendorMasterDTO.setRegnCumCodeDate(vendorMaster.getRegnCumCodeDate());
		vendorMasterDTO.setRegnCumCouncilName(vendorMaster.getRegnCumCouncilName());
		vendorMasterDTO.setRegnCumValidityDate(vendorMaster.getRegnCumValidityDate());
		
		vendorMasterDTO.setRnge(vendorMaster.getRnge());
		
		vendorMasterDTO.setState(vendorMaster.getState());
		vendorMasterDTO.setStateCode(vendorMaster.getStateCode());
		vendorMasterDTO.setStaxRegnNo(vendorMaster.getStaxRegnNo());
		vendorMasterDTO.setValidationDate(vendorMaster.getValidationDate());
		vendorMasterDTO.setVendorCode(vendorMaster.getVendorCode());
		vendorMasterDTO.setVendorName(vendorMaster.getVendorName());
		
		DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO = new DeliveryTermsMasterforVendorDTO();
		if(vendorMaster.getDeliveryTermsId()!=null) {
			Optional<DeliveryTermsMasterforVendor> deliveryTermsO = deliveryMasterDao.findById(vendorMaster.getDeliveryTermsId());
			
			if(deliveryTermsO.isPresent()) {
				DeliveryTermsMasterforVendor DeliveryTermsMasterControllerforVendor = deliveryTermsO.get();
				deliveryTermsMasterforVendorDTO.setDeliveryTermsCode(DeliveryTermsMasterControllerforVendor.getDeliveryTermsCode());
				deliveryTermsMasterforVendorDTO.setDescription(DeliveryTermsMasterControllerforVendor.getDescription());
				deliveryTermsMasterforVendorDTO.setId(DeliveryTermsMasterControllerforVendor.getId());
				
				vendorMasterDTO.setDeliveryTermsMasterforVendorDTO(deliveryTermsMasterforVendorDTO);
			}
					
		}
		
		
		JurisdictionMasterForVendorDTO jurisdictionMasterForVendor = new JurisdictionMasterForVendorDTO();
		if(vendorMaster.getJurisdictionId()!=null) {
			Optional<JurisdictionMasterForVendor> juridictionO = juridictionDao.findById(vendorMaster.getJurisdictionId());
			if(juridictionO.isPresent()) {
				JurisdictionMasterForVendor juridiction = juridictionO.get();
				jurisdictionMasterForVendor.setDescription(juridiction.getDescription());
				jurisdictionMasterForVendor.setId(juridiction.getId());
				jurisdictionMasterForVendor.setJurisdictionCode(juridiction.getJurisdictionCode());
				
				vendorMasterDTO.setJurisdictionMasterForVendor(jurisdictionMasterForVendor);
			}
		}
		
		
		PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO = new PaymentMethodMasterforVendorDTO();
		if(vendorMaster.getPaymentMethodId()!=null) {
			Optional<PaymentMethodMasterforVendor> paymentMethodO = paymentMethodDao.findById(vendorMaster.getPaymentMethodId()) ;
			if(paymentMethodO.isPresent()) {
				PaymentMethodMasterforVendor masterforVendor = paymentMethodO.get();
				paymentMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				paymentMethodMasterforVendorDTO.setId(masterforVendor.getId());
				paymentMethodMasterforVendorDTO.setPaymentMethodCode(masterforVendor.getPaymentMethodCode());
				
				vendorMasterDTO.setPaymentMethodMasterforVendorDTO(paymentMethodMasterforVendorDTO);
			}
		}
		
		
		PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO = new PaymentTermsMasterforVendorDTO();
		if(vendorMaster.getPaymentTermsId()!=null) {
			Optional<PaymentTermsMasterforVendor> paymentTermsO = paymentTermsDao.findById(vendorMaster.getPaymentTermsId());
			if(paymentTermsO.isPresent()) {
				PaymentTermsMasterforVendor masterforVendor = paymentTermsO.get();
				paymentTermsMasterforVendorDTO.setDays(masterforVendor.getDays());
				paymentTermsMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				paymentTermsMasterforVendorDTO.setDisc_amt(masterforVendor.getDisc_amt());
				paymentTermsMasterforVendorDTO.setId(masterforVendor.getId());
				paymentTermsMasterforVendorDTO.setPaymentTermsCode(masterforVendor.getPaymentTermsCode());
				
				vendorMasterDTO.setPaymentTermsMasterforVendorDTO(paymentTermsMasterforVendorDTO);
			}
		}
		
		
		ReminderTermsMasterForVendorDTO reminderTermsMasterForVendorDTO = new ReminderTermsMasterForVendorDTO();
		if(vendorMaster.getReminderTermsId()!=null) {
			Optional<ReminderTermsMasterForVendor> reminderO = reminderMasterDao.findById(vendorMaster.getReminderTermsId());
			if(reminderO.isPresent()) {
				ReminderTermsMasterForVendor forVendor = reminderO.get();
				reminderTermsMasterForVendorDTO.setDescription(forVendor.getDescription());
				reminderTermsMasterForVendorDTO.setId(forVendor.getId());
				reminderTermsMasterForVendorDTO.setMaxReminder(forVendor.getMaxReminder());
				reminderTermsMasterForVendorDTO.setReminderTermsCode(forVendor.getReminderTermsCode());
				
				vendorMasterDTO.setReminderTermsMasterForVendorDTO(reminderTermsMasterForVendorDTO);
			}
		}
		
		
		ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO = new ShippingMethodMasterforVendorDTO();
		if(vendorMaster.getShippingMethodCodeId()!=null) {
			Optional<ShippingMethodMasterforVendor> shippingO = shippingDao.findById(vendorMaster.getShippingMethodCodeId());
			if(shippingO.isPresent()) {
				ShippingMethodMasterforVendor masterforVendor = shippingO.get();
				shippingMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				shippingMethodMasterforVendorDTO.setId(masterforVendor.getId());
				shippingMethodMasterforVendorDTO.setShippingMethodCode(masterforVendor.getShippingMethodCode());
				
				vendorMasterDTO.setShippingMethodMasterforVendorDTO(shippingMethodMasterforVendorDTO);
			}
		}
		
		
		return vendorMasterDTO;
	}



	@Override
	public VendorMaster prepareVendorMaster(VendorMasterDTO vendorMasterDTO) {
		// TODO Auto-generated method stub
		VendorMaster vendorMaster = new VendorMaster();
		//VendorMaster vendorEntity = vendorMasterDao.save(vendorMaster);
		
		
		if(vendorMasterDTO.getId()!=null) {
			Optional<VendorMaster> vendorO = vendorMasterDao.findById(vendorMasterDTO.getId());
			if(vendorO.isPresent()) {
				vendorMaster = vendorO.get();
			}
		}
		
		vendorMaster.setStatus(1);
		
		vendorMaster.setAccountNo(vendorMasterDTO.getAccountNo());
		vendorMaster.setAddress1(vendorMasterDTO.getAddress1());
		vendorMaster.setAddress2(vendorMasterDTO.getAddress2());
		vendorMaster.setAmount(vendorMasterDTO.getAmount());
		vendorMaster.setBankName(vendorMasterDTO.getBankName());
		vendorMaster.setBinNo(vendorMasterDTO.getBinNo());
		vendorMaster.setBranch_office(vendorMasterDTO.getBranch_office());
		vendorMaster.setCexciseRegnNo(vendorMasterDTO.getCexciseRegnNo());
		vendorMaster.setCity(vendorMasterDTO.getCity());
		vendorMaster.setCommissionerate(vendorMasterDTO.getCommissionerate());
//		vendorMaster.setContactsDetails(vendorMasterDTO.getContactsDetails());
		vendorMaster.setCountry(vendorMasterDTO.getCountry());
		vendorMaster.setPin(vendorMasterDTO.getPin());
		vendorMaster.setBranchName(vendorMasterDTO.getBranchName());
		vendorMaster.setIfscCode(vendorMasterDTO.getIfscCode());
		
		vendorMaster.setDivision(vendorMasterDTO.getDivision());
		vendorMaster.setEccNo(vendorMasterDTO.getEccNo());
		vendorMaster.setEcgcNo(vendorMasterDTO.getEcgcNo());
		vendorMaster.setEcgcDate(vendorMasterDTO.getEcgcDate());
		vendorMaster.setEcgcValidityDate(vendorMasterDTO.getEcgcValidityDate());
		vendorMaster.setGstNo(vendorMasterDTO.getGstNo());
		vendorMaster.setHoCode(vendorMasterDTO.getHoCode());
		vendorMaster.setHoName(vendorMasterDTO.getHoName());
		
		vendorMaster.setImpExpCode(vendorMasterDTO.getImpExpCode());
		vendorMaster.setInsuranceType(vendorMasterDTO.getInsuranceType());
		vendorMaster.setIsbLocked(vendorMasterDTO.getIsbLocked());
		vendorMaster.setIsisoSupplier(vendorMasterDTO.getIsisoSupplier());
		
		vendorMaster.setLedgerName(vendorMasterDTO.getLedgerName());
		vendorMaster.setPanNo(vendorMasterDTO.getPanNo());
		
		vendorMaster.setRegnCumCode(vendorMasterDTO.getRegnCumCode());
		vendorMaster.setRegnCumCodeDate(vendorMasterDTO.getRegnCumCodeDate());
		vendorMaster.setRegnCumCouncilName(vendorMasterDTO.getRegnCumCouncilName());
		vendorMaster.setRegnCumValidityDate(vendorMasterDTO.getRegnCumValidityDate());
		
		vendorMaster.setRnge(vendorMasterDTO.getRnge());
		vendorMaster.setState(vendorMasterDTO.getState());
		vendorMaster.setStateCode(vendorMasterDTO.getStateCode());
		vendorMaster.setStaxRegnNo(vendorMasterDTO.getStaxRegnNo());
		vendorMaster.setValidationDate(vendorMasterDTO.getValidationDate());
		
		vendorMaster.setVendorName(vendorMasterDTO.getVendorName());
		
		if(vendorMasterDTO.getDeliveryTermsMasterforVendorDTO()!=null) {
			vendorMaster.setDeliveryTermsCode(vendorMasterDTO.getDeliveryTermsMasterforVendorDTO().getDeliveryTermsCode());
			vendorMaster.setDeliveryTermsId1(vendorMasterDTO.getDeliveryTermsMasterforVendorDTO().getId());
		}
		
		if(vendorMasterDTO.getJurisdictionMasterForVendor()!=null) {
			vendorMaster.setJurisdictionCode(vendorMasterDTO.getJurisdictionMasterForVendor().getJurisdictionCode());
			vendorMaster.setJurisdictionId(vendorMasterDTO.getJurisdictionMasterForVendor().getId());
		}
		
		if(vendorMasterDTO.getPaymentMethodMasterforVendorDTO()!=null) {
			vendorMaster.setPaymentMethodCode(vendorMasterDTO.getPaymentMethodMasterforVendorDTO().getPaymentMethodCode());
			vendorMaster.setPaymentMethodId(vendorMasterDTO.getPaymentMethodMasterforVendorDTO().getId());
		}
		
		if(vendorMasterDTO.getPaymentTermsMasterforVendorDTO()!=null) {
			vendorMaster.setPaymentTermsCode(vendorMasterDTO.getPaymentTermsMasterforVendorDTO().getPaymentTermsCode());
			vendorMaster.setPaymentTermsId(vendorMasterDTO.getPaymentTermsMasterforVendorDTO().getId());
		}
		
		if(vendorMasterDTO.getReminderTermsMasterForVendorDTO()!=null) {
			vendorMaster.setReminderTermsCode(vendorMasterDTO.getReminderTermsMasterForVendorDTO().getReminderTermsCode());
			vendorMaster.setReminderTermsId(vendorMasterDTO.getReminderTermsMasterForVendorDTO().getId());
		}
		
		if(vendorMasterDTO.getShippingMethodMasterforVendorDTO()!=null) {
			vendorMaster.setShippingMethodCode(vendorMasterDTO.getShippingMethodMasterforVendorDTO().getShippingMethodCode());
			vendorMaster.setShippingMethodCodeId(vendorMasterDTO.getShippingMethodMasterforVendorDTO().getId());
		}
		
		return vendorMaster;
	}
	
	@Override
	public List<VendorMasterDTO> getallvendorlist() {
		List<VendorMasterDTO> dtos = new ArrayList<>();
		try {
			List<VendorMaster> list = vendorMasterDao.findByStatus(1);
			for(VendorMaster vm : list) {
				VendorMasterDTO vendorDTO = new VendorMasterDTO();
				vendorDTO = prepareVendorMasterDTO(vm);
				dtos.add(vendorDTO);
			}
		}catch(Exception e) {
			
		}
		return dtos;
	}

	

	  @Override
	  public VendorMasterDTO findByVendorCode(String vendorCode) {
		  
		  VendorMasterDTO vendorDTO = new VendorMasterDTO();
		  try {
			  VendorMaster vendorMaster=vendorMasterDao.findByVendorCode(vendorCode);
			  vendorDTO = prepareVendorMasterDTO(vendorMaster);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return vendorDTO;
	  
	  }
	  
	  @Override
	  public VendorMasterDTO findByVendorId(Integer vendorId) {
		  
		  VendorMasterDTO vendorDTO = new VendorMasterDTO();
		  try {
			  Optional<VendorMaster> vendorMasterO=vendorMasterDao.findById(vendorId);
			  VendorMaster vendorMaster = new VendorMaster();
			  if(vendorMasterO.isPresent()) {
				  vendorMaster = vendorMasterO.get();
			  }
			  vendorDTO = prepareVendorMasterDTO(vendorMaster);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return vendorDTO;
	  
	  }
	

	/*
	 * @Override public VendorMaster vendorMasterSave(VendorMaster vendorMaster) {
	 * 
	 * return vendorMasterDao.save(vendorMaster); }
	 */
	
	 @Override 
	 public ResponseDetails vendorMasterSave(VendorMasterDTO vendorMasterDTO) {
		 VendorMaster vendorEntity = new VendorMaster();
			try{
				//Generating indentCode start
				/*String vendorCode = "";
				Long vendorCount = vendorMasterDao.count();
				
				DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
				String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
	//			(formattedDate);
				Integer currYear = Integer.valueOf(formattedDate);
				Integer nextYear = currYear+1;
				vendorCode = "VEN/"+(vendorCount+1)+"/"+currYear+"-"+nextYear;
				//Generating indentCode end
				*/
				VendorMaster vendor = prepareVendorMaster(vendorMasterDTO);
				if(vendorMasterDTO.getId()==null) {
//					vendor.setVendorCode(vendorCode);
					vendor.setVendorCode(vendorMasterDTO.getVendorCode());
				}
				
				VendorMaster vendorNames = vendorMasterDao.findByVendorName(vendorMasterDTO.getVendorName());
				if(vendorNames!=null) {
					
					return new ResponseDetails(new Date(), "Sorry '"+vendorMasterDTO.getVendorName()+"' already exist.", null);
				}else {
				
				vendorEntity = vendorMasterDao.save(vendor);
				}
				
				if(vendorEntity!=null) {
					for(ContactsDetails contact : vendorMasterDTO.getContactsDetails()) {
						ContactsDetails contactsDetails = new ContactsDetails();
	
						contactsDetails.setContactNo(contact.getContactNo());
						contactsDetails.setContactPerson(contact.getContactPerson());
						contactsDetails.setContactType(contact.getContactType());
						contactsDetails.setDepartment(contact.getDepartment());
						contactsDetails.setDesignation(contact.getDesignation());
						contactsDetails.setEmail(contact.getEmail());
						contactsDetails.setFaxNo(contact.getFaxNo());
						contactsDetails.setId(contact.getId());
						contactsDetails.setMobileNo(contact.getMobileNo());
						contactsDetails.setCustomerId(contact.getCustomerId());
						contactsDetails.setVendorId(vendorEntity.getId());
						
						contactsDetailsDao.save(contactsDetails);
					}
				
				    }
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	  
			return new ResponseDetails(new Date(), "We have registered the vendor successfully", null, vendorEntity.getId());
	  
	  }
	  
	  @Override public ResponseDetails vendormasterupdate(VendorMasterDTO vendorMasterDTO) {
	  
		  try {
			  List<ContactsDetails> contactsList = new ArrayList<>();
			  
			  for(ContactsDetails contct:vendorMasterDTO.getContactsDetails()) {
				  contactsList.add(contct);
			  }
			  
			  VendorMaster vendor = prepareVendorMaster(vendorMasterDTO);
			  
			  VendorMaster vendorEntity = vendorMasterDao.save(vendor);
				
				if(vendorEntity!=null) {
					for(ContactsDetails contact : contactsList) {
						ContactsDetails contactsDetails = contactsDetailsDao.findById(contact.getId()).get();

						contactsDetails.setContactNo(contact.getContactNo());
						contactsDetails.setContactPerson(contact.getContactPerson());
						contactsDetails.setContactType(contact.getContactType());
						contactsDetails.setDepartment(contact.getDepartment());
						contactsDetails.setDesignation(contact.getDesignation());
						contactsDetails.setEmail(contact.getEmail());
						contactsDetails.setFaxNo(contact.getFaxNo());
						contactsDetails.setId(contact.getId());
						contactsDetails.setMobileNo(contact.getMobileNo());
						contactsDetails.setCustomerId(contact.getCustomerId());
						contactsDetails.setVendorId(vendorEntity.getId());
						
						contactsDetailsDao.save(contactsDetails);
					}
				
				}
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  
		  return new ResponseDetails(new Date(), "Successfully updated vendor ","200"); 
	  }
	 


	@Override
	public ResponseDetails permDeleteVendorMasterById(int vendorId) {
		// TODO Auto-generated method stub
		vendorMasterDao.deleteById(vendorId);
		
		return new ResponseDetails(new Date(), "Successfully deleted vendor ", String.valueOf(vendorId));
	}



	@Override
	public ResponseDetails softDeleteVendorMasterById(int vendorId) {
		// TODO Auto-generated method stub
		VendorMaster vendor = vendorMasterDao.findById(vendorId).get();
		vendor.setStatus(0);
		vendorMasterDao.save(vendor);
		return new ResponseDetails(new Date(), "Deleted Sucessfully", "200");
	}



	@Override
	public VendorMasterDTO getVendorById(Integer vendorId) {
		// TODO Auto-generated method stub
		VendorMasterDTO vendorDTO = new VendorMasterDTO();
		Optional<VendorMaster> vendorO = vendorMasterDao.findById(vendorId);
		if(vendorO.isPresent()) {
			vendorDTO = prepareVendorMasterDTO(vendorO.get());
		}
		return vendorDTO;
	}


	

}
