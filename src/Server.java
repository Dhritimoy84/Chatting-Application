
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
    private static String[] firstName = {"Dhritimoy", "Ram", "Sanjay", "Rohit"};
    private static String[] lastName = {"Majundar", "Das", "Dutta", "Sarma"};

    private static ArrayList<ClientHandler> clientsDS = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(6);

    public static void main(String[] args) throws IOException {
        int port = 9999;
        ServerSocket listener = new ServerSocket(port);

        while (true) {
            System.out.println("[SERVER] waiting for connection....");
            Socket client = listener.accept();
            System.out.println("[SERVER] Connected to Client");
            ClientHandler clientThread = new ClientHandler(client);
            clientsDS.add(clientThread);

            pool.execute(clientThread);

        }
    }

        public static String getRandomName () {
            String name = firstName[(int) (Math.random() * firstName.length)];
            String sureName = lastName[(int) (Math.random() * lastName.length)];
            return name + " " + sureName;
        }
    }
