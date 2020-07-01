package com.example.jetpack_exper;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class UploadWork extends Worker {
    public UploadWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            Thread.sleep(3*60*1000);
            Log.d(WorkManagerActivity.TAG, "666");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.failure();
    }
}
