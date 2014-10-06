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

    public static void main(String[] args) {

        BLPSystem sys = new BLPSystem();

        SecurityLevel low = SecurityLevel.low;
        SecurityLevel high = SecurityLevel.high;

        // We add two subjects, one high and one low.

        sys.createSubject("lyle", low);
        sys.createSubject("hal", high);

        try {

            Path path = Paths.get(args[0]);
            byte[] bytes = Files.readAllBytes(path);
            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);



            String currentByte;
            while (byteStream.available() > 0) {
                currentByte = String.format("%8s", Integer.toBinaryString(byteStream.read())).replace(' ', '0');
                System.out.println(currentByte);
                for (int i = 0; i < currentByte.length(); i++) {

                }


            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
