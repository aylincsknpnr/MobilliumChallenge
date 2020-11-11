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
import com.google.gson.internal.LinkedTreeMap;

import java.util.LinkedHashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditorShopViewAdapter extends RecyclerView.Adapter<EditorShopViewAdapter.MyView> {

    private List<Shop_> list;
    private Context context;
    private int cards;

    public class MyView
            extends RecyclerView.ViewHolder {

        TextView tvShopName;
        TextView tvShopDefinition;
        ImageView ivShopImage1;
        ImageView ivShopImage2;
        ImageView ivShopImage3;
        CircleImageView logo;

        public MyView(View view) {
            super(view);

            tvShopName = view
                    .findViewById(R.id.tv_shop_name);
            tvShopDefinition = view
                    .findViewById(R.id.tv_shop_definition);
            ivShopImage1 = view.findViewById(R.id.iv_shop_image1);
            ivShopImage2 = view.findViewById(R.id.iv_shop_image2);
            ivShopImage3 = view.findViewById(R.id.iv_shop_image3);
            logo=view.findViewById(R.id.logo);
        }
    }

    public EditorShopViewAdapter(List<Shop_> shopList, Context context, int card4_all) {
        this.list = shopList;
        this.context = context;
        this.cards=card4_all;

    }
    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType) {

        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(cards,
                        parent,
                        false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder,
                                 final int position) {

        holder.tvShopName.setText(list.get(position).getName());
        holder.tvShopDefinition.setText(list.get(position).getDefinition());
        Glide.with(context)
                .load(list.get(position).getPopularProducts().get(0).getImages().get(0).getThumbnail().getUrl())
                .into(holder.ivShopImage1);
        Glide.with(context)
                .load(list.get(position).getPopularProducts().get(1).getImages().get(0).getThumbnail().getUrl())
                .into(holder.ivShopImage2);
        Glide.with(context)
                .load(list.get(position).getPopularProducts().get(2).getImages().get(0).getThumbnail().getUrl())
                .into(holder.ivShopImage3);

      try {

          Glide.with(context)
                  .load(((LinkedTreeMap) list.get(position).getLogo()).get("url"))
                  .into(holder.logo);
      }catch (Exception e){
          Glide.with(context)
                  .load(((LinkedHashMap) list.get(position).getLogo()).get("url"))
                  .into(holder.logo);
      }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
