package oazidea.interfaces;

import java.io.Serializable;

public interface ParticipantMember{
    
    public String getNickName();
    public String getIP();
    public int indexOfLastMessageReceived();
    public void connectToServer();
    public void disconnectFromServer();
}
