package com.sample_android_ui.sample;

import android.util.Log;

import androidx.annotation.Nullable;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.HashMap;
import java.util.Map;

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
        Log.i("Create View Instance", "ANDROID_SAMPLE_UI");
        return new CustomView(context, this.message); //If your customview has more constructor parameters pass it from here.
    }

    @ReactProp(name = "message")
    public void setMessage(CustomView view, @Nullable String message) {
        Log.i("Set Message", "ANDROID_SAMPLE_UI");
        view.setMessage(message);
    }

    //PART 3: Added Receive Event.
    @javax.annotation.Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        //For frequent updates like on change or movement, read about getExportedCustomBubblingEventTypeConstants
        Log.i("Register Native Click", "ANDROID_SAMPLE_UI");
        return MapBuilder.<String, Object>builder()
                .put("nativeClick", //Same as name registered with receiveEvent
                        MapBuilder.of("registrationName", "onClick"))
                .build();
    }
}
