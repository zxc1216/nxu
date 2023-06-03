package edu.zhangmolei.zhangmolei.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import edu.zhangmolei.zhangmolei.DB.zhangMolei_DBHelper;
import edu.zhangmolei.zhangmolei.R;

public class zhangMolei_Sql extends Activity {
    private EditText name,sno,zhuanye,nianji,sex;
    private TextView show,showSno,showZhuanye,showNianji,showSex;
    final zhangMolei_DBHelper dbHelper=new zhangMolei_DBHelper(zhangMolei_Sql.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_sql);

        Button insertButton = findViewById(R.id.btn_insert);
        Button updateButton = findViewById(R.id.btn_update);
        Button searchButton = findViewById(R.id.btn_search);
        Button deleteButton = findViewById(R.id.btn_delete);
        name=findViewById(R.id.name);
        sno=findViewById(R.id.sno);
        zhuanye=findViewById(R.id.zhuanye);
        nianji=findViewById(R.id.nianji);
        sex=findViewById(R.id.sex);
        show=findViewById(R.id.tv_show);
        showSno=findViewById(R.id.tv_showSno);
        showZhuanye=findViewById(R.id.tv_showZhuanye);
        showNianji=findViewById(R.id.tv_showNianji);
        showSex=findViewById(R.id.tv_showSex);

        SQLiteDatabase db=dbHelper.getReadableDatabase();

        myShow();

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name",name.getText().toString());
                values.put("sno",sno.getText().toString());
                values.put("zhuanye",zhuanye.getText().toString());
                values.put("nianji",nianji.getText().toString());
                values.put("sex",sex.getText().toString());
                long id =db.insert("information",null,values);
                Log.d("myDeBug","insert");

                myShow();


                db.close();
                name.setText(null);
                sno.setText(null);
                zhuanye.setText(null);
                nianji.setText(null);
                sex.setText(null);
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("sno",sno.getText().toString());
                values.put("zhuanye",zhuanye.getText().toString());
                values.put("nianji",nianji.getText().toString());
                values.put("sex",sex.getText().toString());
                db.update("information",values,"name=?",new String[]{name.getText().toString()});

                myShow();

                db.close();
                Log.d("myDebug","update");
                name.setText(null);
                sno.setText(null);
                zhuanye.setText(null);
                nianji.setText(null);
                sex.setText(null);
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db=dbHelper.getWritableDatabase();
                String name1=name.getText().toString();
                show.setText(null);
                if(name1.equals("")){
                    myShow();
                    db.close();
                }else {
                    show.setText("姓名");
                    showSno.setText("学号");
                    showZhuanye.setText("专业");
                    showNianji.setText("年级");
                    showSex.setText("性别");
                    Cursor cursor = db.rawQuery("select * from information where name = ? ", new String[]{name1});

                    while (cursor.moveToNext()) {
                        String newName = cursor.getString(cursor.getColumnIndex("name"));
                        int newSno = cursor.getInt(cursor.getColumnIndex("sno"));
                        int newZhuanye = cursor.getInt(cursor.getColumnIndex("zhuanye"));
                        int newNianji = cursor.getInt(cursor.getColumnIndex("nianji"));
                        int newSex = cursor.getInt(cursor.getColumnIndex("sex"));
                        show.setText(show.getText() + "\n" + newName);
                        showSno.setText(showSno.getText()+"\n" + newSno);
                        showZhuanye.setText(showZhuanye.getText()+"\n" + newZhuanye);
                        showNianji.setText(showNianji.getText()+"\n" + newNianji);
                        showSex.setText(showSex.getText()+"\n" + newSex);
                    }

                    cursor.close();
                    db.close();
                    name.setText(null);
                    sno.setText(null);
                    zhuanye.setText(null);
                    nianji.setText(null);
                    sex.setText(null);
                }
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db=dbHelper.getWritableDatabase();
                db.delete("information","name=?",new String[]{name.getText().toString()});

                myShow();

                db.close();
                Log.d("myDeBug","DeleteSuccess");
                name.setText(null);
                sno.setText(null);
                zhuanye.setText(null);
                nianji.setText(null);
                sex.setText(null);
            }
        });

    }

    public void myShow(){
        SQLiteDatabase db=dbHelper.getReadableDatabase();


        show.setText("姓名");
        showSno.setText("学号");
        showZhuanye.setText("专业");
        showNianji.setText("年级");
        showSex.setText("性别");
        Cursor cursor = db.rawQuery("select * from information",null);

        while (cursor.moveToNext()) {
            String newName = cursor.getString(cursor.getColumnIndex("name"));
            int newSno = cursor.getInt(cursor.getColumnIndex("sno"));
            int newZhuanye = cursor.getInt(cursor.getColumnIndex("zhuanye"));
            int newNianji = cursor.getInt(cursor.getColumnIndex("nianji"));
            int newSex = cursor.getInt(cursor.getColumnIndex("sex"));
            show.setText(show.getText() + "\n" + newName);
            showSno.setText(showSno.getText()+"\n" + newSno);
            showZhuanye.setText(showZhuanye.getText()+"\n" + newZhuanye);
            showNianji.setText(showNianji.getText()+"\n" + newNianji);
            showSex.setText(showSex.getText()+"\n" + newSex);
        }
        cursor.close();
    }
}
