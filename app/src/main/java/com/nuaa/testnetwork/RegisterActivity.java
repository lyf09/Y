package com.nuaa.testnetwork;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nuaa.util.NetworkUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/2.
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText id;
    private EditText pwd;
    private EditText email;
    private Button submit;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       id = (EditText)findViewById(R.id.id);
        pwd = (EditText)findViewById(R.id.pwd);
        email = (EditText)findViewById(R.id.email);
        submit = (Button)findViewById(R.id.registeBtn);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                id.setText("");
                pwd.setText("");
                email.setText("");
                Toast.makeText(RegisterActivity.this, "数据插入成功", Toast.LENGTH_SHORT).show();
            }
        };

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(){
                    @Override
                    public void run() {

                        Map<String, String> map = new HashMap<>();
                        map.put("id", id.getText().toString());
                        map.put("pwd", pwd.getText().toString());
                        map.put("email", email.getText().toString());
                        try {
                            String str = NetworkUtils.postDataByURL(NetworkUtils.INSERT_STU_URL, map);
                            System.out.println(str + "---------");
                            handler.sendEmptyMessage(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
            }
        });
    }
}
