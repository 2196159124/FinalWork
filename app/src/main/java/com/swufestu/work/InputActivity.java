package com.swufestu.work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    private final String TAG = "InputActivity";

    EditText wordText;
    EditText tipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Intent intent = getIntent();
        String newwords = intent.getStringExtra("newwords_key");
        String newtips = intent.getStringExtra("newtips_key");

        Log.i(TAG, "onCreate: dollar2=" + newwords);
        Log.i(TAG, "onCreate: euro2=" + newtips);

        wordText = (EditText)findViewById(R.id.ipt_word);
        tipText = (EditText)findViewById(R.id.ipt_tip);

        //显示数据到控件
        wordText.setText(String.valueOf(newwords));
        tipText.setText(String.valueOf(newtips));
    }

    public void add(View view) {

        Log.i(TAG, "add: ");
        //获取新的值
        String newWords = wordText.getText().toString();
        String newTips = tipText.getText().toString();


        Log.i(TAG, "add: 添加新单词");
        Log.i(TAG, "add: newWords=" + newWords);
        Log.i(TAG, "add: newTips=" + newTips);


        //保存到Bundle或放入到Extra
        Intent intent = getIntent();
        Bundle bdl = new Bundle();
        bdl.putString("key_dollar",newWords);
        bdl.putString("key_euro",newTips);

        intent.putExtras(bdl);
        setResult(2,intent);


        //返回到调用页面
        finish();
    }
}