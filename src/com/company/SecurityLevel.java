package com.company;

/**
 * Created by kylemartinez on 9/11/14.
 */
public enum SecurityLevel {

    low(1),
    high(2);

    public int value;

    private SecurityLevel(int value) {
        this.value = value;
    }

    public boolean dominates(SecurityLevel level){
        return (value >= level.value);
    }
 }
