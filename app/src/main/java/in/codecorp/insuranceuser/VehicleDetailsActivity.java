package in.codecorp.insuranceuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VehicleDetailsActivity extends AppCompatActivity {

    TextView txtMake, txtModel, txtNumber;
    String make, model, number;
    Button btnService, btnAccident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);
        txtMake = findViewById(R.id.textView5);
        txtModel = findViewById(R.id.textView6);
        txtNumber = findViewById(R.id.textView7);
        btnService = findViewById(R.id.button2);
        btnAccident = findViewById(R.id.button3);

        btnAccident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(VehicleDetailsActivity.this, RcActivity.class);
                startActivity(intent);
            }
        });

        txtMake.setText(getIntent().getStringExtra("brand"));
        txtModel.setText(getIntent().getStringExtra("name"));
        txtNumber.setText(getIntent().getStringExtra("number"));
    }
}
