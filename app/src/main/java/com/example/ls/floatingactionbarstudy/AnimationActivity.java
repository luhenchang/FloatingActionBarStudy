package com.example.ls.floatingactionbarstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationActivity extends AppCompatActivity {

    @BindView(R.id.animal_button)
    ImageButton animalButton;
    boolean flag = true;
    ScrollView mScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) animalButton.getLayoutParams();
        int height = params.bottomMargin + animalButton.getHeight();

        animalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    animalButton.animate().translationY(100).setInterpolator(new AccelerateInterpolator(3));
                    flag=false;
                } else {
                    animalButton.animate().translationY(0);
                    flag=true;
                }

            }
        });

    }
}
