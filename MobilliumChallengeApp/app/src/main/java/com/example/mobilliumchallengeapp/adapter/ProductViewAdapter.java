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
import com.example.mobilliumchallengeapp.model.Product;

import java.util.List;

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewAdapter.MyView> {

    private List<Product> list;
    private Context context;
    private int card;

    public class MyView
            extends RecyclerView.ViewHolder {

        TextView tvProductName;
        TextView tvProductPrice;
        ImageView ivProductImage;

        public MyView(View view) {
            super(view);

            tvProductName = view
                    .findViewById(R.id.tv_product_name);
            tvProductPrice = view
                    .findViewById(R.id.tv_product_price);
            ivProductImage = view.findViewById(R.id.iv_new_product);
        }
    }

    public ProductViewAdapter(List<Product> productList, Context context, int card_all) {
        this.list = productList;
        this.context = context;
        this.card=card_all;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType) {

        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(card,
                        parent,
                        false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder,
                                 final int position) {

        holder.tvProductName.setText(list.get(position).getTitle());
        holder.tvProductPrice.setText(String.valueOf(list.get(position).getPrice())+" TL");

            Glide.with(context)
                    .load(list.get(position).getImages().get(0).getUrl())
                    .into(holder.ivProductImage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
