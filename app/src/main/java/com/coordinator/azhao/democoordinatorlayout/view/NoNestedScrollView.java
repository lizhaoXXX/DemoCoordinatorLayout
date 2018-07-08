package com.coordinator.azhao.democoordinatorlayout.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author azhao
 * @date 2018/7/9
 * $desc
 */
public class NoNestedScrollView extends NestedScrollView {
	private float mDownPosX;
	private float mDownPosY;
	public NoNestedScrollView(@NonNull Context context) {
		this(context, null);
		//这个
	}
	
	public NoNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		final float x = ev.getX();
		final float y = ev.getY();
		final int action = ev.getAction();
		switch (action) {
			case MotionEvent.ACTION_DOWN:
				mDownPosX = x;
				mDownPosY = y;
				break;
			case MotionEvent.ACTION_MOVE:
				final float deltaX = Math.abs(x - mDownPosX);
				final float deltaY = Math.abs(y - mDownPosY);
				// 这里是够拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截
				if (deltaX > deltaY) {
					return false;
				}
				default:
					break;
		}
		
		return super.onInterceptTouchEvent(ev);
	}
}
