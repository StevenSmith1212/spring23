// StatsClient; modified to illustrate callbacks.   M. Liu, 11-4-99
// This client requires a command-line argument specifying the RMI registry
//   port.
// It prompts for statistics update, and accepts callbacks whenever changes
//   statics updates are made (by this and other clients).
 
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

// call back method - will be run in its own thread when server 
// initiates a callback
public class StatsClient implements StatsCallbackInterface
{
  Registry registry;  // to hold the reference to the registry

  public void statsChanged (
      String teamName,
      int    passingYards,
      int    rushingYards,
      int    turnovers
  )
  {
     System.out.println ("****Sports update****");
     System.out.println("\t" + teamName+ ": ");
     System.out.println("\t\t"+ "Yards passing: " + passingYards);
     System.out.println("\t\t" + "Yards rushing: " + rushingYards);
     System.out.println("\t\t" + "Turnovers: " + turnovers);
  }

  // constructor
  // @param theServerInterface: the interface object for the remote server
  StatsClient(StatsServerInterface theServerInterface){              
     try{
         // convert this object to an exportable object
         UnicastRemoteObject.exportObject(this);
         // register for callback
         theServerInterface.addCallback(this);
         System.out.println("Registered for callback\n");
     }
     catch (Exception exc) {
         System.out.println("Exception in client callback"
                                 + exc);
     }
  } // end constructor

  public static void main(String args[]) {
     try {
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

         // create a client object for callback
         StatsClient client   = new StatsClient(theInterface);

         // make the invocations and display message from server

         BufferedReader console = new
             BufferedReader(new InputStreamReader(System.in));
         while (true) {
            System.out.println("Enter a team name:");
            String teamname = console.readLine( );
            System.out.println("Enter passing yards");
            String input = console.readLine( );
            int passing = Integer.parseInt(input);
            System.out.println("Enter rushing yards");
            input = console.readLine( );
            int rushing = Integer.parseInt(input);
            System.out.println("Enter turnovers");
            input = console.readLine( );
            int turnovers = Integer.parseInt(input);
            theInterface.setStatistics(teamname, passing, rushing, turnovers);
        } //end while
     }// end try
     catch (Exception exc) {
        System.out.println("Exception in client " + exc.toString());
     } // end catch
  } // end main
} //end class
 
