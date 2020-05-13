package com.nam.logging;

import java.util.logging.*;
//import java.io.*;

//import static java.util.logging.Level.WARNING;

public class Dlogging {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Dlogging.class.getName());
        FileHandler fh;

        try{
            fh = new FileHandler("C:\\Users\\raona\\Desktop\\test\\machine.i.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setLevel(Level.ALL);

            logger.info("This is the first log");
            logger.log(Level.INFO, "This is the Log information");
            logger.log(Level.WARNING, "Needs Attention");
            int i = 1/0;

        } catch(Exception e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }
        //catch(SecurityException e) {
            //e.printStackTrace();
        //} catch(IOException e) {
            //e.printStackTrace();
        }
        //logger.info("Exception :As we continue to log");

    }

