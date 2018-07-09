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

public class CardTransformer implements ViewPager.PageTransformer {

//    private int mOffset = 60;
    private int mOffset = 10;

    @Override
    public void transformPage(View page, float position) {

    	
        if (position <= 0) {
            page.setRotation(45 * position);
            page.setTranslationX((page.getWidth() / 2 * position));
			page.setAlpha(1.0f);
			Log.i(getClass().getName()+"==", "<=0 position=" +position);
        } else {
			Log.i(getClass().getName()+"==", " position=" +position);
            //移动X轴坐标，使得卡片在同一坐标
			float pageWidth = page.getWidth() * 1.2f;
			page.setTranslationX(-position * pageWidth);
            //缩放卡片并调整位置
            float scale = (page.getWidth() - mOffset * position) / page.getWidth();
            page.setScaleX(scale);
            page.setScaleY(scale);
            //移动Y轴坐标
            page.setTranslationY(position * mOffset);
            
			/*if(position<=0){
				//pos区域[-1,0)
				page.setAlpha(0.5f+0.5f*(1+position));
			}else{
				//pos区域[0,1]
				page.setAlpha(0.5f+0.5f*(1-position));
			}*/
			
        }


    }
}
