package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;

public class Cheese {

    @NotNull
    @Size(min=3, max=15)
    private String cheeseName;
    @NotNull
    @Size(min=3, max=100)
    private String cheeseValue;

    private CheeseType type;
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

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
