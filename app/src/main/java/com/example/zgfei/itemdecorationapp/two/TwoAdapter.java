package com.example.zgfei.itemdecorationapp.two;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zgfei.itemdecorationapp.R;

import java.util.ArrayList;
import java.util.List;

class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.ViewHolder> {
    private Context context;
    private List<String> list;
    private List<Integer> mHeights;
    private OnClickListener onClickListener;

    TwoAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;

        mHeights = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_two, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // 随机高度, 模拟瀑布效果.
       /* if (mHeights.size() <= position) {
            mHeights.add((int) (150 + Math.random() * 200));// 150~150+(0.0~1.0 * 200)
        }
        ViewGroup.LayoutParams lp = holder.textView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.textView.setLayoutParams(lp);*/


        holder.textView.setText(list.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void addData(int position) {
        list.add(position, "new item");
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.tv_two);
        }
    }

    interface OnClickListener {
        void onClick(View view, int position);
    }

    void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
