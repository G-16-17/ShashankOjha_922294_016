package com.cognizant.moviecruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String sdate) {
		SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
	    try {
	    	date= sf.parse(sdate);
	    }catch(ParseException e) {
	    	e.printStackTrace();
	    }
		
		return date;
	}
}
