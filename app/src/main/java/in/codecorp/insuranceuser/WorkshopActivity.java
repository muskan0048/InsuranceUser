package in.codecorp.insuranceuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import in.codecorp.insuranceuser.Adapters.VehicleAdapter;
import in.codecorp.insuranceuser.Adapters.WorkshopAdapter;
import in.codecorp.insuranceuser.models.Vehicle;
import in.codecorp.insuranceuser.models.Workshop;

public class WorkshopActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Workshop> list;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        recyclerView = findViewById(R.id.recycle);
        database = FirebaseDatabase.getInstance().getReference("workshop");
        getData();
    }

    void getData(){
        // Read from the database
        list = new ArrayList<>();

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

//                String value = dataSnapshot.getValue(String.class);
                //      Log.d("jjs", "Value is: " + value);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    //System.out.println(snapshot.child("vBrand").getValue());
//                    Workshop vehicle = new Workshop(snapshot.child("vBrand").getValue().toString()
//                            , snapshot.child("vNumber").getValue().toString(),
//                            snapshot.child("vid").getValue().toString(), snapshot.child("vBrand").getValue().toString());
                  //  list.add(vehicle);
                  //  System.out.println(vehicle);
                }
                list.add(new Workshop("Workshop1", "Workshop Address 1", "10.726", "34.654",
                        "workshop1@gmail.com", "929299292", "7272727"));
                list.add(new Workshop("Workshop2", "Workshop Address 2", "11.726", "33.654",
                        "workshop2@gmail.com", "929299292", "7272727"));
                list.add(new Workshop("Workshop1", "Workshop Address 1", "10.726", "34.654",
                        "workshop3@gmail.com", "929299292", "7272727"));
                list.add(new Workshop("Workshop1", "Workshop Address 1", "10.726", "34.654",
                        "workshop4@gmail.com", "929299292", "7272727"));

                recyclerView.setLayoutManager(new LinearLayoutManager(WorkshopActivity.this));

                WorkshopAdapter vehicleAdapter = new WorkshopAdapter(getApplicationContext(), list);
                recyclerView.setAdapter(vehicleAdapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("hha", "Failed to read value.", error.toException());
            }
        });


    }
}
