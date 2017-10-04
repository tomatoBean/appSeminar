package com.example.eric.myapplicationdefviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Field;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyScrollImageView myPager; // 图片容器
    private LinearLayout ovalLayout; // 圆点容器
    private List<View> imageContainers; // 图片组

    int[] imageResId = new int[]{R.drawable.touxiang1, R.drawable.touxiang2,
            R.drawable.touxiang3, R.drawable.touxiang4, R.drawable.touxiang5,R.drawable.touxiang6, R.drawable.touxiang7 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPager = (MyScrollImageView) findViewById(R.id.myvp);
        ovalLayout = (LinearLayout) findViewById(R.id.vb);
        ovalLayout.bringToFront();
        InitViewPager();//初始化图片
        //开始滚动
//        myPager.start(this, listViews, 4000, ovalLayout,
//                R.layout.ad_bottom_item, R.id.ad_item_v,
//                R.drawable.dot_focused, R.drawable.dot_normal);
        myPager.start(this, imageContainers, 4000, ovalLayout,
                R.layout.ad_bottom_item, R.id.ad_item_v,
                R.drawable.dot_focused, R.drawable.dot_normal);

    }

    @Override
    protected void onRestart() {
        myPager.startTimer();
        super.onRestart();
    }

    @Override
    protected void onStop() {
        myPager.stopTimer();
        super.onStop();
    }

    /**
     * 初始化图片
     */
    private void InitViewPager() {
        imageContainers = new ArrayList<View>();
        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) { // 设置图片点击事件
                    Toast.makeText(MainActivity.this,
                            "点击了:" + myPager.getCurIndex(), Toast.LENGTH_SHORT)
                            .show();
                }
            });
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageContainers.add(imageView);
        }
    }


}
