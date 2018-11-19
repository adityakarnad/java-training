package org.jdemos.ch06_streams;

import java.util.List;

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
	}

}