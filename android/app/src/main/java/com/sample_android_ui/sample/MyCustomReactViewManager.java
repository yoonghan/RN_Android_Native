package com.sample_android_ui.sample;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * Created by mmpkl05 on 12/14/17.
 */

public class MyCustomReactViewManager extends SimpleViewManager<CustomView> {

    public static final String REACT_CLASS = "MyCustomReactViewManager";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public CustomView createViewInstance(ThemedReactContext context) {
        return new CustomView(context); //If your customview has more constructor parameters pass it from here.
    }
}
