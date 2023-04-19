import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
public class ChatroomImpl extends UnicastRemoteObject implements ChatroomInterface{
    private ArrayList<String> UsernameList = new ArrayList<String>();
    private String ChatLog = "--- Start of Log--- \n";


    public ChatroomImpl() throws RemoteException{
        super(); 
    }

    public String logIn(String username) throws RemoteException {
        String name = username;
        String output = "-1";
       
        UsernameList.add(name);
        output = "Welcome " + name;
        System.out.println(output);
        return output; 
    }

    public String sendMessage(String message) throws RemoteException{
        String output = message;

        ChatLog = ChatLog + output + "\n";
        return "Message Sent to Chatlog"; 
    }

    public String updateChat() throws RemoteException{
        return ChatLog; 
    }

    public String getUsers() throws RemoteException{
        String UsersList = "\n"; 
        for(int i = 0; i <= UsernameList.size(); i++){
            UsersList = UsersList + UsernameList.get(i) + "\n";
        }
        return UsersList; 
    }

    /*
     * Loop the client into sending messages, always recieves messages.
     */

    
}
