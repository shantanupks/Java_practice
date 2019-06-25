import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ChatServer {

	private List<Socket> clients = new LinkedList<>();
	
	public void addClient(Socket socket) {
		this.clients.add(socket);
	}
	
	public void removeClient(Socket socket) {
		this.clients.remove(socket);
	}
	
	public void sendToAll(String msg, Socket socket) {
		for(Socket client : clients) {
			this.sendMsg(msg, client);
		}
	}
	public int activeClients() {
		return this.clients.size();
	}
	
	public void sendMsg(String msg, Socket socket) {
			
		try {
			PrintStream printStream = new PrintStream(socket.getOutputStream());
			printStream.println(" : "+ msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String []args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9126);
		
		ChatServer chatServer = new ChatServer();
		
		final int roomSize = 10;
		
		ExecutorService executorService  = Executors.newCachedThreadPool();
		
		
		Runnable removeWhenSocketClosed = ()->{
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for( Socket socket : chatServer.clients )
				if( socket.isClosed())
					chatServer.removeClient(socket);
		};
		
		Runnable readingClients = ()-> {
			while( chatServer.activeClients() < roomSize ) {
				try {
					Socket socket = serverSocket.accept();
					chatServer.addClient(socket);
					
					
					
					Runnable waitForClientMsg = () -> {
						try (
							InputStream is = socket.getInputStream();
							InputStreamReader isr = new InputStreamReader(is);
			                BufferedReader br = new BufferedReader(isr);
			                ){
							while(!socket.isClosed()) {
								
								String msg = br.readLine();
								
								chatServer.sendToAll(msg, socket);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					};
					executorService.execute(waitForClientMsg);
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		executorService.submit(readingClients);
		executorService.execute(removeWhenSocketClosed);

	}
}
