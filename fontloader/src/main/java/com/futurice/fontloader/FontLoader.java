package com.futurice.fontloader;

/**
 * Created by kilp on 08/02/15.
 */
public class FontLoader {

    private static FontLoader ourInstance = new FontLoader();

    public static FontLoader getInstance() {
        return ourInstance;
    }

    private FontLoader() {
    }

}
