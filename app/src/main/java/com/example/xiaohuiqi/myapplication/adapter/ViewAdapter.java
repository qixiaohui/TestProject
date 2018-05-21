package com.example.xiaohuiqi.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaohuiqi.myapplication.R;
import com.example.xiaohuiqi.myapplication.model.Resturant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    private List<Resturant> resturants = new ArrayList<>(1);
    private Context mContex;

    public ViewAdapter(Context context) {
        mContex = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Resturant resturant = resturants.get(position);
        Picasso.with(mContex).load(resturant.getCoverImgUrl()).into(holder.image);
        holder.title.setText(resturant.getName());
        holder.subtitle.setText(resturant.getBusiness().getName());
        holder.status.setText(resturant.getStatus());
    }

    @Override
    public int getItemCount() {
        return resturants.size();
    }

    public void addData(List<Resturant> resturants) {
        final int notifyPosition = resturants.size();
        this.resturants.addAll(resturants);
        this.notifyItemRangeChanged(notifyPosition, resturants.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView subtitle;
        public TextView status;

        public ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            status = (TextView) view.findViewById(R.id.status);
        }
    }
}
