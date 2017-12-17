package com.amit_pc.demoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.amit_pc.demoapp.R;
import com.amit_pc.demoapp.service.MyService;

/**
 * Created by amit_pc on 23-09-2017.
 */

public class PlayMusicActivity extends BaseActivity implements View.OnClickListener {

    private Button btnStartService;
    private Button btnNextPage;
    private Button btnStopService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
    }

    @Override
    public void getId(){
        btnStartService = (Button) findViewById(R.id.btn_start_service);
        btnStopService = (Button) findViewById(R.id.btn_stop_service);
        btnNextPage = (Button) findViewById(R.id.btn_next_page);
    }

    @Override
    public void setData() {

    }

    public void setListener(){
        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnNextPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start_service:
                startService(new Intent(PlayMusicActivity.this,MyService.class));
                break;
            case R.id.btn_stop_service:
                stopService(new Intent(PlayMusicActivity.this,MyService.class));
                break;
            case R.id.btn_next_page:
                startActivity(new Intent(PlayMusicActivity.this,MainActivity.class));
                break;
        }
    }
}
