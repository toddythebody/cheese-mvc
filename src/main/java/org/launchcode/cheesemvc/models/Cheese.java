package org.launchcode.cheesemvc.models;

import java.util.HashMap;

public class Cheese {

    private String cheeseName;
    private String cheeseValue;

    public Cheese(String cheeseName, String cheeseValue) {
        this.cheeseName = cheeseName;
        this.cheeseValue = cheeseValue;
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
