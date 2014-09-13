package com.company;

import java.util.HashMap;

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
}
