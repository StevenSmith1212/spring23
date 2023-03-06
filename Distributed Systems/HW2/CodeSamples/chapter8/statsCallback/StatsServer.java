//StatsServer.java, modified to accept callback requests.  M. Liu, 11-4-99.

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;
import java.util.*;

public class StatsServer extends UnicastRemoteObject
    implements StatsServerInterface {

  private Vector callbackObjects;

  // vector to store list of callback objects that need to be tended to

  public StatsServer() throws RemoteException {
    super();
    callbackObjects = new Vector();
  }

  public void setStatistics (
    String teamName,
    int    passingYards,
    int    rushingYards,
    int    turnovers
  )
  {
    // invoke each callback object to update the passing yardage
    System.out.println("**************************************\n" +
                       "Server initiating callbacks ---");
    for (int i = 0; i < callbackObjects.size(); i++)
    {
     System.out.println("doing "+ i +"-th callback\n");    
      // convert the vector object to a callback object
      StatsCallbackInterface callback = 
        (StatsCallbackInterface) callbackObjects.elementAt (i);

      // invoke the callback
     try {
       callback.statsChanged ( teamName, passingYards, rushingYards, 
                              turnovers);
     }
     catch (java.rmi.RemoteException re) {
       System.out.println("Exception in StatsServer callback: " + re);
    }
    }  // end for
    System.out.println("**************************************\n" +
                       "Server completed callbacks ---");
  } // end setStatistics

  public void addCallback(
     StatsCallbackInterface StatsCallbackObject) {
     // store the callback object into the vector
     callbackObjects.addElement (StatsCallbackObject);
  }  

  public int getTotalRunningYardage( String teamName)
                throws RemoteException
  {
     if (teamName.equals ( "Packers"))
       return 4320;
     else 
       return 128;
  }

  public int getTotalPassingYardage( String teamName)
                throws RemoteException
  {
     if (teamName.equals ( "Packers"))
       return 1320;
     else 
       return 28;
  }

  public int getTotalTurnovers( String teamName)
                throws RemoteException
  {
     if (teamName.equals ( "Packers"))
       return 0;
     else 
       return 12;
  }

  public static void main(String args[]) {
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    String s;
    int RMIPort;
    Registry registry;
    try{
         System.out.println("Enter the RMIregistry port number:");
         s = br.readLine();
         RMIPort = Integer.parseInt(s);
         System.setSecurityManager(new RMISecurityManager());
         StatsServer h = new StatsServer();
         try {
            registry = LocateRegistry.getRegistry(RMIPort);
            registry.list();  
         }
         catch (Exception e) { // here if registry is not found
            registry = null;
         }
         if (registry == null)
            registry = LocateRegistry.createRegistry(RMIPort);
       // Edit the following line to change the registry ID of the server 
       registry.rebind("stats99", h);
       registry.list();
       System.out.println("Stats Server ready.");
    }// end try
    catch (Exception re) {
      System.out.println("Exception in StatsServer.main: " + re);
    } // end catch
  } // end main
} // end class
