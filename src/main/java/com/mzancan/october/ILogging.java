package com.mzancan.october;

/* Logging interface that can be used to re-direct 
 * other than console
 */


public interface ILogging 
{
	// one method only, takes String as input
	void logError(String s);
	void logInfo(String s);
}
