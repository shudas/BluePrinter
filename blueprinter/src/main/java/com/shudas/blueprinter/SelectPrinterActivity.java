package com.shudas.blueprinter;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class SelectPrinterActivity extends ActionBarActivity {

    SelectPrinterFragment printerfrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_printer);

        FragmentManager fm = getSupportFragmentManager();
        printerfrag = (SelectPrinterFragment) fm.findFragmentById(R.id.selectprinterfrag);

        // If the Fragment is non-null, then it is currently being
        // retained across a configuration change.
        if (printerfrag == null) {
            printerfrag = new SelectPrinterFragment();
            fm.beginTransaction().add(0, printerfrag).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_printer, menu);
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
