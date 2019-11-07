package com.aspl.org.report.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.log4j.Logger;


import org.springframework.stereotype.Service;

import com.aspl.org.service.UtilService;
import com.aspl.org.utils.GlobalDefine_;

@Service("utilService")
public class UtilServiceImpl implements UtilService {
	private static final Logger logger = Logger.getLogger(UtilService.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.azure.erpA.service.UtilService#dateFormatConversion(java.util.Date,
	 * java.lang.String)
	 */
	@Override
	public String dateFormatConversion(Date date, String format) {
		String strDate = "";
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat(format);
			strDate = formatDate.format(date);
		} catch (Exception e) {
			strDate = "00-00-0000";
			logger.error("dateFormatConversion ::::::::::::::::::::: " + e);
		}
		return strDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.azure.erpA.service.UtilService#stringToDateConversion(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Date stringToDateConversion(String dateStr, String format) {
		Date date = new Date();
		try {
			SimpleDateFormat df = new SimpleDateFormat(format);
			if(!dateStr.equals("")) {				
				date = df.parse(dateStr);
			} else {
				date = df.parse("00-00-0000");
			}
		} catch (Exception e) {
			logger.error("stringToDateConversion ::::::::::::::::::::: " + e);
		}
		return date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.azure.erpA.service.UtilService#generateOrderNumber(int,
	 * java.lang.String)
	 */
	@Override
	public String generateOrderNumber(int number, String orderCode) {
		int nextNumber = number +1;
		logger.info("CURRENT NUMBER :::::::::::::::::::::::::: "+number);
		logger.info("NEXT NUMBER  :::::::::::::::::::::::::::::: "+nextNumber);
		
		String orderNo = "";
		try {
			//String preFix = rootcategoryName.substring(0, 2).toUpperCase();
			int month = Calendar.getInstance().get(Calendar.MONTH);
			if (month > 2) {
				orderNo = GlobalDefine_.company_prefix + "/" + orderCode + "/" + (number + 1) + "/"
						+ Calendar.getInstance().get(Calendar.YEAR) + "-"
						+ (Calendar.getInstance().get(Calendar.YEAR) + 1) % 100;
			} else {
				orderNo = GlobalDefine_.company_prefix + "/" + orderCode + "/" + (number + 1) + "/"
						+ (Calendar.getInstance().get(Calendar.YEAR) - 1) + "-"
						+ (Calendar.getInstance().get(Calendar.YEAR)) % 100;
			}
			logger.info("ORDER NUMBER >>>>------------->> " + orderNo);
		} catch (Exception e) {
			orderNo = "ORD/00000/0000";
			logger.error("generateOrderNumber ::::::::::::::::::::: " + e);
		}
		return orderNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.azure.erpA.service.UtilService#generateRMControlNumber(int,
	 * java.lang.String)
	 */
	@Override
	public String generateRMControlNumber(int number, String subCategoryName) {
		String controlNumber = "";
		String prefix = "";
		try {

			if (subCategoryName.equals("Packing") || subCategoryName.equals("Packaging")) {
				//prefix = "P-" + (number + 1);
				prefix = "P-" + (number);
			} else {
				//prefix = String.valueOf((number + 1));
				prefix = String.valueOf((number));
			}

			int month = Calendar.getInstance().get(Calendar.MONTH);
			controlNumber = prefix + "/" + Calendar.getInstance().get(Calendar.YEAR);
			/*if (month > 2) {
				controlNumber = prefix + "/" + Calendar.getInstance().get(Calendar.YEAR) + "-" + (Calendar.getInstance().get(Calendar.YEAR) + 1) % 100;
			} else {
				controlNumber = prefix + "/" + (Calendar.getInstance().get(Calendar.YEAR) - 1) + "-" + (Calendar.getInstance().get(Calendar.YEAR)) % 100;
			}*/
		} catch (Exception e) {
			controlNumber = "0/0000-0000";
			logger.error("generateRMControlNumber ::::::::::::::::::::: " + e);
		}
		return controlNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.azure.erpA.service.UtilService#getFinancialDate(java.lang.String)
	 */
	@Override
	public String getFinancialDate(String type) {
		String strDate = "";
		String start = "-04-01";
		String end = "-03-31";
		int year = Calendar.getInstance().get(Calendar.YEAR);
		try {
			int month = Calendar.getInstance().get(Calendar.MONTH);
			if (type.equals("Start")) {
				if (month > 2) {
					strDate = year + start;
				} else {
					strDate = (year - 1) + start;
				}
			} else {
				if (month > 2) {
					strDate = (year + 1) + end;
				} else {
					strDate = year + end;
				}
			}
		} catch (Exception e) {
			strDate = "0/0000-0000";
			logger.error("getFinancialDate ::::::::::::::::::::: " + e);
		}
		return strDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.azure.erpA.service.UtilService#checkInputDataEmpty(java.util.Map)
	 */
	@Override
	public boolean checkInputDataEmpty(Map<String, Object> inputData) {
		boolean flag = true;
		try {
			for (Entry<String, Object> entry : inputData.entrySet()) {
				if (entry.getValue() == null || entry.getValue().toString().equals("")) {
					flag = false;
					break;
				}
			}
		} catch (Exception e) {
			flag = false;
			logger.error("checkInputDataEmpty ::::::::::::::::::::: " + inputData);
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.azure.erpA.service.UtilService#RoundOffDouble2(double)
	 */
	@Override
	public double RoundOffDouble(double value, String format) {
		try {
			double val = 0.0;
			DecimalFormat two = new DecimalFormat(format);
			val = Double.parseDouble(two.format(value));
			return val;
		} catch (Exception e) {
			logger.error("RoundOffDouble :::::::::::: " + e);
			return value;
		}
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.azure.erpA.service.UtilService#generateInterimControlNo(java.lang.String)
	 */
	@Override
	public String generateInterimControlNo(String prefix) {
		String controlNo = "";
		try {
			Random r = new Random(System.currentTimeMillis());
			int i = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));

			int month = Calendar.getInstance().get(Calendar.MONTH);
			if (month > 2) {
				controlNo = prefix + i + "/" + Calendar.getInstance().get(Calendar.YEAR) + "-"
						+ (Calendar.getInstance().get(Calendar.YEAR) + 1) % 100;
			} else {
				controlNo = prefix + i + "/" + (Calendar.getInstance().get(Calendar.YEAR) - 1) + "-"
						+ (Calendar.getInstance().get(Calendar.YEAR)) % 100;
			}

		} catch (Exception e) {
			controlNo = "ICN-000000/0000-00";
			logger.error("generateInterimControlNo :::::::::::: " + e);
		}
		return controlNo;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.azure.erpA.service.UtilService#dateFormatConversion(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String dateFormatConversion(String strDate, String format1, String format2) {
		String returnStr = "";
		
		try {
			// create SimpleDateFormat object with source date format
			SimpleDateFormat sdfSource = new SimpleDateFormat(format1);

			// parse the string into Date object
			Date date = sdfSource.parse(strDate);

			// create SimpleDateFormat object with desired date format
			SimpleDateFormat sdfDestination = new SimpleDateFormat(format2);

			// parse the date into another format
			returnStr = sdfDestination.format(date);

		} catch (Exception e) {
			returnStr = null;
			logger.error("dateFormatConversion :::::::::::::::::::::::::::::::::::::::::::::    "+e);			
			
		}		
		return returnStr;
	}
	
	
	public static String generateOrderNumber(int number, String categoryName, String subCategoryName) {
		String orderNo = "";
		try {
			
			
			String preFix = "";
			String prefix1 = "";
			
			if(categoryName.contains(" ")) {
				
				String split[] = categoryName.split(" ");				
				preFix = split[0].substring(0, 1)+split[1].substring(0, 1);

			} else {
				
				preFix = categoryName.substring(0, 3).toUpperCase();
				prefix1 = subCategoryName.substring(0,1).toUpperCase();
				logger.info("prefix1 ::::::::::::    "+prefix1);
			}
			
			
			
			int month = Calendar.getInstance().get(Calendar.MONTH);
			if (month > 2) {
				orderNo = GlobalDefine_.company_prefix + "/" + preFix + prefix1 + "/" + (number + 1) + "/"
						+ Calendar.getInstance().get(Calendar.YEAR) + "-"
						+ (Calendar.getInstance().get(Calendar.YEAR) + 1) % 100;
			} else {
				orderNo = GlobalDefine_.company_prefix + "/" + preFix+prefix1 + "/" + (number + 1) + "/"
						+ (Calendar.getInstance().get(Calendar.YEAR) - 1) + "-"
						+ (Calendar.getInstance().get(Calendar.YEAR)) % 100;
			}
			logger.info("Month >>>>>>>>>>>> " + orderNo);
		} catch (Exception e) {
			orderNo = "ORD/00000/0000";
			logger.error("generateOrderNumber ::::::::::::::::::::: " + e);
		}
		return orderNo;
	}
	/*
	 * (non-Javadoc)
	 * @see com.azure.erpA.service.UtilService#calculateDueDate(java.lang.String, java.lang.String)
	 */
	@Override
	public String calculateDueDate(String strDate, String creditDays) {
		
		try {
			if(!creditDays.equals("Advance")) {
				
				SimpleDateFormat formatDate = new SimpleDateFormat(GlobalDefine_.dateFormat);
				Date date = formatDate.parse(strDate);				
				String days[] = creditDays.split(" ");
				
				Calendar cal=Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DATE, Integer.parseInt(days[0]));
				
				String dueDate = formatDate.format(cal.getTime());
				return dueDate;
			}
			
		} catch (Exception e) {
			logger.info("calculateDueDate ::::::::::::::::::::::::    "+e);
		}
		return "00-00-0000";
	}
	
	@Override
	public String  getMonth(int month) {
		String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
		
		return monthName[(month - 1)];
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.azure.erpA.service.UtilService#convertDateIntoMedicineFoemat(java.util.Date)
	 */
	@Override
	public String convertDateIntoMedicineFoemat(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		logger.info("YEAR --->"+calendar.get(Calendar.YEAR));
		logger.info("Month --->"+calendar.get(Calendar.MONTH));
		
		return (calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR);
	}
	
	@Override
	public String getDateFormMonthYear(String month, String year) {
		
		String date = "";
		
		try {
			
			Date dateObj = new SimpleDateFormat("MMMM").parse(month);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateObj);
			date = (cal.get(Calendar.MONTH) + 1) + "-"+year;
			logger.info("DATE >>>--------->> "+date);
		} catch (Exception e) {
			logger.error("getDateFormMonthYear >>>>---------->> "+e);
		}
		
		return date;
	}
	
	@Override
	public Date getDateAfterGivenMonths(Integer months, Date date) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(date);
			cal.add(Calendar.MONTH, months);
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		} catch (Exception e) {
			logger.error("getDateAfterGivenMonths :::::::::::: " + e);

		}

		return cal.getTime();
	}
	
	@Override
	public String getLastYearDateFromGivenDate(String dateStr, String dateFormat) {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	
			// parse the string into Date object
			Date date = sdf.parse(dateStr);
			
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.YEAR, -1);
			Date newDate = c.getTime();
			
			String returnStr = sdf.format(newDate);
			
			return returnStr;
		} catch (Exception e) {
			logger.error("getLastYearDateFromGivenDate ::::::::::::::::::::: "+e);
			return "00-00-0000";
		}
	
	}
	
	@Override
	public String getFinancialYear() {	
		
		String financeYear = "";
		try {
			//String preFix = rootcategoryName.substring(0, 2).toUpperCase();
			int month = Calendar.getInstance().get(Calendar.MONTH);
			if (month > 2) {
				financeYear =  Calendar.getInstance().get(Calendar.YEAR) %100 + "-"+ (Calendar.getInstance().get(Calendar.YEAR) + 1) % 100;
			} else {
				financeYear = (Calendar.getInstance().get(Calendar.YEAR) - 1)%100 + "-"	+ (Calendar.getInstance().get(Calendar.YEAR)) % 100;
			}
			logger.info("FINANCE YEAR >>>>------------->> " + financeYear);
		} catch (Exception e) {
			financeYear = "ORD/00000/0000";
			logger.error("financeYear ::::::::::::::::::::: " + e);
		}
		return financeYear;
	
	}
	
	public static void main(String[] args) throws ParseException {
		//System.out.println(UtilServiceImpl.generateOrderNumber(1,"Consumable","Factory"));
		//System.out.println(UtilServiceImpl.calculateDueDate(new Date(), "10 days"));
		//Format formatter = new SimpleDateFormat("MMMM"); 
	   // String s = formatter.format(new Date());
	   // System.out.println(s);
		//System.out.println(UtilServiceImpl.getDateAfterGivenMonths1(3,new Date("2018/01/12")));
		
		/*SimpleDateFormat sdfSource = new SimpleDateFormat(GlobalDefine_.dateFormat);

		// parse the string into Date object
		Date date = sdfSource.parse("01-02-2019");
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, -1);
		Date newDate = c.getTime();
		
		String returnStr = sdfSource.format(newDate);
		
		System.out.println(returnStr);*/
		
		/*Date date = Calendar.getInstance().getTime();  
		SimpleDateFormat sdfSource = new SimpleDateFormat("dd-mm-yyyy");
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String strDate = sdfSource.format(date);  
        System.out.println("Converted String: " + strDate); */
		
		//System.out.println(UtilServiceImpl.getFinancialYear());
        
	}
	
	
	@Override
	public String getNoteTypeId(String prefix, String type, Integer number) {
		
		DateFormat df = new SimpleDateFormat("MMYY");
		Date date = new Date();
		String dtStr=df.format(date);
		
		 String noteTypeFinalId = "";
		 String typePrefix = "";
		try {
			logger.info("type:::::::>>>>>>" +type +"number::::::::::::::>>>" +number);
			if(type.equalsIgnoreCase("Credit")) {
				typePrefix = "C";
			}
			
			if(type.equalsIgnoreCase("Debit")) {
				typePrefix = "D";
			}
			  noteTypeFinalId =typePrefix +dtStr+ prefix +(number+1);
	           logger.info("noteTypeFinalId:::::::::::" +noteTypeFinalId);
	           
	        } catch (Exception e) {
	        	logger.error("getNoteTypeId:::::::::::::>>>" +e);
			}
	       
	        return noteTypeFinalId;
	       
		}
		
		
	}


