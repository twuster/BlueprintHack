package com.blueprint.blueprinthack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryImageAdapter extends BaseAdapter 
{
    private Context mContext;
    private int[] petImages;
    private int width, height;

    public GalleryImageAdapter(Context context, int[] photos, int w, int h) 
    {
        mContext = context;
        petImages = photos;
        width = w;
        height = h;
    }

    public int getCount() {
        return petImages.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup) 
    {
        // TODO Auto-generated method stub
        ImageView i = new ImageView(mContext);

        i.setImageResource(petImages[index]);
        i.setLayoutParams(new Gallery.LayoutParams(width, width));
    
        i.setScaleType(ImageView.ScaleType.FIT_XY);

        return i;
    }
}