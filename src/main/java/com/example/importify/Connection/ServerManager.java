package com.example.importify.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerManager {
    private ObjectOutputStream sendMessage;
    private ObjectInputStream readMessage;


    public ServerManager(Socket clientSocket) {
        try {
            sendMessage = new ObjectOutputStream(clientSocket.getOutputStream());
            readMessage = new ObjectInputStream(clientSocket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendObject(Object object) {
        try {
            sendMessage.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendString(String text) {
        try {
            sendMessage.writeObject(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObject()
    {
        try {
            return readMessage.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String readString()
    {
        try {
            return (String)readMessage.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
