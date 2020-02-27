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
 * */public class RxxpAdapter extends BaseAdapter {
    Context context;
    List<ListBean.ResultBean.RxxpBean.CommodityListBean> list;

    public RxxpAdapter(Context context, List<ListBean.ResultBean.RxxpBean.CommodityListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
            convertView=View.inflate(context, R.layout.rxxp,null);
            holder=new ViewHolder();
            holder.iv=convertView.findViewById(R.id.iv);
            holder.name=convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        ListBean.ResultBean.RxxpBean.CommodityListBean commodityListBean = list.get(position);
        String masterPic = commodityListBean.getMasterPic();
        Glide.with(context).load(masterPic).error(R.mipmap.ic_launcher).into(holder.iv);
        holder.name.setText(commodityListBean.getCommodityName());
        return convertView;
    }
    private class ViewHolder{
        private ImageView iv;
        private TextView name;
    }
}
