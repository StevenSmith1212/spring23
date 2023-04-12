import java.rmi.*;
import java.rmi.server.*;

public class VoteImpl extends UnicastRemoteObject
     implements VoteInterface {

        private int yesVotes, noVotes, dontCareVotes; 
        public VoteImpl() throws RemoteException{
            super();
        }


        public String getVotes(String input) throws RemoteException{
            String message; 
            if(input.equals( "1") ){ //getYes
                message = "There are currently, " + yesVotes + " votes for Yes";
            } else if (input.equals("2")){
                message = "There are currently, " + noVotes + " votes for No";
            }else if (input.equals("3")){
                message = "There are currently, " + dontCareVotes + " votes for Don't Care";
            }else if (input.equals("exit")){
                message = "Goodbye";
            }else {
                message = "Input value is invalid";
            }
            return message; 
        } // end getVotes


        public String Vote(String input) throws RemoteException{
            String message;
            if (input.equals("1")){
                yesVotes++; 
                message = "You have voted for Yes";
            }else if (input.equals("2")){
                noVotes++; 
                message = "You have voted for No";
            } else if (input.equals("3")){
                dontCareVotes++;
                message = "you have voted for Don't Care";
            }else{ 
                message = "Please input a valid input";
            } 
            return message;
        }
    
}
