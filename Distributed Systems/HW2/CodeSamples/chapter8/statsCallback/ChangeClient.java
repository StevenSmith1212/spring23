// ChangeClient.java    M. Liu   11-4-99
//   This client initiates statisics updates only, which triggers
//   callbacks to all StatsClients objects.
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class ChangeClient
{

   public static void main(String args[]) {
     try{
        // set the client seurity manager
        System.setSecurityManager( new RMISecurityManager () );

        /* locate the RMI registry */
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter the RMIRegistry host namer:");
        String hostName = br.readLine();

        System.out.println("Enter the RMIregistry port number:");
        String portNum = br.readLine();
        int RMIPort = Integer.parseInt(portNum);

        Registry registry = LocateRegistry.getRegistry(hostName,
                                                     RMIPort);
        System.out.println("Registry located.\n");

        // get the remote server object from the Registry
  
        StatsServerInterface theInterface =
           (StatsServerInterface) registry.lookup("stats99");

        System.out.println("Server interface located.\n");

    
        // get the remote server object from the Registry
     
         // make the invocations and display message from server
              theInterface.setStatistics("Packers", 1000, 2000, 3);
              System.out.println("Stats updated\n");
     }
     catch (Exception exc) {
       System.out.println("Exception in client " + exc);
     }
  }

}
 
