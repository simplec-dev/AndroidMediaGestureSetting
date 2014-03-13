package com.simplec.phonegap.plugins.videosettings;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaPlugin;

public class AndroidMediaGestureSetting extends CordovaPlugin {

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }
}
