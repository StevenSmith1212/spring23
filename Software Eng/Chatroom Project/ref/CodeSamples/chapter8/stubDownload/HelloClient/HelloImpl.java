import java.rmi.*;
import java.rmi.server.*;

/**
 * This class implements the remote interface HelloInterface.
 * @author M. L. Liu
 */

public class HelloImpl extends UnicastRemoteObject
     implements HelloInterface {
  
   public HelloImpl() throws RemoteException {
      super( );
   }
  
   public String sayHello() throws RemoteException {
      return "Hello, World!";
   }
} // end class
