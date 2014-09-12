package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SecureSystem {

    public static void main(String[] args) {

        //
        SecurityLevel low = SecurityLevel.low;
        SecurityLevel high = SecurityLevel.high;

        BufferedReader reader = null;

        try {

            String currentInstruction;
            reader = new BufferedReader(new FileReader(args[0]));
            while ((currentInstruction = reader.readLine()) != null) {
                System.out.println(currentInstruction);

                //Project code goes here
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
