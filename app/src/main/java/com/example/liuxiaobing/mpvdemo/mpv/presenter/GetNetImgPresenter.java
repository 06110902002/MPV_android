package com.example.liuxiaobing.mpvdemo.mpv.presenter;

import com.example.liuxiaobing.mpvdemo.R;
import com.example.liuxiaobing.mpvdemo.mpv.model.NetImgModel;
import com.example.liuxiaobing.mpvdemo.mpv.view.MainActivity;

/**
 * Created by liuxiaobing
 * Date on 2018/9/17
 * Copyright 2013 - 2018 QianTuo Inc. All Rights Reserved
 * Desc:
 */

public class GetNetImgPresenter extends BasePresenter<MainActivity>{

    private NetImgModel mModel;

    /**
     * 这里执行获取网络图片的逻辑操作
     * @return
     */
    public void  getNetImgRes(){
        NetImgModel imgModel = new NetImgModel();
        imgModel.setImgUrl(R.mipmap.ic_launcher+"");
        mView.get().showNetImg(imgModel);

    }

    /**
     * 亦可将数据结果直接抛出去
     * @param listener
     */
    public void getNetImgRes(GetNetImgListener<NetImgModel> listener){

        NetImgModel imgModel = new NetImgModel();
        imgModel.setImgUrl(R.mipmap.ic_launcher+"");
        listener.callBack(imgModel);
    }


    /**
     * 获取网络图片 监听器，由Presenter层将数据结果传递给View层，view层需要实现这个接口
     * @param <T>
     */
    public interface GetNetImgListener<T>{

        void callBack(T result);
    }
}
