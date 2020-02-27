package com.bw.huyanyan.model;

import com.bw.huyanyan.contorct.IHomeContorct;
import com.bw.huyanyan.utile.VolleyUtile;

/*
 *@Auther:cln
 *@Date: 2020/2/27
 *@Time:15:22
 *@Description:
 * */public class IHomePageModel implements IHomeContorct.IModel {

    @Override
    public void getBanner(String url, final onBannerICallBack iCallBack) {
        VolleyUtile.getInstance().doGet(url, new VolleyUtile.ICallBack() {
            @Override
            public void onSuccess(String json) {
                iCallBack.onBannerSuccess(json);
            }

            @Override
            public void onError(String msg) {
                iCallBack.onBannerFrailure(msg);
            }
        });
    }

    @Override
    public void getList(String url, final onListCallBack callBack) {
        VolleyUtile.getInstance().doGet(url, new VolleyUtile.ICallBack() {
            @Override
            public void onSuccess(String json) {
                callBack.onListSuccess(json);
            }

            @Override
            public void onError(String msg) {
                callBack.onListFrailure(msg);
            }
        });
    }
}
