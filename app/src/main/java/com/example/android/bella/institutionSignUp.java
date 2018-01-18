package com.example.android.bella;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class institutionSignUp extends AppCompatActivity {
    protected Uri selectedImage,selectedImage1,selectedImage2;
    int i=0;
    protected static final String LOG_TAG=institutionSignUp.class.getName();
    String placeHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution_sign_up);
        final EditText editText = (EditText) findViewById(R.id.edit_text);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editText.setHint("");
                } else {
                    editText.setHint("");
                }
            }
        });
    }

    public void getImageFromGalary(View view) {
        i=0;
        Intent pickerPhotoIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickerPhotoIntent,1);
    }
    public void getImageFromGalary2(View view) {
        Intent pickerPhotoIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickerPhotoIntent,1);
    }
    public void getMyLocation(View view) {
        PlacePicker.IntentBuilder bulider=new PlacePicker.IntentBuilder();
        Intent intent;
        try {
            intent=bulider.build(getApplicationContext());
            startActivityForResult(intent,1);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }finally {

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if(requestCode == RESULT_OK) {
                    Log.i("MainActivity", "case 0");
                }
                break;
            case 1:
                if(resultCode == RESULT_OK) {
                    selectedImage = data.getData();
                    Log.i("MainActivity", "selected Image = "+selectedImage);
                    if(i==0) {
                        selectedImage1 = selectedImage;
                        Log.i(LOG_TAG,"the selected pic for 1 is :"+selectedImage1);
                        Log.e(LOG_TAG,"i = 0");
                        i++;
                        Log.e(LOG_TAG,"i = 1");
                    }else if(i==1){
                        selectedImage2 = selectedImage;
                        Log.i(LOG_TAG,"the selected pic for 2 is :"+selectedImage2);
                        Log.e(LOG_TAG,"i = 1");
                    }
                }
                break;

            case 2:
                if(resultCode==RESULT_OK){
                    Place place= PlacePicker.getPlace(data,this);
                    placeHolder=place.getAddress().toString();
            }
            break;
        }
    }



}
