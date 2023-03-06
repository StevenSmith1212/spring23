
public interface StatsCallbackInterface extends java.rmi.Remote
{
 public  void statsChanged (
     String teamName,
     int passingYards,
     int rushingYards,
     int turnovers) throws java.rmi.RemoteException;
}
