package com.example.retrofitdemo.adatpters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.model.Album;

import org.w3c.dom.Text;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private Context mContext;
    private List<Album> mAlbumsList;



    public AlbumAdapter(Context context, List<Album> albumList) {
        this.mContext = context;
        this.mAlbumsList = albumList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.actorlist_item,viewGroup,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.mTextView.setText(mAlbumsList.get(i).getTitle());
        Glide.with(mContext).load(mAlbumsList.get(i).getImageUrl()).error(Glide.with(viewHolder.mImageView).load(R.drawable.ic_launcher_background)).into(viewHolder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mAlbumsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private ImageView mImageView;

        public  ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tv_title);
            mImageView =(ImageView) view.findViewById(R.id.iv_logo);
        }
    }


    public void updateAlbumList( List<Album> list) {
        mAlbumsList = list;
        notifyDataSetChanged();
    }
}
