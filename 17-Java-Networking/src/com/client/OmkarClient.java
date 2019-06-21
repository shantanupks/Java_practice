package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class client {

}

public class OmkarClient {

	public static void main(String[] args) {

		while (true) {

			try {
				Socket socket = new Socket("192.168.6.12", 8181);
				// ...

				InputStream in = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(in);
				Object object = ois.readObject();
				String resp = (String) object;

				System.out.println("resp : " + resp);

				socket.close();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}