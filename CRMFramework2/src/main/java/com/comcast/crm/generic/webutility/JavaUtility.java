package com.comcast.crm.generic.webutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber()
	 {
		 Random ranDom=new Random();
		 int ranDomNumber=ranDom.nextInt(99000);
		 return ranDomNumber;
	 }
	 
	    public String getSystemDateYYYYMM()
	 {
		 Date  dateobj =new Date();
		  
		  SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		  String startDate=sdf.format(dateobj);
		  return startDate;
		  
	 }
		  public String getRequiredDateYYYYDDMM(int days)
		 {
			
			  
			  SimpleDateFormat sim=new SimpleDateFormat("YYYY-MM-dd");
			  Calendar cal=Calendar.getInstance();
			  cal.add(Calendar.DAY_OF_MONTH,days);
			  String endDate=sim.format(cal.getTime());
			  return endDate;
			  
			  
	 }
	 
}
