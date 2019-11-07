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

public class CrawleyPurchaseIndentReportGenerator {

	///////////////// GENERATED PDF PATH ///////////////////////////////////////////////////////////////////////////////////////////
	static Date date = new java.util.Date();
	
	static long time = date.getTime();
	
	static int randNum = (int) ((int) Math.random() + time);
	
	static String fileName = "crawley-purchase-indent-report";
	
	//public static final String RESULT = "D:/ABHIRUP/emcee_workspace/erpa-v2/src/main/webapp/WEB-INF/pdf/" + fileName + "_" + randNum + ".pdf";
	
	public static final String RESULT = "D:/ABHIRUP_WORKSPACE/ABHIRUP/erp-report-workspace/erpa-v2/src/main/webapp/WEB-INF/purchase-module-report/" + fileName + ".pdf";

	///////////////// HEADER CONSTANT /////////////////////////////////////////////////////////////////////////////////////////////
	
	static String companyName	= "CRAWLEY & RAY (FOUNDERS AND ENGINEERS) PRIVATE LTD.";
	static String compAddress   = "32, Foreshore Road, Howrah - 711103, West Bengal";
	static String reportName 	= "PURCHASE INDENT";
	static String indentNo      = "PID/275/19-20";
	static String indentDate    = "28/06/2019";
	static String validity      = "01/07/2019";
	static String department    = "MELTING";
	static String workOrderNo	= "";
	static String projectCode	= "";
	static String authDateTime	= "";

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
		
		/*
		 * PdfPTable header1 = createHeader1(); document.add(header1);
		 * 
		 * PdfPTable header2 = createHeader2(); document.add(header2);
		 * 
		 * PdfPTable header3 = createHeader3(); document.add(header3);
		 * 
		 * PdfPTable header4 = createHeader4(); document.add(header4);
		 * 
		 * PdfPTable header5 = createHeader5(); document.add(header5);
		 * 
		 * PdfPTable header6 = createHeader6(); document.add(header6);
		 * 
		 * PdfPTable header7 = createHeader7(); document.add(header7);
		 * 
		 * PdfPTable headerBlankLine = createHeaderBlankLine();
		 * document.add(headerBlankLine);
		 * 
		 * PdfPTable descriptionTableHead1 = createDescriptionTableHead1();
		 * document.add(descriptionTableHead1);
		 * 
		 * PdfPTable listItems = createDescriptionTable(); 
		 * document.add(listItems);
		 * 
		 * PdfPTable noteSecion = createNoteSecion(); 
		 * document.add(noteSecion);
		 * 
		 * PdfPTable signatoryLine = createSignatoryLine(); 
		 * document.add(signatoryLine);
		 */
		
