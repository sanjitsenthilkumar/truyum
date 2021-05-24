package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String sDate) throws ParseException {
		Date d = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
		return d;
	}

}
