package com.bw.huyanyan.activity;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bw.huyanyan.R;
import com.bw.huyanyan.adapter.MlssAdapter;
import com.bw.huyanyan.adapter.PzshAdapter;
import com.bw.huyanyan.adapter.RxxpAdapter;
import com.bw.huyanyan.base.BaseActivity;
import com.bw.huyanyan.base.BasePersenter;
import com.bw.huyanyan.bean.BannerBean;
import com.bw.huyanyan.bean.ListBean;
import com.bw.huyanyan.contorct.IHomeContorct;
import com.bw.huyanyan.persenter.IHomePagePresenter;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends BaseActivity implements IHomeContorct.IView {


    private GridView gv1;
    private ListView lv;
    private GridView gv2;
    private XBanner xb;
    private BasePersenter mpresenter;
    private RecyclerView rv;
    private RecyclerView ml;
    private RecyclerView pz;

    @Override
    protected BasePersenter initPresenter() {
        return new IHomePagePresenter(this);
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        xb = findViewById(R.id.xb);
        gv1 = findViewById(R.id.gv1);

        lv = findViewById(R.id.lv);

        gv2 = findViewById(R.id.gv2);

    }

    @Override
    protected void getData() {
        mpresenter = getPresenter();
        String url="http://mobile.bwstudent.com/small/commodity/v1/bannerShow";
        String urlList="http://mobile.bwstudent.com/small/commodity/v1/commodityList";
        Log.i("xxx",url);
        Log.i("xxx",urlList);
        if (mpresenter !=null&& mpresenter instanceof IHomePagePresenter){
            ((IHomePagePresenter) mpresenter).getBanner(url);
            ((IHomePagePresenter) mpresenter).getList(urlList);
        }
    }

    @Override
    public void onBannerSuccess(String str) {

        Log.i("xxx",str);
        Gson gson = new Gson();
        BannerBean bannerBean = gson.fromJson(str, BannerBean.class);
        final List<BannerBean.ResultBean> result = bannerBean.getResult();
        xb.setBannerData(result);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                BannerBean.ResultBean resultBean = result.get(position);
                String imageUrl = resultBean.getImageUrl();
                //配置占位图、错误图、图片加载优先级
                Glide.with(MainActivity.this).load(imageUrl) .into((ImageView) view);
//                        .error(R.mipmap.ic_launcher)
//                        .thumbnail(R.mipmap.ic_launcher)

            }
        });

    }

    @Override
    public void onBannerFrailure(String str) {
        Log.i("xxx",str);
    }

    @Override
    public void onListSuccess(String str) {
        Log.i("xxx",str);
        //解析
        Gson gson = new Gson();
        ListBean listBean = gson.fromJson(str, ListBean.class);
        //热销新品
        List<ListBean.ResultBean.RxxpBean.CommodityListBean> commodityList = listBean.getResult().getRxxp().getCommodityList();

        RxxpAdapter rxxpAdapter = new RxxpAdapter(MainActivity.this, commodityList);
        gv1.setAdapter(rxxpAdapter);
        //魔丽时尚
        List<ListBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList1 = listBean.getResult().getMlss().getCommodityList();
        MlssAdapter mlssAdapter = new MlssAdapter(MainActivity.this, commodityList1);
        lv.setAdapter(mlssAdapter);
        //品质生活
        final List<ListBean.ResultBean.PzshBean.CommodityListBeanX> commodityList2 = listBean.getResult().getPzsh().getCommodityList();
        PzshAdapter pzshAdapter = new PzshAdapter(MainActivity.this, commodityList2);
        gv2.setAdapter(pzshAdapter);

        //点击事件，点击的时候开启一个新页面
        gv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PzshActivity.class);

                ListBean.ResultBean.PzshBean.CommodityListBeanX list = commodityList2.get(position);
                String commodityName = list.getCommodityName();
                intent.putExtra("commodityName",commodityName);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onListFrailure(String str) {
        Log.i("xxx",str);
    }
}
