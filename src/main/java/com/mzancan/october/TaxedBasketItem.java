package com.mzancan.october;

import java.math.BigDecimal;

/* 
 * Basic Tax item
 * only concrete class of AsbractBasketItem for simplicity
 */

public class TaxedBasketItem extends AbstractBasketItem
{
	
	private int numberItem;
	private String itemDescription;
	private double unitCost;
	private double basicTaxRate =0;
	
	

	public TaxedBasketItem(int noInstance, String description, double cost, double bRate)
	{
		numberItem =noInstance;
		itemDescription = description;
		unitCost = cost;
		basicTaxRate = bRate;
	}
	
	// getters
	public String getDescription()
	{
		return itemDescription;
	}
	
	
	@Override
	public double getTotalTax()
	{
		return ReceiptHelper.doubleTaxTruncation(numberItem*unitCost*basicTaxRate);
	}
	
	@Override
	public double getTotalCost()
	{
		return ReceiptHelper.doubleSumTruncation((ReceiptHelper.doubleTaxTruncation(numberItem*unitCost*(basicTaxRate)) + numberItem*unitCost));
	}

	@Override
	public String toString() 
	{
		return(this.numberItem + " "+ this.itemDescription + ": " +  String.format("%.2f",this.getTotalCost())); 
	}
	
	

}
