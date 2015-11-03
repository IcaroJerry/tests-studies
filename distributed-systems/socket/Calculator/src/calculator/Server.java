package calculator;

import java.io.*;
import java.net.*;

public class Server{
    
    public Server() throws UnknownHostException{ 

        try{
            this.address= (InetAddress.getLocalHost()).toString();
        }
        catch(Exception e){
            throw new UnknownHostException("can't get inet address.");
        }

        this.port=3232;
        System.out.println("this address="+this.address+",port="+this.port);
        
        try {
	    serverSocket = new ServerSocket(this.port);
        }
        catch (IOException e){
            System.out.println(e);
        }

        while(true){
	    try {
		clientSocket = serverSocket.accept();
		for(int i=0; i<=9; i++){
		    if(t[i]==null)
			{
			    (t[i] = new ClientCalculatorThread(clientSocket,t)).start();
			    break;
			}
		}
	    }
	    catch (IOException e) {
		System.out.println(e);}
	}
    }

    static public void main(String args[])
    {
        try{
            Server s = new Server();
        }
        catch (Exception e) {
           e.printStackTrace();
           System.exit(1);
        }
    }
      
    private static  Socket clientSocket = null;
    private static  ServerSocket serverSocket = null;
    private static  ClientCalculatorThread t[] = new ClientCalculatorThread[10];
    private int port;
    private String address;
}