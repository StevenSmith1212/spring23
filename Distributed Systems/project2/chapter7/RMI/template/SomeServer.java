import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;

/**
 * This class represents the object server for a distributed
 * object of class SomeImpl, which implements the remote 
 * interface SomeInterface.
 */

public class SomeServer  {
   public static void main(String args[]) {
      String portNum = "1234", registryURL;
      try{   
 		   // code for obtaining RMI port number value omitted
         SomeImpl exportedObj = new SomeImpl();
         startRegistry(1234);
         // register the object under the name "some"
         registryURL = "rmi://localhost:" + portNum + "/some";
         Naming.rebind(registryURL, exportedObj);
         System.out.println("Some Server ready.");
      }// end try
      catch (Exception re) {
         System.out.println(
            "Exception in SomeServer.main: " + re);
      } // end catch
  } // end main

   // This method starts a RMI registry on the local host, if it
   // does not already exist at the specified port number.
   private static void startRegistry(int RMIPortNum)
      throws RemoteException{
      try {
         Registry registry = LocateRegistry.getRegistry(RMIPortNum);
         registry.list( );  
			// The above call will throw an exception
         // if the registry does not already exist
      }
      catch (RemoteException ex) {
         // No valid registry at that port.
         System.out.println(
            "RMI registry cannot be located at port " 
            + RMIPortNum);
         Registry registry = LocateRegistry.createRegistry(RMIPortNum);
         System.out.println(
            "RMI registry created at port " + RMIPortNum);
      }
   } // end startRegistry
     
} // end class
