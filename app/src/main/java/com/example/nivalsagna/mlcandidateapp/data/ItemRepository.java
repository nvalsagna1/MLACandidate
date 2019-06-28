package com.example.nivalsagna.mlcandidateapp.data;

import android.arch.lifecycle.MutableLiveData;


import com.example.nivalsagna.mlcandidateapp.model.ItemCatalog;
import com.example.nivalsagna.mlcandidateapp.model.ItemDetail;
import com.example.nivalsagna.mlcandidateapp.service.ItemClient;
import com.example.nivalsagna.mlcandidateapp.service.ItemService;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemRepository {

    private ItemService itemService;
    private ItemClient itemClient;
    private MutableLiveData<ItemCatalog> items;
    private MutableLiveData<ItemDetail> itemDetails;
    private static ItemRepository instance = null;

    public static ItemRepository getInstance(){
        if (instance == null){
            instance = new ItemRepository();
        }
        return instance;
    }

    private ItemRepository(){
        itemClient = itemClient.getInstance();
        itemService = itemClient.getitemService();
    }

    /*public ItemRepository(String method, String datoBusqueda){
        if (method == "itemcatalog"){
            itemClient = itemClient.getInstance();
            itemService = itemClient.getitemService();
            items = getitemcatalog(datoBusqueda);
        }else if (method == "itemdetails"){
            itemClient = itemClient.getInstance();
            itemService = itemClient.getitemService();
            itemDetails = getitemdetails(datoBusqueda);
        }
    }*/

    public MutableLiveData<ItemDetail> getitemdetails(String datoBusqueda) {
        if (itemDetails == null) {
            itemDetails = new MutableLiveData<>();
        }

        // REVISAR PARAMETRO HARCODEADO
//        Call<ItemDetail> requestItemDetail = itemService.detailsItem("MLA793023477");
//        Call<ItemDetail> requestItemDetail = itemService.detailsItem(datoBusqueda);
//        requestItemDetail.enqueue(new Callback<ItemDetail>() {
//            @Override
//            public void onResponse(Call<ItemDetail> call, Response<ItemDetail> response) {
//                if (response.isSuccessful()) {
//                    itemDetails.setValue(response.body());
//                }
//                else{
//                    //Error http no 500
//                }
//            }
//            @Override
//            public void onFailure(Call<ItemDetail> call, Throwable t) {
//            }
//        });


        Observer<ItemDetail> observer = new Observer<ItemDetail>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ItemDetail itemDetail) {
                itemDetails.setValue(itemDetail);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        ItemClient.getInstance().itemDetails(datoBusqueda)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return itemDetails;
    }


    public MutableLiveData<ItemCatalog> getitemcatalog(String datoBusqueda) {
        if (items == null){
            items = new MutableLiveData<>();
        }

        // REVISAR PARAMETRO HARCODEADO
        //Call<ItemCatalog> requestitems = itemService.listItems("chromecast");
        /*Call<ItemCatalog> requestitems = itemService.listItems(datoBusqueda);
        requestitems.enqueue(new Callback<ItemCatalog>() {
            @Override
            public void onResponse(Call<ItemCatalog> call, Response<ItemCatalog> response) {
                if (response.isSuccessful()) {
                    items.setValue(response.body());
                }
                else{
                    //Error http no 500
                }
            }

            @Override
            public void onFailure(Call<ItemCatalog> call, Throwable t) {
            }
        });*/


        Observer<ItemCatalog> observer = new Observer<ItemCatalog>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ItemCatalog itemCatalog) {
                items.setValue(itemCatalog);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        ItemClient.getInstance().listItem(datoBusqueda)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        return items;
    }


}
