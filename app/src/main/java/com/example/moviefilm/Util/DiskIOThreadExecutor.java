package com.example.moviefilm.Util;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiskIOThreadExecutor implements Executor {
    private final Executor mDiskIO;
    DiskIOThreadExecutor(){
        mDiskIO= Executors.newSingleThreadExecutor();

    }
    @Override
    public void execute(@NonNull Runnable command){
        mDiskIO.execute(command);

    }
}