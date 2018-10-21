package com.archana.pJAssignment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.archana.pJAssignment.model.SearchType;
import com.squareup.picasso.Picasso;
import info.archana.pJAssignment.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private int rowLayout;
    private Context context;
    private List<SearchType> searchTypes;

    public SearchAdapter(List<SearchType> searchTypes, int rowLayout, Context context) {
        this.searchTypes = searchTypes;
        this.rowLayout = rowLayout;
        this.context = context;
        Log.d("SearchType","SearchType inside SearchAdapter"+searchTypes);
    }

    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchAdapter.SearchViewHolder holder, int position) {
        String name = searchTypes.get(position).getResult().getName();
        if (name != "") {
            holder.titleTextView.setText(name);
        } else {
            holder.titleTextView.setText("No Title");
        }
        try{
            String imageUrl = searchTypes.get(position).getResult().getImage().getContentUrl();
            Picasso.with(context).load(imageUrl).into(holder.coverImageView);
        }catch (NullPointerException e){
            holder.coverImageView.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    public int getItemCount() {
        return searchTypes.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView coverImageView;
        TextView titleTextView;

        public SearchViewHolder(View itemView) {
            super(itemView);
            coverImageView = (ImageView)itemView.findViewById(R.id.coverImageView);
            titleTextView = (TextView)itemView.findViewById(R.id.titleTextView);
        }
    }
}