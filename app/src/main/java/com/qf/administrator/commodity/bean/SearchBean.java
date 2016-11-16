package com.qf.administrator.commodity.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16/11/14.
 */

public class SearchBean {

    /**
     * code : 1
     * msg : success
     * data : {"items":[{"id":2410920,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41I-048pcxL._SX540_.jpg","brand":"","price":174,"labelprice":681,"discount":"2.5折","reduce":"减507元","title":"Calvin Klein Jeans Slim 男士直筒牛仔裤","isLike":0,"commentCount":4,"type":0},{"id":2049802,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/8/2/8/3418280-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":139,"labelprice":1028,"discount":"1.4折","reduce":"减889元","title":"Kerry Deep Gold Contour Jeans in Blue","isLike":0,"commentCount":0,"type":0},{"id":2049034,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/2/9/4/4/6/3294469-p-2x.jpg!medium","brand":"(7 For All Mankind)","price":229,"labelprice":1493,"discount":"1.5折","reduce":"减1264元","title":"7 For All Mankind 女士牛仔裤","isLike":0,"commentCount":3,"type":0},{"id":2049805,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/8/2/6/3418260-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":174,"labelprice":1028,"discount":"1.7折","reduce":"减854元","title":"Emma Gold Jeans in Blue","isLike":0,"commentCount":0,"type":0},{"id":2049830,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/8/2/8/3418281-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":160,"labelprice":820,"discount":"1.9折","reduce":"减660元","title":"Scarlett Indigo Coated Jeans in Blue","isLike":0,"commentCount":0,"type":0},{"id":2047844,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/2/9/6/6/0/8/2966089-p-2x.jpg!medium","brand":"(Diesel)","price":382,"labelprice":1902,"discount":"2.0折","reduce":"减1520元","title":"迪赛（DIESEL）  Iakop 0R01Q 男士牛仔裤","isLike":0,"commentCount":1,"type":0},{"id":2049819,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/7/3/1/3417317-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":229,"labelprice":1028,"discount":"2.2折","reduce":"减799元","title":"Carlotta Deep Gold Jeans in Sateen","isLike":0,"commentCount":0,"type":0},{"id":2049813,"imgUrl":"http://www.zappos.com/images/z/3/4/1/7/2/2/3417224-p-2x.jpg","brand":"(Mavi Jeans)","price":195,"labelprice":820,"discount":"2.4折","reduce":"减625元","title":"Carlotta Jeans in Indigo","isLike":0,"commentCount":0,"type":0},{"id":2441792,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41H-YI7wqcL._SX540_.jpg","brand":"","price":344,"labelprice":1375,"discount":"2.5折","reduce":"减1031元","title":"7 For All Mankind Vintage Boot Cut 女士牛仔裤","isLike":0,"commentCount":0,"type":0},{"id":2049800,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/7/2/0/3417206-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":257,"labelprice":1028,"discount":"2.5折","reduce":"减771元","title":"Jake Jeans in Dark White Edge","isLike":0,"commentCount":0,"type":0},{"id":2448450,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41GYRd7iswL._SX540_.jpg","brand":"","price":331,"labelprice":1299,"discount":"2.5折","reduce":"减968元","title":"G-Star 3301 Loose 男款锥形牛仔裤","isLike":0,"commentCount":0,"type":0},{"id":2050107,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/5/3/4/0/9/3534093-p-2x.jpg!medium","brand":"(Seven7 Jeans)","price":132,"labelprice":514,"discount":"2.6折","reduce":"减382元","title":"No Destruction Skinny Jeans in Wicked","isLike":0,"commentCount":0,"type":0},{"id":2049823,"imgUrl":"http://www.zappos.com/images/z/3/4/2/1/6/4/3421649-p-2x.jpg","brand":"(Seven7 Jeans)","price":139,"labelprice":514,"discount":"2.7折","reduce":"减375元","title":"Luxury Denim Straight Leg Jeans in Forge Blue","isLike":0,"commentCount":0,"type":0},{"id":2049796,"imgUrl":"http://www.zappos.com/images/z/3/4/1/7/2/1/3417215-p-2x.jpg","brand":"(Mavi Jeans)","price":278,"labelprice":1028,"discount":"2.7折","reduce":"减750元","title":"Jake Jeans in Dark Foggy White Edge","isLike":0,"commentCount":0,"type":0},{"id":2050114,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/5/3/4/0/9/3534090-p-2x.jpg!medium","brand":"(Seven7 Jeans)","price":146,"labelprice":514,"discount":"2.8折","reduce":"减368元","title":"Missy Bootcut Jeans in Sonja Blue","isLike":0,"commentCount":0,"type":0},{"id":2050100,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/5/3/4/0/9/3534092-p-2x.jpg!medium","brand":"(Seven7 Jeans)","price":146,"labelprice":514,"discount":"2.8折","reduce":"减368元","title":"Metal Slim Jeans in Protégé Blue","isLike":0,"commentCount":0,"type":0},{"id":2049814,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/7/2/1/3417216-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":243,"labelprice":820,"discount":"3.0折","reduce":"减577元","title":"Jake Jeans in Black Brushed Italy","isLike":0,"commentCount":0,"type":0},{"id":2188356,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/3/2/5/5/6/3325563-p-2x.jpg!medium","brand":"(DKNY Jeans)","price":187,"labelprice":622,"discount":"3.0折","reduce":"减435元","title":"Bleecker Knit Jeans in Medium Indigo","isLike":0,"commentCount":0,"type":0},{"id":2049320,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/3/3/8/2/9/3338292-p-2x.jpg!medium","brand":"(Miraclebody Jeans)","price":250,"labelprice":833,"discount":"3.0折","reduce":"减583元","title":"Katie Straight Leg Jeans in Edinburgh Blue","isLike":0,"commentCount":0,"type":0},{"id":2396388,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/2/1/9/4/3/3219435-p-2x.jpg!medium","brand":"(DKNY Jeans)","price":145,"labelprice":483,"discount":"3.0折","reduce":"减338元","title":"Bleecker Jeans in White Denim","isLike":0,"commentCount":0,"type":0},{"id":"","imgUrl":"","brand":"","price":"","labelprice":"","discount":"","reduce":"","title":"没有找到满意的商品？点击查看全网结果","isLike":"","commentCount":"","type":1}],"nextPage":2}
     */

