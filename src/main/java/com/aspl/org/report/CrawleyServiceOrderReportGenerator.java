package com.aspl.org.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CrawleyServiceOrderReportGenerator {

	///////////////// GENERATED PDF PATH ///////////////////////////////////////////////////////////////////////////////////////////
	static Date date = new java.util.Date();
	
	static long time = date.getTime();
	
	static int randNum = (int) ((int) Math.random() + time);
	
	static String fileName = "crawley-service-order-report";
	
	//public static final String RESULT = "D:/ABHIRUP/emcee_workspace/erpa-v2/src/main/webapp/WEB-INF/pdf/" + fileName + "_" + randNum + ".pdf";
	
	public static final String RESULT = "D:/ABHIRUP/ABHIRUP_WORKSPACE/21-08-2019/ERPBootApplication/src/main/resources/pdf/" + fileName + ".pdf";

	///////////////// HEADER CONSTANT /////////////////////////////////////////////////////////////////////////////////////////////
	
	static String companyName		= "CRAWLEY & RAY (FOUNDERS AND ENGINEERS) PRIVATE LTD.";
	static String compAddress   	= "32, Foreshore Road, Howrah - 711103, West Bengal";
	static String phoneNo			= "(033) 26684845";
	static String faxNo				= "(033) 26680487";
	static String emailId			= "crawnray@vsnl.com";	
	static String reportName 		= "SERVICE ORDER";
	
	static String partyNameAdd    	= "M/s SUPRIYA BARUI \n" + 
									  "38/2, BANGLAPARA 1ST BYE LANE, SHIBPUR, \n" + 
									  "HOWRAH - 711104, \n" + 
									  "WEST BENGAL";
	static String billingAdd      	= "Crawley & Ray (Founders and Engineers) Pvt. Ltd.\n" + 
									  "32, Foreshore Road,\n" + 
									  "HOwrah - 711103 \n" + 
									  "West Bengal";
	static String shippingAdd      	= "Crawley & Ray (Founders and Engineers) Pvt. Ltd.\n" + 
			  						  "32, Foreshore Road,\n" + 
			  						  "HOwrah - 711103 \n" + 
			  						  "West Bengal";
	static String notes				= "NEO METALIKS LTD. \n" + 
									  "STATE BANK OF INDIA.\n" + 
									  "COMMERCIAL BRANCH.KOLKATA-16.\n" + 
									  "A/C NO. 30414216418.\n" + 
									  "IFSC NO. SBIN 0007502.";


	///////////////// END OF HEADER CONSTANT //////////////////////////////////////////////////////////////////////////////////////

	///////////////// REQUIRED FONTS //////////////////////////////////////////////////////////////////////////////////////////////
	private static Font Font5 = new Font(Font.FontFamily.HELVETICA, 5, Font.NORMAL);
	private static Font Font5Bold = new Font(Font.FontFamily.HELVETICA, 5, Font.BOLD);
	private static Font Font6 = new Font(Font.FontFamily.HELVETICA, 6, Font.NORMAL);
	private static Font Font6Bold = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD);
	private static Font Font7 = new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL);
	private static Font Font7Bold = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD);
	private static Font Font8 = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);
	private static Font Font8Bold = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
	private static Font Font9 = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);
	private static Font Font9Bold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	private static Font Font10 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
	private static Font Font10Bold = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
	private static Font Font12Red = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
	private static Font Font12Bold = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	
	public static void main(String[] args) throws DocumentException, IOException {
		
		Document document = new Document();

//		document.setPageSize(PageSize.A4.rotate());
		document.setPageSize(PageSize.A4.rotate());
		document.setMargins(10, 10, 10, 10);

		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));

		writer.setPdfVersion(PdfWriter.VERSION_1_7);

		document.open();
		
		PdfPTable header1 = createHeader1();
		document.add(header1);
		
		PdfPTable header2 = createHeader2();
		document.add(header2);
		
//		PdfPTable header3 = createHeader3();
//		document.add(header3);
//		
//		PdfPTable header4 = createHeader4();
//		document.add(header4);
		
		PdfPTable descriptionTableHead1 = createDescriptionTableHead1();
		document.add(descriptionTableHead1);
		
