package com.rw.starter.javafx.mvp.home;

import com.rw.starter.javafx.mvp.internal.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public interface HomePageView extends View {
    void setOnLogoutAction(EventHandler<ActionEvent> onLogoutAction);
}
