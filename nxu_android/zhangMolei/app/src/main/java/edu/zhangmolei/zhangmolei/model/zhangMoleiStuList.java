package edu.zhangmolei.zhangmolei.model;

import java.util.ArrayList;

public class zhangMoleiStuList extends ArrayList<zhangMoleiStu> {

    private static zhangMoleiStuList zhangMoleiStuList = null;//防止外部调用构造函数

    private zhangMoleiStuList() {
        zhangMoleiStu b1 = new zhangMoleiStu("12020246205", "张沫雷", "男","网络工程","2020");
        zhangMoleiStu b2 = new zhangMoleiStu("12020246666", "慕容雪", "女","软件工程","2020");
        zhangMoleiStu b3 = new zhangMoleiStu("12020246111", "李小布", "女","网络安全","2020");
        zhangMoleiStu b4 = new zhangMoleiStu("12020246112", "李大布", "男","网络工程","2021");
        zhangMoleiStu b5 = new zhangMoleiStu("12020246113", "李中布", "男","网络安全","2020");
        zhangMoleiStu b6 = new zhangMoleiStu("12020246114", "李小石", "女","网络工程","2019");
        zhangMoleiStu b7 = new zhangMoleiStu("12020246115", "李大石", "男","软件工程","2020");
        zhangMoleiStu b8 = new zhangMoleiStu("12020246116", "李中石", "男","网络安全","2021");
        zhangMoleiStu b9 = new zhangMoleiStu("12020246117", "李小剪", "女","软件工程","2020");
        zhangMoleiStu b10 = new zhangMoleiStu("12020246118", "李大剑", "男","网络安全","2021");
        zhangMoleiStu b11 = new zhangMoleiStu("12020246119", "李中坚", "男","软件工程","2021");
        zhangMoleiStu b12 = new zhangMoleiStu("12020246120", "李忠", "男","软件工程","2020");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);
        add(b12);
    }

    public static zhangMoleiStuList getZhangMoleiStuList() {
        if (zhangMoleiStuList == null)
            zhangMoleiStuList = new zhangMoleiStuList();
        return zhangMoleiStuList;

    }

}
