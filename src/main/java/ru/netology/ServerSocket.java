package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocket {
    public static void main(String[] args) {

        try {

            try (java.net.ServerSocket serverSocket = new java.net.ServerSocket(8888);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                 System.out.printf("New connection accepted Port: %d%n", clientSocket.getPort());
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}