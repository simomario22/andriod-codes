// ads  bannar programed

        View adContainer = findViewById(R.id.adMobView);

        AdView mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.SMART_BANNER);
        mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        ((RelativeLayout)adContainer).addView(mAdView);
        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);


        //  add this to your layout

    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"

        android:layout_alignParentStart="true">

        <RelativeLayout
            android:id="@+id/adMobView"

            android:layout_width="match_parent"
            android:layout_height="50dp"

            android:layout_centerVertical="true"
            android:layout_centerHorizontal="true" />

    </RelativeLayout>
