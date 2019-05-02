package org.launchcode.cheesemvc.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @NotNull
    @Min(value = 1, message = "Rating must be a value of 1-5")
    @Max(value = 5, message = "Rating must be a value of 1-5")
    private int cheeseRating;

    private CheeseType type;
    private int cheeseId;
    private static int nextId = 1;

    public Cheese(String cheeseName, String cheeseValue, int cheeseRating) {
        this();
        this.cheeseName = cheeseName;
        this.cheeseValue = cheeseValue;
        this.cheeseRating = cheeseRating;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseRating() {
        return cheeseRating;
    }

    public void setCheeseRating(int cheeseRating) {
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
