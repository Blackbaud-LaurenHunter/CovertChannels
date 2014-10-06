package com.company;

import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;

public class CovertChannel {

    public static BLPSystem sys;

    public static void main(String[] args) {

        sys = new BLPSystem();

        SecurityLevel low = SecurityLevel.low;
        SecurityLevel high = SecurityLevel.high;

        // We add two subjects, one high and one low.

        sys.createSubject("lyle", low);
        sys.createSubject("hal", high);

        try {

            Path path = Paths.get(args[0]);
            byte[] bytes = Files.readAllBytes(path);
            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
            sys.getReferenceMonitor().getSubject("lyle").openFile(args[0] + ".out");
            createChannel(byteStream);

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
            System.out.println(currentByte);
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
}
