# android-fontloading-textview
Helper for using custom fonts in styles

## Usage in layouts
Please use styles.xml instead!

Add font namespace to xml root element, eg.

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:font="http://schemas.android.com/apk/res-auto"


Define explicit font file to use:

    <com.futurice.fontloader.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        font:fontFile="fonts/OpenSans-Regular.ttf"
        android:textSize="18sp"
        />

Or a pattern, family and variant:

    <com.futurice.fontloader.TextView
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

    <resources xmlns:font="http://schemas.android.com/res/com.futurice.fontloader">

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

    <com.futurice.fontloader.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        style="@style/OpenSans"
        />

    <com.futurice.fontloader.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        style="@style/OpenSans.Bold"
        />
