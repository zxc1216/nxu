package edu.zhangmolei.zhangmolei.ui;

import edu.zhangmolei.zhangmolei.control.zhangMoleiController;
import edu.zhangmolei.zhangmolei.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class zhangMolei_Set extends Activity{
    private EditText name;
    private EditText sno;
    private EditText sex;
    private EditText zhuanye;
    private EditText nianji;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_set);
        name = (EditText) findViewById(R.id.sname);
        sno = (EditText) findViewById(R.id.ssno);
        sex = (EditText) findViewById(R.id.ssex);
        zhuanye = (EditText) findViewById(R.id.szhuanye);
        nianji = (EditText) findViewById(R.id.snianji);
        Button set = (Button) findViewById(R.id.s_set);
        set.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements View.OnClickListener {

        public void onClick(View v) {

            String stuname = name.getText().toString();
            String stusno = sno.getText().toString();
            String stusex = sex.getText().toString();
            String stuzhuanye = zhuanye.getText().toString();
            String stunianji = nianji.getText().toString();

            zhangMoleiController control = new zhangMoleiController();
            if (stuname.equals("") || stusno.equals("")
                    || stusex.equals("")) {
                new AlertDialog.Builder(zhangMolei_Set.this).setMessage("信息不能为空!!!").show();
            } else {
                if (control.setStu(stusno, stuname, stusex,stuzhuanye,stunianji)) {
                    name.setText("");
                    sno.setText("");
                    sex.setText("");
                    zhuanye.setText("");
                    nianji.setText("");
                    buildDialog();
                } else {
                    new AlertDialog.Builder(zhangMolei_Set.this).setMessage("没有此学号的学生,请重新输入！！！")
                            .show();

                }
            }
        }

        private void buildDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(zhangMolei_Set.this);
            builder.setTitle("修改成功,是否继续修改学生信息？");
            builder.setNegativeButton("返回首页",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            finish();
                        }

                    });
            builder.setPositiveButton("继续修改", null);
            builder.show();
        }
    }

}
