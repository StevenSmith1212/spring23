import java.io.*;

/**
 * This module contains the presentation logic of a counter Client.
 * @author M. L. Liu
 */
public class CounterClient1 {
   public static void main(String[] args) {
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      try {
         System.out.println("Welcome to the Counter client.\n" +
                            "What is the name of the server host?");
         String hostName = br.readLine();
         if (hostName.length() == 0) // if user did not enter a name
            hostName = "localhost";  //   use the default host name
         System.out.println("Enter the port # of the server host:");
         String portNum = br.readLine();
         if (portNum.length() == 0)
            portNum = "12345";       // default port number
         System.out.println
            ("Here is the counter received from the server: "
             + CounterClientHelper1.getCounter(hostName, portNum));
      } // end try  
      catch (Exception ex) {
         ex.printStackTrace( );
      } // end catch
   } //end main
} // end class     
