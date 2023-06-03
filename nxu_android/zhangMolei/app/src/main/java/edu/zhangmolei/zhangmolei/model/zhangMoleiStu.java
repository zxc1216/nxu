package edu.zhangmolei.zhangmolei.model;

public class zhangMoleiStu {

    private String name;
    private String sno;
    private String sex;
    private String zhuanye;
    private String nianji;

    public zhangMoleiStu(String sno, String name, String sex,String zhuangye,String nianji) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.zhuanye = zhuangye;
        this.nianji = nianji;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye;
    }

    public String getNianji() { return nianji; }

    public void setNianji(String nianji) { this.nianji = nianji; }


    public String toString() {
        return sno + "  " + name + "  " + sex+ "  " + zhuanye+ "  " + nianji;
    };

}
