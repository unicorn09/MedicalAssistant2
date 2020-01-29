package com.example.dell.medicalassistant;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowImagesActivity extends AppCompatActivity {
    String user_id=FirebaseAuth.getInstance().getUid();
    String user_id1=FirebaseAuth.getInstance().getUid();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private DatabaseReference mDatabase;
    private ProgressDialog progressDialog;

    //list to hold all the uploaded images
    private List<Upload> uploads;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.divyansh,menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        user_id=user_id1;
        switch(id)
        {
            case R.id.xrays1:
                user_id=user_id+"/xray";
                setContentView(R.layout.showimagesactivity);
                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                progressDialog = new ProgressDialog(this);

                uploads = new ArrayList<>();

                progressDialog.setMessage("Please wait...");
                progressDialog.show();
                mDatabase = FirebaseDatabase.getInstance().getReference(user_id);


                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        // Toast.makeText(ShowImagesActivity.this, "entered onDataChange", Toast.LENGTH_SHORT).show();
                        //dismissing the progress dialog
                        progressDialog.dismiss();

                        //iterating through all the values in database
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            Upload upload = postSnapshot.getValue(Upload.class);
                            uploads.add(upload);
                            //Toast.makeText(ShowImagesActivity.this, "entered DataChange", Toast.LENGTH_SHORT).show();
                        }
                        //creating adapter
                        adapter = new MyAdapter(getApplicationContext(), uploads);

                        //adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                        //Toast.makeText(ShowImagesActivity.this, "end", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                        //Toast.makeText(ShowImagesActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                });
                Toast.makeText(this, "showing files in xray folder", Toast.LENGTH_SHORT).show();

                break;
            case R.id.mris1:
                user_id=user_id+"/mri";
                setContentView(R.layout.showimagesactivity);
                //  Toast.makeText(this, "please Change from menu on right top corner ", Toast.LENGTH_SHORT).show();


                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));


                progressDialog = new ProgressDialog(this);

                uploads = new ArrayList<>();

                //displaying progress dialog while fetching images
                progressDialog.setMessage("Please wait...");
                progressDialog.show();

                mDatabase = FirebaseDatabase.getInstance().getReference(user_id);

                //adding an event listener to fetch values
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        // Toast.makeText(ShowImagesActivity.this, "entered onDataChange", Toast.LENGTH_SHORT).show();
                        //dismissing the progress dialog
                        progressDialog.dismiss();

                        //iterating through all the values in database
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            Upload upload = postSnapshot.getValue(Upload.class);
                            uploads.add(upload);
                            //Toast.makeText(ShowImagesActivity.this, "entered DataChange", Toast.LENGTH_SHORT).show();
                        }
                        //creating adapter
                        adapter = new MyAdapter(getApplicationContext(), uploads);

                        //adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                        //Toast.makeText(ShowImagesActivity.this, "end", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                        //Toast.makeText(ShowImagesActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                });
                Toast.makeText(this, "showing files in mri folder", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pres1:
                user_id=user_id+"/prescription";
                setContentView(R.layout.showimagesactivity);
                //  Toast.makeText(this, "please Change from menu on right top corner ", Toast.LENGTH_SHORT).show();


                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));


                progressDialog = new ProgressDialog(this);

                uploads = new ArrayList<>();

                //displaying progress dialog while fetching images
                progressDialog.setMessage("Please wait...");
                progressDialog.show();

                mDatabase = FirebaseDatabase.getInstance().getReference(user_id);

                //adding an event listener to fetch values
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        // Toast.makeText(ShowImagesActivity.this, "entered onDataChange", Toast.LENGTH_SHORT).show();
                        //dismissing the progress dialog
                        progressDialog.dismiss();

                        //iterating through all the values in database
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            Upload upload = postSnapshot.getValue(Upload.class);
                            uploads.add(upload);
                            //Toast.makeText(ShowImagesActivity.this, "entered DataChange", Toast.LENGTH_SHORT).show();
                        }
                        //creating adapter
                        adapter = new MyAdapter(getApplicationContext(), uploads);

                        //adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                        //Toast.makeText(ShowImagesActivity.this, "end", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                        //Toast.makeText(ShowImagesActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                });
                Toast.makeText(this, "showing files in prescription folder", Toast.LENGTH_SHORT).show();
                break;
            case R.id.oth1:
                user_id=user_id+"/others";
                setContentView(R.layout.showimagesactivity);
                //  Toast.makeText(this, "please Change from menu on right top corner ", Toast.LENGTH_SHORT).show();


                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));


                progressDialog = new ProgressDialog(this);

                uploads = new ArrayList<>();

                //displaying progress dialog while fetching images
                progressDialog.setMessage("Please wait...");
                progressDialog.show();

                mDatabase = FirebaseDatabase.getInstance().getReference(user_id);

                //adding an event listener to fetch values
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        // Toast.makeText(ShowImagesActivity.this, "entered onDataChange", Toast.LENGTH_SHORT).show();
                        //dismissing the progress dialog
                        progressDialog.dismiss();

                        //iterating through all the values in database
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            Upload upload = postSnapshot.getValue(Upload.class);
                            uploads.add(upload);
                            //Toast.makeText(ShowImagesActivity.this, "entered DataChange", Toast.LENGTH_SHORT).show();
                        }
                        //creating adapter
                        adapter = new MyAdapter(getApplicationContext(), uploads);

                        //adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                        //Toast.makeText(ShowImagesActivity.this, "end", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                        //Toast.makeText(ShowImagesActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                });
                Toast.makeText(this, "showing files in others folder", Toast.LENGTH_SHORT).show();

                break;




        }


        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.showimagesactivity);
      //  Toast.makeText(this, "please Change from menu on right top corner ", Toast.LENGTH_SHORT).show();


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progressDialog = new ProgressDialog(this);

        uploads = new ArrayList<>();

        //displaying progress dialog while fetching images
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        mDatabase = FirebaseDatabase.getInstance().getReference(user_id);

        //adding an event listener to fetch values
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
               // Toast.makeText(ShowImagesActivity.this, "entered onDataChange", Toast.LENGTH_SHORT).show();
                //dismissing the progress dialog
                progressDialog.dismiss();

                //iterating through all the values in database
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    uploads.add(upload);
                    //Toast.makeText(ShowImagesActivity.this, "entered DataChange", Toast.LENGTH_SHORT).show();
                }
                //creating adapter
                adapter = new MyAdapter(getApplicationContext(), uploads);

                //adding adapter to recyclerview
                recyclerView.setAdapter(adapter);
                //Toast.makeText(ShowImagesActivity.this, "end", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
                //Toast.makeText(ShowImagesActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
