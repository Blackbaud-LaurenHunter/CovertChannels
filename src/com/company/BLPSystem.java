package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kylemartinez on 9/12/14.
 */
public class BLPSystem {

    ReferenceMonitor monitor;

    public BLPSystem(){
        monitor = new ReferenceMonitor();
    }

    public ReferenceMonitor getReferenceMonitor(){
        return monitor;
    }

    public void createSubject(String name, SecurityLevel level){
        Subject subject = new Subject(name, level);
        monitor.addSubject(subject);
    }

    public void runInstruction(String instruction){
        Pattern writePattern = Pattern.compile("^write\\s([a-zA-Z]*)\\s([a-zA-Z]*)\\s(\\d+)", Pattern.CASE_INSENSITIVE);
        Pattern readPattern = Pattern.compile("^read\\s([a-zA-Z]*)\\s([a-zA-Z]*)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = writePattern.matcher(instruction);

        InstructionObject instructionObject = null;

        if (matcher.matches()) {
            System.out.println("write Instruction");
            String subject = matcher.group(1);
            String object = matcher.group(2);
            int value = Integer.parseInt(matcher.group(3));
            instructionObject = new InstructionObject(subject, object, value, InstructionType.READ);

        } else if ((matcher = readPattern.matcher(instruction)).matches() ) {
            System.out.println("Read Instruction");
            String subject = matcher.group(1);
            String object = matcher.group(2);
            instructionObject = new InstructionObject(subject, object,InstructionType.WRITE);
        } else {
            System.out.println("Bad Instruction");
            instructionObject = new InstructionObject(InstructionType.BAD);
        }

        monitor.executeInstruction(instructionObject);
    }


}
