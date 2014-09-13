package com.company;

/**
 * Created by kylemartinez on 9/11/14.
 */
public class Object {

    public String name;
    public SecurityLevel securityLevel;
    public int value = 0;

    public Object(String name, SecurityLevel level){
        this.name = name;
        securityLevel = level;
    }

    public void updateValue(int newValue){
        value = newValue;
    }
}
