package com.shudas.blueprinter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FilesFragment extends Fragment {

    String[] activeServs = {"MBox", "MFile IFS", "MPrint Locker"};
    String[] inactiveServs = {"Dropbox", "Drive"};

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_files, container, false);
        // Add the connected and unconnected services programmatically
        LinearLayout line = (LinearLayout) v.findViewById(R.id.filesLinLayout);
        fillLineLayout(inflater, line);

        v.findViewById(R.id.savedFilesCatTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOptionClicked(view, inflater.getContext());
            }
        });
        return v;
    }

    private void fillLineLayout(final LayoutInflater inflater, LinearLayout mainLine) {
        // fill connected services
        int pos = mainLine.indexOfChild(mainLine.findViewById(R.id.connservsLabel));
        for (String s : activeServs) {
            final TextView tv = (TextView) inflater.inflate(R.layout.activeservitem, null);
            tv.setText(s);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onOptionClicked(tv, inflater.getContext());
                }
            });
            mainLine.addView(tv, pos + 1);
        }
        // fill inactive services
        pos = mainLine.indexOfChild(mainLine.findViewById(R.id.inactservLabel));
        for (String s : inactiveServs) {
            final LinearLayout inact = (LinearLayout) inflater.inflate(R.layout.inactiveservitem, null);
            ((TextView) inact.findViewById(R.id.servTV)).setText(s);
            inact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onOptionClicked(inact, inflater.getContext());
                }
            });
            mainLine.addView(inact, pos + 1);
        }
    }

    public void onOptionClicked(View v, Context c) {
        Intent intent = new Intent(c, PrintActivity.class);
        startActivity(intent);
    }
}