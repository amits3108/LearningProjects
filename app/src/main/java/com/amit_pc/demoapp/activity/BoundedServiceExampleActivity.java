package com.amit_pc.demoapp.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amit_pc.demoapp.R;
import com.amit_pc.demoapp.service.BoundService;


/**
 * Created by amit_pc on 24-09-2017.
 */

public class BoundedServiceExampleActivity extends AppCompatActivity {
    BoundService mBoundService;
    boolean mServiceBound = false;
    private final ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounded_service_example);
        final TextView timestampText = findViewById(R.id.timestamp_text);
        Button printTimestampButton = findViewById(R.id.print_timestamp);
        Button stopServiceButon = findViewById(R.id.stop_service);
        printTimestampButton.setOnClickListener(v -> {
            if (mServiceBound) {
                timestampText.setText(mBoundService.getTimestamp());
            }
        });

        new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };


        stopServiceButon.setOnClickListener(v -> {
            if (mServiceBound) {
                unbindService(mServiceConnection);
                mServiceBound = false;
            }
            Intent intent = new Intent(BoundedServiceExampleActivity.this,
                    BoundService.class);
            stopService(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }
}
