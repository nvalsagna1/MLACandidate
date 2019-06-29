package com.example.nivalsagna.mlcandidateapp.data;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.example.nivalsagna.mlcandidateapp.model.ItemCatalog;
import com.example.nivalsagna.mlcandidateapp.model.ItemDetail;
import com.example.nivalsagna.mlcandidateapp.model.MyApp;
import com.example.nivalsagna.mlcandidateapp.service.ItemClient;
import com.example.nivalsagna.mlcandidateapp.service.ItemService;
import com.example.nivalsagna.mlcandidateapp.ui.MainActivity;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.URLConnection.setContentHandlerFactory;

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
                        //error inesperado
                        Toast.makeText(MyApp.getContext(), "Lo sentimos! Ha ocurrido un error inesperado", Toast.LENGTH_LONG).show();
                    }
                    else{
                        //error inesperado
                        Log.e("getItemDetailCall","Response = " + httpException.code() + " - " + httpException.message());
                        Toast.makeText(MyApp.getContext(), "Lo sentimos! atualmente no podemos procesar su petición", Toast.LENGTH_LONG).show();
                    }
                }
                else if (e instanceof  IOException){
                    //error de red
                    Log.e("getItemDetailCall","Error de red = " + e.getMessage());
                    Toast.makeText(MyApp.getContext(), "Ups! revise su conexión a internet y vuelva a intentarlo", Toast.LENGTH_LONG).show();

                }
                else{
                    //error inesperado
                    Log.e("getItemDetailCall","Error Inesperado = " + e.getMessage());
                    //error inesperado
                    Toast.makeText(MyApp.getContext(), "Lo sentimos! Ha ocurrido un error inesperado", Toast.LENGTH_LONG).show();
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
                        //error inesperado
                        Toast.makeText(MyApp.getContext(), "Lo sentimos! Ha ocurrido un error inesperado", Toast.LENGTH_LONG).show();
                    }
                    else{
                        //error inesperado
                        Log.e("getItemCatalogCall","Response = " + httpException.code() + " - " + httpException.message());
                        Toast.makeText(MyApp.getContext(), "Lo sentimos! atualmente no podemos procesar su petición", Toast.LENGTH_LONG).show();
                    }
                }
                else if (e instanceof  IOException){
                    //error de red
                    Log.e("getItemCatalogCall","Error de red = " + e.getMessage());
                    Toast.makeText(MyApp.getContext(), "Ups! revise su conexión a internet y vuelva a intentarlo", Toast.LENGTH_LONG).show();

                }
                else{
                    Log.e("getItemCatalogCall","Error Inesperado = " + e.getMessage());
                    //error inesperado
                    Toast.makeText(MyApp.getContext(), "Lo sentimos! Ha ocurrido un error inesperado", Toast.LENGTH_LONG).show();
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
