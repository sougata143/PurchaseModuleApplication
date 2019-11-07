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

import com.aspl.org.dto.ServiceOrderItemsDTO;
import com.aspl.org.dto.ServiceOrderReportDTO;
import com.aspl.org.report.CrawleyServiceOrderReportGenerator;
import com.aspl.org.report.service.ServiceOrderReportPdfGenService;
import com.aspl.org.service.ServiceOrderReportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ServiceOrderPDFGenReportServiceImpl implements ServiceOrderReportPdfGenService {

	static Date date = new java.util.Date();
	static long time = date.getTime();
	static int randNum = (int) ((int) Math.random() + time);
	String fileName = "invReport";

	@Autowired
	ServiceOrderReportService serviceReportService;
	
	@Override
	public Map<String, Object> getServiceOrderReport(HttpServletRequest request, String serviceId) {

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
//				writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdf/crawley_service_order" + ".pdf"));
				writer = PdfWriter.getInstance(document, new FileOutputStream("/home/pdf/crawley_service_order" + ".pdf"));
				writer.setPdfVersion(PdfWriter.VERSION_1_7);

			} catch (DocumentException e1) {

				e1.printStackTrace();

			} catch (IOException e1) {

				e1.printStackTrace();

			}

			document.open();

			ServiceOrderReportDTO report = new ServiceOrderReportDTO();
			List<ServiceOrderItemsDTO> reportLines = new ArrayList<>();

			if (!serviceId.isEmpty() || serviceId != null || serviceId != "") {

				report = serviceReportService.getServiceOrderReportDTO(Integer.valueOf(serviceId));
				reportLines = report.getServiceOrderItemsDTO();

			}

			boolean newPage = true;

			
			int lineindex = 0;

			

			//if (numberOfPage <= 1) {

				/////////////////////////// For Single Page ///////////////////////
				document.newPage();

				///////////////// TAX INVOICE TITLE ////////////////////////

				// INVOICE TITLE
				
				// Header 1
				PdfPTable headerTable1 = CrawleyServiceOrderReportGenerator.createHeader1();
				document.add(headerTable1);

				// Header 2
				PdfPTable headerTable2 = CrawleyServiceOrderReportGenerator.createHeader2();
				document.add(headerTable2);
				
				PdfPTable headerTable3 = CrawleyServiceOrderReportGenerator.createHeader3(
							report.getVendorName(),
							report.getVendorAddress(),
							report.getServiceOrderId(),
							report.getServiceOrderDate(),
							report.getDeliveryDate()
						);
				document.add(headerTable3);
				
				PdfPTable headerTable4 = CrawleyServiceOrderReportGenerator.createHeader4(
							report.getContactPerson(),
							report.getPhoneNumber(),
							report.getVendorFax(),
							report.getVendorGst()
							
						);
				document.add(headerTable4);
				

				// Description Header
				PdfPTable descHeader = CrawleyServiceOrderReportGenerator.createDescriptionTableHead1();
				document.add(descHeader);
				
				// Description Table
				for (int i = lineindex; i < reportLines.size(); i++) {

					ServiceOrderItemsDTO reportitems = reportLines.get(i);
					
					PdfPTable listItems = CrawleyServiceOrderReportGenerator.createDescriptionTable(
								(i+1), 
								reportitems.getServiceDescription(), 
								reportitems.getQuantity(),
								reportitems.getRate(),
								reportitems.getTotal(),
								reportitems.getUnit()
							);

					document.add(listItems);
				}
				
				//Basic value section 
				PdfPTable basicValue = CrawleyServiceOrderReportGenerator.createBasicValue(
							report.getSoTotalQnt()
						);
				document.add(basicValue);
				
				PdfPTable IGSTValue = CrawleyServiceOrderReportGenerator.createIGSTValue(
							report.getIgstTotal()
						);
				document.add(IGSTValue);

				PdfPTable CGSTValue = CrawleyServiceOrderReportGenerator.createCGSTValue(
							report.getCgstTotal()
						);
				document.add(CGSTValue);
				
				PdfPTable SGSTValue = CrawleyServiceOrderReportGenerator.createSGSTValue(
							report.getSgstTotal()
						);
				document.add(SGSTValue);
				
				PdfPTable totalLine = CrawleyServiceOrderReportGenerator.createTotalLine(
							report.getGrandTotal()
						);
				document.add(totalLine);
				
				PdfPTable amtInWordsLine = CrawleyServiceOrderReportGenerator.createAmtInWordsLine(
							report.getAmountInWord()
						);
				document.add(amtInWordsLine);
				
				PdfPTable payTermsLine = CrawleyServiceOrderReportGenerator.createPayTermsLine(
							report.getPayTerms()
						);
				document.add(payTermsLine);
				
				PdfPTable deliveryTermsLine = CrawleyServiceOrderReportGenerator.createDeliveryTermsLine(
							report.getDeliveryTerms()
						);
				document.add(deliveryTermsLine);
				
				PdfPTable shippingModeLine = CrawleyServiceOrderReportGenerator.createShippingModeLine(
							report.getShippingMode()
						);
				document.add(shippingModeLine);
				
				PdfPTable paymentMethodLine = CrawleyServiceOrderReportGenerator.createPaymentMethodLine(
							report.getPaymentMethod()
						);
				document.add(paymentMethodLine);
				
				PdfPTable packingTypeLine = CrawleyServiceOrderReportGenerator.createPackingTypeLine();
				document.add(packingTypeLine);
				
				PdfPTable jurisdictionLine = CrawleyServiceOrderReportGenerator.createJurisdictionLine(
							report.getJuridiction()
						);
				document.add(jurisdictionLine);
				
				PdfPTable PANDetailsLine = CrawleyServiceOrderReportGenerator.createNotesLine(
							report.getNotes()
						);
				document.add(PANDetailsLine);
				
				PdfPTable footerLine1 = CrawleyServiceOrderReportGenerator.createFooterLine1();
				document.add(footerLine1);
				
				PdfPTable footerLine2 = CrawleyServiceOrderReportGenerator.createFooterLine2();
				document.add(footerLine2);
				
				PdfPTable footerLine3 = CrawleyServiceOrderReportGenerator.createFooterLine3();
				document.add(footerLine3);
				
				PdfPTable footerLine4 = CrawleyServiceOrderReportGenerator.createFooterLine4();
				document.add(footerLine4);
				
				PdfPTable signatoryLine = CrawleyServiceOrderReportGenerator.createSignatoryLine();
				document.add(signatoryLine);
				
				PdfPTable signatureLine = CrawleyServiceOrderReportGenerator.createSignatureLine();
				document.add(signatureLine);
				
				/*PdfPTable headerBlankLine = createHeaderBlankLine();
				document.add(headerBlankLine);*/
				
				

			//} else {}

			document.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		returnData.put("fileName", "crawley_service_order.pdf");
		returnData.put("status", true);
		
		return returnData;
	}

	

}
