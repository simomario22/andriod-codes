
First Activity :

Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
intent.putExtra("Variable Name",string_to_be_sent);
startActivity(intent);


Second Activity :

//Receiving data inside onCreate() method of Second Activity

String value = getIntent().getStringExtra("Variable Name");