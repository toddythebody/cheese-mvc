package org.launchcode.cheesemvc.models;

import javax.validation.constraints.*;
import java.util.HashMap;

public class Cheese {

    @NotNull
    @Size(min=3, max=15)
    private String cheeseName;
    @NotNull
    @Size(min=3, max=100)
    private String cheeseValue;
    @NotNull
    @Pattern(regexp = "^[1-5]$", message = "Choose a rating from 1 to 5")
    private String cheeseRating;

    private CheeseType type;
    private int cheeseId;
    private static int nextId = 1;

    public Cheese(String cheeseName, String cheeseValue, String cheeseRating) {
        this();
        this.cheeseName = cheeseName;
        this.cheeseValue = cheeseValue;
        this.cheeseRating = cheeseRating;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public String getCheeseRating() {
        return cheeseRating;
    }

    public void setCheeseRating(String cheeseRating) {
        this.cheeseRating = cheeseRating;
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
