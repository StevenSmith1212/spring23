import java.io.*;

/**
 * This module contains the presentaton logic of a DaytimeClient.
 * @author M. L. Liu
 */

public class DaytimeClient2 {
   public static void main(String[] args) {
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      try {
         System.out.println("Welcome to the Daytime client.\n" +
                            "What is the name of the server host?");
         String hostName = br.readLine();
         if (hostName.length() == 0) // if user did not enter a name
            hostName = "localhost";  //   use the default host name
         System.out.println("What is the port number of the server host?");
         String portNum = br.readLine();
         if (portNum.length() == 0)
            portNum = "13";          // default port number
         System.out.println("Here is the timestamp received from the server"
            + DaytimeClientHelper2.getTimestamp(hostName, portNum));
      } // end try  
      catch (Exception ex) {
         ex.printStackTrace( );
      } // end catch
   } //end main
} // end class     
