package com.example.zgfei.itemdecorationapp.zero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zgfei.itemdecorationapp.R;
import com.example.zgfei.itemdecorationapp.one.OneResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleView 添加 ItemDecoration
 *
 * 使用系统提供的 DividerItemDecoration
 * 只支持 LinearLayoutManager
 * 可以设置两种形式：
 *  LinearLayout.VERTICAL
 *  LinearLayout.HORIZONTAL
 *  或者：layoutManager.getOrientation()
 *  仅仅添加边界线
 */
public class ZeroActivity extends AppCompatActivity {
    private static final String IMAG_URL = "https://testphotosd.nggirl.com.cn/work/297fb5fa7a59457c87693e2fec198edb.jpg";

    private RecyclerView recyclerView;
    private ZeroAdapter zeroAdapter;
    private List<OneResponse> list;

    public static void start(Context context) {
        Intent intent = new Intent(context, ZeroActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

        initData();
        initView();

        // test
        testDividerItemDecoration();
//        testZeroDecoration();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            OneResponse response = new OneResponse(IMAG_URL);
            list.add(response);
        }

        zeroAdapter = new ZeroAdapter(this, list);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_zero);
        zeroAdapter.setOnClickListener(new ZeroAdapter.OnClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(ZeroActivity.this, "item:" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void testDividerItemDecoration() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);// 设置横向的 RecycleView
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(zeroAdapter);

//        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayout.HORIZONTAL);
        recyclerView.addItemDecoration(decoration);
    }

    private void testZeroDecoration() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(zeroAdapter);

        ZeroDecoration decoration = new ZeroDecoration();
        recyclerView.addItemDecoration(decoration);
    }
}
