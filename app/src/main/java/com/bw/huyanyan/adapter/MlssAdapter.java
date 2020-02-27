package com.bw.huyanyan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.huyanyan.R;
import com.bw.huyanyan.activity.MainActivity;
import com.bw.huyanyan.bean.ListBean;

import java.util.List;

/*
 *@Auther:cln
 *@Date: 2020/2/27
 *@Time:16:36
 *@Description:
 * */public class MlssAdapter extends BaseAdapter {
    Context context;
    List<ListBean.ResultBean.MlssBean.CommodityListBeanXX> list1;

    public MlssAdapter(Context context, List<ListBean.ResultBean.MlssBean.CommodityListBeanXX> list1) {
        this.context = context;
        this.list1 = list1;
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.mlssitem,null);
            holder=new ViewHolder();
            holder.iv=convertView.findViewById(R.id.iv);
            holder.name=convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
//        ListBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBean = list1.get(position);
//        String masterPic = commodityListBean.getMasterPic();
//        Glide.with(context).load(masterPic).error(R.mipmap.ic_launcher).into(holder.iv);
        ListBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX = list1.get(position);
        String masterPic = commodityListBeanXX.getMasterPic();
        Glide.with(context).load(masterPic).error(R.mipmap.ic_launcher_round).into(holder.iv);
        holder.name.setText(commodityListBeanXX.getCommodityName());
        return convertView;
    }
    private class ViewHolder{
        private ImageView iv;
        private TextView name;
    }
}