		document.close();
		
//		("Report Name : " + reportName + "\nPDF has been generated successfully in this path : \n" + RESULT);
		
	}
	
	public static PdfPTable createHeader1(String indentNo) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{8, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(companyName, Font10Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Indent No", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			if(indentNo!=null && !indentNo.equals("null"))
				para_1.add(new Chunk(": " + indentNo, Font8));
			else
				para_1.add(new Chunk(": ", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader2(String indentDate) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{8, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(compAddress, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Date", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			if(indentDate!=null && indentDate!="9999-09-09" && !indentDate.equals("null"))
				para_1.add(new Chunk(": " + indentDate, Font8));
			else
				para_1.add(new Chunk(": ", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader3(String validityDate) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{8, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
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
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Validity", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			if(validityDate!=null && validityDate!="9999-09-09")
				para_1.add(new Chunk(": " + validityDate, Font8));
			else
				para_1.add(new Chunk(": ", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader4(String department) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{8, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
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
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Department", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			if(department!=null)
				para_1.add(new Chunk(": " + department, Font8));
			else
				para_1.add(new Chunk(": " + " ", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader5(String workOrderNo) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{8, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
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
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Work Order No.", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			if(workOrderNo!=null)
				para_1.add(new Chunk(": " + workOrderNo, Font8));
			else
				para_1.add(new Chunk(": ", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader6(String projectGrp) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{8, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
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
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Project Code", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			if(projectGrp!=null)
				para_1.add(new Chunk(": " + projectGrp, Font8));
			else
				para_1.add(new Chunk(": ", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader7(String authDate) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[]{8, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(reportName, Font9Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Auth Dt. & Time", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			if(authDate!=null && !authDate.equals("null"))
				para_1.add(new Chunk(": " + authDate, Font8));
			else
				para_1.add(new Chunk(": ", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
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
		dataTable.setWidths(new float[]{1, (float) 2.5, 5, 1, 1, 2, 2, 2, 2});
		
		String[] headersLabels = {"SL NO","Item Code","Item Description","Prod. Grp","Unit","Qty Req","Req. Date","In Stock Qty","Pending Indent Qty"};
		
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
			cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			
			dataTable.addCell(cell);
			
		}
		
		return dataTable;
	}
	
	public static PdfPTable createDescriptionTable(Integer sl, String itemCode, String itemDescription, String itemName, String productGroup, String unit, Double reqQnt, Date reqDate, Double inStockQnt, Double pendingIndentQnt) throws DocumentException {
		PdfPTable dataTable = new PdfPTable(9);

		dataTable.setTotalWidth(800);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{1, (float) 2.5, 5, 1, 1, 2, 2, 2, 2});
		
		PdfPCell cell;
		
		////////////// ITEM DETAILS ////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		
		//for(int i=1; i<=16; i++) {
			
			cell_1: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(String.valueOf(sl), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(3);
				//cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_2: {
			
				Paragraph para_2 = new Paragraph();
				if(itemCode!=null && itemName!=null)
					para_2.add(new Chunk(itemCode+" "+itemName, Font7));
				else if(itemCode!=null)
					para_2.add(new Chunk(" "+itemCode, Font7));
				else if(itemName!=null)
					para_2.add(new Chunk(" "+itemName, Font7));
				else
					para_2.add(new Chunk(" ", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(3);
				//cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_3: {
				
				Paragraph para_2 = new Paragraph();
				if(itemDescription!=null)
					para_2.add(new Chunk(itemDescription, Font7));
				else
					para_2.add(new Chunk("", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(3);
				//cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_4: {
				
				Paragraph para_2 = new Paragraph();
				if(productGroup!=null)
					para_2.add(new Chunk(productGroup, Font7));
				else
					para_2.add(new Chunk(" ", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(3);
				//cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_5: {
				
				Paragraph para_2 = new Paragraph();
				if(unit!=null)
					para_2.add(new Chunk(unit, Font7));
				else
					para_2.add(new Chunk("", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(3);
				//cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_6: {
				
				Paragraph para_2 = new Paragraph();
				if(reqQnt!=null)
					para_2.add(new Chunk(String.valueOf(reqQnt), Font7));
				else
					para_2.add(new Chunk(String.valueOf(0), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(3);
				//cell.setBorder(Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_7: {
				
				Paragraph para_2 = new Paragraph();
				if(reqDate!=null)
					para_2.add(new Chunk(String.valueOf(reqDate).split("\\s")[0], Font7));
				else
					para_2.add(new Chunk(String.valueOf(0).split("\\s")[0], Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(3);
				//cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_8: {
			
				Paragraph para_2 = new Paragraph();
				if(inStockQnt!=null)
					para_2.add(new Chunk(String.valueOf(inStockQnt), Font7));
				else
					para_2.add(new Chunk(String.valueOf(0), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(3);
				//cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_9: {
				
				Paragraph para_2 = new Paragraph();
				if(pendingIndentQnt!=null)
					para_2.add(new Chunk(String.valueOf(pendingIndentQnt), Font7));
				else
					para_2.add(new Chunk(String.valueOf(0), Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(3);
				//cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
		
		//}

		return dataTable;
	}
	
	public static PdfPTable createNoteSecion(String notes) throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(800);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Notes:", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			if(notes!=null)
				para_1.add(new Chunk(notes, Font8Bold));
			else
				para_1.add(new Chunk("", Font8Bold));
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
			para_1.add(new Chunk("Powered By", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(45f);
			cell_1.setPadding(3);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Checked By", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(45f);
			cell_1.setPadding(3);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Authorized By", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(45f);
			cell_1.setPadding(3);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
}
