package com.company;

/**
 * Created by kylemartinez on 9/11/14.
 */
public class Object {

    public String name;
    public int value = 0;
    public SecurityLevel securityLevel;

    public Object(String name, SecurityLevel level){
        this.name = name;
        securityLevel = level;
    }

    public void updateValue(int newValue){
        value = newValue;
    }
}
