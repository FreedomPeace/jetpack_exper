package com.example.jetpack_exper;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * workManager可以轻松地调度即使应用退出或者设备重启时仍应运行的可延迟（不需要立即运行）异步任务
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

    }
}
