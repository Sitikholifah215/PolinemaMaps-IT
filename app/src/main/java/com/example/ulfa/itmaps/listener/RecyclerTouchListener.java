package com.example.ulfa.itmaps.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
    private GestureDetector mGesdetector;
    private ClickListener mClickListn;
    Context contexx;

    public RecyclerTouchListener(Context contexx, final RecyclerView recyview, final ClickListener click) {
        this.contexx = contexx;
        this.mClickListn = click;

        mGesdetector = new GestureDetector(contexx,new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View v = recyview.findChildViewUnder(e.getX(),e.getY());
                if (v != null && click != null){
                    click.onLongClick(v,recyview.getChildPosition(v));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(),e.getY());
        if (child != null && mClickListn != null && mGesdetector.onTouchEvent(e)){
            mClickListn.onClick(child,rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}