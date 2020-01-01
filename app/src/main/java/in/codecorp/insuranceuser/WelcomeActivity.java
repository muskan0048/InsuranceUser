package in.codecorp.insuranceuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import in.codecorp.insuranceuser.models.ConnectionDetector;
import me.relex.circleindicator.CircleIndicator;

public class WelcomeActivity extends AppCompatActivity {
    ConnectionDetector cd;
    Button btn_get_started;
    TextView txt_skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indictor);
        viewpager.setAdapter(new AwesomePagerAdapter());
        indicator.setViewPager(viewpager);
        viewpager.setCurrentItem(0);

        cd = new ConnectionDetector(getApplicationContext());

        if (!cd.isNetworkAvailable()) {
            android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(WelcomeActivity.this);
            alertDialog.setTitle(R.string.Internet_Title);
            alertDialog.setMessage(R.string.Internet_Message);
            alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        }

        btn_get_started = (Button)findViewById(R.id.btn_get_started);
        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        txt_skip = (TextView)findViewById(R.id.txt_skip);
        txt_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private class AwesomePagerAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return 4;
        }


        @Override
        public Object instantiateItem(View collection, int position) {

            LayoutInflater mLayoutInflater = (LayoutInflater) collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View LeagueButtonView = mLayoutInflater.inflate(R.layout.mytickets, null);
            ((ViewPager) collection).addView(LeagueButtonView, 0);

            return LeagueButtonView;
        }


        @Override
        public void destroyItem(View collection, int position, Object view) {
            ((ViewPager) collection).removeView((View) view);
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public void finishUpdate(View arg0) {
        }


        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
        }

    }
}
