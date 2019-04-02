package com.example.ui;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DialogDemo extends AppCompatActivity {

    private Button button, button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);
        //动态加载布局生成View对象
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View longinDialogView = layoutInflater.inflate(R.layout.activity_dialog_demo, null);

        //获取布局中的控件
        EditText mUserName = (EditText) longinDialogView.findViewById(R.id.edit_username);
        EditText mPassword = (EditText) longinDialogView.findViewById(R.id.edit_password);
        //创建一个AlertDialog对话框
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.drawable.header)
                .setView(longinDialogView)                //加载自定义的对话框式样
                .setPositiveButton("Sign in", null)
                .setNeutralButton("Cancle", null)
                .create();
        dialog.show();
    }
}
