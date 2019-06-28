package com.example.nivalsagna.mlcandidateapp.ui;

import android.content.Context;
import android.graphics.drawable.DrawableContainer;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nivalsagna.mlcandidateapp.R;
import com.example.nivalsagna.mlcandidateapp.model.ItemPicture;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class ItemViewPagerAdapter extends PagerAdapter {
    private Context context;
    private List<ItemPicture> imageUrls;

    ItemViewPagerAdapter(Context context, List<ItemPicture> imageUrls){
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        Picasso.get()
                .load(imageUrls.get(position).getSecure_url())
                .fit()
                //.centerCrop()
                .error(context.getResources().getDrawable(R.drawable.ic_block_black_24dp))
                .centerInside()
                .into(imageView);

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
