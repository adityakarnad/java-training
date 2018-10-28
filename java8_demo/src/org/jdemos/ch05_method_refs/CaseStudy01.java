package org.jdemos.ch05_method_refs;

import java.util.Arrays;
import java.util.List;

public class CaseStudy01 {

	public static void main(String[] args) {
		
		/*
		 * Calculate service charge of 10% and GST of 18%.
		 * Make a list of method references (functional interface type)
		 */
		
		List<AdditionalChargeCalculator> charges = Arrays.asList(
				CaseStudy01::serviceChargeCalc, 
				CaseStudy01::gstCalc
		);
		
		System.out.println("Final bill amount with service charge is: " 
		+ calculateBillAmount(800, charges));
	}
	
	private static float calculateBillAmount(
			float billValue, 
			List<AdditionalChargeCalculator> charges) {
		
		float accumulatedCharges = billValue;
		
		for (AdditionalChargeCalculator charge : charges) {
			
			accumulatedCharges += charge.calculateCharge(billValue);
			System.out.println("acc = " + accumulatedCharges);
		}
		
		return accumulatedCharges;
	}
	
	// calculation implementer methods
	
	public static float serviceChargeCalc(float billValue) {
		
		return billValue * 0.1f;
	}
	
	public static float gstCalc(float billValue) {
		
		return billValue * 0.18f;
	}
}