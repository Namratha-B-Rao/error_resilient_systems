package com.nam.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TestServer {
    public static void main(String[] args) throws IOException {
        try
        {
            //Establishing connection
            System.out.println("Waiting for client");
            ServerSocket ss = new ServerSocket(9806);
            Socket soc = ss.accept();
            System.out.println("Connection established");

            //Reading from the Client socket and performing the search
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String q = in.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println("Matched lines per queried " + calPattern(q));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    static String calPattern(String s)
    {
        Pattern sre = null;        // Compiled RE
        try {
            sre = Pattern.compile(s);
        } catch (PatternSyntaxException e) {
            System.err.println("Invalid RE syntax: " + e.getDescription());
            System.exit(1);
        }

        BufferedReader br = null;
        try {
            FileInputStream fstream = new FileInputStream("C:\\Users\\raona\\Desktop\\test\\machine.i.log");
            DataInputStream inp = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(inp));
        }catch (FileNotFoundException e) {
            System.err.println("Unable to open file :" + e.getMessage());
            System.exit(1);
        }

        StringBuilder sb = new StringBuilder();
        String res = "";
        try {
            String st;
            while ((st = br.readLine()) != null) {
                Matcher m = sre.matcher(st);
                if (m.find())
                    sb.append(" | " +st);
                    //sb.append("\n");
            }
            res = sb.toString();
            //System.out.println(res);
        } catch (Exception e) {
            System.err.println("Error reading line: " + e.getMessage());
            System.exit(1);
        }
        return res;
    }
}
