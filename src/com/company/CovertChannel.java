package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class CovertChannel {

    public static void main(String[] args) {

        BLPSystem sys = new BLPSystem();

        SecurityLevel low = SecurityLevel.low;
        SecurityLevel high = SecurityLevel.high;

        // We add two subjects, one high and one low.

        sys.createSubject("lyle", low);
        sys.createSubject("hal", high);

        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentInstruction;
        sys.getReferenceMonitor().printState();

        try {
            System.out.println("give instrucitons now, enter q to quit");
            while (!(currentInstruction = reader.readLine()).equals("q")) {
                currentInstruction = currentInstruction.toLowerCase();
                sys.runInstruction(currentInstruction);
            }
            sys.getReferenceMonitor().printState();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }
}
