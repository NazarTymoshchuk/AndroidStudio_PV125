package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText txtValue;
    private ImageView imgAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtValue = findViewById(R.id.txtValue);
        imgAvatar=findViewById(R.id.imgAvatar);
        String url = "https://kovbasa.itstep.click/images/mala.jpeg";
        Glide
                .with(this)
                .load(url)
                .apply(new RequestOptions().override(600))
                .into(imgAvatar);

    }

    public void onClickMeHandler(View view) {
        String text = txtValue.getText().toString();
        Log.d("my_text", "----Ви нажали кнопку----"+ text);
    }
}