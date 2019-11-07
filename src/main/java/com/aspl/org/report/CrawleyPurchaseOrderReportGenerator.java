package com.aspl.org.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.aspl.org.service.UtilService;
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

public class CrawleyPurchaseOrderReportGenerator {
	
	@Autowired
	UtilService utilService;

	///////////////// GENERATED PDF PATH ///////////////////////////////////////////////////////////////////////////////////////////
	static Date date = new java.util.Date();
	
	static long time = date.getTime();
	
	static int randNum = (int) ((int) Math.random() + time);
	
	static String fileName = "crawley-purchase-order-report";
	
	//public static final String RESULT = "D:/ABHIRUP/emcee_workspace/erpa-v2/src/main/webapp/WEB-INF/pdf/" + fileName + "_" + randNum + ".pdf";
	
	public static final String RESULT = "D:/ABHIRUP/emcee_workspace/erpa-v2/src/main/webapp/WEB-INF/crawley-report/purchase/" + fileName + ".pdf";

	///////////////// HEADER CONSTANT /////////////////////////////////////////////////////////////////////////////////////////////
	
	static String companyName		= "CRAWLEY & RAY (FOUNDERS AND ENGINEERS) PRIVATE LTD.";
	static String compAddress   	= "32, Foreshore Road, Howrah - 711103, West Bengal";
	static String phoneNo			= "(033) 26684845";
	static String faxNo				= "(033) 26680487";
	static String emailId			= "crawnray@vsnl.com";	
	static String reportName 		= "PURCHASE ORDER";
	static String acknowledgement 	= "Vendor/Acknowledgement/Accounts/Purchase";
	static String poType			= "PO Type : CGST, SGST";
	
	static String vendorNameAdd    	= "M/s. NEO METALIKS LTD.\n" + 
									  "71, PARK PLAZA, 3E, NORTH BLOCK \n" + 
									  "KOLKATA - 700016 \n" + 
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

		document.setPageSize(PageSize.A4.rotate());
		document.setMargins(10, 10, 10, 10);

		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));

		writer.setPdfVersion(PdfWriter.VERSION_1_7);

		document.open();
		
//		PdfPTable header1 = createHeader1();
//		document.add(header1);
		
		PdfPTable header2 = createHeader2();
		document.add(header2);
		
//		PdfPTable header3 = createHeader3();
//		document.add(header3);
		
//		PdfPTable header4 = createHeader4();
//		document.add(header4);
		
		PdfPTable descriptionTableHead1 = createDescriptionTableHead1();
		document.add(descriptionTableHead1);
		
//		PdfPTable listItems = createDescriptionTable();
//		document.add(listItems);
		
//		PdfPTable basicValue = createBasicValue();
//		document.add(basicValue);
		
//		PdfPTable CGSTValue = createCGSTValue();
//		document.add(CGSTValue);
//		
//		PdfPTable SGSTValue = createSGSTValue();
//		document.add(SGSTValue);
//		
//		PdfPTable totalLine = createTotalLine();
//		document.add(totalLine);
//		
//		PdfPTable amtInWordsLine = createAmtInWordsLine();
//		document.add(amtInWordsLine);
//		
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
//		PdfPTable PANDetailsLine = createPANDetailsLine();
//		document.add(PANDetailsLine);
//		
//		PdfPTable signatoryLine = createSignatoryLine();
//		document.add(signatoryLine);
		
		/*PdfPTable headerBlankLine = createHeaderBlankLine();
		document.add(headerBlankLine);*/
		
//		PdfPTable signatureLine = createSignatureLine();
//		document.add(signatureLine);
		
		document.close();
		
