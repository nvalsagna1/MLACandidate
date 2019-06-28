package com.example.nivalsagna.mlcandidateapp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nivalsagna.mlcandidateapp.R;
import com.example.nivalsagna.mlcandidateapp.data.ItemCatalogViewModel;
import com.example.nivalsagna.mlcandidateapp.data.ItemDetailViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new ItemSearchFragment())
                    //.addToBackStack("itemsearchfragment")
                    .commit();
        }
    }
}
