package com.aspl.org.utils;

public class GlobalDefine_ {

	public static String company_prefix = "EPPL";
	public static String interimPrefix = "ICN-";
	public static String sampleinvoicePrefix = "EPUR";
	/*
	 * ---------------KEYWORD-----------------
	 */
	public static String user_Name = "userName";
	public static String empLoyeeId = "empLoyeeId";
	public static String userDept = "UserDept";
	public static String user_Role = "userRole";
	public static String name = "name";
	public static String url = "url";
	//public static String reopen = "active";
	public static String msg = "msg";
	public static String isAlive = "isAlive";

	public static String categoryName = "categoryName";
	public static String subCategoryName = "subCategoryName";
	public static String childCategoryName = "childCategoryName";

	// ----------------------DEPARTMENT----------------------------------------

	/*public static Integer HR = 1;
	public static Integer Sales = 2;
	public static Integer MKT = 3;
	public static Integer PUR = 4;
	public static Integer Stock_QA = 5;
	public static Integer QC = 6;
	public static Integer PROD = 7;
	public static Integer IVT = 8;
	public static Integer PLN = 9;*/

	// ----------------------------------------------------------------------------

	/*
	 * ---------------- MESSAGE-------------
	 */

	public static String exceptionMessage = "ERROR! PLEASE TRY AGAIN AFTER SOMETIME."; // Show the messages at the time exception
	public static String sessionEndMsg = "SESSION END! PLEASE LOGIN AGAIN."; // message when session expire for the user
	public static String updateMsg = "UPDATED SUCCESSFULLY."; // message when update anything successfully
	public static String updateFailedMsg = "FAILED TO UPDATE."; // when update failed
	public static String nullMsg = "INVALID VALUE! PLEASE TRY AGAIN."; // null value passed
	public static String unAuthorised = "UNAUTHORISED USER!!";

	// -----------DATE FORMAT------

	public static String dateFormat = "dd-MM-yyyy";
	public static String dateFormat1 = "yyyy-MM-dd";
	public static String dateFormat2 = "MM-yyyy";
	public static String dateFormat3 = "dd-MM-yyyy HH:mm:ss";

	// --------------------- STATUS -------------------------------------

	public static Integer failed = 0; // for failed
	public static Integer pending = 1; // for pending
	public static Integer success = 2; // for success

	/*
	 * ----------------------- ORDER STATUS -----------
	 */
	public static Integer order_cancelled = 0; // status when order cancelled
	public static Integer order_success = 1; // status when order is successfully placed
	public static Integer order_pending = 2; // status when order is pending
	public static Integer order_final = 3; // status when order is failed

	/*
	 * ---------------------ORDER ITEM STATUS ------------------------------
	 */

	public static Integer item_order_cancelled = 0; // order item details ---> item order cancelled
	public static Integer item_order_success = 1; // order item details ---> item order success
	public static Integer item_order_pending = 2; // order item details ---> item order pending

	public static Integer QC_Failed = 0; // raw item received master and production product(raw material requisition)
											// --> QC failed (FAILED BY QC)
	public static Integer pre_Qc = 1; // raw item received master and production product(raw material requisition) -->
										// PRE QC and not send for QC till now
	public static Integer QC_Pending = 2; // raw item received master and production product(raw material requisition)
											// -- > RAW ITEM PENDING BY QC (UNDER QC)
	public static Integer QC_Success = 3; // raw item received master and production product(raw material requisition)
											// -- > RAW ITEM SUCCESS BY QC (PASSED BY QC)

	public static Integer non_store_order_Success = 3; // NON Store Item received ORDER SUCCESS
	public static Integer non_store_order_pending = 2; // NON Store Item received ORDER PENDING
	public static Integer non_store_order_failed = 0; // NON Store Item received ORDER FAILED

	public static Integer orderAccept = 2; // Status when order accepted after the QC passed the item
	public static Integer orderReject = 1; // Status when Order rejected after the QC
	public static Integer orderPending = 0; // status when item received at the QA

	/*
	 * ---------------------------- TYPES ITEM IN QC-----
	 */

	public static Integer QC_item_type = 0; // raw material under QC
	public static Integer QC_product_type = 1; // Finished good under QC

	// --------------------- DECIMAL FROMAT --------------------------------
	public static String decimal0 = "0"; //decimal upto 0 digits
	public static String decimal1 = "0.0"; //decimal upto 1 digits
	public static String decimal2 = "0.00"; // decimal upto 2 digits
	public static String decimal3 = "0.000"; // decimal upto 3 digits

	
	

	// ---------Batch Process Keywords-------------
	public static String productInformation = "productInformation";
	public static String productCheckList = "productCheckList";
	public static String productFormulation = "productFormulation";
	public static String batchPackingpackaging = "batchPackingpackaging";
	public static String batchPackingMaterial = "batchPackingMaterial";
	public static String batchEquipments = "batchEquipments";
	public static String batchSopFollow = "batchSopFollow";
	public static String batchContactParts = "batchContactParts";
	public static String batchDispensing = "batchDispensing";

	public static String product = "product";
	public static String packing = "packing";
	public static String equipments = "equipments";

	// ------REQUISITION STATUS-------
	public static Integer requisition_pending = 1;
	public static Integer requisition_failed = 0;
	public static Integer requisition_success = 2;

	// ----------- PRODUCTION FOR--------------------

	public static int trade = 1;
	public static int sample = 2;
	public static int both_trade_sample = 3;

	// ------------------- SPECIFICATION TYPE ----------------

	public static int specification_item = 1;
	public static int specification_product = 2;
	public static int specification_inprocess = 3;

	/*-------------------------------------------------------------------------------*/
	public static String issuedRemarks = "ITEM ISSUED";
	
	
	/*----------------------------------ACTIVE AND INACTIVE STATUS--------------------------------------------------------------*/
	public static Integer active = 1;
	public static Integer inActive = 0;
	
	
	/*------------------------------------------------------------------------------------------------------------*/
	public static String incompleteStatus = "INCOMPLETE";
	public static String salesOrderPending = "PENDING";
	
	/*---------------------------------------------------------------------------------------------------------------------*/
	
	
	public static Integer waterID = 424; // purified water id in raw item master table it is fixed because its is lonely
										// raw material which is inhouse production
	public static Integer expiryMonth = 3;
	
	public static double minCreditLimit = 0.0;
	
	
	/*-----------------------------------Payment--------------------------------------------------*/
	
	public static Integer no_payment = 0;
	public static Integer part_payment = 1;
	public static Integer full_payment = 2;
	public static Integer extra_paid = 3;
	
	
	
	public static String IGSTSTATMENT = "GST INVOICE - See Rule 2 of IGST Rules 2017 read with Rule 46 of CGST Rules 2017";
	public static String GSTSTATMENT = "GST INVOICE - See Rule 46 of CGST Rules 2017 & SGST Rules 2017";
	
	
}
