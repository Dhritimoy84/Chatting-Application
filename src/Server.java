
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;



public class Server {

//    public static String[] names= {"Dhritimoy", "Ram","Rohan","Rohit"};
//    public static String getRandomName(){
//        String randomElement = names.get(randomizer.nextInt(names.size()));
//    }

    public static void main(String[] args) throws IOException {
        int port = 9999;
        ServerSocket server = new ServerSocket(port);
//        System.out.println("Server waiting for connection....");
        Socket s = server.accept();
        System.out.println("Connection established");

        PrintWriter output = new PrintWriter(s.getOutputStream(), true);
//to read the request from client
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        try {
            while (true) {
                String request = in.readLine();
                if (request.contains("number")) {
                    output.println(Math.random());
                } else {
                    output.println("Type'tell me a number' to get a random number");
                }
            }
        } finally {
            {
                output.close();
                in.close();
                s.close();
                server.close();

            }

        }
    }
}
