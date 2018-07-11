package com.coordinator.azhao.democoordinatorlayout.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author azhao
 * @date 2018/7/11
 * $desc
 */
public class MyBehavior extends CoordinatorLayout.Behavior<View> {
	public MyBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
		return dependency instanceof AppBarLayout;
		
	}
	
	@Override
	public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
		float scaleY = Math.abs(dependency.getY()) / dependency.getHeight();
		child.setTranslationY(child.getHeight() * scaleY);
//		int height = -parent.getHeight() + child.getHeight()*2;
//		child.setTranslationY(height);
		return true;
		
	}
	
}
