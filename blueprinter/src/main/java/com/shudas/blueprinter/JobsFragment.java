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

    ArrayList<JobTabInfo> jobs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jobs = JobTabInfo.genRandomJobs(100);
        // Retain this fragment across configuration changes.
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        JobsArrayAdapter adapter = new JobsArrayAdapter(inflater.getContext(), jobs);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}