package net.kianoni.fontloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

/**
 * Created by kilp on 24/02/16.
 */
public class EditText extends android.widget.EditText{

    public EditText(Context context) {
        super(context);
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(FontLoader.readTypeFace(context, attrs));
    }

    public EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTypeface(FontLoader.readTypeFace(context, attrs));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.setTypeface(FontLoader.readTypeFace(context, attrs));
    }



}
