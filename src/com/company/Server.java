package com.company;

import java.io.DataOutputStream;
import java.io.IOException;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        //you should run the server first
        System.out.println("Server is running..");
        ServerSocket serverSocket= new ServerSocket(6000);
        System.out.println("Server socket created ..");
        Socket client= serverSocket.accept(); // accept connection from the client. wait until client connect, create local variable name as client
        System.out.println("Server accepted a client");

        //send some data to client
        //to send data use OutputStream

        //OutputStream outputStream= client.getOutputStream();
        //DataOutputStream dataOutputStream=new DataOutputStream(outputStream); //wrapper
        DataOutputStream outputStream= new DataOutputStream(client.getOutputStream());
        outputStream.writeBytes(" Hello from the server..\n");

        client.close();

    }
}
