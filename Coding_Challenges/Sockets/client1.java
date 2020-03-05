import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.InetAddress; 
import java.net.Socket;  
import java.util.Scanner; 
  
public class client1{
	//Setup throw exceptions
    public static void main(String[] args) throws IOException{ 
    	//Enter IP address of host/server machine
    	//Enter port # of Host/Server machine
    	InetAddress ip = InetAddress.getByName("127.0.0.1"); 
        int port = 5555; 
        Scanner sc = new Scanner(System.in); 
  
        //Step 1: Open the socket connection. 
        Socket s = new Socket(ip, port); 
  
        //Step 2: Communication-get the input and output stream 
        DataInputStream dis = new DataInputStream(s.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
  
        
        //Enter your integer to be sent 
        //to the server
        System.out.print("Enter Client1 Integer: "); 
        String client1inp = sc.nextLine();
  
        //Send the integer to the server
        dos.writeUTF(client1inp); 
            
        //Waiting for the server to send its input
        System.out.println("\n\n\nWaiting for the Server to send an integer...\n\n\n");
  
        //Read the integer from the server
        String serverout = dis.readUTF(); 
            

        //Print out both server and client integer to console
        System.out.println("Server/Client1 Input Integer Table (See Below)");
        System.out.println("----------------------------------------------\n");
        System.out.println("Server  Input Integer: " + serverout); 
        System.out.println("Client1 Input Integer: " + client1inp);
        
        //Close Sockets
        s.close();
        sc.close();
    } 
} 

