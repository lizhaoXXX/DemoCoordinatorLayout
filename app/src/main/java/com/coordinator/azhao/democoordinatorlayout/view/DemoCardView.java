package com.coordinator.azhao.democoordinatorlayout.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/**
 * @author azhao
 * @date 2018/7/9
 * $desc 锁定宽高比的CardView
 */
public class DemoCardView extends CardView {
	
	private float ratio = 0.6f;
	
	public DemoCardView(Context context) {
		this(context, null);
	}
	
	public DemoCardView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public DemoCardView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if (ratio > 0) {
			Log.i(getClass().getName()+"==", "getMeasuredWidth() = " + getMeasuredWidth() + "--getMeasuredHeight() = " + getMeasuredHeight());
			int ratioHeight = (int) (getMeasuredWidth() * ratio);
			setMeasuredDimension(getMeasuredWidth(), ratioHeight);
			ViewGroup.LayoutParams lp = getLayoutParams();
			lp.height = ratioHeight;
			setLayoutParams(lp);
		}
	}
}