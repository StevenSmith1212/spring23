import java.io.*;
import java.net.*;
import java.util.Date;   // for obtaining a timestamp

/**
 * This module contains the application logic of a Daytime server
 *   which uses connection-oriented datagram socket for IPC.
 * A command-line argument is required to specify the server port.
 * @author M. L. Liu
 */
public class DaytimeServer2 {
   public static void main(String[] args) {
      int serverPort = 13;    // default port
      if (args.length == 1 )
         serverPort = Integer.parseInt(args[0]);       
      try {
         // instantiates a stream socket for accepting
         //   connections
   	   ServerSocket myConnectionSocket = 
            new ServerSocket(serverPort); 
         System.out.println("Daytime server ready.");  
         while (true) {  // forever loop
            // wait to accept a connection 
/**/        System.out.println("Waiting for a connection.");
            MyStreamSocket myDataSocket = new MyStreamSocket
                (myConnectionSocket.accept( ));
            // Note: there is no need to read a request - the 
            // request is implicit.
/**/        System.out.println("A client has made connection.");
            Date timestamp = new Date ();
/**/        System.out.println("timestamp sent: "+ timestamp.toString());
            // Now send the reply to the requestor
            myDataSocket.sendMessage(timestamp.toString( ));
            myDataSocket.close( );
		   } //end while
       } // end try
       catch (Exception ex) {
          ex.printStackTrace( );
       } // end catch
   } //end main
} // end class      
