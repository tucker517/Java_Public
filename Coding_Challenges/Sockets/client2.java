import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.InetAddress; 
import java.net.Socket;  
import java.util.Scanner; 
  
public class client2{ 
	//Setup throw exceptions
    public static void main(String[] args) throws IOException{ 
    	//Enter IP address of host/server machine
    	//Enter port # of Host/Server machine
    	InetAddress ip = InetAddress.getByName("XXXX");
        int port = XXXX; 
        Scanner sc = new Scanner(System.in); 
  
        //Step 1: Open the socket connection. 
        Socket d = new Socket(ip, port); 
  
        //Step 2: Communication-get the input and output stream 
        DataInputStream did = new DataInputStream(d.getInputStream()); 
        DataOutputStream dod = new DataOutputStream(d.getOutputStream()); 
  
        
        //Enter your integer to be sent 
        //to the server
        System.out.print("Enter Client2 Integer: ");  
        String client2inp = sc.nextLine();
  
        //Send the integer to the server
        dod.writeUTF(client2inp); 
            
        //Waiting for the server to send its input
        System.out.println("\n\n\nWaiting for the Server to send an integer...\n\n\n");
        
        //Read the integer from the server
        String serverout = did.readUTF(); 
            
            
        //Print out both Server and Client integer to console
        System.out.println("Server/Client2 Input Integer Table (See Below)");
        System.out.println("----------------------------------------------\n");
        System.out.println("Server  Input Integer: " + serverout); 
        System.out.println("Client2 Input Integer: " + client2inp);
        
        //Close Sockets
        d.close();
        sc.close();
    } 
} 

