package com.example.android.bella;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class institutionSignUp extends AppCompatActivity {
    protected Uri selectedImage;
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
        Intent pickerPhotoIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickerPhotoIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case 0:
                if(requestCode == RESULT_OK) {
                    Log.i("MainActivity", "case 0");
                }
                break;
            case 1:
                if(resultCode == RESULT_OK) {
                    selectedImage = imageReturnedIntent.getData();
                    Log.i("MainActivity", "selected Image = "+selectedImage);
                }
                break;
        }
    }
}
}
