# android-fontloading-textview
Efficient font loading with custom xml attributes

# add gradle dependency
todo: publish to public repo

# Usage in layouts
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
            android:textSize="28dp"
            />

Or a pattern, family and variant:

        <com.futurice.fontloader.TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/hello_world"
            font:fontFilePattern="fonts/{fontFamily}-{fontVariant}.ttf"
            font:fontFamily="OpenSans"
            font:fontVariant="Light"
            android:textSize="28dp"
            />

# usage in styles

Example:

    <resources xmlns:font="http://schemas.android.com/res/com.elisa.wallet">

        <!-- Base application theme. -->
        <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
            <!-- Customize your theme here. -->
        </style>

        <style name="OpenSans">
            <item name="fontFilePattern">fonts/{fontFamily}-{fontVariant}.ttf</item>
            <item name="fontFamily">OpenSans</item>
            <item name="fontVariant">Regular</item>
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
        android:textSize="28dp"
        />

    <com.futurice.fontloader.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        style="@style/OpenSans.Bold"
        android:textSize="28dp"
        />
