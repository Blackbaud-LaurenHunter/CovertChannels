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

    public Subject getSubject(String name)  { return subjects.get(name); }

    public void executeInstruction(InstructionObject instruction){
        /*
        * if security levels are the same, subject may read/write to object
        * if subject security level is < object level, subject may write to object
        * if subject security level is > object level, subject may read from object
        *
        * READ-> set sub value
        * WRITE-> set obj value
        * CREATE-> create object with subject securtiy level
        * DESTORY-> destroy object
        * RUN -> wtf?
        */

        InstructionType op = instruction.type;
        switch(op){
            case READ:
                read(instruction);
                break;
            case WRITE:
                write(instruction);
                break;
            case CREATE:
                create(instruction);
                break;
            case DESTROY:
                destroy(instruction);
                break;
            case RUN:
                //idk what this does...I'll get back to this later
                run(instruction);
                break;
        }
    }

    public void read(InstructionObject instruction){ 
        String subname = instruction.subjectName;
        String objname = instruction.objectName;
        if(subjects.containsKey(subname) && objectManager.objects.containsKey(objname)) {
            Subject sub = subjects.get(subname);
            Object obj = objectManager.objects.get(objname);
            SecurityLevel sL = sub.securityLevel;
            SecurityLevel oL = obj.securityLevel;
            if(sL.dominates(oL)){
                sub.updateReadValue(obj.value);
            } else sub.readValue = 0;
        }
    }

    public void write(InstructionObject instruction) {
        String subname = instruction.subjectName;
        String objname = instruction.objectName;
        if(subjects.containsKey(subname) && objectManager.objects.containsKey(objname)) {
            Subject sub = subjects.get(subname);
            Object obj = objectManager.objects.get(objname);
            SecurityLevel sL = sub.securityLevel;
            SecurityLevel oL = obj.securityLevel;
            if(oL.dominates(sL)){
                obj.updateValue(instruction.value);
            }
        }
    }

    public void create(InstructionObject instruction) {
        String subname = instruction.subjectName;
        String objname = instruction.objectName;
        if(!objectManager.objects.containsKey(objname) && subjects.containsKey(subname)) {
            Subject sub = subjects.get(subname);
            SecurityLevel sL = sub.securityLevel;
            createNewObject(objname, sL);
        }
    }

    public void destroy(InstructionObject instruction) {
        String subname = instruction.subjectName;
        String objname = instruction.objectName;
        if(subjects.containsKey(subname) && objectManager.objects.containsKey(objname)) {
            Subject sub = subjects.get(subname);
            Object obj = objectManager.objects.get(objname);
            SecurityLevel sL = sub.securityLevel;
            SecurityLevel oL = obj.securityLevel;
            if(oL.dominates(sL)) {
                objectManager.destroyObject(objname);
            }
        }
    }

    public void run(InstructionObject instruction) {
        Subject subject = getSubject(instruction.subjectName);
        subject.run();
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
