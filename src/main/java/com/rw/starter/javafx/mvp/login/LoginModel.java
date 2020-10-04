package com.rw.starter.javafx.mvp.login;

import com.rw.starter.javafx.mvp.internal.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class LoginModel extends Model {
    private final StringProperty username;
    private final StringProperty password;


    public LoginModel() {
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }


    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
