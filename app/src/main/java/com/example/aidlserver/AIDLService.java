package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

public class AIDLService extends Service {
    private static String TAG = "AIDLService";
    public AIDLService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }

    private IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {
        @Override
        public int getColor() throws RemoteException {
            Random rnd = new Random();
            int color = Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
            //Toast.makeText(getApplicationContext(),"AIDL Server Called",Toast.LENGTH_LONG).show();
            Log.d(TAG,"getColor"+color);
            return color;

        }
    };
}