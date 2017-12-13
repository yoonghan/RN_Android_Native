package com.sample_android_ui.sample;

import android.content.Context;
import android.widget.LinearLayout;

import com.sample_android_ui.R;

/**
 * Created by mmpkl05 on 12/14/17.
 */

public class CustomView  extends LinearLayout{

    private Context context;

    public CustomView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public void init() {
       inflate(this.context, R.layout.multiplecamerastreamlayout, this);
    }
}
