package com.coordinator.azhao.democoordinatorlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @author azhao
 * @date 2018/7/9
 * $desc
 */
public class MyFragment extends Fragment {
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		ImageView imageView = new ImageView(getActivity());
		imageView.setImageResource(R.mipmap.a3);
		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		return imageView;
	}
}
