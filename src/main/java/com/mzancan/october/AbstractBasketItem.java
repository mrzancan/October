package com.mzancan.october;


/* general description of basket items
 * they have a number of unit
 * they have a decription 
 * they have a cost 
 * must return a description
 * mest retun a cost
 * 
 * Could be decorated into a lot more components
 */

public abstract class AbstractBasketItem 
{
	public abstract double getTotalCost(); 
	public abstract double getTotalTax();
	public abstract String toString();

}
