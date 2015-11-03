package calculator;

import java.rmi.*;

public interface RmiCalculator extends Remote
{
        double plus(double x, double y) throws RemoteException;
        double minus(double x, double y) throws RemoteException;
        double times(double x, double y) throws RemoteException;
        double division(double x, double y) throws RemoteException;
}
