package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerApp {

	static List<Socket> list = new ArrayList<Socket>();
	
	 static class AcceptService {
		 
		Socket socket = null;
		String resp;
		
		public void accept() throws IOException, ClassNotFoundException {
			
			InputStream in = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);
			Object object = ois.readObject();
			this.resp = (String) object;
			System.out.println("Message from client :"+resp);

		}

		public void setSocket(Socket socket2) {
			// TODO Auto-generated method stub
			this.socket=socket2;
			
		}

		public void send() {
			// TODO Auto-generated method stub
			for(Socket sockets: list) {
				try {
					ObjectOutputStream oos = new ObjectOutputStream(sockets.getOutputStream());
					oos.writeObject(this.resp);
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	 }
	 
	 

	public static void main(String[] args) throws IOException {
		

		ServerSocket serverSocket;
		serverSocket=new ServerSocket(8181);
		AcceptService acceptService = new AcceptService();
		
		ExecutorService executorService = Executors.newCachedThreadPool();

		
		Runnable task = () -> {
			try {
				acceptService.accept();
				acceptService.send();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		};
		
		
		try {
			while (true) {

				Socket socket = serverSocket.accept(); // accepts request
				
				acceptService.setSocket(socket);
				list.add(socket);
				
				executorService.submit(task);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		


	}

}
