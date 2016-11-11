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

public class GoodsListBean {

    /**
     * code : 1
     * msg : success
     * nextpage : 2
     * items : [{"id":2472353,"imgUrl":"http://mgpyh.b0.upaiyun.com/post_image/1abd89e376a0b2bd9452d6d68d585b55.jpg!focus","brand":"","brand_id":"19572","cate_name":"","price":1459,"labelPrice":2999,"discount":"4.9折","reduce":"减1540元","title":"哈曼卡顿（Harman/Kardon） Aura Studio 音乐琉璃 无线蓝牙音箱","isLove":0,"commentCount":1,"currency":"￥"},{"id":2402347,"imgUrl":"http://ec4.images-amazon.com/images/I/41ti3CrO1JL._SX540_.jpg","brand":"","brand_id":"40288","cate_name":"","price":59,"labelPrice":63,"discount":"9.4折","reduce":"减4元","title":"膳魔师（THERMOS） Tritan Hydration 儿童吸管杯 350ml","isLove":0,"commentCount":2,"currency":"￥"},{"id":2472620,"imgUrl":"http://mgpyh.b0.upaiyun.com/post_image/1e030c5c470e9f1d64d5d5f1cd93dd86.png!focus","brand":"","brand_id":"60654","cate_name":"","price":99,"labelPrice":598,"discount":"1.7折","reduce":"减499元","title":"LOVO 罗莱","isLove":0,"commentCount":1,"currency":"￥"},{"id":2174338,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/51kOotpUiyL._SX540_.jpg","brand":"","brand_id":"0","cate_name":"","price":234,"labelPrice":416,"discount":"5.6折","reduce":"减182元","title":"McFarlane TOYS 麦克法兰 行尸走肉  戴尔的房车RV","isLove":0,"commentCount":2,"currency":"￥"},{"id":2386628,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/616BCVN3WWL._SX540_.jpg","brand":"","brand_id":"1413","cate_name":"","price":655,"labelPrice":1025,"discount":"6.4折","reduce":"减370元","title":"Lesportsac 乐播诗尼龙手提单肩包","isLove":0,"commentCount":2,"currency":"￥"},{"id":2386040,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/51SMW5mKmQL._SX540_.jpg","brand":"","brand_id":"0","cate_name":"","price":195,"labelPrice":222,"discount":"8.8折","reduce":"减27元","title":"甘尼克宝贝（Babyganics ） 橙花香沐浴洗发露 473ml*3","isLove":0,"commentCount":3,"currency":"￥"},{"id":2385737,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/51N%2BTX4q3eL._SX540_.jpg","brand":"","brand_id":"60689","cate_name":"","price":312,"labelPrice":0,"discount":"","reduce":"减0元","title":"Transformers 变形金刚 领袖级 惊天雷  Thundercracker Figure","isLove":0,"commentCount":4,"currency":"￥"},{"id":2385315,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/51%2BFXxMt%2B9L._SX540_.jpg","brand":"","brand_id":"32681","cate_name":"","price":49,"labelPrice":132,"discount":"3.7折","reduce":"减83元","title":"Medela 美德乐 母乳储存袋 150ml*50只 :","isLove":0,"commentCount":5,"currency":"￥"},{"id":2385290,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/51mHQgJefJL._SX540_.jpg","brand":"","brand_id":"22307","cate_name":"","price":103,"labelPrice":173,"discount":"5.9折","reduce":"减70元","title":"Nerf N-Strike Elite CrossBolt Blaster :24.99","isLove":0,"commentCount":2,"currency":"￥"},{"id":2385280,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/51MERfS15UL._SX540_.jpg","brand":"","brand_id":"12590","cate_name":"","price":284,"labelPrice":381,"discount":"7.5折","reduce":"减97元","title":"LEGO Disney Princess Ariel's Undersea Palace乐高迪斯尼公主系列美人鱼海底宫殿 :","isLove":0,"commentCount":2,"currency":"￥"},{"id":2384537,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41jsyGDFhkL._SX540_.jpg","brand":"","brand_id":"0","cate_name":"","price":291,"labelPrice":0,"discount":"","reduce":"减0元","title":"小朋友的网游世界，Webkinz Velvety Elephant汤宝同款天鹅绒小象","isLove":0,"commentCount":5,"currency":"￥"},{"id":2188715,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41C1AG11h-L._SX540_.jpg","brand":"","brand_id":"26453","cate_name":"","price":92,"labelPrice":243,"discount":"3.8折","reduce":"减151元","title":"卡骆驰（crocs） Crocband Star Wars Villain Clog 男童凉鞋","isLove":0,"commentCount":1,"currency":"￥"},{"id":2003607,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41sEQ9kRu7L._SX540_.jpg","brand":"","brand_id":"33080","cate_name":"","price":38,"labelPrice":113,"discount":"3.4折","reduce":"减75元","title":"明星产品！Desitin Diaper  尿布湿疹软膏453g   需用coupon+SS","isLove":0,"commentCount":4,"currency":"￥"},{"id":2411065,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/51WlhTDbfgL._SX540_.jpg","brand":"","brand_id":"0","cate_name":"","price":146,"labelPrice":187,"discount":"7.8折","reduce":"减41元","title":"膳魔师（THERMOS） FHL-400F CP儿童保温吸管杯 400ml","isLove":0,"commentCount":2,"currency":"￥"},{"id":2391718,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/4/4/1/9/3444198-p-2x.jpg!medium","brand":"","brand_id":"0","cate_name":"","price":208,"labelPrice":415,"discount":"5.0折","reduce":"减207元","title":"New Balance 新百伦 Kids KL574U2P 大童款复古运动鞋","isLove":0,"commentCount":0,"currency":"￥"},{"id":2425669,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/51xY0DfYt4L._SX540_.jpg","brand":"","brand_id":"0","cate_name":"","price":130,"labelPrice":216,"discount":"6.0折","reduce":"减86元","title":"PILOT（百乐） 儿童神奇水彩画布","isLove":0,"commentCount":1,"currency":"￥"},{"id":2003421,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/519tFAlXsJL._SX540_.jpg","brand":"","brand_id":"0","cate_name":"","price":85,"labelPrice":173,"discount":"4.9折","reduce":"减88元","title":"曼哈顿（Manhattan） Toy 婴儿磨牙牙胶固齿器玩具","isLove":0,"commentCount":4,"currency":"￥"},{"id":2407912,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/51mGPI8qtxL._SX540_.jpg","brand":"","brand_id":"0","cate_name":"","price":47,"labelPrice":87,"discount":"5.4折","reduce":"减40元","title":"大正制药 口腔溃疡口疮贴纸 10枚","isLove":0,"commentCount":4,"currency":"￥"},{"id":2385515,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41rorWpq4%2BL._SX540_.jpg","brand":"","brand_id":"0","cate_name":"","price":201,"labelPrice":0,"discount":"","reduce":"减0元","title":"Fisher-Price 费雪 托马斯电动小火车 手势控制","isLove":0,"commentCount":2,"currency":"￥"},{"id":2105422,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41T3TFRk-hL._SX540_.jpg","brand":"","brand_id":"49002","cate_name":"","price":1142,"labelPrice":0,"discount":"","reduce":"减0元","title":"ALPHA INDUSTRIES M-65 Field  风衣夹克","isLove":0,"commentCount":2,"currency":"￥"}]
     */

