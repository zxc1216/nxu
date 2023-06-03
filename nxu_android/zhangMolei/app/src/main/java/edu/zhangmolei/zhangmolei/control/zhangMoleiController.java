package edu.zhangmolei.zhangmolei.control;

import edu.zhangmolei.zhangmolei.model.zhangMoleiStu;
import edu.zhangmolei.zhangmolei.model.zhangMoleiStuList;

public class zhangMoleiController {
    public boolean addStu(String sno,String name,String sex,String zhuanye,String nianji) {
        zhangMoleiStuList zhangMoleiStuList = edu.zhangmolei.zhangmolei.model.zhangMoleiStuList.getZhangMoleiStuList();
        int i = 0;
        for (; i < zhangMoleiStuList.size(); ++i) {

            zhangMoleiStu zhangMoleiStu = zhangMoleiStuList.get(i);
            String bid = zhangMoleiStu.getSno();
            if (bid.equals(sno)) {
                break;
            }
        }
        if (i == zhangMoleiStuList.size()) {
            zhangMoleiStu zhangMoleiStu = new zhangMoleiStu(sno, name, sex,zhuanye,nianji);
            zhangMoleiStuList.add(zhangMoleiStu);
            return true;

        }
        return false;
    }

    public zhangMoleiStuList searchStu() {
        zhangMoleiStuList zhangMoleiStuList = edu.zhangmolei.zhangmolei.model.zhangMoleiStuList.getZhangMoleiStuList();
        return zhangMoleiStuList;
    }

    public boolean deleteStu(String name)
    {
        zhangMoleiStuList zhangMoleiStuList = edu.zhangmolei.zhangmolei.model.zhangMoleiStuList.getZhangMoleiStuList();
        for (int i=0; i<zhangMoleiStuList.size(); ++i)
        {
            zhangMoleiStu zhangMoleiStu = zhangMoleiStuList.get(i);
            if(zhangMoleiStu.getName().equals(name))
            {
                zhangMoleiStuList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean setStu(String sno,String name,String sex,String zhuanye,String nianji)
    {
        zhangMoleiStuList zhangMoleiStuList = edu.zhangmolei.zhangmolei.model.zhangMoleiStuList.getZhangMoleiStuList();
        for(int i=0;i<zhangMoleiStuList.size();++i)
        {
            zhangMoleiStu zhangMoleiStu = zhangMoleiStuList.get(i);
            if(zhangMoleiStu.getSno().equals(sno))
            {
                zhangMoleiStu zhangMoleiStu1 = new zhangMoleiStu(sno, name, sex,zhuanye,nianji);
                zhangMoleiStuList.set(i,zhangMoleiStu1);
                return true;
            }
        }
        return false;

    }
}

