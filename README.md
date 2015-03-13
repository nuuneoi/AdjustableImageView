# AdjustableImageView

Provide `AdjustableImageView` and `AdjustableImageButton` which are the ImageView and ImageButton with the correct **adjustViewBounds** behaviour.

# Version

1.0.0

# Installation

To use this library in your android project, just simply add the following dependency into your build.gradle

```sh
dependencies {
    compile 'com.inthecheesefactory.thecheeselibrary:adjustable-imageview:1.0.0'
}
```

# Usage

Replace your ImageView with `com.inthecheesefactory.lab.animation.AdjustableImageView` and replace your ImageButton with `com.inthecheesefactory.lab.animation.AdjustableImageButton`, for example:

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fillViewport="true">

        <LinearLayout android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <com.inthecheesefactory.lab.animation.AdjustableImageView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:adjustViewBounds="true"
                android:src="@mipmap/ic_launcher"/>

            <com.inthecheesefactory.lab.animation.AdjustableImageView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:adjustViewBounds="true"
                android:src="@mipmap/ic_launcher"/>
        </LinearLayout>

    </ScrollView>

</LinearLayout>
```

# Change Logs

### v1.0.0

Initial version

# License
Apache 2.0
