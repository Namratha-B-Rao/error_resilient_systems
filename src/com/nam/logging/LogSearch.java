package com.nam.logging;
import java.io.*;


public class LogSearch {
    public static void main(String[] args) {
        try {
            // input file
            FileInputStream fstream = new FileInputStream("C:\\Users\\raona\\Desktop\\test\\machine.i.log");

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            // output file
            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\raona\\Desktop\\test\\out.txt"));

            String strLine;
            Boolean broken = false;
            int line = 0;

            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("Exception")){		// keyword
                    broken = true;
                }
                if (broken) {
                    out.write(strLine);
                    out.newLine();
                    line++;
                }
                if (line == 10) {	// print next 10 lines after exception
                    broken = false;
                    line = 0;
                }
            }

            in.close();
            out.close();
            System.out.println("Successfully written to file");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
