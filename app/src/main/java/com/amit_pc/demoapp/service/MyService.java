package com.amit_pc.demoapp.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.amit_pc.demoapp.R;
import com.amit_pc.demoapp.utils.Utils;

/**
 * Created by amit_pc on 23-09-2017.
 */

public class MyService extends Service {
    //NOTE: LifeCycle of Started Services
    // startService() -> onCreate -> onStartCommand -> onDestroy

    //NOTE: LifeCycle of Bounded Services
    // bindService()  -> onCreate -> onBind -> onUnbind() -> onDestroy

    private static String TAG = "MY_SERVICE_CLASS";

    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: Actions to perform when service is created.
        Utils.printLog("e",TAG,"Service is created");
        Utils.showToast(this,"Service is created", Toast.LENGTH_SHORT);
        mediaPlayer = MediaPlayer.create(MyService.this, R.raw.addiction_song);
        mediaPlayer.setLooping(false);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Utils.printLog("e",TAG,"Service onBind");
        Utils.showToast(this,"Service is onBind", Toast.LENGTH_SHORT);
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Utils.printLog("e",TAG,"Service onStartCommand");
        Utils.showToast(this,"Service is onStartCommand", Toast.LENGTH_SHORT);
        mediaPlayer.start();
        return Service.START_REDELIVER_INTENT;
//        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Utils.printLog("e",TAG,"Service onDestroy");
        Utils.showToast(this,"Service is onDestroy", Toast.LENGTH_SHORT);
        mediaPlayer.stop();
    }
}
