package com.example.zgfei.itemdecorationapp.two;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zgfei.itemdecorationapp.R;

import java.util.ArrayList;
import java.util.List;

public class TwoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TwoAdapter twoAdapter;
    private List<String> list;

    public static void start(Context context) {
        Intent intent = new Intent(context, TwoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        initData();
        initView();

        // test decoration
//        testOne();
        testTwo();
//        testThree();

        // test animator
        testItemAnimator();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item:" + i);
        }

        twoAdapter = new TwoAdapter(this, list);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_two);

        twoAdapter.setOnClickListener(new TwoAdapter.OnClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(TwoActivity.this, "position:" + position + "==list:" + list.get(position), Toast.LENGTH_SHORT).show();

            }
        });

        FloatingActionButton actionButtonAdd = (FloatingActionButton) findViewById(R.id.fab_two_add);
        actionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoAdapter.addData(2);
            }
        });
        FloatingActionButton actionButtonRemove = (FloatingActionButton) findViewById(R.id.fab_two_remove);
        actionButtonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoAdapter.removeData(2);
            }
        });

    }

    /**
     * 测试通过改变主题颜色改变间距的颜色变化
     *
     * 测试 LinearLayoutManager
     */
    private void testOne() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(twoAdapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayout.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    /**
     * 测试 GridLayoutManager
     */
    private void testTwo() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(twoAdapter);

        TwoGridDecoration decoration = new TwoGridDecoration(this);
        recyclerView.addItemDecoration(decoration);
    }

    /**
     * 测试 StaggeredGridLayoutManager
     */
    private void testThree() {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(twoAdapter);

        TwoGridDecoration decoration = new TwoGridDecoration(this);
        recyclerView.addItemDecoration(decoration);
    }

    private void testItemAnimator() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
