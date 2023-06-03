package edu.zhangmolei.zhangmolei.NDK;

import android.app.Activity;
import edu.zhangmolei.zhangmolei.R;
import  android.os.Bundle ;
import  android.view.View ;
import android.widget.EditText;

public class zhangMoleiNDK extends Activity {
    private EditText et;
    private zhangMoleiNDKJiami jni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_ndk);
        et = (EditText) findViewById(R.id.et);
        jni = new zhangMoleiNDKJiami();
    }

    public void encode(View view) {
        //获取edittext的文字
        String word = et.getText().toString();
        //传递c加密处理
        word = jni.encodeInC(word);
        //把处理后的结果显示到edittext上
        et.setText(word);
    }

    public void decode(View view) {
        //获取edittext的文字
        String word = et.getText().toString();
        //传递c加密处理
        word = jni.decodeInC(word);
        //把处理后的结果显示到edittext上
        et.setText(word);
    }
}
