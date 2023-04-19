import java.io.*;
/**
 * This module is to be used with a concurrent Echo server.
 * Its run method carries out the logic of a client session.
 * @author M. L. Liu
 */

class EchoServerThread implements Runnable {
   static final String endMessage = ".";
   MyStreamSocket myDataSocket;

   EchoServerThread(MyStreamSocket myDataSocket) {
      this.myDataSocket = myDataSocket;
   }
 
   public void run( ) {
      boolean done = false;
      String message;
      try {
         while (!done) {
             message = myDataSocket.receiveMessage( );
/**/         System.out.println("message received: "+ message);
             if ((message.trim()).equals (endMessage)){
                //Session over; close the data socket.
/**/            System.out.println("Session over.");
                myDataSocket.close( );
                done = true;
             } //end if
             else {
                // Now send the echo to the requestor
                myDataSocket.sendMessage(message);
             } //end else
          } //end while !done
        }// end try
        catch (Exception ex) {
           System.out.println("Exception caught in thread: " + ex);
        } // end catch
   } //end run
} //end class 
