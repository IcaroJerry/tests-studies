package calculator;

import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.util.Scanner;

public class RmiClient
{
    static public void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       RmiCalculator rmiServer;
       Registry registry;
       String serverAddress;
       String serverPort;
       String text;
       
       System.out.println("Type the server address:");
       serverAddress = sc.next();
       System.out.println("Type the port number:");
       serverPort = sc.next();      
       try{
           registry=LocateRegistry.getRegistry( serverAddress, (new Integer(serverPort)).intValue());

           rmiServer= (RmiCalculator)(registry.lookup("rmiServer"));
           
           String[] op;
           String result;
           String c = "";
           while(!c.equalsIgnoreCase("q")){
           
            System.out.println("Send a request text to the server: ");
            text = sc.next();
            System.out.println();
            System.out.println("...sending "+text+" to "+serverAddress+":"+serverPort);
            
            if((op = text.split("\\+")).length == 2){
              result = ""+rmiServer.plus(Double.valueOf(op[0]), Double.valueOf(op[1]));
            }
            else if((op = text.split("-")).length == 2){
              result = ""+rmiServer.minus(Double.valueOf(op[0]), Double.valueOf(op[1]));
            }
            else if((op = text.split("/")).length == 2){
              result = ""+rmiServer.division(Double.valueOf(op[0]), Double.valueOf(op[1]));
            }
            else if((op = text.split("\\*")).length == 2){
              result = ""+rmiServer.times(Double.valueOf(op[0]), Double.valueOf(op[1]));
            }
            else{
                result = "Error: Invalid expression! Try again...\n";
            }
            System.out.println("The result is: "+result+"\n");
            System.out.println("To exit type \"q\" or any key to continue...");
            c = sc.next();
           }
       }
       catch(RemoteException e){
           e.printStackTrace();
       }
       catch(NotBoundException e){
           e.printStackTrace();
       }
    }
}
