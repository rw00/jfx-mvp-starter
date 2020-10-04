package com.rw.starter.javafx.mvp;

import com.rw.starter.javafx.mvp.internal.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ApplicationModel extends Model {
    private final StringProperty username;


    public ApplicationModel() {
        this.username = new SimpleStringProperty();
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
}
