package com.rw.starter.javafx.mvp.home;

import com.rw.starter.javafx.mvp.ApplicationPresenter;
import com.rw.starter.javafx.mvp.internal.AbstractPresenter;


public class HomePagePresenter extends AbstractPresenter<HomePageModel, HomePageView, ApplicationPresenter> {
    public HomePagePresenter(HomePageModel model, HomePageView view, ApplicationPresenter parentPresenter) {
        super(model, view, parentPresenter);
    }


    @Override
    protected void bindActions() {
        getView().setOnLogoutAction(param -> {
            // logout
            getApplicationPresenter().goToLoginScreen();
        });
    }
}
