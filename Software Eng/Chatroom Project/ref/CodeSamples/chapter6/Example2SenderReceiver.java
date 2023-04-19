// This program illustrates sending and receiving using mutlicast

import java.io.*;
import java.net.*;
/**
 * This example illustrates using multithreads to send and
 *  receive multicast in one process. 
 * @author M. L. Liu
 */
public class Example2SenderReceiver{ 

// An application which uses a multicast socket to send
// a single message to a multicast group, and a separate
// thread which uses a separate multicast socket to receive
// messages sent to the same group.
// Three command-line arguments are expected: 
//   <multicast IP address>,<multicast port>,<message>

  public static void main(String[] args) {
  
    InetAddress group = null;
    int port = 0;
    MulticastSocket socket = null;
    String characters;
    byte[] data = null;
  
    if (args.length !=3) 
       System.out.println("Three command-line arguments are expected.");
    else {
       try {
          group = InetAddress.getByName(args[0]);
          port = Integer.parseInt(args[1]);
          characters = args[2];
          data = characters.getBytes();
          DatagramPacket packet = 
             new DatagramPacket(data, data.length, group, port);
          Thread theThread = 
             new Thread(new ReadThread(group, port));
          theThread.start();
          System.out.println("Hit return when ready to send:");
          InputStreamReader is = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(is);
          br.readLine();
          socket = new MulticastSocket(port);
          socket.setTimeToLive(1); 
          socket.send(packet);
          socket.close();
       }
       catch (Exception se) {
          se.printStackTrace( );
       } // end catch
    } //end else
  } // end main

} // end class
