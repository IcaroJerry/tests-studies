package calculator;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client implements Runnable{
   
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String serverAddress;
        int serverPort;
        
        System.out.println("Type the server address:");
        serverAddress = sc.next();
        System.out.println("Type the port number:");
        serverPort = sc.nextInt();
        
        System.out.println();
        System.out.println("...connecting to "+serverAddress+":"+serverPort);

	try {
            clientSocket = new Socket(serverAddress, serverPort);
            inputLine = new BufferedReader(new InputStreamReader(System.in));
            os = new PrintStream(clientSocket.getOutputStream());
            is = new DataInputStream(clientSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host "+serverAddress);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to the host "+serverAddress);
        }
	
        if (clientSocket != null && os != null && is != null) {
            try {
                new Thread(new Client()).start();

		while (!closed) {
                    os.println(inputLine.readLine()); 
                }

		os.close();
		is.close();
		clientSocket.close();   
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }           

    public void run() {		
	String responseLine;

	try{ 
	    while ((responseLine = is.readLine()) != null) {
		System.out.println(responseLine);
		if (responseLine.indexOf("*** Bye") != -1) break;
	    }
            closed=true;
	} catch (IOException e) {
	    System.err.println("IOException:  " + e);
	}
    }
   
    private static Socket clientSocket = null;
    private static PrintStream os = null;
    private static DataInputStream is = null;
    private static BufferedReader inputLine = null;
    private static boolean closed = false;
}
