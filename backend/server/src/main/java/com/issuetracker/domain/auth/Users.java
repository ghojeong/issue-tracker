package com.issuetracker.domain.auth;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users() {
        this(new ArrayList<>());
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public void add(User user) {
        users.add(user);
    }

    public List<User> toList() {
        return users;
    }

}
