// Retrieving Basic Data - Android Firebase Tutorial - Full Backend Course (Part - 12)
TVAC Studio 
TVAC Studio

package com.tips.picasofirebase;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Main3Activity extends AppCompatActivity {


    private DatabaseReference rdatabase ;
    private TextView  textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        rdatabase = FirebaseDatabase.getInstance().getReference().child("message");
        textView = (TextView)findViewById(R.id.textView);


        rdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String name = dataSnapshot.getValue().toString();
                textView.setText("name :"+ name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
