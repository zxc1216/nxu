package edu.zhangmolei.zhangmolei.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import edu.zhangmolei.zhangmolei.R;
import edu.zhangmolei.zhangmolei.service.zhangMoleiMusic;

public class zhangMolei_Bgm extends Activity {
    Button btn,btn2,btn3;
    Intent intent;
    SeekBar seekBar;
    TextView textView,textView2;
    MyConnection myConnection;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_bgm);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        btn=(Button)findViewById(R.id.button);
        btn3=(Button)findViewById(R.id.button2);
        btn2=(Button)findViewById(R.id.button3);
        intent=new Intent(zhangMolei_Bgm.this,zhangMoleiMusic.class);
        btn.setOnClickListener(new mClick());
        btn2.setOnClickListener(new mClick());
        btn3.setOnClickListener(new mClick());
        textView=(TextView)findViewById(R.id.textView) ;
        textView2=(TextView)findViewById(R.id.textView2);
        seekBar.setOnSeekBarChangeListener(new sClick());
    }
    class sClick implements SeekBar.OnSeekBarChangeListener{
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    }
    class  mClick implements View.OnClickListener{
        public void onClick(View view){
            if(view==btn){//开始
                intent.putExtra("play",1);
                zhangMolei_Bgm.this.startService(intent);
                myConnection=new MyConnection();
                bindService(intent,myConnection,BIND_AUTO_CREATE);
            }
            else if(view==btn2){//暂停
                intent.putExtra("play",2);
                zhangMolei_Bgm.this.startService(intent);
                System.out.println(2);

            }
            else if(view==btn3){
                intent.putExtra("play",3);
                zhangMolei_Bgm.this.startService(intent);
            }
        }
    }
    class MyConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
