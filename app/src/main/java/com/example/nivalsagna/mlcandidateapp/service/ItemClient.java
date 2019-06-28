package com.example.nivalsagna.mlcandidateapp.service;

import com.example.nivalsagna.mlcandidateapp.common.Constants;
import com.example.nivalsagna.mlcandidateapp.model.ItemCatalog;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemClient {

    private static ItemClient instance = null;
    private ItemService itemService;
    private Retrofit retrofit;

    public ItemClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_ML_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        itemService = retrofit.create(ItemService.class);
    }

    //singleton pattern
    public static ItemClient getInstance(){
        if (instance == null){
            instance = new ItemClient();
        }
        return instance;
    }

    public ItemService getitemService(){
        return itemService;
    }

    public Observable<ItemCatalog> listItem(String datobusqueda)
    {return itemService.listItems(datobusqueda);
    }
}
