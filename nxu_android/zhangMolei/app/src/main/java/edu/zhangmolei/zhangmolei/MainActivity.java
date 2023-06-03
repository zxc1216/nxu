package edu.zhangmolei.zhangmolei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import edu.zhangmolei.zhangmolei.ui.zhangMolei_Insert;
import edu.zhangmolei.zhangmolei.ui.zhangMolei_Delete;
import edu.zhangmolei.zhangmolei.ui.zhangMolei_Select;
import edu.zhangmolei.zhangmolei.ui.zhangMolei_Set;
import edu.zhangmolei.zhangmolei.ui.zhangMolei_Bgm;
import edu.zhangmolei.zhangmolei.ui.zhangMolei_Sql;
import edu.zhangmolei.zhangmolei.ui.zhangMolei_Map;
import edu.zhangmolei.zhangmolei.ui.zhangMolei_Choujiang;
import edu.zhangmolei.zhangmolei.NDK.zhangMoleiNDK;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_main);
        Button insert = (Button) findViewById(R.id.m_insert);
        Button delete = (Button) findViewById(R.id.m_delete);
        Button set = (Button) findViewById(R.id.m_set);
        Button select = (Button) findViewById(R.id.m_select);
        Button bgm = (Button) findViewById(R.id.m_bgm);
        Button sql = (Button) findViewById(R.id.m_sql);
        Button map = (Button) findViewById(R.id.m_map);
        Button choujiang = (Button) findViewById(R.id.m_choujiang);
        Button encrypt = (Button) findViewById(R.id.m_ndk);
        ButtonListener buttonListener = new ButtonListener();
        insert.setOnClickListener(buttonListener);
        delete.setOnClickListener(buttonListener);
        set.setOnClickListener(buttonListener);
        select.setOnClickListener(buttonListener);
        bgm.setOnClickListener(buttonListener);
        sql.setOnClickListener(buttonListener);
        map.setOnClickListener(buttonListener);
        choujiang.setOnClickListener(buttonListener);
        encrypt.setOnClickListener(buttonListener);
    }

    class ButtonListener implements View.OnClickListener {

        public void onClick(View v) {
            int id = v.getId();
            Intent intent = new Intent();
            switch (id) {
                case R.id.m_insert:
                    intent.setClass(MainActivity.this, zhangMolei_Insert.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_delete:
                    intent.setClass(MainActivity.this, zhangMolei_Delete.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_set:
                    intent.setClass(MainActivity.this, zhangMolei_Set.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_select:
                    intent.setClass(MainActivity.this, zhangMolei_Select.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_bgm:
                    intent.setClass(MainActivity.this, zhangMolei_Bgm.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_sql:
                    intent.setClass(MainActivity.this, zhangMolei_Sql.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_map:
                    intent.setClass(MainActivity.this, zhangMolei_Map.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_choujiang:
                    intent.setClass(MainActivity.this, zhangMolei_Choujiang.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_ndk:
                    intent.setClass(MainActivity.this, zhangMoleiNDK.class);
                    MainActivity.this.startActivity(intent);
                    break;
            }
        }

    }
}