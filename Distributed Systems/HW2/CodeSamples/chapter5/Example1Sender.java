import java.net.*;
import java.io.*;

/**
 * This example illustrates the basic method calls for connectionless
 * datagram socket.
 * @author M. L. Liu
 */
public class Example1Sender {

// An application which sends a message using connectionless
// datagram socket.
// Three command line arguments are expected, in order: 
//    <domain name or IP address of the receiver>
//    <port number of the receiver's socket>
//    <message, a string, to send>

   public static void main(String[] args) {
      if (args.length != 3)
         System.out.println
            ("This program requires three command line arguments");
      else {
         try {
  		      InetAddress receiverHost = InetAddress.getByName(args[0]);
  		      int receiverPort = Integer.parseInt(args[1]);
            String message = args[2];
  	
   	      DatagramSocket	mySocket = new DatagramSocket();  
               // instantiates a datagram socket for sending the data
            byte[ ] buffer = message.getBytes( );                                     
            DatagramPacket datagram = 
               new DatagramPacket(buffer, buffer.length, 
                                  receiverHost, receiverPort);
            mySocket.send(datagram);
         } // end try
	 catch (Exception ex) {
       System.out.println(ex);
	 }
      } // end else
   } // end main
} // end class
