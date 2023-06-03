package edu.zhangmolei.zhangmolei.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import edu.zhangmolei.zhangmolei.ui.zhangMolei_Sql;

public class zhangMolei_DBHelper extends SQLiteOpenHelper{

    public zhangMolei_DBHelper(Context context){super(context,"zmldemo.db",null,1);}

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,sno INTEGER,zhuanye INTEGER,nianji INTGER,sex INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("myDeBug","数据库版本已更新");
    }

}
