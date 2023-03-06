import java.net.*;
import java.io.*;
/**
 * This class is to be used with Example2SenderReceiver for
 * reading multicast messages while the main thread sends
 * a multicast message.  Each message read is echoed on the
 * screen.
 * @author M. L. Liu
 */
class ReadThread implements Runnable {

   static final int MAX_LEN = 30;
   private InetAddress group;
   private int port;

  public ReadThread(InetAddress group, int port) {  
    this.group = group ;
    this.port = port;    
  }

  public void run() {

    try {

       MulticastSocket socket = new MulticastSocket(port);
       socket.joinGroup(group);
       while (true) {
          byte[] data = new byte[MAX_LEN];
          DatagramPacket packet = 
             new DatagramPacket(data, data.length, group, port);
          socket.receive(packet);
          String s = new String(packet.getData());
          System.out.println(s);
       } //end while
    }  // end catch
    catch (Exception exception) {
       exception.printStackTrace( );
    }
  } // end run

} //end class
