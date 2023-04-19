import java.rmi.*;
import java.io.*; 

public class ChatroomClient {
    

    public static void main(String args[]){
        Boolean done = false; 
        try {
            int RMIPort;         
            String hostName;
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("Enter the RMIRegistry host namer:");
            hostName = br.readLine();
            System.out.println("Enter the RMIregistry port number:");
            String portNum = br.readLine();
            RMIPort = Integer.parseInt(portNum);
            String registryURL = 
               "rmi://" + hostName+ ":" + portNum + "/chatroom";  



            // find the remote object and cast it to an interface object
            ChatroomInterface h =
              (ChatroomInterface)Naming.lookup(registryURL);
            System.out.println("Lookup completed " );

            // invoke the remote method

            // username 
            String message = "From";
            System.out.println("Enter a Username");
            String username = br.readLine();
            message = h.logIn(username);
            System.out.println(message);
            br.readLine();

            Boolean loop=false; 
            while(loop != true){
                //Loop messages sending and receiving
                System.out.println("Send a Message");
                message = "From: "+ username +":"+ br.readLine();
               // System.out.println(h.updateChat());
                h.sendMessage(message);
                System.out.println(h.updateChat());
            }

            
         } // end try 
         catch (Exception e) {
            System.out.println("Exception in ChatroomClient: " + e);
         } 
    }
}
