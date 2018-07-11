package com.coordinator.azhao.democoordinatorlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.coordinator.azhao.democoordinatorlayout.view.CardTransformer02;
import com.coordinator.azhao.democoordinatorlayout.view.RecyclerCoverFlow;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	
	private Toolbar mToolbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AppBarLayout appBarLayout = findViewById(R.id.ab_app_bar);
		ImageView imageView = findViewById(R.id.iv_image);
		mToolbar = findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);
		
		appBarLayout = findViewById(R.id.ab_app_bar);
		appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
			@Override
			public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
				mToolbar.setBackgroundColor(changeAlpha(ContextCompat.getColor(MainActivity.this, R.color.colorWhite),
					Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange()));
			}
		});
		
		List<Integer> data = new ArrayList<>();
		data.add(R.mipmap.image1);
		data.add(R.mipmap.image2);
		data.add(R.mipmap.image3);
//		data.add(R.mipmap.image4);
//		data.add(R.mipmap.image5);
		
		List<Fragment> dataFragment = new ArrayList<>();
		/*dataFragment.add(new MyFragment());
		dataFragment.add(new MyFragment());
		dataFragment.add(new MyFragment());*/
		dataFragment.add(new MyFragment02());
		dataFragment.add(new MyFragment02());
		dataFragment.add(new MyFragment02());
		
		//普通的viewpager显示效果,加入动画
		ViewPager viewPager = findViewById(R.id.vp_view_pager);
		//设置缓存的页面数量
		viewPager.setOffscreenPageLimit(dataFragment.size());
		
		//左右滑动的
//		viewPager.setPageTransformer(true, new CustPagerTransformer(MainActivity.this));
		//卡片效果的动画
//		viewPager.setPageTransformer(true,new CardTransformer());
		viewPager.setPageTransformer(true,new CardTransformer02());
		
		viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), dataFragment));
		//设置Page间间距
//		viewPager.setPageMargin(80);
//		if (dataFragment.size() >= 3){
//			viewPager.setCurrentItem(1);
//		}
		
		
		//recyclerView的图片层叠效果，焦点事件有一点冲突
		RecyclerCoverFlow mList = findViewById(R.id.list);
		//平面滚动
		mList.setFlatFlow(false);
		mList.setGreyItem(true);
		mList.setAlphaItem(true);
		mList.setIntervalRatio(0.6f);
		mList.setHasFixedSize(true);
		mList.setAdapter(new PhotoAdapter(MainActivity.this, data));
		mList.setOnItemSelectedListener(new com.coordinator.azhao.democoordinatorlayout.view.CoverFlowLayoutManger.OnSelected() {
			@Override
			public void onItemSelected(int position) {
				//选中的回调
			}
		});
		
		
		
		//仿魅族viewpager轮播图效果可以，只不过是在图片上，还没有加入fragment测试，好像在魅族手机出现崩溃问题（需测试）
		MZBannerView mMZBanner = findViewById(R.id.banner);
		// 设置数据
		mMZBanner.setPages(data, new MZHolderCreator<BannerViewHolder>() {
			@Override
			public BannerViewHolder createViewHolder() {
				return new BannerViewHolder();
			}
		});
		
		
		//符合现需求，但是这个开源需要大量的运行内存，少于2个item则无法自动轮播,感觉效果也不好，废弃
		final HorizontalInfiniteCycleViewPager infiniteCycleViewPager = findViewById(R.id.hicvp);
		infiniteCycleViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), dataFragment));
		infiniteCycleViewPager.setScrollDuration(500);
//		infiniteCycleViewPager.setInterpolator(...);
		infiniteCycleViewPager.setMediumScaled(true);
		infiniteCycleViewPager.setMaxPageScale(0.8F);
		infiniteCycleViewPager.setMinPageScale(0.5F);
		infiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
		infiniteCycleViewPager.setMinPageScaleOffset(5.0F);
//		infiniteCycleViewPager.setOnInfiniteCyclePageTransformListener(...);
		infiniteCycleViewPager.stopAutoScroll();
	}
	
	/**
	 * 根据百分比改变颜色透明度
	 */
	public int changeAlpha(int color, float fraction) {
		int red = Color.red(color);
		int green = Color.green(color);
		int blue = Color.blue(color);
		int alpha = (int) (Color.alpha(color) * fraction);
		return Color.argb(alpha, red, green, blue);
	}
	
	
	
}
