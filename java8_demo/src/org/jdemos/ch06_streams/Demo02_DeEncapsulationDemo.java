package org.jdemos.ch06_streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jdemos.entities.Product;
import org.jdemos.entities.ProductUtility;

/**
 * De-encapsulation demo on streams
 * 
 * @author aditya.karnad
 *
 */
public class Demo02_DeEncapsulationDemo {

	public static void main(String[] args) {
		
		/*
		 * Here we see the de-encapsulation of Product POJO: A stream of Products is transformed 
		 * into a stream of Product IDs. So to transform a stream of type A to a stream of type B, 
		 * we usually use the map() method which accepts a Function as an argument.
		 * 
		 * So what is a Function? It's a Functional Interface which is used to implement a transformation 
		 * of T to R. In this case, we are transforming a Product into an Integer
		 * (...the Product ID is an integer).
		 * 
		 */
		List<Product> products = ProductUtility.getProductList();
		
		//Applied function which converts Product to Integer. Function<Product, Integer>
		List<Integer> ids0 = products.stream()
				.map(
					new Function<Product, Integer>() {
	
						@Override
						public Integer apply(Product t) {
							
							return t.getId();
						}
					}
				).collect(Collectors.toList());
		
		// which should be written as...
		
		List<Integer> ids1 = products.stream().map(p -> p.getId()).collect(Collectors.toList());
		
		System.out.println(ids1);
	}

}