package example.application_demo;

import android.os.Handler;
import java.util.logging.LogRecord;

import javax.xml.parsers.FactoryConfigurationError;

/**
 * Created by 13192 on 2022/1/1.
 */

public class CustomCountDownTimer implements Runnable{
    //1 实时去回调这个时候的时间，倒计时几秒  观察着设计模式
    //2 支持传入总时间
    //3 没过一秒总时间减1
    //4 总时间倒计时为0时，回调完成的状态

    private int countDowntime;
    private int time;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;

    public CustomCountDownTimer(int time,ICountDownHandler countDownHandler){
        handler = new Handler();
        this.time = time;
        this.countDowntime = time;
        this.countDownHandler = countDownHandler;
    }

    @Override
    public void run() {
        //实现的逻辑
        if(isRun){
            if(countDownHandler != null){

                countDownHandler.onTicker(countDowntime);
            }
            if(countDowntime == 0){
                cancel();
                if(countDownHandler != null);
                    countDownHandler.onFinish();
            }else{
                countDowntime = time --;
                handler.postDelayed(this,1000);
            }
        }
    }

    public void start(){
        isRun =true;
        handler.post(this);
    }
    //跳出循环
    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }

    // 观察者回调接口（IOC回调）
    public interface ICountDownHandler{
        //倒计时回调
        void onTicker(int time);
        //完成时回调
        void onFinish();
    }
}
