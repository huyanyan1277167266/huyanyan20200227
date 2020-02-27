package com.bw.huyanyan.base;

import java.lang.ref.WeakReference;

/*
 *@Auther:cln
 *@Date: 2020/2/27
 *@Time:15:09
 *@Description:
 * */public abstract class BasePersenter<V extends IBaseView> {

    private WeakReference<V> mWeakReference;

    public BasePersenter(V v){
        mWeakReference = new WeakReference<>(v);
        initModel();
     }

     protected abstract void initModel();

    public V getView(){
        if (mWeakReference!=null){
            return mWeakReference.get();
        }
        return null;
    }
    protected void detachView(){
        if (mWeakReference!=null){
            mWeakReference.clear();
            mWeakReference=null;
        }
    }

}
