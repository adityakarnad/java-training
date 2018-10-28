package org.jdemos.entities;
public class Product{
	
    private Integer id;  
    private String name;  
    private float price;  
    private String productType;
    
    public Product(Integer id, String name, float price,String productTYpe) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
        this.productType=productTYpe;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}  
	
    
}  
