package com.bw.huyanyan.base;

import android.app.Application;
import android.content.Context;

/*
 *@Auther:cln
 *@Date: 2020/2/27
 *@Time:15:22
 *@Description:
 * */public class App extends Application {

    private static Context mcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = getApplicationContext();
    }
    public static Context getAppContext(){
        return mcontext;
    }
}
