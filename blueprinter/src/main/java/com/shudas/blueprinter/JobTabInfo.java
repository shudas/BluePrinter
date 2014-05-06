package com.shudas.blueprinter;

import java.util.ArrayList;
import java.util.Random;

// Contains information about any previously completed job
public class JobTabInfo {
    public boolean success;
    public String filename;
    public String time;
    public String location;

    public JobTabInfo(boolean _success, String _file, String _time, String _loc) {
        success = _success;
        filename = _file;
        time = _time;
        location = _loc;

    }

    public static ArrayList<JobTabInfo> genRandomJobs(int numToGen) {
        if (numToGen < 0) {
            return null;
        }
        ArrayList<JobTabInfo> ret = new ArrayList<JobTabInfo>(numToGen);
        String fname = "TEST_FILE_NAME";
        String tname = "Submitted ";
        String loc = "Location_";
        Random r = new Random();
        for (int i = 0; i < numToGen; ++i) {
            boolean suc = r.nextBoolean();
            String file = fname + Integer.toString(r.nextInt());
            // gen time between 2001 to 2014
            String time = tname + Integer.toString(r.nextInt(12) + 1) + "/" +
                    Integer.toString(r.nextInt(12) + 1) + "/" + Integer.toString(r.nextInt(14) + 2000)
                    + " " + Integer.toString(r.nextInt(12) + 1) + ":" + Integer.toString(r.nextInt(60)) + " AM";
            String location = loc + Integer.toString(r.nextInt());
            ret.add(new JobTabInfo(suc, file, time, location));
            ret.add(new JobTabInfo(false, fname, tname, loc));
        }
        return ret;
    }
}
