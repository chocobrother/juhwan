package com.example.juhwan.axivity;

/**
 * Created by Juhwan on 2017-07-17.
 */

public class Data {
    private String blue_time;
    private String state;

    public Data(String blue_time, String state) {
        this.blue_time = blue_time;
        this.state = state;
    }

    public String getBlue_time() {
        return blue_time;
    }

    public void setBlue_time(String blue_time) {
        this.blue_time = blue_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
