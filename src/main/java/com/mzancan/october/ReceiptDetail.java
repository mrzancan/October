package com.mzancan.october;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceiptDetail 
{
	// Tax Rate
	private double bTaxRate=0;
	// Import Tax Rate
	private double imTaxRate=0; 
	// How to identify if product is imported
	private String imDiscriminator= "imported"; 
	// List of Baskets Items
	private List<AbstractBasketItem> bItems= new ArrayList<AbstractBasketItem>();
	// Total tax per basket 
	private double basketTax =0;
	// Total basket value
	private double basketTotal =0;
    private ILogging lLogger;
	
    static public void main(String[] args)
	{
    	ILogging log = new BasicLogger();
    	ReceiptDetail rDetail = null;
    	try
    	{
    		rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	}
    	catch (Exception e)
    	{
    		log.logError(" problems with ReciptDetail constructor, returning");
    		return;
    	}
    	
    	String[] inputData1 = { "1 book at 12.49",
				"1 music CD at 14.99",
				"1 chocolate bar at 0.85"};
    	
    	rDetail.getBasketDetail(inputData1);
		rDetail.calculateBasketTax();
		rDetail.calculateBasketTotal();
		rDetail.pritnBasket();
		
		rDetail.flashBasket();
    	
    	String[] inputData2 = { 
    			"1 imported box of chocolates at 10.00",
    			"1 imported bottle of perfume at 47.50"};
    	
    	rDetail.getBasketDetail(inputData2);
		rDetail.calculateBasketTax();
		rDetail.calculateBasketTotal();
		rDetail.pritnBasket();
    	
    	rDetail.flashBasket();
    	
		String[] inputData3 = { 
				"1 imported bottle of perfume at 27.99",
				"1 bottle of perfume at 18.99",
				"1 packet of headache pills at 9.75",
				"1 box of imported chocolates at 11.25"
                };
    	
    	rDetail.getBasketDetail(inputData3);
		rDetail.calculateBasketTax();
		rDetail.calculateBasketTotal();
		rDetail.pritnBasket();
		
		rDetail.flashBasket();
	}
      
    
    public ReceiptDetail(ILogging log, double tRate, double imTRate, String discriminator )
    {
    	if (log == null)
    	{
    		throw new InvalidParameterException();
    	}
    	if (discriminator == null)
    	{
    		throw new InvalidParameterException();
    	}
    	lLogger = log;
    	bTaxRate = tRate;
    	imTaxRate = imTRate;
    	imDiscriminator = discriminator;
    }
    
    /* getters */
    
    public double getTotalTax()
    {
    	return basketTax;
    }
    
    public double getTotal()
    {
    	return basketTotal;
    }
    
    public void getBasketDetail(String[] basket)
    {
    	for (String s:basket)
    	{
    		try
    		{
    			AbstractBasketItem nItem = parseInputString(s);
    			bItems.add(nItem);
    		}
    		catch (Exception e)
    		{
    			lLogger.logError("Exception while parsing input basket"+ e.getMessage());
    		}

    	}
    }
    
    private boolean isExempted(String searchable)
    {
    	return ReceiptHelper.isPatternMatched("book", searchable) || 
    			ReceiptHelper.isPatternMatched("chocolate", searchable) ||
    			ReceiptHelper.isPatternMatched("headache", searchable);
    }
    
    private boolean isImported(String searchable)
    {
    	return ReceiptHelper.isPatternMatched(imDiscriminator, searchable);
    }
    
    /* The method below could have lived into a separate Parser Class OR
    *  OR also being implemented as static - passing more parameter
    *  For expediency implemented a public class
    */
    public AbstractBasketItem parseInputString(String s) throws Exception
    {
    	StringBuffer buf = new StringBuffer();
		double priceBVAT = 0;
		int noItems = 0;

	    final Scanner scanner = new Scanner(s);
	    scanner.useDelimiter(" ");
	    try
	    {
	    	noItems = Integer.parseInt((scanner.next().trim()));
	    }
	    catch (Exception e)
	    {
	    	scanner.close();
	    	lLogger.logError("Exception while parsing number of items"+ e.getMessage());
	    	throw e;
	    }
	
	    while (scanner.hasNext())
	    {
	      //assumes the line has a certain structure
	      String value = scanner.next();
	      if (!value.equals("at"))
	      {
	    	  buf.append(value+ " ");
	      }
	      else
	      {
	    	  try
	    	  {
	    		  priceBVAT = Double.parseDouble(scanner.next());
	    	  }
	    	  catch (Exception e)
	    	  {
	    		  scanner.close();
	    		  lLogger.logError("Exception while parsing price of items"+ e.getMessage());
	    		  throw e;
	    	  }
	      }
	    }
	    scanner.close();
	    final Boolean imported = isImported(buf.toString());
	    final boolean exempted = isExempted(buf.toString());
	    double taxRate = 0;
	    
	    taxRate = (exempted? 0.0: 0.1)+(imported? 0.05:0.0);    	
    	return new TaxedBasketItem(noItems, buf.toString().trim(), priceBVAT, taxRate);
    }
    
    
    public void calculateBasketTax()
    {
    	for(AbstractBasketItem item: bItems)
    	{
    		basketTax =ReceiptHelper.doubleSumTruncation( item.getTotalTax()+basketTax );
    	}
    }
    
    public void calculateBasketTotal()
    {
    	for(AbstractBasketItem item: bItems)
    	{
    		basketTotal= ReceiptHelper.doubleSumTruncation( item.getTotalCost() +basketTotal);
    	}
    }
    
    public void pritnBasket()
    {
    	for(AbstractBasketItem item: bItems)
    	{
    		lLogger.logInfo(item.toString());
    	}
    	lLogger.logInfo("Sales Tax: " + String.format("%.2f",this.basketTax));
    	lLogger.logInfo("Total: " +  String.format("%.2f",this.basketTotal));
    	
    }
    
    public void flashBasket()
    {
    	bItems.clear();
    	basketTax = 0;
    	basketTotal = 0;
    }
    
   

}
