package com.aspl.org.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.GoodsReceiptNoteRepository;
import com.aspl.org.repository.IndentDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.PurchaseDao;
import com.aspl.org.repository.ServiceorderDao;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.PurchaseCodesGenerationService;

@Service
@Transactional
public class PurchaseCodesGenerationServiceImpl implements PurchaseCodesGenerationService {

	@Autowired
	PurchaseDao purchaseDao;
	
	@Autowired
	IndentDao indentDao;
	
	@Autowired
	GoodsReceiptNoteRepository grnDao;
	
	@Autowired
	ServiceorderDao serviceOrderDao;
	
	@Autowired
	ItemMasterDao itemDao;	
	
	@Autowired
	VendorMasterDao vendorMasterDao;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	
	
	@Override
	public String generatePurchaseOrderCode() {
		
		String purchaseOrderCode = "";
		try {
			//Generating indentCode start
			Long purchaseOrderCount = purchaseDao.count();
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//			(formattedDate);
			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			purchaseOrderCode = "POR/"+(purchaseOrderCount+1)+"/"+currYear+"-"+nextYear;
			//Generating indentCode end
		}catch(Exception e) {
			e.printStackTrace();
		}
		return purchaseOrderCode;
	}

	@Override
	public String generateIndentCode() {
		
		String indentCode = "";
		try {
			//Generating indentCode start
			Long indentCount = indentDao.count(); //getting total number of indents currently present in the indent table
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//			(formattedDate);
			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			indentCode = "PID/"+(indentCount+1)+"/"+currYear+"-"+nextYear;
			//Generating indentCode end
		}catch(Exception e) {
			e.printStackTrace();
		}
		return indentCode;
	}
	
	

	@Override
	public String generateGrnCode() {
		
		String grnNo = "";
		try {
			// generating GRN number start
			Long grnCount = grnDao.count();
						
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); // getting the current year's last two digits

			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			grnNo = "GRP/"+(grnCount+1)+"/"+currYear+"-"+nextYear; 
			// generating GRN number end
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grnNo;
	}

	@Override
	public String generateServiceOrderCode() {
	
		String serviceOrderCode = "";
		try {
			Long serviceOrderCount = serviceOrderDao.count();
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//			(formattedDate);
			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			serviceOrderCode = "SWO/"+(serviceOrderCount+1)+"/"+currYear+"-"+nextYear;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return serviceOrderCode;
	}

	@Override
	public String generateItemCode(String categoryId) {
	
		String itemCode = "";
		try {
			//item code auto generation start
			String categoryFirst = "";
			Long count = itemDao.countByCategoryId2(Integer.valueOf(categoryId));
			
			if(categoryId!=null) {
				categoryFirst = categoryRepo.findById(Integer.valueOf(categoryId)).get().getCategoryName().substring(0, 1);
				itemCode = categoryFirst+"-000"+(count+1);
			}else {
				itemCode = "NA";
			}
			//item code auto generation end
		}catch(Exception e) {
			e.printStackTrace();
		}
		return itemCode;
	}

	@Override
	public String generateVendorCode() {
		String vendorCode = "";
		try {
		Long vendorCount = vendorMasterDao.count();
		
		DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
		String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//				(formattedDate);
		Integer currYear = Integer.valueOf(formattedDate);
		Integer nextYear = currYear+1;
		vendorCode = "VEN/"+(vendorCount+1)+"/"+currYear+"-"+nextYear;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vendorCode;
	}

}
