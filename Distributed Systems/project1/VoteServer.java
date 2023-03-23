/* 
 * Author : Steven Smith
 * Date: 3/08/23
 * class: CS 40400
 * Assignement: Project 1
 */
/* Interface
 * Client Side 
 *     ----------------------
 *      (1) Vote Yes
 *      (2) Vote No. 
 *      (3) I Don't Care
 *      (4) Show Me No votes
 *      (5) Show me Yes Votes
 *      (6) Show me I don't care
 * 
 * Server Side
 * -> Should be connectionless
 * -> Should be concurrent
 */
import java.lang.Thread;
import java.net.*;

 public class VoteServer{
  
//processVote will determine the input values and increase the correct votes
   

//Session runs continuously until manually stopped, It should constantly look for input, and process the data
    public static void main(String[] args){
            //Stream Mode Thread version
            int serverPort = 13; 

            if (args.length == 1 )
                 serverPort = Integer.parseInt(args[0]);   
            try{
                ServerSocket myConnectionSocket = new ServerSocket(serverPort); 
                System.out.println("Vote Server Ready");
            
                while(true){
                    //accept connection
                    System.out.println("Awaiting Connection");
                    MyStreamSocket myDataSocket = new MyStreamSocket (myConnectionSocket.accept());
                    System.out.println("Connected");

                    Thread theThread = new Thread(new VoteServerThread(myDataSocket));
                    theThread.start(); 
                }//end While
            }//End try
            catch (Exception ex) {
                ex.printStackTrace();
            }//end catch
            
        }     //end session 



            // Datagram Concurrent Version 
                // MyServerDatagramSocket mySocket = new MyServerDatagramSocket(port);
                // System.out.println("Vote Server is ready");
                // while(true){
                //     DatagramMessage request = mySocket.receiveMessageAndSender();
                //     String initialMessage = "Vote Yes (1) \n Vote No (2) \n Vote I Dont Care (3) \nShow No votes (4) \n Show Yes Votes (5) \n Show Don't Care Vote (6)";
                //     MySocket.sendMessage(request.getAddress(), request.getPort(), initialMessage);
                //     String input = request.getMessage().trim();

                //     String output = vote(input);
                    
                //     mySocket.sendMessage(request.getAddress(), request.getPort(), output);
                //} end while
                //}//end try 
                // end session
   
 }// end of VoteServer