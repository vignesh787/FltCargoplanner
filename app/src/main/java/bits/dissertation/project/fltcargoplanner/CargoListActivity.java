package bits.dissertation.project.fltcargoplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CargoListActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_list);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expandableListView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("High Priority Cargo");
        listDataHeader.add("Medium Priority Cargo");
        listDataHeader.add("Low Priority Cargo");

        // Adding child data
        List<String> highPriority = new ArrayList<String>();
        highPriority.add("AWB # 66857485");
        highPriority.add("AWB # 66857485");
        highPriority.add("AWB # 66857485");


        List<String> mediumPriority = new ArrayList<String>();
        mediumPriority.add("AWB # 45887485");
        mediumPriority.add("AWB # 45887485");
        mediumPriority.add("AWB # 45887485");
        mediumPriority.add("AWB # 45887485");
        mediumPriority.add("AWB # 45887485");


        List<String> lowPriority = new ArrayList<String>();
        lowPriority.add("AWB # 32447485");
        lowPriority.add("AWB # 32447485");
        lowPriority.add("AWB # 32447485");
        lowPriority.add("AWB # 32447485");
        lowPriority.add("AWB # 32447485");
        lowPriority.add("AWB # 32447485");
        lowPriority.add("AWB # 32447485");

        listDataChild.put(listDataHeader.get(0), highPriority); // Header, Child data
        listDataChild.put(listDataHeader.get(1), mediumPriority);
        listDataChild.put(listDataHeader.get(2), lowPriority);
    }

}