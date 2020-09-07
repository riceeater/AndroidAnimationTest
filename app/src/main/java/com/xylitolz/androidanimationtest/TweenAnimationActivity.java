package com.xylitolz.androidanimationtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc
 * @date 2018-04-11 11:31
 */

public class TweenAnimationActivity extends AppCompatActivity {
    private ImageView ivTest;//操作的中心ImageView
    private ImageView ivTest2;//操作的左侧ImageView
    private Animation animation;//需要执行的动画效果

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        ivTest = findViewById(R.id.iv_test);
        ivTest2 = findViewById(R.id.iv_test2);
    }

    /**
     * 使用xml实现渐隐效果
     */
    public void xmlAlpha(View view) {
        animation = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        ivTest.startAnimation(animation);
    }

    /**
     * 使用代码实现渐显效果
     */
    public void javaAlpha(View view) {
        animation = new AlphaAnimation(0.0f,1.0f);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setDuration(500);
        animation.setRepeatCount(0);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setFillAfter(true);
        ivTest.startAnimation(animation);
    }

    /**
     * 使用xml实现逆时针旋转
     */
    public void xmlRotate(View view) {
        animation = AnimationUtils.loadAnimation(this,R.anim.anim_rotate);
        ivTest.startAnimation(animation);
    }
    /**
     * 使用xml实现顺时针旋转
     */
    public void javaRotate(View view) {
        animation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setDuration(500);
        animation.setRepeatCount(2);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setFillAfter(true);
        ivTest.startAnimation(animation);
    }

    /**
     * xml实现向右下平移
     */
    public void xmlTranslate(View view) {
        animation = AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        ivTest.startAnimation(animation);
    }
    public void javaTranslate(View view) {
        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1.0f,
                Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-0.5f);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setDuration(500);
        animation.setRepeatCount(1);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setFillAfter(true);
        ivTest.startAnimation(animation);
    }

    /**
     * xml拉伸效果
     */
    public void xmlScale(View view) {
        animation = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        ivTest.startAnimation(animation);
    }

    /**
     * java拉伸效果
     */
    public void javaScale(View view) {
        animation = new ScaleAnimation(1.0f,2.0f,1.0f,2.0f,
                Animation.RELATIVE_TO_SELF,1,Animation.RELATIVE_TO_SELF,1);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setDuration(500);
        animation.setRepeatCount(1);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setFillAfter(true);
        ivTest.startAnimation(animation);
    }

    /**
     * xml AnimationSet
     */
    public void xmlSet(View view) {
        animation = AnimationUtils.loadAnimation(this,R.anim.anim_set);
        ivTest2.startAnimation(animation);
    }

    /**
     * java拉伸效果
     */
    public void javaSet(View view) {
        //显示动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(500);
        alphaAnimation.setRepeatCount(0);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setFillAfter(true);

        //旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        rotateAnimation.setFillAfter(true);

        //平移动画
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1.0f,
                Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-0.5f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(500);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setFillAfter(true);

        //拉伸动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,2.0f,1.0f,2.0f,
                Animation.RELATIVE_TO_SELF,1,Animation.RELATIVE_TO_SELF,1);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation.setDuration(500);
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setFillAfter(true);

        //AnimationSet
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);

        ivTest2.startAnimation(animationSet);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context,TweenAnimationActivity.class);
        context.startActivity(intent);
    }
}
