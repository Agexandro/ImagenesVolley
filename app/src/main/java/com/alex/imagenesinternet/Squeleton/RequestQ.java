package com.alex.imagenesinternet.Squeleton;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class RequestQ extends Application {
    public static final String TAG = RequestQ.class.getSimpleName();
private RequestQueue requestQueue;
private ImageLoader imageLoader;
private static  RequestQ requestQ;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQ = this;
    }

    public  static synchronized RequestQ getInstance(){
        return requestQ;
    }

    public RequestQueue getRequestQueue() {
    if (requestQueue==null){
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    return requestQueue;
    }

    public ImageLoader getImageLoader(){
        getRequestQueue();
        if(imageLoader==null){
            imageLoader=new ImageLoader(this.requestQueue,new Fill());
        }
        return this.imageLoader;
    }


    public void cancelPendingRquest(Object tag){
        if(requestQueue!=null){
            requestQueue.cancelAll(tag);
        }
    }
}
