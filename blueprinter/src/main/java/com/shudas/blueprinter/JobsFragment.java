package com.shudas.blueprinter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class JobsFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_jobs, container, false);
//        ListView lv = (ListView) v.findViewById(R.id.jobsLV);
        ArrayList<JobTabInfo> jobs = JobTabInfo.genRandomJobs(15);
        JobsArrayAdapter adapter = new JobsArrayAdapter(inflater.getContext(), jobs);
//        lv.setAdapter(adapter);
        setListAdapter(adapter);
//        return v;
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}