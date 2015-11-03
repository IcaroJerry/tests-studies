package calculator;

import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
 
public class RmiServer extends java.rmi.server.UnicastRemoteObject implements RmiCalculator
{
    @Override
    public double plus(double x, double y) throws RemoteException {
        System.out.println("Message received in plus.");
        return  cal.plus(x, y);
    }

    @Override
    public double minus(double x, double y) throws RemoteException {
        System.out.println("Message received in minus.");
        return  cal.minus(x, y);
    }

    @Override
    public double times(double x, double y) throws RemoteException {
        System.out.println("Message received in times.");
        return  cal.times(x, y);
    }

    @Override
    public double division(double x, double y) throws RemoteException {
        System.out.println("Message received in division.");
        return  cal.division(x, y);
    }

    public RmiServer() throws RemoteException
    {
        this.cal = new Calculator();
        try{
            address= (InetAddress.getLocalHost()).toString();
        }
        catch(Exception e){
            throw new RemoteException("can't get inet address.");
        }

        this.port=3232;
        System.out.println("this address="+address+",port="+this.port);

        try{
            registry = LocateRegistry.createRegistry(this.port);
            registry.rebind("rmiServer", this);
        }
        catch(RemoteException e){
            throw e;
        }
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
    private String address;
    private Registry registry;
    private Calculator cal;
}
