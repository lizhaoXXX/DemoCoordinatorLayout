package com.coordinator.azhao.democoordinatorlayout.view;

/**
 * @author azhao
 * @date 2018/7/9
 * $desc
 */

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 实现ViewPager左右滑动时的时差
 * Created by xmuSistone on 2016/9/18.
 */
public class CustPagerTransformer03 implements ViewPager.PageTransformer {
	private static final float DEFAULT_MIN_ALPHA = 0.3f;
	private              float mMinAlpha         = DEFAULT_MIN_ALPHA;
	private float MINALPHA = 0.5f;
	private static final float MAX_ALPHA=0.1f;
	private static final float MAX_SCALE=0.9f;
	
	private int       maxTranslateOffsetX;
	private ViewPager viewPager;
	
	public CustPagerTransformer03(Context context) {
	}
	
	@Override
	public void transformPage(View view, float position) {
		//position = 0 当前界面位于屏幕中心,  1 当前Page刚好滑出屏幕，位于屏幕右侧, -1 当前Page刚好滑出屏幕，位于屏幕左侧
		if (position < -1 || position > 1) {
			view.setAlpha(MINALPHA);
		} else {
			//不透明->半透明
			if (position < 0) {//[0,-1]
				view.setAlpha(MINALPHA + (1 + position) * (1 - MINALPHA));
			} else {//[1,0]
				//半透明->不透明
				view.setAlpha(MINALPHA + (1 - position) * (1 - MINALPHA));
			}
		}
		
		
	}
	
	/**
	 * dp和像素转换
	 */
	private int dp2px(Context context, float dipValue) {
		float m = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * m + 0.5f);
	}
	
}