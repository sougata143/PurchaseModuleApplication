package com.aspl.org.utils;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

@Component
public class PurchaseUtil {

	 private static final String[] tensNames = {
			    "",
			    " ten",
			    " twenty",
			    " thirty",
			    " forty",
			    " fifty",
			    " sixty",
			    " seventy",
			    " eighty",
			    " ninety"
			  };
 
			  private static final String[] numNames = {
			    "",
			    " one",
			    " two",
			    " three",
			    " four",
			    " five",
			    " six",
			    " seven",
			    " eight",
			    " nine",
			    " ten",
			    " eleven",
			    " twelve",
			    " thirteen",
			    " fourteen",
			    " fifteen",
			    " sixteen",
			    " seventeen",
			    " eighteen",
			    " nineteen"
			  };
			  
			 public static String convertLessThanOneThousand(int number) {
			    String soFar;

			    if (number % 100 < 20){
			      soFar = numNames[number % 100];
			      number /= 100;
			    }
			    else {
			      soFar = numNames[number % 10];
			      number /= 10;

			      soFar = tensNames[number % 10] + soFar;
			      number /= 10;
			    }
			    if (number == 0) return soFar;
			    return numNames[number] + " hundred" + soFar;
			  }


			  public static String convert(long number) {
			    // 0 to 999 999 999 999
			    if (number == 0) { return "zero"; }

			    String snumber = Long.toString(number);

			    // pad with "0"
			    String mask = "000000000000";
			    DecimalFormat df = new DecimalFormat(mask);
			    snumber = df.format(number);

			    // XXXnnnnnnnnn
			    int billions = Integer.parseInt(snumber.substring(0,3));
			    // nnnXXXnnnnnn
			    int millions  = Integer.parseInt(snumber.substring(3,6));
			    // nnnnnnXXXnnn
			    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
			    // nnnnnnnnnXXX
			    int thousands = Integer.parseInt(snumber.substring(9,12));

			    String tradBillions;
			    switch (billions) {
			    case 0:
			      tradBillions = "";
			      break;
			    case 1 :
			      tradBillions = convertLessThanOneThousand(billions)
			      + " billion ";
			      break;
			    default :
			      tradBillions = convertLessThanOneThousand(billions)
			      + " billion ";
			    }
			    String result =  tradBillions;

			    String tradMillions;
			    switch (millions) {
			    case 0:
			      tradMillions = "";
			      break;
			    case 1 :
			      tradMillions = convertLessThanOneThousand(millions)
			         + " million ";
			      break;
			    default :
			      tradMillions = convertLessThanOneThousand(millions)
			         + " million ";
			    }
			    result =  result + tradMillions;

			    String tradHundredThousands;
			    switch (hundredThousands) {
			    case 0:
			      tradHundredThousands = "";
			      break;
			    case 1 :
			      tradHundredThousands = "one thousand ";
			      break;
			    default :
			      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
			         + " thousand ";
			    }
			    result =  result + tradHundredThousands;

			    String tradThousand;
			    tradThousand = convertLessThanOneThousand(thousands);
			    result =  result + tradThousand;

			    // remove extra spaces!
			    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");

			  }
			  
			  
			// Strings at index 0 is not used, it is to make array  
			// indexing simple  
			    static String one[] = {"", "one ", "two ", "three ", "four ", 
			        "five ", "six ", "seven ", "eight ", 
			        "nine ", "ten ", "eleven ", "twelve ", 
			        "thirteen ", "fourteen ", "fifteen ", 
			        "sixteen ", "seventeen ", "eighteen ", 
			        "nineteen "
			    }; 
			  
			// Strings at index 0 and 1 are not used, they is to  
			// make array indexing simple  
			    static String ten[] = {"", "", "twenty ", "thirty ", "forty ", 
			        "fifty ", "sixty ", "seventy ", "eighty ", 
			        "ninety "
			    }; 
			  
			// n is 1- or 2-digit number  
			    static String numToWords(int n, String s) { 
			        String str = ""; 
			        // if n is more than 19, divide it  
			        if (n > 19) { 
			            str += ten[n / 10] + one[n % 10]; 
			        } else { 
			            str += one[n]; 
			        } 
			  
			        // if n is non-zero  
			        if (n != 0) { 
			            str += s; 
			        } 
			  
			        return str; 
			    } 
			  
			// Function to print a given number in words  
			 public static String convertToWords(double n) { 
			        // stores word representation of given number n  
			        String out = ""; 
			  
			        // handles digits at ten millions and hundred  
			        // millions places (if any)  
			        out += numToWords((int) (n / 10000000), "crore "); 
			  
			        // handles digits at hundred thousands and one  
			        // millions places (if any)  
			        out += numToWords((int) ((n / 100000) % 100), "lakh "); 
			  
			        // handles digits at thousands and tens thousands  
			        // places (if any)  
			        out += numToWords((int) ((n / 1000) % 100), "thousand "); 
			  
			        // handles digit at hundreds places (if any)  
			        out += numToWords((int) ((n / 100) % 10), "hundred "); 
			  
			        if (n > 100 && n % 100 > 0) { 
			            out += "and "; 
			        } 
			  
			        // handles digits at ones and tens places (if any)  
			        out += numToWords((int) (n % 100), ""); 
			  
			        return out; 
			    } 
			  
			
			  
			  
			  
			  
			  
}
