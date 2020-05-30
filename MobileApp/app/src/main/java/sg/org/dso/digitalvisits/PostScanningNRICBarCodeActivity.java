package sg.org.dso.digitalvisits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PostScanningNRICBarCodeActivity extends AppCompatActivity {

    private String nric;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_scanning);

        nric = getIntent().getStringExtra("nric");
        TextView tv = findViewById(R.id.textView2);
        tv.setText(nric);

    }

    public void proceedToFront(View v)
    {
        Intent myIntent = new Intent(this, CameraNRICRecogniztionActivity.class);
        myIntent.putExtra("nric", nric);
        startActivity(myIntent);
    }
}
