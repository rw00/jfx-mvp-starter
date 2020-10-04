package com.rw.starter.javafx.mvp.login;

import com.rw.starter.javafx.mvp.ApplicationPresenter;
import com.rw.starter.javafx.mvp.internal.AbstractPresenter;


public class LoginPresenter extends AbstractPresenter<LoginModel, LoginView, ApplicationPresenter> {
    public LoginPresenter(LoginModel model, LoginView view, ApplicationPresenter applicationPresenter) {
        super(model, view, applicationPresenter);
        applicationPresenter.getModel().usernameProperty().bind(model.usernameProperty());
    }


    @Override
    protected void bindActions() {
        getView().setOnLoginAction(getApplicationPresenter().getOnLoginAction());
    }
}
