package com.mzancan.october.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import com.mzancan.october.ReceiptHelper;
import com.mzancan.october.TaxedBasketItem;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestTaxedBasketItem {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test_Output_1_1() 
	{
		// 1 music CD at 14.99
		int noInstance = 1;
		String s= "music CD";
		double cost= 14.99;
		double bTR = 0.1;
		double outcome = 16.49;
		String oString = noInstance + " "+ s+ ": "+ outcome;
		TaxedBasketItem ut = new TaxedBasketItem(noInstance, s, cost,bTR);
		
		assertEquals(ut.getDescription(),s);
		assertEquals(ut.getTotalTax(), 1.5, 0);
		assertEquals(ut.getTotalCost(), outcome,0);
		assertEquals(oString, ut.toString());

		// assertEquals(ReceiptHelper.doubleSumTruncation(ut.getTotalTax()+cost), outcome,0);
	}

	
	@Test
	public void test_Output_2_2()
	{
		// 1 imported bottle of perfume: 54.65
		int noInstance = 1;
		String s= "bottle of perfume";
		double cost= 47.50;
		double bTR = 0.15;
		double outcome = 54.65;
		String oString = noInstance + " "+ s+ ": "+ outcome;
		TaxedBasketItem ut = new TaxedBasketItem(noInstance, s, cost,bTR);     
		assertEquals(ut.getDescription(),s);
		assertEquals(ut.getTotalCost(), outcome,0);
		assertEquals(oString, ut.toString());
	}

	

	
	@Test
	public void test_Output_2_1()
	{
		// 1 imported box of chocolates: 10.50
		int noInstance = 1;
		String s= "imported box of chocolated";
		double cost= 10.00;
		double bTR = 0.05;
		double outcome = 10.50;
		String oString = noInstance + " "+ s+ ": "+ outcome;
		TaxedBasketItem ut = new TaxedBasketItem(noInstance, s, cost,bTR);
		System.out.println(ut.getTotalCost());
		System.out.println(ut.toString());
		assertEquals(ut.getDescription(),s);
		assertEquals(ut.getTotalCost(), outcome,0);

	}
		
	@Test
	public void test_pattern_Output_3_1()
	{
		// 1 imported bottle of perfume at 27.99
		int noInstance = 1;
		String s= "imported bottle of perfume";
		double cost = 27.99;
		double bTR = 0.15;
		double outcome = 32.19;
		double tax = 4.2;
		String oString = noInstance + " "+ s+ ": "+ outcome;
		// System.out.println(ut.getTotalCost());
		// System.out.println(ut.getTotalTax());
		TaxedBasketItem ut = new TaxedBasketItem(noInstance, s, cost,bTR);       
		assertEquals(ut.getDescription(),s);
		assertEquals(ut.getTotalCost(), outcome,0);
		assertEquals(ut.getTotalTax(), tax,0);
		assertEquals(oString, ut.toString());

	}	
	
	@Test
	public void test_pattern_Output_3_2()
	{
		// 1 bottle of perfume at 18.99
		int noInstance = 1;
		String s= "bottle of perfume";
		double cost = 18.99;
		double bTR = 0.10;
		double tax = 1.9;
		double outcome = 20.89;
		String oString = noInstance + " "+ s+ ": "+ outcome;
		// System.out.println(ut.getTotalCost());
		// System.out.println(ut.getTotalTax());
		TaxedBasketItem ut = new TaxedBasketItem(noInstance, s, cost,bTR);       
		assertEquals(ut.getDescription(),s);
		assertEquals(ut.getTotalCost(), outcome,0);
		assertEquals(ut.getTotalTax(), tax,0);
		assertEquals(oString, ut.toString());
	}	
	
	@Test
	public void test_pattern_Output_3_3()
	{
		// 1 box of imported chocolates at 11.25
		int noInstance = 1;
		String s= "box on imported chocolates";
		double cost = 9.75;
		double bTR = 0.00;
		double outcome = 9.75;
		String oString = noInstance + " "+ s+ ": "+ outcome;
		TaxedBasketItem ut = new TaxedBasketItem(noInstance, s, cost, bTR);       
		assertEquals(ut.getDescription(),s);
		assertEquals(ut.getTotalCost(), outcome,0);
		assertEquals(ut.getTotalTax(), 0,0);
		assertEquals(oString, ut.toString());
	}	
	
	@Test
	public void test_pattern_Output_3_4()
	{
		// 1 box of imported chocolates at 11.25
		int noInstance = 1;
		String s= "box on imported chocolates";
		double cost = 11.25;
		double bTR = 0.05;
		double outcome = 11.85;
		double tax = 0.6;
		String oString = noInstance + " "+ s+ ": "+ outcome;
		TaxedBasketItem ut = new TaxedBasketItem(noInstance, s, cost,bTR); 
		//System.out.println(ut.getTotalCost());
		//System.out.println(ut.getTotalTax());
		assertEquals(ut.getDescription(),s);
		assertEquals(ut.getTotalCost(), outcome,0);
		assertEquals(ut.getTotalTax(), tax,0);
		assertEquals(oString, ut.toString());
	}		
	

}
