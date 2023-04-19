// A simple RMI interface file - M. Liu
import java.rmi.*;

/**
 * This is a remote interface.
 * @author M. L. Liu
 */

public interface HelloInterface extends Remote {
/**
 * This remote method returns a message.
 * It accepts no parameter.
 * @return a String message.
 */
  public String sayHello() throws java.rmi.RemoteException;

}
