package com.mzancan.october;

public class TestConversionValues {



	
	public static double conv1(double untrunkated)
	{

		return Math.round(untrunkated * 20.0) / 20.0;
	}
	
	public static double conv2(double untrunkated)
	{

		return Math.ceil(untrunkated * 20.0) / 20.0;
	}
	
	public static void main(String[] args) 
	{
		double Out_1_1 = 0.5;
		double Out_1_2 = 7.125;
		double Out_2_1 = 1.499;
		double Out_3_1 = 4.1985;
		double Out_3_2 = 1.899;
		double Out_3_4 = 0.5625;
		System.out.println(TestConversionValues.conv1(Out_1_1));
		System.out.println(TestConversionValues.conv2(Out_1_1));
		
		System.out.println(TestConversionValues.conv1(Out_1_2));
		System.out.println(TestConversionValues.conv2(Out_1_2));
		
		System.out.println(TestConversionValues.conv1(Out_2_1));
		System.out.println(TestConversionValues.conv2(Out_2_1));
		
		System.out.println(TestConversionValues.conv1(Out_3_1));
		System.out.println(TestConversionValues.conv2(Out_3_1));
		
		System.out.println(TestConversionValues.conv1(Out_3_2));
		System.out.println(TestConversionValues.conv2(Out_3_2));	
		
		System.out.println(TestConversionValues.conv1(Out_3_4));
		System.out.println(TestConversionValues.conv2(Out_3_4));
		
	}

}
