package hiveUserMain;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	public static void main(String[] args){
		ServerSocket wang = null;
	    Socket socket = null;
	    DataInputStream input = null;
	    DataOutputStream output = null;
	    try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    String hst = addr.getHostName();
		    System.out.println("Host Name: <"+hst + ">");
		}
		catch (UnknownHostException ex)
		{
		    System.out.println("Hostname can not be resolved");
		}
	    try {
	    	wang = new ServerSocket(HiveMain.PORTNUM);
	    	wang.bind(wang.getLocalSocketAddress(), HiveMain.PORTNUM);
		    socket = wang.accept();
		    input = new DataInputStream(socket.getInputStream());
		    output = new DataOutputStream(socket.getOutputStream());
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
    	System.out.println("Connected :D");
	    while(true){
	    	System.out.println("Server running!");
	    	try {
				output.write(input.read());
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
//	    wang.close();
//	    try {
//			input.close();
//		    output.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
