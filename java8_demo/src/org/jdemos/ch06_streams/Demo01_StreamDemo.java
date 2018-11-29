package org.jdemos.ch06_streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.jdemos.entities.Product;
import org.jdemos.entities.ProductUtility;

/**
 * This demo introduces streams - what they are and how to use them.
 * @author Aditya Karnad
 *
 */
public class Demo01_StreamDemo {

	public static void main(String[] args) {
		
		List<Product> products = ProductUtility.getProductList();
		
		/*
		 * Collections are data structures - streams are not. Just like a stream of water 
		 * that flows from points A to B, in a stream the data flows from a source 
		 * to a destination.
		 * The developer can determine what happens to the data during the course of the flow.
		 * 
		 * While manipulating data in a stream, there are two types of operations 
		 * that can be performed.
		 * 
		 * 1. Intermediate (or non-Terminal)
		 * Here the stream is operated on and what's returned is a modified stream.
		 * Example: filter(), map(), etc.
		 * 
		 * 2. Terminal
		 * Here the stream ends - i.e. operation finalizes the stream to it's destination.
		 * For instance, forEach().
		 * 
		 * HINT: See the javadoc for the operation you wish to perform to 
		 * check if it's intermediate or terminal.
		 * 
		 */
		
		
		products.stream()
			.filter(p -> p.getPrice() <= 15000) //intermediate op
			.forEach((p)-> System.out.println(p.getName() + " >>> " + p.getPrice())); //terminal op
		
		
		/* Let's break this down now...
		 *
		 * So what does this filter() do? This method creates another stream of the elements in the filter 
		 * such that all the elements of the resulting stream satisfy a certain condition.
		 * 
		 * Example: in a stream of integers: 1,4,2,9,8,12,76,24,17,10 -- I can add a filter of odd numbers.
		 * The resulting stream will be: 1,9,17
		 * 
		 * the filter method accepts a Predicate... What's a Predicate?
		 * This is Functional Interface with a SAM that accepts the type <T> and returns a boolean.
		 * This is used like a test for a condition being true or false.
		 */
		
		
		products.stream()
		.filter(
				new Predicate<Product>() {
					
					public boolean test(Product p) {
						
						return p.getPrice() <= 15000;
					};
				}
		)
		
		/*
		 * The second method which is the terminal operation on the stream is forEach().
		 * 
		 * This method accepts a Consumer, which is a Functional Interface having SAM that accepts a type <T> 
		 * and does something with it without returning anything. i.e. it consumes a value, and returns nothing.
		 */
		
		.forEach(
			new Consumer<Product>() {
				@Override
				public void accept(Product p) {
					
					System.out.println(p.getName() + " >>> " + p.getPrice());
				}
			}
		);
	}
}