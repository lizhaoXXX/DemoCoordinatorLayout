package com.coordinator.azhao.democoordinatorlayout.view02;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.coordinator.azhao.democoordinatorlayout.R;

/**
 * @author azhao
 * @date 2018/7/23
 * $desc 卡片翻转效果
 */
public class ImageFrameLayout extends FrameLayout implements View.OnClickListener {
	private final static String TAG = "ImageFrameLayout";
	private FrameLayout mFrontFrameLayout;
	private FrameLayout mBackFrameLayout;
	private float mDownX;
	private float mDownY;
	
	public ImageFrameLayout(@NonNull Context context) {
		this(context, null);
	}
	
	public ImageFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.view_image_fragme, this);
		initView();
	}
	
	private void initView() {
		mFrontFrameLayout = findViewById(R.id.fl_front);
		mBackFrameLayout = findViewById(R.id.fl_back);
		ImageView mFrontImage = findViewById(R.id.iv_front);
		ImageView mFrontBack = findViewById(R.id.iv_back);
		
//		int distance = 16000;
		int distance = 15000;
		float scale = getResources().getDisplayMetrics().density * distance;
		mFrontFrameLayout.setCameraDistance(scale);
		mBackFrameLayout.setCameraDistance(scale);

//		mFrontFrameLayout.setOnClickListener(this);
//		mBackFrameLayout.setOnClickListener(this);
		
	}
	
	
	/**
	 * 对两个Layout 作属性动画，font 布局旋转90度时，back 布局从-90度开始旋转到0度。注意设置旋转动画时的可点击性。
	 * @param fontView
	 * @param backView
	 */
	public void doHideAndShowAnimation(final View fontView, final View backView){
		final int runTime = 500;
		fontView.animate().withStartAction(new Runnable() {
			@Override
			public void run() {
				fontView.setClickable(false);
				backView.setClickable(false);
				fontView.setRotationY(0);
				fontView.setAlpha(1);
				
				backView.setAlpha(0);
				backView.setRotationY(-90);
			}
		}).rotationY(90).withEndAction(new Runnable() {
			@Override
			public void run() {
				fontView.setAlpha(0);
				backView.setAlpha(1);
				backView.animate().rotationY(0)
					.setInterpolator(new AccelerateDecelerateInterpolator())
					.setDuration(runTime)
					.withEndAction(new Runnable() {
					@Override
					public void run() {
						backView.setClickable(true);
					}
				}).start();
			}
		}).setInterpolator(new AccelerateDecelerateInterpolator())
			.setDuration(runTime)
			.start();
		
	}
	
	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.fl_front){
			doHideAndShowAnimation(mFrontFrameLayout, mBackFrameLayout);
		}else {
			doHideAndShowAnimation(mBackFrameLayout, mFrontFrameLayout);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		int mMeasuredWidth = getMeasuredWidth();
		switch (event.getAction()){
		    case MotionEvent.ACTION_DOWN:
//		    	Log.i(TAG, "ACTION_DOWN");
				mDownX = x;
				mDownY = y;
//		    break;
				return true;
		    case MotionEvent.ACTION_MOVE:
//				Log.i(TAG, "ACTION_MOVE");
				float moveX = mDownX - x;
				float hX = Math.abs(moveX);
				float verY = Math.abs(mDownY - y);
				if (hX > verY){
//					final float rotation = 180f * moveX;
					final float rotation =  (moveX / mMeasuredWidth) * 180f;
					Log.i(TAG, "ACTION_MOVE = " + rotation + "--mMeasuredWidth = " + mMeasuredWidth + "--moveX=" + moveX);
					//左右滑动
//					if (moveX > 0){
//						//从右往左滑动
//						mFrontFrameLayout.setAlpha(1);
//						mBackFrameLayout.setAlpha(0);
//					}else {
//						//从左往右滑动
//						mFrontFrameLayout.setAlpha(0);
//						mBackFrameLayout.setAlpha(1);
//					}
//					mFrontFrameLayout.setRotationY(rotation);
//					mBackFrameLayout.setRotationY(rotation);
				}
				break;
			case MotionEvent.ACTION_UP:
				Log.i(TAG, "ACTION_UP");
				break;
		    default:
		        break;
		}
		return super.onTouchEvent(event);
//		return true;
	}
}
