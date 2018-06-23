package com.jiju.java8examples;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Paragraph {
	public static String changeDateFormat(String paragraph) {
		//throw new UnsupportedOperationException("Waiting to be implemented.");
		String dates[]= getDatestoFormat(paragraph);
		String[] formattedDates = getFormattedDates(dates);
		
		return constructParagraph(formattedDates, paragraph);
	}

	public static void main(String[] args) {
		System.out.println(changeDateFormat("Last time it rained was on 07/25/2013 and today is 08/09/2013."));
	}
	
	public static String constructParagraph(String[] dates, String paragraph){
		String names[] = paragraph.split(" ");
	    int k=0;
	    String paragra="";
	    for (int i = 0; i < names.length; i++){
	            if(names[i].contains("/")){
	            	names[i] = dates[k];
	            	k++;
	            }
	            paragra += names[i];
	    }
	    return paragra;
	}
	public static String [] getFormattedDates(String[] dates){
		
		String[] formattedDates = new String[3];
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	    String strDate = sdf.format(dates[0]);
	    formattedDates [0]= strDate;
	    strDate = sdf.format(dates[1]);
	    formattedDates [1]=strDate;
	    
	    return formattedDates;

	}
	public static Date getDateFromString(String format, String dateStr) {

        DateFormat formatter = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = (Date) formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
	
	//* Method to parse string for dates
	public static String[] getDatestoFormat(String str){
		int nnames;
	    String names[] = str.split(" ");
	    String[] dates = new String[3];
	    int k=0;
	    
	    for (int i = 0; i < names.length; i++){
	            if(names[i].contains("/")){
	            	dates[k]= names[i];
	            	k++;
	            }
	    }
	    
	    return dates;
	}

    public static String getDate(Date date, String dateFormat) {
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }
}
