package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Client is running");
        Socket socket=new Socket("localhost",6000);


        //get the data from the server
        InputStream inputStream=socket.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream)); //bufferedreader-wait untill all content buffered without read charactor by charactor
        String receivedData= bufferedReader.readLine();//it wait untill \n
        System.out.println("Data received from Server: "+receivedData);
        System.out.println("Client finished the execution...");
    }

}
