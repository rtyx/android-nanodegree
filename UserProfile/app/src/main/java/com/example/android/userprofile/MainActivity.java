package com.example.android.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public ImageView profilePicture = (ImageView) findViewById(R.id.profile_picture);

    public TextView name = (TextView) findViewById(R.id.name);
    public TextView birthday = (TextView) findViewById(R.id.birthday);
    public TextView country = (TextView) findViewById(R.id.country);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profilePicture.setImageResource(R.drawable.picture_rafael);
        name.setText(R.string.name);
        birthday.setText(R.string.birthday);
        country.setText(R.string.country);
    }
}
