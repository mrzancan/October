package com.mzancan.october;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiptHelper 
{
	public static final int PRECISION = 2;
	
	public static double doubleTaxTruncation(double untrunkated)
	{

		return Math.ceil(untrunkated * 20.0) / 20.0;
	}
	
	public static double doubleSumTruncation(double untrunkated)
	{
		final BigDecimal bd = new BigDecimal(untrunkated);
		BigDecimal rounded = bd.setScale(PRECISION, BigDecimal.ROUND_HALF_UP);
		return rounded.doubleValue();
	}
	
	public static boolean isPatternMatched(String pattern, String searchable)
	{
	      // Pattern object
	      Pattern ptn = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher mtch = ptn.matcher(searchable);
	      if (mtch.find())
	      {
	    	  return true;
	      }
	      return false; 
	}
	
}
