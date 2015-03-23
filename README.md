# android-fontloading-textview
Load custom fonts easily just via layout parameters or styles. Uses static Typeface objects, load once - memory efficient.
No more textView.setTypeface() calls!

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-android--fontloading--textview-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1659)

## Add gradle dependency
    compile 'net.kianoni:fontloader:0.3.0'

## Usage in layouts
Please use styles.xml instead!

Add font namespace to xml root element, eg.

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:font="http://schemas.android.com/apk/res-auto"


Define explicit font file to use:

    <net.kianoni.fontloader.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        font:fontFile="fonts/OpenSans-Regular.ttf"
        android:textSize="18sp"
        />

Or a pattern, family and variant:

    <net.kianoni.fontloader.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        font:fontFilePattern="fonts/{fontFamily}-{fontVariant}.ttf"
        font:fontFamily="OpenSans"
        font:fontVariant="Light"
        android:textSize="18sp"
        />

## usage in styles

Example:

    <resources xmlns:font="http://schemas.android.com/res/net.kianoni.fontloader">

        <!-- Base application theme. -->
        <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
            <!-- Customize your theme here. -->
        </style>

        <style name="OpenSans">
            <item name="fontFilePattern">fonts/{fontFamily}-{fontVariant}.ttf</item>
            <item name="fontFamily">OpenSans</item>
            <item name="fontVariant">Regular</item>
            <item name="android:textSize">18sp</item>
        </style>

        <style name="OpenSans.Bold" parent="OpenSans">
            <item name="fontVariant">Bold</item>
        </style>

    </resources>

and usage in layouts:

    <net.kianoni.fontloader.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        style="@style/OpenSans"
        />

    <net.kianoni.fontloader.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        style="@style/OpenSans.Bold"
        />
