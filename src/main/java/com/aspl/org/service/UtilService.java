package com.aspl.org.service;

import java.util.Date;
import java.util.Map;

public interface UtilService {

	public String dateFormatConversion(Date date, String format);

	
	public Date stringToDateConversion(String dateStr, String format);

	
	public String generateOrderNumber(int number, String rootCategoryName);

	
	public String generateRMControlNumber(int number, String subCategoryName);

	
	public String getFinancialDate(String type);

	
	public boolean checkInputDataEmpty(Map<String, Object> inputData);

	
	double RoundOffDouble(double value, String format);

	
	String generateInterimControlNo(String prefix);

	String dateFormatConversion(String strDate, String format1, String format2);

	
	String calculateDueDate(String strDate, String creditDays);

	String getMonth(int month);


	String convertDateIntoMedicineFoemat(Date date);

	String getDateFormMonthYear(String month, String year);

	Date getDateAfterGivenMonths(Integer months, Date date);

	String getLastYearDateFromGivenDate(String dateStr, String dateFormat);

	String getFinancialYear();

	String getNoteTypeId(String prefix, String type, Integer number);

	
}
