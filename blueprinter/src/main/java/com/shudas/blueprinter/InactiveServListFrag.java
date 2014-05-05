package com.shudas.blueprinter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class InactiveServListFrag extends ListFragment {
    static final String[] inactiveServs = {"Google Drive", "Box"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        InactArrayAdapter adapter = new InactArrayAdapter(inflater.getContext(), inactiveServs);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

class InactArrayAdapter extends ArrayAdapter<String> {

    InactArrayAdapter(Context c, String[] data) {
        super(c, R.layout.inactiveservitem, R.id.servTV, data);
    }
}
