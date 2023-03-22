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
 * --------------------
 * Take the message as the vote, 
 * process the vote and action, 
 * return to gathering input, 
 * 
 * Edge Cases: Invalid Input, throw error, "Please submit a valid input"
 * Edge Case: Should the client be able to vote more than once
 * 
 */

 public class VoteServer{
    public static int noCount; 
    public static int yesCount;
    public static int dontCareCount;

// "Show Methods" will return a string that can be sent to the client
    public static String showNo(){
        
        return "There are... " + noCount + " no votes submitted.";
    }//end showNp
    public static String showYes(){
        return "There are... " + yesCount + " yes votes submitted.";
    }// end showYes

    public static String showCare(){
      return "There are... " + dontCareCount + " I don't care votes submitted.";
    }//end showCare

//processVote will determine the input values and increase the correct votes
    public static String vote(String vote){
        if(vote.equals("1")){
            yesCount++; 
            return "System processed a vote of \"Yes\"";
        } if(vote.equals("2")){
            noCount++;
            return "System processed a vote for \"No\"";
        } if (vote.equals("3")){
            dontCareCount++; 
            return "System processed \"I don't care\" ";
        } if (vote.equals("4")){ // ShowNo operation
            return showNo(); 
        } if (vote.equals("5")){ // showYes Operation
            return showYes();
        } if (vote.equals("6")){ // Show Don't Care Operation
            return showCare(); 
        } else {
            return 
             
             "Please enter a valid input.";
        }
    }//end of processVote

//Session runs continuously until manually stopped, It should constantly look for input, and process the data
    public static void session(int port){
        try {
            MyServerDatagramSocket mySocket = new MyServerDatagramSocket(port);
            System.out.println("Vote Server is ready");
            while(true){
                DatagramMessage request = mySocket.receiveMessageAndSender();
                String initialMessage = "Vote Yes (1) \n Vote No (2) \n Vote I Dont Care (3) \nShow No votes (4) \n Show Yes Votes (5) \n Show Don't Care Vote (6)";
                MySocket.sendMessage(request.getAddress(), request.getPort(), initialMessage);
                String input = request.getMessage().trim();

                String output = vote(input);
                
                mySocket.sendMessage(request.getAddress(), request.getPort(), output);
             }// end while
            }//end try 
            catch (Exception ex) {
                ex.printStackTrace( ); 
            }//end catch     
    }// end session
    public static void main(String[] args){
        int defaultport = 13; 
        session(defaultport);
    }//end of main method
 }// end of VoteServer