package com.example.android.bella;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mostafa on 1/22/18.
 */

public class notification extends ListFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notifactions, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("الاشعــارات");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView list = getListView();
        ArrayList<notificationData> list1 = new ArrayList<>();
        list1.add(new notificationData("HI", "55", R.drawable.smile));
        list1.add(new notificationData("HI2", "45", R.drawable.smile));
        list1.add(new notificationData("HI3", "35", R.drawable.smile));
        notificationArrayAdapter notificationArrayAdapter = new notificationArrayAdapter(getActivity(), list1);
        setListAdapter(notificationArrayAdapter);
    }
}
