import java.io.*; 
import java.net.*; 

/**
 * This example illustrates the basic syntax for basic multicast.
 * @author M. L. Liu
 */
public class Example1Sender {

// An application which uses a multicast socket to send
// a single message to a multicast group.
// The message is specified as a command-line argument

   public static void main(String[] args) {
      MulticastSocket s;
      InetAddress group;
      if (args.length != 1)
         System.out.println
            ("This program requires a command line argument");
      else {
         try {      
            // create the multicast socket
            group = InetAddress.getByName("239.1.2.3");
            s = new MulticastSocket(3456);
            s.setTimeToLive(32);   // restrict multicast to processes
                                   // running on hosts at the same site.
            String msg = args[0];
            DatagramPacket packet = 
               new DatagramPacket(msg.getBytes(), msg.length(),
                   group, 3456);
            s.send(packet);
            s.close();
         }
         catch (Exception ex) { // here if an error has occurred
            ex.printStackTrace( );
         } // end catch
      }//end else
   }// end main
}// end class
