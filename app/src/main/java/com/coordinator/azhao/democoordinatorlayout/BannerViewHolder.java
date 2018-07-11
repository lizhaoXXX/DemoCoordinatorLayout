package com.coordinator.azhao.democoordinatorlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.zhouwei.mzbanner.holder.MZViewHolder;

/**
 * @author azhao
 * @date 2018/7/9
 * $desc
 */
public  class BannerViewHolder implements MZViewHolder<Integer> {
	private ImageView mImageView;
	
	@Override
	public View createView(Context context) {
		// 返回页面布局
		View view = LayoutInflater.from(context).inflate(R.layout.fragment_my02,null);
		mImageView =  view.findViewById(R.id.iv_image);
		return view;
	}
	
	@Override
	public void onBind(Context context, int position, Integer data) {
		// 数据绑定
		mImageView.setImageResource(data);
	}
}
