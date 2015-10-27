package calculator;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;
 
public class RmiServer extends java.rmi.server.UnicastRemoteObject implements ReceiveMessageInterface
{
    @Override
    public void receiveMessage(String val) throws RemoteException
    {
        String[] op = val.split(";");
        String msg;
        System.out.println(op[0]+op[1]+op[2]);
        if(op.length == 3){
            switch (op[1]) {
                case "+":
                   msg = String.valueOf(cal.plus(Double.valueOf(op[0]), Double.valueOf(op[2])));
                    break;
                case "-":
                   msg = String.valueOf(cal.minus(Double.valueOf(op[0]), Double.valueOf(op[2])));
                    break;
                case "*":
                   msg = String.valueOf(cal.times(Double.valueOf(op[0]), Double.valueOf(op[2])));
                    break;
                case "/":
                    msg = String.valueOf(cal.division(Double.valueOf(op[0]), Double.valueOf(op[2])));
                    break;
                default:
                    throw new AssertionError();
            }
            System.out.println("The result is "+msg+".");
        }
        System.out.println("Error: invalid expression!");
    }
 
    public RmiServer() throws RemoteException
    {
        try{
            thisAddress= (InetAddress.getLocalHost()).toString();
        }
        catch(Exception e){
            throw new RemoteException("can't get inet address.");
        }

        this.port=3232;
        System.out.println("this address="+thisAddress+",port="+this.port);

        try{
            registry = LocateRegistry.createRegistry(this.port );
            registry.rebind("rmiServer", this);
        }
        catch(RemoteException e){
            throw e;
        }
        this.cal = new Calculator();
    }
   
    static public void main(String args[])
    {
        try{
        RmiServer s = new RmiServer();
    }
    catch (Exception e) {
           e.printStackTrace();
           System.exit(1);
    }
     }
    
    private int port;
    private String thisAddress;
    private Registry registry;
    private Calculator cal;
}
