package com.qf.administrator.commodity.utils;

import android.app.Activity;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 高超 on 2016/10/31.
 */

public class OkHttpUtils {
    private OkHttpClient mClient;

    private OkHttpUtils() {
//        mClient=new OkHttpClient();
        mClient=new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.HOURS)
                .readTimeout(1,TimeUnit.DAYS)
                .writeTimeout(2,TimeUnit.DAYS)
                .build();
    }

    private static OkHttpUtils utils;

    public static OkHttpUtils getInstances(){
        if (utils == null){
            synchronized (OkHttpUtils.class){
                if (utils== null){
                utils= new OkHttpUtils();
            }
            }
        }
        return  utils;
    }
    /**
     * 封装一个通过execute方法执行的get请求
     */

    public <T extends Object>T get(String url,Class<T> clazz){
        Request request=new Request.Builder()
                .url(url)
                .build();

        try {
            Response res= mClient.newCall(request).execute();
            T zb = new Gson().fromJson(res.body().string(),clazz);
            return zb;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 封装一个通过enqueue方法执行的get请求
     */
    public interface  GetTextCallback<T>{
        void getText(T result);
    }
    public <T extends Object>void getByEnqueue(final Activity activity,String url,final Class<T> clazz,final GetTextCallback callback){
        Request request = new Request.Builder()
                .url(url)
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final  T gc = new Gson().fromJson(response.body().string(),clazz);

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (callback!=null){
                            callback.getText(gc);
                        }
                    }
                });
            }
        });

    }

    /**
     * 通过execute方法实现post请求
     *
     */
    public <T extends  Object>T post(String url, Map<String,String>map,Class<T> clazz){
        FormBody.Builder fb = new FormBody.Builder();

        Set<String> keys =map.keySet();
        for (String s: keys
             ) {
                fb.add(s,map.get(s));
        }
        Request post =new Request.Builder()
                .post(fb.build())
                .url(url)
                .build();
        try {
            Response res =mClient.newCall(post).execute();
            T gc = new Gson().fromJson(res.body().string(),clazz);
            return gc;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 通过enqueue方法执行post请求
     */

    public <T extends Object>void postByQueue(final Activity activity,String url,Map<String,String> map,final  Class<T> clazz,final  GetTextCallback<T> callback){
        FormBody.Builder fb =new FormBody.Builder();

        Set<String> keys =map.keySet();
        for (String s: keys
             ) {
               fb.add(s,map.get(s));
        }
        Request post = new Request.Builder()
                .post(fb.build())
                .url(url)
                .build();
        mClient.newCall(post).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final T gc =new Gson().fromJson(response.body().string(),clazz);

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (callback!=null){
                            callback.getText(gc);
                        }
                    }
                });
            }
        });
    }

}
