package com.bw.huyanyan.utile;

import android.os.Handler;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bw.huyanyan.base.App;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:cln
 *@Date: 2020/2/27
 *@Time:15:22
 *@Description:
 * */public class VolleyUtile {
       RequestQueue mQueue;
       private VolleyUtile(){
           mQueue= Volley.newRequestQueue(App.getAppContext());
       }
       private static class SingleInstance{
           private static VolleyUtile INSTANCE=new VolleyUtile();
       }

    public static VolleyUtile getInstance() {
        return SingleInstance.INSTANCE;
    }
    private Handler handler=new Handler();
       public interface ICallBack{
           void onSuccess(String json);
           void onError(String msg);
       }
    public void doGet(String url, final ICallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        });
        mQueue.add(stringRequest);

    }
    public void doPost(String url, final HashMap<String,String>map, final ICallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        mQueue.add(stringRequest);
    }
}
