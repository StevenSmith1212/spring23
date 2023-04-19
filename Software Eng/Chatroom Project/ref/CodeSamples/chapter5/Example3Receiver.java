import java.net.*;

/**
 * This example illustrates the basic syntax for connection-oriented
 * datagram socket.
 * @author M. L. Liu
 */
public class Example3Receiver {

// An application which uses a connection-oriented datagram
// socket to receive multiple messages, then sends one.
// Four command line arguments are expected, in order: 
//    <domain name or IP address of the sender>
//    <port number of the sender's datagram socket>
//    <port number of this process's datagram socket>
//    <message, a string, to send>

   public static void main(String[] args) {
      if (args.length != 4)
         System.out.println
            ("This program requires four command line arguments");
      else {
         try {      
            InetAddress senderHost = InetAddress.getByName(args[0]);
            int senderPort = Integer.parseInt(args[1]);
  		      int myPort = Integer.parseInt(args[2]);
            String message = args[3];
            // instantiates a datagram socket for receiving the data
   	      MyDatagramSocket	mySocket = new MyDatagramSocket(myPort); 
            // make a connection with the sender's socket
            mySocket.connect(senderHost, senderPort);
            for (int i=0; i<100; i++)  
            	System.out.println(mySocket.receiveMessage());
            // now send a message to the other end
            mySocket.sendMessage( senderHost, senderPort, message);
				mySocket.close( );
         } // end try
	      catch (Exception ex) {
            System.out.println("An exception has occured: " + ex);
	      }
      } // end else
   } // end main
} // end class
