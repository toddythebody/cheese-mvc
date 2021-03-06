package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {
    static ArrayList<Cheese> cheeses= new ArrayList<>();

    // getAll
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    // add
    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    //remove
    public static void remove(int id) {
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    // getById
    public static Cheese getById(int id) {

        Cheese theCheese = null;

        for (Cheese cheese : cheeses) {
            if (cheese.getId() == id) {
                theCheese = cheese;
            }
        }

        return theCheese;

    }

    public static void edit(int id, String name, String value, CheeseType type, String rating) {
        Cheese newCheese = getById(id);
        newCheese.setCheeseName(name);
        newCheese.setCheeseValue(value);
        newCheese.setType(type);
        newCheese.setCheeseRating(rating);
    }

}
