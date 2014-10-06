package com.company;

import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.Timer;

public class CovertChannel {

    public static BLPSystem sys;
    private static boolean createLog = false;
    private static BufferedWriter logWriter;

    public static void main(String[] args) {

        sys = new BLPSystem();

        SecurityLevel low = SecurityLevel.low;
        SecurityLevel high = SecurityLevel.high;

        // We add two subjects, one high and one low.

        sys.createSubject("lyle", low);
        sys.createSubject("hal", high);

        try {
            Path path;
            if (args.length == 2){
                if (args[0].equals("v")){
                    openLogFile();
                }
                path = Paths.get(args[1]);
            } else{
                path = Paths.get(args[0]);
            }

            long startTime = System.currentTimeMillis();
            byte[] bytes = Files.readAllBytes(path);
            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
            sys.getReferenceMonitor().getSubject("lyle").openFile(args[0] + ".out");
            createChannel(byteStream);
            closeLogFile();
            long endTime = System.currentTimeMillis();
            System.out.println("Number of Bits: " + bytes.length * 8);
            System.out.println("Time Elapsed: " + (endTime - startTime) * 0.001);
            System.out.println("Bits per Second: " + (bytes.length * 8) / ((endTime - startTime) * 0.001));


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            sys.getReferenceMonitor().getSubject("lyle").closeFile();
        }
    }

    private static void createChannel(ByteArrayInputStream inputStream) {
        String currentByte;
        while (inputStream.available() > 0) {
            currentByte = String.format("%8s", Integer.toBinaryString(inputStream.read())).replace(' ', '0');
            //System.out.println(currentByte);
            for (int i = 0; i < currentByte.length(); i++) {
                String bitToSend = currentByte.substring(i, i+1);
                sendBit(bitToSend);
            }
        }
    }

    private static void sendBit(String bitToSend){
        sys.runInstruction("RUN hal");
        if (bitToSend.equals("0")){
            sys.runInstruction("CREATE hal obj");
        }
        runLylesInstructions();
    }

    private static void runLylesInstructions(){
        sys.runInstruction("CREATE lyle obj");
        sys.runInstruction("WRITE lyle obj 1");
        sys.runInstruction("READ lyle obj");
        sys.runInstruction("DESTROY lyle obj");
        sys.runInstruction("RUN lyle");
    }

   private static void openLogFile() throws IOException{
      FileWriter logFile = new FileWriter("log");
       sys.logWriter = new BufferedWriter(logFile);
   }

    private static void closeLogFile() throws  IOException{
        if (sys.logWriter != null){
            sys.logWriter.close();
        }
    }
}
