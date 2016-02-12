package com.simplec.phonegap.plugins.videosettings;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class AndroidMediaGestureSetting extends CordovaPlugin {

    private static final String LOG_TAG = "AndroidMediaGestureSetting";


    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			try {
				WebView view = getWebViewFromPlugin();
	        	view.getSettings().setMediaPlaybackRequiresUserGesture(false);
		        Log.d(LOG_TAG, "setMediaPlaybackRequiresUserGesture: FALSE");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		        Log.d(LOG_TAG, "setMediaPlaybackRequiresUserGesture: ERROR");
				Log.e(LOG_TAG, "error getting settings or view: "+e.getMessage());
			}        	
        } else {
	        Log.d(LOG_TAG, "setMediaPlaybackRequiresUserGesture: COULD NOT RUN");
        }
        
    }
    
    public WebView getWebViewFromPlugin() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	WebView thisView = null;
		boolean CORDOVA_4 = Integer.valueOf(CordovaWebView.CORDOVA_VERSION.split("\\.")[0]) >= 4;
		Log.e(LOG_TAG, "CORDOVA_4: "+CORDOVA_4);
		if (CORDOVA_4) {
			if (webView.getClass().isAssignableFrom(WebView.class)) {
				Log.e(LOG_TAG, "it is assignable");
				thisView = ((WebView) webView);
			} else {
				Log.e(LOG_TAG, "using reflection to get method getView");
				Method m = webView.getClass().getDeclaredMethod("getView");

				Log.e(LOG_TAG, "got method: "+m);
				thisView = (WebView) m.invoke(webView);//  webView.getView());
				Log.e(LOG_TAG, "invoked method");
			}
		} else {
			thisView = ((WebView) webView);
		}
		
		return thisView;
    }
}
