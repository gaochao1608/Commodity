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

public class BuyShowBean {

    /**
     * agree_count : 23
     * brand : {"id":62797,"name":"默认品牌"}
     * comment_count : 16
     * content : {"bad":"价格比以往的专辑都高","good":"制作精美，以立体书的效果呈现出专辑主题，复古风格浓郁。","images":[{"big":"http://mgpyh.b0.upaiyun.com/post_image/7d8af7abc62ed59986df0a18deaee61d.jpg!shaidanbig","height":1080,"id":"460874","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344501676.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/7d8af7abc62ed59986df0a18deaee61d.jpg!shaidansmall","tags":[{"brand":"周杰伦的床边故事","pleace":"https://item.taobao.com/item.htm?spm=a1z10.1-c-s.w4004-14541192450.1.niISqt&amp;id=533200890533","price":"人民币 258","x":701,"y":613}],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/0bf30a6cff196b957d78c81d3ff7eda8.jpg!shaidanbig","height":1080,"id":"460875","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344547952.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/0bf30a6cff196b957d78c81d3ff7eda8.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/8428dc14ddcb2aa24bc15815431641d8.jpg!shaidanbig","height":1080,"id":"460876","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344557236.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/8428dc14ddcb2aa24bc15815431641d8.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/528a6dbd30204f1074668ebb31658ece.jpg!shaidanbig","height":1080,"id":"460877","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344567369.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/528a6dbd30204f1074668ebb31658ece.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/1579d836631d67e07463e070663bdfcf.jpg!shaidanbig","height":1080,"id":"460878","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344579658.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/1579d836631d67e07463e070663bdfcf.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/c9a04907de89e3c8e68847a6a3a44739.jpg!shaidanbig","height":1080,"id":"460879","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344592260.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/c9a04907de89e3c8e68847a6a3a44739.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/f5e3a890b6472f0befbf0c53d1aac1c0.jpg!shaidanbig","height":1080,"id":"460880","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344600753.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/f5e3a890b6472f0befbf0c53d1aac1c0.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/da48e3bb3f665d8bdc653f2ed149b65a.jpg!shaidanbig","height":1080,"id":"460881","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344613930.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/da48e3bb3f665d8bdc653f2ed149b65a.jpg!shaidansmall","tags":[],"width":1080}],"option":"每年的专辑必买已经成为了习惯，周杰伦可以说是创造了一个新的年代，陪伴我走过了童年的岁月，大家购买专辑的时候如果是想买台版的话，推荐大家到贴吧官方团购或者周杰伦中文网的官方淘宝店购买，如果嫌麻烦可以到京东等正轨电商自营渠道购买内地版，比如今年的内地精装版只是名字和台版不一样，精美程度是一样的。","tags":["周杰伦的床边故事"],"total_price":"人民币 258"}
     * cover_image : http://mgpyh.b0.upaiyun.com/post_image/7d8af7abc62ed59986df0a18deaee61d.jpg!show
     * created_time : 3&nbsp;月前
     * direct_url :
     * disagree_count : 4
     * dp_id : null
     * favorite_count : 7
     * id : 3661
     * is_favorited : false
     * is_self_sell : true
     * is_vote_down : false
     * is_vote_up : false
     * naturaltime : 3&nbsp;月前
     * platform : 2
     * share_url : /m/show-detail/3661/
     * source_url : https://detail.tmall.com/item.htm?id=533018610934&amp;ali_refid=a3_430582_1006:1103970904:N:%E5%91%A8%E6%9D%B0%E4%BC%A6%E7%9A%84%E5%BA%8A%E8%BE%B9%E6%95%85%E4%BA%8B:c6b929bc180d93d18a44e066a003f5a5&amp;ali_trackid=1_c6b929bc180d93d18a44e066a003f5a5&amp;spm=a230r.1.14.6.a2HeL7
     * tags :
     * timestamp : 1469344740
     * title : 制作精美，以立体书的效果呈现出专辑主题，复古风格浓郁。
     * total_price : 258
     * url : https://detail.tmall.com/item.htm?id=533018610934&amp;ali_refid=a3_430582_1006:1103970904:N:%E5%91%A8%E6%9D%B0%E4%BC%A6%E7%9A%84%E5%BA%8A%E8%BE%B9%E6%95%85%E4%BA%8B:c6b929bc180d93d18a44e066a003f5a5&amp;ali_trackid=1_c6b929bc180d93d18a44e066a003f5a5&amp;spm=a230r.1.14.6.a2HeL7
     * user : {"avatar":"http://mgpyh.b0.upaiyun.com/show/2a7ff90b03ac465b460c66b7226b80b1.jpg","followed":false,"level":11,"resource_uri":"/api/v3/mobileuser/你管我呢/","total_price":258,"username":"你管我呢"}
     */

    private List<ObjectsBean> objects;

    public static BuyShowBean objectFromData(String str) {

        return new Gson().fromJson(str, BuyShowBean.class);
    }

