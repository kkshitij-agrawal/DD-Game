package com.example.kshitij.dd;

import android.app.Application;

public class GlobalClass extends Application {

    private int counter;
    private int position=-1;
    private int compass_use = 0;

    public int getCompass_use() {
        return compass_use;
    }

    public void setCompass_use(int compass_use) {
        this.compass_use = compass_use;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private int flag = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
