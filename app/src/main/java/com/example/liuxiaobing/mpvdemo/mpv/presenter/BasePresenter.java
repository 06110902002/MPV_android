package com.example.liuxiaobing.mpvdemo.mpv.presenter;

import android.os.Bundle;

import com.example.liuxiaobing.mpvdemo.mpv.view.BaseView;

import java.lang.ref.WeakReference;

/**
 * Created by liuxiaobing
 * Date on 2018/9/17
 * Copyright 2013 - 2018 QianTuo Inc. All Rights Reserved
 * Desc: MPV模型中 p层基类
 */

public abstract class BasePresenter<V extends BaseView> {

    protected WeakReference<V> mView;

    /**
     * view层的初始化操作
     *
     * @param view
     * @param savedInstanceState
     */
    public void attachView(V view,Bundle savedInstanceState) {
        this.mView = new WeakReference<>(view);
    }

    /********下面生命周期可以根据需要进行重载********/
    public void onStart(){

    }

    public void onResume(){

    }

    public void onRestart(){

    }

    public void onStop(){

    }

    public void onDestory(){
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }

    /**
     * 在使用之前记得判断对象是否已经回收
     * @return
     */
    public V getView(){
        return this.mView.get();
    }

    /**
     * 判断view与Presenter是否处理连接状态，其实最终是判断view是否添加到PhoneWindow
     * @return
     */
    public boolean isViewAttached(){

        return mView != null && mView.get() != null;
    }


}
