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

import com.aspl.org.dto.GoodsReceiptNoteReportDTO;
import com.aspl.org.dto.GoodsReceiptNoteReportItemsDTO;
import com.aspl.org.report.CrawleyGoodsReceiptNoteReportGenerator;
import com.aspl.org.report.service.PurchaseGoodReceiptNoteReportService;
import com.aspl.org.service.PurchaseReportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PurchaseGoodReceiptNoteReportServiceImpl implements PurchaseGoodReceiptNoteReportService {

	static Date date = new java.util.Date();
	static long time = date.getTime();
	static int randNum = (int) ((int) Math.random() + time);
	String fileName = "invReport";

	@Autowired
	PurchaseReportService purchaseReportService;
	
	@Override 
	public Map<String, Object> getPurchaseGoodReceiptNoteReport(HttpServletRequest request, String grnID) {

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
//				writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdf/crawley_grn_report" + ".pdf"));
				writer = PdfWriter.getInstance(document, new FileOutputStream("/home/pdf/crawley_grn_report" + ".pdf"));
				writer.setPdfVersion(PdfWriter.VERSION_1_7);

			} catch (DocumentException e1) {

				e1.printStackTrace();

			} catch (IOException e1) {

				e1.printStackTrace();

			}

			document.open();

			GoodsReceiptNoteReportDTO report = new GoodsReceiptNoteReportDTO();
			List<GoodsReceiptNoteReportItemsDTO> reportLines = new ArrayList<>();

			if (!grnID.isEmpty() || grnID != null || grnID != "") {

				report = purchaseReportService.getGoodsReceiptNoteReport(Integer.valueOf(grnID));
				reportLines = report.getGoodsReceiptNoteReportItemsDTO();

			}

			boolean newPage = true;

			
			int lineindex = 0;

			

				/////////////////////////// For Single Page ///////////////////////
				document.newPage();

				///////////////// TAX INVOICE TITLE ////////////////////////

				// INVOICE TITLE
				
				// Header 1
				PdfPTable headerTable1 = CrawleyGoodsReceiptNoteReportGenerator.createHeader1();
				document.add(headerTable1);

				// Header 2
				PdfPTable headerTable2 = CrawleyGoodsReceiptNoteReportGenerator.createHeader2();
				document.add(headerTable2);
				
				PdfPTable headerTable3 = CrawleyGoodsReceiptNoteReportGenerator.createHeader3(
						 report.getVendorMaster().getVendorName(),
						 report.getVendorMaster().getAddress1(),
						 report.getVendorMaster().getAddress2(),
						 report.getGrnNo(),
						 report.getGrnDate(),
						 report.getPoNo(),
						 report.getPoDate(),
						 report.getInvoiceNo(),
						 report.getInvoiceDate(),
						 report.getDcNo(),
						 report.getDcDate()
					);
				document.add(headerTable3);
				
				PdfPTable headerTable4 = CrawleyGoodsReceiptNoteReportGenerator.createHeader4(
						 report.getTransport(),
						 report.getAuthoriseDate()
					);
				document.add(headerTable4);
				
				
				// Description Header
				PdfPTable descHeader = CrawleyGoodsReceiptNoteReportGenerator.createDescriptionTableHead1();
				document.add(descHeader);
				
				// Description Table
				for (int i = lineindex; i < reportLines.size(); i++) {

					GoodsReceiptNoteReportItemsDTO reportitems = reportLines.get(i);
					
					PdfPTable listItems = CrawleyGoodsReceiptNoteReportGenerator.createDescriptionTable(
								(i+1), 
								reportitems.getItemCode(), 
								reportitems.getItemDescription(),
								reportitems.getItemName(),
								reportitems.getUnit(),
								reportitems.getRateType(),
								reportitems.getWtPerUnit(),
								reportitems.getChallanQnt(),
								reportitems.getReceivedQnt(),
								reportitems.getReceivedWt(),
								reportitems.getAcceptedQnt(),
								reportitems.getRejectedQnt()
							);

					document.add(listItems);
				}

				PdfPTable totalLine = CrawleyGoodsReceiptNoteReportGenerator.createTotalLine(
							report.getTotalAcceptedQnt(),
							report.getTotalChalanQnt(),
							report.getTotalReceivedQnt(),
							report.getTotalReceivedWt(),
							report.getTotalRejectedQnt()
						);
				document.add(totalLine);
				
				PdfPTable headerBlankLine = CrawleyGoodsReceiptNoteReportGenerator.createHeaderBlankLine();
				document.add(headerBlankLine);
				
				 // Note Section
				 PdfPTable noteSecion = CrawleyGoodsReceiptNoteReportGenerator.createNotesLine(
						 	report.getNotes()
						 );
				 document.add(noteSecion);
				 
				 // Signatory Section
				 PdfPTable signatoryLine = CrawleyGoodsReceiptNoteReportGenerator.createSignatoryLine();
				 document.add(signatoryLine);
				 
				 PdfPTable signatureLine = CrawleyGoodsReceiptNoteReportGenerator.createSignatureLine();
				 document.add(signatureLine);
				


			document.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		returnData.put("fileName", "crawley_grn_report.pdf");
		returnData.put("status", true);
		return returnData;
	}

	

}
