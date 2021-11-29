package com.example.importify.Connection;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static ServerManager interactionsWithServer;

    public void connectToServer(String host, int port) {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 4444);
            interactionsWithServer = new ServerManager(clientSocket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

