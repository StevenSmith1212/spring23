import java.net.*;
import java.io.*;

/**
 * This example illustrates the basic syntax for stream-mode
 * socket.
 * @author M. L. Liu
 */
public class Example4ConnectionRequestor {

// An application which sends a message using stream-mode socket.
// A command line argument is expected: 
//    <host name of the connection accceptor>

   public static void main(String[] args) {
      if (args.length != 2)
         System.out.println
            ("This program requires two command line arguments");
      else {
         try {
  		      InetAddress acceptorHost = InetAddress.getByName(args[0]);
  		      int acceptorPort = Integer.parseInt(args[1]);
            // instantiates a data socket
   	      Socket mySocket = new Socket(acceptorHost, acceptorPort); 
/**/        System.out.println("Connection request granted"); 
            // get an input stream for reading from the data socket
            InputStream inStream = mySocket.getInputStream();
            // create a BufferedReader object for text line input
            BufferedReader socketInput = 
               new BufferedReader(new InputStreamReader(inStream));
/**/        System.out.println("waiting to read");
            // read a line from the data stream
            String message = socketInput.readLine( );
/**/        System.out.println("Message received:");
            System.out.println("\t" + message);
            mySocket.close( );
/**/        System.out.println("data socket closed");
         } // end try
	 catch (Exception ex) {
       System.out.println(ex);
	 }
      } // end else
   } // end main
} // end class
