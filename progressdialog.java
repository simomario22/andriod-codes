public class Main4Activity extends AppCompatActivity {


    private ProgressDialog  startProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);



        startProgress = new ProgressDialog(this);
        startProgress.setTitle("start the app");
        startProgress.setMessage("had  lbarr khadama m3akk");
        //  if clik outside dosent canceld
        startProgress.setCanceledOnTouchOutside(false);
        startProgress.show();


        // to finished
        startProgress.dismiss();


    }

}
