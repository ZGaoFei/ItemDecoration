package com.example.zgfei.itemdecorationapp.zero;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ZeroDecoration extends RecyclerView.ItemDecoration{
    private Paint mPaint;

    ZeroDecoration() {
        mPaint = new Paint();
        mPaint.setColor(0x99FF0000);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        drawItem(c, parent);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (position == 0) {
            outRect.set(0, 10, 0, 10);
        } else {
            outRect.set(0, 0, 0, 10);
        }
    }

    private void drawItem(Canvas c, RecyclerView parent) {
        int left;
        int right;
        int top;
        int bottom;
        left = parent.getPaddingLeft();
        right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childAt.getLayoutParams();

            // 计算 itemView 的底部坐标：(left, top)
            top = childAt.getBottom() + params.bottomMargin + Math.round(ViewCompat.getTranslationY(childAt));
            bottom = top + 10;
            c.drawRect(left, top, right, bottom, mPaint);

            if (i == 0) {
                int b = childAt.getTop() - params.bottomMargin - Math.round(ViewCompat.getTranslationY(childAt));
                int t = b - 10;
                c.drawRect(left, t, right, b, mPaint);
            }
        }
    }
}
