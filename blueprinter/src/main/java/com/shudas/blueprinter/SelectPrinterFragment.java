package com.shudas.blueprinter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectPrinterFragment extends ListFragment {

    public static final String RETURNED_PRINTER = "RETURNED_PRINTER";
    ArrayList<PrinterInfo> printers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printers = PrinterInfo.genPrinters(100);
        // Retain this fragment across configuration changes.
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PrinterArrayAdapter adapter = new PrinterArrayAdapter(inflater.getContext(), printers);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = getActivity().getIntent();
        PrinterInfo printer = (PrinterInfo) l.getAdapter().getItem(position);
        System.out.println(printer.name);
        intent.putExtra(RETURNED_PRINTER, printer);
        getActivity().setResult(Activity.RESULT_OK, intent);
        // Don't allow this activity to come back
        getActivity().finish();
    }
}
