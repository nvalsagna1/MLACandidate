package com.example.nivalsagna.mlcandidateapp.data;


import android.arch.lifecycle.MutableLiveData;
import android.util.Log;


import com.example.nivalsagna.mlcandidateapp.model.ItemCatalog;
import com.example.nivalsagna.mlcandidateapp.model.ItemDetail;
import com.example.nivalsagna.mlcandidateapp.service.ItemClient;
import com.example.nivalsagna.mlcandidateapp.service.ItemService;

import java.io.IOException;

import io.reactivex.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;


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


    public MutableLiveData<ItemDetail> getitemdetails(String datoBusqueda) {
        if (itemDetails == null) {
            itemDetails = new MutableLiveData<>();
        }


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
                if (e instanceof HttpException){
                    final HttpException httpException = (HttpException) e;
                    if (httpException.code() >= HTTP_BAD_REQUEST && httpException.code() < HTTP_INTERNAL_ERROR){
                        //bad request
                        Log.e("getItemDetailCall","Response = " + httpException.code() + " - " + httpException.message());

                    }
                    else{
                        //error inesperado
                        Log.e("getItemDetailCall","Response = " + httpException.code() + " - " + httpException.message());

                    }
                }
                else if (e instanceof  IOException){
                    //error de red
                    Log.e("getItemDetailCall","Error de red = " + e.getMessage());


                }
                else{
                    //error inesperado
                    Log.e("getItemDetailCall","Error Inesperado = " + e.getMessage());

                }

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

        final Observer<ItemCatalog> observer = new Observer<ItemCatalog>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ItemCatalog itemCatalog) {
                items.setValue(itemCatalog);
            }

            @Override
            public void onError(Throwable e) {
                if (e instanceof HttpException){
                    final HttpException httpException = (HttpException) e;
                    if (httpException.code() >= HTTP_BAD_REQUEST && httpException.code() < HTTP_INTERNAL_ERROR){
                        //bad request
                        Log.e("getItemCatalogCall","Response = " + httpException.code() + " - " + httpException.message());
                    }
                    else{
                        //error inesperado
                        Log.e("getItemCatalogCall","Response = " + httpException.code() + " - " + httpException.message());
                    }
                }
                else if (e instanceof  IOException){
                    //error de red
                    Log.e("getItemCatalogCall","Error de red = " + e.getMessage());

                }
                else{
                    //error inesperado
                    Log.e("getItemCatalogCall","Error Inesperado = " + e.getMessage());
                }
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
