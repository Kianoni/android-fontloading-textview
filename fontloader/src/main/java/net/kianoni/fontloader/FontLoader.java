package net.kianoni.fontloader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kilp on 08/02/15.
 */
public class FontLoader {

    private Map<String, Typeface> typefaceByFilename = new HashMap<>();
    private static FontLoader ourInstance = new FontLoader();

    public static FontLoader getInstance() {
        return ourInstance;
    }

    private FontLoader() {
    }

    public Typeface getTypeFace(Context context, String fontFile) {
        Typeface typeface = typefaceByFilename.get(fontFile);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontFile);
                typefaceByFilename.put(fontFile, typeface);
            } catch (RuntimeException e) {
                throw new RuntimeException("Error loading font", e);
            }
        }
        return typeface;
    }

    public Typeface getTypeFace(Context context, String fontFamily, String fontVariant, String fontFilePattern) {
        String fontFilename = fontFilePattern.replace("{fontFamily}", fontFamily).replace("{fontVariant}", fontVariant);
        return getTypeFace(context, fontFilename);
    }

    public static Typeface readTypeFace(Context context, AttributeSet attrs) {
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.TextView);

        String fontFile = null;
        String fontFamily = null;
        String fontVariant = null;
        String fontFilePattern = null;

        final int N = styledAttributes.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = styledAttributes.getIndex(i);
            if (R.styleable.TextView_fontFile == attr) {
                fontFile = styledAttributes.getString(attr);
            }
            if (R.styleable.TextView_fontFamily == attr) {
                fontFamily = styledAttributes.getString(attr);
            }
            if (R.styleable.TextView_fontVariant == attr) {
                fontVariant = styledAttributes.getString(attr);
            }
            if (R.styleable.TextView_fontFilePattern == attr) {
                fontFilePattern = styledAttributes.getString(attr);
            }
        }

        styledAttributes.recycle();

        if (fontFamily != null && fontVariant != null && fontFilePattern != null) {
            if (fontFile != null) {
                throw new RuntimeException("Attempting to set fontFile together with fontFilePattern");
            }
            return FontLoader.getInstance().getTypeFace(context, fontFamily, fontVariant, fontFilePattern);
        }

        if (fontFile != null) {
            return  FontLoader.getInstance().getTypeFace(context, fontFile);
        }
        return Typeface.DEFAULT;
    }


}
