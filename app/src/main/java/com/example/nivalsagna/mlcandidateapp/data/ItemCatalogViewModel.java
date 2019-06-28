package com.example.nivalsagna.mlcandidateapp.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.nivalsagna.mlcandidateapp.model.ItemCatalog;

public class ItemCatalogViewModel extends AndroidViewModel {
    private ItemRepository itemRepository;
    private LiveData<ItemCatalog> itemCatalogLiveData;


    public ItemCatalogViewModel(@NonNull Application application){
        super(application);
        //itemRepository = new ItemRepository("itemcatalog", datoBusqueda);
        itemRepository = ItemRepository.getInstance();
        //itemCatalogLiveData = itemRepository.getitemcatalog(datoBusqueda);
    }

    public LiveData<ItemCatalog> getItemCatalog(){
        return itemCatalogLiveData;
    }

    public void fetchItemCatalog(String datoBusqueda){
        itemCatalogLiveData = itemRepository.getitemcatalog(datoBusqueda);
    }


}
