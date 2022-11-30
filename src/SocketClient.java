
import javax.swing.*;
import java.io.*;
import java.net.*;


public class SocketClient {
    public static void main(String[] args)throws IOException{
        String ip ="127.0.0.1";
        int port = 9999;
        Socket s = new Socket(ip,port);

        BufferedReader input= new BufferedReader(new InputStreamReader(s.getInputStream()));

        String serverResponse = input.readLine();
        JOptionPane.showMessageDialog(null,serverResponse);
        s.close();
        System.exit(0);



    }
}
