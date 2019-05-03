package org.launchcode.cheesemvc.models;

public class User {

    private String username;
    private String email;
    private String password;
    private int userId;
    private static int nextUserId;

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        userId = nextUserId;
        nextUserId++;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static int getNextUserId() {
        return nextUserId;
    }

    public static void setNextUserId(int nextUserId) {
        User.nextUserId = nextUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