//		PdfPTable listItems = createDescriptionTable();
//		document.add(listItems);
		
//		PdfPTable basicValue = createBasicValue();
//		document.add(basicValue);
		
		/*
		 * PdfPTable CGSTValue = createCGSTValue(); document.add(CGSTValue);
		 * 
		 * PdfPTable SGSTValue = createSGSTValue(); document.add(SGSTValue);
		 */
		
//		PdfPTable totalLine = createTotalLine();
//		document.add(totalLine);
		
//		PdfPTable payTermsLine = createPayTermsLine();
//		document.add(payTermsLine);
//		
//		PdfPTable deliveryTermsLine = createDeliveryTermsLine();
//		document.add(deliveryTermsLine);
//		
//		PdfPTable shippingModeLine = createShippingModeLine();
//		document.add(shippingModeLine);
//		
//		PdfPTable paymentMethodLine = createPaymentMethodLine();
//		document.add(paymentMethodLine);
//		
//		PdfPTable packingTypeLine = createPackingTypeLine();
//		document.add(packingTypeLine);
//		
//		PdfPTable jurisdictionLine = createJurisdictionLine();
//		document.add(jurisdictionLine);
//		
//		PdfPTable amtInWordsLine = createAmtInWordsLine();
//		document.add(amtInWordsLine);
		
