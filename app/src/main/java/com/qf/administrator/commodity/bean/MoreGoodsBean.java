package com.qf.administrator.commodity.bean;

import java.util.List;

/**
 * Created by 高超 on 2016/11/14.
 */

public class MoreGoodsBean {

    /**
     * description : <p>戴尔（Dell），是一家总部位于美国德克萨斯州朗德罗克的世界五百强企业，由迈克尔·戴尔于1984年创立。戴尔以生产、设计、销售家用以及办公室电脑而闻名，不过它同时也涉足高端电脑市场，生产与销售服务器、数据储存设备、网络设备等。<br></p>
     * id : 13481
     * logo :
     * name : 戴尔（DELL）
     */

    private BrandInfoBean brand_info;
    /**
     * id : 2002959
     * imgUrl : https://images-cn.ssl-images-amazon.com/images/I/41Pb6M5gE0L._SX540_.jpg
     * brand :
     * brand_id :
     * cate_name :
     * price : 1644
     * labelPrice : 4116
     * discount : 4.0折
     * reduce : 减2472元
     * title : Dell Inspiron i3000-101SLV 11.6 Inch Convertible Touchscreen Laptop (Intel Celeron, 2GB RAM, 32GB eMMC)
     * isLove : 0
     * commentCount : 0
     * currency : ￥
     */

    private List<ItemsBean> items;

    public BrandInfoBean getBrand_info() {
        return brand_info;
    }

    public void setBrand_info(BrandInfoBean brand_info) {
        this.brand_info = brand_info;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class BrandInfoBean {
        private String description;
        private int id;
        private String name;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ItemsBean {
        private int id;
        private String imgUrl;
        private int price;
        private int labelPrice;
        private String discount;
        private String reduce;
        private String title;
        private String currency;

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

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
