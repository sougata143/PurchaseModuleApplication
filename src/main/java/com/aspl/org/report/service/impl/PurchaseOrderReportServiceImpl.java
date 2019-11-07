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
import com.aspl.org.report.CrawleyPurchaseOrderReportGenerator;
import com.aspl.org.report.service.PurchaseOrderReportService;
import com.aspl.org.service.PurchaseReportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PurchaseOrderReportServiceImpl implements PurchaseOrderReportService {

	static Date date = new java.util.Date();
	static long time = date.getTime();
	static int randNum = (int) ((int) Math.random() + time);
	String fileName = "invReport";

	@Autowired
	PurchaseReportService purchaseReportService;
	
	@Override
	public Map<String, Object> getPurchaseOrderReport(HttpServletRequest request, String purchaseId) {

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
//				writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdf/crawley_purchase_order" + ".pdf"));
				writer = PdfWriter.getInstance(document, new FileOutputStream("/home/pdf/crawley_purchase_order" + ".pdf"));
				writer.setPdfVersion(PdfWriter.VERSION_1_7);

			} catch (DocumentException e1) {

				e1.printStackTrace();

			} catch (IOException e1) {

				e1.printStackTrace();

			}

			document.open();

			PurchaseOrderReportDTO report = new PurchaseOrderReportDTO();
			List<PurchaseOrderReportItemDTO> reportLines = new ArrayList<>();

			if (!purchaseId.isEmpty() || purchaseId != null || purchaseId != "") {

				report = purchaseReportService.getPurchaseOrderReport(Integer.valueOf(purchaseId));
				reportLines = report.getPurchaseOrderReportItemDTO();

				returnData.put("DTO", report);
				returnData.put("DTO lines", reportLines);
				
			}

			boolean newPage = true;

			
			int lineindex = 0;

			

			//if (numberOfPage <= 1) {

				/////////////////////////// For Single Page ///////////////////////
				document.newPage();

				///////////////// TAX INVOICE TITLE ////////////////////////

				// INVOICE TITLE
				
				// Header 1
				PdfPTable headerTable1 = CrawleyPurchaseOrderReportGenerator.createHeader1(
							report.getPoType()
						);
				document.add(headerTable1);

				// Header 2
				PdfPTable headerTable2 = CrawleyPurchaseOrderReportGenerator.createHeader2();
				document.add(headerTable2);
				
				PdfPTable headerTable3 = CrawleyPurchaseOrderReportGenerator.createHeader3(
							report.getVendorName(),
							report.getVendorPhone(),
							report.getVenodrGst(),
							report.getVendorPan(),
							report.getVendorFax(),
							report.getVendorAddress(),
							report.getPoNumber(),
							report.getPoDate(),
							report.getValidity(),
							report.getDeliveryDate(),
							report.getRevalidateNo(),
							report.getBillTo()
						);
				document.add(headerTable3);
				
				PdfPTable headerTable4 = CrawleyPurchaseOrderReportGenerator.createHeader4(
							report.getContactPerson(),
							report.getVendorPhone(),
							report.getVendorFax(),
							report.getVenodrGst(),
							report.getVendorPan(),
							report.getVendorEmail(),
							report.getIndentNumber(),
							report.getAuthDate(),
							report.getShipTo()
						);
				document.add(headerTable4);
				

				// Description Header
				PdfPTable descHeader = CrawleyPurchaseOrderReportGenerator.createDescriptionTableHead1();
				document.add(descHeader);
				
				Double basicTotalValue = 0.0;
				// Description Table
				for (int i = lineindex; i < reportLines.size(); i++) {

					PurchaseOrderReportItemDTO reportitems = reportLines.get(i);
					
					PdfPTable listItems = CrawleyPurchaseOrderReportGenerator.createDescriptionTable(
								i, 
								reportitems.getItemCode(), 
								reportitems.getItemDescription(),
								reportitems.getItemDescription2(),
								reportitems.getUnit(),
								reportitems.getQuantity(),
								reportitems.getRate(),
								reportitems.getTotal(),
								reportitems.getDiscount()
							);

					document.add(listItems);

					basicTotalValue = basicTotalValue + reportitems.getTotal();
				}
				
				//Basic value section 
				PdfPTable basicValue = CrawleyPurchaseOrderReportGenerator.createBasicValue(
							basicTotalValue
						);
				document.add(basicValue);

				if(report.getPoType().equals("IGST")) {
					PdfPTable IGSTValue = CrawleyPurchaseOrderReportGenerator.createIGSTValue(
							report.getBasicIgst(),
							report.getBasicIgstPer()
						);
					document.add(IGSTValue);
				}
				
				if(report.getPoType().equals("CGST,SGST")) {
					PdfPTable CGSTValue = CrawleyPurchaseOrderReportGenerator.createCGSTValue(
							report.getBasicCgst(),
							report.getBasicCgstPer()
						);
					document.add(CGSTValue);
					
					PdfPTable SGSTValue = CrawleyPurchaseOrderReportGenerator.createSGSTValue(
								report.getBasicSgst(),
								report.getBasicSgstPer()
							);
					document.add(SGSTValue);
				}
				
				PdfPTable totalLine = CrawleyPurchaseOrderReportGenerator.createTotalLine(
							report.getTotalPoQnt(),
							basicTotalValue,
							report.getBasicIgst(),
							report.getBasicCgst(),
							report.getBasicSgst()
						);
				document.add(totalLine);
				
				PdfPTable amtInWordsLine = CrawleyPurchaseOrderReportGenerator.createAmtInWordsLine(
							report.getAmountInWords()
						);
				document.add(amtInWordsLine);
				
				PdfPTable payTermsLine = CrawleyPurchaseOrderReportGenerator.createPayTermsLine(
							report.getPaymentTerms()
						);
				document.add(payTermsLine);
				
				PdfPTable deliveryTermsLine = CrawleyPurchaseOrderReportGenerator.createDeliveryTermsLine(
							report.getDeliveryTerms()
						);
				document.add(deliveryTermsLine);
				
				PdfPTable shippingModeLine = CrawleyPurchaseOrderReportGenerator.createShippingModeLine(
							report.getShippingMethod()
						);
				document.add(shippingModeLine);
				
				PdfPTable paymentMethodLine = CrawleyPurchaseOrderReportGenerator.createPaymentMethodLine(
							report.getPaymentMethod()
						);
				document.add(paymentMethodLine);
				
				PdfPTable packingTypeLine = CrawleyPurchaseOrderReportGenerator.createPackingTypeLine();
				document.add(packingTypeLine);
				
				PdfPTable jurisdictionLine = CrawleyPurchaseOrderReportGenerator.createJurisdictionLine(
							report.getJuridiction()
						);
				document.add(jurisdictionLine);
				
				PdfPTable PANDetailsLine = CrawleyPurchaseOrderReportGenerator.createPANDetailsLine(
							report.getNotes()
						);
				document.add(PANDetailsLine);
				
				PdfPTable signatoryLine = CrawleyPurchaseOrderReportGenerator.createSignatoryLine();
				document.add(signatoryLine);
				
				/*PdfPTable headerBlankLine = createHeaderBlankLine();
				document.add(headerBlankLine);*/
				
				PdfPTable signatureLine = CrawleyPurchaseOrderReportGenerator.createSignatureLine();
				document.add(signatureLine);
				

			//} else {}

			document.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		returnData.put("fileName", "crawley_purchase_order.pdf");
		returnData.put("status", true);
		
		return returnData;
	}

	

}