//		PdfPTable notesLine = createNotesLine();
//		document.add(notesLine);
		
		PdfPTable footerLine1 = createFooterLine1();
		document.add(footerLine1);
		
		PdfPTable footerLine2 = createFooterLine2();
		document.add(footerLine2);
		
		PdfPTable footerLine3 = createFooterLine3();
		document.add(footerLine3);
		
		PdfPTable footerLine4 = createFooterLine4();
		document.add(footerLine4);
		
		PdfPTable signatoryLine = createSignatoryLine();
		document.add(signatoryLine);
		
		/*PdfPTable headerBlankLine = createHeaderBlankLine();
		document.add(headerBlankLine);*/
		
		PdfPTable signatureLine = createSignatureLine();
		document.add(signatureLine);
		
		document.close();
		
		System.out.println("Report Name : " + reportName + "\nPDF has been generated successfully in this path : \n" + RESULT);
		
	}
	
	public static PdfPTable createHeader1() throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(companyName, Font10Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(compAddress, Font10));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Phone : " + phoneNo, Font10));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Fax : " + faxNo, Font10));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Email : " + emailId, Font10));
			
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(50f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader2() throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(reportName, Font10Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(4);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader3(String vendorName, String vendorAddress, String serviceOrderId, Date serviceDate, Date deliveryDate) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Party Name & Address \n", Font10Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(vendorName+"\n"+vendorAddress, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(60f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Billing Address \n", Font10Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(billingAdd,Font9));
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(60f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Our Ref : "+serviceOrderId, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Date : "+String.valueOf(serviceDate).split("\\s")[0], Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Delv. Date : "+String.valueOf(deliveryDate).split("\\s")[0], Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(60f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader4(String vendorName, String phoneNo, String fax, String gst) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Kind : "+vendorName, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Phone : "+phoneNo, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Fax : "+fax, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("GST : "+gst, Font9));
//			para_1.add(Chunk.NEWLINE);
//			para_1.add(new Chunk("CST : AABCN8514G", Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(60f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font9Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(60f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("" , Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(60f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeaderBlankLine() throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1});

		PdfPCell cell_1;

		Paragraph para_1 = new Paragraph();
		para_1.add(new Chunk("", Font9Bold));
		para_1.add(Chunk.NEWLINE);
		para_1.setSpacingBefore(10);
		para_1.setSpacingAfter(10);

		cell_1 = new PdfPCell(para_1);
		cell_1.setPadding(2);
		cell_1.setBorder(Rectangle.NO_BORDER);
		cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell_1);

		return table;
	}
	
	public static PdfPTable createDescriptionTableHead1() throws DocumentException {
		PdfPTable dataTable = new PdfPTable(6);

		dataTable.setTotalWidth(800);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{1, 5, 1, 1, 1, 2});
		
		String[] headersLabels = {"SL NO","Service Description","Quantity", "Unit", "Rate","Total"};
		
		for (int index = 0; index < headersLabels.length ; index++) {
			
    		PdfPCell cell;
			
			Paragraph headerParagraph = new Paragraph(headersLabels[index], Font8Bold);
			
			cell = new PdfPCell(headerParagraph);
			cell.setPadding(3);
			if(index == 1) {
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			}
			else{
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			}
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			//cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			
			dataTable.addCell(cell);
			
		}
		
		return dataTable;
	}
	
	public static PdfPTable createDescriptionTable(Integer i, String serviceDesc, Double qnt, Double rate, Double total, String unit) throws DocumentException {
		PdfPTable dataTable = new PdfPTable(6);

		dataTable.setTotalWidth(800);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{1, 5, 1, 1, 1, 2});
		
		PdfPCell cell;
		
		////////////// ITEM DETAILS ////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		
			cell_1: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(i + "", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_2: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(serviceDesc, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_3: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(String.valueOf(qnt), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_4: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(String.valueOf(unit), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_5: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(String.valueOf(rate), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_6: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(String.valueOf(total), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
		
		return dataTable;
	}
	
	public static PdfPTable createBasicValue(Double basicValue) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Basic Value ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(":", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(String.valueOf(basicValue), Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createIGSTValue(Double igstTotal) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("IGST @ 18.00%", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(":", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(String.valueOf(igstTotal), Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}

	public static PdfPTable createCGSTValue(Double cgstTotal) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("CGST @ 9.00%", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(":", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(String.valueOf(cgstTotal), Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createSGSTValue(Double sgstTotal) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("SGST 9% Receivable @ 9.00 %", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(":", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(String.valueOf(sgstTotal), Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createTotalLine(Double totalValue) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font9Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Total", Font9Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(":", Font9Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(String.valueOf(totalValue), Font9Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createPayTermsLine(String payTerms) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Pay terms ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : "+payTerms, Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createDeliveryTermsLine(String deliveryTerms) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Delivery Terms ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : "+deliveryTerms, Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createShippingModeLine(String shippingMode) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Shipping Mode ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : "+shippingMode, Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createPaymentMethodLine(String payMethod) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Payment method ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : "+payMethod, Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createPackingTypeLine() throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Packing Type ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createJurisdictionLine(String jurisdiction) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Jurisdiction ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.BOTTOM | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : "+jurisdiction, Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createAmtInWordsLine(String amtInWords) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 8});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Amount In Words", Font9Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(4);
			cell_1.setBorder(Rectangle.BOTTOM | Rectangle.TOP | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : "+amtInWords, Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.BOTTOM | Rectangle.TOP | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createNotesLine(String notes) throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Notes :", Font10Bold));
			para_1.add(Chunk.NEWLINE);
			if(notes!=null)
				para_1.add(new Chunk(notes, Font10Bold));
			else
				para_1.add(new Chunk("", Font10Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(4);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createFooterLine1() throws DocumentException {
		PdfPTable table = new PdfPTable(5);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 2, 1, 2, 3});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("PAN", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : AAACC9999H", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Excise Regn ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(": No", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_5:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.RIGHT | Rectangle.TOP);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createFooterLine2() throws DocumentException {
		PdfPTable table = new PdfPTable(5);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 2, 1, 2, 3});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("E.C.C ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : AAACC9999HXM001", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Range ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : III", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_5:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createFooterLine3() throws DocumentException {
		PdfPTable table = new PdfPTable(5);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 2, 1, 2, 3});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("CST No ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : 19701274241", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Division ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : shibpur New, 39 Rabi", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_5:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createFooterLine4() throws DocumentException {
		PdfPTable table = new PdfPTable(5);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 2, 1, 2, 3});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("LST No ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : VAT:19701274047", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Commision at rate", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : Howrah New", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_5:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createSignatoryLine() throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 1, 1});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Prepared By", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Checked By", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Authorized By", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createSignatureLine() throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 1, 1});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Signature", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(45f);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Signature", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(45f);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Signature", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(45f);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
}
