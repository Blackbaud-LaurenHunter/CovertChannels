package com.company;

/**
 * Created by kylemartinez on 9/13/14.
 */
public class InstructionObject {
    public String subjectName;
    public String objectName;
    public int value;
    public InstructionType type;

    public InstructionObject(String subject, String object, int value, InstructionType type){
        this.subjectName = subject;
        this.objectName = object;
        this.value = value;
        this.type = type;
    }

    public InstructionObject(String subject, String object, InstructionType type){
        this.subjectName = subject;
        this.objectName = object;
        this.type = type;
    }

    public InstructionObject(InstructionType type){
        this.type = type;
    }

}


