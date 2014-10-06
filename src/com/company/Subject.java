package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * Created by kylemartinez on 9/11/14.
 */
public class Subject {

    public String subjectName;
    public SecurityLevel securityLevel;
    public int readValue = 0;

    public String bitsReceived = "";
    private BufferedWriter fileWriter;

    public Subject(String name, SecurityLevel clearanceLevel){
        subjectName = name;
        securityLevel = clearanceLevel;
    }

    public void updateReadValue(int value){
        readValue = value;
    }

    public void run(){
        if(subjectName.equals("lyle")) {
            //write to "secret file based on reads"
            bitsReceived += Integer.toString(readValue);
            if (bitsReceived.length() == 8){
                writeByteToFile();
                bitsReceived = "";
            }
        }
    }

    public void writeByteToFile(){
        try {
            short a = Short.parseShort(bitsReceived, 2);
            ByteBuffer bytes = ByteBuffer.allocate(2).putShort(a);

            byte[] array = bytes.array();
            fileWriter.write(new String(array, "UTF-8"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openFile(String filename) throws IOException{
        FileWriter fstream = new FileWriter(filename);
        fileWriter = new BufferedWriter(fstream);
    }

    public void closeFile(){
        try {
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
