package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class UserData {
    static ArrayList<User> users = new ArrayList<>();

    //getAll
    public static ArrayList<User> getAll() {
        return users;
    }

    //add
    public static void add(User newUser) {
        users.add(newUser);
    }

    //getById
    public static User getById(int id) {
        User theUser = null;

        for (User user : users) {
            if (user.getUserId() == id) {
                theUser = user;
            }
        }
        return theUser;
    }

    //userExist
    public static boolean userExist(User theUser) {
        for (User user: users) {
            if (user.getUsername().equals(theUser.getUsername())) {
                return false;
            }
            if (user.getEmail().equals(theUser.getEmail())) {
                return false;
            }
        }
        return true;
    }
}
