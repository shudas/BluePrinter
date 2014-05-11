package com.shudas.blueprinter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PrintActivity extends ActionBarActivity {

    public static int SELECT_PRINTER_REQUEST = 2;

    public static final String RETURNED_JOB = "RETURNED_JOB";
    private static final String ALL_OPTS_ENABLED = "ALL_OPTS_ENABLED";
    private static final String CURR_PRINTER = "CURR_PRINTER";
    boolean alloptsenabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        // if opts were enabled, then reenable them in case orientation changed
        if (savedInstanceState != null) {
            ((TextView) findViewById(R.id.selectPrinterTV))
                    .setText(savedInstanceState.getString(CURR_PRINTER));
            alloptsenabled = savedInstanceState.getBoolean(ALL_OPTS_ENABLED);
            if (alloptsenabled) {
                disableEnableControls(true, (ViewGroup) findViewById(R.id.allopts));
            }
            else {
                // Disable all options until name is selected
                disableEnableControls(false, (ViewGroup) findViewById(R.id.allopts));
            }
        }
        else {
            // Disable all options until name is selected
            disableEnableControls(false, (ViewGroup) findViewById(R.id.allopts));
        }

        // set the fit to page param
//        ((ToggleButton) findViewById(R.id.fittopageTB)).setChecked(fittopage);

        // Set up spinners
        Spinner ppsspinner = (Spinner) findViewById(R.id.pagesPerSheet);
        ArrayAdapter<CharSequence> ppsadapter = ArrayAdapter.createFromResource(this,
                R.array.pps_choices, android.R.layout.simple_spinner_item);
        ppsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ppsspinner.setAdapter(ppsadapter);

        Spinner duplexspinner = (Spinner) findViewById(R.id.duplexOpt);
        ArrayAdapter<CharSequence> duplexadapter = ArrayAdapter.createFromResource(this,
                R.array.duplex_choices, android.R.layout.simple_spinner_item);
        duplexadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        duplexspinner.setAdapter(duplexadapter);

        // set on click listener for name selector
        findViewById(R.id.selectPrinterTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPrinterClicked(view);

            }
        });
    }

    private void selectPrinterClicked(View v) {
        Intent intent = new Intent(this, SelectPrinterActivity.class);
        startActivityForResult(intent, SELECT_PRINTER_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(requestCode);
//        if (requestCode == PRINT_REQUEST) {
//        System.out.println("Yooo");
        // user actually selected a printer
        if (resultCode == RESULT_OK) {
            PrinterInfo ret = data.getParcelableExtra(SelectPrinterFragment.RETURNED_PRINTER);
            ((TextView) findViewById(R.id.selectPrinterTV)).setText(ret.name);
            // enable all controls
            if (alloptsenabled) return;
            disableEnableControls(true, (ViewGroup) findViewById(R.id.allopts));
            alloptsenabled = true;
        }
//        }
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ALL_OPTS_ENABLED, alloptsenabled);
        outState.putString(CURR_PRINTER,
                ((TextView) findViewById(R.id.selectPrinterTV)).getText().toString());
    }

    // disable/enable all children
    private void disableEnableControls(boolean enable, ViewGroup vg){
        for (int i = 0; i < vg.getChildCount(); i++){
            View child = vg.getChildAt(i);
            child.setEnabled(enable);
            if (child instanceof ViewGroup){
                disableEnableControls(enable, (ViewGroup)child);
            }
        }
    }

    public void printClicked(View v) {
        Intent intent = getIntent();
        JobTabInfo info = new JobTabInfo(true, "TEST_SUCCESS_FILE", "Submitted my/da/te", "TEST_PRINTER");
        intent.putExtra(RETURNED_JOB, info);
        setResult(RESULT_OK, intent);
        // Don't allow this activity to come back
        finish();
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
        switch (item.getItemId()) {
            // Don't create new Activity with up nav
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
