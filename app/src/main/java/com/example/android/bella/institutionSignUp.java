package com.example.android.bella;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.shashank.sony.fancytoastlib.FancyToast;

public class institutionSignUp extends AppCompatActivity {
    protected static final String LOG_TAG = institutionSignUp.class.getName();
    protected Uri selectedImage,selectedImage1,selectedImage2;
    int i=0;
    String placeHolder;
    private String usage = "", nameOfOwner = "", Commeriacalregistraiton = "", NumOfCommeriacalRoom = "", DescriptionOfOrigin = "", Services = "", Email = "", City = "";
    private EditText UseageEditText, NameOfOwnerEditText, CommeriacalregistraitonEditText, NumOfCommeriacalRoomEditText, DescriptionOfOriginEditText, ServicesEditText, EmailEditText, CityEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution_sign_up);
        final EditText editText = findViewById(R.id.usage_Edit_text);

        //استخدمها
        UseageEditText = findViewById(R.id.usage_Edit_text);
        //اسم صاحب المنشأه
        NameOfOwnerEditText = findViewById(R.id.nameOfOwner_Edit_text);
        //رقم السجل التجارى
        CommeriacalregistraitonEditText = findViewById(R.id.Commeriacalregistraiton_Edit_text);
        //رقم الغرفه التجاريه
        NumOfCommeriacalRoomEditText = findViewById(R.id.NumOfCommeriacalRoom_Edit_text);
        //وصف المنشأه
        DescriptionOfOriginEditText = findViewById(R.id.Description_of_origin_Edit_text);
        //الخدمات التى تقدمها المنِشأه
        ServicesEditText = findViewById(R.id.Services_Edit_text);
        //البريد الالكترونى للمنشأه
        EmailEditText = findViewById(R.id.Email_Edit_text);
        //المدينه
        CityEditText = findViewById(R.id.city_Edit_text);

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

    //to handel image for the insitiuation "المنشأه السجل التجارى"
    public void getImageFromGalary(View view) {
        i=0;
        Intent pickerPhotoIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickerPhotoIntent,1);
    }

    //to handel image for the instituation "صوره شهادة الغرفه التجاريه"
    public void getImageFromGalary2(View view) {
        Intent pickerPhotoIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickerPhotoIntent,1);
    }

    //to handel location for the instituation .
    public void getMyLocation(View view) {
        PlacePicker.IntentBuilder bulider=new PlacePicker.IntentBuilder();
        Intent intent;
        try {
            intent=bulider.build(getApplicationContext());
            startActivityForResult(intent, 2);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }finally {

        }
    }

    //to handel intent activity on the result.
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
                        FancyToast.makeText(this, "Image Taken", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        i++;
                        Log.e(LOG_TAG,"i = 1");
                    }else if(i==1){
                        selectedImage2 = selectedImage;
                        Log.i(LOG_TAG,"the selected pic for 2 is :"+selectedImage2);
                        Log.e(LOG_TAG,"i = 1");
                        FancyToast.makeText(this, "Image Taken", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        i++;
                    }
                }
                break;

            case 2:
                if(resultCode==RESULT_OK){
                    Place place= PlacePicker.getPlace(data,this);
                    placeHolder=place.getAddress().toString();
                    if (i == 2) {
                        FancyToast.makeText(this, "Place Taken", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        i++;
                    }
                }
                break;
        }
    }


    public void takeData(View view) {
        usage = UseageEditText.getText().toString();
        nameOfOwner = NameOfOwnerEditText.getText().toString();
        Commeriacalregistraiton = CommeriacalregistraitonEditText.getText().toString();
        NumOfCommeriacalRoom = NumOfCommeriacalRoomEditText.getText().toString();
        DescriptionOfOrigin = DescriptionOfOriginEditText.getText().toString();
        Services = ServicesEditText.getText().toString();
        Email = EmailEditText.getText().toString();
        City = CityEditText.getText().toString();

        Toast.makeText(this, "" + usage, Toast.LENGTH_SHORT).show();

    }
}

