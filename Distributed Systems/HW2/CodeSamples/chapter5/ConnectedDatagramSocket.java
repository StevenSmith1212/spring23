import java.net.*;
import java.io.*;

/**
 * A subclass of DatagramSocket which contains 
 * methods for sending and receiving messages
 * via a connection.
 * @author M. L. Liu
 */
public class ConnectedDatagramSocket extends DatagramSocket {
   static final int MAX_LEN = 10; 
   InetAddress receiverHost;
   int receiverPort;

   ConnectedDatagramSocket(InetAddress receiverHost, int receiverPort,
                    int myPortNo) throws SocketException{
     super(myPortNo);
     this.receiverHost = receiverHost;
     this.receiverPort = receiverPort;
   }
   public void sendMessage(String message)                         
   		          throws IOException {	
         byte[ ] sendBuffer = message.getBytes( );                                     
         DatagramPacket datagram = 
            new DatagramPacket(sendBuffer, sendBuffer.length, 
                                  receiverHost, receiverPort);
         this.send(datagram);
   } // end sendMessage

   public void receiveMessage()
		throws IOException {		
         byte[ ] receiveBuffer = new byte[MAX_LEN];
         DatagramPacket datagram =
            new DatagramPacket(receiveBuffer, MAX_LEN);
         this.receive(datagram);
         String message = new String(receiveBuffer);
         System.out.println(message);
   } //end receiveMessage
} //end class
