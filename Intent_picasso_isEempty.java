


// intent dyal site
Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com"));
                startActivity(intent);
//intet
Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);


// addflag  kadar bach ila khrajti man app yab9a f akher intent darti fiha flag
   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);             
  
  //  ilakan editetexe khawi  madouch
  if (!TextUtils.isEmpty(username) || !TextUtils.isEmpty(mpassword)){

            
        };              

        
     // picasso 

      Picasso.with(context)
       .load(url)
       .placeholder(R.drawable.placeholder) //optional
       .resize(imgWidth, imgHeight)         //optional  
       .centerCrop()                        //optional   
       .into(image);                        //Your image view object. 

       
       //It's not possible? Of course it's possible. Get your FirbaseStorage object, lets name it 
       storage. Then,
 storage.getReference().child("nameOfChild").getDownloadUrl()

On this object, you add an onSuccessListener and then within the onSuccess override method, 
use Picasso or glide to show the image.﻿
         