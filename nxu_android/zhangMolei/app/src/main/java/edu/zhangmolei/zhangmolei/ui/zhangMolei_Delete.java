package edu.zhangmolei.zhangmolei.ui;

import edu.zhangmolei.zhangmolei.R;
import edu.zhangmolei.zhangmolei.control.zhangMoleiController;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class zhangMolei_Delete extends Activity{

    private EditText name;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_delete);
        name = (EditText) findViewById(R.id.dname);
        Button delete = (Button) findViewById(R.id.d_delete);
        delete.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements OnClickListener {

        public void onClick(View v) {
            String stuname = name.getText().toString();
            zhangMoleiController control = new zhangMoleiController();
            if(stuname.equals(""))
            {
                new Builder(zhangMolei_Delete.this).setMessage("学生名不能为空！！！").show();
            }
            else
            {
                if (control.deleteStu(stuname)) {
                    name.setText("");
                    buildDialog();
                } else {
                    new Builder(zhangMolei_Delete.this).setMessage("没有此学生！！！").show();
                }
            }
        }

        private void buildDialog() {
            Builder builder = new Builder(zhangMolei_Delete.this);
            builder.setTitle("删除成功,是否继续删除学生？");
            builder.setNegativeButton("返回首页",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            finish();
                        }

                    });
            builder.setPositiveButton("继续删除", null);
            builder.show();
        }
    }
}
