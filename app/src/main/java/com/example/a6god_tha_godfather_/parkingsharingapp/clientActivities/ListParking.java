package com.example.a6god_tha_godfather_.parkingsharingapp.clientActivities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a6god_tha_godfather_.parkingsharingapp.R;

import java.util.ArrayList;
import java.util.List;

// THIS IS THE CLIENT
public class ListParking extends ListFragment {

    ListView myListView ;
    List parkingList = new ArrayList() ;

    ArrayAdapter adapter ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_parking, container, false);
        // myListView = (ListView)rootView.findViewById(R.id.list);

        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.list_parking, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("List Parking");
        adapter = (ArrayAdapter) ArrayAdapter.createFromResource(getActivity(), R.array.Planets, android.R.layout.simple_list_item_1 );
        setListAdapter(adapter);



    }
}

