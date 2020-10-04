package com.rw.starter.javafx.mvp.login;

import com.rw.starter.javafx.mvp.internal.View;

import javafx.util.Callback;


public interface LoginView extends View {
    void setOnLoginAction(Callback<Void, Void> onLoginAction);
}