//		System.out.println("Report Name : " + reportName + "\nPDF has been generated successfully in this path : \n" + RESULT);
		
	}
	
	public static PdfPTable createHeader1(String poType) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{7, 3});
		
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
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(acknowledgement, Font10));
			para_1.add(Chunk.NEWLINE);
			para_1.add(Chunk.NEWLINE);
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("PO Type : "+poType, Font8Bold));
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(50f);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
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
	
	public static PdfPTable createHeader3(String vendorName, String vendorPhone, String vendorGst, String vendorPan, String vendorFax, 
			String vendorAddress, String poNum, Date poDate, String validity, Date deliveryDate, String revNo, String billTo) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Vendor Name & Address \n", Font10Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(vendorName + "\n" + vendorAddress, Font9));
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
			para_1.add(new Chunk(billTo,Font9));
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
			para_1.add(new Chunk("PO Ref : "+poNum, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Date : "+String.valueOf(poDate).split("\\s")[0], Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Validity : "+validity.split("\\s")[0], Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Delv. Date : "+String.valueOf(deliveryDate).split("\\s")[0], Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Rev. No : "+revNo, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Date : ", Font9));
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
	
	public static PdfPTable createHeader4(String contactPerson, String phone, String fax, String GST, String pan, String email,
			String indentNo, String authDate, String shipTo) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Kind Attn : "+contactPerson, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Phone : "+phone, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Fax : "+fax, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("GSTIN : "+GST, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("PAN NO : "+pan, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("E-Mail : "+email, Font9));
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
			para_1.add(new Chunk("Shipping Address: \n", Font9Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(shipTo, Font9));
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
			para_1.add(new Chunk("Ind. Ref : "+indentNo , Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("CIN NO : " , Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Auth. Dt. & Time : "+authDate , Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("PO Raised by : " , Font8));
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
		PdfPTable dataTable = new PdfPTable(9);

		dataTable.setTotalWidth(800);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{1, (float) 2.5, 5, 1, 1, (float) 2.5, 2, 2, (float) 2.5});
		
		String[] headersLabels = {"SL NO","Item Code","Item Description","Unit.","Quantity","Unit Weight","Rate","Disc. %","Total"};
		
		for (int index = 0; index < headersLabels.length ; index++) {
			
    		PdfPCell cell;
			
			Paragraph headerParagraph = new Paragraph(headersLabels[index], Font8Bold);
			
			cell = new PdfPCell(headerParagraph);
			cell.setPadding(3);
			if(index == 2) {
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
	
	public static PdfPTable createDescriptionTable(Integer sl, String itemCode, String itemDescription, String itemDescription2, String unit, Double quantity, Double rate, Double total, Double discount) throws DocumentException {
		PdfPTable dataTable = new PdfPTable(9);

		dataTable.setTotalWidth(800);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{1, (float) 2.5, 5, 1, 1, (float) 2.5, 2, 2, (float) 2.5});
		
		PdfPCell cell;
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		////////////// ITEM DETAILS ////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		
//		for(int i=1; i<=6; i++) {
			
			cell_1: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk((sl+1) + "", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_2: {
			
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(itemCode+" "+itemDescription2, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_3: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(itemDescription, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_4: {
				
				Paragraph para_2 = new Paragraph();
				if(unit!=null)
					para_2.add(new Chunk(unit, Font7));
				else
					para_2.add(new Chunk("", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_5: {
				
				Paragraph para_2 = new Paragraph();
				Double quantRound = Double.valueOf(df.format(quantity));
				para_2.add(new Chunk(String.valueOf(quantRound), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_6: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(String.valueOf(0.0), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_7: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(String.valueOf(rate), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_8: {
			
				Paragraph para_2 = new Paragraph();
				Double discountRound = Double.valueOf(df.format(discount));
				
				para_2.add(new Chunk(String.valueOf(discount), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_9: {
				
				Paragraph para_2 = new Paragraph();
				Double qnt = rate * quantity;
				Double discQnt = (rate * quantity)-(rate * ((quantity/100)*discount));
				Double discQntRO = Double.valueOf(df.format(discQnt)); 
				
				para_2.add(new Chunk(String.valueOf(total), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
		
//		}

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
	
	public static PdfPTable createIGSTValue(Double igst, Double igstPer) throws DocumentException {
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
			para_1.add(new Chunk("IGST @ "+igstPer+"%", Font8Bold));
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
			para_1.add(new Chunk(String.valueOf(igst), Font8Bold));
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
	
	public static PdfPTable createCGSTValue(Double cgst, Double cgstPer) throws DocumentException {
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
			para_1.add(new Chunk("CGST @ "+cgstPer+"%", Font8Bold));
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
			para_1.add(new Chunk(String.valueOf(cgst), Font8Bold));
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
	
	public static PdfPTable createSGSTValue(Double sgst, Double scgstPer) throws DocumentException {
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
			para_1.add(new Chunk("SGST 9% Receivable @ "+scgstPer+"%", Font8Bold));
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
			para_1.add(new Chunk(String.valueOf(sgst), Font8Bold));
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
	
	public static PdfPTable createTotalLine(Double totalPoQnt, Double basicTotalValue, Double igst, Double cgst, Double sgst) throws DocumentException {
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
			para_1.add(new Chunk("Total", Font8Bold));
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
			DecimalFormat df = new DecimalFormat("#.##");
			Double totalValue = basicTotalValue+igst+cgst+sgst;
			para_1.add(new Chunk(String.valueOf(df.format(totalValue)), Font9Bold));
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
	
	public static PdfPTable createAmtInWordsLine(String amtInWords) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Amount In Words ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.TOP | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : "+amtInWords.toUpperCase(), Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
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
	
	public static PdfPTable createPaymentMethodLine(String paymentMethod) throws DocumentException {
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
			para_1.add(new Chunk(" : "+paymentMethod, Font8Bold));
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
	
	public static PdfPTable createJurisdictionLine(String juridiction) throws DocumentException {
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
			para_1.add(new Chunk(" : "+juridiction, Font8Bold));
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
	
	public static PdfPTable createPANDetailsLine(String notes) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 1, 1});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("PAN : AAACC9999H", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(60f);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("GSTIN : 19AAACC9999H1ZX", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(60f);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Notes: ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			if(notes!=null)
				para_1.add(new Chunk(notes, Font8Bold));
			else
				para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(60f);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
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
