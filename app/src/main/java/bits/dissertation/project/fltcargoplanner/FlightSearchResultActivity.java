package bits.dissertation.project.fltcargoplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Vignesh on 9/2/2016.
 */
public class FlightSearchResultActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_result);
        int capacity = 55;
      /*  String[] stringArray =  new String[5];
        stringArray[0] = "XX - 0200 - FRA - SFO - 08/20/2013 10:00 - 08/20/2013 22:00";
        stringArray[1] = "XX - 0201 - FRA - SFO - 08/20/2014 12:00 - 08/20/2014 22:00";
        stringArray[2] = "XX - 0202 - FRA - SFO - 08/20/2015 14:00 - 08/20/2015 22:00";
        stringArray[3] = "XX - 0203 - FRA - SFO - 08/20/2016 16:00 - 08/20/2016 22:00";
        stringArray[4] = "XX - 0204 - FRA - SFO - 08/20/2017 18:00 - 08/20/2017 22:00";

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.flightsearchresult_list,stringArray);
   */
        ListView listView = (ListView) findViewById(R.id.flight_list);

     //   listView.setAdapter(adapter);


        List<FlightInfo> flightInfo = new ArrayList<FlightInfo>();
        for(int i = 0; i < 10; ++i) {
            flightInfo.add(new FlightInfo("XX - "+( 0200+ i) + " - FRA - SFO - 08/20/2013 10:00 - 08/ 20/ 2013 22:00 ", i * 10 ));
        }

        listView.setAdapter(new FlightInfoArrayAdapter(getApplicationContext(), R.id.flight_list, flightInfo));


/*
        RelativeLayout layout = new RelativeLayout(this);

        for(int i = 0;i <= 10 ; i ++) {
            ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            //   progressBar.setIndeterminate(true);
            progressBar.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
         //   params.addRule(RelativeLayout.CENTER_IN_PARENT);
            layout.addView(progressBar, params);
        }


            TextView tv = new TextView(getApplicationContext());
            tv.setText("XX - 0200 - FRA - SFO - 08/20/2013 10:00 - 08/20/2013 22:00");
        layout.addView(tv);
        setContentView(layout);
    */}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_flight_results, menu);
        return true;
    }
}
