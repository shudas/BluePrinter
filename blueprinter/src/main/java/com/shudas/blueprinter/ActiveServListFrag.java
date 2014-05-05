package com.shudas.blueprinter;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ActiveServListFrag extends ListFragment {
    static final String[] activeServs = {"MFile IFS", "MPrint Locker", "Dropbox"};
    static final String[] inactiveServs = {"Google Drive", "Box"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(inflater.getContext(), R.layout.activeservitem, activeServs);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
