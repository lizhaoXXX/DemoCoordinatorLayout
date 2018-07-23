package com.coordinator.azhao.democoordinatorlayout.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * @author azhao
 * @date 2018/7/9
 * $desc 锁定宽高比的CardView
 */
public class MyCardView extends CardView {
	
	private float ratioWight = 0.99f;
	private float ratio = 0.7f;
	
	public MyCardView(Context context) {
		this(context, null);
	}
	
	public MyCardView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public MyCardView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if (ratio > 0) {
			int ratioWidth = (int) (getMeasuredWidth() * ratioWight);
			int ratioHeight = (int) (getMeasuredWidth() * ratio);
			setMeasuredDimension(ratioWidth, ratioHeight);
			ViewGroup.LayoutParams lp = getLayoutParams();
			lp.height = ratioHeight;
			lp.width = ratioWidth;
			setLayoutParams(lp);
			
		}
	}
}