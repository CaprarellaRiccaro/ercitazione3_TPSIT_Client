package com.example;

import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Socket mioSocket = new Socket("localhost", 6789);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
            DataOutputStream outVersoServer = new DataOutputStream(mioSocket.getOutputStream());
            String stringaServer;
            int n = 0;  

            do {
                n++;
                System.out.println("Inserisci un numero da indovinare tra 1 e 100");
                String st = in.readLine();
                outVersoServer.writeBytes(st + '\n');
                stringaServer = inDalServer.readLine();
            } while(Integer.parseInt(stringaServer) != 3);
            
            System.out.println("Numero indovinato in " + n + " tentativi");

            mioSocket.close();
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione!");
            System.exit(1);
        }
    }
}
