package org.jdemos.entities;

import java.util.ArrayList;
import java.util.List;

public class ProductUtility {
	
	
	public static List<Product> getProductList(){
		
		List<Product> productsList = new ArrayList<Product>();  
        //Adding Products
		
        productsList.add(new Product(1,"HP Laptop",25000f,"N"));  
        productsList.add(new Product(2,"TV",30000f,"O"));  
        productsList.add(new Product(3,"Sony Handy Cam",28000f,"N"));  
        productsList.add(new Product(4,"Washing Machine",28000f,"O"));  
        productsList.add(new Product(5,"Ipod",9000f,"N"));
        productsList.add(new Product(6,"Ipad",15000f,"O"));  
        productsList.add(new Product(7,"A.C.",30000f,"N"));  
        productsList.add(new Product(8,"Fan",2600f,"O"));  
        productsList.add(new Product(9,"Table",28000f,"N"));  
        productsList.add(new Product(10,"Shoe Stand",90000f,"O"));
        
        //intential duplicate products
        productsList.add(new Product(9,"Table**",28000f,"N"));
        productsList.add(new Product(10,"Shoe Stand**",90000f,"O"));
        
        return productsList;
	}

}
