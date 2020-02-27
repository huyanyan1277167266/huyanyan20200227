package com.bw.huyanyan.contorct;

/*
 *@Auther:cln
 *@Date: 2020/2/27
 *@Time:15:21
 *@Description:
 * */public interface IHomeContorct {
    interface IView{
        void onBannerSuccess(String str);
        void onBannerFrailure(String str);

        void onListSuccess(String str);
        void onListFrailure(String str);
    }

    interface IPresenter{
        void getBanner(String url);

        void getList(String url);
    }
    interface IModel{
        void getBanner(String url,onBannerICallBack iCallBack);
        interface onBannerICallBack{
            void onBannerSuccess(String str);
            void onBannerFrailure(String str);
        }
        void getList(String url,onListCallBack callBack);
        interface onListCallBack{
            void onListSuccess(String str);
            void onListFrailure(String str);
        }
    }
}
