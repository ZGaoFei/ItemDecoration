package com.example.zgfei.itemdecorationapp.one;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 九宫格形式的布局显示
 *
 * 要求：
 * 在每个布局的前面和后面添加间距，
 * 间距保持一致
 */
public class OneDecoration extends RecyclerView.ItemDecoration {
    private int itemCount;
    private int spacing;

    private Paint paint;

    public OneDecoration(int itemCount, int spacing) {
        this.itemCount = itemCount;
        this.spacing = spacing;

        paint = new Paint();
        paint.setColor(0x99FF0000);
    }

    /**
     * 先于 ItemView 的 onDraw() 的调用
     * 因此在这个里面绘制的内容如果在 ItemView 的边界内，会被隐藏
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        //会显示在 ItemView 的下面
//        drawCircle(c);

//        drawRect(c, parent);
    }

    /**
     * 后于 ItemView 的 onDraw() 的调用
     * 因此在这个里面绘制的内容如果在 ItemView 的边界内，会显示在上方
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        //会显示在 ItemView 的上面
//        drawCircle(c);

        drawRect(c, parent);
//        drawRedItem(c, parent);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

//        outRect.set(10, 10, 10, 10);
//        outRect.set(0, 0, 0, 50);

//        addItem(outRect, view, parent);
        addItemOne(outRect, view, parent);
//        addItemTwo(outRect, view, parent);
//        addItemThree(outRect, view, parent);
    }

    /**
     * 画圆
     *
     * @param c
     */
    private void drawCircle(Canvas c) {
        c.drawCircle(40, 40, 30, paint);
    }

    /**
     * 画矩形
     *
     * @param c
     * @param parent
     */
    private void drawRect(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin +
                    Math.round(ViewCompat.getTranslationY(child));
            final int bottom = top + 50;
            c.drawRect(left, top, right, bottom, paint);
        }
    }

    /**
     * 在第一个ItemView的insetTop区域再绘制一个分割线
     *
     * @param c
     * @param parent
     */
    private void drawRedItem(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top1 = child.getTop() - params.bottomMargin -
                    Math.round(ViewCompat.getTranslationY(child)) - 50;
            final int bottom1 = top1 + 50;
            final int top2 = child.getBottom() + params.bottomMargin +
                    Math.round(ViewCompat.getTranslationY(child));
            final int bottom2 = top2 + 50;
            c.drawRect(left, top2, right, bottom2, paint);
            if (i == 0) {
                c.drawRect(left, top1, right, bottom1, paint);
            }
        }
    }

    /**
     * 在第一个的上面也加上一个间距
     * 适用于单列情况下的列表显示
     *
     * @param outRect
     * @param view
     * @param parent
     */
    private void addItem(Rect outRect, View view, RecyclerView parent) {
        int itemPosition = parent.getChildAdapterPosition(view);
        int dataSize = parent.getAdapter().getItemCount();
        if (itemPosition == 0) {
            outRect.set(0, 50, 0, 50);
        } else {
            outRect.set(0, 0, 0, 50);
        }
    }

    /**
     * 列数为 3
     * 在 ItemView 的周围添加一个等宽间距
     *
     * @param outRect
     * @param view
     * @param parent
     */
    private void addItemOne(Rect outRect, View view, RecyclerView parent) {
        int itemPosition = parent.getChildAdapterPosition(view);
        int dataSize = parent.getAdapter().getItemCount();
        if (itemPosition % 3 == 0) {
            outRect.set(10, 10, 10, 0);
        } else if (itemPosition % 3 == 1) {
            outRect.set(0, 10, 10, 0);
        } else {
            outRect.set(0, 10, 10, 0);
        }
    }

    /**
     * 简单封装成可以任意列数和间距
     *
     * @param outRect
     * @param view
     * @param parent
     */
    private void addItemTwo(Rect outRect, View view, RecyclerView parent) {
        int itemPosition = parent.getChildAdapterPosition(view);
        int dataSize = parent.getAdapter().getItemCount();
        if (itemPosition % itemCount == 0) {
            outRect.set(spacing, spacing, spacing, 0);
        } else {
            outRect.set(0, spacing, spacing, 0);
        }
    }

    /**
     * 列数为 3
     * 给最后一行也加上间距
     *
     * 先判断是否是一行中的第一个，然后判断是否是最后一行
     * 以此类推
     *
     * @param outRect
     * @param view
     * @param parent
     */
    private void addItemThree(Rect outRect, View view, RecyclerView parent) {
        int itemPosition = parent.getChildAdapterPosition(view);
        int dataSize = parent.getAdapter().getItemCount();
        if (itemPosition % 3 == 0) {
            if (itemPosition == dataSize - 1 || itemPosition == dataSize - 2 || itemPosition == dataSize - 3) {
                outRect.set(10, 10, 10, 10);
            } else {
                outRect.set(10, 10, 10, 0);
            }
        } else if (itemPosition % 3 == 1) {
            if (itemPosition == dataSize - 1 || itemPosition == dataSize - 2 || itemPosition == dataSize - 3) {
                outRect.set(0, 10, 10, 10);
            } else {
                outRect.set(0, 10, 10, 0);
            }
        } else {
            if (itemPosition == dataSize - 1 || itemPosition == dataSize - 2 || itemPosition == dataSize - 3) {
                outRect.set(0, 10, 10, 10);
            } else {
                outRect.set(0, 10, 10, 0);
            }
        }
    }

}
