package com.company.client;

import java.io.*;
import java.util.Scanner;

public class ChatClient1 {
    public static void main(String[] args) throws IOException {

        Client client= new Client();
        client.start();

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a Client1 message: ");
        String str=sc.nextLine();
        client.sendMessage(str+"\n");

        System.out.println("Client finished the execution...");

    }

}
