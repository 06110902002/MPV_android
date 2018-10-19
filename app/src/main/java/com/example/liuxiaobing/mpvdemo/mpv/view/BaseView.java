package com.example.liuxiaobing.mpvdemo.mpv.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.liuxiaobing.mpvdemo.mpv.presenter.BasePresenter;

/**
 * Created by liuxiaobing on 2018/7/30.
 */

public abstract class BaseView<P extends BasePresenter> extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
    }

    protected abstract P getPresenter();

    /**
     * 子类需要重写
     * @return
     */
    public abstract int getLayout();

    /**
     * 初始化视图
     */
    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().onDestory();
    }

    @Override
    public void onClick(View view) {

    }

    public void loading(){

    }
}
