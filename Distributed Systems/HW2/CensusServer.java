import java.io.*;
import java.net.*;
import java.util.*; 


class CensusServer{
    static final String endMessage = ".";
    static ArrayList<String> names = new ArrayList<String>(); 
    

    public static void main(String[] args){
        int serverPort = 13;
        
        String clientName = ""; 

        if(args.length ==1)
            serverPort = Integer.parseInt(args[0]);
        try{

            //establishes a connection
            ServerSocket myConnection = new ServerSocket(serverPort);
            System.out.println("CensusServer is ready to steal names");

            while(true){//runs conintuously
                //ready for incoming connections
                System.out.println("Looking for connection.");
                MyStreamSocket DataSocket = new MyStreamSocket(myConnection.accept());
                System.out.println("connection accepted");
                boolean done = false;
                while (!done) {
                    String NewclientName = DataSocket.receiveMessage();
                    clientName = NewclientName+ "||" + clientName;
                    System.out.println("message received: Added Name "+ NewclientName);

                    if ((clientName.trim()).equals (endMessage)){
                       //Session over; close the data socket.
                        System.out.println("Session over.");
                        DataSocket.close( );
                        done = true;
                    } //end if
                    else {
                        DataSocket.sendMessage(clientName);
                    }
                }//End While !done
            }//end while cont.

        } //End of Try
        catch(Exception ex){
            ex.printStackTrace(); 
        }

    }// End of Main

}