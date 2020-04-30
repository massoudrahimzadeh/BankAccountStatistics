package com.company;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    String name;
    public User(String name) {
        this.name = name;
    }

    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
