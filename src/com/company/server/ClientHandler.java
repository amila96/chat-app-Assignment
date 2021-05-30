package com.company.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket) {
        this.client=socket;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(30000); //wait for 30s before execute the rest of the code
            //receive data

            InputStream inputStream=client.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream= new DataOutputStream(client.getOutputStream());

        /*String data= bufferedReader.readLine();
        System.out.println("Data received from the client"+data);*/

            //continuous reading data from client
            String inputData;
            while((inputData= bufferedReader.readLine())!=null){

                System.out.println("Client says : "+inputData);

                switch (inputData){
                    case "Hello from the Client":
                        outputStream.writeBytes(" Hello from the server..\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes(" I'm fine, how are you..\n");
                        break;
                    case "I'm fine":
                        outputStream.writeBytes("Ok good to know\n");
                        break;
                    case "Thank you":
                        outputStream.writeBytes("You are welocme \n");
                        break;
                    default:
                        outputStream.writeBytes("I didn't understand it \n");
                }



                if(inputData.equals("exit")){
                    break;
                }
            }

            //send some data to client
            //to send data use OutputStream

            //OutputStream outputStream= client.getOutputStream();
            //DataOutputStream dataOutputStream=new DataOutputStream(outputStream); //wrapper

            /*
             */

            client.close();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();

        }


    }
}
