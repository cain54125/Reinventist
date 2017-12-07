package com.example.cain.reinventist;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Grid_test extends BaseAdapter {
    private LayoutInflater mInflater;
    int [] mimage;
    String[]mtext;
    public Grid_test(LayoutInflater inflater,int []image,String []text){
        mInflater = inflater;
        mimage=image;
        mtext=text;
    }

    @Override
    public int getCount() {
        return mimage.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewDatatest = mInflater.inflate(R.layout.activity_grid_test,null);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) mInflater.getContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int height = displaymetrics.heightPixels;

        ImageView imageView=(ImageView)viewDatatest.findViewById(R.id.image);
        TextView textView=(TextView)viewDatatest.findViewById(R.id.text);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxWidth((int)(width*0.5));
        imageView.setMinimumWidth((int)(width*0.5));
        imageView.setMaxHeight((int)(width*0.5));
        imageView.setMinimumHeight((int)(width*0.5));
        imageView.setImageResource(mimage[position]);
        textView.setText(mtext[position]);
        textView.setTextSize(20);
        return viewDatatest;
    }
}
