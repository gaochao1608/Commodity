package com.qf.administrator.commodity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.qf.administrator.commodity.activity.MainActivity;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 16/11/04.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("tmd", "onReceive: 收到");
        if(intent.getAction().equals(JPushInterface.ACTION_NOTIFICATION_RECEIVED)){
            String title = intent.getStringExtra(JPushInterface.EXTRA_NOTIFICATION_TITLE);
            String alert = intent.getStringExtra(JPushInterface.EXTRA_ALERT);
            String extra = intent.getStringExtra(JPushInterface.EXTRA_EXTRA);
            Log.i("tmd", "onReceive: "+title+alert+extra);

        }else if(intent.getAction().equals(JPushInterface.ACTION_MESSAGE_RECEIVED)){
            String mess = intent.getStringExtra(JPushInterface.EXTRA_MESSAGE);
            Log.i("tmd", "onReceive: "+mess);
        }else if(intent.getAction().equals(JPushInterface.ACTION_NOTIFICATION_OPENED)){
            Intent inten = new Intent(context,MainActivity.class);
            inten.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
