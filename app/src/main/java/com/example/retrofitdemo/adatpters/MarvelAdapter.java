package com.example.retrofitdemo.adatpters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import model.Actor;

public class MarvelAdapter extends RecyclerView.Adapter<MarvelAdapter.ViewHolder> {

    private final String TAG = MarvelAdapter.class.getSimpleName();

    private List<Actor> actorList;
    private Context mContext;

    public MarvelAdapter(List<Actor> list, Context context) {
        this.actorList =  list;
        this.mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.actorlist_item,null,false);
        return new MarvelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Log.v(TAG,"onBindViewHolder");

        viewHolder.mTextView.setText(actorList.get(i).getName());
//        Glide.with(mContext)
//                .load(actorList.get(i).getImageurl())
//                .error(Glide.with(viewHolder.mImageView).load(R.drawable.ic_launcher_background))
//                .into(viewHolder.mImageView);

        Picasso.with(mContext)
                .load(actorList.get(i).getImageurl())
                .centerCrop()
                .resize(300,200)
                .error(R.drawable.ic_launcher_background)
                .into(viewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextView;
        private ImageView mImageView;

        public ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tv_title);
            mImageView =(ImageView)view.findViewById(R.id.iv_logo);

        }
    }

    public void updateResponse(List<Actor> actors) {
        Log.v(TAG,"updateResponse==>>"+actors.size());
        actorList = actors;
        notifyDataSetChanged();
    }
}
