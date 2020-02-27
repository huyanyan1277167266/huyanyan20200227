package com.bw.huyanyan.persenter;

import com.bw.huyanyan.base.BasePersenter;
import com.bw.huyanyan.base.IBaseView;
import com.bw.huyanyan.contorct.IHomeContorct;
import com.bw.huyanyan.model.IHomePageModel;

/*
 *@Auther:cln
 *@Date: 2020/2/27
 *@Time:15:39
 *@Description:
 * */public class IHomePagePresenter extends BasePersenter implements IHomeContorct.IPresenter {

    private IHomePageModel mModel;

    public IHomePagePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new IHomePageModel();
    }

    @Override
    public void getBanner(String url) {
        mModel.getBanner(url, new IHomeContorct.IModel.onBannerICallBack() {
            @Override
            public void onBannerSuccess(String str) {
                IBaseView iBaseView = getView();
                if (iBaseView instanceof IHomeContorct.IView){
                    IHomeContorct.IView iView= (IHomeContorct.IView) iBaseView;
                    iView.onBannerSuccess(str);
                }
            }

            @Override
            public void onBannerFrailure(String str) {
                IBaseView iBaseView = getView();
                if (iBaseView instanceof IHomeContorct.IView){
                    IHomeContorct.IView iView= (IHomeContorct.IView) iBaseView;
                    iView.onBannerFrailure(str);
                }
            }
        });
    }

    @Override
    public void getList(String url) {
    mModel.getList(url, new IHomeContorct.IModel.onListCallBack() {
        @Override
        public void onListSuccess(String str) {
            IBaseView iBaseView = getView();
            if (iBaseView instanceof IHomeContorct.IView){
                IHomeContorct.IView iView= (IHomeContorct.IView) iBaseView;
               iView.onListSuccess(str);
            }
        }

        @Override
        public void onListFrailure(String str) {
            IBaseView iBaseView = getView();
            if (iBaseView instanceof IHomeContorct.IView){
                IHomeContorct.IView iView= (IHomeContorct.IView) iBaseView;
                iView.onListFrailure(str);
            }
        }
    });
    }
}
