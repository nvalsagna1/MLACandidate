package com.example.nivalsagna.mlcandidateapp.ui;


import android.app.SearchManager;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.nivalsagna.mlcandidateapp.R;
import com.example.nivalsagna.mlcandidateapp.data.ItemCatalogViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemSearchFragment extends Fragment {
    private ImageView btBuscar;
    private EditText etBuscar;
    private String datoBusqueda;
    private SearchView searchView;
    private ItemCatalogViewModel itemCatalogViewModel;

    public ItemSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_search, container, false);

        btBuscar = view.findViewById(R.id.btBuscar);
        etBuscar = view.findViewById(R.id.etBuscar);

        btBuscar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                datoBusqueda = etBuscar.getText().toString();

                if (datoBusqueda.equals("")){
                    Toast.makeText(getActivity(), R.string.text_find_null_value, Toast.LENGTH_SHORT).show();
                }else{
                    Fragment itemListFragment = new ItemListFragment();

                    itemCatalogViewModel = ViewModelProviders.of(
                            getActivity()).get(ItemCatalogViewModel.class);
                    itemCatalogViewModel.getNewItemCatalog(datoBusqueda);
                    Log.i("getItemCatalogCall","Búsqueda de productos publicados, parámetro = " + datoBusqueda);

                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, itemListFragment)
                            .addToBackStack("itemlistfragment")
                            .commit();
                }
            }

        });
    return  view;
    }
}



