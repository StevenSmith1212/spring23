	
	import java.io.*;

	public class EchoClient2 {
	
	   static final String endMessage = ".";
	
	   public static void main(String[] args) {
		  
		   
	      InputStreamReader is = new InputStreamReader(System.in);
	      BufferedReader br = new BufferedReader(is);
	      
	      try {
	         System.out.println("Welcome to the Echo client.\n" +
	                            "What is the name of the server host?");
	         String hostName = br.readLine();
	         if (hostName.length() == 0) // if user did not enter a name
	            hostName = "localhost";  //   use the default host name
	         System.out.println("What is the port number of the server host?");
	         String portNum = br.readLine();
	         if (portNum.length() == 0)
	            portNum = "13";          // default port number
	         
	         EchoClientHelper2 helper = 
	             new EchoClientHelper2(hostName, portNum);
	         boolean done = false;
	         String message, echo;
	              while (!done) {
	                 System.out.println("Enter a line to receive an echo back from the server, "
	                                 + "or a single peroid to quit.");
	                 message = br.readLine( );
	                 if ((message.trim()).equals (endMessage)){
	                    done = true;
	                    helper.done( );
	                 }
	                 else {
	                    echo = helper.getEcho(message);
	                    System.out.println(echo);
	                 }
	               } // end while
	           } // end try  
	           catch (Exception ex) {
	              ex.printStackTrace( );
	           }
	   }
	} // end class    