    private int code;
    private String msg;
    /**
     * items : [{"id":2410920,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41I-048pcxL._SX540_.jpg","brand":"","price":174,"labelprice":681,"discount":"2.5折","reduce":"减507元","title":"Calvin Klein Jeans Slim 男士直筒牛仔裤","isLike":0,"commentCount":4,"type":0},{"id":2049802,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/8/2/8/3418280-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":139,"labelprice":1028,"discount":"1.4折","reduce":"减889元","title":"Kerry Deep Gold Contour Jeans in Blue","isLike":0,"commentCount":0,"type":0},{"id":2049034,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/2/9/4/4/6/3294469-p-2x.jpg!medium","brand":"(7 For All Mankind)","price":229,"labelprice":1493,"discount":"1.5折","reduce":"减1264元","title":"7 For All Mankind 女士牛仔裤","isLike":0,"commentCount":3,"type":0},{"id":2049805,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/8/2/6/3418260-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":174,"labelprice":1028,"discount":"1.7折","reduce":"减854元","title":"Emma Gold Jeans in Blue","isLike":0,"commentCount":0,"type":0},{"id":2049830,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/8/2/8/3418281-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":160,"labelprice":820,"discount":"1.9折","reduce":"减660元","title":"Scarlett Indigo Coated Jeans in Blue","isLike":0,"commentCount":0,"type":0},{"id":2047844,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/2/9/6/6/0/8/2966089-p-2x.jpg!medium","brand":"(Diesel)","price":382,"labelprice":1902,"discount":"2.0折","reduce":"减1520元","title":"迪赛（DIESEL）  Iakop 0R01Q 男士牛仔裤","isLike":0,"commentCount":1,"type":0},{"id":2049819,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/7/3/1/3417317-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":229,"labelprice":1028,"discount":"2.2折","reduce":"减799元","title":"Carlotta Deep Gold Jeans in Sateen","isLike":0,"commentCount":0,"type":0},{"id":2049813,"imgUrl":"http://www.zappos.com/images/z/3/4/1/7/2/2/3417224-p-2x.jpg","brand":"(Mavi Jeans)","price":195,"labelprice":820,"discount":"2.4折","reduce":"减625元","title":"Carlotta Jeans in Indigo","isLike":0,"commentCount":0,"type":0},{"id":2441792,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41H-YI7wqcL._SX540_.jpg","brand":"","price":344,"labelprice":1375,"discount":"2.5折","reduce":"减1031元","title":"7 For All Mankind Vintage Boot Cut 女士牛仔裤","isLike":0,"commentCount":0,"type":0},{"id":2049800,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/7/2/0/3417206-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":257,"labelprice":1028,"discount":"2.5折","reduce":"减771元","title":"Jake Jeans in Dark White Edge","isLike":0,"commentCount":0,"type":0},{"id":2448450,"imgUrl":"https://images-cn.ssl-images-amazon.com/images/I/41GYRd7iswL._SX540_.jpg","brand":"","price":331,"labelprice":1299,"discount":"2.5折","reduce":"减968元","title":"G-Star 3301 Loose 男款锥形牛仔裤","isLike":0,"commentCount":0,"type":0},{"id":2050107,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/5/3/4/0/9/3534093-p-2x.jpg!medium","brand":"(Seven7 Jeans)","price":132,"labelprice":514,"discount":"2.6折","reduce":"减382元","title":"No Destruction Skinny Jeans in Wicked","isLike":0,"commentCount":0,"type":0},{"id":2049823,"imgUrl":"http://www.zappos.com/images/z/3/4/2/1/6/4/3421649-p-2x.jpg","brand":"(Seven7 Jeans)","price":139,"labelprice":514,"discount":"2.7折","reduce":"减375元","title":"Luxury Denim Straight Leg Jeans in Forge Blue","isLike":0,"commentCount":0,"type":0},{"id":2049796,"imgUrl":"http://www.zappos.com/images/z/3/4/1/7/2/1/3417215-p-2x.jpg","brand":"(Mavi Jeans)","price":278,"labelprice":1028,"discount":"2.7折","reduce":"减750元","title":"Jake Jeans in Dark Foggy White Edge","isLike":0,"commentCount":0,"type":0},{"id":2050114,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/5/3/4/0/9/3534090-p-2x.jpg!medium","brand":"(Seven7 Jeans)","price":146,"labelprice":514,"discount":"2.8折","reduce":"减368元","title":"Missy Bootcut Jeans in Sonja Blue","isLike":0,"commentCount":0,"type":0},{"id":2050100,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/5/3/4/0/9/3534092-p-2x.jpg!medium","brand":"(Seven7 Jeans)","price":146,"labelprice":514,"discount":"2.8折","reduce":"减368元","title":"Metal Slim Jeans in Protégé Blue","isLike":0,"commentCount":0,"type":0},{"id":2049814,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/4/1/7/2/1/3417216-p-2x.jpg!medium","brand":"(Mavi Jeans)","price":243,"labelprice":820,"discount":"3.0折","reduce":"减577元","title":"Jake Jeans in Black Brushed Italy","isLike":0,"commentCount":0,"type":0},{"id":2188356,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/3/2/5/5/6/3325563-p-2x.jpg!medium","brand":"(DKNY Jeans)","price":187,"labelprice":622,"discount":"3.0折","reduce":"减435元","title":"Bleecker Knit Jeans in Medium Indigo","isLike":0,"commentCount":0,"type":0},{"id":2049320,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/3/3/8/2/9/3338292-p-2x.jpg!medium","brand":"(Miraclebody Jeans)","price":250,"labelprice":833,"discount":"3.0折","reduce":"减583元","title":"Katie Straight Leg Jeans in Edinburgh Blue","isLike":0,"commentCount":0,"type":0},{"id":2396388,"imgUrl":"http://shopstyleimg.b0.upaiyun.com/image_cache/6pm/origin/images/z/3/2/1/9/4/3/3219435-p-2x.jpg!medium","brand":"(DKNY Jeans)","price":145,"labelprice":483,"discount":"3.0折","reduce":"减338元","title":"Bleecker Jeans in White Denim","isLike":0,"commentCount":0,"type":0},{"id":"","imgUrl":"","brand":"","price":"","labelprice":"","discount":"","reduce":"","title":"没有找到满意的商品？点击查看全网结果","isLike":"","commentCount":"","type":1}]
     * nextPage : 2
     */

    private DataBean data;

    public static SearchBean objectFromData(String str) {

        return new Gson().fromJson(str, SearchBean.class);
    }

    public static SearchBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), SearchBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<SearchBean> arraySearchBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SearchBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<SearchBean> arraySearchBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<SearchBean>>() {
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int nextPage;
        /**
         * id : 2410920
         * imgUrl : https://images-cn.ssl-images-amazon.com/images/I/41I-048pcxL._SX540_.jpg
         * brand :
         * price : 174
         * labelprice : 681
         * discount : 2.5折
         * reduce : 减507元
         * title : Calvin Klein Jeans Slim 男士直筒牛仔裤
         * isLike : 0
         * commentCount : 4
         * type : 0
         */

        private List<ItemsBean> items;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
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
            private int price;
            private int labelprice;
            private String discount;
            private String reduce;
            private String title;
            private int isLike;
            private int commentCount;
            private int type;

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

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getLabelprice() {
                return labelprice;
            }

            public void setLabelprice(int labelprice) {
                this.labelprice = labelprice;
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

            public int getIsLike() {
                return isLike;
            }

            public void setIsLike(int isLike) {
                this.isLike = isLike;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
