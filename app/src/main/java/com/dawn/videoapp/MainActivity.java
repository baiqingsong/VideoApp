package com.dawn.videoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dawn.videoapp.ui.activity.AnimationAdapterActivity;
import com.dawn.videoapp.ui.activity.CircleImageActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void jumpToAnimation(View view){
        Intent intent = new Intent(this, AnimationAdapterActivity.class);
        startActivity(intent);
    }
    protected void jumpToCircle(View view){
        Intent intent = new Intent(this, CircleImageActivity.class);
        startActivity(intent);
    }
}
