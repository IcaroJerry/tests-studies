package calculator;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientCalculatorThread extends Thread{

    public ClientCalculatorThread(Socket clientSocket, ClientCalculatorThread[] t){
        this.clientSocket=clientSocket;
        this.t=t;
        calculator = new Calculator();
    }
    
    @Override
    public void run(){
        String operation;
        String op[];
        String result;
        String c = "";

        try{
           is = new DataInputStream(clientSocket.getInputStream());
           os = new PrintStream(clientSocket.getOutputStream());
           
           os.println("...connected!\n\n");
           os.println("Welcome to online calculator!");

           while(!c.equalsIgnoreCase("q")){
            os.println("Type operation to the server: ");
            operation = is.readLine();
     
            if((op = operation.split("\\+")).length == 2){
               result = ""+calculator.plus(Double.valueOf(op[0]), Double.valueOf(op[1]));
             }
             else if((op = operation.split("-")).length == 2){
               result = ""+calculator.minus(Double.valueOf(op[0]), Double.valueOf(op[1]));
             }
             else if((op = operation.split("/")).length == 2){
               result = ""+calculator.division(Double.valueOf(op[0]), Double.valueOf(op[1]));
             }
             else if((op = operation.split("\\*")).length == 2){
               result = ""+calculator.times(Double.valueOf(op[0]), Double.valueOf(op[1]));
             }
             else{
                 result = "Error: Invalid expression! Try again...\n";
             }
            os.println("The result is:"+String.valueOf(result));
            os.println("To exit type \"q\" or any key to continue...");
            c = is.readLine();
           }
        os.println("\nBye bye...");
        }
        catch(IOException io){
        }
    }
    
    private DataInputStream is = null;
    private PrintStream os = null;
    private Socket clientSocket = null;       
    private ClientCalculatorThread t[]; 
    private Calculator calculator;
}
