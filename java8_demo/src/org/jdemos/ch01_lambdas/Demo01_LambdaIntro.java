package org.jdemos.ch01_lambdas;

public class Demo01_LambdaIntro {
	
	/*
	 * While calling methods, we are familiar with passing data arguments to it.
	 * But until Java 8 there was no simple way to pass an action / function to it.
	 * A Lambda expression is a best way to represent a function / action / behavior.
	 */
	
	public static void main(String[] args) {
		
		/*
		 * METHOD 1: HARD DEFINITION FOR METHODS...
		 * data passed as arguments to a method who's execution 
		 * is completely defined... meaning it adds two numbers and this 
		 * behavior will always remain same.
		 */
		
		int result = doAddition_OnNums(20, 50);
		/*
		 * The arguments we passed are data literals - meaning they are not referenced by a variable.
		 * They are also not bound to an object.
		 */
		
		System.out.println("Method 2: Result obtained from executing behavior passed to it: " + result);
		
		
		
		/**
		 * METHOD 2: DEFINITION PASSED AS ANONYMOUS CLASS...
		 * data and behavior passed as arguments to a method who's execution depends on
		 * another argument which determines the behavior... meaning the method does 
		 * not have defined behavior - it executes the behavior passed to it
		 * as argument.
		 */
		int resultWithAnonClass = doWhateverIsPassed_OnNums(
				20, 
				50, 
				new SomeOperationReturningInteger() {
			
					@Override
					public int doOperation(int a, int b) {
						System.out.println("Calculating in an anonymous class instance.");
						return (a*4) - (b*2);
					}
				}
		);
		/* 
		 * 20 and 50 are literals and not bound to an object, but opr (argument passing behavior) 
		 * is bound to an anonymous class instance.
		 */
		
		System.out.println("Method 2: Result obtained from executing behavior passed to it: " + resultWithAnonClass);
		
		
		
		/*
		 * METHOD 3: DEFINITION PASSED AS A LAMBDA
		 * Same as method 2, but the argument passing the behavior is represented as Lambda expression that's not bound to an 
		 * object.
		 * Just like we have data literals 20 and 50, think of this as a "behavior literal" which is syntactically represented
		 * as "(operands separated by commas) -> {operation definition with operands}".
		 */
		
		int resultWithLambda01 = doWhateverIsPassed_OnNums(
					20, 
					50, 
					(int a,int b) 				//(a,b) = operands
					-> 							//-> passed to
					{
						return (a*4) - (b*2);	//method body providing definition (using operands)
					}
				);
		
		System.out.println("Method 3A: Result obtained from executing lambda expression passed to it: " + resultWithLambda01);
		
		//the above lambda expression can be made shorter...
		
		int resultWithLambda02 = doWhateverIsPassed_OnNums(
				20, 
				50, 
				(a,b) 						//(a,b) = operands
				-> 							//-> passed to
				{
					return (a*4) - (b*2);	//method body providing definition (using operands)
				}
			);
		
		System.out.println("Method 3B: Result obtained from executing lambda expression passed to it: " + resultWithLambda02);
		
		//removing blocks and return since definition is a single line.
		
		int resultWithLambda03 = doWhateverIsPassed_OnNums(
				20, 
				50, 
				(a,b) 				//(a,b) = operands
				-> 					//-> passed to
				(a*4) - (b*2)		//method body 	
			);
		
		System.out.println("Method 3C: Result obtained from executing lambda expression passed to it: " + resultWithLambda03);
	}
	
	private static int doAddition_OnNums(int a, int b) {
		
		return a+b;
	}
	
	private static int doWhateverIsPassed_OnNums(int a, int b, SomeOperationReturningInteger opr) {
		
		return opr.doOperation(a, b);
	}
}


interface SomeOperationReturningInteger {
	
	int doOperation(int a, int b);
}
