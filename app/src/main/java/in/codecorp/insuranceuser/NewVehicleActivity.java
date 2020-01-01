package in.codecorp.insuranceuser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.codecorp.insuranceuser.models.Vehicle;

public class NewVehicleActivity extends AppCompatActivity {

    DatabaseReference database;
    AutoCompleteTextView eName, eName2;
    EditText  eNumber;
    String name, make, number;
    Button save;
    ProgressDialog progressDialog;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vehicle);
        init();
    }

    void init(){
        database = FirebaseDatabase.getInstance().getReference("vehicle");
        progressDialog = new ProgressDialog(NewVehicleActivity.this);
        eName = findViewById(R.id.edtName);
        eName2 = findViewById(R.id.edtName2);
        eNumber = findViewById(R.id.edtNumber);
        save = findViewById(R.id.button);
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        uid = firebaseUser.getUid();
        getInfo();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                getData();
            }
        });
    }

    void getData(){
        make = eName.getText().toString().trim();
        name = eName2.getText().toString().trim();
        number = eNumber.getText().toString().trim();
        if((make.equalsIgnoreCase(null) || make.equalsIgnoreCase(""))
                || (name.equalsIgnoreCase(null) || name.equalsIgnoreCase(""))
        || (number.equalsIgnoreCase(null) || number.equalsIgnoreCase(""))){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Kindly fill up all the fields");

            alertDialogBuilder.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        else{
            insertData();

        }

    }

    void insertData(){
        String key = database.push().getKey();
        Vehicle vehicle = new Vehicle(name, number, key, make, uid);
        database.child(key).setValue(vehicle);
        progressDialog.dismiss();
        Toast.makeText(getApplicationContext(), "New Car Added", Toast.LENGTH_LONG).show();
        finish();
    }

    void getInfo(){
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        final List<String> brand = new ArrayList<>();
        final List<String> model = new ArrayList<>();
        StringRequest strReq = new StringRequest(Request.Method.GET,
                "http://codecorp.in/cars.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("s", response);
                //pDialog.hide();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("cars");
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject jo = jsonArray.getJSONObject(i);
                        if(!brand.contains(jo.getString("brand"))){
                            brand.add(jo.getString("brand"));
                        }
                        if(!model.contains(jo.getString("model"))){
                            model.add(jo.getString("model"));
                        }

                    }
                    String[] br = new String[brand.size()];
                    br = brand.toArray(br);

                    String[] mo = new String[model.size()];
                    mo = model.toArray(mo);


                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewVehicleActivity.this,
                            android.R.layout.simple_dropdown_item_1line, br);
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(NewVehicleActivity.this,
                            android.R.layout.simple_dropdown_item_1line, mo);
                   eName.setAdapter(adapter);
                   eName2.setAdapter(adapter1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "Data aagya", Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("", "Error: " + error.getMessage());
                System.out.println(error.getMessage());
                //  pDialog.hide();
            }
        });

// Adding request to request queue
        mRequestQueue.add(strReq);

    }
}
