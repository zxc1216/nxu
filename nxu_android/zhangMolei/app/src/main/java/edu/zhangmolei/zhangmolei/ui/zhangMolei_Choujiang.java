package edu.zhangmolei.zhangmolei.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import edu.zhangmolei.zhangmolei.R;
import edu.zhangmolei.zhangmolei.service.zhangMoleiRandom;

public class zhangMolei_Choujiang extends Activity {
    private static Handler handler = new Handler();
    private static TextView labelView = null;
    private static int random ;

    public static void UpdateGUI(int refreshDouble){
        random = refreshDouble;
        handler.post(RefreshLable);
    }

    private static Runnable RefreshLable = new Runnable(){
        @Override
        public void run() {
            labelView.setText(String.valueOf(random));
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_choujiang);

        labelView = (TextView)findViewById(R.id.label);
        Button startButton = (Button)findViewById(R.id.start);
        Button stopButton = (Button)findViewById(R.id.stop);

        final Intent serviceIntent = new Intent(this, zhangMoleiRandom.class);

        startButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                startService(serviceIntent);
            }
        });

        stopButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                stopService(serviceIntent);
            }
        });

    }
}
