package oazidea.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import oazidea.interfaces.ReceiveMessageInterface;

public class OaZideaClient {

    static public void main(String args[])
    {
       UiClient ui = new UiClient();
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
       
       ui.setVisible(true);
       try{
           // get the registry 
           registry=LocateRegistry.getRegistry(
               serverAddress,
               (new Integer(serverPort)).intValue()
           );
           // look up the remote object
           rmiServer=
              (ReceiveMessageInterface)(registry.lookup("rmiServer"));
           // call the remote method
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