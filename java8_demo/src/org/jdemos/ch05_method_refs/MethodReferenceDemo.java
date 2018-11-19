package org.jdemos.ch05_method_refs;

/**
 * Explains with comments and example why method references are used and how.
 * @author Aditya Karnad
 */
public class MethodReferenceDemo {

	public static void main(String[] args) {
		
		/*
		 * So we now know behavior can be passed as arguments and 
		 * such functions are called higher order functions.
		 * 
		 * We have seen behavior passed as lambdas - but what if 
		 * the behavior is more complex than just a single expression or a print statement?
		 * 
		 * In such cases, it's usually a better practice to simply add your 
		 * behavior / function definition to a method and pass the method as a reference.
		 * 
		 * this is how it's done...
		 */
		
		//Lets calculate our restaurant bill by adding service charge of 10% to the bill value...
		
		System.out.println("Final bill amount with service charge is: " 
		+ calculateBillAmount(800, MethodReferenceDemo::serviceChargeCalc));
	}
	
	private static float calculateBillAmount(
			float billValue, 
			AdditionalChargeCalculator charge01) {
		
		return charge01.calculateCharge(billValue);
	}
	
	
	// calculation implementer methods
	
	public static float serviceChargeCalc(float billValue) {
		
		return billValue = billValue + billValue*0.1f;
	}
}

interface AdditionalChargeCalculator {
	
	float calculateCharge(float value);
}