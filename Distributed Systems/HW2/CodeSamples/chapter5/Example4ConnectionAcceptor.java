import java.net.*;
import java.io.*;

/**
 * This example illustrates the basic syntax for stream-mode
 * socket.
 * @author M. L. Liu
 */
public class Example4ConnectionAcceptor {

// An application which receives a message using stream-mode socket
// Two command line arguments are expected, in order: 
//    <port number for the the Server socket used in this process>
//    <message, a string, to send>

   public static void main(String[] args) {
      if (args.length != 2)
         System.out.println
            ("This program requires three command line arguments");
      else {
         try {
  		      int portNo = Integer.parseInt(args[0]);
            String message = args[1];
            // instantiates a socket for accepting connection  	
   	      ServerSocket connectionSocket = new ServerSocket(portNo);
/**/        System.out.println("now ready accept a connection");  
            // wait to accept a connecion request, at which
            //  time a data socket is created                  
            Socket dataSocket = connectionSocket.accept();
/**/        System.out.println("connection accepted"); 
            // get a output stream for writing to the data socket
            OutputStream outStream = dataSocket.getOutputStream();
            // create a PrinterWriter object for character-mode output
            PrintWriter socketOutput = 
               new PrintWriter(new OutputStreamWriter(outStream));
            // write a message into the data stream
            socketOutput.println(message);
            //The ensuing flush method call is necessary for the data to
            // be written to the socket data stream before the
            // socket is closed.
            socketOutput.flush();
/**/        System.out.println("message sent"); 
            dataSocket.close( );
/**/        System.out.println("data socket closed");
            connectionSocket.close( );
/**/        System.out.println("connection socket closed"); 
         } // end try
	 catch (Exception ex) {
       System.out.println(ex);
	 }
      } // end else
   } // end main
} // end class
