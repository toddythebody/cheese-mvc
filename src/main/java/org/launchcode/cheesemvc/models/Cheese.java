package org.launchcode.cheesemvc.models;

import java.util.HashMap;

public class Cheese {
    private static HashMap<String, String> cheeses = new HashMap<>();

    public static HashMap<String, String> cheeseGet() {
        return cheeses;
    }

    public static void cheeseSet(String cheeseKey, String cheeseValue) {
        cheeses.put(cheeseKey, cheeseValue);
    }
}
