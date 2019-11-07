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

import com.aspl.org.dto.PurchaseIndentReportDTO;
import com.aspl.org.dto.PurchaseIndentReportItemsDTO;
import com.aspl.org.report.CrawleyPurchaseIndentReportGenerator;
import com.aspl.org.report.service.PurchaseIndnetReportService;
import com.aspl.org.service.PurchaseReportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PurchaseIndentReportServiceImpl implements PurchaseIndnetReportService {

	static Date date = new java.util.Date();
	static long time = date.getTime();
	static int randNum = (int) ((int) Math.random() + time);
	String fileName = "invReport";

	@Autowired
	PurchaseReportService purchaseReportService;
	
	@Override 
	public Map<String, Object> getInvoiceReport(HttpServletRequest request, String indentID) {

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
//				writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdf/crawley_purchase_indent" + ".pdf"));
				writer = PdfWriter.getInstance(document, new FileOutputStream("/home/pdf/crawley_purchase_indent" + ".pdf"));
				writer.setPdfVersion(PdfWriter.VERSION_1_7);

			} catch (DocumentException e1) {

				e1.printStackTrace();

			} catch (IOException e1) {

				e1.printStackTrace();

			}

			document.open();

			PurchaseIndentReportDTO report = new PurchaseIndentReportDTO();
			List<PurchaseIndentReportItemsDTO> reportLines = new ArrayList<>();

			if (!indentID.isEmpty() || indentID != null || indentID != "") {

				report = purchaseReportService.getPurchaseIndentReport(Integer.valueOf(indentID));
				reportLines = report.getPurchaseIndentReportItemsDTO();

			}

			boolean newPage = true;

			
			int lineindex = 0;

			

				/////////////////////////// For Single Page ///////////////////////
				document.newPage();

				///////////////// TAX INVOICE TITLE ////////////////////////

				// INVOICE TITLE
				
				// Header 1
				PdfPTable headerTable1 = CrawleyPurchaseIndentReportGenerator.createHeader1(
							report.getIndentCode()
						);
				document.add(headerTable1);

				// Header 2
				PdfPTable headerTable2 = CrawleyPurchaseIndentReportGenerator.createHeader2(
							 String.valueOf(report.getIndentDate()).split("\\s+")[0]
						);
				document.add(headerTable2);
				
				PdfPTable headerTable3 = CrawleyPurchaseIndentReportGenerator.createHeader3(
						 String.valueOf(report.getValidityDate()).split("\\s+")[0]
					);
				document.add(headerTable3);
				
				PdfPTable headerTable4 = CrawleyPurchaseIndentReportGenerator.createHeader4(
						 String.valueOf(report.getDepartment())
					);
				document.add(headerTable4);
				
				PdfPTable headerTable5 = CrawleyPurchaseIndentReportGenerator.createHeader5(
						 report.getWorkOrderNo()
					);
				document.add(headerTable5);
				
				PdfPTable headerTable6 = CrawleyPurchaseIndentReportGenerator.createHeader6(
						report.getProjectCode()
					);
				document.add(headerTable6);
				
				PdfPTable headerTable7 = CrawleyPurchaseIndentReportGenerator.createHeader7(
						String.valueOf(report.getAuthDate())
					);
				document.add(headerTable7);
				
				

				// Description Header
				PdfPTable descHeader = CrawleyPurchaseIndentReportGenerator.createDescriptionTableHead1();
				document.add(descHeader);
				
				// Description Table
				for (int i = lineindex; i < reportLines.size(); i++) {

					PurchaseIndentReportItemsDTO reportitems = reportLines.get(i);
					
					PdfPTable listItems = CrawleyPurchaseIndentReportGenerator.createDescriptionTable(
								i, 
								reportitems.getItemCode(), 
								reportitems.getItemDescription(),
								reportitems.getItemName(),
								reportitems.getProductGrp(), 
								reportitems.getUnit(),
								reportitems.getReqQnt(),
								reportitems.getReqDate(),
								reportitems.getInStockQnt(),
								reportitems.getPendingIndentQnt()
							);

					document.add(listItems);
				}

				 // Note Section
				 PdfPTable noteSecion = CrawleyPurchaseIndentReportGenerator.createNoteSecion(
						 	report.getNote()
						 );
				 document.add(noteSecion);
				 
				 // Signatory Section
				 PdfPTable signatoryLine = CrawleyPurchaseIndentReportGenerator.createSignatoryLine();
				 document.add(signatoryLine);
				


			document.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		returnData.put("fileName", "crawley_purchase_indent.pdf");
		returnData.put("status", true);
		return returnData;
	}

	

}
