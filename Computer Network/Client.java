import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Socket cs = null;
        PrintWriter out = null;
        BufferedReader in = null;
        boolean check=true;
        try {
            while (check) {
                cs = new Socket("localhost", 100);
                in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
                out = new PrintWriter(cs.getOutputStream(), true);
                
                String c = sc.nextLine();
                if (c.equalsIgnoreCase("stop") ) {
                    check=false;
                    break;
                }
                out.println(c);
                String serverMessage = in.readLine();
                System.out.println("Server message: " + serverMessage);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (cs != null) cs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
