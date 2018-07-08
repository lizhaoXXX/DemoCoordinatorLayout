package com.coordinator.azhao.democoordinatorlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

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
		Random random = new Random();
		int i = random.nextInt(6);
		switch (i){
		    case 0:
				imageView.setImageResource(R.mipmap.a1);
		    break;
		    case 1:
				imageView.setImageResource(R.mipmap.a2);
		    break;
			case 2:
				imageView.setImageResource(R.mipmap.a3);
				break;
			case 3:
				imageView.setImageResource(R.mipmap.a6);
				break;
			case 4:
				imageView.setImageResource(R.mipmap.a7);
				break;
		    default:
				imageView.setImageResource(R.mipmap.a7);
		        break;
		}
		
		imageView.setScaleType(ImageView.ScaleType.CENTER);
		return imageView;
	}
}
