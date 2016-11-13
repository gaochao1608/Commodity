package com.qf.administrator.commodity.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16/11/13.
 */

public class CommentBean {

    /**
     * limit : 20
     * next : null
     * next_exists : false
     * offset : 0
     * previous : null
     * security_hash : f1c2b494226489158914a00ea47959873ae7693d
     * timestamp : 1479048870
     * total_count : 8
     */

    private MetaBean meta;
    /**
     * agree_count : 0
     * ancestors : []
     * ancestors_more : false
     * api_platform : null
     * avatar : http://mgpyh.b0.upaiyun.com/show/c40208df1fda8399beb2b310560b7cd3.png
     * comment : 喇叭
     * created_time : 2016-10-28 17:02:35
     * id : 838154
     * naturetime : 2&nbsp;周前
     * target_cover_image : http://mgpyh.b0.upaiyun.com/post_image/c7b1cf13e35289e6c10256fd41d5ab1a.jpg!show
     * target_title : 果岭风超越想象，性能出色，静音省电，像母亲的手抚摸着你
     * target_url : /api/v2/get_post/?source=dp&amp;post_url=https://www.amazon.co.jp/バルミューダ-DCモーター-GreenFan-Japan（グリーンファンジャパン）ホワイト×グレー-EGF-1500-WG/dp/B00JUMGOZY
     * timestamp : 1477645355
     * total_price : 0
     * username : 梦消失人海
     */

    private List<ObjectsBean> objects;

    public static CommentBean objectFromData(String str) {

        return new Gson().fromJson(str, CommentBean.class);
    }

    public static CommentBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), CommentBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<CommentBean> arrayCommentBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<CommentBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<CommentBean> arrayCommentBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<CommentBean>>() {
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
        private int limit;
        private Object next;
        private boolean next_exists;
        private int offset;
        private Object previous;
        private String security_hash;
        private String timestamp;
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

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public Object getNext() {
            return next;
        }

        public void setNext(Object next) {
            this.next = next;
        }

        public boolean isNext_exists() {
            return next_exists;
        }

        public void setNext_exists(boolean next_exists) {
            this.next_exists = next_exists;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public Object getPrevious() {
            return previous;
        }

        public void setPrevious(Object previous) {
            this.previous = previous;
        }

        public String getSecurity_hash() {
            return security_hash;
        }

        public void setSecurity_hash(String security_hash) {
            this.security_hash = security_hash;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }
    }

    public static class ObjectsBean {
        private int agree_count;
        private boolean ancestors_more;
        private Object api_platform;
        private String avatar;
        private String comment;
        private String created_time;
        private int id;
        private String naturetime;
        private String target_cover_image;
        private String target_title;
        private String target_url;
        private int timestamp;
        private int total_price;
        private String username;
        private List<?> ancestors;

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

        public int getAgree_count() {
            return agree_count;
        }

        public void setAgree_count(int agree_count) {
            this.agree_count = agree_count;
        }

        public boolean isAncestors_more() {
            return ancestors_more;
        }

        public void setAncestors_more(boolean ancestors_more) {
            this.ancestors_more = ancestors_more;
        }

        public Object getApi_platform() {
            return api_platform;
        }

        public void setApi_platform(Object api_platform) {
            this.api_platform = api_platform;
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

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNaturetime() {
            return naturetime;
        }

        public void setNaturetime(String naturetime) {
            this.naturetime = naturetime;
        }

        public String getTarget_cover_image() {
            return target_cover_image;
        }

        public void setTarget_cover_image(String target_cover_image) {
            this.target_cover_image = target_cover_image;
        }

        public String getTarget_title() {
            return target_title;
        }

        public void setTarget_title(String target_title) {
            this.target_title = target_title;
        }

        public String getTarget_url() {
            return target_url;
        }

        public void setTarget_url(String target_url) {
            this.target_url = target_url;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
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

        public List<?> getAncestors() {
            return ancestors;
        }

        public void setAncestors(List<?> ancestors) {
            this.ancestors = ancestors;
        }
    }
}
