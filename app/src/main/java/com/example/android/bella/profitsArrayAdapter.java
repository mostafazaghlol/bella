package com.example.android.bella;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mostafa on 1/22/18.
 */

public class profitsArrayAdapter extends ArrayAdapter<profitsdata> {
    public profitsArrayAdapter(Activity context, ArrayList<profitsdata> listprofits) {
        super(context, 0, listprofits);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_profits, parent, false);
        }

        profitsdata profitObject = getItem(position);

        TextView TextViewFacilityName = listItemView.findViewById(R.id.FacilityName);
        TextView TextViewNumberOfTimes = listItemView.findViewById(R.id.NumberOfTimes);
        TextView TextViewPercentageOfAppOwner = listItemView.findViewById(R.id.PercentageOfAppOwner);
        TextView TextViewTotalProfit = listItemView.findViewById(R.id.TotalProfit);

        TextViewFacilityName.setText(profitObject.getmFacilityName());
        TextViewNumberOfTimes.setText(profitObject.getmNumberOfTimes());
        TextViewPercentageOfAppOwner.setText(profitObject.getmPercentageOfAppOwner());
        TextViewTotalProfit.setText(profitObject.getmTotalProfit());


        return listItemView;
    }
}
