package com.simplec.phonegap.plugins.videosettings;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import android.os.Build;
import android.util.Log;

public class AndroidMediaGestureSetting extends CordovaPlugin {

    private static final String LOG_TAG = "AndroidMediaGestureSetting";


    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
	        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
	
	        Log.d(LOG_TAG, "setMediaPlaybackRequiresUserGesture: FALSE");
        } else {
	        Log.d(LOG_TAG, "setMediaPlaybackRequiresUserGesture: COULD NOT RUN");
        }
    }
}
