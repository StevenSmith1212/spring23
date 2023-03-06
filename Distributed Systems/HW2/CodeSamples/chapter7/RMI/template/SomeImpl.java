import java.rmi.*;
import java.rmi.server.*;

/**
 * This class implements the remote interface SomeInterface.
 */

public class SomeImpl extends UnicastRemoteObject
   implements SomeInterface {
  
   public SomeImpl() throws RemoteException {
      super( );
   }
  
   public String someMethod1( ) throws RemoteException {
      // code to be supplied
   }

   public int someMethod2( ) throws RemoteException {
      // code to be supplied
   }

} //end class
