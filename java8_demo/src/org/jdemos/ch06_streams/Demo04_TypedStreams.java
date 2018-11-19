package org.jdemos.ch06_streams;

import java.util.List;

import org.jdemos.entities.Product;
import org.jdemos.entities.ProductUtility;

public class Demo04_TypedStreams {

	public static void main(String[] args) {
		
		List<Product> products = ProductUtility.getProductList();
		
		System.out.println("Most expensive product costs " + products.stream().mapToDouble(p -> p.getPrice()).max().getAsDouble());
	}

}
