package com.sample_android_ui.sample;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;
import com.sample_android_ui.R;

/**
 * Created by mmpkl05 on 12/14/17.
 */

public class CustomView  extends LinearLayout{

    private Context context;
    private String message = "NOT SET";

    public CustomView(Context context, String message) {
        super(context);
        this.context = context;
        this.message = message;
        init();
    }

    public void init() {
        inflate(this.context, R.layout.multiplecamerastreamlayout, this);
        //This can be viewed in Android Studio's Log Cat.
        Log.i("Inflated XML", "ANDROID_SAMPLE_UI");

        //BONUS: Create a button that writes a toast.
        Button clickButton = (Button) findViewById(R.id.multipleCameraButton);
        final Context _context = context;
        clickButton.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
                //Log into the Logcat of android studio. Filter by Info and ANDROID_SAMPLE_UI.
                Log.i("Button get clicked", "ANDROID_SAMPLE_UI");
                Toast toast = Toast.makeText(_context, message, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}
