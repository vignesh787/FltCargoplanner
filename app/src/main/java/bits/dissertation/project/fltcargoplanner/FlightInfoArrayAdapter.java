package bits.dissertation.project.fltcargoplanner;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vignesh on 9/5/2016.
 */
public class FlightInfoArrayAdapter extends ArrayAdapter<FlightInfo> {
    // Simple class to make it so that we don't have to call findViewById frequently
    private static class ViewHolder {
        TextView textView;
        ProgressBar progressBar;
        Button button;
        FlightInfo info;
    }


    private static final String TAG = FlightInfoArrayAdapter.class.getSimpleName();

    public FlightInfoArrayAdapter(Context context, int textViewResourceId,
                                    List<FlightInfo> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final FlightInfo info = getItem(position);
        // We need to set the convertView's progressBar to null.

        ViewHolder holder = null;

        if(null == row) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.flightdetails_row, parent, false);

            holder = new ViewHolder();
            holder.textView = (TextView) row.findViewById(R.id.FlightDetails);
            holder.progressBar = (ProgressBar) row.findViewById(R.id.downloadProgressBar);

            holder.info = info;

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();

            holder.info.setProgressBar(null);
            holder.info = info;
            holder.info.setProgressBar(holder.progressBar);
        }

        holder.textView.setText(info.getFlightData());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FlightResultDetailsActivity.class);
                intent.putExtra("flightData",info.getFlightData());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);

            }
        });
        holder.progressBar.setProgress(info.getProgress());
        //holder.progressBar.setMax(info.getFileSize());
        info.setProgressBar(holder.progressBar);


        return row;
    }

}