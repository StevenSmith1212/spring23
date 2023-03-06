import java.net.*;
import java.io.*;

/**
 * This example illustrates the basic syntax for stream-mode
 * socket.
 * @author M. L. Liu
 */
public class Example5ConnectionRequestor {

// An application that sends a message using stream-mode socket.
// Two command line arguments are expected: 
//
//    <host name of the connection accceptor>
//    <port number of the connection accceptor>

   public static void main(String[] args) {
      if (args.length != 2)
         System.out.println
            ("This program requires two command line arguments");
      else {
         try {
            String acceptorHost = args[0];
  		      int acceptorPort = Integer.parseInt(args[1]);
            // instantiates a data socket
   	      MyStreamSocket mySocket = 
               new MyStreamSocket(acceptorHost, acceptorPort); 
/**/        System.out.println("Connection request granted"); 
            String message = mySocket.receiveMessage( );
/**/        System.out.println("Message received:");
            System.out.println("\t" + message);
            mySocket.close( );
/**/        System.out.println("data socket closed");
         } // end try
	      catch (Exception ex) {
            ex.printStackTrace( );
	      }
      } // end else
   } // end main
} // end class
