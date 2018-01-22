package com.example.android.bella;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mostafa on 1/22/18.
 */

public class notificationArrayAdapter extends ArrayAdapter<notificationData> {
    public notificationArrayAdapter(Activity context, ArrayList<notificationData> listnotification) {
        super(context, 0, listnotification);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_notification, parent, false);
        }
        notificationData notificationData = getItem(position);
        ImageView imageViewFace = listItemView.findViewById(R.id.faceOfNotification);
        TextView textViewMessage = listItemView.findViewById(R.id.detailsOfNotification);
        TextView textViewTime = listItemView.findViewById(R.id.TimerOfNotification);

        imageViewFace.setImageResource(notificationData.getmId());
        textViewMessage.setText(notificationData.getmMessage());
        textViewTime.setText(notificationData.getmTime());

        return listItemView;
    }
}
