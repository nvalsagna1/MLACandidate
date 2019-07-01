package com.example.nivalsagna.mlcandidateapp.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nivalsagna.mlcandidateapp.R;
import com.example.nivalsagna.mlcandidateapp.data.ItemCatalogViewModel;
import com.example.nivalsagna.mlcandidateapp.data.ItemDetailViewModel;
import com.example.nivalsagna.mlcandidateapp.model.Item;
import com.example.nivalsagna.mlcandidateapp.model.ItemCatalog;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private RecyclerView itemrecyclerView;
    private List<Item> itemList;
    private ItemCatalogViewModel itemCatalogViewModel;
    private ItemDetailViewModel itemDetailViewModel;
    private ItemRecyclerViewAdapter adapter;
    private String idItemClicked = "";
    private String titletemClicked = "";
    private Double priceItemClicked;
    private String currencyItemClicked;


    public ItemListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemListFragment newInstance(int columnCount) {
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

            itemrecyclerView = view.findViewById(R.id.rvitems);
            itemrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            adapter = new ItemRecyclerViewAdapter(
                    itemList,
                    getActivity()
            );
            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idItemClicked = itemList.get(itemrecyclerView.getChildAdapterPosition(v)).getId();
                    priceItemClicked = itemList.get(itemrecyclerView.getChildAdapterPosition(v)).getPrice();
                    titletemClicked = itemList.get(itemrecyclerView.getChildAdapterPosition(v)).getTitle();
                    currencyItemClicked = itemList.get(itemrecyclerView.getChildAdapterPosition(v)).getCurrency_id();

                    Bundle itemArgs = new Bundle();
                    itemArgs.putString("titleitemclicked",titletemClicked);;
                    itemArgs.putDouble("priceitemclicked",priceItemClicked);
                    itemArgs.putString("currencyitemclicked",currencyItemClicked);


                    itemDetailViewModel = ViewModelProviders.of(
                            getActivity()).get(ItemDetailViewModel.class);
                    itemDetailViewModel.getNewItemDetails(idItemClicked);

                    Log.i("getItemDetailCall","Búsqueda de detalles de un producto, ID = " + idItemClicked);

                    Fragment itemDetailFragment = new ItemDetailFragment();
                    itemDetailFragment.setArguments(itemArgs);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, itemDetailFragment)
                            .addToBackStack("itemdetailfragment")
                            .commit();
                }
            });

            itemrecyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            itemCatalogViewModel = ViewModelProviders.of(
                    getActivity()).get(ItemCatalogViewModel.class);
            itemCatalogViewModel.getItemCatalog().observe( getViewLifecycleOwner(), new Observer<ItemCatalog>() {
                @Override
                public void onChanged(@Nullable ItemCatalog itemCatalog) {
                    itemList = itemCatalog.getResults();
                    adapter.setData(itemList);
                    Log.i("getItemCatalog","Seteo de datos del ItemCatalogViewModel");
                }
            });
    }

}
