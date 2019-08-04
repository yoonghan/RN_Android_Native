package com.sample_android_ui.sample;

import android.util.Log;

import androidx.annotation.Nullable;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by mmpkl05 on 12/14/17.
 */

public class MyCustomReactViewManager extends SimpleViewManager<CustomView> {

    public static final String REACT_CLASS = "MyCustomReactViewManager";
    private String message = "NOT SET";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public CustomView createViewInstance(ThemedReactContext context) {
        return new CustomView(context, this.message); //If your customview has more constructor parameters pass it from here.
    }

    @ReactProp(name = "message")
    public void setMessage(CustomView view, @Nullable String message) {
        Log.i("Button get clicked", "ANDROID_SAMPLE_UI");
        this.message=message;
    }
}
