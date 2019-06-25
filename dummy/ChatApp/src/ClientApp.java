import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", Integer.valueOf(args[0]) );
			// ...

			Runnable printServerMsg = ()-> {
				try (
						InputStream is = socket.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
		                BufferedReader br = new BufferedReader(isr);
		                ){
						while(!socket.isClosed()) {
							String msg = br.readLine();
							System.out.println(msg);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			};
			

			Runnable waitForClientToWriteMsg = () -> {
				
				try {
					PrintStream printStream = new PrintStream(socket.getOutputStream());
					Scanner scan = new Scanner(System.in);
					String msg = socket.getInetAddress()+" : Joined to chat room";
					while( !msg.equals("exit") ) {
						printStream.println(socket.getInetAddress()+ " : "+ msg);
						msg = scan.nextLine();
					}
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			};

			new Thread(printServerMsg).start();
			new Thread(waitForClientToWriteMsg).start();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
