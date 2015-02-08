package com.futurice.fontloader;

import android.content.Context;
import android.graphics.Typeface;

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
            // todo: error handling
            typeface = Typeface.createFromAsset(context.getAssets(), fontFile);
            typefaceByFilename.put(fontFile, typeface);
        }
        return typeface;
    }
}
