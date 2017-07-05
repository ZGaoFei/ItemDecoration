package com.example.zgfei.itemdecorationapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zgfei.itemdecorationapp.one.OneActivity;
import com.example.zgfei.itemdecorationapp.two.TwoActivity;
import com.example.zgfei.itemdecorationapp.zero.ZeroActivity;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        initView();
    }

    private void initView() {
        Button btZero = (Button) findViewById(R.id.bt_skip_decoration_zero);
        btZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZeroActivity.start(mContext);
            }
        });

        Button btOne = (Button) findViewById(R.id.bt_skip_decoration_one);
        btOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OneActivity.start(mContext);
            }
        });

        Button btTwo = (Button) findViewById(R.id.bt_skip_decoration_two);
        btTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwoActivity.start(mContext);
            }
        });
    }

}
