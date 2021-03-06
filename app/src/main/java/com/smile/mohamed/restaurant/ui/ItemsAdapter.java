package com.smile.mohamed.restaurant.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smile.mohamed.restaurant.R;
import com.smile.mohamed.restaurant.databinding.RvItemsLayoutBinding;

import java.util.List;



public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    public ItemsAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        RvItemsLayoutBinding binding=
                DataBindingUtil.inflate(layoutInflater, R.layout.rv_items_layout, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public RvItemsLayoutBinding binding;
        public MyViewHolder(RvItemsLayoutBinding view) {
            super(view.getRoot());
            this.binding = view;

        }
    }

}