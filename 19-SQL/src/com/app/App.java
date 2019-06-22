package com.app;

import com.app.repository.JdbcProductRepository;
import com.app.repository.ProductRepository;

public class App {
	public static void main(String[] args) {
		ProductRepository productRepository = new JdbcProductRepository();

//		Product product = new Product(3, "Mobile", 5000, ProductType.ELEC);
//		Product product2 = new Product(4, "Mobile2", 10000, ProductType.ELEC);
//		Product product3 = new Product(5, "TV", 20000, ProductType.ELEC);

//		productRepository.save(product);
//		productRepository.save(product2);
//		productRepository.save(product3);
		
		productRepository.update(6, 11000);
		

	}

}
