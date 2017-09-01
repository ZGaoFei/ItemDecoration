package com.example.zgfei.itemdecorationapp.zero;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.zgfei.itemdecorationapp.R;
import com.example.zgfei.itemdecorationapp.one.OneResponse;

import java.util.List;

class ZeroAdapter extends RecyclerView.Adapter<ZeroAdapter.ViewHolder> {
    private Context context;
    private List<OneResponse> list;
    private OnClickListener onClickListener;

    ZeroAdapter(Context context, List<OneResponse> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zero, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.imageView);
        holder.editText.setText("====" + position);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
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

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private EditText editText;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.iv_zero);
            editText = (EditText) itemView.findViewById(R.id.et_zero);
        }
    }

    interface OnClickListener {
        void onClick(View view, int position);
    }

    void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
