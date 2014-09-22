package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SecureSystem {

    public static void main(String[] args) {

        BLPSystem sys = new BLPSystem();

        SecurityLevel low = SecurityLevel.low;
        SecurityLevel high = SecurityLevel.high;

        // We add two subjects, one high and one low.

        sys.createSubject("lyle", low);
        sys.createSubject("hal", high);

        // We add two objects, one high and one low.

        sys.getReferenceMonitor().createNewObject("lobj", low);
        sys.getReferenceMonitor().createNewObject("hobj", high);

        BufferedReader reader = null;

        try {

            String currentInstruction;
            reader = new BufferedReader(new FileReader(args[0]));
            while ((currentInstruction = reader.readLine()) != null) {
                currentInstruction = currentInstruction.toLowerCase();
                System.out.println(currentInstruction);
                sys.runInstruction(currentInstruction);
                sys.getReferenceMonitor().printState();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
