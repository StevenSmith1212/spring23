
/**
 * This module is to be used with a concurrent Echo server.
 * Its run method carries out the logic of a client session.
 * @author M. L. Liu
 */

class VoteServerThread implements Runnable {
   static final String endMessage = ".";
   MyStreamSocket myDataSocket;

   VoteServerThread(MyStreamSocket myDataSocket) {
      this.myDataSocket = myDataSocket;
   }


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

   public static String vote(String vote){
    if(vote.equals("1")){
          yesCount++; 
          return "System processed a vote of \"Yes\"";
      } 
      if(vote.equals("2")){
          noCount++;
          return "System processed a vote for \"No\"";
      } 
      if (vote.equals("3")){
          dontCareCount++; 
          return "System processed \"I don't care\" ";
      }  
      else {
          return "Please enter a valid input.";
      }
  }//end of processVote

  public static String showVote(String showVoteInput){
    if (showVoteInput.equals("1")){ // showYes Operation
        return showYes();
    }
    if (showVoteInput.equals("2")){ // ShowNo operation
        return showNo(); 
    } 
    if (showVoteInput.equals("3")){ // Show Don't Care Operation
        return showCare(); 
    } else{ 
        return "Please enter a valid input.";
    }
  }//end showVote
   public void run( ) {
        boolean done = false;
        boolean voted = false;
        String message;
        try {
            while (!done) {
                message = myDataSocket.receiveMessage( );
    /**/         System.out.println("message received: "+ message);
                if ((message.trim()).equals (endMessage)){
                    //Session over; close the data socket.
    /**/            System.out.println("Session over.");
                    myDataSocket.close( );
                    done = true;
                } //end if
                else {
                    // Now send the echo to the requestor
                   if(voted != true){
                        String output = vote(message);
                        System.out.println(output);
                        myDataSocket.sendMessage(output);
                        voted = true; 
                   }//end if
                    else {
                        String output = showVote(message);
                        System.out.println(output);
                        myDataSocket.sendMessage(output);
                    }
                } //end else
            } //end while !done
        }// end try
        catch (Exception ex) {
           System.out.println("Exception caught in thread: " + ex);
        } // end catch
   } //end run
} //end class 
