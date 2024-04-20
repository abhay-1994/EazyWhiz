package com.tyss.easywhiz.GenericUtility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method will return the random number in the form of integer'
	 * 
	 * @return
	 */
	public int getRandomNo() {
		Random r = new Random();
		int random = r.nextInt(500);
		return random;
	}

	/**
	 * This method will return the system date in the form of string.
	 * 
	 * @return
	 */

	public String getSystemDate() {
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}

	/**
	 * this method will return the date in format;
	 * 
	 * @return
	 */

	public String getSystemDateAndTimeInFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date dt = new Date();
		String systemDateInFormat = dateFormat.format(dt);
		return systemDateInFormat;
	}

	/**
	 * This method is used to get the system date and time;
	 * 
	 * @return
	 */
	public String getSystemDateAndTime() {
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		return timeStamp;
	}

}
