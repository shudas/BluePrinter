package com.shudas.blueprinter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Shu on 5/10/2014.
 */
public class PrinterInfo implements Parcelable{
    public String name;
    // one of 3 strings: GOOD, BAD, MAYBE
    public String state;

    PrinterInfo(String _name, String _state) {
        name = _name;
        state = _state;
    }

    PrinterInfo(Parcel parcel) {
        name = parcel.readString();
        state = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(state);
    }

    public static final Creator<PrinterInfo> CREATOR = new Creator<PrinterInfo>(){

        @Override
        public PrinterInfo createFromParcel(Parcel parcel) {
            return new PrinterInfo(parcel);
        }

        @Override
        public PrinterInfo[] newArray(int size) { return new PrinterInfo[size]; }
    };

    public static ArrayList<PrinterInfo> genPrinters(int numToGen) {
        if (numToGen < 0) {
            return null;
        }
        ArrayList<PrinterInfo> ret = new ArrayList<PrinterInfo>(numToGen);
        String pname = "TEST_PRINTER_";
        Random r = new Random();
        for (int i = 0; i < numToGen; ++i) {
            String name = pname + Integer.toString(i);
            // gen so that 1/8 prob bad, 2/8 prob maybe 5/8 prob good
            int good = r.nextInt(8);
            String state = "GOOD";
            if (good == 0) { state = "BAD"; }
            else if (good <= 2) { state = "MAYBE"; }
            ret.add(new PrinterInfo(name, state));
        }
        return ret;
    }

}

