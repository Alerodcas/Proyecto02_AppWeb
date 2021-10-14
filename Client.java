/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project02.Proyecto02_AppWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author alero
 */
public class Client {
    
    public static void main(String[] args){
    String host = "127.0.0.1";
    int port = 7777;
    try (Socket socket = new Socket(host, port)){
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);
        String line = null;
        while(!"exit".equalsIgnoreCase(line)){
            line = scanner.nextLine();
            out.println(line);
            out.flush();
            System.out.println("Message sent");
            //System.out.println(in.read());
        }
        scanner.close();
    }catch (IOException e){
        e.printStackTrace();
    }
    }
}
