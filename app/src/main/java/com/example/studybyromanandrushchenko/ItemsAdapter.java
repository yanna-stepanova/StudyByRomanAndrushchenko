package com.example.studybyromanandrushchenko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studybyromanandrushchenko.databinding.ItemRecyclerBinding;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    private ItemsService _itemsService;
    ItemRecyclerBinding binding;

    public ItemsAdapter(ItemsService itemsService) {
        this._itemsService = itemsService;
    }

   /* public void setItemsList(List<Item> itemsList) {

        notifyDataSetChanged(); //it works if it's used the method add/remove/edit
    }*/

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemRecyclerBinding.inflate(inflater, parent, false);
        return new ItemViewHolder(binding);
    }



    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item object = _itemsService.getItemsList().get(position);// receive an element from our list
        holder.getItemRecyclerBinding().textViewItem.setText(object.getName());
        holder.getItemRecyclerBinding().imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              _itemsService.deleteItem(object);
              notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return _itemsService.getItemsList().size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private ItemRecyclerBinding _binding;

        public ItemRecyclerBinding getItemRecyclerBinding() {
            return _binding;
        }

        public ItemViewHolder(ItemRecyclerBinding binding) {
            super(binding.getRoot());
            this._binding = binding;
        }
    }
}
