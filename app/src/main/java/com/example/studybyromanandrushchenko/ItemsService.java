package com.example.studybyromanandrushchenko;

import java.util.ArrayList;

public class ItemsService {
    private ArrayList<Item> _itemsList = new ArrayList<>();

    public ArrayList<Item> getItemsList() {
        return _itemsList;
    }

    public void deleteItem (Item someItem){
        _itemsList.removeIf(i -> i.getName().equals(someItem.getName()));
    }

    public ItemsService() {
        for (int i=1; i<25; i++){
            this._itemsList.add(new Item("Element_"+i));
        }
    }
}
