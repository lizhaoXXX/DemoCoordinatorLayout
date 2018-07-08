package com.coordinator.azhao.democoordinatorlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * @author azhao
 * @date 2018/7/8
 * $desc
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
	
	private final LayoutInflater mFrom;
	private final List<Integer>  data;
	
	public PhotoAdapter(Context context, List<Integer> data) {
		mFrom = LayoutInflater.from(context);
		this.data = data;
	}
	
	@NonNull
	@Override
	public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new PhotoViewHolder(mFrom.inflate(R.layout.item_photo, viewGroup, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull PhotoViewHolder photoViewHolder, int i) {
		photoViewHolder.mImageView.setImageResource(data.get(i));
	}
	
	@Override
	public int getItemCount() {
		return data != null ? data.size() : 0;
	}
	
	public class PhotoViewHolder extends RecyclerView.ViewHolder {
		
		private ImageView mImageView;
		
		public PhotoViewHolder(@NonNull View itemView) {
			super(itemView);
			mImageView = itemView.findViewById(R.id.iv_image);
		}
	}
}
