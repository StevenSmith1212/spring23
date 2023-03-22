import java.io.*;
import java.net.InetAddress;
public class VoteClient {
    static final String endMessage = "exit";

    public static void main(String[] args){
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        try{
            System.out.println("Welcome to Vote Client");
            System.out.println("Enter server host");
            String hostName = br.readLine();
            if (hostName.length() == 0) // if user did not enter a name
            hostName = "localhost";  //   use the default host name
            System.out.println("What is the port number of the server host?");
            String portNum = br.readLine();
            if (portNum.length() == 0)
                portNum = "13";          // default port number

            EchoClientHelper1 helper = new EchoClientHelper1(hostName, portNum); 
           

            boolean done = false; 
            String message; 
            while(!done){
                System.out.println(
                "Vote Yes (1)" + 
                "\nVote No (2)" + 
                "\nVote I Dont Care (3)" +
                "\nShow No votes (4)" + 
                "\nShow Yes Votes (5)"+ 
                "\nShow Dont Care Votes (6)"); 
                message = br.readLine( );
                if ((message.trim()).equals (endMessage)){
                done = true;
                helper.done( );
                }
                else {
                String echo = helper.getEcho( message);
                System.out.println(echo);
                br.readLine(); 
                }
                } // end while
            } // end try
        catch (Exception ex){
            ex.printStackTrace(); 
        } // end catch
    }// end main
}//end class
