package example.application_demo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by 13192 on 2022/1/1.
 */

public class FullScreeVideoView extends VideoView {

    //主要用于new出来的对象
    public FullScreeVideoView(Context context) {
        super(context);
    }
    //主要用于xml文件当中，支持自定义属性
    public FullScreeVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //主要用于xml文件，支持义自定义属性和样式
    public FullScreeVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //widthMeasureSpec包含两个主要的内容：1 测量模式 2 测量大小
        int width = getDefaultSize(0,widthMeasureSpec);
        int height = getDefaultSize(0,heightMeasureSpec);
        setMeasuredDimension(width,height);

        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
