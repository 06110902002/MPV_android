package com.example.liuxiaobing.mpvdemo.mpv.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.liuxiaobing.mpvdemo.R;
import com.example.liuxiaobing.mpvdemo.mpv.model.NetImgModel;
import com.example.liuxiaobing.mpvdemo.mpv.presenter.BasePresenter;
import com.example.liuxiaobing.mpvdemo.mpv.presenter.GetNetImgPresenter;

public class MainActivity extends BaseView<GetNetImgPresenter> {

    private Button getNetImgBtn;
    private ImageView resultImg;
    private GetNetImgPresenter getNetImgPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().attachView(this,savedInstanceState);
    }

    @Override
    protected GetNetImgPresenter getPresenter() {
        if(getNetImgPresenter == null){
            getNetImgPresenter = new GetNetImgPresenter();
        }
        return getNetImgPresenter;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        getNetImgBtn = (Button)findViewById(R.id.btn_getnetimg);
        getNetImgBtn.setOnClickListener(this);
        resultImg = (ImageView)findViewById(R.id.img_result);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch(view.getId()){
            case R.id.btn_getnetimg:
                getPresenter() .getNetImgRes();
                break;
        }
    }

    public void showNetImg(NetImgModel netImgModel){
        resultImg.setBackgroundResource(Integer.valueOf(netImgModel.getImgUrl()));
    }


}
