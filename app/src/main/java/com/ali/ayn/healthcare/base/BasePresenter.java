package com.ali.ayn.healthcare.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V, M> {

    private M model;
    private WeakReference<V> view;

    public BasePresenter(M model) {
        setModel(model);
    }

    private void setModel(M model) {
        this.model = model;
        if (setup()) {
            start();
        }
    }

    private void bindView(V view) {
        this.view = new WeakReference<>(view);
        if (setup()) {
            start();
        }
    }

    private void unBindView() {
        this.view = null;
        System.gc();
    }

    public V getView() {
        if (view == null) {
            return null;
        } else {
            return view.get();
        }

    }

    public M getModel(){
        return model;
    }

    public void onCreate(V view){
        bindView(view);
    }

    public void onDestroyed(){
        unBindView();
    }

    private boolean setup() {
        return model != null && getView() != null;
    }

    protected abstract void start();

    protected abstract void resume();

}
