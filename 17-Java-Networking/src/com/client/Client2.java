package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) throws ClassNotFoundException, UnknownHostException, IOException {
		final Socket socket = new Socket("localhost", 8181);
		Scanner scanner = new Scanner(System.in);

		Runnable read = () -> {
			try {
				// reading
				InputStream in = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				ObjectInputStream ois = new ObjectInputStream(in);

				while (true) {
//						Object object = ois.readObject();
//						String resp = (String) object;
					String resp = br.readLine();
					System.out.println("------> :" + resp);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		};

		Runnable write = () -> {
			try {
				// writing
				OutputStream out = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(out);
				String msg = "";
				do {
					System.out.println("Enter msg : ");
					msg = scanner.next();
					oos.writeObject(msg);
				} while (msg != "bye");

				//socket.close();
				//scanner.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		};

		Thread writeThread = new Thread(write);
		Thread readThread = new Thread(read);

		writeThread.start();
		readThread.start();

	}
}
