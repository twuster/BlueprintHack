package com.blueprint.blueprinthack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class PetAdapter extends BaseAdapter {
	private Context mContext;
	private Pet[] petImages;
	private int width;

	public PetAdapter(Context c, Pet[] pi, int w) {
		mContext = c;
		petImages = pi;
		width = w;
	}

	public int getCount() {
		return petImages.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			imageView = new ImageView(mContext);
			//Change Image Dimension here
			imageView.setLayoutParams(new GridView.LayoutParams(width, width));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(petImages[position].getProfilePhoto());
		return imageView;
	}

}
