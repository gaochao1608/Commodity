package com.qf.administrator.commodity.bean;

import java.util.List;

/**
 * Created by 高超 on 2016/11/15.
 */

public class RecommendListBean {

    /**
     * limit : 20
     * next : /api/dp/mobilepost/?limit=20&offset=20
     * next_exists : true
     * offset : 0
     * previous : null
     * total_count : 191454
     */

    private MetaBean meta;
    /**
     * agree_count : 0
     * comment_count : 0
     * context : 7块钱还包邮哦 在使用觉得效果不错， 推荐给大家.
     * cover_image : http://mgpyh.b0.upaiyun.com/post_image/9505cacbb2fc1bb838a3d8108c6faf15.jpg!focus
     * created_time : 1 分钟前
     * currency : ￥
     * direct_url : /goods/yevsr
     * disagree_count : 0
     * dp_id : null
     * favorite_count : 0
     * hot_degree : 42
     * id : 315781
     * is_favorited : false
     * is_self_sell : false
     * is_stick : false
     * is_vote_down : false
     * is_vote_up : false
     * naturaltime : 1 分钟前
     * origin_price : 7.0
     * price : 7
     * share_url : /m/recommend-detail/315781/
     * source_url : https://detail.tmall.com/item.htm?id=524607277655&ali_trackid=2:mm_25282911_3455987_13726438:1479199828_213_975402210&upsid=a85d708c8bd5ff011b814734d6f5d6ad&clk1=a85d708c8bd5ff011b814734d6f5d6ad
     * subtitle :
     * tags :
     * timestamp : 1479199800
     * title : 亿泰利vga线电脑显示器电视连接数据线视频投影仪延长线1.5/3米5
     * url : /recommend/0315781/
     */

    private List<ObjectsBean> objects;

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
        private String next;
        private boolean next_exists;
        private int offset;
        private Object previous;
        private int total_count;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
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

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }
    }

    public static class ObjectsBean {
        private int agree_count;
        private int comment_count;
        private String context;
        private String cover_image;
        private String created_time;
        private String currency;
        private String direct_url;
        private int disagree_count;
        private Object dp_id;
        private int favorite_count;
        private int hot_degree;
        private int id;
        private boolean is_favorited;
        private boolean is_self_sell;
        private boolean is_stick;
        private boolean is_vote_down;
        private boolean is_vote_up;
        private String naturaltime;
        private double origin_price;
        private int price;
        private String share_url;
        private String source_url;
        private String subtitle;
        private String tags;
        private int timestamp;
        private String title;
        private String url;

        public int getAgree_count() {
            return agree_count;
        }

        public void setAgree_count(int agree_count) {
            this.agree_count = agree_count;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getCover_image() {
            return cover_image;
        }

        public void setCover_image(String cover_image) {
            this.cover_image = cover_image;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getDirect_url() {
            return direct_url;
        }

        public void setDirect_url(String direct_url) {
            this.direct_url = direct_url;
        }

        public int getDisagree_count() {
            return disagree_count;
        }

        public void setDisagree_count(int disagree_count) {
            this.disagree_count = disagree_count;
        }

        public Object getDp_id() {
            return dp_id;
        }

        public void setDp_id(Object dp_id) {
            this.dp_id = dp_id;
        }

        public int getFavorite_count() {
            return favorite_count;
        }

        public void setFavorite_count(int favorite_count) {
            this.favorite_count = favorite_count;
        }

        public int getHot_degree() {
            return hot_degree;
        }

        public void setHot_degree(int hot_degree) {
            this.hot_degree = hot_degree;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIs_favorited() {
            return is_favorited;
        }

        public void setIs_favorited(boolean is_favorited) {
            this.is_favorited = is_favorited;
        }

        public boolean isIs_self_sell() {
            return is_self_sell;
        }

        public void setIs_self_sell(boolean is_self_sell) {
            this.is_self_sell = is_self_sell;
        }

        public boolean isIs_stick() {
            return is_stick;
        }

        public void setIs_stick(boolean is_stick) {
            this.is_stick = is_stick;
        }

        public boolean isIs_vote_down() {
            return is_vote_down;
        }

        public void setIs_vote_down(boolean is_vote_down) {
            this.is_vote_down = is_vote_down;
        }

        public boolean isIs_vote_up() {
            return is_vote_up;
        }

        public void setIs_vote_up(boolean is_vote_up) {
            this.is_vote_up = is_vote_up;
        }

        public String getNaturaltime() {
            return naturaltime;
        }

        public void setNaturaltime(String naturaltime) {
            this.naturaltime = naturaltime;
        }

        public double getOrigin_price() {
            return origin_price;
        }

        public void setOrigin_price(double origin_price) {
            this.origin_price = origin_price;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getSource_url() {
            return source_url;
        }

        public void setSource_url(String source_url) {
            this.source_url = source_url;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


}
