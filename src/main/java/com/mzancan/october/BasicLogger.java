package com.mzancan.october;

public class BasicLogger implements ILogging
{

	public void logError(String s) 
	{
		System.out.println("ERROR: "+s);
	}
	
	public void logInfo(String s) 
	{
		System.out.println("INFO: "+s);
	}

}
