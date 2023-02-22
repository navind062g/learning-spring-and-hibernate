package com.coding.hibernate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static Date formatDate(String dateString) {
		Date formattedDate = null;
		try 
		{
			if(dateString == null || dateString.isEmpty()) {
				dateString = "2023-01-01 09:00:00.0";
			}
		
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		
			formattedDate = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return formattedDate;
	}

}
