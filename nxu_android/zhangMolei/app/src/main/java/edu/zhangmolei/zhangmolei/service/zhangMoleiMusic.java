package edu.zhangmolei.zhangmolei.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import edu.zhangmolei.zhangmolei.R;

import androidx.annotation.Nullable;

public class zhangMoleiMusic extends Service {
    public MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {//可以实现在ManActivity调用MediaPlay的方法
        return new Finder();
    }
    public class  Finder extends Binder {
        public int getDuration(){//获取总进度条
            return player.getDuration();
        }
        public int getCurrentPosition(){//获取当前进度条
            return player.getCurrentPosition();
        }
        public void setProgress(int s){//更改当前音乐进度
            player.seekTo(s);
        }
    }
    public void onCreate(){//创建后台服务
        super.onCreate();
        player =MediaPlayer.create(this,R.raw.summer);//创建媒体播放对象
        Toast.makeText(this,"创建后台服务...",Toast.LENGTH_SHORT).show();//提示框
    }
    public int onStartCommand(Intent intent,int flags,int startId){//启动后台服务
        super.onStartCommand(intent,flags,startId);
        switch (intent.getIntExtra("play",-1)){
            case 1:
                player.start();//开始
                Toast.makeText(this,"启动后台服务，播放音乐...",Toast.LENGTH_SHORT).show();//提示
                break;
            case 2:
                if (player!=null&&player.isPlaying()){
                    player.pause();//暂停
                    Toast.makeText(this,"暂停...",Toast.LENGTH_SHORT).show();//提示框
                }
                else {
                    player.start();//继续
                    Toast.makeText(this,"继续...",Toast.LENGTH_SHORT).show();//提示框
                }
                break;
            case 3:
                player.stop();//停止
                player.release();//释放内存
                Toast.makeText(this,"销毁后台服务...",Toast.LENGTH_SHORT).show();//提示框
                break;
        }

        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}

