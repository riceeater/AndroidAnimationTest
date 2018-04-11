package com.xylitolz.androidanimationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;


/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc
 * @date 2018-04-10 16:17
 */

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Tween动画演示
     */
    protected void tweenTest(View view) {
        TweenAnimationActivity.start(this);
    }

    /**
     * Frame动画演示
     */
    protected void frameTest(View view) {
        FrameAnimationActivity.start(this);
    }

}
