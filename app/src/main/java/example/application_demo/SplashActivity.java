package example.application_demo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;
//有很多的硬编码,这是问题
public class SplashActivity extends AppCompatActivity {

    private FullScreeVideoView mVideoView;
    private TextView mTvTimer;
    private CustomCountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //bundle就是保存页面状态的载体
        super.onCreate(savedInstanceState);
        //将页面加载如id为R的页面里面去了
        setContentView(R.layout.activity_splash);

        mVideoView = (FullScreeVideoView)findViewById(R.id.vv_paly);
        mTvTimer = (TextView)findViewById(R.id.mTvTimer);
        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });
        mVideoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ File.separator + R.raw.splash));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            @Override
            public void onPrepared(MediaPlayer mp){
                mp.start();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                mp.start();
            }
        });
        CustomCountDownTimer timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mTvTimer.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                mTvTimer.setText("跳过");
            }
        });
        timer.start();
    }

    protected void onDestroy(){
        super.onDestroy();
        timer.cancel();
    }
}
