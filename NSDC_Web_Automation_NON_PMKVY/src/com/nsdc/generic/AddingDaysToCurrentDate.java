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
		String parts[]=date.split("/");
		String resultedDay=parts[0];
		char prefix=resultedDay.charAt(0);
		String finalDay = null;
		if(prefix=='0')
		{
			finalDay=resultedDay.replaceAll("0", "");
		}
		else
		{
			finalDay=resultedDay;
		}
		return finalDay;
	}
	public static int gettingCurrentDayOFTheMonth()
	{
		Date today = new Date(); 
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(today); 
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); 
		return dayOfMonth;
	}
	
}
