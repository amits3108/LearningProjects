package com.amit_pc.demoapp.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by amit_pc on 23-09-2017.
 */

public class Utils {
    public static boolean isDebugAble = true;

    public static void printLog(String type, String TAG, String msg) {
        if (!isDebugAble) {
            return;
        }

        switch (type) {
            case "i":
                Log.i(TAG, msg);
                break;
            case "e":
                Log.e(TAG, msg);
                break;
            case "d":
                Log.d(TAG, msg);
                break;
            case "v":
                Log.v(TAG, msg);
                break;
            case "w":
                Log.w(TAG, msg);
                break;
            default:
                Log.i(TAG, msg);
                break;
        }
    }

    public static void showToast(Context context,String msg,int duration){
        Toast.makeText(context,msg,duration).show();
    }
}
