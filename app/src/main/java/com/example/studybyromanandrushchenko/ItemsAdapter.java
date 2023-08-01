package com.example.studybyromanandrushchenko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studybyromanandrushchenko.databinding.ItemRecyclerBinding;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> implements View.OnClickListener {
    private ItemsService _itemsService;
    ItemRecyclerBinding binding;

    public ItemsAdapter(ItemsService itemsService) {
        this._itemsService = itemsService;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemRecyclerBinding.inflate(inflater, parent, false);
        binding.getRoot().setOnClickListener(this); //realize the click effect on the element of list
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item object = _itemsService.getItemsList().get(position);// receive an element from our list
        holder.getItemRecyclerBinding().textViewItem.setText(object.getName());
        holder.itemView.setTag(object); //use the tag for a popup message with name of item
        holder.getItemRecyclerBinding().imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              _itemsService.deleteItem(object);
              notifyItemRemoved(holder.getBindingAdapterPosition()); //update our arraylist after the deletion
            }
        });
    }

    @Override
    public void onClick(View v) {
        Item itemClicked = (Item) v.getTag(); //get our clicked object
        Toast.makeText(v.getContext(), "This is "+ itemClicked.getName(), Toast.LENGTH_SHORT).show();
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
