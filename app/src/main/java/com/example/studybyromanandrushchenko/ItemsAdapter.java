package com.example.studybyromanandrushchenko;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studybyromanandrushchenko.databinding.ItemRecyclerBinding;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    private List<Item> _itemsList = null;
    ItemRecyclerBinding binding;

    public void setItemsList(List<Item> itemsList) {
        this._itemsList = itemsList;
        notifyDataSetChanged(); //it works if it's used the method add/remove/edit
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemRecyclerBinding.inflate(inflater, parent, false);
        return new ItemViewHolder(binding);
    }

    public List<Item> getItemsList() {
        return _itemsList;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item object = getItemsList().get(position); // receive an element from our list
        holder.getItemRecyclerBinding().textViewItem.setText(object.getName());
        
    }

    @Override
    public int getItemCount() {
        return _itemsList.size();
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
