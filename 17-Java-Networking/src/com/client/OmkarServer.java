package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OmkarServer  {

	public static void processRequest(Socket socket)
	{
		try {
			System.out.println("request from client on thread "+Thread.currentThread().getName());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			while(true)
			{
	            String instring = in.readLine();
	            if(instring.equals("bye"))
	            {
		            socket.close();
		            break;
	            }
	            System.out.println("The server got this response from client " + instring.toUpperCase());
	            out.println("The server got this response from client" + instring.toUpperCase());
			}
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
	private static ServerSocket serverSocket = null;
	
	public static void main(String[] args) {

		ExecutorService executorService= Executors.newCachedThreadPool();
		try {
			serverSocket = new ServerSocket(8181);
			while(true)
			{
				Socket socket = serverSocket.accept();
				Runnable task = ()->{
					processRequest(socket);
				};
				executorService.submit(task);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}