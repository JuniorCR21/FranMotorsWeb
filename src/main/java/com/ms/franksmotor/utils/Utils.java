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
	
	public static String createUsername(String name, String surname) {
        StringBuilder builder = new StringBuilder();
        String [] values = surname.toLowerCase().split(" ",-2);
        builder.append(name.toLowerCase().charAt(0));
        builder.append(values[0].length() > 6 
                ? values[0].substring(0, 6)
                        : values[0]);
        builder.append(values.length <= 2 
                ? values[1].charAt(0)
                        : "z");
        return builder.toString();
    }
}
