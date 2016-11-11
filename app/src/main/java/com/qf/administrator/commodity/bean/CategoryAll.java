package com.qf.administrator.commodity.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16/11/11.
 */

public class CategoryAll {

    /**
     * code : 1
     * msg : success
     * data : {"comment":{"quick_comment_up":["36个赞","美美嗒","强烈推荐"],"quick_comment_down":[]},"user":{"category_favorite":[]},"category":[{"cate_id":"1000400","cate_name":"母婴 / 童装 / 玩具","level":"0","sub":[{"cate_id":"1000040","cate_name":"洗护用品","level":"1","sub":[]},{"cate_id":"1000401","cate_name":"安全座椅","level":"1","sub":[]},{"cate_id":"1000403","cate_name":"寝居服饰","level":"1","sub":[]},{"cate_id":"1000415","cate_name":"妈妈用品","level":"1","sub":[]},{"cate_id":"1000457","cate_name":"童装","level":"1","sub":[]},{"cate_id":"1000646","cate_name":"童车童床","level":"1","sub":[]},{"cate_id":"1001050","cate_name":"尿裤湿巾","level":"1","sub":[]},{"cate_id":"1001051","cate_name":"奶粉","level":"1","sub":[]},{"cate_id":"1001052","cate_name":"营养辅食","level":"1","sub":[]},{"cate_id":"1001053","cate_name":"喂养用品","level":"1","sub":[]},{"cate_id":"1001486","cate_name":"童鞋","level":"1","sub":[]},{"cate_id":"1001508","cate_name":"婴幼玩具","level":"1","sub":[]},{"cate_id":"1001515","cate_name":"早教益智","level":"1","sub":[]},{"cate_id":"1001522","cate_name":"积木拼插","level":"1","sub":[]},{"cate_id":"1001527","cate_name":"户外运动玩具","level":"1","sub":[]},{"cate_id":"1001528","cate_name":"电动遥控","level":"1","sub":[]},{"cate_id":"1001529","cate_name":"绘画/DIY/仿真","level":"1","sub":[]},{"cate_id":"1001530","cate_name":"儿童文具/音乐玩具","level":"1","sub":[]},{"cate_id":"1001531","cate_name":"娃娃/玩偶","level":"1","sub":[]},{"cate_id":"1001532","cate_name":"手办模型","level":"1","sub":[]},{"cate_id":"1001533","cate_name":"游戏派对","level":"1","sub":[]},{"cate_id":"1001534","cate_name":"趣味周边","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1000400.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1000400-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1000400-2.jpg"},{"cate_id":"1000486","cate_name":"生活 / 家居 / 家装","level":"0","sub":[{"cate_id":"1000001","cate_name":"生活用品","level":"1","sub":[]},{"cate_id":"1000002","cate_name":"家居装饰","level":"1","sub":[]},{"cate_id":"1000097","cate_name":"家纺","level":"1","sub":[]},{"cate_id":"1000244","cate_name":"灯具","level":"1","sub":[]},{"cate_id":"1000459","cate_name":"厨具","level":"1","sub":[]},{"cate_id":"1000494","cate_name":"家具","level":"1","sub":[]},{"cate_id":"1000711","cate_name":"家装建材","level":"1","sub":[]},{"cate_id":"1001084","cate_name":"宠物生活","level":"1","sub":[]},{"cate_id":"1002354","cate_name":"家居日用","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1000486.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1000486-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1000486-2.jpg"},{"cate_id":"1000551","cate_name":"男装","level":"0","sub":[{"cate_id":"1001267","cate_name":"男士上装","level":"1","sub":[]},{"cate_id":"1002056","cate_name":"男士内搭","level":"1","sub":[]},{"cate_id":"1002065","cate_name":"男士裤装","level":"1","sub":[]},{"cate_id":"1002074","cate_name":"特色服饰","level":"1","sub":[]},{"cate_id":"1002078","cate_name":"男士内衣","level":"1","sub":[]},{"cate_id":"1002085","cate_name":"服饰配件","level":"1","sub":[]},{"cate_id":"1002409","cate_name":"男士户外装","level":"2","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1000551.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1000551-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1000551-2.jpg"},{"cate_id":"1000836","cate_name":"女装","level":"0","sub":[{"cate_id":"1002100","cate_name":"女士上装","level":"1","sub":[]},{"cate_id":"1002115","cate_name":"女士裙装","level":"1","sub":[]},{"cate_id":"1002118","cate_name":"女士裤装","level":"1","sub":[]},{"cate_id":"1002131","cate_name":"特色服饰","level":"1","sub":[]},{"cate_id":"1002136","cate_name":"文胸塑身","level":"1","sub":[]},{"cate_id":"1002144","cate_name":"美腿丝袜","level":"1","sub":[]},{"cate_id":"1002154","cate_name":"女士内衣","level":"1","sub":[]},{"cate_id":"1002163","cate_name":"内衣配件","level":"1","sub":[]},{"cate_id":"1002169","cate_name":"服饰配件","level":"1","sub":[]},{"cate_id":"1002423","cate_name":"女士户外装","level":"2","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1000836.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1000836-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1000836-2.jpg"},{"cate_id":"1001023","cate_name":"箱包","level":"0","sub":[{"cate_id":"1000380","cate_name":"女包","level":"1","sub":[]},{"cate_id":"1000524","cate_name":"男包","level":"1","sub":[]},{"cate_id":"1001255","cate_name":"功能箱包","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001023.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001023-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001023-2.jpg"},{"cate_id":"1001024","cate_name":"鞋","level":"0","sub":[{"cate_id":"1000595","cate_name":"男鞋","level":"1","sub":[]},{"cate_id":"1000842","cate_name":"女鞋","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001024.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001024-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001024-2.jpg"},{"cate_id":"1001025","cate_name":"美妆 / 个人洗护","level":"0","sub":[{"cate_id":"1000563","cate_name":"香水","level":"1","sub":[]},{"cate_id":"1000835","cate_name":"美发护发","level":"1","sub":[]},{"cate_id":"1001054","cate_name":"面部护肤","level":"1","sub":[]},{"cate_id":"1001055","cate_name":"时尚彩妆","level":"1","sub":[]},{"cate_id":"1001419","cate_name":"口腔护理","level":"1","sub":[]},{"cate_id":"1001420","cate_name":"身体清洁护理","level":"1","sub":[]},{"cate_id":"1001421","cate_name":"手足清洁护理","level":"1","sub":[]},{"cate_id":"1001422","cate_name":"女性护理","level":"1","sub":[]},{"cate_id":"1001423","cate_name":"男性护理","level":"1","sub":[]},{"cate_id":"1001424","cate_name":"清洁日用","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001025.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001025-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001025-2.jpg"},{"cate_id":"1001027","cate_name":"运动户外","level":"0","sub":[{"cate_id":"1002229","cate_name":"健身器材","level":"1","sub":[]},{"cate_id":"1002242","cate_name":"骑行运动","level":"1","sub":[]},{"cate_id":"1002251","cate_name":"体育用品","level":"1","sub":[]},{"cate_id":"1002263","cate_name":"户外装备","level":"1","sub":[]},{"cate_id":"1002281","cate_name":"智能穿戴","level":"1","sub":[]},{"cate_id":"1002286","cate_name":"垂钓用品","level":"1","sub":[]},{"cate_id":"1002292","cate_name":"游泳用品","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001027.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001027-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001027-2.jpg"},{"cate_id":"1001035","cate_name":"钟表 / 珠宝 / 眼镜","level":"0","sub":[{"cate_id":"1001108","cate_name":"钟表","level":"1","sub":[]},{"cate_id":"1001587","cate_name":"眼镜","level":"1","sub":[]},{"cate_id":"1001596","cate_name":"礼品","level":"1","sub":[]},{"cate_id":"1002322","cate_name":"首饰饰品","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001035.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001035-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001035-2.jpg"},{"cate_id":"1001036","cate_name":"图书","level":"0","sub":[{"cate_id":"1001092","cate_name":"教育","level":"1","sub":[]},{"cate_id":"1001093","cate_name":"进口图书","level":"1","sub":[]},{"cate_id":"1001094","cate_name":"少儿","level":"1","sub":[]},{"cate_id":"1001095","cate_name":"文艺","level":"1","sub":[]},{"cate_id":"1001096","cate_name":"艺术","level":"1","sub":[]},{"cate_id":"1001097","cate_name":"经济管理","level":"1","sub":[]},{"cate_id":"1001098","cate_name":"人文社科","level":"1","sub":[]},{"cate_id":"1001099","cate_name":"励志与成功","level":"1","sub":[]},{"cate_id":"1001100","cate_name":"科技","level":"1","sub":[]},{"cate_id":"1001101","cate_name":"生活","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001036.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001036-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001036-2.jpg"},{"cate_id":"1001039","cate_name":"手机 / 数码 / 摄影","level":"0","sub":[{"cate_id":"1001085","cate_name":"手机通讯","level":"1","sub":[]},{"cate_id":"1001086","cate_name":"摄影摄像","level":"1","sub":[]},{"cate_id":"1001087","cate_name":"手机配件","level":"1","sub":[]},{"cate_id":"1001088","cate_name":"数码配件","level":"1","sub":[]},{"cate_id":"1001089","cate_name":"数码影音","level":"1","sub":[]},{"cate_id":"1001090","cate_name":"智能设备","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001039.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001039-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001039-2.jpg"},{"cate_id":"1001041","cate_name":"电脑 / 办公","level":"0","sub":[{"cate_id":"1001073","cate_name":"电脑整机","level":"1","sub":[]},{"cate_id":"1001074","cate_name":"电脑外设","level":"1","sub":[]},{"cate_id":"1001075","cate_name":"网络设备","level":"1","sub":[]},{"cate_id":"1001076","cate_name":"办公设备耗材","level":"1","sub":[]},{"cate_id":"1001077","cate_name":"办公设备","level":"1","sub":[]},{"cate_id":"1001078","cate_name":"文具耗材","level":"1","sub":[]},{"cate_id":"1001079","cate_name":"电子教育","level":"1","sub":[]},{"cate_id":"1001768","cate_name":"电脑配件","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001041.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001041-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001041-2.jpg"},{"cate_id":"1001042","cate_name":"家用电器","level":"0","sub":[{"cate_id":"1001068","cate_name":"厨房小电","level":"1","sub":[]},{"cate_id":"1001069","cate_name":"大家电","level":"1","sub":[]},{"cate_id":"1001070","cate_name":"厨卫大电","level":"1","sub":[]},{"cate_id":"1001071","cate_name":"生活电器","level":"1","sub":[]},{"cate_id":"1001072","cate_name":"个护电器","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001042.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001042-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001042-2.jpg"},{"cate_id":"1001044","cate_name":"食品 / 酒水 / 生鲜","level":"0","sub":[{"cate_id":"1001056","cate_name":"进口食品","level":"1","sub":[]},{"cate_id":"1001057","cate_name":"中外名酒","level":"1","sub":[]},{"cate_id":"1001058","cate_name":"茗茶","level":"1","sub":[]},{"cate_id":"1001059","cate_name":"饮料冲调","level":"1","sub":[]},{"cate_id":"1001060","cate_name":"休闲食品","level":"1","sub":[]},{"cate_id":"1001061","cate_name":"粮油/调味/干货","level":"1","sub":[]},{"cate_id":"1001062","cate_name":"生鲜食材","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001044.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001044-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001044-2.jpg"},{"cate_id":"1001047","cate_name":"汽车 / 配件 / 用品","level":"0","sub":[{"cate_id":"1001063","cate_name":"汽车车型","level":"1","sub":[]},{"cate_id":"1001064","cate_name":"车载电器","level":"1","sub":[]},{"cate_id":"1001065","cate_name":"汽车配件","level":"1","sub":[]},{"cate_id":"1001066","cate_name":"美容清洗","level":"1","sub":[]},{"cate_id":"1001067","cate_name":"汽车装饰","level":"1","sub":[]},{"cate_id":"1001966","cate_name":"机车","level":"1","sub":[]},{"cate_id":"1001977","cate_name":"安全自驾","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001047.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001047-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001047-2.jpg"},{"cate_id":"1001048","cate_name":"游戏 / 音像 / 乐器","level":"0","sub":[{"cate_id":"1001110","cate_name":"游戏设备","level":"1","sub":[]},{"cate_id":"1001111","cate_name":"游戏软件/卡带","level":"1","sub":[]},{"cate_id":"1001112","cate_name":"音乐","level":"1","sub":[]},{"cate_id":"1001113","cate_name":"影视","level":"1","sub":[]},{"cate_id":"1002024","cate_name":"教育音像","level":"1","sub":[]},{"cate_id":"1002036","cate_name":"乐器","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001048.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001048-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001048-2.jpg"},{"cate_id":"1001270","cate_name":"旅游 / 票务","level":"0","sub":[{"cate_id":"1001305","cate_name":"折扣游","level":"1","sub":[]},{"cate_id":"1001306","cate_name":"演出票务","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001270.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001270-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001270-2.jpg"},{"cate_id":"1001271","cate_name":"营养保健","level":"0","sub":[{"cate_id":"1001318","cate_name":"营养健康","level":"1","sub":[]},{"cate_id":"1001319","cate_name":"滋补养生","level":"1","sub":[]},{"cate_id":"1001320","cate_name":"成人用品","level":"1","sub":[]},{"cate_id":"1001321","cate_name":"保健器械","level":"1","sub":[]},{"cate_id":"1001322","cate_name":"护理护具","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001271.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001271-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001271-2.jpg"},{"cate_id":"1002341","cate_name":"新闻","level":"2","sub":[{"cate_id":"1002342","cate_name":"新品","level":"1","sub":[]},{"cate_id":"1002343","cate_name":"奇葩","level":"1","sub":[]},{"cate_id":"1002378","cate_name":"召回","level":"2","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1002341.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1002341-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1002341-2.jpg"},{"cate_id":"1002348","cate_name":"宠物","level":"0","sub":[{"cate_id":"1002349","cate_name":"水族用品","level":"1","sub":[]},{"cate_id":"1002350","cate_name":"宠物主粮","level":"1","sub":[]},{"cate_id":"1002351","cate_name":"宠物零食","level":"1","sub":[]},{"cate_id":"1002352","cate_name":"猫砂尿布","level":"1","sub":[]},{"cate_id":"1002357","cate_name":"宠物玩具","level":"1","sub":[]},{"cate_id":"1002358","cate_name":"宠物牵引","level":"1","sub":[]},{"cate_id":"1002359","cate_name":"宠物驱虫","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1002348.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1002348-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1002348-2.jpg"}],"currency":["人民币","美元","英镑","日元","欧元"],"country":["马尔维纳斯","上沃尔特","不丹","东帝汶","中国","中国台湾","中国澳门","中国香港","中途岛","中间地带","中非","丹麦","乌克兰","乌干达","乌拉圭","乍得","也门","以色列","伊拉克","伊朗","伯利兹","佛得角","俄罗斯(包括原苏联) ","保加利亚","关岛","冈比亚","冰岛","几内亚","几内亚比绍","列支敦土登","刚果","利比亚","利比里亚","加拿大","加纳 　","加蓬","匈牙利","南斯拉夫","南朝鲜","南非(阿札尼亚)","博茨瓦纳","卡诺尔","卢旺达","卢森堡","印度","印度尼西亚","危地马拉","厄瓜多尔","叙利亚","古巴","吉布提","哥斯达黎加","喀麦隆","图瓦卢","土耳其","圣卢西亚","圣基茨-尼维斯-安圭拉","圣多美和普林西比","圣文森特和格林纳丁斯","圣皮埃尔和密克隆","圣赫勒拿","圣马力诺","圭亚那","坎顿和恩德贝里群岛","坦桑尼亚","埃及","埃塞俄比亚","基里巴斯","塞内加尔","塞拉利昂","塞浦路斯","塞舌尔","墨西哥","多哥","多米尼加","多米尼加共和国","太平洋群岛","奥地利","委内瑞拉","威克岛","孟加拉","尼加拉瓜","尼日利亚","尼日尔","尼泊尔","巴勒斯坦","巴哈马","巴基斯坦","巴巴多斯","巴布亚新几内亚","巴拉圭","巴拿马","巴林","巴西","布维岛","布隆迪","希腊","库克群岛","开曼群岛","德国","德意志联邦共和国","意大利","所罗门群岛","扎伊尔","托克劳","挪威","捷克","摩洛哥","摩纳哥","文莱","斐济","斯威士兰","斯洛伐克","斯瓦巴德群岛","斯里兰卡","新加坡","新喀里多尼亚","新西兰","日本","朝鲜","柬埔寨","格林纳达","格陵兰","梵蒂冈","比利时","毛德地","毛里塔尼亚","毛里求斯","民主也门","汤加","沙特阿拉伯","法国","法属圭亚那","法属波利尼西亚","法罗","波兰","波多黎各","泰国","津巴布韦","洪都拉斯","海地","澳大利亚","澳门","爱尔兰","牙买加","特克斯和凯科斯群岛","特立尼达和多哥巴","玻利维亚","瑙鲁","瑞典","瑞士","瓜德罗普","瓦利斯和富图纳群岛","瓦努阿图","留尼汪","百慕大","皮特凯恩岛","直布罗陀","福克兰群岛","科威持","秘鲁","突尼斯","索马里","约旦","约翰斯顿岛","纳米比亚","纽埃岛","缅甸","罗马尼亚","美国","美属太平洋群岛","美属维尔京群岛","老挝","肯尼亚","芬兰","苏丹","苏里南","英国","英属印度洋领土","英属维尔京群岛","荷兰","荷属安的列斯","莫桑比克","莱索托","菲律滨","萨尔瓦多","葡萄牙","蒙古","蒙特塞拉特","西撤哈拉","西班牙","西萨摩亚","诺福克岛","象牙海岸","贝宁","赞比亚","赤道几内亚","赫德岛","越南","阿拉伯联合酋长国","阿曼","阿联酋","韩国","马尔代夫","马拉维","马提尼克","马来西亚","马耳他","马达加斯加","马里","黎巴嫩"]}
     */

