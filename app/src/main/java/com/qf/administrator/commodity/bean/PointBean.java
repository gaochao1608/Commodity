package com.qf.administrator.commodity.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16/11/12.
 */

public class PointBean {

    /**
     * limit : 20
     * next : null
     * next_exists : false
     * offset : 0
     * previous : null
     * security_hash : 22a92e251d72a82b8bb490c1d72a42373d3765b4
     * timestamp : 1478917330
     * total_count : 16
     */

    private MetaBean meta;
    /**
     * agree_count : 0
     * ancestors : []
     * ancestors_more : false
     * api_platform : null
     * avatar : http://mgpyh.b0.upaiyun.com/show/3c15f27e17e1121343939168fca1ade3.png
     * comment : 哈哈哈
     * created_time : 2016-11-06 19:49:21
     * id : 839590
     * naturetime : 5&nbsp;日前
     * target_cover_image : http://mgpyh.b0.upaiyun.com/post_image/7d8af7abc62ed59986df0a18deaee61d.jpg!show
     * target_title : 制作精美，以立体书的效果呈现出专辑主题，复古风格浓郁。
     * target_url : /api/v2/get_post/?source=dp&amp;post_url=https://detail.tmall.com/item.htm?id=533018610934&amp;ali_refid=a3_430582_1006:1103970904:N:%E5%91%A8%E6%9D%B0%E4%BC%A6%E7%9A%84%E5%BA%8A%E8%BE%B9%E6%95%85%E4%BA%8B:c6b929bc180d93d18a44e066a003f5a5&amp;ali_trackid=1_c6b929bc180d93d18a44e066a003f5a5&amp;spm=a230r.1.14.6.a2HeL7
     * timestamp : 1478432961
     * total_price : 0
     * username : weixin_小亦虫
     */

    private List<ObjectsBean> objects;

    public static PointBean objectFromData(String str) {

        return new Gson().fromJson(str, PointBean.class);
    }

    public static PointBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), PointBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<PointBean> arrayPointBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<PointBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<PointBean> arrayPointBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<PointBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<ObjectsBean> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectsBean> objects) {
        this.objects = objects;
    }

    public static class MetaBean {
        private int total_count;

        public static MetaBean objectFromData(String str) {

            return new Gson().fromJson(str, MetaBean.class);
        }

        public static MetaBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), MetaBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<MetaBean> arrayMetaBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<MetaBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<MetaBean> arrayMetaBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<MetaBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }
    }

    public static class ObjectsBean {
        private String avatar;
        private String comment;
        private String naturetime;
        private int total_price;
        private String username;

        public static ObjectsBean objectFromData(String str) {

            return new Gson().fromJson(str, ObjectsBean.class);
        }

        public static ObjectsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ObjectsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ObjectsBean> arrayObjectsBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ObjectsBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ObjectsBean> arrayObjectsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ObjectsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getNaturetime() {
            return naturetime;
        }

        public void setNaturetime(String naturetime) {
            this.naturetime = naturetime;
        }

        public int getTotal_price() {
            return total_price;
        }

        public void setTotal_price(int total_price) {
            this.total_price = total_price;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
