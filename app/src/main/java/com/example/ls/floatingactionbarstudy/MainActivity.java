package com.example.ls.floatingactionbarstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HideScrollListenner {
    private RecyclerView recyclerView;
    private Toolbar mToobar;
    private ImageButton imageButton;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        imageButton = (ImageButton) findViewById(R.id.fab);
        mToobar = (Toolbar) findViewById(R.id.toolbar);
        //这样太臃肿了。我们还是自定义一个类
        recyclerView.addOnScrollListener(new FabScrollListenner(this));
        mData=new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            mData.add("item="+i);
        }
        RecylerViewApdater madapter=new RecylerViewApdater(this,mData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(madapter);
        madapter.notifyDataSetChanged();
        mToobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListViewActivity.class));
            }
        });
        /*recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        */

    }

    @Override
    public void onHide() {

        //赢藏--属性动画
        RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) imageButton.getLayoutParams();
        imageButton.animate().translationY((imageButton.getHeight()+params.bottomMargin)).setInterpolator(new AccelerateInterpolator(3));
        //Toolbar
        RelativeLayout.LayoutParams params1= (RelativeLayout.LayoutParams) mToobar.getLayoutParams();
        mToobar.animate().translationY(-(mToobar.getHeight()+params1.bottomMargin)).setInterpolator(new AccelerateInterpolator(3));
    }

    @Override
    public void onShow() {
        //显示--属性动画
        imageButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
        mToobar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
    }
}
