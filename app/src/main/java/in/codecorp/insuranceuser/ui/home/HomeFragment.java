package in.codecorp.insuranceuser.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import in.codecorp.insuranceuser.Adapters.VehicleAdapter;
import in.codecorp.insuranceuser.NewVehicleActivity;
import in.codecorp.insuranceuser.R;
import in.codecorp.insuranceuser.VehicleDetailsActivity;
import in.codecorp.insuranceuser.models.Vehicle;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    List<Vehicle> list;
    TextView txtView;
    ImageView imageView;
    DatabaseReference database;
    String uid;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // final TextView textView = root.findViewById(R.id.text_home);
        recyclerView = root.findViewById(R.id.rec);
        imageView = root.findViewById(R.id.imageView);
        txtView = root.findViewById(R.id.textView3);
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        uid = firebaseUser.getUid();
        database = FirebaseDatabase.getInstance().getReference("vehicle");
        getData();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initV();
            }
        });
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initV();
            }
        });
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
         //       textView.setText(s);
            }
        });
        return root;
    }

    void initV(){
        Intent intent = new Intent(getActivity(), NewVehicleActivity.class);
        startActivity(intent);
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
                    Vehicle vehicle = new Vehicle(snapshot.child("vName").getValue().toString()
                            , snapshot.child("vNumber").getValue().toString(),
                            snapshot.child("vid").getValue().toString(), snapshot.child("vBrand").getValue().toString(), snapshot.child("uid").getValue().toString());

                    list.add(vehicle);
                    System.out.println(vehicle);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                VehicleAdapter vehicleAdapter = new VehicleAdapter(getActivity(), list);
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