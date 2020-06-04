package com.example.jetpack_exper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;

import com.example.jetpack_exper.numgame.MainActivity;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * workManager可以轻松地调度即使应用退出或者设备重启时仍应运行的可延迟（不需要立即运行）异步任务
 * 可以增加约束条件：比如，低电量或者没有网的时候不执行。。。
 * 例如：箱后端发送日志或分析数据
 * 定时将应用数据和服务器同步
 *
 * 内存抖动--频繁的创建和销毁对象
 *  例如：android 官方不建议在View的OnDraw方法中创建对象
 */
public class WorkManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workmanager);
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(UploadWork.class);
        builder.setConstraints(Constraints.NONE);
        OneTimeWorkRequest request = builder.build();
        ListenableFuture<Operation.State.SUCCESS> result = WorkManager.getInstance(this).enqueue(request).getResult();
        try {
            Operation.State.SUCCESS success = result.get();
//            System.out.println("666"+success.toString());
            System.out.println(66);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initView();
    }

    private void initView() {
       findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(WorkManagerActivity.this, MainActivity.class);
               startActivity(intent);
           }
       });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy***");
    }
}
