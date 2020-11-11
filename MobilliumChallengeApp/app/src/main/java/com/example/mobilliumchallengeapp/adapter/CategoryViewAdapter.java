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
import com.example.mobilliumchallengeapp.model.Category_;

import java.util.List;

public class CategoryViewAdapter extends RecyclerView.Adapter<CategoryViewAdapter.MyView> {

    private List<Category_> list;
    private Context context;
    public class MyView
            extends RecyclerView.ViewHolder {

        TextView tvCategoryName;
        ImageView ivCategoryImage;

        public MyView(View view) {
            super(view);

            tvCategoryName = view
                    .findViewById(R.id.tv_category_name);

            ivCategoryImage = view.findViewById(R.id.iv_categories);
        }
    }

    public CategoryViewAdapter(List<Category_> categoryList, Context context) {
        this.list = categoryList;
        this.context = context;

    }
    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType) {

        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card2,
                        parent,
                        false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder,
                                 final int position) {

        holder.tvCategoryName.setText(list.get(position).getName().toUpperCase());

        Glide.with(context)
                .load(list.get(position).getLogo().getUrl())
                .into(holder.ivCategoryImage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
