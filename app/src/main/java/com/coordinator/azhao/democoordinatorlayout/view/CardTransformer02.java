package com.coordinator.azhao.democoordinatorlayout.view;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * 卡片效果Transformer
 * Create by: chenwei.li
 * Date: 2017/12/8
 * time: 14:55
 * Email: lichenwei.me@foxmail.com
 */

public class CardTransformer02 implements ViewPager.PageTransformer {

//    private int mOffset = 60;
    private int mOffset = 15;

    @Override
    public void transformPage(View page, float position) {
		//设置透明度
//		page.setAlpha(0.5f);
	
		//设置每个View在中间，即设置相对原位置偏移量
//		page.setTranslationX((-page.getWidth() * position));
//
//		//缩放比例
//		float scale = (page.getWidth() - mOffset * position) / (float) (page.getWidth());
//		//设置水平方向缩放
//		page.setScaleX(scale);
//		//设置竖直方向缩放
//		page.setScaleY(scale);
		//设置竖直方向偏移量
//		page.setTranslationY(mOffset * position);
	
		if (position <= 0.0f) {
			//被滑动的那页  position 是-下标~ 0
			page.setTranslationX(0f);
		
			//旋转角度  45° * -0.1 = -4.5°
			page.setRotation((45 * position));
		
			//X轴偏移 li:  300/3 * -0.1 = -10
			page.setTranslationX((page.getWidth() / 3 * position));
		
		} else {
		
			//缩放比例
//			float scale = (page.getWidth() - mOffset * position) / (float) (page.getWidth());
//			page.setScaleX(scale);
//			page.setScaleY(scale);
		Log.i(getClass().getName()+"==", "position=" + position);
		if (Math.ceil(position) % 2 == 1){
			page.setTranslationX((-page.getWidth() * position) - 50.0f);
		}else {
			page.setTranslationX((-page.getWidth() * position) + 50.0f);
		}
		
		
//			page.setTranslationY((mOffset * 0.8f) * position);
		
		}
    }
}
