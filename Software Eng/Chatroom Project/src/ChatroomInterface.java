import java.rmi.*;

public interface ChatroomInterface extends Remote{

    public String logIn(String username) throws RemoteException;
    public String sendMessage(String Message) throws RemoteException;
    public String updateChat() throws RemoteException; 
    public String getUsers() throws RemoteException;
}
