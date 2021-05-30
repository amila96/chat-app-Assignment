package com.company.server;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket) {
        this.client=socket;
    }

    @Override
    public void run() {

            try {

                InputStream inputStream=client.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                DataOutputStream outputStream= new DataOutputStream(client.getOutputStream());

                //continuous reading data from client
                String inputData = bufferedReader.readLine();
                System.out.println("Client says : "+inputData);

                Scanner servermsg= new Scanner(System.in);
                System.out.print("Enter a server message: ");
                String str=servermsg.nextLine();
                outputStream.writeBytes(str);

               // client.close();

            } catch (IOException e) {
                e.printStackTrace();

            }

        }

}
