package calculator;

import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.util.Scanner;

public class RmiClient
{
    static public void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
       ReceiveMessageInterface rmiServer;
       Registry registry;
       String serverAddress;
       String serverPort;
       String text;
       
       System.out.println("Enter the server address:");
       serverAddress = sc.next();
       System.out.println("Enter the port number:");
       serverPort = sc.next();
       System.out.println("Send a request text to the server separated by ';'. Ex (2;+;2): ");
       text = sc.next();
       System.out.println();
       System.out.println("...sending "+text+" to "+serverAddress+":"+serverPort);
       
       try{

           registry=LocateRegistry.getRegistry(
               serverAddress,
               (new Integer(serverPort)).intValue()
           );

           rmiServer=
              (ReceiveMessageInterface)(registry.lookup("rmiServer"));

           rmiServer.receiveMessage(text);
       }
       catch(RemoteException e){
           e.printStackTrace();
       }
       catch(NotBoundException e){
           e.printStackTrace();
       }
    }
}
