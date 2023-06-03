package edu.zhangmolei.zhangmolei.ui;


import android.app.Activity;
import android.graphics.Typeface;
import edu.zhangmolei.zhangmolei.control.zhangMoleiController;
import edu.zhangmolei.zhangmolei.model.zhangMoleiStu;
import edu.zhangmolei.zhangmolei.model.zhangMoleiStuList;
import edu.zhangmolei.zhangmolei.R;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class zhangMolei_Select extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_select);
        zhangMoleiController control = new zhangMoleiController();
        zhangMoleiStuList zhangMoleiStuList = control.searchStu();
        CreateTable(zhangMoleiStuList);
    }

    private void CreateTable(zhangMoleiStuList zhangMoleiStuList) {
        TableLayout table = (TableLayout) findViewById(R.id.SELECT_ACTIVITY_TableLayout);

        for (int i = 0; i < zhangMoleiStuList.size(); ++i) {
            zhangMoleiStu zhangMoleiStu = zhangMoleiStuList.get(i);
            String sno = zhangMoleiStu.getSno();
            String name = zhangMoleiStu.getName();
            String sex = zhangMoleiStu.getSex();
            String zhuanye = zhangMoleiStu.getZhuanye();
            String nianji = zhangMoleiStu.getNianji();
            TableRow row = new TableRow(this);
            TextView tsno = new TextView(this);
            TextView tname = new TextView(this);
            TextView tsex = new TextView(this);
            TextView tzhuanye = new TextView(this);
            TextView tnianji = new TextView(this);
            tsno.setText(sno);
            tname.setText(name);
            tsex.setText(sex);
            tzhuanye.setText(zhuanye);
            tnianji.setText(nianji);
            row.addView(tsno);
            row.addView(tname);
            row.addView(tsex);
            row.addView(tzhuanye);
            row.addView(tnianji);
            table.addView(row);
        }
    }
}
