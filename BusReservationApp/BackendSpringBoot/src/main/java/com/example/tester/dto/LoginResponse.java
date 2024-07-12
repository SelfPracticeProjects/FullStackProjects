
package com.example.tester.dto;

import com.example.tester.entity.User;

public class LoginResponse {
    private String nextPage;
    private User user;

    // Getters and setters
    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}