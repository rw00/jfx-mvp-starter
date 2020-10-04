package com.rw.starter.javafx.mvp;

import com.rw.starter.javafx.mvp.login.DefaultLoginView;
import com.rw.starter.javafx.mvp.login.LoginModel;
import com.rw.starter.javafx.mvp.login.LoginPresenter;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;


public class JfxApplication extends Application {
    private ApplicationPresenter applicationPresenter;


    public JfxApplication() {
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationModel applicationModel = new ApplicationModel();
        applicationPresenter = new ApplicationPresenter(applicationModel, primaryStage);

        LoginModel loginModel = new LoginModel();
        DefaultLoginView loginView = new DefaultLoginView(loginModel);
        new LoginPresenter(loginModel, loginView, applicationPresenter);

        primaryStage.setScene(new Scene(loginView));

        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        applicationPresenter.shutdownNow();
    }
}
