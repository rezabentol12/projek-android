package com.fairureza.m.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {
    private ArrayList<lagu_nasional> listHero;
    private OnItemClickCallback onItemClickCallback;
    private Context context;




    public GridHeroAdapter(ArrayList<lagu_nasional> list,Context context) {
        this.listHero = list;
        this.context = context;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_hero, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GridViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext())
                .load(listHero.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        Toast.makeText(holder.itemView.getContext(), "kamu memilih" + listHero.get(holder.getAdapterPosition()).getName()
                                , Toast.LENGTH_SHORT).show();
                        onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition()));
                        Intent wardun = new Intent(context, Detail_Lagu_nasional.class);
                        wardun.putExtra(Detail_Lagu_nasional.EXTRA, position);
                    }

                });

            }

        });

    }

    public interface OnItemClickCallback {
        void onItemClicked(lagu_nasional data);
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }
    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }


}
