package org.launchcode.cheesemvc.models;

import java.util.HashMap;

public class Cheese {

    private String cheeseName;
    private String cheeseValue;
    private int cheeseId;
    private static int nextId = 1;

    public Cheese(String cheeseName, String cheeseValue) {
        this();
        this.cheeseName = cheeseName;
        this.cheeseValue = cheeseValue;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Cheese.nextId = nextId;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public String getCheeseValue() {
        return cheeseValue;
    }

    public void setCheeseValue(String cheeseValue) {
        this.cheeseValue = cheeseValue;
    }
}
