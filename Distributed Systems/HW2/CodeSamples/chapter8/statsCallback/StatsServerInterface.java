import java.rmi.*;

public interface StatsServerInterface extends Remote {

  public int getTotalRunningYardage(String teamname)
     throws java.rmi.RemoteException;

  public int getTotalPassingYardage(String teamname)
     throws java.rmi.RemoteException;

  public int getTotalTurnovers(String teamname)
     throws java.rmi.RemoteException;

  public void setStatistics(String teamnam,
                           int passingYards,
                           int rushingYards,
                           int turnovers )
     throws java.rmi.RemoteException;

  public void addCallback(
    StatsCallbackInterface statsCallbackObject)
    throws java.rmi.RemoteException;
}
