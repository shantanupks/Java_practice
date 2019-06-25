package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.model.Product;

public class Deserialization_Ex {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File  file = new File("product.ser");
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		

		Object object = inputStream.readObject();
		Product product = (Product) object;
		
		System.out.println(product);
	}

}
