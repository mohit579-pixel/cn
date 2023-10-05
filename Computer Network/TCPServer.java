import java.io.*;
import java.net.*;
import java.util.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(100);
            System.out.println("Server is listening on port 100");

            Socket cs = ss.accept();
            System.out.println("Client is connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

            String clientMessage = in.readLine();
            System.out.println("Client Says: " + clientMessage);

            while (true)  {
                // Read a message from the server user input
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter a message to send to the client: ");
                String serverMessage = sc.nextLine();
                if(serverMessage.equalsIgnoreCase("stop") || clientMessage.equalsIgnoreCase("stop")){
                break;
                }
                out.println(serverMessage);
                clientMessage = in.readLine();
                System.out.println("Client Says: " + clientMessage);
                if(serverMessage.equalsIgnoreCase("stop") || clientMessage.equalsIgnoreCase("stop")){
                break;
                }
            
                
            }

            // Close resources and the socket when the client types "stop"
            in.close();
            out.close();
            cs.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
