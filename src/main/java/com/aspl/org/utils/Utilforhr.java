package com.aspl.org.utils;

import java.text.DateFormatSymbols;

public class Utilforhr {

	
	//public String getMonthForInt;

	public static String getMonthForInt(int m) {
	    String month = "invalid";
	    DateFormatSymbols dfs = new DateFormatSymbols();
	    String[] months = dfs.getMonths();
	    if (m >= 0 && m <= 11 ) {
	        month = months[m];
	    }
	    return month;
	}
	
	
}
