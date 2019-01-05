package com.example.tanchukuang;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Dialog dialog;
    private Boolean aBoolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_an).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        final Button s = (Button)findViewById(R.id.btn_dian);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!aBoolean){
                    aBoolean = true;
                    s.setActivated(aBoolean);
                }else {
                    aBoolean = false;
                    s.setActivated(aBoolean);
                }
            }
        });
    }

    //弹出框
    public void show(){
        dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
            //填充对话框的布局
            View inflate = LayoutInflater.from(this).inflate(R.layout.activity_tanchu, null);
            //初始化控件
            inflate.findViewById(R.id.btn_an1).setOnClickListener(this);
            //将布局设置给Dialog
            dialog.setContentView(inflate);
            //获取当前Activity所在的窗体
            Window dialogWindow = dialog.getWindow();
            if (dialogWindow == null){
                return;
            }
            //设置Dialog从窗体底部弹出
            dialogWindow.setGravity( Gravity.BOTTOM);
            //获得窗体的属性
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        lp.y = 20;//设置Dialog距离底部的距离
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//       将属性设置给窗体
            dialogWindow.setAttributes(lp);
            dialog.show();//显示对话框
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_an1:
                dialog.dismiss();
                break;
        }
    }
}
