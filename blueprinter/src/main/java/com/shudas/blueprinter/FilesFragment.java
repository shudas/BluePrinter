package com.shudas.blueprinter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FilesFragment extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_files, container, false);
        v.findViewById(R.id.savedFilesCatTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOptionClicked(view, inflater.getContext());
            }
        });
        return v;
    }

    public void onOptionClicked(View v, Context c) {
        Intent intent = new Intent(c, PrintActivity.class);
        startActivity(intent);
    }
}