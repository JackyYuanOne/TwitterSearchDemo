package com.yuan.twittersearchdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuan.twittersearchdemo.R;
import com.yuan.twittersearchdemo.model.SearchEntity;

import java.util.List;

/**
 * Created by Yuan on 15/12/23.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private Context mContext;

    private List<SearchEntity> mData;

    public SearchAdapter(@NonNull Context ctx,@NonNull List<SearchEntity> list){
        this.mContext = ctx;
        this.mData = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_list_search, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SearchEntity entity = mData.get(position);
        holder.text_username.setText(entity.user.name);
        holder.text_content.setText(entity.text);
    }

    @Override
    public int getItemCount() {
        return (mData != null) ? mData.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView text_username;

        public TextView text_content;

        public ImageView img_portrait;

        public ViewHolder(View itemView) {
            super(itemView);
            text_username = (TextView) itemView.findViewById(R.id.text_username);
            text_content = (TextView) itemView.findViewById(R.id.text_content);
            img_portrait = (ImageView) itemView.findViewById(R.id.img_portrait);
        }
    }
}
