package com.shudas.blueprinter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class PrintActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        Spinner ppsspinner = (Spinner) findViewById(R.id.pagesPerSheet);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> ppsadapter = ArrayAdapter.createFromResource(this,
                R.array.pps_choices, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        ppsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        ppsspinner.setAdapter(ppsadapter);

        Spinner duplexspinner = (Spinner) findViewById(R.id.duplexOpt);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> duplexadapter = ArrayAdapter.createFromResource(this,
                R.array.duplex_choices, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        duplexadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        duplexspinner.setAdapter(duplexadapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.print, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