    private int code;
    private String msg;
    private int nextpage;
    /**
     * id : 2472353
     * imgUrl : http://mgpyh.b0.upaiyun.com/post_image/1abd89e376a0b2bd9452d6d68d585b55.jpg!focus
     * brand :
     * brand_id : 19572
     * cate_name :
     * price : 1459
     * labelPrice : 2999
     * discount : 4.9折
     * reduce : 减1540元
     * title : 哈曼卡顿（Harman/Kardon） Aura Studio 音乐琉璃 无线蓝牙音箱
     * isLove : 0
     * commentCount : 1
     * currency : ￥
     */

    private List<ItemsBean> items;

    public static GoodsListBean objectFromData(String str) {

        return new Gson().fromJson(str, GoodsListBean.class);
    }

    public static GoodsListBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GoodsListBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GoodsListBean> arrayGoodsListBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GoodsListBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GoodsListBean> arrayGoodsListBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GoodsListBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNextpage() {
        return nextpage;
    }

    public void setNextpage(int nextpage) {
        this.nextpage = nextpage;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private int id;
        private String imgUrl;
        private String brand;
        private String brand_id;
        private String cate_name;
        private int price;
        private int labelPrice;
        private String discount;
        private String reduce;
        private String title;
        private int isLove;
        private int commentCount;
        private String currency;

        public static ItemsBean objectFromData(String str) {

            return new Gson().fromJson(str, ItemsBean.class);
        }

        public static ItemsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ItemsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ItemsBean> arrayItemsBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ItemsBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ItemsBean> arrayItemsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ItemsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getBrand_id() {
            return brand_id;
        }

        public void setBrand_id(String brand_id) {
            this.brand_id = brand_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getLabelPrice() {
            return labelPrice;
        }

        public void setLabelPrice(int labelPrice) {
            this.labelPrice = labelPrice;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getReduce() {
            return reduce;
        }

        public void setReduce(String reduce) {
            this.reduce = reduce;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getIsLove() {
            return isLove;
        }

        public void setIsLove(int isLove) {
            this.isLove = isLove;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
