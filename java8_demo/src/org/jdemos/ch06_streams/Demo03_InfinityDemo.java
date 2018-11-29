package org.jdemos.ch06_streams;

import java.util.stream.Stream;

public class Demo03_InfinityDemo {

	/*
	 * We know what a stream is a flow of data from a source to a destination?
	 * A stream unlike a collection can also be infinite...
	 * 
	 * An achieve anything meaningful from such a stream, we would need to define boundaries - this 
	 * is done using the limit() method.
	 * 
	 * Here we demonstrate an infinite stream and how to work with it.
	 */
	public static void main(String[] args) {
		
		System.out.println("Simple Integer sequence stream coming up >>>");
		
		Stream<Integer> stream = Stream.iterate(0, i -> i+5);  // The stream has a source here.
		/*
		 * limit here is used to define a boundary to the infinite stream.
		 */
		stream.limit(10)
		.forEach(i -> System.out.println(i));
		
		
		
		/*
		 * Bad news: limit() is the only EASY way to limit infinite streams in Java 8.
		 * Good news: They realised pretty quickly that they need more limiting options 
		 * and provided more ways in Java 9.
		 * 
		 * takeWhile() and dropWhile() were introduced in Java 9 - here's how to use takeWhile().
		 */
		
		
		System.out.println("Mod 2018! stream coming up >>>");
		
		Stream<Long> demoStreamMod2018 = Stream.generate(Demo03_InfinityDemo::demoEventStream);
		
		/*
		 * current millisec + 60 seconds serves as a one minute time 
		 * limit for the stream.
		 */
		long timeLimit = System.currentTimeMillis() + 60000; 
		
		/*
		 * takeWhile() accepts a predicate and every time a stream element is generated at source, this predicate 
		 * is applied to it to determine if this should be the last element in the stream.
		 * If the predicate holds good, the stream is terminated.
		 * 
		 * So the timeLimit variable holds the millisec one minute from when the stream starts.
		 * And we can estimate that a stream element is generated every 12345 millisecs i.e. 12 seconds.
		 * we can therefore expect the below operations to produce 5 elements.
		 */
		demoStreamMod2018.takeWhile(millisec -> millisec <= timeLimit).
			forEach(x -> System.out.println("[MOD:12345 --> " + x + "]"));
	}
	
	/**
	 * Supplies time stamp milliseconds.
	 * @return current time in milliseconds every time the millisecond long number 
	 * is perfectly divisible by 1234.
	 */
	public static long demoEventStream() {
		while(true) {
			
			long x = System.currentTimeMillis();
			if(x % 12345 == 0) {
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return x;
			}
		}
	}
}