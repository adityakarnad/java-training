package org.jdemos.ch02_functional_interfaces;


/*
 * We know what a lambda expression is like a "function literal" and that it can be 
 * passed to methods.
 * 
 * But just like a reference of type int can hold 20, can we 
 * have a typed reference for a lambda?
 * 
 * The below interface containing only a single abstract method 
 * can serve as a type for the reference to a lambda defining the method.
 * 
 * Such an interface having only a single abstract method (SAM) is called a functional interface.
 */

interface SomeOperationReturningInteger {
	
	int doOperation(int a, int b);
}

/**
 * Explains Functional references with an example.
 * 
 * @author Aditya Karnad
 */
public class Demo01_FunctionalInterfaces {
	
	public static void main(String[] args) {
		
		int resultWithLambda = 
				doWhateverIsPassed_OnNums(20, 50, (a,b)->(a*4) - (b*2));
		
		System.out.println("Result: " + resultWithLambda);
		
		// Let's have a reference to the lambda and try this again...
		SomeOperationReturningInteger opr = (a,b)->(a*4) - (b*2);
		
		resultWithLambda = 
				doWhateverIsPassed_OnNums(20, 50, opr);
		
		System.out.println("Result (using functional interface): " + resultWithLambda);
		
	}
	
	private static int doWhateverIsPassed_OnNums(int a, int b, SomeOperationReturningInteger opr) {
		
		return opr.doOperation(a, b);
	}
}