//   mesage  fih  yes  ou  close  

AlertDialog.Builder builder = new  AlertDialog.Builder(clashroyaleclashroyale_7.this);
                    builder.setMessage("Review the Application Before Exit");
                    builder.setCancelable(true);
                    builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                        }
                    });


                    builder.setPositiveButton("Close!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();

                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();