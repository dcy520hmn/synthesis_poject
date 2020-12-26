package com.dcy.thread.one;

public class User {
    private String name = "aa";
    private String pass = "bb";

    public User() {
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        Thread.currentThread().suspend();
        this.pass = pass;
    }
}
