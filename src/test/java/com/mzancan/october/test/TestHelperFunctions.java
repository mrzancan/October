package com.mzancan.october.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mzancan.october.ReceiptHelper;

public class TestHelperFunctions {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() 
	{
		double mult = 11.25*0.05;
		System.out.println(mult);
		double mult2 = Math.round(mult * 20.0);
		double mult1 = Math.ceil(mult * 20.0);
		System.out.println(mult1);
		System.out.println(mult2);
		
		assertEquals(ReceiptHelper.doubleTaxTruncation(11.25*0.05),0.6,0);
	}
}
