package com.coordinator.azhao.democoordinatorlayout.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @author azhao
 * @date 2018/7/11
 * $desc
 */
public class MyBehavior02 extends CoordinatorLayout.Behavior<View> {
	public MyBehavior02(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
		return dependency instanceof LinearLayout;
		
	}
	
	@Override
	public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull final View child, @NonNull final View dependency) {
		final int allHeight = -parent.getHeight();
		final int height = allHeight  + dependency.getHeight();
		final int childHeight = child.getHeight();
		
		child.setTranslationY(height);
		Log.i(" 11 child==", child.getTranslationY()+"--" + height + "---childHeight=" + childHeight);
		dependency.setOnTouchListener(new View.OnTouchListener() {
			private float mY;
			
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
					case MotionEvent.ACTION_DOWN:
						mY = motionEvent.getY();
						Log.i("ACTION_DOWN==", mY+"");
						break;
					case MotionEvent.ACTION_MOVE:
						Log.i("ACTION_MOVE==", motionEvent.getY()+"");
						float moveActon = motionEvent.getY();
						float v = moveActon - mY;
						//判断是向上，还是向下
						if (v > 0){
							//向下
							float move = v >= childHeight?0:v;
							Log.i("child=move=", move + "");
							float aa = (child.getTranslationY() +move)< childHeight ?child.getTranslationY()+move:height+childHeight;
							child.setTranslationY( aa);
							Log.i("child==", child.getTranslationY()+"");
						}else {
							//向上
							float move = child.getTranslationY() != 0 && (Math.abs(v) < childHeight) ?Math.abs(v):0;
//							float aa = (child.getTranslationY() - move)< childHeight ?child.getTranslationY()+move:height+childHeight;
							child.setTranslationY(height - move);
							Log.i("child==", child.getTranslationY()+"");
						}
						
						break;
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL:
						mY = 0;
						break;
					default:
						break;
				}
				return true;
			}
		});
		return true;
		
	}
	
}
