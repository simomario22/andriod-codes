package com.tips.picasofirebase;

import android.content.Intent;
import android.support.annotation.InterpolatorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class Main2Activity extends AppCompatActivity {


    public Button mButton;
    private InterstitialAd mInterstitialAd;
    private DatabaseReference  mReference ;
    private  String ads ;




    static ImageView mimage2;

    private String url = "https://s-media-cache-ak0.pinimg.com/236x/a9/6e/2f/a96e2fde6aa4a147ff0b96c5fd9e0da9--splash-screen-screen-design.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mReference  = FirebaseDatabase.getInstance().getReference().child("ads");

        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ads = dataSnapshot.child("ads1").getValue().toString();



                //  load ads id from firebase if data work good

                if (dataSnapshot.exists()) {

                    mInterstitialAd = new InterstitialAd(getApplication());
                    mInterstitialAd.setAdUnitId(ads);
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());

                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            // Load the next interstitial.
                            mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        }

                    });

                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });







        mButton =(Button)findViewById(R.id.button2) ;
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main5Activity.class);
                startActivity(intent);

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        });






        mimage2 =(ImageView) findViewById(R.id.imageurl);

        Picasso.with(getApplicationContext()).load(url).into(mimage2);


    }
}
