package com.nsdc.generic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddingDaysToCurrentDate
{
	public static String addDaysToCurrentDate(int daysCount)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); 
		c.add(Calendar.DATE, daysCount);
		String date = sdf.format(c.getTime());
		return date;
	}
	
}
