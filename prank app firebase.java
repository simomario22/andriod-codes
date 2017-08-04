package com.tips.picasofirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main5Activity extends AppCompatActivity {

    private DatabaseReference  mdatabase;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView   textview1 ,textView2 ,textView3 ;

    String mbtn1 ;
    String mbtn2 ;
    String mbtn3 ;
    //String imageU;

    private ProgressDialog mProgressDialog ;


    \\  hadi  3la 9bal button bach ya cliki darori
    private int  a ,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btn1 = (Button )findViewById(R.id.button1);
        btn2 = (Button )findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        textview1 =(TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);

         //  progressdialog  ...
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Load..");
        mProgressDialog.setMessage("wait ...");
        mProgressDialog.show();


        mdatabase = FirebaseDatabase.getInstance().getReference().child("page5");

        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                // for prograsdialog
                if (dataSnapshot.exists()){

                    //do something
                    mProgressDialog.dismiss();
                }


                String text1 = dataSnapshot.child("text1").getValue().toString();
                String text2 = dataSnapshot.child("text2").getValue().toString();
                String text3 = dataSnapshot.child("text3").getValue().toString();


                  mbtn1 = dataSnapshot.child("btn1").getValue().toString();
                  mbtn2 = dataSnapshot.child("btn2").getValue().toString();
                  mbtn3 = dataSnapshot.child("btn3").getValue().toString();
                 // imageU = dataSnapshot.child("imageU").getValue().toString();


                textview1.setText(text1);
                textView2.setText(text2);
                textView3.setText(text3);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                mProgressDialog.dismiss();


            }
        });




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(mbtn1));
                startActivity(intent);
                a = 1;
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(mbtn2));
                startActivity(intent);

                b = 1;
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(mbtn3));
                startActivity(intent);

                c = 1;
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  chart  hta ycliki 3la buttons b 3

                if (a ==1 &&  b==1  && c== 1 ){

                    Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);

                }else {

                    Toast.makeText(getApplicationContext(),"makhdamch der 5 star",Toast.LENGTH_LONG).show();
                }



            }
        });

    }



}
