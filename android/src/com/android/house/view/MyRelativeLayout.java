package com.android.house.view;

import com.android.house.view.DragLayout.Status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;


public class MyRelativeLayout extends RelativeLayout {
    private DragLayout dl;

    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setDragLayout(DragLayout dl) {
        this.dl = dl;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
    	if(event.getRawX() < getWidth()*0.15){
    		if (dl.getStatus() != Status.Close) {
                return true;
            }
            return super.onInterceptTouchEvent(event);
    	}else{
    		return false;
    	}
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	if(event.getRawX() < getWidth()*0.15 && event.getAction() == MotionEvent.ACTION_DOWN){
    		if (dl.getStatus() != Status.Close) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    dl.close();
                }
                return true;
            }
            return super.onTouchEvent(event);
    	}else{
    		return false;
    	}
    }
}
