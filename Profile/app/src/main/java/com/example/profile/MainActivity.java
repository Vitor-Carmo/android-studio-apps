package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.profile_image);
    }

    public void openCamera(View view) {
        startActivityForResult(
                new Intent(MediaStore.ACTION_IMAGE_CAPTURE),
                100
        );
    }

    public void openGalery(View view) {
        startActivityForResult(
                new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI),
                200
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap image = null;

        try{
            switch (requestCode) {
                case 100:
                    image = (Bitmap) data.getExtras().get("data");
                    break;
                case 200:
                    // local image -- data.getData()
                    image = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if(image != null){profile.setImageBitmap(image);}
    }
}