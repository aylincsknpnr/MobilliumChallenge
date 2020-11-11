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
import com.example.mobilliumchallengeapp.model.Shop_;

import java.util.List;


public class NewShopViewAdapter extends RecyclerView.Adapter<NewShopViewAdapter.MyView> {

    private List<Shop_> list;
    private Context context;
    private int card;

    public class MyView
            extends RecyclerView.ViewHolder {

        TextView tvShopName;
        TextView tvShopDefinition;
        TextView tvcount;
        TextView logo;
        ImageView ivSHopImage;

        public MyView(View view) {
            super(view);

            tvShopName = view
                    .findViewById(R.id.tv_products_name);
            tvShopDefinition = view
                    .findViewById(R.id.tv_products_def);
            tvcount = view.findViewById(R.id.tv_product_count);
            logo = view.findViewById(R.id.tv_logo);
            ivSHopImage = view.findViewById(R.id.iv_new_product);
        }
    }

    public NewShopViewAdapter(List<Shop_> shopList, Context context, int card_all) {
        this.list = shopList;
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
        holder.tvShopName.setText(list.get(position).getName());
        holder.tvShopDefinition.setText(list.get(position).getDefinition());
        holder.tvcount.setText(Integer.toString(list.get(position).getProductCount())+" ÜRÜN");
        holder.logo.setText(list.get(position).getName().substring(0, 1));
        if (list.get(position).getCover() != null) {
            Glide.with(context)
                    .load(list.get(position).getCover().getUrl())
                    .into(holder.ivSHopImage
                    );
        } else {
            holder.ivSHopImage.setImageResource(R.drawable.noimages);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
