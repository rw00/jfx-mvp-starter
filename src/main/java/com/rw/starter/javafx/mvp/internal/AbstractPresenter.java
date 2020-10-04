package com.rw.starter.javafx.mvp.internal;

import com.rw.starter.javafx.mvp.ApplicationPresenter;


public abstract class AbstractPresenter<M extends Model, V extends View, P extends AbstractPresenter> {
    private final M model;
    private final V view;
    private final P parentPresenter;


    public AbstractPresenter(M model, V view, P parentPresenter) {
        this.model = model;
        this.view = view;
        this.parentPresenter = parentPresenter;
        bindActions();
    }


    public M getModel() {
        return model;
    }

    public V getView() {
        return view;
    }

    public P getParentPresenter() {
        return parentPresenter;
    }

    protected abstract void bindActions();

    protected ApplicationPresenter getApplicationPresenter() {
        if (this instanceof ApplicationPresenter) {
            return (ApplicationPresenter) this;
        }
        if (parentPresenter == null) {
            return null;
        }
        return parentPresenter.getApplicationPresenter();
    }
}