    public static BuyShowBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), BuyShowBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<BuyShowBean> arrayBuyShowBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<BuyShowBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<BuyShowBean> arrayBuyShowBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<BuyShowBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public List<ObjectsBean> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectsBean> objects) {
        this.objects = objects;
    }

    public static class ObjectsBean {
        /**
         * bad : 价格比以往的专辑都高
         * good : 制作精美，以立体书的效果呈现出专辑主题，复古风格浓郁。
         * images : [{"big":"http://mgpyh.b0.upaiyun.com/post_image/7d8af7abc62ed59986df0a18deaee61d.jpg!shaidanbig","height":1080,"id":"460874","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344501676.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/7d8af7abc62ed59986df0a18deaee61d.jpg!shaidansmall","tags":[{"brand":"周杰伦的床边故事","pleace":"https://item.taobao.com/item.htm?spm=a1z10.1-c-s.w4004-14541192450.1.niISqt&amp;id=533200890533","price":"人民币 258","x":701,"y":613}],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/0bf30a6cff196b957d78c81d3ff7eda8.jpg!shaidanbig","height":1080,"id":"460875","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344547952.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/0bf30a6cff196b957d78c81d3ff7eda8.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/8428dc14ddcb2aa24bc15815431641d8.jpg!shaidanbig","height":1080,"id":"460876","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344557236.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/8428dc14ddcb2aa24bc15815431641d8.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/528a6dbd30204f1074668ebb31658ece.jpg!shaidanbig","height":1080,"id":"460877","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344567369.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/528a6dbd30204f1074668ebb31658ece.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/1579d836631d67e07463e070663bdfcf.jpg!shaidanbig","height":1080,"id":"460878","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344579658.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/1579d836631d67e07463e070663bdfcf.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/c9a04907de89e3c8e68847a6a3a44739.jpg!shaidanbig","height":1080,"id":"460879","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344592260.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/c9a04907de89e3c8e68847a6a3a44739.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/f5e3a890b6472f0befbf0c53d1aac1c0.jpg!shaidanbig","height":1080,"id":"460880","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344600753.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/f5e3a890b6472f0befbf0c53d1aac1c0.jpg!shaidansmall","tags":[],"width":1080},{"big":"http://mgpyh.b0.upaiyun.com/post_image/da48e3bb3f665d8bdc653f2ed149b65a.jpg!shaidanbig","height":1080,"id":"460881","localPath":"/storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344613930.jpg","small":"http://mgpyh.b0.upaiyun.com/post_image/da48e3bb3f665d8bdc653f2ed149b65a.jpg!shaidansmall","tags":[],"width":1080}]
         * option : 每年的专辑必买已经成为了习惯，周杰伦可以说是创造了一个新的年代，陪伴我走过了童年的岁月，大家购买专辑的时候如果是想买台版的话，推荐大家到贴吧官方团购或者周杰伦中文网的官方淘宝店购买，如果嫌麻烦可以到京东等正轨电商自营渠道购买内地版，比如今年的内地精装版只是名字和台版不一样，精美程度是一样的。
         * tags : ["周杰伦的床边故事"]
         * total_price : 人民币 258
         */

        private ContentBean content;
        private int id;
        private String naturaltime;
        /**
         * avatar : http://mgpyh.b0.upaiyun.com/show/2a7ff90b03ac465b460c66b7226b80b1.jpg
         * followed : false
         * level : 11
         * resource_uri : /api/v3/mobileuser/你管我呢/
         * total_price : 258
         * username : 你管我呢
         */

        private UserBean user;

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

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNaturaltime() {
            return naturaltime;
        }

        public void setNaturaltime(String naturaltime) {
            this.naturaltime = naturaltime;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class ContentBean {
            private String bad;
            private String good;
            private String option;
            /**
             * big : http://mgpyh.b0.upaiyun.com/post_image/7d8af7abc62ed59986df0a18deaee61d.jpg!shaidanbig
             * height : 1080
             * id : 460874
             * localPath : /storage/emulated/0/Android/data/com.x.danpinnew/cache/show_1469344501676.jpg
             * small : http://mgpyh.b0.upaiyun.com/post_image/7d8af7abc62ed59986df0a18deaee61d.jpg!shaidansmall
             * tags : [{"brand":"周杰伦的床边故事","pleace":"https://item.taobao.com/item.htm?spm=a1z10.1-c-s.w4004-14541192450.1.niISqt&amp;id=533200890533","price":"人民币 258","x":701,"y":613}]
             * width : 1080
             */

            private List<ImagesBean> images;

            public static ContentBean objectFromData(String str) {

                return new Gson().fromJson(str, ContentBean.class);
            }

            public static ContentBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ContentBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ContentBean> arrayContentBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ContentBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ContentBean> arrayContentBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ContentBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getBad() {
                return bad;
            }

            public void setBad(String bad) {
                this.bad = bad;
            }

            public String getGood() {
                return good;
            }

            public void setGood(String good) {
                this.good = good;
            }

            public String getOption() {
                return option;
            }

            public void setOption(String option) {
                this.option = option;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class ImagesBean {
                private String big;
                private String small;

                public static ImagesBean objectFromData(String str) {

                    return new Gson().fromJson(str, ImagesBean.class);
                }

                public static ImagesBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ImagesBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<ImagesBean> arrayImagesBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<ImagesBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<ImagesBean> arrayImagesBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<ImagesBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getBig() {
                    return big;
                }

                public void setBig(String big) {
                    this.big = big;
                }

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }
            }
        }

        public static class UserBean {
            private String avatar;
            private int total_price;
            private String username;

            public static UserBean objectFromData(String str) {

                return new Gson().fromJson(str, UserBean.class);
            }

            public static UserBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), UserBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<UserBean> arrayUserBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<UserBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<UserBean> arrayUserBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<UserBean>>() {
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
}
