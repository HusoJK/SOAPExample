package com.java.soapexample.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AsyncTasks {
    private final ExecutorService executors;

    protected AsyncTasks() {
        this.executors = Executors.newSingleThreadExecutor();
    }

    private void startBackground() {
        onPreExecute();
        executors.execute(() -> {
            doInBackground();
            new Handler(Looper.getMainLooper()).post(this::onPostExecute);
        });
    }

    public void execute() {
        startBackground();
    }

    protected void shutdown() {
        executors.shutdown();
    }

    protected boolean isShutdown() {
        return executors.isShutdown();
    }

    public abstract void onPreExecute();

    public abstract void doInBackground();

    public abstract void onPostExecute();
}