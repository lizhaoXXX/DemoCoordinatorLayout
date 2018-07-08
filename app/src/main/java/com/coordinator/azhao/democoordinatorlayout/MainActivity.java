package com.coordinator.azhao.democoordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.coordinator.azhao.democoordinatorlayout.view.RecyclerCoverFlow;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AppBarLayout appBarLayout = findViewById(R.id.ab_app_bar);
		ImageView imageView = findViewById(R.id.iv_image);
		ViewPager viewPager = findViewById(R.id.vp_view_pager);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		List<Integer> data = new ArrayList<>();
		data.add( R.mipmap.a1);
		data.add( R.mipmap.a2);
		data.add( R.mipmap.a3);
		data.add( R.mipmap.a6);
		data.add( R.mipmap.a7);
		
		List<Fragment> dataFragment = new ArrayList<>();
		dataFragment.add(new MyFragment());
		dataFragment.add(new MyFragment());
		dataFragment.add(new MyFragment());
		viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), dataFragment));
		
		RecyclerCoverFlow mList =  findViewById(R.id.list);
		//平面滚动
		mList.setFlatFlow(false);
		mList.setGreyItem(true);
		mList.setAlphaItem(true);
		mList.setIntervalRatio(0.6f);
		
		//禁止上下滑动
		mList.setNestedScrollingEnabled(true);
		mList.setHasFixedSize(true);
		mList.setAdapter(new PhotoAdapter(MainActivity.this, data));
		mList.setOnItemSelectedListener(new com.coordinator.azhao.democoordinatorlayout.view.CoverFlowLayoutManger.OnSelected() {
			@Override
			public void onItemSelected(int position) {
				//选中的回调
			}
		});
		
		
		
		
		
		/*FloatingElement builder = new FloatingBuilder()
									  .anchorView(appBarLayout)
									  .targetView(imageView)
									  .offsetX(300)
                            .offsetY(0)
                            .floatingTransition(new FloatingPathTransition() {
								@Override
								public FloatingPath getFloatingPath() {
									return null;
								}
	
								@Override
								public void applyFloating(final YumFloating yumFloating) {
									
									*//*ValueAnimator alphaAnimator = ObjectAnimator.ofFloat(1.0f, 0.0f);
									alphaAnimator.setDuration(1000);
									alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
										@Override
										public void onAnimationUpdate(ValueAnimator valueAnimator) {
											yumFloating.setAlpha((Float) valueAnimator.getAnimatedValue());
										}
									});
									alphaAnimator.start();*//*
									
								*//*	SpringHelper
										.createWidthBouncinessAndSpeed(0.0f, 1.0f,bounciness, speed)
										.reboundListener(new SimpleReboundListener(){
													@Override
													public void onReboundUpdate(double currentValue) {
														yumFloating.setScaleX((float) currentValue);
														yumFloating.setScaleY((float) currentValue);
													}
												}).start(yumFloating);*//*
								}
							})
								 .build();
		Floating floating = new Floating(this);
		floating.startFloating(builder);*/
	}
	
}
