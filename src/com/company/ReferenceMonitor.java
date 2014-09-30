package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kylemartinez on 9/12/14.
 */
public class ReferenceMonitor {
    private ObjectManager objectManager;
    private HashMap<String, Subject> subjects;

    public ReferenceMonitor(){
        objectManager = new ObjectManager();
        subjects = new HashMap<String, Subject>();
    }

    public void createNewObject(String name, SecurityLevel level){
        objectManager.addObject(name, level);
    }

    public void addSubject(Subject subject){
        subjects.put(subject.subjectName, subject);
    }

    public void executeInstruction(InstructionObject instruction){
        /*
        * if security levels are the same, subject may read/write to object
        * if subject security level is < object level, subject may write to object
        * if subject security level is > object level, subject may read from object
        *
        * READ-> set sub value
        * WRITE-> set obj value
        */

        //extract information from instruction
        InstructionType op = instruction.type;
        String subname = instruction.subjectName;
        String objname = instruction.objectName;
        
        Subject sub = subjects.get(subname);
        Object obj = objectManager.objects.get(objname);

        SecurityLevel sL = sub.securityLevel;
        SecurityLevel oL = obj.securityLevel;

        switch(op){
            case READ:
                // System.out.print("READ\n");
                if(subjects.containsKey(subname) && objectManager.objects.containsKey(objname)) {
                    if(sL.dominates(oL)){
                        sub.updateReadValue(obj.value);
                    } else sub.readValue = 0;
                } break;
            case WRITE:
                // System.out.print("WRITE\n");
                if(subjects.containsKey(subname) && objectManager.objects.containsKey(objname)) {
                    if(oL.dominates(sL)){
                        obj.updateValue(instruction.value);
                    }
                } break;
            case CREATE:
                //check if object exists, if not then create it with the security level of the subject
                if(!objectManager.objects.containsKey(objname)){
                    createNewObject(objname, sL);
                } break;
            case DESTROY:
                //check if object exists, if there then destroy it
                    objectManager.destroyObject(objname);
                 break;
            case RUN:
                //idk what this does...I'll get back to this later
                break;
        }
    }

    public void printState(){
        System.out.println("The current state is:");
        printObjectState();
        printSubjectState();
    }

    public void printObjectState(){
        for(Map.Entry<String, Object> entry : objectManager.objects.entrySet()){
            Object object = entry.getValue();
            System.out.println(object.name + " has value: " + object.value);
        }
    }

    public void printSubjectState(){
        for(Map.Entry<String, Subject> entry : subjects.entrySet()){
            Subject subject = entry.getValue();
            System.out.println(subject.subjectName + " has recently read: " + subject.readValue);
        }
    }

    private class ObjectManager {
        public HashMap<String, Object> objects;

        public ObjectManager(){
            objects = new HashMap<String, Object>();
        }

        public void addObject(String name, SecurityLevel level){
            Object object = new Object(name, level);
            objects.put(object.name, object);
        }

        public void destroyObject(String name){
            if(objects.containsKey(name))
                objects.remove(name);
        }
    }
}
