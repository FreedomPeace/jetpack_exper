package com.example.jetpack_exper;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class UploadLogWork extends ListenableWorker {
    /**
     * @param appContext   The application {@link Context}
     * @param workerParams Parameters to setup the internal state of this worker
     */
    public UploadLogWork(@NonNull Context appContext, @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
    }

    @SuppressLint("RestrictedApi")
    @NonNull
    @Override
    public ListenableFuture<Result> startWork() {
        ExecutorService service = Executors.newSingleThreadExecutor();
//        service.submit(new FutureTask<>());
        ListenableFuture<Result> listenableFuture = (ListenableFuture<Result>) service;
        return listenableFuture;
    }
}
