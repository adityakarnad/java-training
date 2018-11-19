package org.jdemos.ch06_streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jdemos.entities.Product;
import org.jdemos.entities.ProductUtility;

public class Demo02_DeEncapsulationDemo {

	public static void main(String[] args) {
		
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
			
		
		
		//List<Integer> ids1 = products.stream().map(p -> p.getId()).collect(Collectors.toList());
	}

}
