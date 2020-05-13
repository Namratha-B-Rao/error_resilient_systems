package com.nam.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Pattern;

public class TestClient {
    public static void main(String[] args) {
        try {
            //Connection
            System.out.println("Client started");
            Socket soc = new Socket("localhost", 9806);

            //For user to input the query and write to the Client Socket
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the search string");
            String s = userIn.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(s);

            //Reading from the Server Socket
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(in.readLine());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
