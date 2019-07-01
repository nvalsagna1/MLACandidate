package com.example.nivalsagna.mlcandidateapp.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.nivalsagna.mlcandidateapp.R;
import com.example.nivalsagna.mlcandidateapp.model.Item;

import java.util.List;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemsViewHolder>
implements View.OnClickListener {
    private List<Item> itemList;
    private Context ctx;
    private View.OnClickListener listener;


    public ItemRecyclerViewAdapter(List<Item> itemList, Context ctx) {
        this.itemList = itemList;
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);

        view.setOnClickListener(this);

        return new ItemsViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(final ItemsViewHolder itemsViewHolder, int position) {
        if (itemList != null) {
            itemsViewHolder.mItem = itemList.get(position);
            itemsViewHolder.tvItemTitle.setText(itemsViewHolder.mItem.getTitle());

            String tmpPrice = String.format("%.0f", itemsViewHolder.mItem.getPrice());
            String tmpCurrency = itemsViewHolder.mItem.getCurrency_id();

            if (tmpCurrency.equals(ctx.getResources().getString(R.string.text_dolar_api_value))){
                tmpCurrency = ctx.getResources().getString(R.string.text_currency_dolar) + " " + tmpPrice;
            } else {
                tmpCurrency = ctx.getResources().getString(R.string.text_currency_pesos) + " " + tmpPrice;
            }

            itemsViewHolder.tvItemPrice.setText(tmpCurrency);



            String photo = itemsViewHolder.mItem.getThumbnail();
            if (!photo.equals("")) {
                Glide.with(ctx)
                        .load(itemsViewHolder.mItem.getThumbnail())
                        .dontAnimate()
                        //.error(ctx.getResources().getDrawable(R.drawable.ic_block_black_24dp))
                        //.diskCacheStrategy(DiskCacheStrategy.NONE)
                        //.skipMemoryCache(true)
                        .into(itemsViewHolder.ivThumbnail);

            }
        }
    }

    @Override
    public int getItemCount() {
        if (itemList != null){
            return itemList.size();
        }
        else{
            return 0;
        }
    }

    public void setData(List<Item> itemlist){
        this.itemList = itemlist;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }

    }

    public static class ItemsViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivThumbnail;
        public TextView tvItemTitle;
        public TextView tvItemPrice;
        public final View mView;
        public Item mItem;


        public ItemsViewHolder(View view) {
            super(view);
            this.mView = view;
            tvItemTitle = view.findViewById(R.id.tvItemTitle);
            tvItemPrice = view.findViewById(R.id.tvItemPrice);
            ivThumbnail = view.findViewById(R.id.ivItem);

        }
    }

}
