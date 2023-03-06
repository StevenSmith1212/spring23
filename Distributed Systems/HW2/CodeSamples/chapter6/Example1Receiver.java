import java.io.*; 
import java.net.*; 

/**
 * This example illustrates the basic syntax for basic multicast.
 * @author M. L. Liu
 */
public class Example1Receiver {

// An application which joins a multicast group and
// receives a  single message sent to the group.
   static MulticastSocket s;
   static InetAddress group;
   public static void main(String[] args) {
      try {      
         // join a Multicast group and send the group salutations
         group = InetAddress.getByName("239.1.2.3");
         s = new MulticastSocket(3456);
         System.out.println("Joined group at 239.1.2.3 port 3456");
         s.joinGroup(group);
         byte[] buf = new byte[100];
         DatagramPacket recv = new DatagramPacket(buf, buf.length);
         s.receive(recv);
         System.out.println(new String(buf));
         s.close();
       }
       catch (Exception ex) { // here if an error has occurred
          ex.printStackTrace( ); 
       }
    }// end main
}// end class
 

