// A simple RMI interface file - M. Liu
import java.rmi.*;

/**
 * This is a remote interface.
 * @author M. L. Liu
 */

public interface HelloInterface extends Remote {
/**
 * This remote method returns a message.
 * @param  name - a String containing a name.
 * @return a String message.
 */
   public String sayHello(String name) 
      throws java.rmi.RemoteException;
      
 
} //end interface


/*  public class X{
   	  int y;
   	  public void z( ){
   	  	 System.out.println("X.z( ) executed");
   	  }
   }*/
