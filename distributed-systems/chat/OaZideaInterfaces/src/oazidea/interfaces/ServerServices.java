package oazidea.interfaces;

import bean.Message;
import java.rmi.*;
import java.util.ArrayList;
public interface ServerServices extends Remote
{       
	void sendMessage(Message x) throws RemoteException;
        void refreshMemberMessages(String x, int index) throws RemoteException;
        int connect(String ip, String nick) throws RemoteException;
        void disconnect(int idUser) throws RemoteException;
        void ping()throws RemoteException;
        ArrayList<Message> getNewMessages(int idUser) throws RemoteException;
}
