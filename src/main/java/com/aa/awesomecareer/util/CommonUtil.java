package com.aa.awesomecareer.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonUtil {

	public static boolean isEmpty(List<?> list) {
		return list == null || list.size() == 0;
	}

	public static boolean isEmpty(String s) {
		return s == null || s.isEmpty();
	}
	
	public List<Integer> yearList(){
		List<Integer> years = new ArrayList<Integer>();
		for(int i=1971; i<2022;i++) {
			years.add(i);
		}
		return years;
	}
	
	public List<String> monthList(){
		String[] arr = { "January", "February", "March", "April","May",
				"June","July","August","September","October","November","December" };
		List<String> months = Arrays.asList(arr);
		return months;
	}
	
	public static List<String> genderList(){
		String[] arr = { " ", "Female", "Male", "Other" };
		List<String> genders = Arrays.asList(arr);
		return genders;
	}
	
	public static List<String> relationshipList(){
		String[] arr = { " ", "Married", "Single", "Other" };
		List<String> ralationship = Arrays.asList(arr);
		return ralationship;
	}

}
