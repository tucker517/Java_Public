import java.net.*;
import java.io.*;
import java.util.Scanner;




public class server{
	
	//Setup throw exceptions
	public static void main(String[] args) throws IOException{
		
		//Check to make sure the script is running by printing to terminal
		System.out.println("Waiting to establish connections....");
		System.out.println("Please run both client scripts...");
		
		//Enter server port #
		//Establish sockets and listen
		ServerSocket ss = new ServerSocket(5555);
		ServerSocket sd = new ServerSocket(5556);
		Socket s = ss.accept();
		Socket d = sd.accept();
		
		//Check connections established
		if (s.isClosed() || d.isClosed()){
			System.out.println("Check to make sure both client scripts are running...");
		}else if(s.isConnected() && d.isConnected()) {
			System.out.println("\nBoth sockets have been established...");
			System.out.println("Waiting for client inputs before proceeding...\n");
		}
		
		//Setup data stream between client1 and server
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		String client1inp = dis.readUTF();
		
		//Setup Data stream between client2 and server
		DataInputStream did = new DataInputStream(d.getInputStream());
		DataOutputStream dod = new DataOutputStream(d.getOutputStream());
		String client2inp = did.readUTF();

		//Scan for server input
		Scanner sc = new Scanner(System.in);
		
		//Wait for Server Input
		System.out.println("Recieved client integers!");
		System.out.println("-------------------------\n");
		System.out.print("Enter Server Integer Input: ");
		String serverinp = sc.nextLine();
		
		//Send the Server Input to the Clients 1 & 2
    dos.writeUTF(serverinp);
    dod.writeUTF(serverinp);
        
    //Print all integers to the server machine
    //terminal
    System.out.println("\n\nInteger Table (See Below)");
    System.out.println("-----------------------------\n");
    System.out.println("Server  Input Integer: " + serverinp);
    System.out.println("Client1 Input Integer: " + client1inp);
    System.out.println("Client2 Input Integer: " + client2inp);
        
    //Close sockets 
    s.close();
    d.close();
    sc.close();
    ss.close();
    sd.close();
	}
}
