package com.uwork.expandablerecycler.model;

import com.uwork.expandablerecycler.bean.ChildBean;
import com.uwork.expandablerecycler.bean.GroupBean;

import java.util.ArrayList;

public class Model {

    // 第一个listview的文本数据数组
    private static String[] GROUP_LIST = new String[]{"热门", "美食", "购物",
            "休闲", "运动", "丽人", "结婚", "酒店", "爱车", "亲子", "生活", "家装", "旅游"};
    // 第二个listview的文本数据
    private static String[][] CHILD_LIST = {
            {"全部分类", "小吃快餐", "咖啡厅", "电影院", "KTV", "茶馆", "足疗按摩", "超市/便利店",
                    "银行", "经济型酒店", "景点/郊游", "公园", "美发"},
            {"全部美食", "小吃快餐", "西餐", "火锅", "北京菜", "川菜", "日本", "面包甜点", "粤菜",
                    "韩国料理", "自助餐", "浙江菜", "云南菜", "湘菜", "东南亚菜", "西北菜", "鲁菜",
                    "东北菜", "素菜", "新疆菜", "海鲜", "清真菜", "贵州菜", "湖北菜", "其他"},
            {"全部购物", "综合商场", "服饰鞋包", "超市/便利店", "特色集市", "品牌折扣店", "眼镜店", "珠宝饰品",
                    "化妆品", "运动户外", "食品茶酒", "书店", "数码产品", "药店", "京味儿购物", "亲子购物",
                    "花店", "家具建材", "更多购物场所"},
            {"全部休闲娱乐", "咖啡厅", "KTV", "景点/郊游", "电影院", "酒吧", "公园", "温泉", "文化艺术",
                    "足疗按摩", "洗浴", "茶馆", "游乐游艺", "密室", "采摘/农家乐", "桌面游戏", "台球馆",
                    "DIY手工坊", "休闲网吧", "真人CS", "棋牌室", "轰趴馆", "私人影院", "更多休闲娱乐"},
            {"全部运动健身", "健身中心", "游泳馆", "瑜伽", "羽毛球馆", "台球馆", "舞蹈", "体育场馆",
                    "高尔夫场", "网球场", "武术场馆", "篮球场", "保龄球馆", "足球场", "乒乓球馆",
                    "更多体育运动"},
            {"全部丽人", "美发", "美容/SPA", "齿科", "美甲", "化妆品", "瑜伽", "瘦身纤体", "舞蹈",
                    "个性写真", "整形"},
            {"全部结婚", "婚纱摄影", "婚宴酒店", "婚纱礼服", "婚庆公司", "婚戒首饰", "个性写真", "彩妆造型",
                    "婚礼小礼品", "婚礼跟拍", "婚车租赁", "司仪主持", "婚房装修", "更多婚礼服务"},
            {"全部酒店", "经济型酒店", "五星级酒店", "度假村", "四星级酒店", "三星级酒店", "农家院",
                    "公寓式酒店", "青年旅社", "精品酒店", "更多酒店住宿"},
            {"全部爱车", "维修保养", "驾校", "停车场", "4S店/汽车销售", "加油站", "配件/车饰", "汽车租赁",
                    "汽车保险"},
            {"全部亲子", "亲子摄影", "幼儿教育", "亲子游乐", "孕产护理", "亲子购物", "更多亲子服务"},
            {"全部生活服务", "医院", "银行", "齿科", "宠物", "培训", "快照/冲印", "学校", "旅行社",
                    "购物网站", "干洗店", "家政", "奢侈品护理", "商务楼", "小区", "更多生活服务"},
            {"全部家装", "家具家装", "家用电器", "建材", "家装卖场", "装修设计"},
            {"拉萨", "青海", "新疆", "桂林", "福建", "四川"}

    };

    public static ArrayList<GroupBean> getGroups() {
        ArrayList<GroupBean> groups = new ArrayList<>();
        for (int i = 0; i < GROUP_LIST.length; i++) {
            ArrayList<ChildBean> children = new ArrayList<>();
            for (int j = 0; j < CHILD_LIST[i].length; j++) {
                children.add(new ChildBean(CHILD_LIST[i][j]));
            }
            groups.add(new GroupBean(GROUP_LIST[i], children));
        }
        return groups;
    }

    public static ArrayList<ArrayList<GroupBean>> getDoubleData() {
        ArrayList<ArrayList<GroupBean>> allGroups = new ArrayList<>();
        ArrayList<GroupBean> groups = new ArrayList<>();
        for (int i = 0; i < GROUP_LIST.length; i++) {

            ArrayList<ChildBean> children = new ArrayList<>();
            for (int j = 0; j < CHILD_LIST[i].length; j++) {
                children.add(new ChildBean(CHILD_LIST[i][j]));
            }
            groups.add(new GroupBean(GROUP_LIST[i], children));
            if (i % 2 != 0) { //分两组数据
                ArrayList<GroupBean> temp = new ArrayList<>();
                temp.add(groups.get(i - 1));
                temp.add(groups.get(i));
                allGroups.add(temp);
            } else if (i % 2 == 0 && i == GROUP_LIST.length - 1) {
                ArrayList<GroupBean> temp = new ArrayList<>();
                temp.add(groups.get(i));
                allGroups.add(temp);
            }
        }
        return allGroups;
    }
}
