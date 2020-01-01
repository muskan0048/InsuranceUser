package in.codecorp.insuranceuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", 0);
        if (prefs.getBoolean("firstrun", true)) {
            prefs.edit().putBoolean("firstrun", false).commit();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.this.finish();
                    Intent mainIntent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(mainIntent);
                }
            }, SPLASH_DISPLAY_LENGTH);
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.this.finish();
                    Intent mainIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(mainIntent);
                }
            }, SPLASH_DISPLAY_LENGTH);
        }

    }
}
