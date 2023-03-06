// file: SomeInterface.java 
// to be implemented by a remote object.

import java.rmi.*;

public interface SomeInterface extends Remote {
	// signature of first remote method
   public String someMethod1( ) 
	   throws java.rmi.RemoteException;
   // signature of second remote method
	public int someMethod2( float someParameter)  				
      throws java.rmi.RemoteException;
   // signature of other remote methods may follow      
} // end interface
