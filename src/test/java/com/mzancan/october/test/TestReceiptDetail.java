package com.mzancan.october.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mzancan.october.BasicLogger;
import com.mzancan.october.ILogging;
import com.mzancan.october.ReceiptDetail;
import com.mzancan.october.TaxedBasketItem;

public class TestReceiptDetail
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	@Test
	public void Parsing_1_1() 
	{
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	String s = "1 book at 12.49";
    	TaxedBasketItem ub = null;
    	try
    	{
    		ub= (TaxedBasketItem)rDetail.parseInputString(s);
    	}
    	catch (Exception e)
    	{
    		fail(e.getMessage());
    	}
    	assertEquals("book", ub.getDescription() );
    	assertEquals(12.49, ub.getTotalCost(),0 );
	}
	
	@Test
	public void Parsing_1_2() 
	{
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	String s = "1 music CD at 14.99";
    	TaxedBasketItem ub= null;
    	try
    	{
    		ub= (TaxedBasketItem)rDetail.parseInputString(s);
    	}
    	catch (Exception e)
    	{
    		fail(e.getMessage());
    	}
    	assertEquals("music CD", ub.getDescription() );
    	assertEquals(16.49, ub.getTotalCost(),0 );
	}
    	
	@Test
	public void Parsing_1_3() 
	{
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	String s = "1 chocolate bar at 0.85";
    	TaxedBasketItem ub= null;
    	try
    	{
    		ub= (TaxedBasketItem)rDetail.parseInputString(s);
    	}
    	catch (Exception e)
    	{
    		fail(e.getMessage());
    	}
    	assertEquals("chocolate bar", ub.getDescription() );
    	assertEquals(0.85, ub.getTotalCost(),0 );
	}
	
	
	@Test
	public void Parsing_2_1() 
	{
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	String s = "1 imported box of chocolates at 10.00";
    	TaxedBasketItem ub= null;
    	try
    	{
    		ub= (TaxedBasketItem)rDetail.parseInputString(s);
    	}
    	catch (Exception e)
    	{
    		fail(e.getMessage());
    	}
    	assertEquals("imported box of chocolates", ub.getDescription() );
    	assertEquals(10.50, ub.getTotalCost(),0 );
	}

	@Test
	public void Parsing_2_2() 
	{
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	String s = "1 imported bottle of perfume at 47.50";
    	TaxedBasketItem ub= null;
    	try
    	{
    		ub= (TaxedBasketItem)rDetail.parseInputString(s);
    	}
    	catch (Exception e)
    	{
    		fail(e.getMessage());
    	}
    	assertEquals("imported bottle of perfume", ub.getDescription() );
    	assertEquals(54.65, ub.getTotalCost(),0 );
	}
	
	
	@Test
	public void Parsing_3_1() 
	{
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	String s = "1 imported bottle of perfume at 27.99";
    	TaxedBasketItem ub= null;
    	try
    	{
    		ub= (TaxedBasketItem)rDetail.parseInputString(s);
    	}
    	catch (Exception e)
    	{
    		fail(e.getMessage());
    	}
    	assertEquals("imported bottle of perfume", ub.getDescription() );
    	assertEquals(32.19, ub.getTotalCost(),0 );
	}
	
	@Test
	public void Parsing_3_2() 
	{
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	String s = "1 bottle of perfume at 18.99";
    	TaxedBasketItem ub= null;
    	try
    	{
    		ub= (TaxedBasketItem)rDetail.parseInputString(s);
    	}
    	catch (Exception e)
    	{
    		fail(e.getMessage());
    	}
    	assertEquals("bottle of perfume", ub.getDescription() );
    	assertEquals(20.89, ub.getTotalCost(),0 );
	}
	
	@Test
	public void Parsing_3_3() 
	{
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	String s = "1 packet of headache pills at 9.75";
    	TaxedBasketItem ub= null;
    	try
    	{
    		ub= (TaxedBasketItem)rDetail.parseInputString(s);
    	}
    	catch (Exception e)
    	{
    		fail(e.getMessage());
    	}
    	assertEquals("packet of headache pills", ub.getDescription() );
    	assertEquals(9.75, ub.getTotalCost(),0 );
	
	}
	
	@Test
	public void Parsing_3_4() 
	{
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
    	String s = "1 box of imported chocolates at 11.25";
    	TaxedBasketItem ub= null;
    	try
    	{
    		ub= (TaxedBasketItem)rDetail.parseInputString(s);
    	}
    	catch (Exception e)
    	{
    		fail(e.getMessage());
    	}
    	assertEquals("box of imported chocolates", ub.getDescription() );
    	assertEquals(11.85, ub.getTotalCost(),0 );

	}
	
	
	@Test
	public void testingTaxBasket_1()
	{
		String[] inputData = { "1 book at 12.49",
				"1 music CD at 14.99",
				"1 chocolate bar at 0.85"};
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
		rDetail.getBasketDetail(inputData);
		rDetail.calculateBasketTax();
		rDetail.calculateBasketTotal();
		assertEquals(1.50, rDetail.getTotalTax(),0);
		assertEquals(29.83, rDetail.getTotal(),0);
	}
	
	@Test
	public void testingTaxBasket_2()
	{
		String[] inputData = { 
	"1 imported box of chocolates at 10.00",
	"1 imported bottle of perfume at 47.50"};
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
		rDetail.getBasketDetail(inputData);
		rDetail.calculateBasketTax();
		rDetail.calculateBasketTotal();
		assertEquals(7.65, rDetail.getTotalTax(),0);
		assertEquals(65.15, rDetail.getTotal(),0);
	}
	
	@Test
	public void testingTaxBasket_3()
	{
		String[] inputData = { 
				"1 imported bottle of perfume at 27.99",
				"1 bottle of perfume at 18.99",
				"1 packet of headache pills at 9.75",
				"1 box of imported chocolates at 11.25"
                };
		ILogging log = new BasicLogger(); 
		ReceiptDetail rDetail = new ReceiptDetail(log, 0.1, 0.05, "imported");
		rDetail.getBasketDetail(inputData);
		rDetail.calculateBasketTax();
		rDetail.calculateBasketTotal();
		assertEquals(6.70, rDetail.getTotalTax(),0);
		assertEquals(74.68, rDetail.getTotal(),0);
	}
	
}