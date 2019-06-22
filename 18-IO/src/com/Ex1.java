package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex1 {
	public static void main(String[] args) throws IOException {
//		InputStream inputStream = System.in;
//		
//		InputStreamReader in = new InputStreamReader(inputStream);
//		BufferedReader bufferedReader = new BufferedReader(in);
//		String msg=bufferedReader.readLine();
//		
//		System.out.println(msg);
		
		
		File file = new File("t");
		FileInputStream fileReader = new FileInputStream(file);
		int uc=-1;
		int c;
		while((uc=fileReader.read())!=-1) {
			System.out.println((char)uc);
		}
		
	}

}
