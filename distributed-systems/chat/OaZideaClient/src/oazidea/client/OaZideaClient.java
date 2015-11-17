package oazidea.client;

import bean.Message;
import bean.User;
import java.io.Serializable;
import java.net.InetAddress;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oazidea.interfaces.ParticipantMember;
import oazidea.interfaces.ServerServices;

public class OaZideaClient implements ParticipantMember, Runnable{

    private OaZideaClient(){
        serverAddress = "";
        serverPort = "3232";
        nickName = "";

        try{
            // get the address of this host.
            ip= InetAddress.getLocalHost().getHostAddress();
            ui = new UiClient();
        }
        catch(Exception e){
            new RemoteException("can't get inet address.");
        }
    }
    
    static public void main(String args[]){
        OaZideaClient.getInstance().init();
    }
      
    public void init()
    {
       System.out.println("Enter the server address:");
       System.out.println("Enter the port number:");

       ui.setVisible(true);
    }
    @Override
    public void run(){
      
    }
    
    
    @Override
    public void connectToServer() {
        
        if(myUser==null){
            try{
               registry=LocateRegistry.getRegistry(serverAddress,
                                                  (new Integer(serverPort)).intValue());
               // look up the remote object
               rmiServer=
                  (ServerServices)(registry.lookup("rmiServer"));
               codigo = rmiServer.connect(getIP(), getNickName());

               //inicia a asynk task de perguntar as mensagens
               timerMessages = new java.util.Timer();
               timerMessages.schedule(new refreshMessagesTask(),2000);
               myUser = new User();
               myUser.setId(codigo);
               myUser.setName(nickName);
               myUser.setIp(ip);
            }    
           catch(Exception e){
               e.printStackTrace();
           }
          
       }else{
            JOptionPane.showMessageDialog(ui, "Você já está conectado");
        }
    }
    @Override
    public int indexOfLastMessageReceived() {
        return indexOfLastMessageReceived;
    }
    public void refreshConnectionConfigurations(String sAddress, String sPort, String nick){
        serverAddress = sAddress;
        serverPort = sPort;
        nickName = nick;
        //reset();
    }
    public void resetConnect(){
        ui.clearFields();
        //ui.connet();
    }
    
    //Metodo que recupera a mensagem da area de texto e envia para o servidor
    public void sendMessage() throws RemoteException{
       
        if(myUser!=null && myUser.isConnected()){
            Message m = new Message();
            m.setFrom(myUser);
            m.setMessage(ui.getMessage());
 
            rmiServer.sendMessage(m);
            
            ui.appendMessages("Você disse: "+ui.getMessage());
            
       } 
    }
    
    @Override
    public void disconnectFromServer() {
        try{
           rmiServer.disconnect(codigo);
           registry = null;
           rmiServer = null;
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
    @Override
    public String getNickName() {
        return nickName;
    }
    @Override
    public String getIP() {
        return ip;
    }
    public static OaZideaClient getInstance(){
        if(instance == null){
           instance = new OaZideaClient();
        }
        return instance;
    }
    
     // Utilizada para atualizar a lista de Mensagens
    class refreshMessagesTask extends java.util.TimerTask {

      public void run() {
            try {
                //Terminate the timer thread
                timerMessages.cancel();
            } catch (Exception e){
               System.out.println(e.toString());
            }finally{
                try {
                    // Chama de novo
                    refreshMessagesList();
                } catch (RemoteException ex) {
                    Logger.getLogger(OaZideaClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    public void  refreshMessagesList() throws RemoteException{
        
        ArrayList<Message> list =  rmiServer.getNewMessages(codigo);
        
        for(int i=0; i< list.size();i++){
            Message m = list.get(i);
            ui.appendMessages(m.getFrom().getName() + "(" + m.getFrom().getIp() + "): " + m.getMessage());
        }
        
        timerMessages = new java.util.Timer();
        timerMessages.schedule(new refreshMessagesTask(), 2000);
    }
    
    private User myUser;
    private java.util.Timer timerMessages;
    private int codigo;
    private ServerServices rmiServer;
    private Registry registry;
    private String serverAddress;
    private String serverPort;
    private String ip;
    private String nickName;
    private int indexOfLastMessageReceived;
    private UiClient ui;
    private static OaZideaClient instance;
}