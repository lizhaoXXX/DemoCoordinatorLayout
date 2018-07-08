package com.coordinator.azhao.democoordinatorlayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author azhao
 * @date 2018/7/9
 * $desc
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
	private  List<Fragment> data;
	
	public ViewPagerAdapter(FragmentManager fm, List<Fragment> data) {
		super(fm);
		this.data = data;
	}
	
	@Override
	public Fragment getItem(int i) {
		return data.get(i);
	}
	
	@Override
	public int getCount() {
		return data.size();
	}
}
