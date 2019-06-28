package com.example.nivalsagna.mlcandidateapp.service;

import com.example.nivalsagna.mlcandidateapp.model.ItemCatalog;
import com.example.nivalsagna.mlcandidateapp.model.ItemDetail;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ItemService {

    @GET("sites/MLA/search")
    Observable<ItemCatalog> listItems(@Query("q") String parametro);

    @GET("items/{iditem}")
    Observable<ItemDetail> detailsItem(@Path("iditem") String iditem);
}
