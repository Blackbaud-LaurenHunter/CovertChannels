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

        sys.createSubject("Lyle", low);
        sys.createSubject("Hal", high);

        // We add two objects, one high and one low.

        sys.getReferenceMonitor().createNewObject("Lobj", low);
        sys.getReferenceMonitor().createNewObject("Hobj", high);

        BufferedReader reader = null;

        try {

            String currentInstruction;
            reader = new BufferedReader(new FileReader(args[0]));
            while ((currentInstruction = reader.readLine()) != null) {
                System.out.println(currentInstruction);
                sys.getReferenceMonitor().printState();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
