package com.example.importify.Connection;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static ServerManager interactionsWithServer;

    public void connectToServer() {
        try {
            Socket clientSocket = new Socket("localhost", 4404);
            interactionsWithServer = new ServerManager(clientSocket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

