package com.amit_pc.demoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amit_pc.demoapp.R;
import com.amit_pc.demoapp.utils.Utils;

import androidx.annotation.Nullable;

/**
 * Created by amit_pc on 26-09-2017.
 */

public class LaunchModesExampleActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = LaunchModesExampleActivity.class.getName();
    private Button btnLaunchStandard;
    private Button btnLaunchSingleTop;
    private Button btnLaunchSingleTask;
    private Button btnLaunchSingleInstance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_mode_example);
        Utils.printLog("e", TAG, "Activity Launched");
    }

    @Override
    public void getId() {
        btnLaunchStandard = findViewById(R.id.btn_launch_standard);
        btnLaunchSingleTop = findViewById(R.id.btn_launch_single_top);
        btnLaunchSingleTask = findViewById(R.id.btn_launch_single_task);
        btnLaunchSingleInstance = findViewById(R.id.btn_launch_single_instance);
    }

    @Override
    public void setData() {

    }

    @Override
    public void setListener() {
        btnLaunchStandard.setOnClickListener(this);
        btnLaunchSingleTop.setOnClickListener(this);
        btnLaunchSingleTask.setOnClickListener(this);
        btnLaunchSingleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_launch_standard:
                Intent intent1 = new Intent(this, LaunchModesExampleActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_launch_single_top:
                //NOTE: for testing make LaunchModesExampleActivity to be the singleTop in manifest.
                Intent intent2 = new Intent(this, LaunchModesExampleActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent2);
                break;
            case R.id.btn_launch_single_task:
                //NOTE: for testing make LaunchModesExampleActivity to be the singleTask in manifest.
                Intent intent3 = new Intent(this, LaunchModesExampleActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent3);
                break;
            case R.id.btn_launch_single_instance:
                //NOTE: for testing make LaunchModesExampleActivity to be the singleInstance in manifest.
                Intent intent4 = new Intent(this, LaunchModesExampleActivity.class);
//                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Utils.printLog("e", TAG, "on New Intent " + intent.getFlags());
    }
}
