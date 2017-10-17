package hiveUserMain;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args){
		Socket socket = null;
		String hostname;
	    DataInputStream input = null;
	    PrintStream output = null;
	    try {
	    	Scanner in = new Scanner(System.in);
	    	System.out.println("Please give host name");
	    	hostname = in.nextLine();
	    	in.close();
			socket = new Socket(hostname, HiveMain.PORTNUM);
			output = new PrintStream(socket.getOutputStream());
			input = new DataInputStream(socket.getInputStream());
		} catch (Exception e){
			e.printStackTrace();
		}
    	System.out.println("Connected :D");
	    try {
			output.write("Hey baby".getBytes());
			System.out.println(input.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//	    try {
//			input.close();
//		    output.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
