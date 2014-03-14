package com.simplec.phonegap.plugins.videosettings;

import org.apache.cordova.CordovaInterface;
import android.util.Log;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaPlugin;

public class AndroidMediaGestureSetting extends CordovaPlugin {

    private static final String LOG_TAG = "AndroidMediaGestureSetting";


    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);

        Log.d(LOG_TAG, "setMediaPlaybackRequiresUserGesture: FALSE");

    }
}
