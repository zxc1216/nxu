package edu.zhangmolei.zhangmolei.ui;

import edu.zhangmolei.zhangmolei.control.zhangMoleiController;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import edu.zhangmolei.zhangmolei.R;


public class zhangMolei_Insert extends Activity{
    private EditText name;
    private EditText sno;
    private EditText sex;
    private EditText zhuanye;
    private EditText nianji;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_insert);
        name = (EditText) findViewById(R.id.name);
        sno = (EditText) findViewById(R.id.sno);
        sex = (EditText) findViewById(R.id.sex);
        zhuanye = (EditText) findViewById(R.id.zhuanye);
        nianji = (EditText) findViewById(R.id.nianji);
        Button insert = (Button) findViewById(R.id.i_insert);
        insert.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements View.OnClickListener {

        public void onClick(View v) {
            String stuname = name.getText().toString();
            String stusno = sno.getText().toString();
            String stusex = sex.getText().toString();
            String stuzhuanye = zhuanye.getText().toString();
            String stunianji = nianji.getText().toString();


            zhangMoleiController control;
            control = new zhangMoleiController();
            if (stuname.equals("") || stusno.equals("")
                    || stusex.equals("") || stuzhuanye.equals("") || stunianji.equals("")) {
                new AlertDialog.Builder(zhangMolei_Insert.this).setMessage("信息不能为空!!!").show();
            } else {
                if (control.addStu(stusno, stuname, stusex,stuzhuanye,stunianji)) {
                    sno.setText("");
                    name.setText("");
                    sex.setText("");
                    zhuanye.setText("");
                    nianji.setText("");
                    buildDialog();
                } else {
                    new AlertDialog.Builder(zhangMolei_Insert.this).setMessage("已有此学生！").show();
                }
            }
        }

        private void buildDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(zhangMolei_Insert.this);
            builder.setTitle("录入成功,是否继续录入学生信息？");
            builder.setNegativeButton("返回首页",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            finish();
                        }

                    });
            builder.setPositiveButton("继续录入", null);
            builder.show();
        }

    }

}
