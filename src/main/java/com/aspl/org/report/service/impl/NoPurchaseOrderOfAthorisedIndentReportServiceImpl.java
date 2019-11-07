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

import com.aspl.org.dto.PendingPurchaseIndentReportIndentWiseDTO;
import com.aspl.org.dto.PendingPurchaseIndentReportIndentWiseItemDetailsDTO;
import com.aspl.org.report.CrawleyPurchaseIndentPendingReportGenerator;
import com.aspl.org.report.service.NoPurchaseOrderOfAuthorisedIndnetReportService;
import com.aspl.org.service.PurchaseReportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class NoPurchaseOrderOfAthorisedIndentReportServiceImpl implements NoPurchaseOrderOfAuthorisedIndnetReportService {

	static Date date = new java.util.Date();
	static long time = date.getTime();
	static int randNum = (int) ((int) Math.random() + time);
	String fileName = "invReport";

	@Autowired
	PurchaseReportService purchaseReportService;
	
	@Override 
	public Map<String, Object> NoPurchaseOrderOfAuthorisedIndnetReport(HttpServletRequest request, String startDate, String endDate) {

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
//				//writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdf/crawley_pending_purchase_order_of_authorised_indent_report" + ".pdf"));
				writer = PdfWriter.getInstance(document, new FileOutputStream("/home/pdf/crawley_pending_purchase_order_of_authorised_indent_report" + ".pdf"));
				writer.setPdfVersion(PdfWriter.VERSION_1_7);

			} catch (DocumentException e1) {

				e1.printStackTrace();

			} catch (IOException e1) {

				e1.printStackTrace();

			}

			document.open();

			List<PendingPurchaseIndentReportIndentWiseDTO> report = new ArrayList<>();
			List<PendingPurchaseIndentReportIndentWiseItemDetailsDTO> reportLines = new ArrayList<>();

			if ((!startDate.isEmpty() || startDate != null || startDate != "") && (!endDate.isEmpty() || endDate != null || endDate != "")) {

				report = purchaseReportService.getPendingPurchaseOrderOfIndentReportIndentWiseDTO(startDate, endDate);
				
			}

			boolean newPage = true;

			
			int lineindex = 0;

			

				/////////////////////////// For Single Page ///////////////////////
				document.newPage();

				///////////////// TAX INVOICE TITLE ////////////////////////

				// INVOICE TITLE
				
				// Header 1
				PdfPTable headerTable1 = CrawleyPurchaseIndentPendingReportGenerator.createHeader1(
							startDate
						);
				document.add(headerTable1);

				// Header 2
				PdfPTable headerTable2 = CrawleyPurchaseIndentPendingReportGenerator.createHeader2(
							endDate
						);
				document.add(headerTable2);
				
				PdfPTable headerTable3 = CrawleyPurchaseIndentPendingReportGenerator.createHeader3();
				document.add(headerTable3);
				
				// Description Table
				for (int i = lineindex; i < report.size(); i++) {
//					System.out.println(report.get(i).getDepartment());
					// Description Header
					PdfPTable descHeader = CrawleyPurchaseIndentPendingReportGenerator.createDescriptionTableHead1(
								report.get(i).getIndentCode(),
								report.get(i).getIndentDate(),
								report.get(i).getDepartment()
							);
					document.add(descHeader);
					
					// Description Header
					PdfPTable descHeader2 = CrawleyPurchaseIndentPendingReportGenerator.createDescriptionTableHead2();
					document.add(descHeader2);
					
					List<PendingPurchaseIndentReportIndentWiseItemDetailsDTO> reportitemsList = report.get(i).getPendingPurchaseIndentReportIndentWiseItemDetailsDTO();
					
					for(int j = 0 ; j < reportitemsList.size() ; j++) {
						
						PendingPurchaseIndentReportIndentWiseItemDetailsDTO reportitems = reportitemsList.get(j);
						
						PdfPTable listItems = CrawleyPurchaseIndentPendingReportGenerator.createDescriptionTable(
								j+1, 
								reportitems.getItemCode(), 
								reportitems.getItemDescription(),
								reportitems.getItemName(),
								reportitems.getReqQnt(), 
								reportitems.getUnit(),
								reportitems.getLastPoDetails()
							);

					document.add(listItems);
					}
					
					PdfPTable headerBlankLine2 = CrawleyPurchaseIndentPendingReportGenerator.createHeaderBlankLine();
					document.add(headerBlankLine2);
				}

				 // Note Section
				 PdfPTable noteSecion = CrawleyPurchaseIndentPendingReportGenerator.createNoteSecion();
				 document.add(noteSecion);
				 
				 // Signatory Section
				 PdfPTable signatoryLine = CrawleyPurchaseIndentPendingReportGenerator.createSignatoryLine();
				 document.add(signatoryLine);
				


			document.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		returnData.put("fileName", "crawley_pending_purchase_report.pdf");
		returnData.put("status", true);
		return returnData;
	}
	

}
