package com.example.ls.floatingactionbarstudy;

import android.support.v7.widget.RecyclerView;

/**
 * Created by 路很长~ on 2018/3/16.
 */

public class FabScrollListenner extends RecyclerView.OnScrollListener {
    private static final int THRESHOLE = 20;
    private int distance = 0;//滑动超过一定的距离那么就执行
    private HideScrollListenner hideScrollListenner;
    private boolean visible=true;//是否可见
    public FabScrollListenner(HideScrollListenner hideScrollListenner) {
        this.hideScrollListenner = hideScrollListenner;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        /*
        * dy:Y轴方向的增量
        * 有正负之分的。
        * 当真正执行动画的时候就不要执行其他动画了
        * */
        if (distance > THRESHOLE&&visible) {
            visible=false;
            //执行隐藏动画
            hideScrollListenner.onHide();
            distance = 0;
        } else if(distance<-20&&!visible){
            visible=true;
            //执行显示动画
            hideScrollListenner.onShow();

            distance = 0;
        }
        if(visible&&dy>0||(!visible&&dy<0)) {
            distance += dy;
        }
    }
}
