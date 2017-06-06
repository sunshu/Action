package me.sunshu.action;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * 创建时间：  17-6-2.
 * 编写人： sunshu
 * 功能描述：
 */

public class DispatchTouchEventLinearLayout extends LinearLayout {
    private String TAG = "DispatchTouchEventLinearLayout";
    public DispatchTouchEventLinearLayout(Context context) {
        super(context);
    }

    public DispatchTouchEventLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ListView ls;
    }

    public DispatchTouchEventLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
            int count = getChildCount();

        for (int i = 0; i < count; i++) {
            Log.i(TAG,"count ="+count);
            Log.i(TAG,"i ="+i);
            Log.i(TAG,"i%2 ="+(i%2));
            if (i%2 == 0){
                Log.i(TAG,"true");
                return  true;
            }else{
                Log.i(TAG,"false");
                return false;
            }
        }

        return super.dispatchTouchEvent(ev);
    }
}
