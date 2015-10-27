package calculator;

import java.rmi.*;

public interface ReceiveMessageInterface extends Remote
{
	void receiveMessage(String val) throws RemoteException;
}
