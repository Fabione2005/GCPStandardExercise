package com.standard.gcp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	/**
	 *  Validates rut in the format XXXXXXXX-X 
	 */
	public static Boolean rutValidator ( String rut ) {
		Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
		Matcher matcher = pattern.matcher(rut);
		if ( matcher.matches() == false ) return false;
		String[] stringRut = rut.split("-");
		return stringRut[1].toLowerCase().equals(getCheckerDigit(stringRut[0]));
	}
	
	/**
	 * Validates the checker digit
	 */
	public static String getCheckerDigit( String rut ) {
		Integer M=0,S=1;
		Long T = Long.valueOf(rut);
		for (;T!=0;T = (long) Math.floor(T/=10))
			S=(int) ((S+T%10*(9-M++%6))%11);
		return ( S > 0 ) ? String.valueOf(S-1) : "k";	
	}
}
