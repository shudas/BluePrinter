package com.shudas.blueprinter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Array adapter for Jobs tab
 */
public class JobsArrayAdapter  extends ArrayAdapter<JobTabInfo> {

    Context context;
    ArrayList<JobTabInfo> jobs;

    JobsArrayAdapter(Context c, ArrayList<JobTabInfo> _jobs) {
        super(c, R.layout.jobinfo_row, _jobs);
        jobs = _jobs;
        context = c;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        JobHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.jobinfo_row, parent, false);

            holder = new JobHolder();
            holder.success = (TextView)row.findViewById(R.id.jobinfoSuc);
            holder.filename = (TextView)row.findViewById(R.id.jobinfoFile);
            holder.time = (TextView)row.findViewById(R.id.jobinfoSubmit);
            holder.location = (TextView)row.findViewById(R.id.jobinfoLoc);

            row.setTag(holder);
        }
        else
        {
            holder = (JobHolder)row.getTag();
        }

        JobTabInfo job = jobs.get(position);
//        holder.success.setText(job.title);
        holder.filename.setText(job.filename);
        holder.location.setText(job.location);
        holder.time.setText(job.time);
        if (job.success) {
            holder.success.setBackgroundResource(R.color.success);
        }
        else {
            holder.success.setBackgroundResource(R.color.fail);
        }
        return row;
    }

    static class JobHolder {
        TextView success, filename, time, location;
    }
}
