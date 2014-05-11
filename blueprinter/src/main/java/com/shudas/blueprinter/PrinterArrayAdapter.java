package com.shudas.blueprinter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shu on 5/10/2014.
 */
public class PrinterArrayAdapter extends ArrayAdapter<PrinterInfo> {

    Context context;
    ArrayList<PrinterInfo> printers;

    PrinterArrayAdapter(Context c, ArrayList<PrinterInfo> _printers) {
        super(c, R.layout.printerinfo_row, _printers);
        printers = _printers;
        context = c;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PrinterHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.printerinfo_row, parent, false);

            holder = new PrinterHolder();
            holder.name = (TextView)row.findViewById(R.id.printername);
            holder.state = (TextView)row.findViewById(R.id.printerSuc);
            row.setTag(holder);
        }
        else
        {
            holder = (PrinterHolder)row.getTag();
        }

        PrinterInfo printer = printers.get(position);
        holder.name.setText(printer.name);
        if (printer.state == "GOOD") {
            holder.state.setBackgroundResource(R.color.success);
        }
        else if (printer.state == "MAYBE") {
            holder.state.setBackgroundResource(R.color.maize);
        }
        else {
            holder.state.setBackgroundResource(R.color.fail);
        }
        return row;
    }

    static class PrinterHolder {
        TextView name, state;
    }
}
