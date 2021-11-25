package com.example.importify.Connection;

import com.example.importify.Model.CountryConstituent;
import com.example.importify.Model.CountryImportExport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

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

    public LinkedList<String> getStrings(String code) {
        sendString(code);
        try {
            return (LinkedList<String>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CountryImportExport> getCountryImportExport(String country) {
        sendString("countryTable + " + country);
        try {
            return (LinkedList<CountryImportExport>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CountryConstituent> getCountryConstituent(String country) {
        sendString("countryTable2 + " + country);
        try {
            return (LinkedList<CountryConstituent>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CountryConstituent> getConstituentValue() {
        sendString("constituentTable");
        try {
            return (LinkedList<CountryConstituent>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
