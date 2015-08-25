package com.simplec.phonegap.plugins.videosettings;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;

public class AndroidMediaGestureSetting extends CordovaPlugin {

    private static final String LOG_TAG = "AndroidMediaGestureSetting";


    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    	try {
	        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
	        	WebView.enableSlowWholeDocumentDraw();
		        Log.d(LOG_TAG, "enableSlowWholeDocumentDraw()");
	        }
    	} catch (Exception e) {
    		
    	}

    	try {
    		cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    		cordova.getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    		WindowManager.LayoutParams.FLAG_FULLSCREEN);
    		ViewGroup view = (ViewGroup)cordova.getActivity().getWindow().getDecorView();
    		view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
	        Log.d(LOG_TAG, "tried hiding bar");
    	} catch (Exception e) {
	        Log.d(LOG_TAG, "hiding bar failed: "+e.getMessage());
    	}
		
        super.initialize(cordova, webView);
        
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
	        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
	
	        Log.d(LOG_TAG, "setMediaPlaybackRequiresUserGesture: FALSE");
        }
    }
}
