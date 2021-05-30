package com.company.server;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        //you should run the server first
        System.out.println("Server is running..");
        ServerSocket serverSocket= new ServerSocket(6000);
        System.out.println("Server socket created ..");

        while(true){
            //server is running forever
            Socket client= serverSocket.accept(); // accept connection from the client. wait until client connect, create local variable name as client
            System.out.println("Server accepted a client");

            ClientHandler clientHandler=new ClientHandler(client);
            Thread thread= new Thread(clientHandler);
            thread.start();
        }

    }
}
