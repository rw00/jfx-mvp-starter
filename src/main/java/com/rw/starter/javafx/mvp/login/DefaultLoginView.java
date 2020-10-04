package com.rw.starter.javafx.mvp.login;

import com.rw.starter.javafx.mvp.internal.UIConstants;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.util.Callback;


public class DefaultLoginView extends VBox implements LoginView {
    private final LoginModel model;
    private final ObjectProperty<Callback<Void, Void>> onLoginAction;


    public DefaultLoginView(LoginModel model) {
        this.model = model;
        this.onLoginAction = new SimpleObjectProperty<>();
        init();
    }


    public Callback<Void, Void> getOnLoginAction() {
        return onLoginAction.get();
    }

    public ObjectProperty<Callback<Void, Void>> onLoginActionProperty() {
        return onLoginAction;
    }

    @Override
    public void setOnLoginAction(Callback<Void, Void> onLoginAction) {
        this.onLoginAction.set(onLoginAction);
    }

    private void init() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(UIConstants.SPACING));
        setSpacing(UIConstants.SPACING);

        Label label = new Label("JavaFX MVP Starter");
        label.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        getChildren().add(label);

        BorderPane borderPane = new BorderPane();
        Label usernameLabel = new Label("Username");
        borderPane.setLeft(usernameLabel);
        getChildren().add(borderPane);
        TextField usernameTextField = new TextField();
        model.usernameProperty().bind(usernameTextField.textProperty());
        getChildren().add(usernameTextField);

        borderPane = new BorderPane();
        Label passwordLabel = new Label("Password");
        borderPane.setLeft(passwordLabel);
        getChildren().add(borderPane);
        PasswordField passwordField = new PasswordField();
        model.passwordProperty().bind(passwordField.textProperty());
        getChildren().add(passwordField);

        Button loginButton = new Button("Login");
        loginButton.setDefaultButton(true);
        loginButton.setOnAction(event -> getOnLoginAction().call(null));
        getChildren().add(loginButton);
    }
}
