package sg.org.dso.digitalvisits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PostScanningNRICNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_scanning_nricname);

        String nric = getIntent().getStringExtra("nric");
        String user = getIntent().getStringExtra("username");
        TextView tv = findViewById(R.id.textView2);
        tv.setText(nric);

        TextView tv2 = findViewById(R.id.textView3);
        tv2.setText(user);


        String appendedData = nric + ";" + user;
        MulticastController.getInstance().sendData(appendedData);

    }

    public void backtoMain(View v)
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
