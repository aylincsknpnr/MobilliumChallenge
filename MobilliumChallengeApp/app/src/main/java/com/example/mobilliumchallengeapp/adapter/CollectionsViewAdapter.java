package com.example.mobilliumchallengeapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobilliumchallengeapp.R;
import com.example.mobilliumchallengeapp.model.Collection;

import java.util.List;

public class CollectionsViewAdapter extends RecyclerView.Adapter<CollectionsViewAdapter.MyView> {

    private List<Collection> list;
    private Context context;

    public class MyView
            extends RecyclerView.ViewHolder {

        TextView tvCollectionTitle;
        TextView tvCollectionSubTitle;
        ImageView ivCollectionImage;

        public MyView(View view) {
            super(view);

            tvCollectionTitle = view
                    .findViewById(R.id.tv_collection_title);
            tvCollectionSubTitle = view
                    .findViewById(R.id.tv_collection_subtitle);
            ivCollectionImage = view.findViewById(R.id.iv_collections);
        }
    }

    public CollectionsViewAdapter(List<Collection> categoryList, Context context) {
        this.list = categoryList;
        this.context = context;

    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType) {

        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card3,
                        parent,
                        false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder,
                                 final int position) {

        holder.tvCollectionTitle.setText(list.get(position).getTitle().toUpperCase());
        holder.tvCollectionSubTitle.setText(list.get(position).getDefinition().toUpperCase());
        Glide.with(context)
                .load(list.get(position).getCover().getUrl())
                .into(holder.ivCollectionImage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
