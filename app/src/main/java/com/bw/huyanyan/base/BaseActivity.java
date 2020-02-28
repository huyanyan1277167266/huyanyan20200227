package com.bw.huyanyan.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements IBaseView{
    P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutId());
        mPresenter=initPresenter();
        initView();
        getData();
    }
    public P getPresenter(){
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
            mPresenter=null;
        }
    }
    protected abstract P initPresenter();
    protected abstract int getlayoutId();

    protected abstract void initView();

    protected abstract void getData();

}
