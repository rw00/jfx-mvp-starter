package com.rw.starter.javafx.mvp.home;

import com.rw.starter.javafx.mvp.internal.UIConstants;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class DefaultHomePageView extends VBox implements HomePageView {
    private final String username;
    private final ObjectProperty<EventHandler<ActionEvent>> onLogoutAction;


    public DefaultHomePageView(String username) {
        this.username = username;
        this.onLogoutAction = new SimpleObjectProperty<>();
        init();
    }


    public EventHandler<ActionEvent> getOnLogoutAction() {
        return onLogoutAction.get();
    }

    public ObjectProperty<EventHandler<ActionEvent>> onLogoutActionProperty() {
        return onLogoutAction;
    }

    @Override
    public void setOnLogoutAction(EventHandler<ActionEvent> onLogoutAction) {
        this.onLogoutAction.set(onLogoutAction);
    }

    private void init() {
        setAlignment(Pos.TOP_CENTER);
        setPadding(new Insets(UIConstants.SPACING));
        setSpacing(UIConstants.SPACING);

        BorderPane borderPane = new BorderPane();
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(event -> getOnLogoutAction().handle(event));
        borderPane.setRight(logoutButton);
        getChildren().add(borderPane);

        getChildren().add(new Label("Hi " + username));
    }
}
