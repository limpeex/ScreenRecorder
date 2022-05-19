package me.limpeex.projects.project1;

import java.util.HashMap;

public abstract class ScreenRecorder {
    private int degree;
    private static HashMap<String, Integer> settings = new HashMap<>();
    public abstract void startRecord();
    public abstract void stopRecord();
    public abstract void startStream();
    public abstract void stopStream() throws InterruptedException;
    public abstract void getSettings() throws InterruptedException;
}
