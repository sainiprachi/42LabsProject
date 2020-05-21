package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<NavigationModel> navigationModels;

    NewItemAdapter(List<NavigationModel> navigationModels){
        this.navigationModels=navigationModels;
    }
    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_new, parent, false);
        return new ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        NavigationModel navigationModel=navigationModels.get(position);
        holder.ivImage.setImageResource(navigationModel.itemImg);
        holder.txtWallet.setText(navigationModel.itemName);

    }

    @Override
    public int getItemCount() {
        return navigationModels.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView txtWallet;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage=itemView.findViewById(R.id.ivImage);
            txtWallet=itemView.findViewById(R.id.txtWallet);

        }
    }
}

