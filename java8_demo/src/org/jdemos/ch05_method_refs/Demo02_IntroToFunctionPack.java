package org.jdemos.ch05_method_refs;

import java.util.function.UnaryOperator;

/**
 * Introduction to the java.util.function package
 * @author Aditya Karnad
 */
public class Demo02_IntroToFunctionPack {

	public static void main(String[] args) {
		
		/*
		 * The below program does exactly what the previous one did, but with a small difference.
		 * Below is an explanation of the difference.
		 * 
		 * The earlier program used a Functional Interface called 'AdditionalChargeCalculator' which we defined.
		 * Did we really need to define a new interface?
		 * 
		 * *** PROBLEM STATEMENT ***
		 * While working with a team on an enterprise system, you can be certain that many other 
		 * developers like you at some point in time have needed to use a functional 
		 * interface where the SAM signature was "float methodName(float input)".
		 * 
		 * So you have named your functional interface "AdditionalChargeCalculator", but no one else 
		 * knows that, and when your team mate needs this, he will most likely create a redundant 
		 * Functional Interface and maybe call it "ChargeAdder" having a SAM with the exact same method 
		 * signature you have in your Interface.
		 * 
		 * *** SOLUTION ***
		 * AVOID creating your own Functional Interfaces!
		 * 
		 * A whole array of Functional Interfaces have already been made available to you in 
		 * the java.util.function package and it comes bundled with JDK8.
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
		 * 
		 * Go through the above page and read-up on these out-of-the-box Functional Interfaces
		 * before proceeding to the Streams chapter.
		 */
		
		//Lets calculate our restaurant bill by adding service charge of 10% to the bill value...
		
		System.out.println("Final bill amount with service charge is: " 
		+ calculateBillAmountWithGloballyKnownFuncInterfaces(800, Demo02_IntroToFunctionPack::serviceChargeCalc));
	}
	
	private static float calculateBillAmountWithGloballyKnownFuncInterfaces(
			float billValue, 
			UnaryOperator<Float> chargeAdder) {
		
		return chargeAdder.apply(billValue);
	}
	
	
	// calculation implementer methods
	
	public static float serviceChargeCalc(float billValue) {
		
		return billValue = billValue + billValue*0.1f;
	}
}