package com.xylitolz.androidanimationtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc 帧动画演示
 * @date 2018-04-11 11:36
 */

public class FrameAnimationActivity extends AppCompatActivity{

    private View animContainer;//显示动画的View
    private AnimationDrawable animationDrawable;//帧动画帮助类

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        init();
    }

    private void init() {
        animContainer = findViewById(R.id.view_anim_container);

        animationDrawable = (AnimationDrawable) animContainer.getBackground();
    }

    /**
     * 开启动画
     */
    protected void startAnim(View view) {
        animationDrawable.start();
    }

    /**
     * 停止动画
     */
    protected void stopAnim(View view) {
        animationDrawable.stop();
    }

    /**
     * 切换动画为java生成
     * @param view
     */
    protected void switchJava(View view) {
        animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_28),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_27),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_26),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_25),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_24),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_23),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_22),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_21),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_20),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_19),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_18),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_17),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_16),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_15),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_14),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_13),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_12),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_11),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_10),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_9),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_8),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_7),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_6),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_5),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_4),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_3),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_2),42);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.anim_frame_1),42);
        animContainer.setBackgroundDrawable(animationDrawable);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context,FrameAnimationActivity.class);
        context.startActivity(intent);
    }
}
