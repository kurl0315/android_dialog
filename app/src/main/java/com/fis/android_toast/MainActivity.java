package com.fis.android_toast;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] arr = {"鸡","猪","狗","猴"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        初始化点击事件
        initEvent();
    }

    private void initEvent() {
        findViewById(R.id.dialog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                显示确认对话框
                shouDialog();

            }
        });
//        单选按钮
        findViewById(R.id.dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                显示确认对话框
                shouDialogSec();

            }
        });
    }

    private void shouDialogSec() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        定义主题
        builder.setTitle("单选对话框");
//        定义图标
        builder.setIcon(R.mipmap.ic_launcher);
//        定义内容
       builder.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               String str = arr[i];
               Toast.makeText(MainActivity.this, "这个动物是"+str, Toast.LENGTH_SHORT).show();
           }
       });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void shouDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        定义主题
        builder.setTitle("确认对话框");
//        定义图标
        builder.setIcon(R.mipmap.ic_launcher);
//        定义内容
        builder.setMessage("确认对话框内容");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
