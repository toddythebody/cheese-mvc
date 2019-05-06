package org.launchcode.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.HashMap;

@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;
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


    public Cheese(String cheeseName, String cheeseValue, String cheeseRating) {
        this.cheeseName = cheeseName;
        this.cheeseValue = cheeseValue;
        this.cheeseRating = cheeseRating;
    }

    public Cheese() { }

    public int getId() {
        return id;
    }

    public String getCheeseRating() {
        return cheeseRating;
    }

    public void setCheeseRating(String cheeseRating) {
        this.cheeseRating = cheeseRating;
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
