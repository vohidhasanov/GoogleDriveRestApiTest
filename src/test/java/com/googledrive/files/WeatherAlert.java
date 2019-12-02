package com.googledrive.files;

import java.util.ArrayList;

public class WeatherAlert {
    Time_period Time_periodObject;
    ArrayList < Object > conditions = new ArrayList < Object > ();
    ArrayList < Object > area = new ArrayList < Object > ();


    // Getter Methods

    public Time_period getTime_period() {
        return Time_periodObject;
    }

    // Setter Methods

    public void setTime_period(Time_period time_periodObject) {
        this.Time_periodObject = time_periodObject;
    }
}



