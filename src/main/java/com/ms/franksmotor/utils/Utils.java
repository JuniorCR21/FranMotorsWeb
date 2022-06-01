package com.ms.franksmotor.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	private Utils() {
	}
	
	public static boolean validPassword (String password) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
