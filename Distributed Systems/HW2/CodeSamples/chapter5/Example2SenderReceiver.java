import java.net.*;

/**
 * This example illustrates a process which sends then receives
 * using a datagram socket.
 * @author M. L. Liu
 */
public class Example2SenderReceiver {
// An application which sends then receives a message using
// connectionless datagram socket.
// Four command line arguments are expected, in order: 
//    <domain name or IP address of the receiver>
//    <port number of the receiver's datagram socket>
//    <port number of this process's datagram socket>
//    <message, a string, to send>

   public static void main(String[] args) {
      if (args.length != 4)
         System.out.println
            ("This program requires four command line arguments");
      else {
         try {      
  		      InetAddress receiverHost = InetAddress.getByName(args[0]);
  		      int myPort = Integer.parseInt(args[1]);
            int receiverPort = Integer.parseInt(args[2]);
            String message = args[3];
   	      MyDatagramSocket mySocket = new MyDatagramSocket(myPort);  
               // instantiates a datagram socket for both sending
               // and receiving data
            mySocket.sendMessage( receiverHost, receiverPort, message);
				// now wait to receive a datagram from the socket
            System.out.println(mySocket.receiveMessage());
				mySocket.close( );
         } // end try
	 catch (Exception ex) {
	 }
      } //end else
   } //end main 


} //end class
