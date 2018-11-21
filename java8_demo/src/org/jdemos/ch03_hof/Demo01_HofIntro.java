package org.jdemos.ch03_hof;



/*
 * Higher Order Functions = Fancy term for a function that accepts or 
 * returns a function... example below:
 * 
 * Consider a simple 4 operation calculator...
 * 
 * THE USUAL WAY!
 * Methods of this class would be add(float a, float b), 
 * subtract(float a, float b), etc.
 * 
 * i.e. Different methods do different things to the operands, so the only arguments we pass 
 * are the operands themselves.
 * 
 * THE FUN WAY! (Why have 4 methods when just 1 can do?!)
 * the only method of this class operate() accepts not 2 but 3 arguments:
 * 
 * float operate(float a, float b, Operator actionOnOperands)
 * 
 * - first and second are the operands (or inputs)
 * - third argument is the function to be applied to the operands (the action to be taken on the 2 operands)
 * 
 * So we don't need 4 methods, just one method which accepts (in addition to operands) the action (lambda!!!) 
 * of "what to do with the operands passed" will work.
 */

/**
 * Explains what Higher Order Functions (HOFs) are with an example.<br>
 * Shows how HOFs are implemented with lambda expressions.
 * 
 * @author Aditya Karnad
 */
public class Demo01_HofIntro {
	
	public static void main(String[] args) {
		
		System.out.println("Adding 5 and 2: " + doCalculatorOps(5f, 2f, (a,b) -> a+b));
		System.out.println("Subtracting 2 from 5: " + doCalculatorOps(5f, 2f, (a,b) -> a-b));
		System.out.println("Multiplying 5 and 2: " + doCalculatorOps(5f, 2f, (a,b) -> a*b));
		System.out.println("Dividing 5 by 2: " + doCalculatorOps(5f, 2f, (a,b) -> a/b));
	}
	
	
	private static float doCalculatorOps(float op1, float op2, Operator opr) {
		
		return opr.operate(op1, op2);
	}
}

/**
 * This is a functional 
 * @author Aditya Karnad
 */
//@FunctionalInterface
interface Operator {
	
	float operate(float a, float b);
}