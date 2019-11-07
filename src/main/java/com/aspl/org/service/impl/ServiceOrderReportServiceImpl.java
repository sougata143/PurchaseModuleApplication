package com.aspl.org.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.ServiceOrderItemsDTO;
import com.aspl.org.dto.ServiceOrderReportDTO;
import com.aspl.org.entity.ContactsDetails;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.Serviceorder;
import com.aspl.org.entity.ServiceorderDetails;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
import com.aspl.org.entity.VendorMaster;
import com.aspl.org.repository.ContactsDetailsDao;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.ServiceorderDao;
import com.aspl.org.repository.ServiceorderDetailsDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.ServiceOrderReportService;
import com.aspl.org.utils.PurchaseUtil;


/*
 * Service class for generating the DTO for service order report generation
 */
@Service
@Transactional
public class ServiceOrderReportServiceImpl implements ServiceOrderReportService {
	
	@Autowired
	ServiceorderDao serviceorderDao;
	
	@Autowired
	ServiceorderDetailsDao serviceOrderDetailsDao;
	
	@Autowired
	VendorMasterDao vendorDao;
	
	@Autowired
	PaymentTermsMasterDao paymentTermDao;
	
	@Autowired
	DeliveryTermsMasterDao deliveryTermDao;
	
	@Autowired
	PaymentMethodMasterDao paymentMethodDao;
	
	@Autowired
	JurisdictionMasterDao juridictionDao;
	
	@Autowired
	ShippingMethodMasterDao shippingDao;
	
	@Autowired
	ContactsDetailsDao contactDao;
	
	@Autowired
	PurchaseUtil purUtil;

	
	DecimalFormat df = new DecimalFormat("#.##");
	