    private int code;
    private String msg;
    /**
     * comment : {"quick_comment_up":["36个赞","美美嗒","强烈推荐"],"quick_comment_down":[]}
     * user : {"category_favorite":[]}
     * category : [{"cate_id":"1000400","cate_name":"母婴 / 童装 / 玩具","level":"0","sub":[{"cate_id":"1000040","cate_name":"洗护用品","level":"1","sub":[]},{"cate_id":"1000401","cate_name":"安全座椅","level":"1","sub":[]},{"cate_id":"1000403","cate_name":"寝居服饰","level":"1","sub":[]},{"cate_id":"1000415","cate_name":"妈妈用品","level":"1","sub":[]},{"cate_id":"1000457","cate_name":"童装","level":"1","sub":[]},{"cate_id":"1000646","cate_name":"童车童床","level":"1","sub":[]},{"cate_id":"1001050","cate_name":"尿裤湿巾","level":"1","sub":[]},{"cate_id":"1001051","cate_name":"奶粉","level":"1","sub":[]},{"cate_id":"1001052","cate_name":"营养辅食","level":"1","sub":[]},{"cate_id":"1001053","cate_name":"喂养用品","level":"1","sub":[]},{"cate_id":"1001486","cate_name":"童鞋","level":"1","sub":[]},{"cate_id":"1001508","cate_name":"婴幼玩具","level":"1","sub":[]},{"cate_id":"1001515","cate_name":"早教益智","level":"1","sub":[]},{"cate_id":"1001522","cate_name":"积木拼插","level":"1","sub":[]},{"cate_id":"1001527","cate_name":"户外运动玩具","level":"1","sub":[]},{"cate_id":"1001528","cate_name":"电动遥控","level":"1","sub":[]},{"cate_id":"1001529","cate_name":"绘画/DIY/仿真","level":"1","sub":[]},{"cate_id":"1001530","cate_name":"儿童文具/音乐玩具","level":"1","sub":[]},{"cate_id":"1001531","cate_name":"娃娃/玩偶","level":"1","sub":[]},{"cate_id":"1001532","cate_name":"手办模型","level":"1","sub":[]},{"cate_id":"1001533","cate_name":"游戏派对","level":"1","sub":[]},{"cate_id":"1001534","cate_name":"趣味周边","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1000400.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1000400-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1000400-2.jpg"},{"cate_id":"1000486","cate_name":"生活 / 家居 / 家装","level":"0","sub":[{"cate_id":"1000001","cate_name":"生活用品","level":"1","sub":[]},{"cate_id":"1000002","cate_name":"家居装饰","level":"1","sub":[]},{"cate_id":"1000097","cate_name":"家纺","level":"1","sub":[]},{"cate_id":"1000244","cate_name":"灯具","level":"1","sub":[]},{"cate_id":"1000459","cate_name":"厨具","level":"1","sub":[]},{"cate_id":"1000494","cate_name":"家具","level":"1","sub":[]},{"cate_id":"1000711","cate_name":"家装建材","level":"1","sub":[]},{"cate_id":"1001084","cate_name":"宠物生活","level":"1","sub":[]},{"cate_id":"1002354","cate_name":"家居日用","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1000486.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1000486-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1000486-2.jpg"},{"cate_id":"1000551","cate_name":"男装","level":"0","sub":[{"cate_id":"1001267","cate_name":"男士上装","level":"1","sub":[]},{"cate_id":"1002056","cate_name":"男士内搭","level":"1","sub":[]},{"cate_id":"1002065","cate_name":"男士裤装","level":"1","sub":[]},{"cate_id":"1002074","cate_name":"特色服饰","level":"1","sub":[]},{"cate_id":"1002078","cate_name":"男士内衣","level":"1","sub":[]},{"cate_id":"1002085","cate_name":"服饰配件","level":"1","sub":[]},{"cate_id":"1002409","cate_name":"男士户外装","level":"2","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1000551.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1000551-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1000551-2.jpg"},{"cate_id":"1000836","cate_name":"女装","level":"0","sub":[{"cate_id":"1002100","cate_name":"女士上装","level":"1","sub":[]},{"cate_id":"1002115","cate_name":"女士裙装","level":"1","sub":[]},{"cate_id":"1002118","cate_name":"女士裤装","level":"1","sub":[]},{"cate_id":"1002131","cate_name":"特色服饰","level":"1","sub":[]},{"cate_id":"1002136","cate_name":"文胸塑身","level":"1","sub":[]},{"cate_id":"1002144","cate_name":"美腿丝袜","level":"1","sub":[]},{"cate_id":"1002154","cate_name":"女士内衣","level":"1","sub":[]},{"cate_id":"1002163","cate_name":"内衣配件","level":"1","sub":[]},{"cate_id":"1002169","cate_name":"服饰配件","level":"1","sub":[]},{"cate_id":"1002423","cate_name":"女士户外装","level":"2","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1000836.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1000836-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1000836-2.jpg"},{"cate_id":"1001023","cate_name":"箱包","level":"0","sub":[{"cate_id":"1000380","cate_name":"女包","level":"1","sub":[]},{"cate_id":"1000524","cate_name":"男包","level":"1","sub":[]},{"cate_id":"1001255","cate_name":"功能箱包","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001023.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001023-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001023-2.jpg"},{"cate_id":"1001024","cate_name":"鞋","level":"0","sub":[{"cate_id":"1000595","cate_name":"男鞋","level":"1","sub":[]},{"cate_id":"1000842","cate_name":"女鞋","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001024.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001024-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001024-2.jpg"},{"cate_id":"1001025","cate_name":"美妆 / 个人洗护","level":"0","sub":[{"cate_id":"1000563","cate_name":"香水","level":"1","sub":[]},{"cate_id":"1000835","cate_name":"美发护发","level":"1","sub":[]},{"cate_id":"1001054","cate_name":"面部护肤","level":"1","sub":[]},{"cate_id":"1001055","cate_name":"时尚彩妆","level":"1","sub":[]},{"cate_id":"1001419","cate_name":"口腔护理","level":"1","sub":[]},{"cate_id":"1001420","cate_name":"身体清洁护理","level":"1","sub":[]},{"cate_id":"1001421","cate_name":"手足清洁护理","level":"1","sub":[]},{"cate_id":"1001422","cate_name":"女性护理","level":"1","sub":[]},{"cate_id":"1001423","cate_name":"男性护理","level":"1","sub":[]},{"cate_id":"1001424","cate_name":"清洁日用","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001025.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001025-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001025-2.jpg"},{"cate_id":"1001027","cate_name":"运动户外","level":"0","sub":[{"cate_id":"1002229","cate_name":"健身器材","level":"1","sub":[]},{"cate_id":"1002242","cate_name":"骑行运动","level":"1","sub":[]},{"cate_id":"1002251","cate_name":"体育用品","level":"1","sub":[]},{"cate_id":"1002263","cate_name":"户外装备","level":"1","sub":[]},{"cate_id":"1002281","cate_name":"智能穿戴","level":"1","sub":[]},{"cate_id":"1002286","cate_name":"垂钓用品","level":"1","sub":[]},{"cate_id":"1002292","cate_name":"游泳用品","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001027.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001027-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001027-2.jpg"},{"cate_id":"1001035","cate_name":"钟表 / 珠宝 / 眼镜","level":"0","sub":[{"cate_id":"1001108","cate_name":"钟表","level":"1","sub":[]},{"cate_id":"1001587","cate_name":"眼镜","level":"1","sub":[]},{"cate_id":"1001596","cate_name":"礼品","level":"1","sub":[]},{"cate_id":"1002322","cate_name":"首饰饰品","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001035.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001035-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001035-2.jpg"},{"cate_id":"1001036","cate_name":"图书","level":"0","sub":[{"cate_id":"1001092","cate_name":"教育","level":"1","sub":[]},{"cate_id":"1001093","cate_name":"进口图书","level":"1","sub":[]},{"cate_id":"1001094","cate_name":"少儿","level":"1","sub":[]},{"cate_id":"1001095","cate_name":"文艺","level":"1","sub":[]},{"cate_id":"1001096","cate_name":"艺术","level":"1","sub":[]},{"cate_id":"1001097","cate_name":"经济管理","level":"1","sub":[]},{"cate_id":"1001098","cate_name":"人文社科","level":"1","sub":[]},{"cate_id":"1001099","cate_name":"励志与成功","level":"1","sub":[]},{"cate_id":"1001100","cate_name":"科技","level":"1","sub":[]},{"cate_id":"1001101","cate_name":"生活","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001036.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001036-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001036-2.jpg"},{"cate_id":"1001039","cate_name":"手机 / 数码 / 摄影","level":"0","sub":[{"cate_id":"1001085","cate_name":"手机通讯","level":"1","sub":[]},{"cate_id":"1001086","cate_name":"摄影摄像","level":"1","sub":[]},{"cate_id":"1001087","cate_name":"手机配件","level":"1","sub":[]},{"cate_id":"1001088","cate_name":"数码配件","level":"1","sub":[]},{"cate_id":"1001089","cate_name":"数码影音","level":"1","sub":[]},{"cate_id":"1001090","cate_name":"智能设备","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001039.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001039-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001039-2.jpg"},{"cate_id":"1001041","cate_name":"电脑 / 办公","level":"0","sub":[{"cate_id":"1001073","cate_name":"电脑整机","level":"1","sub":[]},{"cate_id":"1001074","cate_name":"电脑外设","level":"1","sub":[]},{"cate_id":"1001075","cate_name":"网络设备","level":"1","sub":[]},{"cate_id":"1001076","cate_name":"办公设备耗材","level":"1","sub":[]},{"cate_id":"1001077","cate_name":"办公设备","level":"1","sub":[]},{"cate_id":"1001078","cate_name":"文具耗材","level":"1","sub":[]},{"cate_id":"1001079","cate_name":"电子教育","level":"1","sub":[]},{"cate_id":"1001768","cate_name":"电脑配件","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001041.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001041-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001041-2.jpg"},{"cate_id":"1001042","cate_name":"家用电器","level":"0","sub":[{"cate_id":"1001068","cate_name":"厨房小电","level":"1","sub":[]},{"cate_id":"1001069","cate_name":"大家电","level":"1","sub":[]},{"cate_id":"1001070","cate_name":"厨卫大电","level":"1","sub":[]},{"cate_id":"1001071","cate_name":"生活电器","level":"1","sub":[]},{"cate_id":"1001072","cate_name":"个护电器","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001042.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001042-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001042-2.jpg"},{"cate_id":"1001044","cate_name":"食品 / 酒水 / 生鲜","level":"0","sub":[{"cate_id":"1001056","cate_name":"进口食品","level":"1","sub":[]},{"cate_id":"1001057","cate_name":"中外名酒","level":"1","sub":[]},{"cate_id":"1001058","cate_name":"茗茶","level":"1","sub":[]},{"cate_id":"1001059","cate_name":"饮料冲调","level":"1","sub":[]},{"cate_id":"1001060","cate_name":"休闲食品","level":"1","sub":[]},{"cate_id":"1001061","cate_name":"粮油/调味/干货","level":"1","sub":[]},{"cate_id":"1001062","cate_name":"生鲜食材","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001044.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001044-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001044-2.jpg"},{"cate_id":"1001047","cate_name":"汽车 / 配件 / 用品","level":"0","sub":[{"cate_id":"1001063","cate_name":"汽车车型","level":"1","sub":[]},{"cate_id":"1001064","cate_name":"车载电器","level":"1","sub":[]},{"cate_id":"1001065","cate_name":"汽车配件","level":"1","sub":[]},{"cate_id":"1001066","cate_name":"美容清洗","level":"1","sub":[]},{"cate_id":"1001067","cate_name":"汽车装饰","level":"1","sub":[]},{"cate_id":"1001966","cate_name":"机车","level":"1","sub":[]},{"cate_id":"1001977","cate_name":"安全自驾","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001047.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001047-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001047-2.jpg"},{"cate_id":"1001048","cate_name":"游戏 / 音像 / 乐器","level":"0","sub":[{"cate_id":"1001110","cate_name":"游戏设备","level":"1","sub":[]},{"cate_id":"1001111","cate_name":"游戏软件/卡带","level":"1","sub":[]},{"cate_id":"1001112","cate_name":"音乐","level":"1","sub":[]},{"cate_id":"1001113","cate_name":"影视","level":"1","sub":[]},{"cate_id":"1002024","cate_name":"教育音像","level":"1","sub":[]},{"cate_id":"1002036","cate_name":"乐器","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001048.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001048-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001048-2.jpg"},{"cate_id":"1001270","cate_name":"旅游 / 票务","level":"0","sub":[{"cate_id":"1001305","cate_name":"折扣游","level":"1","sub":[]},{"cate_id":"1001306","cate_name":"演出票务","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001270.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001270-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001270-2.jpg"},{"cate_id":"1001271","cate_name":"营养保健","level":"0","sub":[{"cate_id":"1001318","cate_name":"营养健康","level":"1","sub":[]},{"cate_id":"1001319","cate_name":"滋补养生","level":"1","sub":[]},{"cate_id":"1001320","cate_name":"成人用品","level":"1","sub":[]},{"cate_id":"1001321","cate_name":"保健器械","level":"1","sub":[]},{"cate_id":"1001322","cate_name":"护理护具","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1001271.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1001271-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1001271-2.jpg"},{"cate_id":"1002341","cate_name":"新闻","level":"2","sub":[{"cate_id":"1002342","cate_name":"新品","level":"1","sub":[]},{"cate_id":"1002343","cate_name":"奇葩","level":"1","sub":[]},{"cate_id":"1002378","cate_name":"召回","level":"2","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1002341.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1002341-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1002341-2.jpg"},{"cate_id":"1002348","cate_name":"宠物","level":"0","sub":[{"cate_id":"1002349","cate_name":"水族用品","level":"1","sub":[]},{"cate_id":"1002350","cate_name":"宠物主粮","level":"1","sub":[]},{"cate_id":"1002351","cate_name":"宠物零食","level":"1","sub":[]},{"cate_id":"1002352","cate_name":"猫砂尿布","level":"1","sub":[]},{"cate_id":"1002357","cate_name":"宠物玩具","level":"1","sub":[]},{"cate_id":"1002358","cate_name":"宠物牵引","level":"1","sub":[]},{"cate_id":"1002359","cate_name":"宠物驱虫","level":"1","sub":[]}],"pic":"http://shopstyleimg.b0.upaiyun.com/static/category/1002348.jpg","pic_small":"http://shopstyleimg.b0.upaiyun.com/static/category/1002348-1.jpg","pic_large":"http://shopstyleimg.b0.upaiyun.com/static/category/1002348-2.jpg"}]
     * currency : ["人民币","美元","英镑","日元","欧元"]
     * country : ["马尔维纳斯","上沃尔特","不丹","东帝汶","中国","中国台湾","中国澳门","中国香港","中途岛","中间地带","中非","丹麦","乌克兰","乌干达","乌拉圭","乍得","也门","以色列","伊拉克","伊朗","伯利兹","佛得角","俄罗斯(包括原苏联) ","保加利亚","关岛","冈比亚","冰岛","几内亚","几内亚比绍","列支敦土登","刚果","利比亚","利比里亚","加拿大","加纳 　","加蓬","匈牙利","南斯拉夫","南朝鲜","南非(阿札尼亚)","博茨瓦纳","卡诺尔","卢旺达","卢森堡","印度","印度尼西亚","危地马拉","厄瓜多尔","叙利亚","古巴","吉布提","哥斯达黎加","喀麦隆","图瓦卢","土耳其","圣卢西亚","圣基茨-尼维斯-安圭拉","圣多美和普林西比","圣文森特和格林纳丁斯","圣皮埃尔和密克隆","圣赫勒拿","圣马力诺","圭亚那","坎顿和恩德贝里群岛","坦桑尼亚","埃及","埃塞俄比亚","基里巴斯","塞内加尔","塞拉利昂","塞浦路斯","塞舌尔","墨西哥","多哥","多米尼加","多米尼加共和国","太平洋群岛","奥地利","委内瑞拉","威克岛","孟加拉","尼加拉瓜","尼日利亚","尼日尔","尼泊尔","巴勒斯坦","巴哈马","巴基斯坦","巴巴多斯","巴布亚新几内亚","巴拉圭","巴拿马","巴林","巴西","布维岛","布隆迪","希腊","库克群岛","开曼群岛","德国","德意志联邦共和国","意大利","所罗门群岛","扎伊尔","托克劳","挪威","捷克","摩洛哥","摩纳哥","文莱","斐济","斯威士兰","斯洛伐克","斯瓦巴德群岛","斯里兰卡","新加坡","新喀里多尼亚","新西兰","日本","朝鲜","柬埔寨","格林纳达","格陵兰","梵蒂冈","比利时","毛德地","毛里塔尼亚","毛里求斯","民主也门","汤加","沙特阿拉伯","法国","法属圭亚那","法属波利尼西亚","法罗","波兰","波多黎各","泰国","津巴布韦","洪都拉斯","海地","澳大利亚","澳门","爱尔兰","牙买加","特克斯和凯科斯群岛","特立尼达和多哥巴","玻利维亚","瑙鲁","瑞典","瑞士","瓜德罗普","瓦利斯和富图纳群岛","瓦努阿图","留尼汪","百慕大","皮特凯恩岛","直布罗陀","福克兰群岛","科威持","秘鲁","突尼斯","索马里","约旦","约翰斯顿岛","纳米比亚","纽埃岛","缅甸","罗马尼亚","美国","美属太平洋群岛","美属维尔京群岛","老挝","肯尼亚","芬兰","苏丹","苏里南","英国","英属印度洋领土","英属维尔京群岛","荷兰","荷属安的列斯","莫桑比克","莱索托","菲律滨","萨尔瓦多","葡萄牙","蒙古","蒙特塞拉特","西撤哈拉","西班牙","西萨摩亚","诺福克岛","象牙海岸","贝宁","赞比亚","赤道几内亚","赫德岛","越南","阿拉伯联合酋长国","阿曼","阿联酋","韩国","马尔代夫","马拉维","马提尼克","马来西亚","马耳他","马达加斯加","马里","黎巴嫩"]
     */

