package com.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("welcome :");
			Socket socket = new Socket("localhost", 8181);

			OutputStream out = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(out);
			String msg = "";
			
			
			do {
			System.out.println("Enter msg : ");
			msg = scanner.next();
			oos.writeObject(msg);
			
			InputStream in = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);

			Object object = ois.readObject();
			String resp = (String) object;
			System.out.println("------> :" + resp);
			}while(msg!="bye");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
