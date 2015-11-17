package oazidea.server;

import bean.Message;
import bean.User;
import oazidea.interfaces.ReceiveMessageInterface;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import oazidea.interfaces.ParticipantMember;
import oazidea.interfaces.ServerServices;
 
public class OaZideaServer extends java.rmi.server.UnicastRemoteObject implements ServerServices
{
    @Override
    public void sendMessage(Message message)
            throws RemoteException {

        // manda para todos
        for (int i = 0; i < this.connectedUsers.size(); i++) {
            
            // Mas quem mandou, n recebe!
            if (message.getFrom().getId() != this.connectedUsers.get(i).getId()) {
                // Adiciona a mensagem
                this.messagesHistory.add(message);
            }
        }
    }
    
    @Override
    public void refreshMemberMessages(String x, int index) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
      
    @Override
    public void ping(){
        System.out.println("pong..");
    }
    
    @Override
    public int connect(String ip, String nick) throws RemoteException {
        User user = new User(nick, ip);
        return addUser(user);   
    }
    

   
   @Override
    public ArrayList<Message> getNewMessages(int idUser) throws RemoteException {

        ArrayList<Message> mess = new ArrayList<Message>();

        // Carrega as mensagens não lidas
        for (int i = 0; i < this.messagesHistory.size(); i++) {

            Message m = this.messagesHistory.get(i);

            if (!m.isReaded() && m.getFrom().getId() != idUser) {
                mess.add(m);
                // Diz que a mensagem foi lida
                m.setReaded(true);
            }
        }

        return mess;
    }
    
     // Adiciona um novo usuário e retorna o id gerado e envia uma mensagem de que ele entrou na sala
    private int addUser(User user) throws RemoteException {
        User u = user;
        u.setId(this.connectedUsers.size() + 1);
        this.connectedUsers.add(u);
        
        Message m = new Message();
        m.setFrom(u);
        m.setMessage("O usuário "+u.getName()+" acabou de entrar na sala");
        sendMessage(m);
        
        return (u.getId());
    } 
    
    @Override
    public void disconnect(int id) throws RemoteException {
        User u = getUserByID(id);
        u.disconnect();
        connectedUsers.remove(u);
        
        Message m = new Message();
        m.setFrom(u);
        m.setMessage("O usuário "+u.getId() + "com nome "+ u.getName());
        sendMessage(m);
    }
    
    
    // Busca o usuário do ID
    private User getUserByID(int idUser) {

        for (int i = 0; i < this.connectedUsers.size(); i++) {
            User user = this.connectedUsers.get(i);
            if (user.getId() == idUser) {
                return user;
            }
        }
        return new User();
    }
    
    
    
    public OaZideaServer() throws RemoteException
    {
        thisPort=3232;
        connectedUsers = new ArrayList<User>();
        messagesHistory = new ArrayList<Message>();
        boolean uncompleted = true;
        try{
            // get the address of this host.
            thisAddress= (InetAddress.getLocalHost()).toString();
        }
        catch(Exception e){
            throw new RemoteException("can't get inet address.");
        }
        do{
            try{
               effect();
               uncompleted = false;
                System.out.println("this address="+thisAddress+",port="+thisPort);
            }
            catch(RemoteException e){
                System.out.println("port "+thisPort+" already used.");
            }
            thisPort++;
        }while(uncompleted);
    }
    public void effect() throws RemoteException{
        // create the registry and bind the name and object.
        registry = LocateRegistry.createRegistry(thisPort);
        registry.rebind("rmiServer", this);
    }
    static public void main(String args[])
    {
        try{
            OaZideaServer s = new OaZideaServer();
        }
        catch (Exception e) {
           e.printStackTrace();
           System.exit(1);
        }
    }

    
    private ArrayList<User> connectedUsers;
    private int thisPort;
    private String thisAddress;
    private Registry registry;    // rmi registry for lookup the remote objects
    private ArrayList<Message> messagesHistory;
}
