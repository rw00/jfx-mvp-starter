package com.rw.starter.javafx.mvp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.rw.starter.javafx.mvp.home.DefaultHomePageView;
import com.rw.starter.javafx.mvp.home.HomePageModel;
import com.rw.starter.javafx.mvp.home.HomePagePresenter;
import com.rw.starter.javafx.mvp.internal.AbstractPresenter;
import com.rw.starter.javafx.mvp.internal.View;
import com.rw.starter.javafx.mvp.login.DefaultLoginView;
import com.rw.starter.javafx.mvp.login.LoginModel;
import com.rw.starter.javafx.mvp.login.LoginPresenter;

import javafx.application.Platform;

import javafx.concurrent.Task;

import javafx.scene.Scene;

import javafx.stage.Stage;

import javafx.util.Callback;


public class ApplicationPresenter extends AbstractPresenter<ApplicationModel, View, ApplicationPresenter> {
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final Stage primaryStage;
    private Callback<Void, Void> onLoginAction;


    public ApplicationPresenter(ApplicationModel applicationModel, Stage primaryStage) {
        super(applicationModel, null, null);
        this.primaryStage = primaryStage;
    }


    public void shutdownNow() {
        executorService.shutdownNow();
    }

    public void goToLoginScreen() {
        Platform.runLater(() -> {
            LoginModel loginModel = new LoginModel();
            DefaultLoginView loginView = new DefaultLoginView(loginModel);
            new LoginPresenter(loginModel, loginView, ApplicationPresenter.this);
            primaryStage.setScene(new Scene(loginView));
        });
    }

    public void goToHomeScreen() {
        Platform.runLater(() -> {
            HomePageModel mainModel = new HomePageModel();
            DefaultHomePageView mainView = new DefaultHomePageView(getModel().getUsername());
            new HomePagePresenter(mainModel, mainView, ApplicationPresenter.this);
            primaryStage.setScene(new Scene(mainView));
        });
    }

    public Callback<Void, Void> getOnLoginAction() {
        if (onLoginAction == null) {
            onLoginAction =
                (Void) -> {
                executeTask(() -> {
                    // call the server to authenticate
                    goToHomeScreen();
                    return null;
                });
                return null;
            };
        }
        return onLoginAction;
    }

    @Override
    protected void bindActions() {
    }

    protected <X> void executeTask(Callable<X> callable) {
        Task<X> task = new Task<>() {

            @Override
            protected X call() throws Exception {
                return callable.call();
            }
        };
        executorService.submit(task);
    }
}
