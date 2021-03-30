package com.aa.awesomecareer.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

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
	
	public static List<String> occupationList(){
		String[] arr = { "Engineering", "Art/Design", "Management", "Writing","Public Relations",
				"Business Development","Consulting"};
		List<String> occupations = Arrays.asList(arr);
		return occupations;
	}
	public static List<String> countryList(){
		String[] arr = { "Viet Nam", "Singapore", "American"};
		List<String> occupations = Arrays.asList(arr);
		return occupations;
	}


}
