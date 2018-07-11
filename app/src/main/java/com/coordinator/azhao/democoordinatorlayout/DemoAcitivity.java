package com.coordinator.azhao.democoordinatorlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.coordinator.azhao.democoordinatorlayout.view.CustPagerTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author azhao
 * @date 2018/7/11
 * $desc
 */
public class DemoAcitivity extends AppCompatActivity {
	
	private int aa = 10;
	private LinearLayout mLayout;
	View                mBottomSheet;
	BottomSheetBehavior mBehavior;
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main04);
		mBottomSheet = findViewById(R.id.bottomSheet);
		mBehavior = BottomSheetBehavior.from(mBottomSheet);
		mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
			@Override
			public void onStateChanged(@NonNull View bottomSheet, int newState) {
			
			}
			
			@Override
			public void onSlide(@NonNull View bottomSheet, float slideOffset) {
			
			}
		});
		
		RelativeLayout relativeLayout = findViewById(R.id.rl_layout);
		relativeLayout.setOnTouchListener(new View.OnTouchListener() {

			private float mY;

			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()){
				    case MotionEvent.ACTION_DOWN:
						mY = motionEvent.getY();
						break;
				    case MotionEvent.ACTION_MOVE:
						float v = motionEvent.getY() - mY;
						if (v > 0 && Math.abs(v) >= 50){
							//向上
							if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
								mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//								Log.i(getClass().getName()+"==", "mBehavior.getPeekHeight()=" + mBehavior.getPeekHeight());
//								mBehavior.setPeekHeight(mBehavior.getPeekHeight() - 10);
								
							}
						}
					
						if (v < 0 && Math.abs(v) >= 50){
							//向下
							if (mBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
								mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
							}
							
						}
						break;
				    default:
				        break;
				}
				return true;
			}
		});
		
		
		List<Integer> data = new ArrayList<>();
		data.add(R.mipmap.image1);
		data.add(R.mipmap.image2);
		data.add(R.mipmap.image3);
		//		data.add(R.mipmap.image4);
		//		data.add(R.mipmap.image5);
		
		List<Fragment> dataFragment = new ArrayList<>();
		dataFragment.add(new MyFragment());
		dataFragment.add(new MyFragment());
		dataFragment.add(new MyFragment());
		dataFragment.add(new MyFragment());
		dataFragment.add(new MyFragment());
		/*dataFragment.add(new MyFragment02());
		dataFragment.add(new MyFragment02());
		dataFragment.add(new MyFragment02());*/
		
		//普通的viewpager显示效果,加入动画
		ViewPager viewPager = findViewById(R.id.vp_view_pager);
		//设置缓存的页面数量
		viewPager.setOffscreenPageLimit(dataFragment.size());
		
		//左右滑动的
				viewPager.setPageTransformer(true, new CustPagerTransformer(DemoAcitivity.this));
//				viewPager.setPageTransformer(true, new CustPagerTransformer03(DemoAcitivity.this));
		//卡片效果的动画
		//		viewPager.setPageTransformer(true,new CardTransformer());
//		viewPager.setPageTransformer(true,new CardTransformer02());
		
		viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), dataFragment));
	}
}
