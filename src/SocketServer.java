
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;



public class SocketServer {
    
    public static void main(String[] args) throws IOException{
    int port =9999;
    ServerSocket server=new ServerSocket(port);
        System.out.println("Server waiting for connection....");
        Socket s = server.accept();
        System.out.println("Connection established");

    PrintWriter output= new PrintWriter(s.getOutputStream(),true);
    String date= (new Date()).toString();
    System.out.println("Server sending date "+ date);
    output.println(date);

    System.out.println("Server sent data closing.............");

    server.close();
    s.close();


    }
}
