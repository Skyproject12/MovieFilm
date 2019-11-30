package com.example.moviefilm.Util;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.VisibleForTesting;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {
    private static final int THRED_COUNT=3;
    private final Executor diskIo;
    private final Executor networkIO;
    private final Executor mainThread;

    @VisibleForTesting
    public AppExecutors(Executor diskIo, Executor networkIO, Executor mainThread) {
        this.diskIo = diskIo;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    public AppExecutors(){
        this(new DiskIOThreadExecutor(), Executors.newFixedThreadPool(THRED_COUNT), new MainThreadExecutor());
    }

    public Executor diskIO(){
        return diskIo;
    }
    public Executor networkIO(){
        return networkIO;
    }
    public Executor mainThread(){
        return mainThread;
    }
    private static class MainThreadExecutor implements Executor{
        private final Handler mainThreadHandler= new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
