package com.example.android.bella;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mostafa on 1/22/18.
 */

public class profits extends ListFragment {
    private static final String LOG_TAG = profits.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profits, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            ListView list = getListView();
            final ArrayList<profitsdata> profits = new ArrayList<>();
            profits.add(new profitsdata("5ربال", "25 ريال", "5", "mostafa"));
            profits.add(new profitsdata("6ربال", "25 ريال", "5", "mostafa"));
            profits.add(new profitsdata("7ربال", "25 ريال", "5", "mostafa"));
            profits.add(new profitsdata("8ربال", "25 ريال", "5", "mostafa"));
            profits.add(new profitsdata("9ربال", "25 ريال", "5", "mostafa"));
            profits.add(new profitsdata("10ربال", "25 ريال", "5", "mostafa"));
            profitsArrayAdapter profitsArrayAdapter = new profitsArrayAdapter(getActivity(), profits);
            setListAdapter(profitsArrayAdapter);
            list.setAdapter(profitsArrayAdapter);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("الاربــاح");
    }
}