	/*
	 * @Param soid
	 * 
	 * This is method is used for generating the DTO class for service order. This method takes service order id as the param and returns ServiceOrderReportDTO. This DTO
	 * contains ServiceOrder, ServiceOrderDetails, VendorMaster, PaymentTermsMasterforVendor, PaymentMethodMasterforVendor, JurisdictionMasterForVendor, 
	 * ShippingMethodMasterforVendor, DeliveryTermsMasterforVendor and ContactsDetails objects.
	 * 
	 * @Return ServiceOrderReportDTO
	 */
	@Override
	public ServiceOrderReportDTO getServiceOrderReportDTO(Integer soid) {
		// TODO Auto-generated method stub
		ServiceOrderReportDTO serviceOrderReportDTO = new ServiceOrderReportDTO();
		
		Serviceorder so = new Serviceorder();
		if(soid!=null) {
			Optional<Serviceorder> soO = serviceorderDao.findById(soid);
			if(soO.isPresent()) {
				so = soO.get();
			}
		}
		
		List<ServiceorderDetails> serviceOrderDetails = new ArrayList<>();
		if(so!=null) {
			serviceOrderDetails = serviceOrderDetailsDao.findBySoid(soid);
		}
		
		//Fetching details of VendorMaster by vendorId present in the ServiceOrder table
		VendorMaster vendor = new VendorMaster();
		if(so.getVendorId()!=null) {
			Optional<VendorMaster> vendorO = vendorDao.findById(so.getVendorId());
			if(vendorO.isPresent()) {
				vendor = vendorO.get();
			}
		}
		
		PaymentMethodMasterforVendor paymentMethod = new PaymentMethodMasterforVendor();
		if(vendor.getPaymentMethodId()!=null) {
			Optional<PaymentMethodMasterforVendor> optional = paymentMethodDao.findById(vendor.getPaymentMethodId());
			if(optional.isPresent()) {
				paymentMethod = optional.get();
			}
		}
		
		PaymentTermsMasterforVendor payTerms = new PaymentTermsMasterforVendor();
		if(vendor.getPaymentTermsId()!=null) {
			Optional<PaymentTermsMasterforVendor> optional = paymentTermDao.findById(vendor.getPaymentTermsId());
			if(optional.isPresent()) {
				payTerms = optional.get();
			}
		}
		
		JurisdictionMasterForVendor juridiction = new JurisdictionMasterForVendor();
		if(vendor.getJurisdictionId()!=null) {
			Optional<JurisdictionMasterForVendor> optional = juridictionDao.findById(vendor.getJurisdictionId());
			if(optional.isPresent()) {
				juridiction = optional.get();
			}
		}
		
		ShippingMethodMasterforVendor shippingMethod = new ShippingMethodMasterforVendor();
		if(vendor.getShippingMethodCodeId()!=null) {
			Optional<ShippingMethodMasterforVendor> optional = shippingDao.findById(vendor.getShippingMethodCodeId());
			if(optional.isPresent()) {
				shippingMethod = optional.get();
			}
		}
		
		DeliveryTermsMasterforVendor deliveryTerms = new DeliveryTermsMasterforVendor();
		if(vendor.getDeliveryTermsId()!=null) {
			Optional<DeliveryTermsMasterforVendor> optional = deliveryTermDao.findById(vendor.getDeliveryTermsId());
			if(optional.isPresent()) {
				deliveryTerms = optional.get();
			}
		}
		
		ContactsDetails contact = new ContactsDetails();
		if(so.getVendorId()!=null) {
			List<ContactsDetails> contactList = contactDao.findByVendorId(so.getVendorId());
			if(!contactList.isEmpty()) {
				contact = contactList.get(0);
			}
		}
		
		serviceOrderReportDTO.setCommisisionarate(vendor.getCommissionerate());
		serviceOrderReportDTO.setContactPerson(contact.getContactPerson());
		serviceOrderReportDTO.setDeliveryDate(so.getDeliveryDate());
		serviceOrderReportDTO.setDeliveryTerms(deliveryTerms.getDescription());
		serviceOrderReportDTO.setDivision(vendor.getDivision());
		serviceOrderReportDTO.setEcc(vendor.getEccNo());
		serviceOrderReportDTO.setGstNumber(vendor.getGstNo());
		serviceOrderReportDTO.setJuridiction(juridiction.getDescription());
//		serviceOrderReportDTO.setPackingType(packingType);
		serviceOrderReportDTO.setPan(vendor.getPanNo());
		serviceOrderReportDTO.setPaymentMethod(paymentMethod.getDescription());
		serviceOrderReportDTO.setPayTerms(payTerms.getDescription());
		serviceOrderReportDTO.setPhoneNumber(contact.getContactNo());
		serviceOrderReportDTO.setServiceOrderDate(so.getOrderDate());
		serviceOrderReportDTO.setServiceOrderId(so.getServiceCode());
		serviceOrderReportDTO.setShippingMode(shippingMethod.getDescription());
		serviceOrderReportDTO.setVendorAddress(vendor.getAddress1()+" "+vendor.getAddress2()+" "+vendor.getCity());
		serviceOrderReportDTO.setVendorFax(contact.getFaxNo());
		serviceOrderReportDTO.setVendorGst(vendor.getGstNo());
		serviceOrderReportDTO.setVendorName(vendor.getVendorName());
		serviceOrderReportDTO.setNotes(so.getNotes());
		
		Double soTotalQnt = 0.0;
		Double grandTotal = 0.0;
		Double cgstTotal = 0.0;
		Double igstTotal = 0.0;
		Double sgstTotal = 0.0;
		List<ServiceOrderItemsDTO> serviceOrderItemsDTO = new ArrayList<>();
		for(ServiceorderDetails sod : serviceOrderDetails) {
			ServiceOrderItemsDTO orderItemsDTO = new ServiceOrderItemsDTO();
			
			orderItemsDTO.setQuantity(sod.getQty());
			orderItemsDTO.setRate(sod.getPrice());
			orderItemsDTO.setServiceDescription(sod.getServiceDescription());
			orderItemsDTO.setUnit(sod.getUnit());
			
			Double orderQnt = sod.getQty();
			Double disc = sod.getDisc();
			Double billQnt = orderQnt;
			Double totalAmt = sod.getAmount();
//			Double billAmt = billQnt * sod.getPrice();
			Double billAmt = totalAmt - ((totalAmt / 100) * disc);
			
			soTotalQnt = soTotalQnt + billAmt;
			
			orderItemsDTO.setTotal(Double.valueOf(df.format(billAmt)));
			serviceOrderItemsDTO.add(orderItemsDTO);
		}
		
		if(vendor.getStateCode().equals(19)) {
			cgstTotal = (soTotalQnt/100) * so.getCgstPer();
			sgstTotal = (soTotalQnt/100) * so.getSgstPer();
			grandTotal = soTotalQnt + cgstTotal + sgstTotal;
		}else {
			grandTotal = soTotalQnt + ((soTotalQnt/100) * so.getIgstPer());
			igstTotal = (soTotalQnt/100) * so.getIgst();
		}
		
		DecimalFormat df = new DecimalFormat("#.##");
		String totalSoQntSA = df.format(soTotalQnt);
		String totalCgstSA = df.format(cgstTotal);
		String totalSgstSA = df.format(sgstTotal);
		String totalIgstSA = df.format(igstTotal);
		String grandTotalSA = df.format(grandTotal);
		
		if(totalSoQntSA!=null)
			serviceOrderReportDTO.setCgstTotal(Double.valueOf(totalCgstSA));
		if(totalSgstSA!=null)
			serviceOrderReportDTO.setSgstTotal(Double.valueOf(totalSgstSA));
		if(totalIgstSA!=null)
			serviceOrderReportDTO.setIgstTotal(Double.valueOf(totalIgstSA));
		if(grandTotalSA!=null)
			serviceOrderReportDTO.setGrandTotal(Double.valueOf(grandTotalSA));
		
		serviceOrderReportDTO.setServiceOrderItemsDTO(serviceOrderItemsDTO);
		
		if(totalSoQntSA!=null)
			serviceOrderReportDTO.setSoTotalQnt(Double.valueOf(totalSoQntSA));
		
		String soTotalQntS = String.valueOf(soTotalQnt).split("\\.")[0];
		
		String amountInWord = purUtil.convert(Long.parseLong(soTotalQntS));
				
		serviceOrderReportDTO.setAmountInWord(amountInWord+" only");
		
		return serviceOrderReportDTO;
	}

}
