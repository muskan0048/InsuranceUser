package in.codecorp.insuranceuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import in.codecorp.insuranceuser.models.User;

public class RegisterActivity extends AppCompatActivity {

    String email;
    String password;
    String name;
    String phone;
    EditText edtName;
    EditText edtPwd;
    EditText edtEmail;
    EditText edtPhone;
    Button register;

    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    void init(){
         edtName = (EditText) findViewById(R.id.edtName);
         edtPwd = (EditText) findViewById(R.id.editText4);
         edtEmail = (EditText) findViewById(R.id.edtEmail2);
         edtPhone = (EditText) findViewById(R.id.edtPhone);
         register = (Button) findViewById(R.id.btnReg);
         mAuth = FirebaseAuth.getInstance();
         progressDialog = new ProgressDialog(RegisterActivity.this);
         databaseReference = FirebaseDatabase.getInstance().getReference("user");
        register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 register();
             }
         });

    }

    void register(){
        progressDialog.show();
        email = edtEmail.getText().toString().trim();
        password = edtPwd.getText().toString().trim();
        name = edtName.getText().toString().trim();
        phone = edtPhone.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("hdhd", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            insertData(user.getUid());
                            Intent intent = new Intent(RegisterActivity.this, UserDashboard.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("hhdd", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    void insertData(String uid){
        User user = new User(name, email, phone, password, uid);
        databaseReference.child(uid).setValue(user);
        progressDialog.dismiss();
    }
}
