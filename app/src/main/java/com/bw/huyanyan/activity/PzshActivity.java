package com.bw.huyanyan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bw.huyanyan.R;
import com.bw.huyanyan.base.BaseActivity;
import com.bw.huyanyan.base.BasePersenter;
import com.bw.huyanyan.contorct.IHomeContorct;
import com.bw.huyanyan.persenter.IHomePagePresenter;

public class PzshActivity extends BaseActivity implements IHomeContorct.IView {


    private TextView tv;
    private BasePersenter presenter;

    @Override
    protected BasePersenter initPresenter() {
        return new IHomePagePresenter(this);
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_pzsh;
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv);

    }

    @Override
    protected void getData() {
        presenter = getPresenter();



    }

    @Override
    public void onBannerSuccess(String str) {

        Intent intent = getIntent();
        String commodityName = intent.getStringExtra("commodityName");
        tv.setText(commodityName);
    }

    @Override
    public void onBannerFrailure(String str) {

    }

    @Override
    public void onListSuccess(String str) {

    }

    @Override
    public void onListFrailure(String str) {

    }
}
