package com.futurice.fontloader;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

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
}
