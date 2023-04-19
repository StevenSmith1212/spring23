import java.net.*;

/**
 * This example illustrates the basic syntax for connection-oriented
 * datagram socket.
 * @author M. L. Liu
 */
public class Example3Sender {

// An application which uses a connection-oriented datagram
// socket to send multiple messages, then receives one.
// Four command line arguments are expected, in order: 
//    <domain name or IP address of the receiver>
//    <port number of the other process' datagram socket>
//    <port number of this process's datagram socket>
//    <message, a string, to send>

   public static void main(String[] args) {
      if (args.length != 4)
         System.out.println
            ("This program requires four command line arguments");
      else {
         try {      
  		      InetAddress receiverHost = InetAddress.getByName(args[0]);
            int receiverPort = Integer.parseInt(args[1]);
  		      int myPort = Integer.parseInt(args[2]);
            String message = args[3];
            // instantiates a datagram socket for the connection
   	      MyDatagramSocket	mySocket = new MyDatagramSocket(myPort); 
            // make the connection
            mySocket.connect(receiverHost, receiverPort);
            for (int i=0; i<10; i++)  
               mySocket.sendMessage( receiverHost, receiverPort, message);
            // now receive a message from the other end
            System.out.println(mySocket.receiveMessage());
            // cancel the connection, the close the socket
            mySocket.disconnect( );
				mySocket.close( );
         } // end try
	      catch (Exception ex) {
            ex.printStackTrace( );
	      }
      } // end else
   } // end main
} // end class
