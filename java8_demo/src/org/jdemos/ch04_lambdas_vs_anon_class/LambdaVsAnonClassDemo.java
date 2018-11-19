package org.jdemos.ch04_lambdas_vs_anon_class;

/**
 * The implementation of a functional interface can be represented as a 
 * lambda expression and also as an anonymous class.<br>
 * This demo (with comments) explains in detail why one must use 
 * Lambdas wherever possible.
 * 
 * @author Aditya Karnad
 */
public class LambdaVsAnonClassDemo {
	
	interface LambdaRef {
		
		void singleAbstractMethod();
	}

	public static void main(String[] args) {
		
//		Running a thread with anonymous class...
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println(
						"This is running in a thread with a Runnable instance: " 
				+ this.getClass());
			}
		}).start();
		
		/*
		 * The above code will impact performance! Here's how...
		 * 
		 * ## Anonymous classes are generated as files (org/jdemos/ch02_lambdas/LambdaDemo$1.class)
		 * 
		 * ## If you have 25 lambda expressions in your code translated to anonymous 
		 * class implementations, you generate 25 classes!
		 * 
		 * (Thus far we have just compiled! More happens when we run...)
		 * 
		 * ## As these classes are loaded they take up room in the JVM meta-space.
		 * 
		 * ## During execution, your heap is running with 25 instances of the classes you've used.
		 * 
		 * So use Lambdas wherever you can.
		 */
		
//		Running a thread with lambda...
		new Thread(()-> System.out.println(
				"This is running in a thread with a Lambda!")).start();
		
		
//		Can also be written as
		LambdaRef printingAction = ()-> System.out.println(
				"This is running in a thread with a referenced Lambda!");
		
		new Thread(()->printingAction.singleAbstractMethod()).start();
	}
}