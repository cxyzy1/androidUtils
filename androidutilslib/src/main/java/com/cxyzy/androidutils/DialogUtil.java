package com.cxyzy.androidutils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;

public class DialogUtil {
    public static void showEditDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //设置对话框标题
        builder.setTitle("请输入");
        //设置对话框标题前的图标
//        builder.setIcon(android.R.drawable.stat_notify_more);

        final EditText edit = new EditText(context);

        builder.setView(edit);
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "你输入的是: " + edit.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "你点了取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
