package org.jdemos.ch06_streams;

import java.util.stream.Stream;

public class Demo03_InfinityDemo {

	public static void main(String[] args) {
		
		Stream<Integer> stream = Stream.iterate(0, i -> i+5);
		stream
		.limit(10)		//limit here is used to define a boundary to the infinite stream.
		.forEach(i -> System.out.println(i));
	}
}