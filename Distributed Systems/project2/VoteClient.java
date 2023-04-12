
import java.io.*;
import java.rmi.*;

public class VoteClient {

    public static void main(String args[]) {
        try {
            int RMIPort;
            String hostName;
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("Enter the RMIRegistry host namer:");
            hostName = br.readLine();
            System.out.println("Enter the RMIregistry port number:");
            String portNum = br.readLine();
            RMIPort = Integer.parseInt(portNum);
            String registryURL = "rmi://" + hostName + ":" + portNum + "/vote";

            // find the remote object and cast it to an interface object
            VoteInterface V = (VoteInterface) Naming.lookup(registryURL);
            System.out.println("Lookup completed ");

            System.out.println("Vote Yes (1)" +
                    "\nVote No (2)" +
                    "\nVote I Dont Care (3)" +
                    "\ntype 'exit' to exit");

            String input = br.readLine();

            // invoke the remote method
            String message = V.Vote(input.trim());
            System.out.println(message + "\n Press any key to continue...");
            br.readLine(); 
            boolean done = false;
            while (!done) { // Forever Loop until broken
                System.out.println("Input which votes you would like to see...\n" +
                        "Show Yes Votes (1) \n" +
                        "Show No Votes (2)\n" +
                        "Show Dont Care Votes (3) \n" +
                        "input 'exit' to exit");
                input = br.readLine();
                if (input.equals("exit")){
                    System.out.println("Goodbye"); 
                    break;
                }

                message = V.getVotes(input.trim());
                System.out.println(message + "\n Press any key to continue...");
                br.readLine(); 
            }

        } // end try
        catch (Exception e) {
            System.out.println("Exception in VoteClient: " + e);
        }
    }// End Main
}// end VoteClient