    private DataBean data;

    public static CategoryAll objectFromData(String str) {

        return new Gson().fromJson(str, CategoryAll.class);
    }

    public static CategoryAll objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), CategoryAll.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<CategoryAll> arrayCategoryAllFromData(String str) {

        Type listType = new TypeToken<ArrayList<CategoryAll>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<CategoryAll> arrayCategoryAllFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<CategoryAll>>() {
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
        private CommentBean comment;
        private UserBean user;
        /**
         * cate_id : 1000400
         * cate_name : 母婴 / 童装 / 玩具
         * level : 0
         * sub : [{"cate_id":"1000040","cate_name":"洗护用品","level":"1","sub":[]},{"cate_id":"1000401","cate_name":"安全座椅","level":"1","sub":[]},{"cate_id":"1000403","cate_name":"寝居服饰","level":"1","sub":[]},{"cate_id":"1000415","cate_name":"妈妈用品","level":"1","sub":[]},{"cate_id":"1000457","cate_name":"童装","level":"1","sub":[]},{"cate_id":"1000646","cate_name":"童车童床","level":"1","sub":[]},{"cate_id":"1001050","cate_name":"尿裤湿巾","level":"1","sub":[]},{"cate_id":"1001051","cate_name":"奶粉","level":"1","sub":[]},{"cate_id":"1001052","cate_name":"营养辅食","level":"1","sub":[]},{"cate_id":"1001053","cate_name":"喂养用品","level":"1","sub":[]},{"cate_id":"1001486","cate_name":"童鞋","level":"1","sub":[]},{"cate_id":"1001508","cate_name":"婴幼玩具","level":"1","sub":[]},{"cate_id":"1001515","cate_name":"早教益智","level":"1","sub":[]},{"cate_id":"1001522","cate_name":"积木拼插","level":"1","sub":[]},{"cate_id":"1001527","cate_name":"户外运动玩具","level":"1","sub":[]},{"cate_id":"1001528","cate_name":"电动遥控","level":"1","sub":[]},{"cate_id":"1001529","cate_name":"绘画/DIY/仿真","level":"1","sub":[]},{"cate_id":"1001530","cate_name":"儿童文具/音乐玩具","level":"1","sub":[]},{"cate_id":"1001531","cate_name":"娃娃/玩偶","level":"1","sub":[]},{"cate_id":"1001532","cate_name":"手办模型","level":"1","sub":[]},{"cate_id":"1001533","cate_name":"游戏派对","level":"1","sub":[]},{"cate_id":"1001534","cate_name":"趣味周边","level":"1","sub":[]}]
         * pic : http://shopstyleimg.b0.upaiyun.com/static/category/1000400.jpg
         * pic_small : http://shopstyleimg.b0.upaiyun.com/static/category/1000400-1.jpg
         * pic_large : http://shopstyleimg.b0.upaiyun.com/static/category/1000400-2.jpg
         */

        private List<CategoryBean> category;
        private List<String> currency;
        private List<String> country;

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

        public CommentBean getComment() {
            return comment;
        }

        public void setComment(CommentBean comment) {
            this.comment = comment;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public List<String> getCurrency() {
            return currency;
        }

        public void setCurrency(List<String> currency) {
            this.currency = currency;
        }

        public List<String> getCountry() {
            return country;
        }

        public void setCountry(List<String> country) {
            this.country = country;
        }

        public static class CommentBean {
            private List<String> quick_comment_up;
            private List<?> quick_comment_down;

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

            public List<String> getQuick_comment_up() {
                return quick_comment_up;
            }

            public void setQuick_comment_up(List<String> quick_comment_up) {
                this.quick_comment_up = quick_comment_up;
            }

            public List<?> getQuick_comment_down() {
                return quick_comment_down;
            }

            public void setQuick_comment_down(List<?> quick_comment_down) {
                this.quick_comment_down = quick_comment_down;
            }
        }

        public static class UserBean {
            private List<?> category_favorite;

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

            public List<?> getCategory_favorite() {
                return category_favorite;
            }

            public void setCategory_favorite(List<?> category_favorite) {
                this.category_favorite = category_favorite;
            }
        }

        public static class CategoryBean {
            private String cate_id;
            private String cate_name;
            private String level;
            private String pic;
            private String pic_small;
            private String pic_large;
            /**
             * cate_id : 1000040
             * cate_name : 洗护用品
             * level : 1
             * sub : []
             */

            private List<SubBean> sub;

            public static CategoryBean objectFromData(String str) {

                return new Gson().fromJson(str, CategoryBean.class);
            }

            public static CategoryBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), CategoryBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<CategoryBean> arrayCategoryBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<CategoryBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<CategoryBean> arrayCategoryBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<CategoryBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getCate_id() {
                return cate_id;
            }

            public void setCate_id(String cate_id) {
                this.cate_id = cate_id;
            }

            public String getCate_name() {
                return cate_name;
            }

            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getPic_small() {
                return pic_small;
            }

            public void setPic_small(String pic_small) {
                this.pic_small = pic_small;
            }

            public String getPic_large() {
                return pic_large;
            }

            public void setPic_large(String pic_large) {
                this.pic_large = pic_large;
            }

            public List<SubBean> getSub() {
                return sub;
            }

            public void setSub(List<SubBean> sub) {
                this.sub = sub;
            }

            public static class SubBean {
                private String cate_id;
                private String cate_name;
                private String level;
                private List<?> sub;

                public static SubBean objectFromData(String str) {

                    return new Gson().fromJson(str, SubBean.class);
                }

                public static SubBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), SubBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<SubBean> arraySubBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<SubBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<SubBean> arraySubBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<SubBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getCate_id() {
                    return cate_id;
                }

                public void setCate_id(String cate_id) {
                    this.cate_id = cate_id;
                }

                public String getCate_name() {
                    return cate_name;
                }

                public void setCate_name(String cate_name) {
                    this.cate_name = cate_name;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public List<?> getSub() {
                    return sub;
                }

                public void setSub(List<?> sub) {
                    this.sub = sub;
                }
            }
        }
    }
}
