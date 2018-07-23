package com.coordinator.azhao.democoordinatorlayout;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author azhao
 * @date 2018/7/23
 * $desc
 */
public class CarImageActivity extends AppCompatActivity {
	
	private ImageView mImageView;
	private int clickCount;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card);
		
		mImageView = findViewById(R.id.iv_image);
		
		mImageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(CarImageActivity.this, "123", Toast.LENGTH_SHORT).show();
				playFlipAnimation2();
			}
		});
		
	}
	
	private void playFlipAnimation2() {
		clickCount++;
		AnimatorSet animatorSetOut = (AnimatorSet) AnimatorInflater
													   .loadAnimator(this, R.animator.card_flip_left_out);
		
		final AnimatorSet animatorSetIn = (AnimatorSet) AnimatorInflater
															.loadAnimator(this, R.animator.card_flip_left_in);
		
		animatorSetOut.setTarget(mImageView);
		animatorSetIn.setTarget(mImageView);
		
		animatorSetOut.addListener(new AnimatorListenerAdapter() {
			
			@Override
			public void onAnimationEnd(Animator animation) {// 翻转90度之后，换图
				if (clickCount % 2 == 0) {
					mImageView.setImageResource(R.mipmap.image4);
				} else {
					mImageView.setImageResource(R.mipmap.image5);
				}
				animatorSetIn.start();
			}
		});
		
		animatorSetIn.addListener(new AnimatorListenerAdapter() {
			
			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO
			}
		});
		animatorSetOut.start();
	}
}
