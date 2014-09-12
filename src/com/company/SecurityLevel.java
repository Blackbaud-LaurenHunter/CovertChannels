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

    private boolean dominates(SecurityLevel level){
        return (this.value >= level.value);
    }
 }
