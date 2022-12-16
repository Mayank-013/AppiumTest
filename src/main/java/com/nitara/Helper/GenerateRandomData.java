package com.nitara.Helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class GenerateRandomData {
	

	public String generateRandomPhoneNo() {
		Faker faker = new Faker(new Locale("en-IND"));
		
		String number = faker.number().digits(10);
		System.out.println(number);
		return number;
		
	}
	
	public String generateRandomNumber(int noOfDigit) {
		Faker faker = new Faker();
		
		String number = faker.number().digits(noOfDigit);
		System.out.println(number);
		return number;
		
	}
	
	
	public String getPastDate(int days) {

		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -(days));
		SimpleDateFormat format = new SimpleDateFormat("dd MMM YYYY");
		String dateValue = format.format(cal.getTime());
		System.out.println(dateValue);
		return dateValue;
		
	}
	
	
	public String getPastDateAPI(int days) throws Exception {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -(days));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateValue = format.format(cal.getTime());
		return dateValue;
	}

}
