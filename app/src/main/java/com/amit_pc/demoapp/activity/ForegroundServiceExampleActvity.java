package com.amit_pc.demoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amit_pc.demoapp.R;
import com.amit_pc.demoapp.service.ForegroundService;
import com.amit_pc.demoapp.utils.Constants;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by amit_pc on 24-09-2017.
 */

public class ForegroundServiceExampleActvity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground);
        Button startButton = findViewById(R.id.button1);
        Button stopButton = findViewById(R.id.button2);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent startIntent = new Intent(this, ForegroundService.class);
                startIntent.setAction(Constants.ACTION.START_FOREGROUND_ACTION);
                startService(startIntent);
                break;
            case R.id.button2:
                Intent stopIntent = new Intent(this, ForegroundService.class);
                stopIntent.setAction(Constants.ACTION.STOP_FOREGROUND_ACTION);
                startService(stopIntent);
                break;
            default:
                break;
        }
    }
}
