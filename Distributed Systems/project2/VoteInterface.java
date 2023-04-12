import java.rmi.*; 
public interface VoteInterface extends Remote {

    /**
     * this remote method returns the current vote numbers within the global variable
     * @param input - a integer input that contains which type of vote they would like to return
     * @return String - the current vote 
     */
    public String getVotes(String input)
        throws java.rmi.RemoteException;
   


    /**
     * 
     * @param input - integer that represents what they vote for
     * @return String - confirming message that they have voted
     * @throws java.rmi.RemoteException
     */
    public String Vote(String input) throws java.rmi.RemoteException; 
}// end interface
