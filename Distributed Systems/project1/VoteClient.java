import java.io.*;

public class VoteClient {
    static final String endMessage = "exit";
    public static boolean voted = false; 
    public static void main(String[] args){

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        try{
            System.out.println("Welcome to Vote Client Enter server host");
            String hostName = br.readLine();
            if (hostName.length() == 0) // if user did not enter a name
                hostName = "localhost";  //   use the default host name
            System.out.println("What is the port number of the server host?");
            String portNum = br.readLine();
            if (portNum.length() == 0)
                portNum = "13";          // default port number

            EchoClientHelper2 helper = new EchoClientHelper2(hostName, portNum); 
           

            boolean done = false; 
            String message, echo; 
            System.out.println(
                "Vote Yes (1)" + 
                "\nVote No (2)" + 
                "\nVote I Dont Care (3)" + 
                "\ntype 'exit' to exit");
                message = br.readLine( );
                if ((message.trim()).equals (endMessage)){
                    done = true;
                    helper.done( );
                }
                else {
                    echo = helper.getEcho( message);
                    System.out.println(echo);
                    voted = true; 
                }

            while(!done){
                System.out.println(
                "\nShow Yes votes (1)" + 
                "\nShow No Votes (2)"+ 
                "\nShow Dont Care Votes (3)" +
                "\ntype 'exit' to exit"); 
                message = br.readLine( );
                if ((message.trim()).equals (endMessage)){
                    done = true;
                    helper.done( );
                }
                else {
                    echo = helper.getEcho( message);
                    System.out.println(echo);
                }
                } // end while
            } // end try
        catch (Exception ex){
            ex.printStackTrace(); 
        } // end catch
    }// end main
}//end class
