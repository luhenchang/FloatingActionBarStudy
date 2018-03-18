package com.example.ls.floatingactionbarstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.recylerView)
    ListView recylerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    ImageButton fab;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        initData();
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ListViewActivity.this,
                android.R.layout.simple_list_item_1, itemList);//适配器
        recylerView.setAdapter(myAdapter);
        //listView找死宝宝了就是没找到一个方法能获取dy的是吧。算了这个我放弃了
        recylerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.e("scrollX",scrollX+"");
                Log.e("scrollY",scrollY+"");
                Log.e("oldScrollX",oldScrollX+"");
                Log.e("oldScrollY",oldScrollY+"");

            }
        });



    }
    public void initData() {
        itemList = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            itemList.add("测试数据" + i);
        }
    }

}
