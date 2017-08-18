

// picasso 

      Picasso.with(context)
       .load(url)
       .placeholder(R.drawable.placeholder) //optional
       .resize(imgWidth, imgHeight)         //optional  
       .centerCrop()                        //optional   
       .into(image);                        //Your image view object. 


/*

you can simplify and let the OkHttpDownloader from Picasso to handle caching images to disk. Picasso supports disk caching through it's HTTP client.

For example:  */

mBuilder = new Picasso.Builder(context) 
                  .loggingEnabled(BuildConfig.DEBUG) 
                  .indicatorsEnabled(BuildConfig.DEBUG) 
                  .downloader(new OkHttpDownloader(context, DISK_CACHE_SIZE)) 
                  .build();

mBuilder.load("url").into(target);