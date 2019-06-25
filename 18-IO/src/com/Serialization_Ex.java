package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.model.Company;
import com.model.Product;

/*
 * 
 * converting current state of java-object into byte-stream, then persist into file-system
 * or txr over n/w to other java-applications.
 * 
 * transient-> for not making serializable
 * 
 * 
 */


public class Serialization_Ex {
	public static void main(String[] args) throws IOException {
		
		Company company = new Company("wissen");
		Product product = new Product(1, "item-1", 1000.00);		
		product.setCompany(company);
		
		File file = new File("product.ser");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
		
		outputStream.writeObject(product);
		
		outputStream.flush();
		outputStream.close();
		
		System.out.println("done....");

	}
}
