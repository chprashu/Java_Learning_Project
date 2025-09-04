package com.learn.Spring.tightCoupling;

public class Payment {

    /** payment class is tightly coupled with User class */
    User user = new User();

    void doSomething(String username) {
        user.doSomething(username);
    }
}
