package com.example.nivalsagna.mlcandidateapp.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.nivalsagna.mlcandidateapp.model.ItemDetail;

public class ItemDetailViewModel extends AndroidViewModel {
    private ItemRepository itemRepository;
    private LiveData<ItemDetail> itemDetailLiveData;


    public ItemDetailViewModel(@NonNull Application application){
        super(application);
        //itemRepository = new ItemRepository("itemdetails",datoBusqueda);
        itemRepository = ItemRepository.getInstance();
        //itemDetailLiveData = itemRepository.getitemdetails(datoBusqueda);
    }

    public LiveData<ItemDetail> getItemDetails(String datoBusqueda){
        itemDetailLiveData = itemRepository.getitemdetails(datoBusqueda);
        return itemDetailLiveData;
    }
}
