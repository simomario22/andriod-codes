

//On Child Changed - Android Firebase Tutorial - Full Backend Course (Part - 14)


public class Main3Activity extends AppCompatActivity {


    private DatabaseReference rdatabase ;
    private ListView listView;
    private ArrayList<String>  arrayUsername = new ArrayList<> ();
    private ArrayList<String>  arrayKey = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        rdatabase = FirebaseDatabase.getInstance().getReference();
        listView = (ListView) findViewById(R.id.listview);

          //  arryadapter  hawa li kikoun bin listview o arrylist

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , arrayUsername );

        // kadakhl arryadapter  f  listview
        listView.setAdapter(arrayAdapter);

        rdatabase.addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                 // katjib value man database o kathatha f string value
                String value =dataSnapshot.getValue().toString();
                arrayUsername.add(value);

                //  katjib key man database o dero  f (key)
                String key =dataSnapshot.getKey();
                arrayKey.add(key);

                arrayAdapter.notifyDataSetChanged();

            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                //  had  method mnin value katbadel khas n3arfou achman key li tbadlt value dyalou

                String value = dataSnapshot.getValue().toString();
                String key  = dataSnapshot.getKey();

                int index = arrayKey.indexOf(key);
                arrayUsername.set(index,value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
