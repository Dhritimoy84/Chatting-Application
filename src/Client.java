
import java.io.*;
import java.net.*;


public class Client {
    public static void main(String[] args)throws IOException{
        String ip ="127.0.0.1";
        int port = 9999;
        //creating the socket for client
        Socket client  = new Socket(ip,port);
//to read the input from server
        BufferedReader input= new BufferedReader(new InputStreamReader(client.getInputStream()));
        //to read the input from keyboard
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        //to send data to server
        PrintWriter out= new PrintWriter(client.getOutputStream(),true);

        while(true){
            System.out.println(">");
            //reads the input from keyboard
            String command= keyboard.readLine();

            //if commands from keyboard contains "quit",then while loop will break
            if(command.equals("quit")) {
                break;
            }

            out.println(command);

            //reads the input from server
            String serverResponse= input.readLine();
            //prints the input receives from server
            System.out.println("Server says: " + serverResponse);
        }

      //closing the resources
        client.close();
        System.exit(0);



    }
}
