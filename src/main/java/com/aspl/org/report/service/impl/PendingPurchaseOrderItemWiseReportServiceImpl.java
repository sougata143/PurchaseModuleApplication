package com.aspl.org.report.service.impl;

/***/
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.PurchaseOrderReportDTO;
import com.aspl.org.dto.PurchaseOrderReportItemDTO;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.report.CrawleyPendingPurchaseOrderItemWiseReportGenerator;
import com.aspl.org.report.service.PurchaseOrderItemWiseReportService;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.service.PurchaseReportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PendingPurchaseOrderItemWiseReportServiceImpl implements PurchaseOrderItemWiseReportService {

	static Date date = new java.util.Date();
	static long time = date.getTime();
	static int randNum = (int) ((int) Math.random() + time);
	String fileName = "invReport";

	@Autowired
	PurchaseReportService purchaseReportService;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Override
	public Map<String, Object> getPurchaseOrderItemWise(HttpServletRequest request, String itemId, String startDate, String endDate) {

		Map<String, String> param = new HashMap<String, String>();
		Map<String, Object> returnData = new HashMap<String, Object>();

		String RESULT_FILE = request.getServletContext().getRealPath("resources/static/pdf");

		
		try {

			Document document = new Document();

			document.setPageSize(PageSize.A4.rotate());
			document.setMargins(15, 15, 15, 15);

			PdfWriter writer;
//			System.out.println("Result path "+RESULT_FILE);
			try {
//				writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdf/crawley_purchase_order_itemwise" + ".pdf"));
				writer = PdfWriter.getInstance(document, new FileOutputStream("/home/pdf/crawley_purchase_order_itemwise" + ".pdf"));
				writer.setPdfVersion(PdfWriter.VERSION_1_7);

			} catch (DocumentException e1) {

				e1.printStackTrace();

			} catch (IOException e1) {

				e1.printStackTrace();

			}

			document.open();

			List<PurchaseOrderReportDTO> report = new ArrayList<>();
			List<PurchaseOrderReportItemDTO> reportLines = new ArrayList<>();

			if ((!itemId.isEmpty() || itemId != null || itemId != "") && (!startDate.isEmpty() || startDate != null || startDate != "") &&
					(!endDate.isEmpty() || endDate != null || endDate != "")) {

				report = purchaseReportService.getPurchaseOrderReportItemWise(startDate, endDate, Integer.valueOf(itemId));
//				reportLines = report.getPurchaseOrderReportItemDTO();
				
			}

			boolean newPage = true;

			
			int lineindex = 0;

			

			//if (numberOfPage <= 1) {

				/////////////////////////// For Single Page ///////////////////////
				document.newPage();

				///////////////// TAX INVOICE TITLE ////////////////////////

				// INVOICE TITLE
				
				// Header 1
				PdfPTable headerTable1 = CrawleyPendingPurchaseOrderItemWiseReportGenerator.createHeader1();
				document.add(headerTable1);

				// Header 2
				PdfPTable headerTable2 = CrawleyPendingPurchaseOrderItemWiseReportGenerator.createHeader2();
				document.add(headerTable2);
				
				PdfPTable headerTable3 = CrawleyPendingPurchaseOrderItemWiseReportGenerator.createHeader3(
							startDate, endDate
						);
				document.add(headerTable3);
				
				ItemMaster item = itemDao.findById(Integer.valueOf(itemId)).get();
				String itemName = item.getItemName();
				String itemNo = item.getItemCode();
				PdfPTable headerTable4 = CrawleyPendingPurchaseOrderItemWiseReportGenerator.createHeader4(
							itemName, itemNo
						);
				document.add(headerTable4);
				

				PdfPTable headerBlankLine = CrawleyPendingPurchaseOrderItemWiseReportGenerator.createHeaderBlankLine();
				document.add(headerBlankLine);
				  
				PdfPTable descriptionTableHead1 = CrawleyPendingPurchaseOrderItemWiseReportGenerator.createDescriptionTableHead1();
				document.add(descriptionTableHead1);
				
				for(int i = 0 ; i < report.size() ; i++) {
					
					reportLines = report.get(i).getPurchaseOrderReportItemDTO();
					
					for(int j = 0 ; j < reportLines.size() ; j++) {
						
						Double orderValue = reportLines.get(j).getQuantity() * reportLines.get(j).getRate();
						
						PdfPTable listItems = CrawleyPendingPurchaseOrderItemWiseReportGenerator.createDescriptionTable(
									report.get(i).getVendorName(),
									report.get(i).getPoNumber(),
									report.get(i).getPoDate(),
									reportLines.get(j).getQuantity(),
									reportLines.get(j).getUnit(),
									orderValue
								); 
						document.add(listItems);
						
					}
				}
				  
				PdfPTable noteSecion = CrawleyPendingPurchaseOrderItemWiseReportGenerator.createNoteSecion(); 
				document.add(noteSecion);
				  
				PdfPTable signatoryLine = CrawleyPendingPurchaseOrderItemWiseReportGenerator.createSignatoryLine(); 
				document.add(signatoryLine);
				

			//} else {}

			document.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		returnData.put("fileName", "crawley_purchase_order_itemwise.pdf");
		returnData.put("status", true);
		
		return returnData;
	}

	

}
