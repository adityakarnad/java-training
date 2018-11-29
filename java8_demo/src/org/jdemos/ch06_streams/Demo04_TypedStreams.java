package org.jdemos.ch06_streams;

import java.util.List;

import org.jdemos.entities.Product;
import org.jdemos.entities.ProductUtility;

/**
 * Demonstrates the capabilities of Typed Streams
 * @author aditya.karnad
 *
 */
public class Demo04_TypedStreams {

	public static void main(String[] args) {
		
		List<Product> products = ProductUtility.getProductList();
		
		/*
		 * Streams also provide means to extract typed streams i.e. streams of Integers, Doubles, etc.
		 * Such typed streams have some handy utility methods which the below example demonstrates.
		 */
		
		System.out.println("Most expensive product costs "
				+ products.stream().
				/*
				 * mapToDouble = accept stream of product and return a stream of double.
				 * Here the product stream is converted to double stream which is derived 
				 * from the product by getting the product price.
				 */
				mapToDouble(p -> p.getPrice()).
				
				/*
				 * Notice that the resulting stream is a DoubleStream (typed stream of type double)
				 * Such typed streams have methods like max(), average(), sum(), etc which regular streams don't.
				 * 
				 * Here we use max() to get the most expensive product - this returns an OptionalDouble.
				 * 
				 * Optionals: An Optional is a container object which stores data. 
				 * The advantage of using this is that the developer will not need to 
				 * add null checks, which results in neat code with better readability.
				 */
				max().
				/*
				 * returns the value from the OptionalDouble - if the stream turned out empty, then 
				 * this would result in a 'NoSuchlementException'
				 */
				getAsDouble());
	}
}