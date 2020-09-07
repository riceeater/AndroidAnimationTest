package com.xylitolz.androidanimationtest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc 属性动画演示
 * @date 2018-04-12 11:19
 */

public class PropertyAnimatorActivity extends AppCompatActivity {

    private RadioGroup rgAnimatorType;//RadioGroup
    private ImageView ivContainer;//动画执行的目标对象

    private ValueAnimator alphaValueAnimator;//ValueAnimator实现渐隐渐现
    private ValueAnimator translateValueAnimator;//ValueAnimator实现平移
    private ValueAnimator rotateValueAnimator;//ValueAnimator实现旋转
    private ValueAnimator scaleValueAnimator;//ValueAnimator实现缩放
    private AnimatorSet animatorValueSet;//ValueAnimator实现动画组合

    private ObjectAnimator alphaObjectAnimator;//ObjectAnimator实现渐隐渐现
    private ObjectAnimator translateObjectAnimator;//ObjectAnimator实现平移
    private ObjectAnimator rotateObjectAnimator;//ObjectAnimator实现旋转
    private ObjectAnimator scaleObjectAnimator;//ObjectAnimator实现缩放
    private AnimatorSet animatorObjectSet;//ObjectAnimator实现动画组合

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animator);
        rgAnimatorType = findViewById(R.id.rg_animator_type);
        ivContainer = findViewById(R.id.iv_container);
        initAnimator();
    }

    /**
     * 初始化动画
     */
    private void initAnimator() {
        alphaValueAnimator = ValueAnimator.ofFloat(1.0f,0f);
        alphaValueAnimator.setDuration(1000);
        alphaValueAnimator.setRepeatCount(1);
        alphaValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        alphaValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ivContainer.setAlpha((float)animation.getAnimatedValue());
            }
        });

        translateValueAnimator = ValueAnimator.ofFloat(0,200);
        translateValueAnimator.setDuration(1000);
        translateValueAnimator.setRepeatCount(1);
        translateValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        translateValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ivContainer.setTranslationX((float)animation.getAnimatedValue());
            }
        });

        rotateValueAnimator = ValueAnimator.ofFloat(0f,180f);
        rotateValueAnimator.setDuration(1000);
        rotateValueAnimator.setRepeatCount(1);
        rotateValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        rotateValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ivContainer.setRotation((float)animation.getAnimatedValue());
            }
        });

        scaleValueAnimator = ValueAnimator.ofFloat(1f,0.5f);
        scaleValueAnimator.setDuration(1000);
        scaleValueAnimator.setRepeatCount(1);
        scaleValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        scaleValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ivContainer.setScaleX((float)animation.getAnimatedValue());
            }
        });

        animatorValueSet = new AnimatorSet();
        animatorValueSet.play(alphaValueAnimator)
                .with(rotateValueAnimator)
                .before(scaleValueAnimator)
                .after(translateValueAnimator);

        alphaObjectAnimator = ObjectAnimator.ofFloat(ivContainer,"alpha",1f,0);
        alphaObjectAnimator.setRepeatCount(1);
        alphaObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        alphaObjectAnimator.setDuration(1000);

        translateObjectAnimator = ObjectAnimator.ofFloat(ivContainer,"translationY",0,-200);
        translateObjectAnimator.setRepeatCount(1);
        translateObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        translateObjectAnimator.setDuration(1000);

        rotateObjectAnimator = ObjectAnimator.ofFloat(ivContainer,"rotation",0,-180);
        rotateObjectAnimator.setRepeatCount(1);
        rotateObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        rotateObjectAnimator.setDuration(1000);

        scaleObjectAnimator = ObjectAnimator.ofFloat(ivContainer,"scaleY",1f,1.5f);
        scaleObjectAnimator.setRepeatCount(1);
        scaleObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        scaleObjectAnimator.setDuration(1000);

        animatorObjectSet = new AnimatorSet();
        animatorObjectSet.play(alphaObjectAnimator).with(rotateObjectAnimator).before(scaleObjectAnimator).after(translateObjectAnimator).after(100);

        animatorObjectSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //动画开始时调用
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //动画结束时调用
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                //动画取消时调用
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                //动画重复执行时调用
            }
        });
        animatorObjectSet.addListener(new AnimatorListenerAdapter() {

        });
    }

    /**
     * ValueAnimator实现动画
     */
    public void valueAnimatorTest (View view) {
        switch (rgAnimatorType.getCheckedRadioButtonId()) {
            case R.id.rb_type_alpha:
                //alpha透明度动画
                alphaValueAnimator.start();
                break;
            case R.id.rb_type_translate:
                //translate位移动画
                translateValueAnimator.start();
                break;
            case R.id.rb_type_rotate:
                //rotate旋转动画
                rotateValueAnimator.start();
                break;
            case R.id.rb_type_scale:
                //scale缩放动画
                scaleValueAnimator.start();
                break;
            case R.id.rb_type_set:
                //set动画集合
                animatorValueSet.start();
                break;
        }
    }

    /**
     * ObjectAnimator实现动画
     */
    public void objectAnimatorTest (View view) {
        switch (rgAnimatorType.getCheckedRadioButtonId()) {
            case R.id.rb_type_alpha:
                //alpha透明度动画
                alphaObjectAnimator.start();
                break;
            case R.id.rb_type_translate:
                //translate位移动画
                translateObjectAnimator.start();
                break;
            case R.id.rb_type_rotate:
                //rotate旋转动画
                rotateObjectAnimator.start();
                break;
            case R.id.rb_type_scale:
                //scale缩放动画
                scaleObjectAnimator.start();
                break;
            case R.id.rb_type_set:
                //set动画集合
                animatorObjectSet.start();
                break;
        }
    }
    /**
     * xml实现动画
     */
    public void xmlAnimatorTest (View view) {
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.animator_test);
        animator.setTarget(ivContainer);
        animator.start();
    }


    public static void start(Context context) {
        Intent intent = new Intent(context,PropertyAnimatorActivity.class);
        context.startActivity(intent);
    }
}
