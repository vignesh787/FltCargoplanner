package bits.dissertation.project.fltcargoplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Vignesh on 9/5/2016.
 */
public class FlightResultDetailsActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);
        Intent intent = getIntent();
        String flightData = intent.getStringExtra("flightData");

        TextView view = (TextView)findViewById(R.id.flightData);
        view.setText(flightData);
    }
}
