package com.example.nivalsagna.mlcandidateapp.ui;


import android.arch.lifecycle.Observer;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nivalsagna.mlcandidateapp.R;
import com.example.nivalsagna.mlcandidateapp.data.ItemDetailViewModel;
import com.example.nivalsagna.mlcandidateapp.model.ItemAttribute;
import com.example.nivalsagna.mlcandidateapp.model.ItemDetail;
import com.example.nivalsagna.mlcandidateapp.model.ItemPicture;

import org.w3c.dom.Text;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDetailFragment extends Fragment {
    private ItemDetail itemDetail;
    private ItemDetailViewModel itemDetailViewModel;

    private TextView tvTitle;
    private TextView tvPrice;
    private TextView tvCondition;
    private TextView tvSoldReference;
    private TextView tvSoldQuantity;
    private TextView tvMercadoPago;
    private TextView tvAttributeTile1;
    private TextView tvAttributeValue1;
    private TextView tvAttributeTile2;
    private TextView tvAttributeValue2;
    private TextView tvAttributeTile3;
    private TextView tvAttributeValue3;
    private TextView tvAttributeTile4;
    private TextView tvAttributeValue4;
    private TextView tvAttributeTile5;
    private TextView tvAttributeValue5;
    private TextView tvAttributeTile6;
    private TextView tvAttributeValue6;



    private List<ItemPicture> lstItemPictures;
    private List<ItemAttribute> lstItemAttributes;
    private ViewPager viewPager;

    public ItemDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);

        tvTitle = view.findViewById(R.id.tvItemDetailTitle);
        tvPrice = view.findViewById(R.id.tvItemDetailPrice);
        tvCondition = view.findViewById(R.id.tvItemDetailCondition);
        tvSoldQuantity = view.findViewById(R.id.tvItemDetailSold);
        tvMercadoPago = view.findViewById(R.id.tvItemDetailAcceptMercadopago);
        tvAttributeTile1 =view.findViewById(R.id.tvItemDetailFeatureName1);
        tvAttributeValue1 = view.findViewById(R.id.tvItemDetailFeatureValue1);
        tvAttributeTile2 =view.findViewById(R.id.tvItemDetailFeatureName2);
        tvAttributeValue2 = view.findViewById(R.id.tvItemDetailFeatureValue2);
        tvAttributeTile3 =view.findViewById(R.id.tvItemDetailFeatureName3);
        tvAttributeValue3 = view.findViewById(R.id.tvItemDetailFeatureValue3);
        tvAttributeTile4 =view.findViewById(R.id.tvItemDetailFeatureName4);
        tvAttributeValue4 = view.findViewById(R.id.tvItemDetailFeatureValue4);
        tvAttributeTile5 =view.findViewById(R.id.tvItemDetailFeatureName5);
        tvAttributeValue5 = view.findViewById(R.id.tvItemDetailFeatureValue5);
        tvAttributeTile6 =view.findViewById(R.id.tvItemDetailFeatureName6);
        tvAttributeValue6 = view.findViewById(R.id.tvItemDetailFeatureValue6);
        tvSoldReference = view.findViewById(R.id.tvItemDetailSoldDeference);
        viewPager = view.findViewById(R.id.view_pager);

        Bundle itemArgs = getArguments();
        String tmpPrice = String.format("%.0f", itemArgs.getDouble("priceitemclicked"));
        String tmpCurrency = itemArgs.getString("currencyitemclicked");


        if (tmpCurrency.equals(getResources().getString(R.string.text_dolar_api_value))){
            tmpCurrency = getResources().getString(R.string.text_currency_dolar) + " " + tmpPrice;
        } else {
            tmpCurrency = getResources().getString(R.string.text_currency_pesos) + " " + tmpPrice;
        }

        tvPrice.setText(tmpCurrency);
        tvTitle.setText(itemArgs.getString("titleitemclicked"));
        Log.i("setItemDetail","Seteo de datos del primarios del Item cliqueado");


        itemDetailViewModel = ViewModelProviders.of(getActivity())
                .get(ItemDetailViewModel.class);
        itemDetailViewModel.getItemDetails().observe( getViewLifecycleOwner(), new Observer<ItemDetail>() {
            @Override
            public void onChanged(@Nullable ItemDetail itemDetail) {
                setItemDetailsValues(itemDetail);
                Log.i("setItemDetail","Seteo de datos completos del ItemDetailViewModel");
            }
        });

        return view;
    }

    private void setItemDetailsValues(ItemDetail itemDetail) {

        tvTitle.setText(itemDetail.getTitle());
        String tmpPrice = String.format("%.0f", itemDetail.getPrice());
        String tmpCurrency = itemDetail.getCurrency_id();
        if (tmpCurrency.equals(getResources().getString(R.string.text_dolar_api_value))){
            tmpCurrency = getResources().getString(R.string.text_currency_dolar) + " " + tmpPrice;
        } else {
            tmpCurrency = getResources().getString(R.string.text_currency_pesos) + " " + tmpPrice;
        }
         tvPrice.setText(tmpCurrency);


        String tmpCondition = itemDetail.getCondition();
        if (tmpCondition.equals(getResources().getString(R.string.text_new_api_value))){
            tvCondition.setText(getResources().getString(R.string.text_condition_new));
        } else{
            tvCondition.setText(getResources().getString(R.string.text_condition_used));
        }

        tvSoldQuantity.setText(String.valueOf(itemDetail.getSold_quantity()));
        tvSoldReference.setText(R.string.text_sold);
        lstItemPictures = itemDetail.getPictures();
        lstItemAttributes = itemDetail.getAttributes();
        if (!itemDetail.getAccepts_mercadopago()){
            tvMercadoPago.setText(getResources().getString(R.string.text_negative));
        } else{
            tvMercadoPago.setText(getResources().getString(R.string.text_afirmative));
        }

        lstItemPictures = itemDetail.getPictures();
        ItemViewPagerAdapter adapter = new ItemViewPagerAdapter(getActivity(), lstItemPictures);
        viewPager.setAdapter(adapter);

        for(int i = 0; i < lstItemAttributes.size(); i++){
            switch(i){
                case 0:
                    tvAttributeTile1.setText(lstItemAttributes.get(i).getName());
                    tvAttributeValue1.setText(lstItemAttributes.get(i).getValue_name());
                    break;
                case 1:
                    tvAttributeTile2.setText(lstItemAttributes.get(i).getName());
                    tvAttributeValue2.setText(lstItemAttributes.get(i).getValue_name());
                    break;
                case 2:
                    tvAttributeTile3.setText(lstItemAttributes.get(i).getName());
                    tvAttributeValue3.setText(lstItemAttributes.get(i).getValue_name());
                    break;
                case 3:
                    tvAttributeTile4.setText(lstItemAttributes.get(i).getName());
                    tvAttributeValue4.setText(lstItemAttributes.get(i).getValue_name());
                    break;
                case 4:
                    tvAttributeTile5.setText(lstItemAttributes.get(i).getName());
                    tvAttributeValue5.setText(lstItemAttributes.get(i).getValue_name());
                    break;
                case 5:
                    tvAttributeTile6.setText(lstItemAttributes.get(i).getName());
                    tvAttributeValue6.setText(lstItemAttributes.get(i).getValue_name());
                    break;
                default:
                    break;
            }
            if (i == 5){
                break;
            }
        }
    }

}
