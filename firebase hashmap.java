
//Lapit Chat App - Account Settings - Firebase Tutorials - Part 9 | Android Studio

public class Main4Activity extends AppCompatActivity {



    private DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


    //kader child f referenc o ysamih libghiti
        mdatabase = FirebaseDatabase.getInstance().getReference().child("info");


        //  hashmap  bach tjma3 fiha data
        HashMap<String ,String>  infoHash = new HashMap<>();
        infoHash.put("name" ,"mohamed" );
        infoHash.put("Age", "22");
        infoHash.put("image","url");

        //  katsift hashmap l database  o kader listenr bach tchouf wach waslat
        mdatabase.setValue(infoHash).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                //  ila  khdmat  ftah main5activity
                if (task.isSuccessful()){

                    Intent intent2 = new Intent(getApplicationContext(),Main5Activity.class);
                    startActivity(intent2);
                }

            }
        });





    }

}
