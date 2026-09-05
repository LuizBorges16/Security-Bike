package com.luizborges.securitybike.domain;

public class User {

    private int id;
    private String name;
    private String email;
    private String passwordHash;


    public User(int id, String name, String email, String passwordHash) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean passwordMatches(String hashToCompare) {
        return this.passwordHash.equals(hashToCompare);
    }

}
