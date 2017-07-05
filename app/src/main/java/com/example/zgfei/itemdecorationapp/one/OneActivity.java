package com.example.zgfei.itemdecorationapp.one;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.zgfei.itemdecorationapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleView 添加 ItemDecoration
 *
 * 使用 GridLayoutManager 实现九宫格布局
 * 要求在九宫格的每个间隔内添加空隙
 * 保持间隔距离一致
 */
public class OneActivity extends AppCompatActivity {
    private static final String IMAG_URL = "https://testphotosd.nggirl.com.cn/work/297fb5fa7a59457c87693e2fec198edb.jpg";

    private RecyclerView recyclerView;
    private OneAdapter oneAdapter;
    private List<OneResponse> list;

    public static void start(Context context) {
        Intent intent = new Intent(context, OneActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        initData();
        initView();
        setDecoration();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            OneResponse response = new OneResponse(IMAG_URL);
            list.add(response);
        }

        oneAdapter = new OneAdapter(this, list);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_one);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(oneAdapter);

        oneAdapter.setOnClickListener(new OneAdapter.OnClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(OneActivity.this, "item:" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setDecoration() {
        OneDecoration decoration = new OneDecoration(1, 10);
        recyclerView.addItemDecoration(decoration);
    }
}
