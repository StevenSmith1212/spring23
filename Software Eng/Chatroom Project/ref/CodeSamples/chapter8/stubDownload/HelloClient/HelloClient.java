import java.io.*;
import java.rmi.*;

/**
 * This class represents the object client for a
 * distributed object of class Hello, which implements
 * the remote interface HelloInterface.  A security  
 * manager is installed to safeguard stub downloading.
 * @author M. L. Liu
 */

public class HelloClient {

  public static void main(String args[]) {
    try {
      int RMIPort;         
      String hostName;
      InputStreamReader is = 
        new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      System.out.println(
        "Enter the RMIRegistry host namer:");
      hostName = br.readLine();
      System.out.println(
        "Enter the RMIregistry port number:");
      String portNum = br.readLine();
      RMIPort = Integer.parseInt(portNum);

      // start a security manager - this is needed if stub
      // downloading is in use for this application.
      System.setSecurityManager(new RMISecurityManager());

      String registryURL = 
        "rmi://localhost:" + portNum + "/hello";  
      // find the remote object and cast it to an 
      //   interface object
      HelloInterface h =
      (HelloInterface)Naming.lookup(registryURL);
      System.out.println("Lookup completed " );
      // invoke the remote method
      String message = h.sayHello();
      System.out.println("HelloClient: " + message);
    } // end try 
    catch (Exception e) {
      System.out.println(
        "Exception in HelloClient: " + e);
    } 
  } //end main
}//end class
