import java.io.*;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
* This class represents the object client for a distributed
* object of class SomeImpl, which implements the remote 
* interface SomeInterface.
*/

public class SomeClient {
   public static void main(String args[]) {
      try {
         int RMIPort;         
        	String hostName;
         String portNum;
        	// Code for obtaining hostName and RMI Registry port 
       	// to be supplied.

         // Look up the remote object and cast its reference 
         // to the remote interface class -- replace "localhost"
         // with the appropriate host name of the remote object.
			String registryURL = 
				"rmi://localhost:" + portNum + "/some";  
			SomeInterface h =
           	(SomeInterface)Naming.lookup(registryURL);
         // invoke the remote method(s)
         String message = h.method1();
         System.out.println(message);
         // method2 can be invoked similarly
      } // end try 
      catch (Exception ex) {
         ex.printStackTrace( );
      } // end catch
   } //end main
   // Definition for other methods of the class, if any.
}//end class
